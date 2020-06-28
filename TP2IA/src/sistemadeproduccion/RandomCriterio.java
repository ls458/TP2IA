package sistemadeproduccion;

import java.util.ArrayList;
import java.util.LinkedList;

import tp2ia.InterfaceUpdater;

/**
 * Clase que implementa el criterio aleatorio.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class RandomCriterio {

	public static ArrayList<Rule> ejecutarCriterio (ArrayList<Rule> listaReglas) {
		ArrayList<Rule> listaRetorno = new ArrayList<Rule>();
		 Integer valorAleatorio = (int) (Math.random()*(listaReglas.size()-1));
		 listaRetorno.add(listaReglas.get(valorAleatorio));
		 
		 for(Rule r : listaRetorno) {
				InterfaceUpdater.addToLog("Regla salida random [id: " + r.id + "]: " + r.toString());
			}
		 
		 return listaRetorno;
	}

	@Override
	public String toString() {
		return "Random (Aleatorio)";
	}

}
