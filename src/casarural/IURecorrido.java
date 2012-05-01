package casarural;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class IURecorrido extends JFrame {

	private static final long serialVersionUID = 6185298852846850116L;
	
	private JPanel contentPane;
	private JTable table;
	
	private GestorRecorrido gRecorrido;
	private List<Casa> listaCasas;

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
		
		gRecorrido = GestorRecorrido.getInstance();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
				realmenteCrearRecorrido();
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
		
		listaCasas = gRecorrido.getCodigoCasas();
		
		table = new JTable();
		DefaultTableModel tModel = new DefaultTableModel(
			new String[] {
				"Número Casa", "Propietario", "Población", "Añadir"
			}, 0
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		
		for (Casa casa: listaCasas) {
			tModel.addRow(new Object[]{casa.getNumCasa(), casa.getPropietario(), casa.getPoblacion(), new Boolean(false)});
		}
		
		table.setModel(tModel);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
	}
	
	public void crearRecorrido() {
		ComprobarAdministrador iuComprobarAdminstrador = new ComprobarAdministrador();
		iuComprobarAdminstrador.comprobar(new Runnable() {
			public void run() {
				IURecorrido.this.setVisible(true);
			}
		});
	}
	
	private void realmenteCrearRecorrido() {
		
		List<Integer> seleccionados = new ArrayList<Integer>();
		
		for (int i=0;i<table.getModel().getRowCount();i++) {
			if ((Boolean)table.getModel().getValueAt(i, 3)) {
				seleccionados.add((Integer)table.getModel().getValueAt(i, 0));
			}
		}
		
		boolean result = gRecorrido.asignarRecorrido(seleccionados);
		if (result) {
			JOptionPane.showMessageDialog(this, "El recorrido se ha insertado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Ha habido un error al insertar el recorrido", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
