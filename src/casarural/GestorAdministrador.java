package casarural;

public class GestorAdministrador {
	private static String contrasenya = "alberto";
	private static GestorAdministrador gestorAdministrador;
	
	public static GestorAdministrador getInstance() {
		if (gestorAdministrador == null) {
			gestorAdministrador = new GestorAdministrador();
		}
		
		return gestorAdministrador;
	}
	
	private GestorAdministrador() {}
	
	public boolean esAdministrador(String codigo) {
		return codigo.equals(contrasenya);
	}
}
