package sistemadeproduccion;

/**
 * Clase que implementa los pares que resultan de la ejecucion del match.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class PeerRuleData {
	
	Rule rule;
	Object data;
	
	public PeerRuleData(Rule r,Object d){
		rule = r;
		data = d;
	}
	
	public Rule getRule(){
		return rule;
	}
	
	public void setRule(Rule r){
		rule = r;
	}
	
	public Object getData(){
		return data;
	}
	
	public void setData(Object d){
		data = d;
	}
	
}
