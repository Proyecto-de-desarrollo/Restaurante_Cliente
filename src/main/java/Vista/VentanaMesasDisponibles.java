package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaMesasDisponibles extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public VentanaMesasDisponibles() {
        setTitle("Mesas Disponibles");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(217, 230, 242));
        contentPane.setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192), 2, true));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Mesas Disponibles");
        lblTitulo.setBounds(120, 20, 200, 30);
        lblTitulo.setFont(new Font("Consolas", Font.BOLD, 18));
        contentPane.add(lblTitulo);
    }
}
