package sistemadeproduccion;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Clase que implementa el criterio aleatorio.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class RandomCriterio {

	public static ArrayList<Rule> ejecutarCriterio (ArrayList<Rule> listaReglas) {
		ArrayList<Rule> listaRetorno = new ArrayList<Rule>();
		 Integer valorAleatorio = (int) (Math.random()*(listaReglas.size()-1));
		 listaRetorno.add(listaReglas.get(valorAleatorio));
		 
		 return listaRetorno;
	}

	@Override
	public String toString() {
		return "Random (Aleatorio)";
	}

}
