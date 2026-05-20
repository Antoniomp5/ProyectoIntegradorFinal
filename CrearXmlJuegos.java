package prog.ud8.proyecto;

import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class CrearXmlJuegos {

    public static void guardarJuegos(ArrayList<Juegos> listaJuegos) {

        try {

            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();

            DocumentBuilder builder =
                    factory.newDocumentBuilder();

            Document documento =
                    builder.newDocument();

            // Raíz
            Element raiz = documento.createElement("juegos");
            documento.appendChild(raiz);

            // Recorrer lista
            for (Juegos j : listaJuegos) {

                Element juego = documento.createElement("juego");

                Element titulo = documento.createElement("titulo");
                titulo.setTextContent(j.getTitulo());

                Element empresa = documento.createElement("empresa_creadora");
                empresa.setTextContent(j.getEmpresa_creadora());

                Element precio = documento.createElement("precio");
                precio.setTextContent(String.valueOf(j.getPrecio()));

                Element fecha = documento.createElement("fecha_salida");
                fecha.setTextContent(String.valueOf(j.getFecha_salida()));

                Element valoracion = documento.createElement("valoracion");
                valoracion.setTextContent(String.valueOf(j.getValoracion()));

                // Añadir datos al juego
                juego.appendChild(titulo);
                juego.appendChild(empresa);
                juego.appendChild(precio);
                juego.appendChild(fecha);
                juego.appendChild(valoracion);

                // Añadir juego a raíz
                raiz.appendChild(juego);
            }

            // Crear XML
            TransformerFactory transformerFactory =
                    TransformerFactory.newInstance();

            Transformer transformer =
                    transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount",
                    "4");

            DOMSource origen = new DOMSource(documento);

            StreamResult destino =
                    new StreamResult(new File("juegos.xml"));

            transformer.transform(origen, destino);

            System.out.println("XML guardado correctamente.");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
