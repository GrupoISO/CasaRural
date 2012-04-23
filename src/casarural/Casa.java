package casarural;
import java.io.*;

public class Casa implements Serializable {
	
	private static final long serialVersionUID = -5804353691155232654L;
	
	private int numCasa;
	private String propietario;
	private String descripcion;
	private int numPlazasGaraje;
	private int numCocinas;
	private int numBanos;
	private int numDormitorios;
	private String poblacion;

	public Casa() {
	}
	
	
	public boolean equals(Casa c) {
		if (c == null) return false;
		else return (c.getNumCasa() == this.getNumCasa()) &&
					(c.getDescripcion().equals(this.getDescripcion())) &&
					(c.getPoblacion().equals(this.getPoblacion())) &&
					(c.getPropietario().equals(this.getPropietario()));
	}


	/**
	 * @return el código de la casa
	 */
	public int getNumCasa() {
		return this.numCasa;
	}


	/**
	 * @param numCasa el código de la casa
	 */
	public void setNumCasa(int numCas) {
		this.numCasa = numCas;
	}


	/**
	 * @return el propietario
	 */
	public String getPropietario() {
		return propietario;
	}


	/**
	 * @param propietario el propietario
	 */
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}


	/**
	 * @return la descripción
	 */
	public String getDescripcion() {
		return descripcion;
	}


	/**
	 * @param description la descripción
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	/**
	 * @return el número de plazas de garaje
	 */
	public int getNumPlazasGaraje() {
		return numPlazasGaraje;
	}


	/**
	 * @param numPlazasGaraje el número de plazas de garaje
	 */
	public void setNumPlazasGaraje(int numPlazasGaraje) {
		this.numPlazasGaraje = numPlazasGaraje;
	}


	/**
	 * @return el número de cocinas
	 */
	public int getNumCocinas() {
		return numCocinas;
	}


	/**
	 * @param numCocinas el número de cocinas
	 */
	public void setNumCocinas(int numCocinas) {
		this.numCocinas = numCocinas;
	}


	/**
	 * @return el número de baños
	 */
	public int getNumBanos() {
		return numBanos;
	}


	/**
	 * @param numBanos el número de baños
	 */
	public void setNumBanos(int numBanos) {
		this.numBanos = numBanos;
	}


	/**
	 * @return el número de dormitorios
	 */
	public int getNumDormitorios() {
		return numDormitorios;
	}


	/**
	 * @param numDormitorios el número de dormitorios
	 */
	public void setNumDormitorios(int numDormitorios) {
		this.numDormitorios = numDormitorios;
	}


	/**
	 * @return la población
	 */
	public String getPoblacion() {
		return poblacion;
	}


	/**
	 * @param poblacion la población
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
}