/**
 * 
 */
package casarural;

import junit.framework.TestCase;

/**
 * @author Saioa
 *
 */
public class TestGestorReservas extends TestCase {
	
	private GestorReservas gr;
	/**
	 * @param name
	 */
	public TestGestorReservas(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		gr = GestorReservas.getInstance();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		gr=null;
	}
	
	public void test_anularReservas(){
		
	}
}
