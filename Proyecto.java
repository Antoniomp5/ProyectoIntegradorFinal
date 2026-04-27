package prog.ud8.proyecto;

import java.util.HashMap;
import java.util.Map;

public class Proyecto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> juegos = new HashMap<>();
		
		juegos.put("minecraft", 1);
		juegos.put("gta7", 2);
		juegos.put("red dead redeptiom", 3);
		juegos.put("csgo", 4);
		juegos.put("resident evil 8", 5);
		juegos.put("subnautica", 6);
		
		System.out.println(juegos);
	}

}
