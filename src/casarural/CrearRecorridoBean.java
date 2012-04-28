package casarural;

import java.rmi.*;
import java.util.List;
import java.util.ArrayList;

public class CrearRecorridoBean {
	
	InterfazFachada logNeg;
	private List<Casa> listaDeCasasSeleccionada = new ArrayList<Casa>();
	
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
	
	/**Obtiene la lista de Casas cargadas en Bean
	 * 	 * @return listaDeCasas
	 */
	public List<Casa> getlistaDeCasasSeleccionada(){
		return listaDeCasasSeleccionada;
	}
	
	/**Inserta un recorrido en la BD con la lista de Casas que toma como paremtro
	 * 
	 * @param ninguno
	 * @return ninguno
	 */
	public void selecCasas(){
		try
		{
			logNeg.asignarRecorrido(listaDeCasasSeleccionada);
		}catch(Exception e){
			e.getStackTrace();
			System.out.println("Error al intentar crear el recorrido: "+e.toString());
		}
	}	
}
