package casarural;

import java.io.Serializable;

public class Recorrido implements Serializable {

	private static final long serialVersionUID = 4658048871886830544L;

	private int numRecorrido;
	
	public int getNumRecorrido() {
		return numRecorrido;
	}
	
	public void setNumRecorrido(int numRecorrido) {
		this.numRecorrido = numRecorrido;
	}
	
	@Override
	public String toString() {
		return String.valueOf(numRecorrido);
	}
}
