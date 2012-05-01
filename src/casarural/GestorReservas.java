package casarural;

import java.util.*;
import java.sql.SQLException;
import java.io.*;
import java.rmi.*;

public final class GestorReservas {

	protected static int numReserva = 0;
	GestorBD gbd;
	private static String ficheroNumReserva = "numeroReserva.txt";

	private static GestorReservas elGestorReservas = new GestorReservas();

	private GestorReservas() {
		gbd = GestorBD.getInstance();
		GestorReservas.inicializar();
	}

	/**
	 * Devuelve una instancia del gestor de reservas
	 * 
	 * @param Ninguno
	 * @return El gestor de reservas
	 */
	public static GestorReservas getInstance() {
		return elGestorReservas;
	}

	/**
	 * Inicializa las reservas con el numero de reserva
	 * 
	 * @param Ninguno
	 * @return Ninguno
	 */
	protected static void inicializar() {
		try {
			GestorReservas.numReserva = GestorReservas.cargarNumReserva();
		} catch (Exception e) {
			System.out.println("Error cargando el n�mero de reserva: "
					+ e.toString());
		}
	}

	/**
	 * Accede al fichero que contiene el numero de reserva
	 * 
	 * @param Ninguno
	 * @return El numero de reserva
	 */
	protected static int cargarNumReserva() throws FileNotFoundException,
			IOException {
		BufferedReader entrada = new BufferedReader(new FileReader(
				ficheroNumReserva));
		int numero = Integer.parseInt(entrada.readLine());
		entrada.close();
		return numero;
	}

	/**
	 * Guarda en el fichero el numero de reserva actual
	 * 
	 * @param Ninguno
	 * @return Ninguno
	 */
	protected static void salvarNumReserva() throws FileNotFoundException,
			IOException {
		PrintWriter numero = new PrintWriter(new FileWriter(ficheroNumReserva));
		Integer num = new Integer(GestorReservas.numReserva);
		numero.print(num.toString());
		numero.close();
	}

	// crea el siguiente numero para el siguiente reserva
	private int crearNumReserva() {
		GestorReservas.numReserva = GestorReservas.numReserva + 1;
		return GestorReservas.numReserva;
	}

	/**
	 * Indica que el objeto se puede descargar de la memoria
	 * 
	 * @param Ninguno
	 * @return Ninguno
	 */
	protected void finalize() {
		try {
			GestorReservas.salvarNumReserva();
		} catch (Exception e) {
			;
		}
	}

	/**
	 * Hace la reserva en los dias que se le facilitan
	 * 
	 * @param Dia
	 *            de Inicio, Dia de Fin, numero de casa y telefono
	 * @return Una reserva
	 */
	public Reserva reservar(java.sql.Date diaIni, java.sql.Date diaFin,
			int numCasa, String numTfnoReserva)
			throws NoSePuedeReservarException {

		// preguntar el vector de las ofertas dentro de las fechas
		// (diaIni-diaFin)
		// si no existen catch la exception
		List<Oferta> ofertas = new ArrayList<Oferta>();
		OfertasEnMemoriaPrincipal oferts = new OfertasEnMemoriaPrincipal();
		try {
			ofertas = gbd.seleccionarReservas(diaIni, diaFin, numCasa);
		} catch (NoSePuedeReservarException ex) {
			throw ex;
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		// a�adir todas las ofertas en la memoria principal
		for (Oferta next: ofertas) {
			String numOferta = next.getNumOferta();
			java.sql.Date diaIniOtro = next.getDiaIni();
			java.sql.Date diaFinOtro = next.getDiaFin();
			float precio = next.getPrecio();
			oferts.anadirReserva(diaIniOtro, diaFinOtro, numOferta, precio);
		}

		// preguntar de volver el vector de la reservaCompleta
		// sino existe catch la excepcion
		List<ReservaCompleta> resCompleta = new ArrayList<ReservaCompleta>();
		try {
			resCompleta = oferts.obtenerReservaCompleta(diaIni, diaFin);
		} catch (NoSePuedeReservarException ex) {
			throw ex;
		}

		// c�lculo del precio total
		float precio = 0.0f;
		List<String> reservasTotales = new ArrayList<String>();
		for (ReservaCompleta next: resCompleta) {
			reservasTotales.add(next.getNumOferta());
			precio = precio + next.getPrecio();
		}
		// generacion del numReserva
		this.crearNumReserva();

		Integer otro = new Integer(GestorReservas.numReserva);
		// ejecutar la transaccion
		try {
			gbd.transaccionDeReserva(reservasTotales, otro.toString(),
					numTfnoReserva, precio);
		} catch (Exception e) {
			;
		}

		Reserva res = new Reserva(otro.toString(), numCasa, precio);
		// volver numReserv
		try {
			GestorReservas.salvarNumReserva();
		} catch (Exception e) {
			;
		}
		return res;

	}
	
	/**
	 * Hace la reserva en los dias que se le facilitan
	 * 
	 * @param Dia
	 *            de Inicio, Dia de Fin, numero de casa, telefono,
	 *            número de servicio de recogida y plazas a reservar
	 * @return Una reserva
	 */
	public Reserva reservar(java.sql.Date diaIni, java.sql.Date diaFin,
			int numCasa, String numTfnoReserva, int idServicio, int plazas)
			throws NoSePuedeReservarException {

		// preguntar el vector de las ofertas dentro de las fechas
		// (diaIni-diaFin)
		// si no existen catch la exception
		List<Oferta> ofertas = new ArrayList<Oferta>();
		OfertasEnMemoriaPrincipal oferts = new OfertasEnMemoriaPrincipal();
		try {
			ofertas = gbd.seleccionarReservas(diaIni, diaFin, numCasa);
		} catch (NoSePuedeReservarException ex) {
			throw ex;
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		// a�adir todas las ofertas en la memoria principal
		for (Oferta next: ofertas) {
			String numOferta = next.getNumOferta();
			java.sql.Date diaIniOtro = next.getDiaIni();
			java.sql.Date diaFinOtro = next.getDiaFin();
			float precio = next.getPrecio();
			oferts.anadirReserva(diaIniOtro, diaFinOtro, numOferta, precio);
		}

		// preguntar de volver el vector de la reservaCompleta
		// sino existe catch la excepcion
		List<ReservaCompleta> resCompleta = new ArrayList<ReservaCompleta>();
		try {
			resCompleta = oferts.obtenerReservaCompleta(diaIni, diaFin);
		} catch (NoSePuedeReservarException ex) {
			throw ex;
		}

		// c�lculo del precio total
		float precio = 0.0f;
		List<Oferta> reservasTotales = new ArrayList<Oferta>();
		for (ReservaCompleta next: resCompleta) {
			Oferta o = new Oferta();
			o.setNumOferta(next.getNumOferta());
			reservasTotales.add(o);
			precio = precio + next.getPrecio();
		}
		precio = precio + gbd.precioServicio(idServicio)*plazas;
		
		// generacion del numReserva
		this.crearNumReserva();

		Integer otro = new Integer(GestorReservas.numReserva);
		// ejecutar la transaccion
		try {
			gbd.transaccionDeReserva(reservasTotales, otro,
					numTfnoReserva, precio, idServicio, plazas);
		} catch (Exception e) {
			;
		}

		Reserva res = new Reserva(otro.toString(), numCasa, precio);
		// volver numReserv
		try {
			GestorReservas.salvarNumReserva();
		} catch (Exception e) {
			;
		}
		return res;

	}

	// //NUEVO

	/**
	 * Devuelve un Vector con las Reservas que se corresponden con las fechas
	 * indicadas
	 * 
	 * @param diaIni
	 * @param diaFin
	 * @return Vector con objetos de tipo Reserva
	 */
	public Vector<Reserva> obtReservas(java.sql.Date diaIni,
			java.sql.Date diaFin) {
		Vector<Reserva> reservas = new Vector<Reserva>();
		// obtener las reservas de la BD
		reservas = gbd.seleccionarReservas(diaIni, diaFin);
		return reservas;
	}

	/**
	 * Anula las reservas y reestablece o anula las ofertas seg�n corresponda
	 * 
	 * @param reservas
	 *            , array que contiene las reservas a anular
	 * @return 0 si anulaci�n correcta,1 si anulaci�n err�nea, 2 si hay que
	 *         devolver dinero
	 */
	public int[] anularReservas(String[] reservas) {
		int tam = reservas.length;
		int[] res = new int[tam];
		Vector<Oferta> reserva;
		java.util.Date hoy = new java.util.Date();
		Calendar cal = Calendar.getInstance();

		for (int i = 0; i < tam; i++) {
			try {
				reserva = gbd.seleccionarOfertas(reservas[i]);
				// comprobar si la fecha de reserva es 10 dias antes de la fecha
				// de inicio de la misma
				cal.setTime(reserva.elementAt(0).getDiaIni());
				cal.add(Calendar.DATE, -10);
				if (hoy.compareTo(cal.getTime()) <= 0) {
					res[i] = 2;
					gbd.anularReserva(reservas[i], reserva,
							new Vector<Oferta>());
				}
				// comprobar si la fecha de inicio es menor que la fecha de hoy
				else if (hoy.compareTo(reserva.elementAt(0).getDiaIni()) <= 0) {
					res[i] = 0;
					gbd.anularReserva(reservas[i], reserva,
							new Vector<Oferta>());
				}
				// en el caso de que la fecha de inicio de reserva ya haya
				// pasado
				else {
					res[i] = 0;
					Vector<Oferta> anular = anularOfertas(reserva);
					gbd.anularReserva(reservas[i], reserva, anular);
				}
			} catch (SQLException e) {
				res[i] = 1;
			}
		}
		return res;
	}

	/**
	 * Devuelve en un nuevo Vector de ofertas aquellas ofertas que ya no se
	 * deben encontrar disponibles, y deja en el vector pasado como par�metro
	 * las ofertas que han de restaurarse
	 * 
	 * @param ofertas
	 *            , Vector<Oferta>
	 * @return Vector<Oferta>
	 */
	private Vector<Oferta> anularOfertas(Vector<Oferta> ofertas) {
		Vector<Oferta> anular = new Vector<Oferta>();
		java.util.Date hoy = new java.util.Date();
		for (int i = 0; i < ofertas.size(); i++) {
			if (hoy.compareTo(ofertas.elementAt(i).getDiaIni()) >= 0) {
				anular.add(ofertas.elementAt(i));
				ofertas.remove(i);
				i--;
			}
		}
		return anular;
	}
}