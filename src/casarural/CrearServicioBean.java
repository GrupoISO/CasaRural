package casarural;

import java.rmi.*;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class CrearServicioBean {
	
	InterfazFachada logNeg;
	Recorrido recorridoSelec;
	Recogida recogidaSelec;
	
	/**Constructor de la clase CrearServicioBean
	 * @param ninguno
	 * @return constructor
	 */
	public CrearServicioBean(){
		try
	    {
	      logNeg = ((InterfazFachada)Naming.lookup("rmi://localhost:1099/CasaRural"));
	    }
	    catch(Exception e) {System.out.println("Error al conseguir la logica del negocio: "+e.toString());}
	}
	
	/**Obtiene una lista de la clase Recorrido con los recorridos actuales
	 * @param ninguno
	 * @return Una lista de recorridos
	 */
	public List<Recorrido> getRecorridos() {
		List<Recorrido> recorridos = null;
		try {
			recorridos = logNeg.getRecorridos();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return recorridos;
	}
	
	/**Obtiene una lista de las recogidas actuales
	 * @param ninguno
	 * @return Una lista de recogidas
	 */
	public List<Recogida> getRecogidas() {
		List<Recogida> recogidas = null;
		try {
			recogidas = logNeg.getRecogidas();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return recogidas;
	}
	
	/**Crea un Servicio asignandolo a un recorrido
	 * 
	 * @param servicio Toma como entrada la clase Servicio
	 * @return confirmación true/false
	 */
	public boolean crearServicio(Servicio servicio) {
		boolean b = false;
		try {
			b = logNeg.crearServicio(servicio);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return b;
	}
	
}
