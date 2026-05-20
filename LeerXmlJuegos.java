package prog.ud8.proyecto;

import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class LeerXmlJuegos {
    public static ArrayList<Juegos> leerJuegos(String ruta) {

        ArrayList<Juegos> lista = new ArrayList<>();

        try {

            File file = new File(ruta);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document documento = builder.parse(file);

            documento.getDocumentElement().normalize();

            NodeList listaJuegos = documento.getElementsByTagName("juego");

            for (int i = 0; i < listaJuegos.getLength(); i++) {

                Node nodo = listaJuegos.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {

                    Element juego = (Element) nodo;

                    String titulo = juego
                            .getElementsByTagName("titulo")
                            .item(0)
                            .getTextContent();

                    String empresa = juego
                            .getElementsByTagName("empresa_creadora")
                            .item(0)
                            .getTextContent();

                    int precio = Integer.parseInt(
                            juego.getElementsByTagName("precio")
                            .item(0)
                            .getTextContent());

                    int fecha = Integer.parseInt(
                            juego.getElementsByTagName("fecha_salida")
                            .item(0)
                            .getTextContent());

                    int valoracion = Integer.parseInt(
                            juego.getElementsByTagName("valoracion")
                            .item(0)
                            .getTextContent());

                    Juegos j = new Juegos(
                            titulo,
                            empresa,
                            precio,
                            fecha,
                            valoracion);

                    lista.add(j);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

}
