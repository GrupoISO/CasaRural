/**
 * 
 */
package casarural;

import java.rmi.*;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * @author Saioa
 *
 */
public class AnularReservaBean {

	InterfazFachada logNeg;
	
	private String diaIni;
	private Date diaIniDate;
	private String diaFin;
	private Date diaFinDate;
	private String[] anulaciones;
	private Vector<Reserva> reservas;
	/**
	 * Constructor. Se realizan las operaciones necesarias para trabajar mediante RMI
	 * 
	 */
	public AnularReservaBean() {
		final String IPMAQUINA = "localhost";
		// Operaciones necesarias para trabajar mediante RMI
		try {
			//System.setSecurityManager(new RMISecurityManager());
			// Nombre servicio
			String servicio = "/CasaRural";
			// Numero puerto
			int puerto = InterfazFachada.numPuerto;
			// IP
			String maquina = IPMAQUINA;
			logNeg = (InterfazFachada) Naming.lookup("rmi://" + maquina + ":"
					+ puerto + servicio);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	/**
	 * Devuelve el valor del atributo diaIni
	 * 
	 * @return diaIni, String
	 */
	public String getDiaIni() {
		return diaIni;
	}
	
	/**
	 * Establece el valor del atributo diaIni con el valor pasado y también el del atributo diaIniDate (tipo Date)
	 * 
	 * @param fecha
	 */
	public void setDiaIni(String fecha) {
		diaIni=fecha;
	    StringTokenizer st = new StringTokenizer (fecha,"/");
	    int dia = Integer.parseInt(st.nextToken());
	    int mes = Integer.parseInt(st.nextToken()) - 1;
	    int anio = Integer.parseInt(st.nextToken());
	    GregorianCalendar gc = new GregorianCalendar(anio,mes,dia);
	    diaIniDate = new Date(gc.getTime().getTime());
	}
	
	/**
	 * Devuelve el valor del atributo diaIniDate
	 * 
	 * @return diaIniDate, Date
	 */
	public Date getDiaIniDate() {
		return diaIniDate;
	}
	
	/**
	 * Devuelve el valor del parámetro diaFin.
	 * 
	 * @return diaFin, String
	 */
	public String getDiaFin() {
		return diaFin;
	}
	
	/**
	 * Establece el valor del atributo diaFin con el valor pasado, y también establece el valor de diaFinDate
	 * 
	 * @param fecha
	 */
	public void setDiaFin(String fecha) {
		diaFin=fecha;
	    StringTokenizer st = new StringTokenizer (fecha,"/");
	    int dia = Integer.parseInt(st.nextToken());
	    int mes = Integer.parseInt(st.nextToken()) - 1;
	    int anio = Integer.parseInt(st.nextToken());
	    GregorianCalendar gc = new GregorianCalendar(anio,mes,dia);
	    diaFinDate = new Date(gc.getTime().getTime());
	}
	
	/**
	 * Devuelve el valor del atributo diaFinDate
	 * 
	 * @return diaFinDate, Date
	 */
	public Date getDiaFinDate() {
		return diaFinDate;
	}
	
	/**
	 * Establece el valor del parámetro anulaciones, que indica las reservas que se tendrán que anular
	 * 
	 * @param lista, String[]
	 */
	public void setAnulaciones(String[] lista){
		this.anulaciones=lista;
	}
	
	/**
	 * Devuelve el vector con las reservas entre las fechas indicadas en los atributos diaIniDate y diaFinDate
	 * 
	 * @return reservas, Vector<Reserva>
	 */
	public Vector<Reserva> getReservas(){
		try {
			reservas = (Vector<Reserva>)logNeg.obtReservas(diaIniDate, diaFinDate);
		} catch (RemoteException e) {
			System.out.println("ERROR: "+e.toString());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ERROR: "+e.toString());
			e.printStackTrace();
		}
		
		return reservas;
	}
	
	/**
	 * Devuelve un array de enteros con los resultados tras la anulación. 0 indica anulación correcta,
	 * 1 anulación incorrecta y 2 que se devolverá el 20%
	 * 
	 * @return int[]
	 */
	public int[] getResultado(){
		int[] res = null;
		try {
			res = logNeg.anularReservas(anulaciones);
		} catch (RemoteException e) {
			System.out.println("ERROR: "+e.toString());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ERROR: "+e.toString());
			e.printStackTrace();
		}
		return res;
	}
}
