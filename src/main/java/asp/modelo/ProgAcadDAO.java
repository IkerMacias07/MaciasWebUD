package asp.modelo;

import java.util.ArrayList;

public class ProgAcadDAO {

	public static ArrayList<ProgAcad> lista_P = new ArrayList<ProgAcad>();

	public static void cargaDatos() {
		if(lista_P.isEmpty()) {
			System.out.println("Lista vacia");
			lista_P.add( new ProgAcad(0, "Ingeniería de Sistemas"));
			lista_P.add( new ProgAcad(1, "Ingeniería de Industrial"));
			lista_P.add( new ProgAcad(2, "Ingeniería de Telemática"));
			lista_P.add( new ProgAcad(3, "Ingeniería de Electronica"));
			lista_P.add( new ProgAcad(4, "Derecho"));
		
		}
		
	}
}
