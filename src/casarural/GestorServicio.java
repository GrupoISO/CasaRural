package casarural;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GestorServicio {

	private static GestorServicio gestorServicio;
	private GestorBD gbd;
	private static String ficheroNumReserva = "numeroReserva.txt";
	
	/**Devuelve una instancia de la clase GestorServicio
	 * @param ninguno
	 * @return Una instancia del Gestor de Servicios
	 */
	public static GestorServicio getInstance() {
		if (gestorServicio == null) {
			gestorServicio = new GestorServicio();
		}
		return gestorServicio;
	}
		
	private GestorServicio() {
		gbd = GestorBD.getInstance();
	}
	
	/**Accede al fichero que contiene el numero de reserva
	 * 
	 * @return El numero de reserva actual
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	protected static int cargarNumReserva() throws FileNotFoundException,
	IOException {
		BufferedReader entrada = new BufferedReader(new FileReader(
				ficheroNumReserva));
		int numero = Integer.parseInt(entrada.readLine());
		entrada.close();
		return numero;
	}

	/**Guarda en el fichero el numero de reserva actual
	 * 
	 * @param numactual El numero de reserva actual
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	protected static void salvarNumReserva(int numactual) throws FileNotFoundException,
	IOException {
		PrintWriter numero = new PrintWriter(new FileWriter(ficheroNumReserva));
		Integer num = new Integer(numactual);
		numero.print(num.toString());
		numero.close();
	}

	/**Obtiene una lista compuesta por las recogidas actuales
	 * @param ninguno
	 * @return Una lista de recogidas
	 */
	public List<Recogida> getRecogidas() {
		return gbd.getRecogidas();
	}
	
	/**Crea un Servicio asignandolo a un recorrido
	 * 
	 * @param servicio Toma como entrada la clase Servicio que se va a crear
	 * @return confirmación true/false
	 */
	public boolean crearServicio(Servicio servicio) {
		try {
			return gbd.crearServicio(servicio);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	/**Obtiene una lista de Servicios asignados a una casa rural en la fecha indicada
	 * 
	 * @param numCasa Código de la casa rural de la cual se requieren los servicios
	 * @return listaDeServicios asociados a una casa rural
	 */
	public List<Servicio> mostrarServicios(int numCasa, java.sql.Date fecha){
		try {
			return gbd.obtenerServicios(numCasa, fecha);
		}catch(SQLException ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**Crea una reserva y asigna un servicio a la misma
	 *
	 * @param oferta La oferta que se quiere reservar
	 * @param numTfno Número de telefono de contacto del usuario
	 * @param idServicio Identificador del servicio que se asignara a la reserva
	 * @param numPlazas Numero de plazas que se quiere reservar
	 * @return confirmación true/false
	 */
	public boolean transaccionDeReserva(Oferta oferta, String numTfno, int idServicio, int numPlazas) throws casarural.NoSePuedeReservarException {
		// preguntar el vector de las ofertas dentro de las fechas
				// (diaIni-diaFin)
				// si no existen catch la exception
				List<Oferta> ofertas = new ArrayList<Oferta>();
				OfertasEnMemoriaPrincipal oferts = new OfertasEnMemoriaPrincipal();
				try {
					ofertas = gbd.seleccionarReservas(oferta.getDiaIni(), oferta.getDiaFin(), oferta.getNumCasa());
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
					resCompleta = oferts.obtenerReservaCompleta(oferta.getDiaIni(), oferta.getDiaFin());
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
		try {
			int idReserva = cargarNumReserva() + 1;
			List<Oferta> listaUnaOferta = new ArrayList<Oferta>();
			listaUnaOferta.add(oferta);
			gbd.transaccionDeReserva(listaUnaOferta, idReserva, numTfno, precio, idServicio, numPlazas);
			salvarNumReserva(idReserva);
			return true;
		}
		catch(FileNotFoundException ex){
			ex.printStackTrace();
			return false;
		}
		catch(IOException ex){
			ex.printStackTrace();
			return false;
		}
		catch(SQLException ex){
			ex.printStackTrace();
			return false;
		}
	}
}
