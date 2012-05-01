package casarural;

import java.rmi.*;
import java.util.List;
import java.util.ArrayList;

public class CrearRecorridoBean {
	
	InterfazFachada logNeg;
	private List<Integer> listaDeCasasSeleccionadas = new ArrayList<Integer>();
	private int numCasa;
	
	/**Constructor de la clase CrearRecorridoBean
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
	
	/**Obtener la lista de Casas Seleccionadas
	 * 
	 * @return lista de casas seleccionadas
	 */
	public List<Integer> getlistaDeCasasSeleccionadas(){
		return listaDeCasasSeleccionadas;
	}
	
	/**Establece el numero de Casa que se quiere incluir posteriormente en la lista
	 * 
	 * @param numerodecasa El número de la Casa Rural
	 */
	public void setnumCasa(int numerodecasa){
		this.numCasa = numerodecasa;
	}
	
	/** Obtiene el número de la casa actual, que esta disponible para añadir
	 * 
	 * @return
	 */
	public int getnumCasa(){
		return (this.numCasa);
	}
	
	/** Añadir un Casa a la lista de Casasas seleccionadas
	 * 
	 * @param Un objeto Casa
	 */
	public void addCasaSelecionada(){
		listaDeCasasSeleccionadas.add(numCasa);
	}
	
	/**Inserta un recorrido en la BD con la lista de Casas
	 * 
	 * @return ninguno
	 */
	public void selecCasas(){
		try
		{
			logNeg.asignarRecorrido(listaDeCasasSeleccionadas);
		}catch(Exception e){
			e.getStackTrace();
			System.out.println("Error al intentar crear el recorrido: "+e.toString());
		}
	}	
}
