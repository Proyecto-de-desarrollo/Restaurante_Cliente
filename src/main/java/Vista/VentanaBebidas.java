package Vista;

import javax.swing.*;
import java.awt.*;
import Servicio.Pedido;

public class VentanaBebidas extends JFrame {
    private JFrame ventanaAnterior;

    public VentanaBebidas(JFrame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;

        setTitle("Bebidas");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Selecciona una bebida", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        getContentPane().add(titulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 10, 10));

        JButton btnAgua = new JButton("Agua");
        btnAgua.setForeground(new Color(255, 255, 255));
        btnAgua.setBackground(new Color(44, 62, 80));
        JButton btnJugo = new JButton("Jugo");
        btnJugo.setForeground(new Color(255, 255, 255));
        btnJugo.setBackground(new Color(44, 62, 80));
        JButton btnRefresco = new JButton("Refresco");
        btnRefresco.setForeground(new Color(255, 255, 255));
        btnRefresco.setBackground(new Color(44, 62, 80));
        JButton btnCerveza = new JButton("Cerveza");
        btnCerveza.setForeground(new Color(255, 255, 255));
        btnCerveza.setBackground(new Color(44, 62, 80));

        panelBotones.add(btnAgua);
        panelBotones.add(btnJugo);
        panelBotones.add(btnRefresco);
        panelBotones.add(btnCerveza);

        btnAgua.addActionListener(e -> seleccionarBebida("Agua"));
        btnJugo.addActionListener(e -> seleccionarBebida("Jugo"));
        btnRefresco.addActionListener(e -> seleccionarBebida("Refresco"));
        btnCerveza.addActionListener(e -> seleccionarBebida("Cerveza"));

        getContentPane().add(panelBotones, BorderLayout.CENTER);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setForeground(new Color(255, 255, 255));
        btnRegresar.setBackground(new Color(44, 62, 80));
        btnRegresar.addActionListener(e -> {
            ventanaAnterior.setVisible(true);
            dispose();
        });
        getContentPane().add(btnRegresar, BorderLayout.SOUTH);
    }

    private void seleccionarBebida(String bebida) {
        Pedido.setBebida(bebida);
        new VentanaPostres(this).setVisible(true);
        setVisible(false);
    }
}

