package proyecto;

import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Proyecto {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		login();
		opciones();
		sc.close();
	
	}

	public static void opciones() {

		
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
		
		
	}
	
	public static void login() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------Login--------");
		System.out.print("Usuario: ");
		sc.nextLine();
		System.out.println("-------------------------");
		
		
	}
	
	public static void mostrarjuegos() {
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document documento = builder.parse("videojuegos.xml");

			Element raiz = documento.getDocumentElement();

			// Obtener TODOS los juegos
			NodeList juegos = raiz.getElementsByTagName("juego");
			
			// Variables para la base de datos
	        String titulo = "";
	        String empresa = "";
	        int precio = 0;
	        int fecha = 0;
	        int valoracion = 0;

			// Recorrer cada juego
			for (int i = 0; i < juegos.getLength(); i++) {

				Node juego = juegos.item(i);

				if (juego.getNodeType() == Node.ELEMENT_NODE) {

					NodeList datos = juego.getChildNodes();

					for (int j = 0; j < datos.getLength(); j++) {

						Node dato = datos.item(j);

						if (dato.getNodeType() == Node.ELEMENT_NODE) {

							System.out.println(dato.getNodeName() + ": " + dato.getTextContent());
							
	                        switch (dato.getNodeName()) {
                            case "titulo":
                                titulo = dato.getTextContent();
                                break;
                            case "empresa":
                                empresa = dato.getTextContent();
                                break;
                            case "precio":
                                precio = Integer.parseInt(dato.getTextContent());
                                break;
                            case "fecha":
                                fecha = Integer.parseInt(dato.getTextContent());
                                break;
                            case "valoracion":
                                valoracion = Integer.parseInt(dato.getTextContent());
                                break;
	                        }
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


