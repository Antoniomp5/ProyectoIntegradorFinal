package PROYECTO;

import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {

    private JTextField txtUsuario;
    private JButton btnEntrar;

    public VentanaLogin() {

        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        JLabel lblTitulo = new JLabel("INICIAR SESIÓN", SwingConstants.CENTER);

        JPanel panel = new JPanel();

        panel.add(new JLabel("Usuario:"));

        txtUsuario = new JTextField(12);
        panel.add(txtUsuario);

        btnEntrar = new JButton("Entrar");

        btnEntrar.addActionListener(e -> {

            String usuario = txtUsuario.getText();

            if (usuario.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Introduce un usuario");
            } else {

                new VentanaPrincipal(usuario);
                dispose(); // cerrar login
            }
        });

        add(lblTitulo);
        add(panel);
        add(btnEntrar);

        setVisible(true);
    }
}