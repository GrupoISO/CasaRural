package casarural;

import java.sql.SQLException;

/**
 * Gestor de administradores, para comprobar que existan en la base de datos.
 */
public class GestorAdministrador {
	private static GestorAdministrador gestorAdministrador;
	
	private GestorBD gBd;
	
	/**
	 * Obtiene la instancia del gestor de administradores.
	 * @return La instancia del gestor
	 */
	public static GestorAdministrador getInstance() {
		if (gestorAdministrador == null) {
			gestorAdministrador = new GestorAdministrador();
		}
		
		return gestorAdministrador;
	}
	
	private GestorAdministrador() {
		gBd = GestorBD.getInstance();
	}
	
	/**
	 * Comprueba que el código sea de un administrador válido.
	 * @param codigo El código de administrador
	 * @return Verdadero si el administrador existe, falso en caso contrario.
	 */
	public boolean esAdministrador(String codigo) {
		try {
			return gBd.comprobarAdministrador(codigo);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
