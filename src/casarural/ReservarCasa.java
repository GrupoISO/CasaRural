package casarural;
import com.toedter.calendar.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Color;
import java.util.GregorianCalendar;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.UIManager;


import java.util.List;
import javax.swing.JCheckBox;

/** @startuml
actor Cliente #red
Cliente --> IUReservarCasa : reservarCasa(codigoCasa,fechaEntrada,numeroNoches,telefono)
IUReservarCasa --> GestorReservas : reservar(codigoCasa,fechaEntrada,numeroNoches,telefono)
GestorReservas --> GestorReservas : ofertas = seleccionarReservas()
GestorReservas --> GestorReservas : Se comprueba que las ofertas cubren la reserva y se calcula el precio total
GestorReservas --> GestorReservas : transaccionDeReserva()
IUReservarCasa <-- GestorReservas : Confirmaci�n
Cliente <-- IUReservarCasa : Confirmaci�n
@enduml
 */


/*
Alice -> Bob: Authentication Request
Bob --> Alice: Authentication Response

Alice -> Bob: Another authentication Request
Alice <-- Bob: another authentication Response
 */

public class ReservarCasa extends JFrame
{
	private long dia;
	private JLabel jLabel1 = new JLabel();
	private JTextField jTextField1 = new JTextField();
	private JLabel jLabel2 = new JLabel();
	private JLabel jLabel3 = new JLabel();
	private JLabel jLabel4 = new JLabel();
	private JTextField jTextField2 = new JTextField();
	private JTextField jTextField3 = new JTextField();
	private JTextField jTextField4 = new JTextField();
	private JButton jButton2 = new JButton();
	private JButton jButton3 = new JButton();
	private JComboBox comboBoxServicios = new JComboBox();
	private JComboBox comboBoxPlazas = new JComboBox();
	private JCheckBox chckbxServicio = new JCheckBox("Contratar servicio");

	// Codigo para el JCalendar
	private JCalendar jCalendar1 = new JCalendar();
	private Calendar calendarMio = null;
	private JLabel jLabel5 = new JLabel();

	//Para inicializar la página con mis propios datos
	private boolean deOferta = false;
	private int codigo = 0;
	private java.sql.Date diaIni = new java.sql.Date(new java.util.Date().getTime());
	private int numNomches;
	private boolean selected = false;
	private boolean existeServicio = false;

	public ReservarCasa()
	{
		try
		{
			jbInit();


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public ReservarCasa(int numCasa,Date inicio,Date fin)
	{
		try
		{
			jbInit();

			jTextField1.setText(Integer.toString(numCasa));
			long numNoches=(fin.getTime()-inicio.getTime())/(1000*60*60*24);
			jTextField3.setText(Long.toString(numNoches));
			DateFormat dateformat1 = DateFormat.getDateInstance(1);

			Date diaIni= new Date((long)(inicio.getTime()));
			jTextField2.setText(dateformat1.format(diaIni));
			GregorianCalendar cal=new GregorianCalendar();
			cal.setTime(diaIni);
			int anio=cal.get(Calendar.YEAR);
			int mes=cal.get(Calendar.MONTH);
			int dia=cal.get(Calendar.DAY_OF_MONTH);




			JYearChooser yc=jCalendar1.getYearChooser();
			JMonthChooser mc=   jCalendar1.getMonthChooser();
			JDayChooser dc= jCalendar1.getDayChooser();


			yc.setYear(anio);
			mc.setMonth(mes);
			dc.setDay(dia);




		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception
	{
		this.getContentPane().setLayout(null);
		this.setSize(new Dimension(472, 541));
		this.setTitle("Reservar casa rural");
		jLabel1.setText("Codigo de la casa:");
		jLabel1.setBounds(new Rectangle(15, 10, 115, 20));
		jTextField1.setBounds(new Rectangle(155, 10, 140, 20));
		jTextField1.setToolTipText("null");
		jTextField1.setText("0");
		jTextField1.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent e)
			{
			}

			public void focusLost(FocusEvent e)
			{
				jTextField1_focusLost();
			}
		});
		jTextField3.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent e)
			{
			}

			public void focusLost(FocusEvent e)
			{
				jTextField3_focusLost();
			}
		});
		jTextField4.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent e)
			{
			}

			public void focusLost(FocusEvent e)
			{
				jTextField4_focusLost();
			}
		});
		jLabel2.setText("Dia de entrada:");
		jLabel2.setBounds(new Rectangle(15, 40, 115, 20));
		jLabel3.setText("Numero de noches:");
		jLabel3.setBounds(new Rectangle(15, 240, 115, 20));
		jLabel4.setText("Telefono de contacto:");
		jLabel4.setBounds(new Rectangle(15, 270, 140, 20));
		jTextField2.setBounds(new Rectangle(222, 208, 140, 20));
		jTextField2.setEditable(false);
		jTextField3.setBounds(new Rectangle(222, 239, 140, 20));
		jTextField3.setText("0");
		jTextField4.setBounds(new Rectangle(222, 270, 140, 20));
		jTextField4.setText("0");
		jButton2.setText("Aceptar");
		jButton2.setBounds(new Rectangle(51, 462, 130, 30));
		jButton2.setSize(new Dimension(130, 30));
		jButton2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Codigo a ejecutar cuando se clickee sobre el boton aceptar
				// Codigo de la casa
				int numCasa=Integer.parseInt(jTextField1.getText());
				// Dia entrada
				Date diaIni= new Date(jCalendar1.getCalendar().getTime().getTime());
				//Eliminamos la parte de hora:minuto:segundo:ms de la fecha para normalizarla con lo que aparece en la BD
				diaIni=Date.valueOf(diaIni.toString());
				// Dia fin
				// Numero de dias expresado en milisegundos
				long numnoches=1000*60*60*24* Integer.parseInt(jTextField3.getText());
				Date diaFin= new Date((long)(diaIni.getTime()+numnoches));
				// Telefono de contacto
				String numTfnoReserva=jTextField4.getText();
				try {
					Reserva reserva;
					if (chckbxServicio.isSelected()) {
						// Servicio contratado
						Servicio servicio = (Servicio) comboBoxServicios.getSelectedItem();
						// Plazas contratadas
						Integer plazasContratadas = (Integer) comboBoxPlazas.getSelectedItem();
						
						reserva=PantallaInicio.interfazfachada.reservar(diaIni, diaFin, numCasa, numTfnoReserva, servicio.getNumServicio(), plazasContratadas);

					}
					else {
						// Llamada al metodo remoto Reservar
						reserva=PantallaInicio.interfazfachada.reservar(diaIni, diaFin, numCasa, numTfnoReserva);
						// Si llega a ejecutarse lo siguiente es que se puede reservar
					}
					ConfirmarReserva confirmarreserva=new ConfirmarReserva(reserva.getNumCasa(), reserva.getPrecioTotal(), reserva.getNumReserva());
					confirmarreserva.setVisible(true);
				} catch (RemoteException e1) {

					e1.printStackTrace();
				} catch (NoSePuedeReservarException e1) {
					//INCLUDES Consultar disponibilidad
					jLabel5.setText("Error: No se puede reservar");
					JFrame a = new ConsultarDisponibilidad();
					a.setVisible(true);
				}
			}
		});
		jButton3.setText("Cancelar");
		jButton3.setBounds(new Rectangle(260, 462, 130, 30));
		jButton3.setSize(new Dimension(130, 30));
		jButton3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				jButton3_actionPerformed(e);
			}
		});
		jLabel5.setBounds(new Rectangle(15, 441, 430, 20));
		jLabel5.setForeground(Color.red);
		jCalendar1.setBounds(new Rectangle(155, 50, 235, 145));
		this.getContentPane().add(jCalendar1, null);
		this.getContentPane().add(jLabel5, null);
		this.getContentPane().add(jButton3, null);
		this.getContentPane().add(jButton2, null);
		this.getContentPane().add(jTextField4, null);
		this.getContentPane().add(jTextField3, null);
		this.getContentPane().add(jTextField2, null);
		this.getContentPane().add(jLabel4, null);
		this.getContentPane().add(jLabel3, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(jTextField1, null);
		this.getContentPane().add(jLabel1, null);

		JLabel lbldeseaServicioDe = new JLabel("¿Desea servicio de recogida?");
		lbldeseaServicioDe.setBounds(15, 303, 181, 20);
		getContentPane().add(lbldeseaServicioDe);
		comboBoxServicios.setEnabled(false);

		comboBoxServicios.setBounds(15, 336, 430, 20);
		getContentPane().add(comboBoxServicios);

		JTextPane textInfoServicio = new JTextPane();
		textInfoServicio.setBackground(UIManager.getColor("Button.background"));
		textInfoServicio.setEnabled(false);
		textInfoServicio.setEditable(false);
		textInfoServicio.setBounds(15, 392, 430, 43);
		getContentPane().add(textInfoServicio);
		
		GestorServicio gServicio = GestorServicio.getInstance();
		List<Servicio> servicios = gServicio.mostrarServicios(Integer.parseInt(jTextField1.getText()), diaIni);
		comboBoxServicios.setModel(new DefaultComboBoxModel(servicios.toArray()));
		
		
		chckbxServicio.setBounds(222, 302, 168, 23);
		getContentPane().add(chckbxServicio);
		
		JLabel lblcuntasPlazasDesea = new JLabel("¿Cuántas plazas desea?");
		lblcuntasPlazasDesea.setBounds(15, 368, 140, 20);
		getContentPane().add(lblcuntasPlazasDesea);
		
		comboBoxPlazas.setEnabled(false);
		comboBoxPlazas.setBounds(222, 367, 140, 20);
		getContentPane().add(comboBoxPlazas);
		
		chckbxServicio.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		          AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
		          selected = abstractButton.getModel().isSelected();
		          comboBoxServicios.setEnabled(selected&&existeServicio);
		          comboBoxPlazas.setEnabled(selected&&existeServicio);
		          }
		      }
		);
		
		comboBoxServicios.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				Servicio servicio = (Servicio)comboBoxServicios.getSelectedItem();
				Integer plazasLibres = servicio.getNumPlazas() - servicio.getNumPlazasReservadas();
				
				Vector<Integer> listaLibre = new Vector<Integer>(plazasLibres);
				for(Integer i=1; i<=plazasLibres; i++) {
					listaLibre.add(i);
				}
				
				comboBoxPlazas.setModel(new DefaultComboBoxModel(listaLibre));
			}
		});

		// Codigo para el JCalendar
		this.jCalendar1.addPropertyChangeListener(new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent propertychangeevent)
			{
				if (propertychangeevent.getPropertyName().equals("locale"))
				{
					jCalendar1.setLocale((Locale) propertychangeevent.getNewValue());
					DateFormat dateformat = DateFormat.getDateInstance(1, jCalendar1.getLocale());
					jTextField2.setText(dateformat.format(calendarMio.getTime()));

				}
				else if (propertychangeevent.getPropertyName().equals("calendar"))
				{
					calendarMio = (Calendar) propertychangeevent.getNewValue();
					DateFormat dateformat1 = DateFormat.getDateInstance(1, jCalendar1.getLocale());
					jTextField2.setText(dateformat1.format(calendarMio.getTime()));
					jCalendar1.setCalendar(calendarMio);
					diaIni = new java.sql.Date(calendarMio.getTime().getTime());
					actualizarCambios();
				}
			} 
		});
	}

	private void actualizarCambios(){
		GestorServicio gServicio = GestorServicio.getInstance();
		List<Servicio> servicios = gServicio.mostrarServicios(codigo, diaIni);
				
		if(servicios.isEmpty()) {
			comboBoxServicios.setModel(new DefaultComboBoxModel(new String[]{"No existen servicios para esta reserva"}));
			existeServicio = false;
			comboBoxServicios.setEnabled(selected&&false);
			comboBoxPlazas.setEnabled(selected&&false);
		}
		else {
			comboBoxServicios.setModel(new DefaultComboBoxModel(servicios.toArray()));
			existeServicio = true;
			comboBoxServicios.setEnabled(selected&&true);
			comboBoxPlazas.setEnabled(selected&&true);
			
			Servicio servicio = (Servicio)comboBoxServicios.getSelectedItem();
			Integer plazasLibres = servicio.getNumPlazas() - servicio.getNumPlazasReservadas();
			
			Vector<Integer> listaLibre = new Vector<Integer>(plazasLibres);
			for(Integer i=1; i<=plazasLibres; i++) {
				listaLibre.add(i);
			}
			
			comboBoxPlazas.setModel(new DefaultComboBoxModel(listaLibre));
		}
	}
	public static void main (String[] args)
	{
		new ReservarCasa();
	}

	private void jButton3_actionPerformed(ActionEvent e)
	{
		this.setVisible(false);
	}

	private void jTextField1_focusLost()
	{
		try
		{
			codigo = Integer.parseInt(jTextField1.getText());
			actualizarCambios();
			new Integer (jTextField1.getText());
			jLabel5.setText("");
		}
		catch (NumberFormatException ex)
		{
			jLabel5.setText("Error: Introduzca un numero");
		}
	}
	private void jTextField3_focusLost()
	{
		try
		{
			new Integer (jTextField3.getText());
			jLabel5.setText("");
		}
		catch (NumberFormatException ex)
		{
			jLabel5.setText("Error: Introduzca un numero");
		}
	}

	private void jTextField4_focusLost()
	{
		try
		{
			new Integer (jTextField4.getText());
			jLabel5.setText("");
		}
		catch (NumberFormatException ex)
		{
			jLabel5.setText("Error: Introduzca un numero");
		}
	}
}