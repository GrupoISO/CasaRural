/**
 * 
 */
package casarural;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.Vector;

import junit.framework.TestCase;


public class TestGestorBD extends TestCase {

	private GestorBD gestorBD;

	/**
	 * @param name
	 */
	public TestGestorBD(String name) {
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
	
	/*
	 * 
	 * @param year, int
	 * @param month, int
	 * @param day, int
	 * 
	 * @return java.sql.Date
	 */
	private java.sql.Date fecha(int year,int month,int day){
		return new java.sql.Date((new GregorianCalendar(year, month-1, day)).getTime().getTime());
	}
	
	/**
	 * En esta prueba se verifica que salen todas las ofertas no reservadas sin ningun parametro 
	 *	y ordenadas por precio.
	 * Esta prueba debe realizarse con la base de datos inicial
	 */
	public void test_seleccionarCasasDorWC_BD_Ord_Precio() {
		
		// Entrada
		int numDormitorios = 0 , numBanos = 0, numMinDias = 0;
		boolean orden = true;
		java.sql.Date diaIni =  new java.sql.Date((new GregorianCalendar(2004, 1, 1)).getTime().getTime());
		java.sql.Date diaFin  = new java.sql.Date((new GregorianCalendar(2007, 1, 1)).getTime().getTime());
		float precio = 0;
		
		Vector esperado = new Vector();
		Oferta of;
//		 Resultado Esperado
		of = new Oferta();
		of.setPrecio(3);
		of.setDiaFin(fecha(2005,5,15));
		of.setDiaIni(fecha(2005,5,9));
		of.setNumCasa(5);
		of.setNumOferta("102");
		esperado.add(of);

		of = new Oferta();
		of.setPrecio(25);
		of.setDiaFin(fecha(2006,4,16));
		of.setDiaIni(fecha(2006,4,10));
		of.setNumCasa(4);
		of.setNumOferta("108");
		esperado.add(of);
		
		of = new Oferta();
		of.setPrecio(33);
		of.setDiaFin(fecha(2005,5,20));
		of.setDiaIni(fecha(2005,5,15));
		of.setNumCasa(4);
		of.setNumOferta("103");
		esperado.add(of);
		
		of = new Oferta();
		of.setPrecio(34);
		of.setDiaFin(fecha(2006,4,25));
		of.setDiaIni(fecha(2006,4,23));
		of.setNumCasa(4);
		of.setNumOferta("106");
		esperado.add(of);
		
		of = new Oferta();
		of.setPrecio(45);
		of.setDiaFin(fecha(2006,4,16));
		of.setDiaIni(fecha(2006,4,10));
		of.setNumCasa(7);
		of.setNumOferta("107");
		esperado.add(of);
		
		of = new Oferta();
		of.setPrecio(80);
		of.setDiaFin(fecha(2006,5,24));
		of.setDiaIni(fecha(2006,5,21));
		of.setNumCasa(4);
		of.setNumOferta("110");
		esperado.add(of);
		
		of = new Oferta();
		of.setPrecio(110);
		of.setDiaFin(fecha(2006,5,25));
		of.setDiaIni(fecha(2006,5,20));
		of.setNumCasa(7);
		of.setNumOferta("109");
		esperado.add(of);
		
		// Ejecutar test
		Vector obtenido = (Vector) gestorBD.seleccionarCasasDorWC(numDormitorios, numBanos, diaIni, diaFin, precio, numMinDias, orden);
		assertEquals("Error en la obtencion de los datos BD!", esperado, obtenido);
	}
	/**
	 * En esta prueba se verifica que salen todas las ofertas no reservadas entre el 01-02-2005 y el 01-02-2006
	 *	y ordenadas por precio.
	 * Esta prueba debe realizarse con la base de datos inicial
	 */
	public void test_seleccionarCasasDorWC_BD_Fechas_Ord_Precio() {

		// Entrada
		int numDormitorios = 0, numBanos = 0,numMinDias = 0;
		boolean orden = true;
		java.sql.Date diaIni =  new java.sql.Date((new GregorianCalendar(2005, 1, 1)).getTime().getTime());
		java.sql.Date diaFin  = new java.sql.Date((new GregorianCalendar(2006, 1, 1)).getTime().getTime());
		float precio = 0;
		
		Vector esperado = new Vector();
		Oferta of;
//		 Resultado Esperado
		of = new Oferta();
		of.setPrecio(3);
		of.setDiaFin(fecha(2005,5,15));
		of.setDiaIni(fecha(2005,5,9));
		of.setNumCasa(5);
		of.setNumOferta("102");
		esperado.add(of);

		of = new Oferta();
		of.setPrecio(33);
		of.setDiaFin(fecha(2005,5,20));
		of.setDiaIni(fecha(2005,5,15));
		of.setNumCasa(4);
		of.setNumOferta("103");
		esperado.add(of);
		
		// Ejecutar test
		Vector obtenido = (Vector) gestorBD.seleccionarCasasDorWC(numDormitorios, numBanos, diaIni, diaFin, precio, numMinDias, orden);
		assertEquals("Error en la obtencion de los datos BD!", esperado, obtenido);
	}
	/**
	 * En esta prueba se verifica que salen todas las ofertas no reservadas entre el 01-02-2005 y el 01-02-2006
	 * y con un numero de dias minimo igual a 6 y ordenadas por precio.
	 * Esta prueba debe realizarse con la base de datos inicial
	 */
	public void test_seleccionarCasasDorWC_BD_Fechas_Numdias_Ord_Precio() {

		// Entrada
		int numDormitorios = 0 , numBanos = 0,numMinDias = 6;
		boolean orden = true;
		java.sql.Date diaIni =  new java.sql.Date((new GregorianCalendar(2005, 1, 1)).getTime().getTime());
		java.sql.Date diaFin  = new java.sql.Date((new GregorianCalendar(2006, 1, 1)).getTime().getTime());
		float precio = 0;
		
		Vector esperado = new Vector();
		Oferta of;
//		 Resultado Esperado
		of = new Oferta();
		of.setPrecio(3);
		of.setDiaFin(fecha(2005,5,15));
		of.setDiaIni(fecha(2005,5,9));
		of.setNumCasa(5);
		of.setNumOferta("102");
		esperado.add(of);
		
		// Ejecutar test
		Vector obtenido = (Vector) gestorBD.seleccionarCasasDorWC(numDormitorios, numBanos, diaIni, diaFin, precio, numMinDias, orden);
		assertEquals("Error en la obtencion de los datos BD!", esperado, obtenido);
	}
	/**
	 * En esta prueba se verifica que salen todas las ofertas no reservadas entre el 01-02-2005 y el 01-02-2006
	 * y con un precio maximo de 4 y ordenadas por precio.
	 * Esta prueba debe realizarse con la base de datos inicial
	 */
	public void test_seleccionarCasasDorWC_BD_Fechas_Precio_Ord_Precio() {

		// Entrada
		int numDormitorios = 0 , numBanos = 0,numMinDias = 0;
		boolean orden = true;
		java.sql.Date diaIni =  new java.sql.Date((new GregorianCalendar(2005, 1, 1)).getTime().getTime());
		java.sql.Date diaFin  = new java.sql.Date((new GregorianCalendar(2006, 1, 1)).getTime().getTime());
		float precio = 4;
		
		Vector esperado = new Vector();
		Oferta of;
//		 Resultado Esperado
		of = new Oferta();
		of.setPrecio(3);
		of.setDiaFin(fecha(2005,5,15));
		of.setDiaIni(fecha(2005,5,9));
		of.setNumCasa(5);
		of.setNumOferta("102");
		esperado.add(of);

		
		// Ejecutar test
		Vector obtenido = (Vector) gestorBD.seleccionarCasasDorWC(numDormitorios,numBanos,diaIni,diaFin,precio,numMinDias,orden);
		assertEquals("Error en la obtencion de los datos BD!", esperado, obtenido);
	}
	
	/*
	 * En esta prueba se verifica que salen todas las reservas que se han establecido entre las fechas de
	 * 21 de Mayo del 2007 y 30 de Mayo del 2012 ordenado por número de la reserva.
	 * 
	 */
	public void test_mostrar_reservas_ord_numReserva (){
		
		//Entrada
		java.sql.Date fechaIni = new java.sql.Date ((new GregorianCalendar(2007,5,21)).getTime().getTime());
		java.sql.Date fechaFin = new java.sql.Date ((new GregorianCalendar(2012,5,30)).getTime().getTime());
				
		Vector<Reserva> esperado = new Vector<Reserva>();
		Reserva r;
		//Resultado Esperado
		r = new Reserva();
		r.setNumCasa(5);
		r.setNumReserva(new String("1"));
		r.setPrecioTotal(68);
		esperado.add(r);
		
		r=new Reserva();
		r.setNumCasa(4);
		r.setNumReserva("3");
		r.setPrecioTotal(620);
		esperado.add(r);
		
		r=new Reserva();
		r.setNumCasa(7);
		r.setNumReserva("5");
		r.setPrecioTotal(1032);
		esperado.add(r);
		
		r=new Reserva();
		r.setNumCasa(4);
		r.setNumReserva("9");
		r.setPrecioTotal(34);
		esperado.add(r);
		
		r=new Reserva();
		r.setNumCasa(4);
		r.setNumReserva("12");
		r.setPrecioTotal(1290);
		esperado.add(r);
		
		r = new Reserva();
		r.setNumCasa(3);
		r.setNumReserva("15");
		r.setPrecioTotal(89);
		esperado.add(r);
		
		r=new Reserva();
		r.setNumCasa(5);
		r.setNumReserva("25");
		r.setPrecioTotal(429);
		esperado.add(r);
		
		//Vector obtenido
		Vector<Reserva> obtenido = gestorBD.seleccionarReservas(fechaIni, fechaFin);
		boolean b = true;
		int i=0;
		while(b && i<obtenido.size()){
			Reserva r1 = esperado.elementAt(i); 
			Reserva r2 = obtenido.elementAt(i);
			if(r1.getNumCasa()!=r2.getNumCasa() || !(r1.getNumReserva().equals(r2.getNumReserva())) || r1.getPrecioTotal()!=r2.getPrecioTotal()){
				b = false;
			}
			i++;
		}
		assertTrue(b);
			
	}
	
	/*
	 * En esta prueba se verifica que salen todas las ofertas que se han indicado para el número de reserva 5 ordenados ascendentemente por
	 * fecha de inicio de la oferta.
	 */
	
	public void test_seleccionar_ofertas_ord_fechaIni (){
		
		//Entrada
		Vector<Oferta> esperado = new Vector<Oferta>();
		Oferta f;
		String nReserva = "5";
		
		//Resultado esperado
		f = new Oferta();
		f.setDiaIni(new java.sql.Date ((new GregorianCalendar(2009,4,1)).getTime().getTime()));
		f.setDiaFin(new java.sql.Date ((new GregorianCalendar(2009,4,5)).getTime().getTime()));
		f.setPrecio(1000);
		f.setNumOferta("111");
		f.setNumReserva("5");
		esperado.add(f);
					
		f= new Oferta();
		f.setDiaIni(new java.sql.Date ((new GregorianCalendar(2009,4,5)).getTime().getTime()));
		f.setDiaFin(new java.sql.Date ((new GregorianCalendar(2009,4,10)).getTime().getTime()));
		f.setPrecio(25);
		f.setNumOferta("112");
		f.setNumReserva("5");
		esperado.add(f);
		
		f= new Oferta();
		f.setDiaIni(new java.sql.Date ((new GregorianCalendar(2009,4,10)).getTime().getTime()));
		f.setDiaFin(new java.sql.Date ((new GregorianCalendar(2009,4,15)).getTime().getTime()));
		f.setPrecio(7);
		f.setNumOferta("113");
		f.setNumReserva("5");
		esperado.add(f);
		
		//Resultado obtenido
		Vector<Oferta> obtenido = new Vector<Oferta>();
		obtenido = gestorBD.seleccionarOfertas(nReserva);
		
		boolean b = true;
		int i=0;
		while(b && i<obtenido.size()){
			Oferta r1 = esperado.elementAt(i); 
			Oferta r2 = obtenido.elementAt(i);
			if(!(r1.getNumOferta().equals(r2.getNumOferta())) || !(r1.getNumReserva().equals(r2.getNumReserva())) || r1.getPrecio()!=r2.getPrecio()){
				b = false;
			}
			i++;
		}
		assertTrue(b);
	}
	
	/*
	 * En esta prueba se verifica que en el caso de que no existe el número de reserva indicado
	 * no se devuelve ninguna oferta asociada a la misma, pero tampoco presenta un error. 
	 * Se probará con el número de reserva 100.
	 */
	
	public void test_seleccionar_ofertas_numReserva_invalido (){
		
		//Entrada
		Vector<Oferta> esperado;
		String nReserva = "100";
		
		//Resultado esperado
		esperado  = new Vector<Oferta>();
		
		//Resultado obtenido
		Vector<Oferta> obtenido = new Vector<Oferta>();
		obtenido = gestorBD.seleccionarOfertas(nReserva);
		
		boolean b = true;
		int i=0;
		while(b && i<obtenido.size()){
			Oferta r1 = esperado.elementAt(i); 
			Oferta r2 = obtenido.elementAt(i);
			if(!(r1.getNumOferta().equals(r2.getNumOferta())) || !(r1.getNumReserva().equals(r2.getNumReserva())) || r1.getPrecio()!=r2.getPrecio()){
				b = false;
			}
			i++;
		}
		assertTrue(b);
	}
	
	/*
	 * En esta prueba se verifica que se realizan las anulaciones de la reserva número 5.
	 * Para ello se eliminan todas las ofertas de la reserva indicada y se comprueba que al seleccionar esa
	 * misma reserva el vector resultante estará vacío.
	 */
	public void test_anularReservas(){
		//Entrada
		Vector<Oferta> ofertas = new Vector<Oferta>();
		Vector<Oferta> reservas= new Vector<Oferta>();
		
		Oferta f;
		
		f = new Oferta();
		f.setDiaIni(new java.sql.Date ((new GregorianCalendar(2009,4,1)).getTime().getTime()));
		f.setDiaFin(new java.sql.Date ((new GregorianCalendar(2009,4,5)).getTime().getTime()));
		f.setPrecio(1000);
		f.setNumOferta("111");
		f.setNumReserva("5");
		ofertas.add(f);
			
		f = new Oferta();
		f.setDiaIni(new java.sql.Date ((new GregorianCalendar(2009,4,5)).getTime().getTime()));
		f.setDiaFin(new java.sql.Date ((new GregorianCalendar(2009,4,10)).getTime().getTime()));
		f.setPrecio(25);
		f.setNumOferta("112");
		f.setNumReserva("5");
		ofertas.add(f);
		
		f = new Oferta();
		f.setDiaIni(new java.sql.Date ((new GregorianCalendar(2009,4,10)).getTime().getTime()));
		f.setDiaFin(new java.sql.Date ((new GregorianCalendar(2009,4,15)).getTime().getTime()));
		f.setPrecio(7);
		f.setNumOferta("113");
		f.setNumReserva("5");
		ofertas.add(f);
		
		try {
			
			gestorBD.anularReserva("5", ofertas, reservas);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		Vector<Reserva> obtenido = gestorBD.seleccionarReservas(new java.sql.Date ((new GregorianCalendar(2009,4,1)).getTime().getTime()),new java.sql.Date ((new GregorianCalendar(2009,4,15)).getTime().getTime()));

		assertTrue(obtenido.isEmpty());
	}
	
	public void test_esAdministrador() {
		
	}
}
