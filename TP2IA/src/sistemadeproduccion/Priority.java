package sistemadeproduccion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import chatbot.ChatbotEnvironment;

/**
 * Clase que implementa el criterio de prioridad.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class Priority {

	public static ArrayList<Rule> ejecutarCriterio (ArrayList<Rule> listaReglas) {
		
		int mayorPrioridad = -1;
		ArrayList<Rule> reglasAEjecutar = new ArrayList<Rule>();
		for(Rule r : listaReglas) {
			System.out.println("Especificidad de "+ r.getId() + " :" +r.getSpecificity());
			if(r.getPriority() > mayorPrioridad) {
				mayorPrioridad = r.getPriority();
				reglasAEjecutar.clear();
				reglasAEjecutar.add(r);
			}
			else if(r.getSpecificity() == mayorPrioridad){
				reglasAEjecutar.add(r);
			}
		}
		
		return reglasAEjecutar;
	}

	@Override
	public String toString() {
		return "Priority (Prioridad)";
	}

}
