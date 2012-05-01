package casarural;

import java.sql.SQLException;

import junit.framework.TestCase;

public class TestGestorAdministrador extends TestCase {
	
	private GestorAdministrador gAdministrador;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		gAdministrador = GestorAdministrador.getInstance();
	}
	
	public void test_comprobarAdministrador() throws SQLException {
		assertTrue(gAdministrador.esAdministrador("alberto"));
		assertTrue(gAdministrador.esAdministrador("gorka"));
		
		assertFalse(gAdministrador.esAdministrador("jon"));
		assertFalse(gAdministrador.esAdministrador("ander"));
	}

}
