package casarural;

import java.io.Serializable;

public class Recogida implements Serializable {

	private static final long serialVersionUID = -1164979839011462914L;

	private int numRecogida;
	private String tipo;
	private String direccion;
	private String nombre;
	
	public int getNumRecogida() {
		return numRecogida;
	}
	
	public void setNumRecogida(int numRecogida) {
		this.numRecogida = numRecogida;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
