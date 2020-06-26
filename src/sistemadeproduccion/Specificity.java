package sistemadeproduccion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import chatbot.ChatbotEnvironment;

/**
 * Clase que implementa el criterio de especificidad.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class Specificity{

	public static ArrayList<Rule> ejecutarCriterio () {
		
		int mayorEspecificidad = -1;
		ArrayList<Rule> reglasAEjecutar = new ArrayList<Rule>();
		for(Rule r : ChatbotEnvironment.reglasMemoriaProduccion) {
			System.out.println("Especificidad de "+ r.getId() + " :" +r.getSpecificity());
			if(r.getSpecificity() > mayorEspecificidad) {
				mayorEspecificidad = r.getSpecificity();
				reglasAEjecutar.clear();
				reglasAEjecutar.add(r);
			}
			else if(r.getSpecificity() == mayorEspecificidad){
				reglasAEjecutar.add(r);
			}
		}
		
		return reglasAEjecutar;
	}

	@Override
	public String toString() {
		return "Specificity (Especificidad)";
	}

}
