package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Servicio.Pedido;

public class VentanaResumen extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JFrame ventanaAnterior;

    public VentanaResumen(JFrame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(217, 230, 242));
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(10, 10));

        JLabel lblTitulo = new JLabel("Resumen del Pedido", SwingConstants.CENTER);
        lblTitulo.setBackground(new Color(44, 62, 80));
        lblTitulo.setFont(new Font("Consolas", Font.BOLD, 24));
        contentPane.add(lblTitulo, BorderLayout.NORTH);

        JPanel panelResumen = new JPanel();
        panelResumen.setLayout(new GridLayout(3, 1, 10, 10));
        panelResumen.setBackground(new Color(44, 62, 80));
        panelResumen.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel lblPlato = new JLabel("Plato fuerte: " + Pedido.getPlato());
        lblPlato.setForeground(new Color(255, 255, 255));
        lblPlato.setBackground(new Color(255, 255, 255));
        JLabel lblBebida = new JLabel("Bebida: " + Pedido.getBebida());
        lblBebida.setForeground(new Color(255, 255, 255));
        JLabel lblPostre = new JLabel("Postre: " + Pedido.getPostre());
        lblPostre.setForeground(new Color(255, 255, 255));

        Font font = new Font("SansSerif", Font.PLAIN, 16);
        lblPlato.setFont(font);
        lblBebida.setFont(font);
        lblPostre.setFont(font);

        panelResumen.add(lblPlato);
        panelResumen.add(lblBebida);
        panelResumen.add(lblPostre);

        contentPane.add(panelResumen, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton btnConfirmar = new JButton("Confirmar Pedido");
        btnConfirmar.setBackground(new Color(44, 62, 80));
        btnConfirmar.setForeground(new Color(255, 255, 255));
        btnConfirmar.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnConfirmar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "¡Pedido confirmado!\nGracias por su compra.");
            System.exit(0); // o podrías volver al menú
        });

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setBackground(new Color(44, 62, 80));
        btnRegresar.setForeground(new Color(255, 255, 255));
        btnRegresar.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnRegresar.addActionListener(e -> {
            ventanaAnterior.setVisible(true);
            dispose();
        });

        panelBotones.add(btnRegresar);
        panelBotones.add(btnConfirmar);
        contentPane.add(panelBotones, BorderLayout.SOUTH);
    }
}



