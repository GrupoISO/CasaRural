package casarural;

import java.rmi.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class ServicioRecogidaBean {

	InterfazFachada logNeg;
	
	/**Constructor de la clase CrearrecorridoBean
	 * @param ninguno
	 * @return constructor
	 */
	public ServicioRecogidaBean(){
		try
	    {
	      logNeg = ((InterfazFachada)Naming.lookup("rmi://localhost:1099/CasaRural"));
	    }
	    catch(Exception e) {System.out.println("Error al conseguir la logica del negocio: "+e.toString());}
	}
	
	/**Obtiene una lista formada por los servicios actuales disponibles
	 * 
	 * @param numCasa El numero de la Casa Rural, al que estan asociados los servicios
	 * @param fechaElegida La fecha elegida para la reserva y estaran disponibles los servicios
	 * @return Una lista, compuesta por la clase Servicio
	 */
	public List<Servicio> MostrarServicios(int numCasa, java.sql.Date fechaElegida){
		try{
			return logNeg.mostrarServicios(numCasa, fechaElegida);
		} catch(Exception ex) {
			ex.getStackTrace();
			return null;
		}
	}
	
	/**Crea una reserva y asigna un servicio a la misma
	 *
	 * @param Reserva La reserva que se va a crear 
	 * @param idServicio Identificador del servicio que se asignara a la reserva
	 * @param numPlazas Numero de plazas que se quiere reservar
	 * @return
	 */
	public boolean transaccionDeReserva(Oferta reserva, String numTfno, int idServicio, int numPlazas){
		try{
//			List<Oferta> reservasTotales = new ArrayList<Oferta>();
//			reservasTotales.add(reserva);
			return logNeg.transaccionDeReserva(reserva, numTfno, idServicio, numPlazas);
		}catch(Exception ex){
			ex.getStackTrace();
			return false;
		}
	}
}
