package casarural;

import junit.framework.TestCase;
import java.util.List;
import java.util.ArrayList;

public class GestorRecorridoTest extends TestCase {

	private GestorRecorrido GR;
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		this.GR = GestorRecorrido.getInstance();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		this.GR = null;
	}
	
	public void testGetInstance() {
		//fail("Not yet implemented");
	}

	public void testGetCodigoCasas() {
		List<Casa> listaDeCasas = GR.getCodigoCasas();
		//Verificamos que efectivamente se ha devuelto una list no vacia
		assertFalse(listaDeCasas.isEmpty());
	}

	public void testAsignarRecorrido() {
		fail("Not yet implemented");
	}

	public void testGetRecorridos() {
		fail("Not yet implemented");
	}

}
