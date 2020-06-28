package sistemadeproduccion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import chatbot.ChatbotEnvironment;
import tp2ia.InterfaceUpdater;

/**
 * Clase que implementa el criterio de no duplicacion.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class NoDuplication {
	
	public static ArrayList<Rule> ejecutarCriterio (ArrayList<Rule> listaReglas) {
		
		//Veo que todas las reglas de la lista tengan el mismo antecedente
		ArrayList<Tema> listaTemas = listaReglas.get(0).getListaTemas();
		
		boolean antecedenteCoincide = true;
		for(Rule r : listaReglas) {
			for(int i=0; i<listaTemas.size(); i++) {
				if(!r.listaTemas.get(i).equals(listaTemas.get(i))) {
					antecedenteCoincide = false;
					break;
				}
			}
		}
		
		if(antecedenteCoincide) {
			ArrayList<Rule> reglasAEjecutar = new ArrayList<Rule>();
			System.out.println("Antedcedente sí coincide!");
			//Si todas las reglas tienen el mismo antecedente, verifico la no duplicación
			Integer minNoDuplication = Integer.MAX_VALUE;
			for(Rule r : listaReglas) {
				if(r.getNoDuplication() < minNoDuplication) {
					minNoDuplication = r.getNoDuplication();
					reglasAEjecutar.clear();
					reglasAEjecutar.add(r);
				}
				else if(r.getNoDuplication() == minNoDuplication){
					reglasAEjecutar.add(r);
				}
			}
			
			for(Rule r : reglasAEjecutar) {
				InterfaceUpdater.addToLog("Regla salida no duplicación [id: " + r.id + "]: " + r.toString());
			}
			
			return reglasAEjecutar;
			
		}
		
		for(Rule r : listaReglas) {
			InterfaceUpdater.addToLog("Regla salida no duplicación [id: " + r.id + "]: " + r.toString());
		}
		
		System.out.println("Antedcedente no coincide!");
		return listaReglas;
		
	}

	@Override
	public String toString() {	
		return "No Duplication (No duplicación)";
	}

}
