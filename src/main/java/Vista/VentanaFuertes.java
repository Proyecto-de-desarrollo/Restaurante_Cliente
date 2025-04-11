package Vista;

import javax.swing.*;
import java.awt.*;
import Servicio.Pedido;

public class VentanaFuertes extends JFrame {
    private JFrame ventanaAnterior;

    public VentanaFuertes(JFrame ventanaAnterior) {
    	setBackground(new Color(217, 230, 242));
        this.ventanaAnterior = ventanaAnterior;

        setTitle("Platos Fuertes");
        setSize(578, 406);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Selecciona un plato fuerte", SwingConstants.CENTER);
        titulo.setBackground(new Color(44, 62, 80));
        titulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        getContentPane().add(titulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(217, 230, 242));

        JButton btnPollo = new JButton("Pollo");
        btnPollo.setBounds(33, 10, 206, 140);
        btnPollo.setForeground(new Color(255, 255, 255));
        btnPollo.setBackground(new Color(44, 62, 80));
        JButton btnCarne = new JButton("Carne");
        btnCarne.setBounds(322, 10, 216, 140);
        btnCarne.setForeground(new Color(255, 255, 255));
        btnCarne.setBackground(new Color(44, 62, 80));
        JButton btnPescado = new JButton("Pescado");
        btnPescado.setForeground(new Color(255, 255, 255));
        btnPescado.setBounds(33, 160, 206, 150);
        btnPescado.setBackground(new Color(44, 62, 80));
        JButton btnVegano = new JButton("Vegano");
        btnVegano.setForeground(new Color(255, 255, 255));
        btnVegano.setBounds(322, 160, 216, 150);
        btnVegano.setBackground(new Color(44, 62, 80));
        panelBotones.setLayout(null);

        panelBotones.add(btnPollo);
        panelBotones.add(btnCarne);
        panelBotones.add(btnPescado);
        panelBotones.add(btnVegano);

        btnPollo.addActionListener(e -> seleccionarPlato("Pollo"));
        btnCarne.addActionListener(e -> seleccionarPlato("Carne"));
        btnPescado.addActionListener(e -> seleccionarPlato("Pescado"));
        btnVegano.addActionListener(e -> seleccionarPlato("Vegano"));

        getContentPane().add(panelBotones, BorderLayout.CENTER);

        JButton btnRegresar = new JButton("Volver al Menú");
        btnRegresar.setForeground(new Color(255, 255, 255));
        btnRegresar.setBackground(new Color(44, 62, 80));
        btnRegresar.addActionListener(e -> {
            ventanaAnterior.setVisible(true);
            dispose();
        });
        getContentPane().add(btnRegresar, BorderLayout.SOUTH);
    }

    private void seleccionarPlato(String plato) {
        Pedido.setPlato(plato);
        new VentanaBebidas(this).setVisible(true);
        setVisible(false);
    }
}


