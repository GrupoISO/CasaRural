package casarural;

import java.rmi.*;
import java.util.List;

public class CrearRecorridoBean {
	
	InterfazFachada logNeg;
	
	/**Constructor de la clase CrearrecorridoBean
	 * @param ninguno
	 * @return constructor
	 */
	public CrearRecorridoBean(){
		try
	    {
	      logNeg = ((InterfazFachada)Naming.lookup("rmi://localhost:1099/CasaRural"));
	    }
	    catch(Exception e) {System.out.println("Error al conseguir la logica del negocio: "+e.toString());}
	}
	
	/**Obtiene las Casas Rurales disponibles
	 * @param ninguno
	 * @return Lista de Casas
	 */
	public List<Casa> getCasas(){
		List<Casa> listaDeCasasDisponibles = null;
		try
		{
			return listaDeCasasDisponibles = logNeg.getCodigoCasas();
		}catch(Exception e){
			e.getStackTrace();
			System.out.println("Error al conseguir la lista de Casas rurales disponibles: "+e.toString());
			return listaDeCasasDisponibles;
		}
	}
	
	/**Inserta un recorrido en la BD con la lista de Casas que toma como paremtro
	 * 
	 * @param Una lista de casas, que son las que conforma el recorredo que se va a crear
	 * @return ninguno
	 */
	public void selecCasas(List<Casa> listaDeCasasSeleccionada){
		try
		{
			logNeg.asignarRecorrido(listaDeCasasSeleccionada);
		}catch(Exception e){
			e.getStackTrace();
			System.out.println("Error al intentar crear el recorrido: "+e.toString());
		}
	}	
}
