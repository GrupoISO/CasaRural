/**
 * 
 */
package casarural;
import java.util.List;
import java.rmi.*;

/**
 * @author Grupo: Ander, Alberto, Gorka, Jon
 *
 */
public class GestorRecorrido {
	GestorBD gbd;
	
	private static GestorRecorrido elGestorRecorrido = new GestorRecorrido();
	
	private GestorRecorrido(){
		gbd = GestorBD.getInstance();
	}
	
	/**Devuelve una instancia de la clase GestorRecorrido
	 * @param ninguno
	 * @return el gestor de recorridos
	 */
	public static GestorRecorrido getInstance(){
		return elGestorRecorrido;
	}
	
	/**Obtencion de la lista de Casas Rurales crea una nueva interfaz IURecorrido
	 * @param ninguno
	 * @return Una lista de las Casas rurales actuales
	 */
	public List<Casa> getCodigoCasas(){
		List<Casa> listaDeCasas = null;
		try{
			listaDeCasas = gbd.seleccionarCasas();
		}catch(Exception e){
			System.out.println("Error obtiendo la lista de Casas: " + e.getMessage());
		}
		return listaDeCasas;	
	}
	
	/**Asigna a un recorrido un cojunto de casas rurales
	 * @param Una lista de Casas Rurales
	 * @return confirmacion cierto/falso
	 */
	public boolean asignarRecorrido(List<Casa> listaDeCasas){
		int estado = -1;
		try{
			estado = gbd.insertarRecorrido(listaDeCasas);
		}catch(Exception e){
			System.out.println("Error asignando recorrido:" + e.getMessage());
		}
		switch (estado){
		case 1:
			return true;
		case 0:
			return false;
		default:
			return false;
		}		
	}
	
	/**Obtiene una lista de la clase Recorrido con los recorridos actuales
	 * @param ninguno
	 * @return Una lista de recorridos
	 */
	public List<Recorrido> getRecorridos(){
		List<Recorrido> listaDeRecorridos= null;
		try{
			listaDeRecorridos = gbd.getRecorridos();
		}catch(Exception e){
			System.out.println("Error obteniendo la lista de Recorridos" + e.getMessage());
		}
		return listaDeRecorridos;
	}
}
