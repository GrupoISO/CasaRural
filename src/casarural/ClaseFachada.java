package casarural;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.List;
import java.util.Vector;

public class ClaseFachada extends UnicastRemoteObject implements
		InterfazFachada {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4537700637872965045L;

	GestorCasasRurales elGestorCasasRurales = GestorCasasRurales.getInstance();

	GestorReservas elGestorReservas = GestorReservas.getInstance();

	GestorOfertas elGestorOfertas = GestorOfertas.getInstance();

	public ClaseFachada() throws RemoteException {
	}

	/*
	 * public Float calcular(Float op1, Float op2) throws RemoteException {
	 * 
	 * return null; }
	 * 
	 * public void setConfiguracion(InterfazConfiguracion inConf) throws
	 * RemoteException { }
	 * 
	 * public Vector seleccionarReservas(Date diaIni, Date diaFin, int numCasa)
	 * throws RemoteException, NoSePuedeReservarException {
	 * 
	 * return null; }
	 * 
	 * public void transaccionDeReserva(Vector reservasTotales, String
	 * numReserva, String numTfnoReserva, float PrecioTotal) throws
	 * RemoteException { }
	 * 
	 * public Propietario seleccionarPropietario(int numCasa) throws
	 * RemoteException { return null; }
	 * 
	 * public Vector getCodigosCasas(String cuentaSistema) throws
	 * RemoteException { return
	 * elGestorCasasRurales.getCodigosCasas(cuentaSistema); }
	 * 
	 * public Vector seleccionarCasas(String cuentaSistema) throws
	 * RemoteException { return null; }
	 * 
	 * public Vector seleccionarOfertas(Date diaIni, Date diaFin, int numCasa)
	 * throws RemoteException { return null; }
	 * 
	 * public void transaccionDeOfertas(Vector todasLasOfertasIncluidas, Date
	 * diaIni, Date diaFin, String numOfePrimera, String numOfeUltima, float
	 * precio, int numCasa) throws RemoteException { }
	 * 
	 * public void setTantoPorCientoAPagar(int porcentaje) throws
	 * RemoteException { }
	 * 
	 * public int getTantoPorCientoAPagar() throws RemoteException {
	 * 
	 * return 0; }
	 * 
	 * public void setNumDiasAPagar(int numDias) throws RemoteException { }
	 * 
	 * public int getNumDiasAPagar() throws RemoteException {
	 * 
	 * return 0; }
	 * 
	 * public InterfazConfiguracion getConfiguracion() throws RemoteException {
	 * 
	 * return null; }
	 */

	/**
	 * Obtiene el codigo de las casas vinculadas a una cuenta
	 * 
	 * @param Numero
	 *            de cuenta
	 * @return Vector de codigos de casa
	 */

	public List<Integer> getCodigosCasas(String cuentaSistema) throws RemoteException {
		return elGestorCasasRurales.getCodigosCasas(cuentaSistema);
	}

	/**
	 * Obtiene las ofertas entre las fechas indicadas para un numero de casa
	 * 
	 * @param Numero
	 *            de casa, Fecha de inicio y fecha de fin
	 * @return Vector de objetos de la clase Oferta
	 */

	public Oferta obtenerMejorOferta(Date diaIni, Date diaFin,
			int habitaciones, int banos, String criterio)
			throws RemoteException, Exception {

		return elGestorOfertas.obtenerMejorOferta(diaIni, diaFin, habitaciones,
				banos, criterio);

	}

	/**
	 * Asigna la oferta a la casa determinada
	 * 
	 * @param El
	 *            codigo de la casa, dia de inicio, dia de fin y el precio
	 * @return Ninguno
	 */
	public void asignarOferta(int numCasa, Date diaIni, Date diaFin,
			float precio) throws RemoteException, Exception {
		elGestorOfertas.asignarOferta(numCasa, diaIni, diaFin, precio);
	}

	/**
	 * Devuelve la reserva vinculada a los parametros de entrada
	 * 
	 * @param El
	 *            codigo de la casa, dia de inicio, dia de fin y el numero de
	 *            telefono
	 * @return La reserva
	 */
	public Reserva reservar(Date diaIni, Date diaFin, int numCasa,
			String numTfnoReserva) throws RemoteException,
			NoSePuedeReservarException {

		return elGestorReservas.reservar(diaIni, diaFin, numCasa,
				numTfnoReserva);
	}

	/**
	 * Devuelve el numero de cuenta corriente asociada a la casa
	 * 
	 * @param El
	 *            codigo de la casa
	 * @return El numero de cuenta
	 */
	public String getNumCuentaCorriente(int numCasa) throws RemoteException {
		return elGestorCasasRurales.getNumCuentaCorriente(numCasa);
	}

	/**
	 * Obtiene las ofertas entre las fechas indicadas para un numero de casa
	 * 
	 * @param Numero
	 *            de casa, Fecha de inicio y fecha de fin
	 * @return Vector de objetos de la clase Oferta
	 */
	public OfertasEnMemoriaPrincipal obtenerOfertas(int numCasa,
			java.sql.Date diaIni, java.sql.Date diaFin) throws RemoteException,
			Exception {
		return elGestorOfertas.obtenerOfertas(numCasa, diaIni, diaFin);
	}

	/**
	 * Busca el conjunto de ofertas en función de las restricciones impuestas
	 * por el usuario
	 * 
	 * @param diaIni
	 *            , fecha inicio de la oferta
	 * @param diaFin
	 *            , fecha fin de la oferta
	 * @param precioMax
	 *            , precio máximo de la oferta
	 * @param diasMin
	 *            , número mínimo de días a pasar
	 * @param dormitorios
	 *            , número de dormitorios que se buscan
	 * @param bano
	 *            , número de baños que se desea tenga la casa
	 * @param orden
	 *            , mostrar ofertas ordenadas por precio o número de días
	 * 
	 * @return Vector de objetos de la clase Oferta
	 */
	public List<Oferta> buscarOfertas(java.sql.Date diaIni, java.sql.Date diaFin,
			float precioMax, int diasMin, int dormitorios, int banos,
			boolean orden) throws RemoteException, Exception {
		return elGestorOfertas.buscarOfertas(diaIni, diaFin, precioMax,
				diasMin, dormitorios, banos, orden);

		/*
		 * java.sql.Date ini = new java.sql.Date((new GregorianCalendar(2004, 1,
		 * 1)).getTime().getTime()); java.sql.Date fin = new java.sql.Date((new
		 * GregorianCalendar(2007, 1, 1)).getTime().getTime()); Vector v =
		 * elGestorOfertas.buscarOfertas(ini,fin , precioMax, diasMin,
		 * dormitorios, banos, orden);
		 * 
		 * return v;
		 */
	}

	/**
	 * Devuelve un vector con las reservas que se encuentran entre las fechas
	 * indicadas
	 * 
	 * @param diaIni
	 * @param diaFin
	 * @return Vector<Reserva>
	 */
	public Vector<Reserva> obtReservas(java.sql.Date diaIni,
			java.sql.Date diaFin) {
		return elGestorReservas.obtReservas(diaIni, diaFin);
	}

	/**
	 * Devuelve en un array de enteros el resultado tras realizar las
	 * anulaciones de las reservas indicadas en el array reservas que se pasa
	 * como par�metro. Un 0 indica anulaci�n correcta, 1 anulaci�n incorrecta y
	 * 2 que se devolver� el 20%
	 * 
	 * @param reservas
	 *            , String[]
	 * @return int[]
	 * 
	 * 
	 */
	public int[] anularReservas(String[] reservas) throws RemoteException,
			Exception {
		return elGestorReservas.anularReservas(reservas);
	}
}