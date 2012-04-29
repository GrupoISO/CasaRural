package casarural;

import java.rmi.*;
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
	
	public List<Recorrido> getRecorridos() {
		List<Recorrido> recorridos = null;
		try {
			recorridos = logNeg.getRecorridos();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return recorridos;
	}
	
	public List<Recogida> getRecogidas() {
		List<Recogida> recogidas = null;
		try {
			recogidas = logNeg.getRecogidas();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return recogidas;
	}
	
}
