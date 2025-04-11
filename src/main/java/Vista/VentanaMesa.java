package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import Servicio.GestionMesas;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class VentanaMesa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblEstadoMesa;
	private boolean mesaOcupada = false;
	private int numeroMesa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMesa frame = new VentanaMesa(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
		this.mesaOcupada = GestionMesas.isMesaOcupada(numeroMesa);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(217, 230, 242));
		panel.setBorder(new LineBorder(new Color(44, 62, 80), 2, true));
		panel.setBounds(26, 10, 388, 232);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(44, 62, 80));
		panel_1.setBounds(0, 0, 388, 38);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MESA " + numeroMesa);
		lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(160, 10, 105, 23);
		panel_1.add(lblNewLabel);
		
		JButton btnOcupar = new JButton("OCUPAR");
		btnOcupar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mesaOcupada = !mesaOcupada; 
                GestionMesas.setMesaOcupada(numeroMesa, mesaOcupada); 
                lblEstadoMesa.setText(mesaOcupada ? "Ocupada" : "Disponible");
            }
        });
		btnOcupar.setBackground(new Color(255, 255, 255));
		btnOcupar.setFont(new Font("Microsoft Tai Le", Font.BOLD, 16));
		btnOcupar.setForeground(new Color(44, 62, 80));
		btnOcupar.setBounds(26, 143, 132, 32);
		panel.add(btnOcupar);
		
		JButton btnDesocupar = new JButton("DESOCUPAR");
		btnDesocupar.setBackground(new Color(255, 255, 255));
		btnDesocupar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mesaOcupada = false; 
                GestionMesas.setMesaOcupada(numeroMesa, false); 
                lblEstadoMesa.setText("Disponible");
            }
        });
		btnDesocupar.setFont(new Font("Microsoft Tai Le", Font.BOLD, 16));
		btnDesocupar.setForeground(new Color(44, 62, 80));
		btnDesocupar.setBounds(230, 143, 132, 32);
		panel.add(btnDesocupar);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.setBackground(new Color(255, 255, 255));
		btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
                new VentanaMesasDisponibles().setVisible(true);
            }
        });
		btnRegresar.setFont(new Font("Microsoft Tai Le", Font.BOLD, 16));
		btnRegresar.setForeground(new Color(0, 0, 0));
		btnRegresar.setBounds(125, 190, 132, 32);
		panel.add(btnRegresar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(44, 62, 80));
		panel_2.setToolTipText("ESTADO DE LA MESA");
		panel_2.setBorder(new LineBorder(new Color(44, 62, 80), 2));
		panel_2.setBounds(10, 48, 368, 85);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblEstadoMesa = new JLabel("");
		lblEstadoMesa.setFont(new Font("Microsoft Tai Le", Font.BOLD, 16));
		lblEstadoMesa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadoMesa.setBounds(129, 23, 113, 32);
		panel_2.add(lblEstadoMesa);
	}
	
	private void actualizarEstadoMesa() {
        if (mesaOcupada) {
            lblEstadoMesa.setText("Ocupada");
            lblEstadoMesa.setForeground(Color.RED);
        } else {
            lblEstadoMesa.setText("Disponible");
            lblEstadoMesa.setForeground(new Color(34, 139, 34));
        }
    }
	
}
