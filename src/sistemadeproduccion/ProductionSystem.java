package sistemadeproduccion;

import java.util.Iterator;
import java.util.LinkedList;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.solver.Solve;

/**
 * Clase que implementa el solver del sistema de producción.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class ProductionSystem extends Solve{

	//TODO Futuro: Agregar la MI, MP y MT.
	private LinkedList<Criteria> criteria;
	public static LinkedList<PeerRuleData> used = new LinkedList<PeerRuleData>();
	
	/**
	 * Constructor.
	 * Recibe las estrategias en el orden a ser aplicadas.
	 */
	public ProductionSystem(LinkedList<Criteria> s){
		criteria = s;
	}
	
	@Override
	public void showSolution() {
	}

	@Override
	public Action solve(Object[] params) throws Exception {

		PeerRuleData r;
		
		do
		{
			//Se obtienen las reglas activas
			LinkedList<PeerRuleData> activeRules = this.match();
			
			//Si no hay reglas activas se termina.
			if(activeRules.isEmpty()) return null;
			
			//Se resuelven los conflictos.
        	for(Iterator<Criteria> i = criteria.iterator(); i.hasNext();)
        	{
        		Criteria actualCriteria = i.next();
        		System.out.println("\nCriterio:" + actualCriteria.toString());
        		LinkedList<PeerRuleData> finalRules = actualCriteria.apply(activeRules);
        		if(finalRules.size()==0) System.out.print("Reglas en Conflicto: -");
        		else
        		{
        			System.out.print("Reglas en Conflicto: ");
                	for(Iterator<PeerRuleData> j = finalRules.iterator(); j.hasNext();)
                	{
                		System.out.print("(" + j.next().getRule().getId().toString() + ") ");
                	}
        			activeRules = finalRules;
        			if(activeRules.size()==1) break;
        		}
        	}
        	
        	//Se obtiene la regla elegida.
        	r = activeRules.getFirst();
        	
        	//Se ejecuta la regla.
        	this.ejecutar(r);
				
		} while(r.getRule().getType()!=0);

		return new ProductionSystemAction(r);
		
	}
	
	protected LinkedList<PeerRuleData> match(){
		//TODO Futuro: Hacer el match.
		return new LinkedList<PeerRuleData>();
	}
	
	protected void ejecutar(PeerRuleData r){
		used.add(r);
		if(r.getRule().getType()!=0)
		{
			//TODO Futuro: Hacer la actualizacion de la MT,MI y MP.
		}
	}

}
