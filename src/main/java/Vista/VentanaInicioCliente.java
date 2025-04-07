package Vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicioCliente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnConfig;
    private JLabel lblBienvenida;
    private JLabel lblNewLabel;
    private JPanel panel_2;
    private JPanel panel_4;
    private JPanel panel_5;
    private JButton btnMesas;
    private JButton btnMenu;
    private JButton btnHistorial;

    public VentanaInicioCliente(String Usuario) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(217, 230, 242));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(44, 62, 80));
        panel.setBounds(0, 44, 48, 219);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBounds(0, 0, 436, 45);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(405, 6, 21, 21);
        panel_1.add(btnSalir);

        btnConfig = new JButton("Config");
        btnConfig.setBounds(382, 6, 21, 21);
        panel_1.add(btnConfig);
        
        lblNewLabel = new JLabel("RESTAURANT");
        lblNewLabel.setBounds(170, 15, 115, 20);
        panel_1.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 16));
        
        panel_2 = new JPanel();
        panel_2.setBackground(new Color(162, 183, 221));
        panel_2.setBounds(103, 78, 80, 80);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        btnMesas = new JButton("MESAS");
        btnMesas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaMesasDisponibles mesasDisponibles = new VentanaMesasDisponibles();
                mesasDisponibles.setVisible(true);
            }
        });
        btnMesas.setBackground(new Color(44, 62, 80));
        btnMesas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnMesas.setBounds(0, 49, 80, 21);
        panel_2.add(btnMesas);
        
        panel_4 = new JPanel();
        panel_4.setBackground(new Color(162, 183, 221));
        panel_4.setBounds(210, 78, 80, 80);
        contentPane.add(panel_4);
        panel_4.setLayout(null);
        
        btnMenu = new JButton("MENÚ");
        btnMenu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnMenu.setBackground(new Color(44, 62, 80));
        btnMenu.setBounds(0, 49, 80, 21);
        panel_4.add(btnMenu);
        
        panel_5 = new JPanel();
        panel_5.setBackground(new Color(162, 183, 221));
        panel_5.setBounds(316, 78, 80, 80);
        contentPane.add(panel_5);
        panel_5.setLayout(null);
        
        btnHistorial = new JButton("HISTORIAL");
        btnHistorial.setHorizontalAlignment(SwingConstants.LEFT);
        btnHistorial.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnHistorial.setBackground(new Color(44, 62, 80));
        btnHistorial.setBounds(0, 49, 80, 21);
        panel_5.add(btnHistorial);
        
        lblBienvenida = new JLabel("Bienvenido, " + nombreUsuario);
        lblBienvenida.setBounds(145, 194, 186, 20);
        contentPane.add(lblBienvenida);
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 16));
    }
}

