package sistemadeproduccion;

import java.util.ArrayList;

/**
 * Clase que modela elas reglas del sistema de produccion.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class Rule {
	
	public static final int IMPLICAREGLASYELIMINALISTA=0;
	public static final int IMPLICAREGLASYELIMINAANTERIORES=1;
	
//	Object condition;
//	Object then;
	ArrayList<Tema> listaTemas;
	Integer acciones;//  0:implicar reglas 
					 //  1:implicar reglas y borrar su antecedente de la MP
					 //  2:implicar reglas y borrar todas las reglas anteriores de la MP
	ArrayList<Rule> reglasImplicadas;
	ArrayList<Integer> idsReglasAEliminar;
	public String Respuesta;
	int id;
	int specificity;
	int priority;
	int noDuplication;
	
	public Rule(){	
		reglasImplicadas = new ArrayList<Rule>();
		idsReglasAEliminar = new ArrayList<Integer>();
		acciones = IMPLICAREGLASYELIMINALISTA;
		specificity = 0;
		priority = 0;
		noDuplication = 0;
	}
	
	public ArrayList<Integer> getIdsReglasAEliminar() {
		return idsReglasAEliminar;
	}

	public void setIdsReglasAEliminar(ArrayList<Integer> idsReglasAEliminar) {
		this.idsReglasAEliminar = idsReglasAEliminar;
	}

	public Integer getId(){
		return new Integer(id);
	}	
	
	public void setId(int identificador){
		id = identificador;
	}
	
	public int getSpecificity(){
		return specificity;
	}	
	
	public void setSpecificity(int s){
		specificity = s;
	}
	public Integer getPriority(){
		return priority;
	}	
	
	public void setPriority(int p){
		priority = p;
	}
	
//	public void setCondition(Object o){
//		condition = o;
//	}
//	
//	public Object getCondition(){
//		return condition;
//	}
//	
//	public void setThen(Object t){
//		then = t;
//	}
//	
//	public Object getThen(){
//		return then;
//	}
	
	public int getNoDuplication() {
		return noDuplication;
	}

	public void setNoDuplication(int noDuplication) {
		this.noDuplication = noDuplication;
	}

	public boolean equals(Rule aRule){		
		return (id==aRule.getId().intValue());
	}
	
//	public abstract boolean isActive(Object status);

	public ArrayList<Tema> getListaTemas() {
		return listaTemas;
	}

	public void setListaTemas(ArrayList<Tema> listaTemas) {
		this.listaTemas = listaTemas;
	}

	public ArrayList<Rule> getReglasImplicadas() {
		return reglasImplicadas;
	}

	public void setReglasImplicadas(ArrayList<Rule> reglasImplicadas) {
		this.reglasImplicadas = reglasImplicadas;
	}

	public Integer getAcciones() {
		return acciones;
	}

	public void setAcciones(Integer acciones) {
		this.acciones = acciones;
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append('(');
		for(Tema t : listaTemas) {
			if(listaTemas.indexOf(t)!=0)
				 sb.append(',');
			sb.append(t.nombre);
		}
		sb.append(')');
		return sb.toString();
	}
}
