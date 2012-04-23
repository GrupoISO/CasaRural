package casarural;

import java.sql.SQLException;
import java.util.List;
import java.sql.Date;


public class GestorServicio {

	private static GestorServicio gestorServicio;
	private GestorBD gbd;
	
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
	
	/**Obtiene una lista de las recogidas actuales
	 * @param ninguno
	 * @return Una lista de recogidas
	 */
	public List<Recogida> getRecogidas() {
		return gbd.getRecogidas();
	}
	
	/**Crea un Servicio asignandolo a un recorrido
	 * 
	 * @param miServicio Toma como entrada la clase Servicio
	 * @param idRecogida Código de la Recogida asignada
	 * @param idRecorrido Código de Recorrido al que se le asignara este servicio
	 * @return confirmación true/false
	 */
	public boolean crearServicio(Servicio miServicio, int idRecogida, int idRecorrido) {
		try {
			return gbd.crearServicio(miServicio, idRecogida, idRecorrido);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	/**Obtiene una lista de Servicios asignados a una casa rural
	 * 
	 * @param numCasa Código de la casa rural de la cual se requieren los servicios
	 * @return listaDeServicios asociados a una casa rural
	 */
	public List<Servicio> mostrarServicios(int numCasa){
		try {
			java.util.Date fechaActual = new java.util.Date();
			java.sql.Date fecha = new java.sql.Date(fechaActual.getTime());
			return gbd.obtenerServicios(numCasa, fecha);
		}catch(SQLException ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**Crea una reserva y asigna un servicio a la misma
	 *
	 * @param 
	 * @param idServicio Identificador del servicio que se asignara a la reserva
	 * @param numPlazas Numero de plazas que se quiere reservar
	 * @return
	 */
	public boolean TransaccionDeReserva(List<Reserva> reservasTotales, int idReserva, String numTfno, float precioTotal, int idServicio, int numPlazas){
		try {
			gbd.transaccionDeReserva(reservasTotales, idReserva, numTfno, precioTotal, idServicio, numPlazas);
			return true;
		}catch(SQLException ex){
			ex.printStackTrace();
			return false;
		}
	}
}
