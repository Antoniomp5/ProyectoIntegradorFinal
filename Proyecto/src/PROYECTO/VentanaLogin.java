package PROYECTO;

// Importación de las clases de Swing para crear la interfaz gráfica
import javax.swing.*;

// Importación de clases de AWT para layouts y componentes gráficos
import java.awt.*;

// Clase VentanaLogin que hereda de JFrame (una ventana)
public class VentanaLogin extends JFrame {

    // Campo de texto donde el usuario escribirá su nombre
    private JTextField txtUsuario;

    // Botón para acceder a la aplicación
    private JButton btnEntrar;

    // Constructor de la ventana
    public VentanaLogin() {

        // Título de la ventana
        setTitle("Login");

        // Tamaño de la ventana (ancho x alto)
        setSize(300, 150);

        // Cierra completamente la aplicación al pulsar la X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centra la ventana en la pantalla
        setLocationRelativeTo(null);

        // Layout de 3 filas y 1 columna
        setLayout(new GridLayout(3, 1));

        // Etiqueta principal centrada
        JLabel lblTitulo = new JLabel("INICIAR SESIÓN", SwingConstants.CENTER);

        // Panel para agrupar la etiqueta y el campo de texto
        JPanel panel = new JPanel();

        // Etiqueta "Usuario:"
        panel.add(new JLabel("Usuario:"));

        // Campo de texto con espacio para 12 caracteres
        txtUsuario = new JTextField(12);

        // Añadimos el campo de texto al panel
        panel.add(txtUsuario);

        // Creación del botón Entrar
        btnEntrar = new JButton("Entrar");

        // Evento que se ejecuta al pulsar el botón
        btnEntrar.addActionListener(e -> {

            // Obtener el texto escrito por el usuario
            String usuario = txtUsuario.getText();

            // Comprobar si el campo está vacío
            if (usuario.isEmpty()) {

                // Mostrar mensaje de error
                JOptionPane.showMessageDialog(this, "Introduce un usuario");

            } else {

                // Abrir la ventana principal enviando el nombre del usuario
                new VentanaPrincipal(usuario);

                // Cerrar la ventana de login
                dispose();
            }
        });

        // Añadir la etiqueta de título a la ventana
        add(lblTitulo);

        // Añadir el panel con usuario y campo de texto
        add(panel);

        // Añadir el botón Entrar
        add(btnEntrar);

        // Hacer visible la ventana
        setVisible(true);
    }
}