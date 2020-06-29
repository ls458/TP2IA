package sistemadeproduccion;

import java.util.ArrayList;

import chatbot.ChatbotAgent;
import chatbot.ChatbotEnvironment;
import frsf.cidisi.faia.environment.Environment;

public class GestorDeFrases {

	public static ArrayList<String> palabrasUtiles (String textoUsuario){
		ArrayList<String> palabras = new ArrayList<String>();
		
		textoUsuario = textoUsuario.toLowerCase().replace('�', 'a').replace('�', 'e').replace('�', 'i').replace('�', 'o').replace('�', 'u')
				.replace(',', ' ').replace('!', ' ').replace('�', ' ').replace('.', ' ').replace('?', ' ').replace('�', ' ').replace(';', ' ')
				.replace("santa fe", "santafe").replace("nos vemos", "nosvemos").replace("hasta luego", "hastaluego").replace("hasta pronto", "hastapronto");
		String[] palabrasBase = textoUsuario.split(" ");
		
		String aux;
		for(int i=0; i<palabrasBase.length; i++) {
			if(palabrasBase[i]!=null && !palabrasBase[i].equals("")) {
				System.out.println(palabrasBase[i]);
				aux = unificadorPalabras(palabrasBase[i]);
				if(aux != null) {
					palabras.add(aux);
				}
			}
		}
		return palabras;
	}
	
	public static String unificadorPalabras(String palabra){
		
		for(Tema t : ChatbotAgent.listaTemas ) {
			if(t.sinonimos.contains(palabra)) {
				System.out.println("Cambio: " +palabra+ " "+t.nombre);
				return t.nombre;
			}
		}
		
		return null;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void matcheoRules(ArrayList<String> palabras) {
		
		for(Rule r : ChatbotEnvironment.reglasMemoriaProduccion) {
			r.specificity = 0;
			for(Tema t : r.listaTemas){
					if(palabras.contains(t.nombre)) {
						r.specificity++;
					}
					else {
						r.specificity = 0;
						break;
					}
			}
		}
		
	}
	
}
