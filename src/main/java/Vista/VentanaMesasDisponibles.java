package Vista;

import javax.swing.*;
import java.util.Map;
import java.awt.*;
import javax.swing.border.LineBorder;

import Servicio.GestionMesas;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class VentanaMesasDisponibles extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String nombreUsuario;
    private Map<Integer, Boolean> estadoMesas = new HashMap<>();
    private JButton[] botonesMesas = new JButton[10];

    public VentanaMesasDisponibles() {
        this("Invitado");
    }

    public VentanaMesasDisponibles(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        setTitle("Mesas Disponibles");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192), 2, true));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(44, 62, 80), 2));
        panel.setBackground(new Color(217, 230, 242));
        panel.setBounds(20, 25, 343, 215);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(44, 62, 80));
        panel_1.setBounds(0, 0, 343, 34);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("MESAS DISPONIBLES");
        lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(82, 0, 187, 34);
        panel_1.add(lblNewLabel);

        JButton btnMesa1 = new JButton("MESA 1");
        btnMesa1.setFont(new Font("Microsoft Tai Le", Font.BOLD, 5));
        btnMesa1.setForeground(new Color(44, 62, 80));
        btnMesa1.setBounds(10, 44, 50, 50);
        panel.add(btnMesa1);

        JButton btnMesa4 = new JButton("MESA 4");
        btnMesa4.setHorizontalAlignment(SwingConstants.RIGHT);
        btnMesa4.setForeground(new Color(44, 62, 80));
        btnMesa4.setFont(new Font("Microsoft Tai Le", Font.BOLD, 5));
        btnMesa4.setBounds(190, 43, 50, 50);
        panel.add(btnMesa4);

        JButton btnMesa2 = new JButton("MESA 2");
        btnMesa2.setForeground(new Color(44, 62, 80));
        btnMesa2.setFont(new Font("Microsoft Tai Le", Font.BOLD, 5));
        btnMesa2.setBounds(70, 44, 50, 50);
        panel.add(btnMesa2);

        JButton btnMesa3 = new JButton("MESA 3");
        btnMesa3.setHorizontalAlignment(SwingConstants.RIGHT);
        btnMesa3.setForeground(new Color(44, 62, 80));
        btnMesa3.setFont(new Font("Microsoft Tai Le", Font.BOLD, 5));
        btnMesa3.setBounds(130, 43, 50, 50);
        panel.add(btnMesa3);

        JButton btnMesa5 = new JButton("MESA 5");
        btnMesa5.setForeground(new Color(44, 62, 80));
        btnMesa5.setFont(new Font("Microsoft Tai Le", Font.BOLD, 5));
        btnMesa5.setBounds(250, 44, 50, 50);
        panel.add(btnMesa5);

        JButton btnMesa6 = new JButton("MESA 6");
        btnMesa6.setForeground(new Color(44, 62, 80));
        btnMesa6.setFont(new Font("Microsoft Tai Le", Font.BOLD, 5));
        btnMesa6.setBounds(10, 104, 50, 50);
        panel.add(btnMesa6);

        JButton btnMesa7 = new JButton("MESA 7");
        btnMesa7.setForeground(new Color(44, 62, 80));
        btnMesa7.setFont(new Font("Microsoft Tai Le", Font.BOLD, 5));
        btnMesa7.setBounds(70, 104, 50, 50);
        panel.add(btnMesa7);

        JButton btnMesa8 = new JButton("MESA 8");
        btnMesa8.setForeground(new Color(44, 62, 80));
        btnMesa8.setFont(new Font("Microsoft Tai Le", Font.BOLD, 5));
        btnMesa8.setBounds(130, 103, 50, 50);
        panel.add(btnMesa8);

        JButton btnMesa9 = new JButton("MESA 9");
        btnMesa9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnMesa9.setForeground(new Color(44, 62, 80));
        btnMesa9.setFont(new Font("Microsoft Tai Le", Font.BOLD, 5));
        btnMesa9.setBounds(190, 103, 50, 50);
        panel.add(btnMesa9);

        JButton btnMesa10 = new JButton("MESA 10");
        btnMesa10.setForeground(new Color(44, 62, 80));
        btnMesa10.setFont(new Font("Microsoft Tai Le", Font.BOLD, 5));
        btnMesa10.setBounds(250, 104, 50, 50);
        panel.add(btnMesa10);

        botonesMesas = new JButton[]{btnMesa1, btnMesa2, btnMesa3, btnMesa4, btnMesa5, btnMesa6, btnMesa7, btnMesa8, btnMesa9, btnMesa10};

        for (int i = 0; i < botonesMesas.length; i++) {
            final int numeroMesa = i + 1;
            boolean ocupada = GestionMesas.isMesaOcupada(numeroMesa);

            botonesMesas[i].setBackground(ocupada ? Color.RED : Color.GREEN);
            botonesMesas[i].setEnabled(true);
            botonesMesas[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    VentanaMesa ventanaMesa = new VentanaMesa(numeroMesa);
                    ventanaMesa.setVisible(true);
                    if (!GestionMesas.isMesaOcupada(numeroMesa)) {
                        GestionMesas.setMesaOcupada(numeroMesa, true);
                    }
                }
            });
        }

        JButton btnRegresar = new JButton("REGRESAR");
        btnRegresar.setForeground(new Color(44, 62, 80));
        btnRegresar.setBackground(new Color(255, 255, 255));
        btnRegresar.setBounds(221, 184, 114, 21);
        panel.add(btnRegresar);

        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new VentanaInicioCliente(nombreUsuario).setVisible(true);
            }
        });
    }

    private void actualizarEstadoMesas() {
        for (int i = 0; i < botonesMesas.length; i++) {
            int numeroMesa = i + 1;
            boolean ocupada = GestionMesas.isMesaOcupada(numeroMesa);
            botonesMesas[i].setBackground(ocupada ? Color.RED : Color.GREEN);
            botonesMesas[i].setEnabled(!ocupada);
        }
    }
}
