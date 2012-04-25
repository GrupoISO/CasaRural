package casarural;

//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;


public class TestGestorBD2 extends TestCase {

	private GestorBD gestorBD;

	/**
	 * @param name
	 */
	public TestGestorBD2(String name) {
		super(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		gestorBD = GestorBD.getInstance();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		this.gestorBD = null;
	}
	
	/**
	 * Prueba la función 'obtenerCasas'
	 */
	public void test_obtenerCasas() {
		boolean b = true;
		List<Casa> esperado = new ArrayList<Casa>();
		Casa ca;
		
		ca = new Casa();
		ca.setNumCasa(1);
		ca.setDescripcion("Casa en Gipuzkoa");
		ca.setPoblacion("Donostia");
		ca.setPropietario("JoxeMari");
		esperado.add(ca);
		
		ca = new Casa();
		ca.setNumCasa(2);
		ca.setDescripcion("Casa en Bizkaia");
		ca.setPoblacion("Bilbo");
		ca.setPropietario("Patxi");
		esperado.add(ca);
		
		ca = new Casa();
		ca.setNumCasa(3);
		ca.setDescripcion("Casa en Araba");
		ca.setPoblacion("Gasteiz");
		ca.setPropietario("Miren");
		esperado.add(ca);
		
		try {
			List<Casa> obtenido = gestorBD.obtenerCasas();
			b = esperado.size() <= obtenido.size(); // contiene al menos las tres tuplas iniciales
			for (int i=0; i<esperado.size(); i++) {
				b = b && esperado.get(i).equals(obtenido.get(i));
			}
			assertTrue(b);
		} catch (Exception e) {
			fail("Excepción en obtenerCasas");
		}
	}
	
	
	/**
	 * Prueba la función 'insertarRecorrido' en una situación normal
	 */
/*	public void test_insertarRecorrido_lleno() {
		boolean b = true;
		List<Casa> casas = new ArrayList<Casa>();
		Casa ca;
		
		ca = new Casa();
		ca.setNumCasa(2);
		casas.add(ca);
		
		ca = new Casa();
		ca.setNumCasa(3);
		casas.add(ca);
		
		try {
			assertEquals(5, gestorBD.insertarRecorrido(casas));
		} catch (Exception e) {
			fail("Excepción en obtenerCasas");
		}
	}*/
	
	/**
	 * Prueba la función 'insertarRecorrido' con una lista vacía
	 */
	public void test_insertarRecorrido_vacio() {
		try {
			assertEquals(-1, gestorBD.insertarRecorrido(new ArrayList<Casa>()));
		} catch (Exception e) {
			fail("Excepción en obtenerCasas");
		}
	}
	/**
	 * Prueba la función 'obtenerServicios'
	 */
	public void test_obtenerServicios() {
		try {
			java.sql.Date fecha = new java.sql.Date(1336953600000L); // 2012-05-14
			List<Servicio> servicios = gestorBD.obtenerServicios(1, fecha);
			// debe devolver al menos dos servicios: los números 4 y 7
			boolean b = servicios.size() >= 2;
			b = b && servicios.get(0).getNumServicio() == 4 || servicios.get(0).getNumServicio() == 7;
			b = b && servicios.get(1).getNumServicio() == 4 || servicios.get(1).getNumServicio() == 7;
			assertTrue(b);
		} catch (Exception e) {
			fail("Excepción en obtenerServicios");
		}
	}

}
