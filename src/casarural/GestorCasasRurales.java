package casarural;

import java.util.ArrayList;
import java.util.List;


public final class GestorCasasRurales {
	GestorBD gbd;
	private static GestorCasasRurales elGestorCasasRurales = new GestorCasasRurales();

	private GestorCasasRurales() {
		gbd = GestorBD.getInstance();
	}

	/**
	 * Devuelve una instancia de la clase GestorCasasRurales
	 * 
	 * @param Ninguno
	 * @return El gestor de casas rurales
	 */
	public static GestorCasasRurales getInstance() {
		return elGestorCasasRurales;
	}

	/**
	 * Obtener el numero de cuenta corriente a partir de una casa
	 * 
	 * @param Numero
	 *            de casa
	 * @return Numero de cuenta corriente
	 */
	public String getNumCuentaCorriente(int numCasa) {
		try {

			return gbd.seleccionarPropietario(numCasa).getNumCuentaCorriente();
		} catch (Exception e) {
			System.out.println("Error accediendo al Gestor de BD: "
					+ e.toString());
			return null;
		}
	}

	/**
	 * Obtiene el codigo de las casas vinculadas a una cuenta
	 * 
	 * @param Numero
	 *            de cuenta
	 * @return Vector de codigos de casa
	 */
	public List<Integer> getCodigosCasas(String cuentaSistema) {
		List<Casa> v2 = new ArrayList<Casa>();
		try {
			v2 = gbd.seleccionarCasas(cuentaSistema);
		} catch (Exception e) {
			System.out.println("Error accediendo al Gestor de BD: "
					+ e.toString());
		}
		
		List<Integer> v3 = new ArrayList<Integer>();
		for (Casa ic: v2) {
			v3.add(new Integer(ic.getNumCasa()));
		}

		return v3;
	}

	public List<Integer> getCodigosCasas() {
		List<Casa> v2 = new ArrayList<Casa>();
		try {
			v2 = gbd.seleccionarCasas();
		} catch (Exception e) {
			System.out.println("Error accediendo al Gestor de BD: "
					+ e.toString());
		}
		List<Integer> v3 = new ArrayList<Integer>();
		for (Casa ic: v2) {
			v3.add(new Integer(ic.getNumCasa()));
		}

		return v3;
	}
}