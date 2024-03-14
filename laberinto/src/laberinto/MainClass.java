package laberinto;

import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		
		Laberinto lab1 = new Laberinto(60,80,30);
		
		int semilla = 23;
		lab1.generarLaberinto(23);

	
		ArrayList<Nodo> sol = lab1.resolverSolucion();
		lab1.pintarSolucion(sol);

		
	}

}
