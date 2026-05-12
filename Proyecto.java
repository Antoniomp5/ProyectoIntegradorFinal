package prog.ud8.proyecto;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Proyecto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-----------------");
		System.out.print("Nombre de usuario: ");
		String usuario = sc.nextLine();
		System.out.println("-----------------");
		
		System.out.println("bienvenido, " + usuario);
		
		Map<String, Integer> juegos = new HashMap<>();
		
		System.out.println("-----------------");
		System.out.println("Lista de juegos: ");
		juegos.put("minecraft", 1);
		juegos.put("gta7", 2);
		juegos.put("red dead redeptiom", 3);
		juegos.put("csgo", 4);
		juegos.put("resident evil 8", 5);
		juegos.put("subnautica", 6);
		
		
		Set<String> claves = juegos.keySet();
		mostrarJuego(juegos);
		System.out.println("-----------------");
	}
	
	public static void mostrarJuego(Map<String, Integer> j) {
		for (String n : j.keySet()) {
			System.out.println(n);
		}
		
	}
	
}
