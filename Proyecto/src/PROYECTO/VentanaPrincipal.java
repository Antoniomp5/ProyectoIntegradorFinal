package PROYECTO;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class VentanaPrincipal extends JFrame {

    private String usuario;
    private int saldo = 100;

    private JTextArea areaJuegos;

    public VentanaPrincipal(String usuario) {

        this.usuario = usuario;

        setTitle("Catálogo de Juegos");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        // BorderLayout ya que coloca componentes por zonas
        // ===================== PARTE SUPERIOR =====================
        JPanel panelSuperior = new JPanel(new BorderLayout());

        JLabel lblUsuario = new JLabel("Usuario: " + usuario);
        JLabel lblSaldo = new JLabel("Saldo: " + saldo + "€");

        panelSuperior.add(lblUsuario, BorderLayout.WEST);
        panelSuperior.add(lblSaldo, BorderLayout.EAST);

        add(panelSuperior, BorderLayout.NORTH);

        // ===================== LISTADO =====================
        areaJuegos = new JTextArea();
        areaJuegos.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaJuegos);

        add(scroll, BorderLayout.CENTER);

        cargarJuegos();

        setVisible(true);
    }

    // ===================== LEER XML =====================
    private void cargarJuegos() {

        try {

            File file = new File("videojuegos.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(file);

            NodeList lista = doc.getElementsByTagName("juego");

            String texto = "";

            for (int i = 0; i < lista.getLength(); i++) {

                Node nodo = lista.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {

                    Element e = (Element) nodo;

                    String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();
                    String empresa = e.getElementsByTagName("empresa").item(0).getTextContent();
                    String precio = e.getElementsByTagName("Precio").item(0).getTextContent();

                    texto += "Juego: " + nombre + "\n";
                    texto += "Empresa: " + empresa + "\n";
                    texto += "Precio: " + precio + "€\n";
                    texto += "--------------------------\n";
                }
            }

            areaJuegos.setText(texto);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al leer XML");
        }
    }
}