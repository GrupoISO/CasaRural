package casarural;

import java.rmi.*;
import java.util.List;

public class ServicioRecogidaBean {

	InterfazFachada logNeg;
	
	/**Constructor de la clase CrearrecorridoBean
	 * @param ninguno
	 * @return constructor
	 */
	public ServicioRecogidaBean(){
		try
	    {
	      logNeg = ((InterfazFachada)Naming.lookup("rmi://localhost:1099/CasaRural"));
	    }
	    catch(Exception e) {System.out.println("Error al conseguir la logica del negocio: "+e.toString());}
	}
	
	/**Obtiene una lista formada por los servicios actuales disponibles
	 * 
	 * @return Una lista, compuesta por la clase Servicio
	 */
	public List<Servicio> MostrarServicios(int numCasa, java.sql.Date fecha){
		try{
			return logNeg.mostrarServicios(numCasa, fecha);
		}catch(Exception ex){
			ex.getStackTrace();
			return null;
		}
	}
}
