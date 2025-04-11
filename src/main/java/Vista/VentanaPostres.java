package Vista;

import javax.swing.*;
import java.awt.*;
import Servicio.Pedido;

public class VentanaPostres extends JFrame {
    private JFrame ventanaAnterior;

    public VentanaPostres(JFrame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;

        setTitle("Postres");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Selecciona un postre", SwingConstants.CENTER);
        titulo.setForeground(new Color(44, 62, 80));
        titulo.setBackground(new Color(44, 62, 80));
        titulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        getContentPane().add(titulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 10, 10));

        JButton btnPastel = new JButton("Pastel");
        btnPastel.setForeground(new Color(255, 255, 255));
        btnPastel.setBackground(new Color(44, 62, 80));
        JButton btnFlan = new JButton("Flan");
        btnFlan.setForeground(new Color(255, 255, 255));
        btnFlan.setBackground(new Color(44, 62, 80));
        JButton btnFruta = new JButton("Fruta");
        btnFruta.setForeground(new Color(255, 255, 255));
        btnFruta.setBackground(new Color(44, 62, 80));

        panelBotones.add(btnPastel);
        panelBotones.add(btnFlan);
        panelBotones.add(btnFruta);

        btnPastel.addActionListener(e -> seleccionarPostre("Pastel"));
        btnFlan.addActionListener(e -> seleccionarPostre("Flan"));
        btnFruta.addActionListener(e -> seleccionarPostre("Fruta"));

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

    private void seleccionarPostre(String postre) {
        Pedido.setPostre(postre);
        new VentanaResumen(this).setVisible(true);
        setVisible(false);
    }
}
 

