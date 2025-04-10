package Vista;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

import Controlador.GestionUsuarios;
import Vista.VentanaInicioCliente;

public class VentanaLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;
    private JLabel lblRegistro;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VentanaLogin frame = new VentanaLogin();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public VentanaLogin() {
        setTitle("RESTAURANT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(162, 183, 221));
        contentPane.setBorder(new LineBorder(new Color(192, 192, 192), 2, true));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(192, 192, 192), 2, true));
        panel.setBackground(new Color(217, 230, 242));
        panel.setBounds(45, 10, 350, 240);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Login");
        lblTitulo.setBounds(141, 24, 80, 25);
        lblTitulo.setForeground(new Color(44, 62, 80));
        lblTitulo.setFont(new Font("Consolas", Font.BOLD, 20));
        panel.add(lblTitulo);

        txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Consolas", Font.BOLD, 18));
        txtUsuario.setBounds(30, 59, 283, 34);
        txtUsuario.setForeground(new Color(0, 0, 0));
        panel.add(txtUsuario);
        txtUsuario.setColumns(10);

        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(30, 103, 283, 34);
        panel.add(txtContraseña);

        JButton btnLogin = new JButton("LOG IN");
        btnLogin.setBounds(30, 147, 281, 34);
        panel.add(btnLogin);
        btnLogin.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
        btnLogin.setForeground(new Color(44, 62, 80));
        btnLogin.setBackground(new Color(0, 122, 255));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String contraseña = new String(txtContraseña.getPassword());

                if (usuario.isEmpty() || contraseña.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (GestionUsuarios.validarUsuario(usuario, contraseña)) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    VentanaInicioCliente ventanaInicio = new VentanaInicioCliente(usuario);
                    ventanaInicio.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        lblRegistro = new JLabel("¿NO ESTÁS REGISTRADO?");
        lblRegistro.setBounds(37, 206, 267, 13);
        panel.add(lblRegistro);
        lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegistro.setForeground(new Color(0, 128, 255));
        lblRegistro.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
        lblRegistro.setBackground(Color.BLACK);

        lblRegistro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                VentanaRegistro ventanaRegistro = new VentanaRegistro();
                ventanaRegistro.setVisible(true);
                dispose(); 
            }
        });

    }
}

