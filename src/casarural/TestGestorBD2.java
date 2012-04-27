package casarural;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

// NOTA: TODAS LAS PRUEBAS DEBEN HACERSE CON LA BASE DE DATOS INICIAL
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
			fail(e.getMessage());
		}
	}
	
	
	/**
	 * Prueba la función 'insertarRecorrido' en una situación normal
	 */
	public void test_insertarRecorrido_lleno() {
		List<Casa> casas = new ArrayList<Casa>();
		Casa ca;
		
		ca = new Casa();
		ca.setNumCasa(2);
		casas.add(ca);
		
		ca = new Casa();
		ca.setNumCasa(3);
		casas.add(ca);
		
		try {
			assertTrue(gestorBD.insertarRecorrido(casas) > 4);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * Prueba la función 'insertarRecorrido' con una lista vacía
	 */
	public void test_insertarRecorrido_vacio() {
		try {
			assertEquals(-1, gestorBD.insertarRecorrido(new ArrayList<Casa>()));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	/**
	 * Prueba la función 'obtenerServicios' en una situación normal
	 */
	public void test_obtenerServicios_lleno() {
		try {
			java.sql.Date fecha = new java.sql.Date(1336953600000L); // 2012-05-14
			List<Servicio> servicios = gestorBD.obtenerServicios(1, fecha);
			// debe devolver al menos dos servicios: los números 4 y 7
			boolean b = servicios.size() >= 2;
			b = b && servicios.get(0).getNumServicio() == 4 || servicios.get(0).getNumServicio() == 7;
			b = b && servicios.get(1).getNumServicio() == 4 || servicios.get(1).getNumServicio() == 7;
			assertTrue(b);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * Prueba la función 'obtenerServicios' para una fecha enla que no hay servicios
	 */
	public void test_obtenerServicios_vacio() {
		try {
			java.sql.Date fecha = new java.sql.Date(1335312000000L);
			List<Servicio> servicios = gestorBD.obtenerServicios(1, fecha);
			// no debe obtener ningún servicio
			assertTrue(servicios.isEmpty());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * Prueba la función 'transaccionDeReserva' para el caso en el que se contrata un servicio de recogida
	 */
	public void test_transaccionDeReserva() {
		try {
			List<Oferta> ofertas = new ArrayList<Oferta>();
			Oferta o = new Oferta();
			o.setNumOferta("153");
			ofertas.add(o);
			o = new Oferta();
			o.setNumOferta("155");
			ofertas.add(o);
			gestorBD.transaccionDeReserva(ofertas, 10, "943-000000", (float) 123.45, 6, 4);
			assertTrue(true);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * Prueba la función 'transaccionDeReserva' para un caso de error
	 */
	public void test_transaccionDeReserva_error() {
		try {
			List<Oferta> ofertas = new ArrayList<Oferta>();
			Oferta o = new Oferta();
			ofertas.add(o);
			gestorBD.transaccionDeReserva(ofertas, 11, "945-000000", (float) 67.89, 1, 2);
			fail("transaccionDeReserva tenía que haber lanzado excepción");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Prueba la función 'getRecorridos'
	 */
	public void test_getRecorridos() {
		try {
			boolean b = true;
			List<Recorrido> recorridos = gestorBD.getRecorridos();
			for (int i=0; i<recorridos.size(); i++) {
				b = b && recorridos.get(i).getNumRecorrido() == i+1;
			}
			assertTrue(b);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * Prueba la función 'getRecogidas'
	 */
	public void test_getRecogidas() {
		try {
			boolean b = true;
			List<Recogida> recogidas = gestorBD.getRecogidas();
			for (int i=0; i<recogidas.size(); i++) {
				b = b && recogidas.get(i).getNumRecogida() == i+1;
			}
			assertTrue(b);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * Prueba la función 'crearServicio' en una situación normal
	 */
	public void test_crearServicio_bien() {
		try {
			Servicio s = new Servicio();
			s.setFecha(new java.sql.Date(1336953600000L));
			s.setHora(new java.sql.Time(new java.util.Date().getTime()));
			s.setNumRecogida(2);
			s.setNumPlazas(21);
			s.setPrecio((float) 98.76);
			s.setNumRecorrido(3);
			assertTrue(gestorBD.crearServicio(s));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * Prueba la función 'crearServicio' para un caso de error
	 */
	public void test_crearServicio_error() {
		try {
			Servicio s = new Servicio();
			assertFalse(gestorBD.crearServicio(s));
		} catch (Exception e) {
			assertTrue(true);
		}
	}
}
