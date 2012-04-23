package casarural;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import java.awt.Font;

/** @startuml
actor Propietario #black
Propietario --> IUAnularReservas : anularReservar(fechaInicio,fechaFin)
IUAnularReservas --> GestorReservas : obtReservas(fechaInicio,fechaFin)
GestorReservas --> GestorBD : seleccionarReservas(fechaInicio,fechaFin)
GestorReservas <-- GestorBD : listaDeReservas
IUAnularReservas <-- GestorReservas : listaDeReservas
loop Por cada reserva
	IUAnularReservas --> GestorReserva : anularReserva(codigoReserva)
	GestorReservas --> GestorBD : anularReserva(codigoReserva)
	GestorReservas <-- GestorBD : (confirmación,[devolución])
	IUAnularReservas <-- GestorReserva : (confirmación,[devolución])
end
Propietario <-- IUAnularReservas : devolución
 * @enduml
 */

public class AnularReservas extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;  //  @jve:decl-index=0:visual-constraint="553,10"
	
	private JCalendar jCalendar1 = new JCalendar();

	private Calendar calendarMio = null;
	
	private JCalendar jCalendar2 = new JCalendar();
	
	private Calendar calendarMio2 = null;

	private JLabel jLabelInicio = null;

	private JLabel jLabelFin = null;

	private JTextField jTextFieldInicio = null;

	private JTextField jTextFieldFin = null;

	private JButton jButtonListar = null;

	private JButton botonInicio = null;
	
	/**
	 * @throws HeadlessException
	 */
	public AnularReservas() throws HeadlessException {
		super();
		initialize();
	}

	/**
	 * @param arg0
	 */
	public AnularReservas(GraphicsConfiguration arg0) {
		super(arg0);
		initialize();
	}

	/**
	 * @param arg0
	 * @throws HeadlessException
	 */
	public AnularReservas(String arg0) throws HeadlessException {
		super(arg0);
		initialize();
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public AnularReservas(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		initialize();
	}

	/**
	 * This method initializes jTextFieldInicio	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldInicio() {
		if (jTextFieldInicio == null) {
			jTextFieldInicio = new JTextField();
			jTextFieldInicio.setBounds(new Rectangle(45, 270, 165, 31));
			jTextFieldInicio.setEditable(false);
		}
		return jTextFieldInicio;
	}

	/**
	 * This method initializes jTextFieldFin	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldFin() {
		if (jTextFieldFin == null) {
			jTextFieldFin = new JTextField();
			jTextFieldFin.setBounds(new Rectangle(315, 270, 165, 32));
			jTextFieldFin.setEditable(false);
		}
		return jTextFieldFin;
	}

	/**
	 * This method initializes jButtonListar.
	 * Incluye las acciones correspondientes al botón listar.
	 * 
	 * Comprueba que se hayan introducido fechas, tanto de inicio como de fin.
	 * Comprueba que la fecha de inicio sea anterior a la fecha de fin.
	 * Si no hay reservas muestra una pantalla de ResultadosAnular mostrando este hecho.
	 * Si hay reservas muestra una pantalla de ListadoReservas con las reservas correspondientes.
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonListar() {
		if (jButtonListar == null) {
			jButtonListar = new JButton();
			jButtonListar.setBounds(new Rectangle(105, 330, 106, 31));
			jButtonListar.setText("Listar");
			jButtonListar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (jTextFieldInicio.getText().equals("")
							|| jTextFieldFin.getText().equals("")) {
						JFrame alerta = new JFrame();
						try {
							JOptionPane.showMessageDialog(alerta,
									"seleccione las fechas de inicio y de fin",
									"Alerta", JOptionPane.WARNING_MESSAGE);
						} catch (Exception a) {
							System.out.println("error mostrando dialogo");
							a.printStackTrace();
						}
					}else {
						java.sql.Date di = new java.sql.Date(jCalendar1.getCalendar().getTime().getTime());
						java.sql.Date df = new java.sql.Date(jCalendar2.getCalendar().getTime().getTime());
						if(di.compareTo(df)>=0){
							JFrame alerta = new JFrame();
							try {
								JOptionPane.showMessageDialog(alerta,
										"La fecha de inicio ha de ser anterior a la de fin",
										"Alerta", JOptionPane.WARNING_MESSAGE);
							} catch (Exception a) {
								System.out.println("error mostrando dialogo");
								a.printStackTrace();
							}
						}else{
													    
							Vector<Reserva> vr;
							try {
								vr = PantallaInicio.interfazfachada.obtReservas(di, df);
							} catch (Exception e1) {
								System.out.println("Error al obtener las reservas");
								e1.printStackTrace();
								vr = new Vector<Reserva>();
							}
							if (vr==null || vr.isEmpty()){
								ResultadosAnular ra = new ResultadosAnular();
								ra.setVisible(true);
							}
							else{
								ListadoReservas ls = new ListadoReservas(vr);
								ls.setVisible(true);
							}
						}						
					}
				}
			});
		}
		return jButtonListar;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		//jCalendar1.setBounds(new Rectangle(284, 30, 212, 183));
		jCalendar2.setBounds(new Rectangle(295, 75, 200, 167));
		jCalendar1.setBounds(new Rectangle(30, 77, 200, 167));
		this.setSize(533, 437);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setTitle("Anular Reservas");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelFin = new JLabel();
			jLabelFin.setBounds(new Rectangle(300, 30, 195, 31));
			jLabelFin.setFont(new Font("Dialog", Font.BOLD, 14));
			jLabelFin.setText("Selccionar Fecha Fin:");
			jLabelInicio = new JLabel();
			jLabelInicio.setBounds(new Rectangle(30, 30, 197, 31));
			jLabelInicio.setFont(new Font("Dialog", Font.BOLD, 14));
			jLabelInicio.setText("Seleccionar Fecha Inicio:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setSize(new Dimension(375, 271));
			//jContentPane.add(jCalendar1, null);
			jContentPane.add(jCalendar1, null);
			jContentPane.add(jLabelInicio, null);
			jContentPane.add(jCalendar2, null);
			jContentPane.add(jLabelFin, null);
			jContentPane.add(getJTextFieldInicio(), null);
			jContentPane.add(getJTextFieldFin(), null);
			jContentPane.add(getJButtonListar(), null);
			jContentPane.add(getBotonInicio(), null);
			
			this.jCalendar2
			.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(
						PropertyChangeEvent propertychangeevent) {
					if (propertychangeevent.getPropertyName().equals(
							"locale")) {
						jCalendar2
								.setLocale((Locale) propertychangeevent
										.getNewValue());
						DateFormat dateformat = DateFormat
								.getDateInstance(1, jCalendar2
										.getLocale());
						jTextFieldFin.setText(dateformat
								.format(calendarMio2.getTime()));
					} else if (propertychangeevent.getPropertyName()
							.equals("calendar")) {
						calendarMio2 = (Calendar) propertychangeevent
								.getNewValue();
						DateFormat dateformat1 = DateFormat
								.getDateInstance(1, jCalendar2
										.getLocale());
						jTextFieldFin.setText(dateformat1
								.format(calendarMio2.getTime()));
						jCalendar2.setCalendar(calendarMio2);
					}
				}
			});
			
			this.jCalendar1.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent propertychangeevent) {
					if (propertychangeevent.getPropertyName().equals("locale")) {
						jCalendar1.setLocale((Locale) propertychangeevent.getNewValue());
						DateFormat dateformat = DateFormat.getDateInstance(1, jCalendar1.getLocale());
						jTextFieldInicio.setText(dateformat.format(calendarMio.getTime()));
						//jTextFieldInicio.setText(DateFormat.getDateInstance(DateFormat.SHORT).format(jCalendar1.getDate()));
					} else if (propertychangeevent.getPropertyName().equals("calendar")) {
						calendarMio = (Calendar) propertychangeevent.getNewValue();
						DateFormat dateformat1 = DateFormat.getDateInstance(1, jCalendar1.getLocale());
						jTextFieldInicio.setText(dateformat1.format(calendarMio.getTime()));
						//jTextFieldInicio.setText(DateFormat.getDateInstance(DateFormat.SHORT).format(jCalendar1.getDate()));
						jCalendar1.setCalendar(calendarMio);
					}
				}
			});
			
		}
		return jContentPane;
	}

	/**
	 * This method initializes botonInicio.
	 * Oculta la ventana actual, dejando a la vista la pantalla de inicio.
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBotonInicio() {
		if (botonInicio == null) {
			botonInicio = new JButton();
			botonInicio.setBounds(new Rectangle(315, 332, 106, 31));
			botonInicio.setText("Volver");
			botonInicio.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					AnularReservas.this.setVisible(false);
				}
			});
		}
		return botonInicio;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
