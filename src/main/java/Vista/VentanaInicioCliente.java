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

    public VentanaInicioCliente(String usuario) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(217, 230, 242));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(44, 62, 80));
        panel.setBounds(0, 0, 48, 263);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBounds(48, 0, 388, 45);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(405, 6, 21, 21);
        panel_1.add(btnSalir);

        btnConfig = new JButton("Config");
        btnConfig.setBounds(382, 6, 21, 21);
        panel_1.add(btnConfig);
        
        lblNewLabel = new JLabel("RESTAURANT");
        lblNewLabel.setBounds(10, 15, 115, 20);
        panel_1.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 16));
        
        panel_2 = new JPanel();
        panel_2.setBackground(new Color(162, 183, 221));
        panel_2.setBounds(58, 78, 80, 80);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        btnMesas = new JButton("MESAS");
        btnMesas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaMesasDisponibles mesasDisponibles = new VentanaMesasDisponibles(usuario);
                mesasDisponibles.setVisible(true);
            }
        });
        btnMesas.setBackground(new Color(255, 255, 255));
        btnMesas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnMesas.setBounds(0, 49, 80, 21);
        panel_2.add(btnMesas);
        
        panel_4 = new JPanel();
        panel_4.setBackground(new Color(162, 183, 221));
        panel_4.setBounds(148, 78, 80, 80);
        contentPane.add(panel_4);
        panel_4.setLayout(null);
        
        btnMenu = new JButton("MENÚ");
        btnMenu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnMenu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnMenu.setBackground(new Color(255, 255, 255));
        btnMenu.setBounds(0, 49, 80, 21);
        panel_4.add(btnMenu);
        
        panel_5 = new JPanel();
        panel_5.setBackground(new Color(162, 183, 221));
        panel_5.setBounds(238, 78, 80, 80);
        contentPane.add(panel_5);
        panel_5.setLayout(null);
        
        btnHistorial = new JButton("HISTORIAL");
        btnHistorial.setHorizontalAlignment(SwingConstants.LEFT);
        btnHistorial.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnHistorial.setBackground(new Color(255, 255, 255));
        btnHistorial.setBounds(0, 49, 80, 21);
        panel_5.add(btnHistorial);
        
        lblBienvenida = new JLabel("Bienvenido, " + usuario);
        lblBienvenida.setBounds(145, 194, 186, 20);
        contentPane.add(lblBienvenida);
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 16));
    }
}

