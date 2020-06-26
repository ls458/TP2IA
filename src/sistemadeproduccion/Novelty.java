package sistemadeproduccion;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase que implementa el criterio de novedad.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class Novelty extends Criteria {

	@Override
	public LinkedList<PeerRuleData> apply(LinkedList<PeerRuleData> list) {

		int novelty, mayor = 0;		
    	for(Iterator<PeerRuleData> i = list.iterator(); i.hasNext();)
    	{
    		Rule r = i.next().getRule();
    		novelty = r.getNovelty();
    		if(novelty > mayor) mayor = novelty;
    	}
    	LinkedList<PeerRuleData> ret = new LinkedList<PeerRuleData>();
    	for(Iterator<PeerRuleData> i = list.iterator(); i.hasNext();)
    	{
    		PeerRuleData prd = i.next();
    		Rule r = prd.getRule();
    		if(r.getNovelty() == mayor) ret.add(prd);
    	}    	
		return ret;
		
	}

	@Override
	public String toString() {
		return "Novelty (Novedad)";
	}

}
