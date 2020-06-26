package sistemadeproduccion;

import java.util.ArrayList;

public class Tema {
	
	String nombre;
	ArrayList<String> sinonimos;
	
	public Tema() {
		
	}
	
	public Tema(String nombre, ArrayList<String> sinonimos) {
		this.nombre = nombre;
		this.sinonimos = sinonimos;
	}
	
	public boolean equals(Tema tema) {
		
		return (this.nombre.equals(tema.nombre));
	}

}
