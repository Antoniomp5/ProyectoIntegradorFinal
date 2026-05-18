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
		Juegos Minecraft = new Juegos("Minecraft", "Mojang", 90, 1990, 2);
		Juegos gta7 = new Juegos("Gta7", "Rockstar Games", 190, 1290, 6);
		Juegos RD = new Juegos("Red Dead Redeptiom ", "BenaocazSL", 10, 280, 5);
		Juegos CSGO = new Juegos("csgo", "Vale", 0, 3, 0);
		Juegos RE8 = new Juegos("Resident Evil 8", "Mr.LinuxFC", 8, 8, 8);
		Juegos SUB = new Juegos("Subnautica", "AnaODOOPutesquiCPSSH", 17, 0, 14);
		
		Map<Integer, Juegos> juegos = new HashMap<>();
		
		System.out.println("-----------------");
		System.out.println("Lista de juegos: ");
		juegos.put(1, Minecraft);
		juegos.put(2, gta7);
		juegos.put(3, RD);
		juegos.put(4, CSGO);
		juegos.put(5, RE8);
		juegos.put(6, SUB);
		
		
		Set<Integer> claves = juegos.keySet();
		mostrarJuego(juegos);
		
		System.out.println("-----------------");
		System.out.println("¿Quieres comprar un juego?");
		System.out.print(":");
		String respuesta = sc.nextLine();
		respuesta.toLowerCase();
		System.out.println("-----------------");
		if (respuesta == "si") {
			System.out.println("¿Que juego quieres comprar?");
			String juego = sc.nextLine();
		}
	}
	
	public static void mostrarJuego(Map<Integer, Juegos> j) {
	    for (Integer n : j.keySet()) {
	        System.out.println(n + " -> " + j.get(n));
	    }
	}
	
}
