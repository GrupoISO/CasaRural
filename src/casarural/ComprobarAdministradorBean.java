package casarural;

import java.rmi.*;

public class ComprobarAdministradorBean {
	
	InterfazFachada logNeg;
	
	
	/**Constructor de la clase CrearAdministradorBean
	 * @param ninguno
	 * @return constructor
	 */
	public ComprobarAdministradorBean(){
		try
	    {
	      logNeg = ((InterfazFachada)Naming.lookup("rmi://localhost:1099/CasaRural"));
	    }
	    catch(Exception e) {System.out.println("Error al conseguir la logica del negocio: "+e.toString());}
	}
	
	/**Método para comprobar la veracidad del administrador
	 * 
	 * @param usuario
	 * @return
	 */
	public boolean esAdministrador(String usuario){
		try{
			return logNeg.esAdministrador(usuario);
		}catch(Exception e){
			e.getStackTrace();
			return true;
		}
	}

}
