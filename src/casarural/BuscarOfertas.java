package casarural;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

/** @startuml
actor Cliente #red
Cliente --> IUBuscarOfertas : buscarOfertas(fechaEntrada,fechaSalida,[numDias],[precioMinimo],[minDormitorios],[minBa�os],[criterio(precio|dias)])
IUBuscarOfertas --> GestorOfertas : buscarOfertas(fechaEntrada,fechaSalida,[numDias],[precioMinimo],[minDormitorios],[minBa�os],[criterio(precio|dias)])
GestorOfertas --> GestorBD : 2. seleccionarCasasDorWC(fechaEntrada,fechaSalida,[numDias],[precioMinimo],[minDormitorios],[minBa�os],[criterio(precio|dias)])
GestorOfertas <-- GestorBD : listaDeOfertas
IUBuscarOfertas <-- GestorOfertas : listaDeOfertas
 * @enduml
 */

public class BuscarOfertas extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel FInicio = null;

	private JLabel FFin = null;

	private JLabel PrecioMax = null;

	private JTextField TextPrecio = null;

	private JLabel NumDiasMin = null;

	private JTextField TextDias = null;

	private JLabel Dormitorios = null;

	private JTextField TextDormitorios = null;

	private JLabel Banos = null;

	private JTextField TextBanos = null;

	private JPanel PInicio = null;

	private JPanel PFin = null;

	private JPanel PDias = null;

	private JPanel PPrecio = null;

	private JPanel PDormitorios = null;

	private JPanel PBanos = null;

	private JPanel PBuscar = null;

	// Codigo para el JCalendar
	private JTextField jTextField2 = new JTextField();

	private JCalendar jCalendar1 = new JCalendar();

	private Calendar calendarMio = null;

	private JLabel jLabel4 = new JLabel();

	private JTextArea jTextArea1 = new JTextArea();

	private JTextField jTextField3 = new JTextField();

	private JCalendar jCalendar2 = new JCalendar();

	private Calendar calendarMio2 = null;

	private JLabel jLabel5 = new JLabel();

	private JTextArea jTextArea2 = new JTextArea();

	private JButton Buscar = null;

	private JPanel POrden = null;

	private JRadioButton RPrecio = null;

	private JRadioButton RDias = null;

	private JLabel JOrden = null;

	private ButtonGroup group = new ButtonGroup();

	/**
	 * This is the default constructor
	 */
	public BuscarOfertas() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jTextField3.setPreferredSize(new Dimension(140, 20));
		jTextField3.setEditable(false);
		jTextField2.setPreferredSize(new Dimension(140, 20));
		jTextField2.setEditable(false);
		this.setSize(440, 700);
		this.setResizable(false);
		this.setPreferredSize(new Dimension(700, 542));
		this.setContentPane(getJContentPane());
		this.setTitle("Buscador de Ofertas");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			Banos = new JLabel();
			Banos.setText("N�mero m�nimo de ba�os");
			Dormitorios = new JLabel();
			Dormitorios.setText("N�mero m�nimo de dormitorios");
			NumDiasMin = new JLabel();
			NumDiasMin.setText("N�mero de d�as m�nimo");
			PrecioMax = new JLabel();
			PrecioMax.setText("Precio m�ximo");
			FFin = new JLabel();
			FFin.setText("Fecha de fin");
			FInicio = new JLabel();
			FInicio.setText("Fecha de inicio");

			jContentPane = new JPanel();
			jContentPane.setLayout(new BoxLayout(getJContentPane(),
					BoxLayout.Y_AXIS));
			jContentPane.add(getPInicio(), null);
			jContentPane.add(getPFin(), null);
			jContentPane.add(getPDias(), null);
			jContentPane.add(getPPrecio(), null);
			jContentPane.add(getPDormitorios(), null);
			jContentPane.add(getPBanos(), null);
			jContentPane.add(getPOrden(), null);
			jContentPane.add(getPBuscar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes TextPrecio
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTextPrecio() {
		if (TextPrecio == null) {
			TextPrecio = new JTextField();
			TextPrecio.setPreferredSize(new Dimension(100, 20));
		}
		return TextPrecio;
	}

	/**
	 * This method initializes TextDias
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTextDias() {
		if (TextDias == null) {
			TextDias = new JTextField();
			TextDias.setPreferredSize(new Dimension(100, 20));
		}
		return TextDias;
	}

	/**
	 * This method initializes TextDormitorios
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTextDormitorios() {
		if (TextDormitorios == null) {
			TextDormitorios = new JTextField();
			TextDormitorios.setPreferredSize(new Dimension(100, 20));
		}
		return TextDormitorios;
	}

	/**
	 * This method initializes TextBaños
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTextBanos() {
		if (TextBanos == null) {
			TextBanos = new JTextField();
			TextBanos.setPreferredSize(new Dimension(100, 20));
		}
		return TextBanos;
	}

	/**
	 * This method initializes PInicio
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPInicio() {
		if (PInicio == null) {

			jLabel4.setBounds(new Rectangle(55, 300, 305, 30));
			jLabel4.setForeground(Color.red);
			jTextArea1.setEditable(false);
			jCalendar1.setBounds(new Rectangle(190, 60, 225, 150));
			jTextArea1.setText("");

			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setHgap(5);
			flowLayout.setVgap(5);
			PInicio = new JPanel();
			PInicio.setPreferredSize(new Dimension(469, 220));
			PInicio.setLayout(flowLayout);
			PInicio.add(FInicio, null);
			PInicio.add(jLabel4, null);
			PInicio.add(jTextField2, null);
			PInicio.add(jCalendar1, null);
			// Codigo para el JCalendar
			this.jCalendar1
					.addPropertyChangeListener(new PropertyChangeListener() {
						public void propertyChange(
								PropertyChangeEvent propertychangeevent) {
							if (propertychangeevent.getPropertyName().equals(
									"locale")) {
								jCalendar1
										.setLocale((Locale) propertychangeevent
												.getNewValue());
								DateFormat dateformat = DateFormat
										.getDateInstance(1, jCalendar1
												.getLocale());
								jTextField2.setText(dateformat
										.format(calendarMio.getTime()));
							} else if (propertychangeevent.getPropertyName()
									.equals("calendar")) {
								calendarMio = (Calendar) propertychangeevent
										.getNewValue();
								DateFormat dateformat1 = DateFormat
										.getDateInstance(1, jCalendar1
												.getLocale());
								jTextField2.setText(dateformat1
										.format(calendarMio.getTime()));
								jCalendar1.setCalendar(calendarMio);
							}
						}
					});

		}
		return PInicio;
	}

	/**
	 * This method initializes PFin
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPFin() {
		if (PFin == null) {
			jLabel5.setBounds(new Rectangle(55, 300, 305, 30));
			jLabel5.setForeground(Color.red);
			jTextArea2.setEditable(false);
			jCalendar2.setBounds(new Rectangle(190, 60, 225, 150));
			jTextArea2.setText("");

			PFin = new JPanel();
			PFin.setLayout(new FlowLayout());
			PFin.setPreferredSize(new Dimension(453, 220));
			PFin.add(FFin, null);
			PFin.add(jLabel5, null);
			PFin.add(jTextField3, null);
			PFin.add(jCalendar2, null);
			// Codigo para el JCalendar
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
								jTextField3.setText(dateformat
										.format(calendarMio2.getTime()));
							} else if (propertychangeevent.getPropertyName()
									.equals("calendar")) {
								calendarMio2 = (Calendar) propertychangeevent
										.getNewValue();
								DateFormat dateformat1 = DateFormat
										.getDateInstance(1, jCalendar2
												.getLocale());
								jTextField3.setText(dateformat1
										.format(calendarMio2.getTime()));
								jCalendar2.setCalendar(calendarMio2);
							}
						}
					});

		}
		return PFin;
	}

	/**
	 * This method initializes PDias
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPDias() {
		if (PDias == null) {
			FlowLayout flowLayout2 = new FlowLayout();
			flowLayout2.setHgap(46);
			PDias = new JPanel();
			PDias.setLayout(flowLayout2);
			PDias.setComponentOrientation(ComponentOrientation.UNKNOWN);
			PDias.add(NumDiasMin, null);
			PDias.add(getTextDias(), null);

		}
		return PDias;
	}

	/**
	 * This method initializes PPrecio
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPPrecio() {
		if (PPrecio == null) {
			FlowLayout flowLayout3 = new FlowLayout();
			flowLayout3.setHgap(93);
			PPrecio = new JPanel();
			PPrecio.setLayout(flowLayout3);
			PPrecio.add(PrecioMax, null);
			PPrecio.add(getTextPrecio(), null);
		}
		return PPrecio;
	}

	/**
	 * This method initializes PDormitorios
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPDormitorios() {
		if (PDormitorios == null) {
			PDormitorios = new JPanel();
			PDormitorios.setLayout(new FlowLayout());
			PDormitorios.add(Dormitorios, null);
			PDormitorios.add(getTextDormitorios(), null);
		}
		return PDormitorios;
	}

	/**
	 * This method initializes PBanos
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPBanos() {
		if (PBanos == null) {
			FlowLayout flowLayout4 = new FlowLayout();
			flowLayout4.setHgap(33);
			PBanos = new JPanel();
			PBanos.setLayout(flowLayout4);
			PBanos.add(Banos, null);
			PBanos.add(getTextBanos(), null);
		}
		return PBanos;
	}

	/**
	 * This method initializes PBuscar
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPBuscar() {
		if (PBuscar == null) {
			PBuscar = new JPanel();
			PBuscar.setLayout(new FlowLayout());
			PBuscar.add(getBuscar(), null);
		}
		return PBuscar;
	}

	/**
	 * This method initializes Buscar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBuscar() {
		if (Buscar == null) {
			Buscar = new JButton();
			Buscar.setText("Buscar");
			Buscar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (jTextField2.getText().equals("")
							|| jTextField3.getText().equals("")) {
						JFrame alerta = new JFrame();
						try {
							JOptionPane.showMessageDialog(alerta,
									"seleccione las fechas de inicio y de fin",
									"Alerta", JOptionPane.WARNING_MESSAGE);
						} catch (Exception a) {
							System.out.println("error mostrando dialogo");
							a.printStackTrace();
						}
					} else {
						Date dIni = new Date(jCalendar1.getCalendar().getTime()
								.getTime());
						Date dFin = new Date(jCalendar2.getCalendar().getTime()
								.getTime());
						int dmin, dorm, ban;
						float pmax;
						boolean orden = RPrecio.isSelected();
						// comprobamos si el campo está vacío. Si no lo está,
						// pasamos a integer, sino a -1
						if (!TextDias.getText().equals("")) {
							dmin = Integer.parseInt(TextDias.getText());
						} else {
							dmin = 0;
						}
						if (!TextPrecio.getText().equals("")) {
							pmax = Float.parseFloat(TextPrecio.getText());
						} else {
							pmax = 0;
						}
						if (!TextDormitorios.getText().equals("")) {
							dorm = Integer.parseInt(TextDormitorios.getText());
						} else {
							dorm = 0;
						}
						if (!TextBanos.getText().equals("")) {
							ban = Integer.parseInt(TextBanos.getText());
						} else {
							ban = 0;
						}

						// comprobamos que la fecha de fin es posterior a la de
						// inicio
						if (dFin.before(dIni)) {
							JFrame alerta = new JFrame();
							try {
								JOptionPane
										.showMessageDialog(
												alerta,
												"la fecha de fin debe ser posterior a la de inicio",
												"Alerta",
												JOptionPane.WARNING_MESSAGE);
							} catch (Exception a) {
								System.out.println("error mostrando dialogo");
								a.printStackTrace();
							}
						} else { // llamamos a buscarOferta y le pasamos los
									// valores
							List<Oferta> resultado;
							try {
								resultado = PantallaInicio.interfazfachada
										.buscarOfertas(dIni, dFin, pmax, dmin,
												dorm, ban, orden);

							} catch (Exception ex) {
								ex.printStackTrace();
								resultado = new ArrayList<Oferta>();
							}

							kisama a = new kisama(resultado);
							a.setVisible(true);
						}
					}
				}
			});
		}
		return Buscar;
	}

	/**
	 * This method initializes POrden
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPOrden() {
		if (POrden == null) {
			FlowLayout flowLayout1 = new FlowLayout();
			flowLayout1.setHgap(47);
			JOrden = new JLabel();
			JOrden.setText("Ordenar por:");
			POrden = new JPanel();
			POrden.setLayout(flowLayout1);
			POrden.add(JOrden, null);
			POrden.add(getRPrecio(), null);
			POrden.add(getRDias(), null);
		}
		return POrden;
	}

	/**
	 * This method initializes RPrecio
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getRPrecio() {
		if (RPrecio == null) {
			RPrecio = new JRadioButton();
			RPrecio.setText("Precio");
			group.add(RPrecio);
			RPrecio.setSelected(true);
		}
		return RPrecio;
	}

	/**
	 * This method initializes RDias
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getRDias() {
		if (RDias == null) {
			RDias = new JRadioButton();
			RDias.setText("Días");
			group.add(RDias);
		}
		return RDias;
	}

} // @jve:decl-index=0:visual-constraint="9,11"
