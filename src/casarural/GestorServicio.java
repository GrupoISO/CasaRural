package casarural;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
	protected static void salvarNumReserva(int numactual) throws FileNotFoundException,
	IOException {
		PrintWriter numero = new PrintWriter(new FileWriter(ficheroNumReserva));
		Integer num = new Integer(numactual);
		numero.print(num.toString());
		numero.close();
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
	 * @param servicio Toma como entrada la clase Servicio
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
	 * @param 
	 * @param idServicio Identificador del servicio que se asignara a la reserva
	 * @param numPlazas Numero de plazas que se quiere reservar
	 * @return
	 */
	public boolean transaccionDeReserva(List<Oferta> reservasTotales, String numTfno, int idServicio, int numPlazas){
		try {
			int idReserva = cargarNumReserva() + 1;
			float precioTotal = 0;
			for(Oferta reservaOferta: reservasTotales){
				precioTotal = precioTotal + reservaOferta.getPrecio();
			}
			gbd.transaccionDeReserva(reservasTotales, idReserva, numTfno, precioTotal, idServicio, numPlazas);
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
