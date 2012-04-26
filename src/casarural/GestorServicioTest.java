/**
 * 
 */
package casarural;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.TestCase;
import java.util.ArrayList;

public class GestorServicioTest extends TestCase {

	private GestorServicio gs;
	private static String ficheroNumReserva = "numeroReserva.txt";
	
	/**
	 * @param name
	 */
	public GestorServicioTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		this.gs = GestorServicio.getInstance();
	}

	/**
	 * Test method for {@link casarural.GestorServicio#getInstance()}.
	 */
	public void testGetInstance() {
		assertSame(this.gs, GestorServicio.getInstance());
	}

	/**
	 * Test method for {@link casarural.GestorServicio#getRecogidas()}.
	 * Las pruebas se realizan con los datos de la BD iniciales 
	 */
	public void testGetRecogidas() {
		Recogida recogida = new Recogida();
		recogida.setNumRecogida(1);
		recogida.setDireccion("Aeropuerto de Bilbao, s/n 48180 Loiu");
		recogida.setNombre("Aeropuerto de Loiu");
		recogida.setTipo("Aeropuerto");
		
		List<Recogida> listaDeRecogidas = gs.getRecogidas();
		//Comporobar que la lista recibida no es vacia
		assertFalse(listaDeRecogidas.isEmpty());
		//Comprobamos que se recibe una de las recogidas iniciales en la lista
		boolean encontrado = false;
		for(Recogida recogidaIter: listaDeRecogidas){
			if (recogidaIter.getDireccion().equals(recogida.getDireccion()) && recogidaIter.getNombre().equals(recogida.getNombre()) && recogidaIter.getNumRecogida() == recogida.getNumRecogida()) encontrado = true;
		}
		assertTrue(encontrado);
	}

	/**
	 * Test method for {@link casarural.GestorServicio#crearServicio(casarural.Servicio)}.
	 * Las pruebas se realizan con los datos de la BD iniciales
	 */
	public void testCrearServicio() {
		
		Servicio servicio = new Servicio();
		servicio.setDireccionRecogida("Direccion de prueba");
		java.util.Date fechaActual = new java.util.Date();
		java.sql.Date fecha = new java.sql.Date(fechaActual.getTime());
		servicio.setFecha(fecha);
		servicio.setNumPlazas(2);
		servicio.setNumRecogida(2);
		servicio.setPrecio(18.87f);
		java.sql.Time hora = new java.sql.Time(fechaActual.getTime());
		servicio.setHora(hora);
		servicio.setTipoRecogida("Prueba");

		//Probamos a crear un servicio que no tiene asignado un recorrido
		assertFalse(gs.crearServicio(servicio));

		//Probamos un servicio que si tiene asignado el recorrido
		servicio.setNumRecorrido(1);
		assertTrue(gs.crearServicio(servicio));
	}

	/**
	 * Test method for {@link casarural.GestorServicio#mostrarServicios(int)}.
	 * Las pruebas se realizan con los datos de la BD iniciales
	 */
	public void testMostrarServicios() {
		//Obtendremos una lista de servcios asociados a la primera casa rural de los datos iniciales de la BD
		java.util.Date fech = new java.util.Date(1327273200000L); 
		java.sql.Date fecha = new java.sql.Date(fech.getTime());
		List<Servicio> listaDeServicios = gs.mostrarServicios(1, fecha);

		boolean encontrado = false;
		for (Servicio servicio : listaDeServicios){
			System.out.println(servicio.getNumServicio());
			if (servicio.getNumServicio() == 1) encontrado = true;
		}
		assertTrue(encontrado);
	}

	/**
	 * Test method for {@link casarural.GestorServicio#TransaccionDeReserva(java.util.List, int, java.lang.String, float, int, int)}
	 * Las pruebas se realizan con los datos de la BD iniciales.
	 */
	public void testTransaccionDeReserva() {
//		Reserva reserva = new Reserva();
//		reserva.setPrecioTotal(999.9f);
//		reserva.setNumCasa(1);
		Oferta oferta = new Oferta();
		oferta.setNumCasa(1);
		oferta.setNumOferta("Oferta de Prueba");
		
		List<Reserva> listaDeUnareserva = new ArrayList<Reserva>();
		listaDeUnareserva.add(reserva);
		
		//Crearemos una reserva de prueba y tomaremos la confirmación del GestorBtD
		boolean estado = gs.transaccionDeReserva(listaDeUnareserva, 8,"943000000", 1, 5);
		assertTrue(estado);
	}

}
