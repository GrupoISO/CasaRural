package casarural;
import java.io.*;

public class Servicio implements Serializable {
	
	private int numServicio;
	private java.sql.Date fecha;
	private java.sql.Time hora;
	private int numRecogida;
	private int numPlazas;
	private float precio;
	private int numPlazasReservadas;
	private int numRecorrido;
	private String tipoRecogida;
	private String direccionRecogida;
	private String nombreRecogida;
	

	public Servicio() {
	}


	/**
	 * @return el número identificador del servicio
	 */
	public int getNumServicio() {
		return numServicio;
	}


	/**
	 * @param numServicio el número identificador del servicio
	 */
	public void setNumServicio(int numServicio) {
		this.numServicio = numServicio;
	}


	/**
	 * @return la fecha en la que se realiza el servicio
	 */
	public java.sql.Date getFecha() {
		return fecha;
	}


	/**
	 * @param fecha la fecha en la que se realiza el servicio
	 */
	public void setFecha(java.sql.Date fecha) {
		this.fecha = fecha;
	}


	/**
	 * @return la hora en la que se realiza el servicio
	 */
	public java.sql.Time getHora() {
		return hora;
	}


	/**
	 * @param hora la hora en la que se realiza el servicio
	 */
	public void setHora(java.sql.Time hora) {
		this.hora = hora;
	}


	/**
	 * @return el número identificador del lugar de recogida
	 */
	public int getNumRecogida() {
		return numRecogida;
	}


	/**
	 * @param numRecogida el número identificador del lugar de recogida
	 */
	public void setNumRecogida(int numRecogida) {
		this.numRecogida = numRecogida;
	}


	/**
	 * @return el número de plazas totales
	 */
	public int getNumPlazas() {
		return numPlazas;
	}


	/**
	 * @param numPlazas el número de plazas totales
	 */
	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}


	/**
	 * @return el precio del servicio
	 */
	public float getPrecio() {
		return precio;
	}


	/**
	 * @param precio el precio del servicio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}


	/**
	 * @return el número de plazas reservadas
	 */
	public int getNumPlazasReservadas() {
		return numPlazasReservadas;
	}


	/**
	 * @param numPlazasReservadas el número de plazas reservadas
	 */
	public void setNumPlazasReservadas(int numPlazasReservadas) {
		this.numPlazasReservadas = numPlazasReservadas;
	}


	/**
	 * @return el número identificador del recorrido
	 */
	public int getNumRecorrido() {
		return numRecorrido;
	}


	/**
	 * @param numRecorrido el número identificador del recorrido
	 */
	public void setNumRecorrido(int numRecorrido) {
		this.numRecorrido = numRecorrido;
	}


	/**
	 * @return el tipo de lugar de recogida
	 */
	public String getTipoRecogida() {
		return tipoRecogida;
	}


	/**
	 * @param tipoRecogida el tipo de lugar de recogida
	 */
	public void setTipoRecogida(String tipoRecogida) {
		this.tipoRecogida = tipoRecogida;
	}


	/**
	 * @return la dirección del lugar de recogida
	 */
	public String getDireccionRecogida() {
		return direccionRecogida;
	}


	/**
	 * @param direccionRecogida la dirección del lugar de recogida
	 */
	public void setDireccionRecogida(String direccionRecogida) {
		this.direccionRecogida = direccionRecogida;
	}


	/**
	 * @return el nombre del lugar de recogida
	 */
	public String getNombreRecogida() {
		return nombreRecogida;
	}


	/**
	 * @param nombreRecogida el nombre del lugar de recogida
	 */
	public void setNombreRecogida(String nombreRecogida) {
		this.nombreRecogida = nombreRecogida;
	}

}