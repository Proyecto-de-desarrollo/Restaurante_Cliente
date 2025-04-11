package Vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VentanaMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String usuario;

	public VentanaMenu(String usuario) {
		this.usuario = usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.activeCaption);
		panel.setBounds(25, 10, 462, 303);
		panel.setBackground(new Color(162, 183, 221));
		contentPane.add(panel);
		panel.setLayout(null);

		// Botón FUERTE
		ImageIcon iconFuerteOriginal = new ImageIcon(getClass().getResource("/Vista/imagenes/imagenes/food-tray.png"));
		Image iconFuerteEscalado = iconFuerteOriginal.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JButton btnFuerte = new JButton("Fuerte");
		btnFuerte.setForeground(new Color(44, 62, 80));
		btnFuerte.setBackground(new Color(217, 230, 242));
		btnFuerte.setIcon(new ImageIcon(iconFuerteEscalado));
		btnFuerte.setFont(new Font("Consolas", Font.BOLD, 15));
		btnFuerte.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFuerte.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnFuerte.setBounds(10, 96, 108, 163);
		panel.add(btnFuerte);
		btnFuerte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaFuertes(VentanaMenu.this).setVisible(true);
				dispose();
			}
		});

		// Botón BEBIDAS
		ImageIcon iconBebidasOriginal = new ImageIcon(getClass().getResource("/Vista/imagenes/imagenes/soda.png"));
		Image iconBebidasEscalado = iconBebidasOriginal.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JButton btnBebidas = new JButton("Bebidas");
		btnBebidas.setForeground(new Color(44, 62, 80));
		btnBebidas.setBackground(new Color(217, 230, 242));
		btnBebidas.setIcon(new ImageIcon(iconBebidasEscalado));
		btnBebidas.setFont(new Font("Consolas", Font.BOLD, 15));
		btnBebidas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBebidas.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBebidas.setBounds(168, 96, 108, 163);
		panel.add(btnBebidas);
		btnBebidas.addActionListener(e -> {
			new VentanaBebidas(VentanaMenu.this).setVisible(true);
			dispose();
		});

		// Botón POSTRES
		ImageIcon iconPostresOriginal = new ImageIcon(getClass().getResource("/Vista/imagenes/imagenes/cupcake.png"));
		Image iconPostresEscalado = iconPostresOriginal.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JButton btnPostres = new JButton("Postres");
		btnPostres.setForeground(new Color(44, 62, 80));
		btnPostres.setBackground(new Color(217, 230, 242));
		btnPostres.setIcon(new ImageIcon(iconPostresEscalado));
		btnPostres.setFont(new Font("Consolas", Font.BOLD, 15));
		btnPostres.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPostres.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPostres.setBounds(326, 96, 108, 163);
		panel.add(btnPostres);
		btnPostres.addActionListener(e -> {
			new VentanaPostres(VentanaMenu.this).setVisible(true);
			dispose();
		});

		// Título
		JLabel lblTitulo = new JLabel("MENÚ");
		lblTitulo.setFont(new Font("Consolas", Font.BOLD, 26));
		lblTitulo.setBounds(188, 10, 123, 40);
		panel.add(lblTitulo);

		// Botón Resumen
		JButton btnResumen = new JButton("Resumen");
		btnResumen.setBounds(352, 269, 100, 21);
		panel.add(btnResumen);
		btnResumen.addActionListener(e -> {
			new VentanaResumen(VentanaMenu.this).setVisible(true);
			dispose();
		});

		// Botón Regresar
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(10, 269, 100, 21);
		panel.add(btnRegresar);
		btnRegresar.addActionListener(e -> {
			new VentanaInicioCliente(usuario).setVisible(true);
			dispose();
		});
	}
}


