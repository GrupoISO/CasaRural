package casarural;

import java.rmi.*;
import java.util.List;
import java.util.ArrayList;

public class CrearServicioBean {
	
	InterfazFachada logNeg;
	
	/**Constructor de la clase CrearrServicioBean
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
	
}
