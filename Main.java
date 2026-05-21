package prog.ud8.proyecto;

import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) {
		login();
		opciones();
	
	}

	public static void opciones() {

		Scanner sc = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.println("1.Mostrar juegos");
		System.out.print("Respuesta: ");		
		int respuesta = sc.nextInt();
		if (respuesta == 1) {
			mostrarjuegos();
		} else {
			opciones();
		}
		System.out.println("-------------------------");
		sc.close();
		
	}
	
	public static void login() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------Login--------");
		System.out.print("Usuario: ");
		sc.nextLine();
		System.out.println("-------------------------");
		sc.close();
		
	}
	
	public static void mostrarjuegos() {
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document documento = builder.parse("videojuegos.xml");

			Element raiz = documento.getDocumentElement();

			// Obtener TODOS los juegos
			NodeList juegos = raiz.getElementsByTagName("juego");

			// Recorrer cada juego
			for (int i = 0; i < juegos.getLength(); i++) {

				Node juego = juegos.item(i);

				if (juego.getNodeType() == Node.ELEMENT_NODE) {

					NodeList datos = juego.getChildNodes();

					for (int j = 0; j < datos.getLength(); j++) {

						Node dato = datos.item(j);

						if (dato.getNodeType() == Node.ELEMENT_NODE) {

							System.out.println(dato.getNodeName() + ": " + dato.getTextContent());
						}
					}

					System.out.println("-------------------");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error " + e.getMessage());
		}
	}
	
}