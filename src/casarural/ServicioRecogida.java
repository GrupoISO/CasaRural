package casarural;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.EventQueue;

import java.sql.Date;
import java.text.NumberFormat;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import com.toedter.calendar.JCalendar;
import javax.swing.JTextField;


public class ServicioRecogida extends JFrame {

	private static final long serialVersionUID = 1208945330927554713L;
	
	private JPanel contentPane;
	private JComboBox recorridosComboBox;
	private JComboBox recogidasComboBox;
	private JFormattedTextField plazasTextField;
	private JFormattedTextField precioTextField;
	private JCalendar calendar;
	private JFormattedTextField textHora;
	private JFormattedTextField textMin;
	private JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServicioRecogida frame = new ServicioRecogida();
					frame.crearServicio();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ServicioRecogida() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		calendar = new JCalendar();
		calendar.setBounds(123, 34, 237, 144);
		contentPane.add(calendar);
		
		JLabel lblRecorridos = new JLabel("Recorrido");
		lblRecorridos.setBounds(152, 307, 84, 16);
		contentPane.add(lblRecorridos);
		
		recorridosComboBox = new JComboBox();
		recorridosComboBox.setBounds(152, 325, 182, 27);
		contentPane.add(recorridosComboBox);
		
		JLabel lblServ = new JLabel("Recogida");
		lblServ.setBounds(152, 369, 84, 16);
		contentPane.add(lblServ);
		
		recogidasComboBox = new JComboBox();
		recogidasComboBox.setBounds(152, 396, 182, 27);
		contentPane.add(recogidasComboBox);
		
		Button button = new Button("Confirmar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finalCrearServicio();
			}
		});
		button.setBounds(192, 517, 101, 28);
		contentPane.add(button);
		
		plazasTextField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		plazasTextField.setBounds(152, 268, 182, 28);
		plazasTextField.setValue(new Integer(0));
		contentPane.add(plazasTextField);
		plazasTextField.setColumns(10);
		
		JLabel lblPlazas = new JLabel("Plazas");
		lblPlazas.setBounds(152, 252, 61, 16);
		contentPane.add(lblPlazas);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(152, 6, 61, 16);
		contentPane.add(lblFecha);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(152, 190, 61, 16);
		contentPane.add(lblPrecio);
		
		precioTextField = new JFormattedTextField(NumberFormat.getInstance());
		precioTextField.setBounds(152, 213, 182, 28);
		precioTextField.setValue(new Float(0.0f));
		contentPane.add(precioTextField);
		precioTextField.setColumns(10);
		
		textHora = new JFormattedTextField(NumberFormat.getInstance());
		textHora.setText("23");
		textHora.setBounds(186, 470, 50, 20);
		textHora.setValue(new Integer(23));
		contentPane.add(textHora);
		textHora.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(152, 445, 61, 14);
		contentPane.add(lblHora);
		
		JLabel label = new JLabel(":");
		label.setBounds(247, 473, 46, 14);
		contentPane.add(label);
		
		textMin = new JFormattedTextField(NumberFormat.getInstance());
		textMin.setValue(new Integer(59));
		textMin.setBounds(257, 470, 50, 20);
		contentPane.add(textMin);
		textMin.setColumns(10);
		
		lblError = new JLabel("");
		lblError.setBounds(10, 497, 415, 14);
		contentPane.add(lblError);
	}

	public void crearServicio() {
		ComprobarAdministrador iuComprobarAdminstrador = new ComprobarAdministrador();
		iuComprobarAdminstrador.comprobar(new Runnable() {
			public void run() {
				realmenteCrearServicio();
			}
		});
	}
	
	private void realmenteCrearServicio() {
		GestorServicio gServicio = GestorServicio.getInstance();
		GestorRecorrido gRecorrido = GestorRecorrido.getInstance();

		List<Recorrido> recorridos = gRecorrido.getRecorridos();
		List<Recogida> recogidas = gServicio.getRecogidas();
		
		recorridosComboBox.setModel(new DefaultComboBoxModel(recorridos.toArray()));
		recogidasComboBox.setModel(new DefaultComboBoxModel(recogidas.toArray()));
		
		this.setVisible(true);
	}
	
	private void finalCrearServicio() {
		Servicio servicio = new Servicio();
		
		servicio.setFecha(new Date(calendar.getCalendar().getTimeInMillis()));
		servicio.setNumPlazas(((Long)plazasTextField.getValue()).intValue());
		servicio.setPrecio(((Long)precioTextField.getValue()).floatValue());
		servicio.setNumRecogida(((Recogida)recogidasComboBox.getSelectedItem()).getNumRecogida());
		servicio.setNumRecorrido(((Recorrido)recorridosComboBox.getSelectedItem()).getNumRecorrido());
		if(((Integer)textHora.getValue()).intValue() < 0 || ((Integer)textHora.getValue()).intValue() > 23 
				|| ((Integer)textMin.getValue()).intValue() < 0 || ((Integer)textMin.getValue()).intValue() > 59)
		{
			lblError.setText("Formato erroneo: Hora(0..23) Minutos(0..59");
		}
		else
		{
			servicio.setHora(java.sql.Time.valueOf(((Integer)textHora.getValue()).toString() + ":" + ((Integer)textMin.getValue()).toString() + ":00"));
			GestorServicio gServicio = GestorServicio.getInstance();

			boolean result = gServicio.crearServicio(servicio);

			if (result) {
				JOptionPane.showMessageDialog(this, "Se ha guardado con exito",
						"exito al guardar", JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Ha habido un error al guardar",
						"Error al crear", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
