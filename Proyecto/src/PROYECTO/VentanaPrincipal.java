package PROYECTO;

import java.awt.BorderLayout;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class VentanaPrincipal extends JFrame {

    private String usuario;
    private int saldo = 100;

    private JTextArea areaJuegos;

    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("videojuegos.odb");

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

        importarXML();
        cargarDesdeBD();
        
        setVisible(true);
    }

    // ===================== IMPORTAR XML =====================

    private void importarXML() {

        EntityManager em = emf.createEntityManager();

        try {

            File file = new File("videojuegos.xml");

            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();

            DocumentBuilder builder =
                    factory.newDocumentBuilder();

            Document doc = builder.parse(file);

            NodeList lista = doc.getElementsByTagName("juego");

            // ObjectDB
            em.getTransaction().begin();

            // MySQL
            Connection con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/videojuegos",
                    "root",
                    "");

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO juegos " +
                    "(titulo, empresa_creadora, precio, fecha_salida, valoracion) " +
                    "VALUES (?, ?, ?, ?, ?)");

            for (int i = 0; i < lista.getLength(); i++) {

                Element e = (Element) lista.item(i);

                Juegos juego = new Juegos();

                juego.setTitulo(
                        e.getElementsByTagName("nombre")
                                .item(0)
                                .getTextContent());

                juego.setEmpresa_creadora(
                        e.getElementsByTagName("empresa")
                                .item(0)
                                .getTextContent());

                juego.setPrecio(
                        Integer.parseInt(
                                e.getElementsByTagName("Precio")
                                        .item(0)
                                        .getTextContent()));

                juego.setFecha_salida(
                        Integer.parseInt(
                                e.getElementsByTagName("Anio")
                                        .item(0)
                                        .getTextContent()));

                juego.setValoracion(
                        Integer.parseInt(
                                e.getElementsByTagName("Valoracion")
                                        .item(0)
                                        .getTextContent()));

                // Guardar en ObjectDB
                em.persist(juego);

                // Guardar en MySQL
                ps.setString(1, juego.getTitulo());
                ps.setString(2, juego.getEmpresa_creadora());
                ps.setInt(3, juego.getPrecio());
                ps.setInt(4, juego.getFecha_salida());
                ps.setInt(5, juego.getValoracion());

                ps.executeUpdate();
            }

            em.getTransaction().commit();

            ps.close();
            con.close();

        } catch (Exception ex) {

            ex.printStackTrace();

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Error al importar XML");

        } finally {
            em.close();
        }
    }

    // ===================== LEER OBJECTDB =====================

    private void cargarDesdeBD() {

        EntityManager em = emf.createEntityManager();

        try {

            List<Juegos> lista =
                    em.createQuery(
                            "SELECT j FROM Juegos j",
                            Juegos.class)
                            .getResultList();

            if (lista.isEmpty()) {

                areaJuegos.setText(
                        "No hay juegos en la base de datos");

                return;
            }

            String texto = "";

            for (Juegos j : lista) {

                texto += "Juego: " + j.getTitulo() + "\n";
                texto += "Empresa: " + j.getEmpresa_creadora() + "\n";
                texto += "Precio: " + j.getPrecio() + "€\n";
                texto += "Año: " + j.getFecha_salida() + "\n";
                texto += "Valoración: " + j.getValoracion() + "\n";
                texto += "--------------------------\n";
            }

            areaJuegos.setText(texto);

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Error al leer ObjectDB");

        } finally {

            em.close();
        }
    }
    
}

