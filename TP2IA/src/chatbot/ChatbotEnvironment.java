package chatbot;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import sistemadeproduccion.Rule;
import sistemadeproduccion.Tema;

public class ChatbotEnvironment extends Environment {
	
	/***Esta variable sirve únicamente para comunicar el hilo de la interface y el hilo de trabajo del chatbot*/
	public static String respuestaUsuario;
	
	public static ArrayList<Rule> reglasMemoriaProduccion = new ArrayList<Rule>();

	public static void inferencia (Rule regla) {
		
		switch (regla.getAcciones()){
			case 0:
			 	//1:implicar reglas y borrar reglas cuyo id's aparecen en su lista de id's de reglas a eliminar
				
				ArrayList<Integer> reglasAEliminar = regla.getIdsReglasAEliminar();
				for(Integer idEliminar : reglasAEliminar) {
					for(int i=0; i<reglasMemoriaProduccion.size() ;i++) {
						
						if(reglasMemoriaProduccion.get(i).getId().equals(idEliminar)) {
							System.out.println("olakease, camarada!: "+idEliminar);
							reglasMemoriaProduccion.remove(i);
						}
					}
				}
				
				reglasMemoriaProduccion.addAll(regla.getReglasImplicadas());

				break;
			case 1:
				//1:implicar reglas y borrar todas las reglas anteriores
				reglasMemoriaProduccion.clear();
				reglasMemoriaProduccion.addAll(regla.getReglasImplicadas());
			
		}
		
	}
	
	@Override
	public Perception getPercept() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
