package chatbotsistemadeproduccion;

import java.util.Iterator;
import java.util.LinkedList;
import sistemadeproduccion.Criteria;
import sistemadeproduccion.PeerRuleData;
import sistemadeproduccion.ProductionSystem;
import frsf.ia.tp.chatbot.graph.Regla;
import frsf.ia.tp.chatbot.preprocessing.Frase;
import frsf.ia.tp.chatbot.preprocessing.Oracion;

/**
 * Clase que implementa el solver especifico del Chatbot para que el matching 
 * le de el conjunto de reglas obtenidas de la busqueda. 
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class ChatbotProductionSystem extends ProductionSystem{

	LinkedList<Regla> matcheo;
	Oracion perc;
	
	public ChatbotProductionSystem(LinkedList<Criteria> s, LinkedList<Regla> m,Oracion o) {
		super(s);
		matcheo = m;
		perc = o;
	}

	@Override
	protected LinkedList<PeerRuleData> match(){
		LinkedList<PeerRuleData> ret = new LinkedList<PeerRuleData>();
		for(Iterator<Regla> i = matcheo.iterator();i.hasNext();)
		{
			if(perc==null) perc = new Frase();
			PeerRuleData pdr = new PeerRuleData(i.next(),perc);
			ret.add(pdr);
		}
		return ret;
	}
	
}
