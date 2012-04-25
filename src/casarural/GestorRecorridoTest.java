package casarural;

import junit.framework.TestCase;
import java.util.List;
import java.util.ArrayList;

public class GestorRecorridoTest extends TestCase {

	private GestorRecorrido gr;
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		this.gr = GestorRecorrido.getInstance();
	}
	
	/**Prueba para verificar la instancia de GestorRecorrido
	 * 
	 */
	public void testGetInstance() {
		assertSame(this.gr, GestorRecorrido.getInstance());
	}
	
	/**Prueba del método GetCodigoCasas
	 * Verifica que se recibe la primera casa rural de la BD inicial
	 */
	public void testGetCodigoCasas() {
		//Creamos una Casa rural ficticia que esta en la BD inicial
		Casa miCasa = new Casa();
		miCasa.setNumCasa(1);
		miCasa.setPropietario("JoxeMari");
		miCasa.setNumDormitorios(3);
		miCasa.setDescripcion("Casa en Gipuzkoa");
		miCasa.setNumCocinas(2);
		miCasa.setNumPlazasGaraje(0);
		miCasa.setPoblacion("Donostia");
		
		List<Casa> listaDeCasas = gr.getCodigoCasas();
		//Verificamos que efectivamente se ha devuelto una list no vacia
		assertFalse(listaDeCasas.isEmpty());
		//Verificamos que la primera casa esta en la lista recibida
		boolean found = false;
		for (Casa casa: listaDeCasas) {
			if (miCasa.getNumCasa() == casa.getNumCasa())  found = true;
		}
		assertTrue(found);
	}

	/**
	 * TestAsignarRecorrido
	 * comprueba que se ha asignado correctamente un recorrido asignando uno
	 * 
	 */
	public void testAsignarRecorrido() {
		Casa miCasa = new Casa();
		miCasa.setNumCasa(1);
		miCasa.setPropietario("JoxeMari");
		miCasa.setNumDormitorios(3);
		miCasa.setDescripcion("Casa en Gipuzkoa");
		miCasa.setNumCocinas(2);
		miCasa.setNumPlazasGaraje(0);
		miCasa.setPoblacion("Donostia");
		
		List<Casa> listaDeCasas = new ArrayList<Casa>();
		listaDeCasas.add(miCasa);
		
		assertTrue(gr.asignarRecorrido(listaDeCasas));
	}

	/**
	 * Test para probar GestoRecorridos 
	 * solo funciona con los datos iniciales de la BD
	 */
	public void testGetRecorridos() {
		List<Recorrido> listaDeRecorrido = gr.getRecorridos();
		//Comprobar que la lista que se recive no es vacia
		assertFalse(listaDeRecorrido.isEmpty());
		//Comprobamos que existe el numRecorrido 1 en la lista de recorridos devuelta que está en la BD inicial 
		boolean found = false;
		for(Recorrido recorrido: listaDeRecorrido){
			if(recorrido.getNumRecorrido() == 1) found = true;
		}
		assertTrue(found);
	}

}
