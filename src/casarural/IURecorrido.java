package casarural;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class IURecorrido extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IURecorrido frame = new IURecorrido();
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
	public IURecorrido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pBotones = new JPanel();
		pBotones.setBounds(0, 222, 434, 40);
		contentPane.add(pBotones);
		pBotones.setLayout(null);
		
		JButton btnCrearRecorrido = new JButton("Crear Recorrido");
		btnCrearRecorrido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrearRecorrido.setBounds(52, 11, 138, 23);
		pBotones.add(btnCrearRecorrido);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IURecorrido.this.dispose();
			}
		});
		btnVolver.setBounds(287, 11, 89, 23);
		pBotones.add(btnVolver);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 223);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Número Casa", "Propietario", "Población", "Añadir"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
	}
	
	public void crearRecorrido() {
		ComprobarAdministrador iuComprobarAdminstrador = new ComprobarAdministrador();
		iuComprobarAdminstrador.comprobar(new Runnable() {
			public void run() {
				realmenteCrearRecorrido();
			}
		});
	}
	
	private void realmenteCrearRecorrido() {
//		GestorServicio gServicio = GestorServicio.getInstance();
//		GestorRecorrido gRecorrido = GestorRecorrido.getInstance();

//		List<Recorrido> recorridos = gRecorrido.getRecorridos();
//		List<Recogida> recogidas = gServicio.getRecogidas();
		
//		recorridosComboBox.setModel(new DefaultComboBoxModel(recorridos.toArray()));
//		recogidasComboBox.setModel(new DefaultComboBoxModel(recogidas.toArray()));
		
		this.setVisible(true);
	}
}
