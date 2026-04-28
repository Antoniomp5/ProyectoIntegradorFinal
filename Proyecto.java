package prog.ud8.proyecto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Proyecto {

	public static void main(String[] args) {
		Map<String, Integer> juegos = new HashMap<>();
		
		juegos.put("minecraft", 1);
		juegos.put("gta7", 2);
		juegos.put("red dead redeptiom", 3);
		juegos.put("csgo", 4);
		juegos.put("resident evil 8", 5);
		juegos.put("subnautica", 6);
		
		Set<String> claves = juegos.keySet();
		
		for (String n : claves) {
			System.out.println(juegos.get(n));
			
		}
	}

}
