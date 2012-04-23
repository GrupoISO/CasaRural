/**
 * 
 */
package casarural;

import junit.framework.TestCase;

/**
 * @author Eduardo
 *
 */
public class TestAnularReservas extends TestCase {

	/**
	 * @param arg0
	 */
	public TestAnularReservas(String arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/**
	   * Prueba que el resultado de AnularReservas pasándole un array con una reserva futura (faltan más de 10 días desde el día de hoy) es el esperado.
	   * 
	   * @param Ninguno
	   * @return Ninguno
	   */
	public void testReservaFutura(){
		
		String[] reservaFutura = new String[1];
		
		reservaFutura[0] = Integer.toString(1);
		
		int[] esperado = new int[1];
		esperado[0] = 2;
		
		int[] resultado = GestorReservas.getInstance().anularReservas(reservaFutura);
		
		assertEquals(esperado[0], resultado[0]);
		
	}
	
	/**
	   * Prueba que el resultado de AnularReservas pasándole un array con una reserva pasada pero no caducada (faltan menos de 10 días desde el día de hoy) es el esperado.
	   * 
	   * @param Ninguno
	   * @return Ninguno
	   */
	public void testReservaPasadaA(){
		
		String[] reservaFutura = new String[1];
		
		reservaFutura[0] = Integer.toString(15);
		
		int[] esperado = new int[1];
		esperado[0] = 0;
		
		int[] resultado = GestorReservas.getInstance().anularReservas(reservaFutura);
		
		assertEquals(esperado[0], resultado[0]);
		
	}
	
	/**
	   * Prueba que el resultado de AnularReservas pasándole un array con una reserva pasada y ya caducada (ya ha pasado la fecha de la reserva) es el esperado.
	   * 
	   * @param Ninguno
	   * @return Ninguno
	   */
	public void testReservaPasadaB(){
		
		String[] reservaFutura = new String[1];
		
		reservaFutura[0] = Integer.toString(2);
		
		int[] esperado = new int[1];
		esperado[0] = 0;
		
		int[] resultado = GestorReservas.getInstance().anularReservas(reservaFutura);
		
		assertEquals(esperado[0], resultado[0]);
		
	}

}
