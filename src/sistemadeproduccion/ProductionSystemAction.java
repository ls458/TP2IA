package sistemadeproduccion;

import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

/**
 * Clase que implementa las acciones que el sistema de produccion puede
 * devolverle al ambiente.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class ProductionSystemAction extends frsf.cidisi.faia.agent.Action {

	PeerRuleData rule;
	
	public ProductionSystemAction(PeerRuleData r){
		rule = r;
	}
	
	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est){
		//TODO Futuro: Esto esta armado para el Chatbot pero debería incorporarse en la clase Enviroment el metodo update.
		ChatbotEnvironmentState cest = (ChatbotEnvironmentState) est;
		cest.update(ast,rule);
		return cest;
	}

	@Override
	public String toString() {
		return "Ejecutar";
	}
	
	public PeerRuleData getPeerRuleData(){
		return rule;
	}

}
