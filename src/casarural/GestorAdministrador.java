package casarural;

import java.sql.SQLException;

public class GestorAdministrador {
	private static GestorAdministrador gestorAdministrador;
	
	private GestorBD gBd;
	
	public static GestorAdministrador getInstance() {
		if (gestorAdministrador == null) {
			gestorAdministrador = new GestorAdministrador();
		}
		
		return gestorAdministrador;
	}
	
	private GestorAdministrador() {
		gBd = GestorBD.getInstance();
	}
	
	public boolean esAdministrador(String codigo) {
		try {
			return gBd.comprobarAdministrador(codigo);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
