package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import Servicio.GestionUsuarios;

import java.awt.event.*;

public class VentanaRegistro extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNombreDeUsuario;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VentanaRegistro frame = new VentanaRegistro();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public VentanaRegistro() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(162, 183, 221));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new LineBorder(new Color(192, 192, 192), 2, true));
        panel.setBackground(new Color(217, 230, 242));
        panel.setBounds(41, 10, 350, 240);
        contentPane.add(panel);

        txtNombreDeUsuario = new JTextField("Nombre de usuario");
        txtNombreDeUsuario.setForeground(Color.GRAY);
        txtNombreDeUsuario.setFont(new Font("Consolas", Font.BOLD, 18));
        txtNombreDeUsuario.setBounds(30, 59, 283, 34);
        txtNombreDeUsuario.setBorder(new LineBorder(Color.GRAY, 1, true));
        panel.add(txtNombreDeUsuario);

        txtNombreDeUsuario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtNombreDeUsuario.getText().equals("Nombre de usuario")) {
                    txtNombreDeUsuario.setText("");
                    txtNombreDeUsuario.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtNombreDeUsuario.getText().isEmpty()) {
                    txtNombreDeUsuario.setText("Nombre de usuario");
                    txtNombreDeUsuario.setForeground(Color.GRAY);
                }
            }
        });

        JLabel lblRegistro = new JLabel("REGISTRO");
        lblRegistro.setForeground(new Color(44, 62, 80));
        lblRegistro.setFont(new Font("Consolas", Font.BOLD, 20));
        lblRegistro.setBounds(128, 22, 106, 25);
        panel.add(lblRegistro);

        passwordField = new JPasswordField("Contraseña");
        passwordField.setForeground(Color.GRAY);
        passwordField.setFont(new Font("Consolas", Font.BOLD, 18));
        passwordField.setEchoChar((char) 0);
        passwordField.setBounds(30, 103, 283, 34);
        passwordField.setBorder(new LineBorder(Color.GRAY, 1, true));
        panel.add(passwordField);

        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals("Contraseña")) {
                    passwordField.setText("");
                    passwordField.setEchoChar('*');
                    passwordField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).isEmpty()) {
                    passwordField.setText("Contraseña");
                    passwordField.setEchoChar((char) 0);
                    passwordField.setForeground(Color.GRAY);
                }
            }
        });

        JButton btnRegistrarse = new JButton("REGISTRARSE");
        btnRegistrarse.setForeground(new Color(0, 0, 0));
        btnRegistrarse.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
        btnRegistrarse.setBackground(new Color(0, 122, 255));
        btnRegistrarse.setBounds(32, 162, 281, 34);
        btnRegistrarse.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
        btnRegistrarse.setFocusPainted(false);
        panel.add(btnRegistrarse);
        btnRegistrarse.addActionListener(e -> {
            String nombreUsuario = txtNombreDeUsuario.getText().trim();
            String contrasena = new String(passwordField.getPassword()).trim();

            if (nombreUsuario.equals("Nombre de usuario") || nombreUsuario.isEmpty() ||
                contrasena.equals("Contraseña") || contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (GestionUsuarios.registrarUsuario(nombreUsuario, contrasena)) {
                JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
                dispose();
                new VentanaLogin().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


        JLabel lblIniciarSesion = new JLabel("VOLVER A INICIAR SESIÓN");
        lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
        lblIniciarSesion.setForeground(new Color(0, 128, 255));
        lblIniciarSesion.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
        lblIniciarSesion.setBounds(37, 206, 267, 13);
        panel.add(lblIniciarSesion);

        lblIniciarSesion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                VentanaLogin login = new VentanaLogin();
                login.setVisible(true);
                dispose();
            }
        });
    }
}
