/**
 * 
 */
package casarural;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;

import javax.swing.JFrame;
import java.awt.Dimension;

import java.rmi.RemoteException;
import java.util.*;

import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ListadoReservas extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JScrollPane scroll = null;

	private JTable tabla = null;

	private JPanel pBoton = null;

	private JButton boton = null;
	
	private Vector<Reserva> vectReservas;

	private JButton botonVolver = null;
	

	/**
	 * This is the default constructor
	 */
	public ListadoReservas(Vector<Reserva> vr) throws HeadlessException {
		super();
		vectReservas = vr;
		initialize();
	}
	

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 387);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BoxLayout(getJContentPane(), BoxLayout.Y_AXIS));
			jContentPane.add(getScroll(), null);
			jContentPane.add(getPBoton(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes scroll	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScroll() {
		if (scroll == null) {
			scroll = new JScrollPane();
			scroll.setPreferredSize(new Dimension(400, 300));
			scroll.setSize(400, 300);
			scroll.setViewportView(mostrarReservas());
			scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		}
		return scroll;
	}

	/**
	 * This method initializes tabla.
	 * Inserta en la tabla las reservas existentes, que se encuentran en el vector inicializado en el constructor.
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable mostrarReservas() {
		if (tabla == null) {
			tabla = new JTable();
			Object[][] matriz = new Object[vectReservas.size()][4];
	        tabla.setModel(new ModeloTabla(
	            matriz,
	            new String [] {
	                "Número Reserva", "Número Casa", "Precio Total(€)", "¿Anular?"
	            }, false
	        ) {
	            Class[] types = new Class [] {
	                java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Boolean.class
	            };
	            
	            public Class getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }
	        });
	        
	        for(int i=0;i<vectReservas.size();i++){
	        	Reserva res = (Reserva)vectReservas.elementAt(i);
	        	tabla.setValueAt(res.getNumReserva(), i, 0);
	        	tabla.setValueAt(res.getNumCasa(), i, 1);
	        	tabla.setValueAt(res.getPrecioTotal(), i, 2);
	        	tabla.setValueAt(new Boolean(false), i, 3);
	        }

			tabla.setPreferredSize(new Dimension(400, 600));
			tabla.setPreferredScrollableViewportSize(new Dimension(200,100));
			tabla.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
			tabla.setRowSelectionAllowed(true);
			
		}
		return tabla;
	}

	/**
	 * This method initializes pBoton	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPBoton() {
		if (pBoton == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.insets = new Insets(0, 70, 0, 0);
			gridBagConstraints1.gridy = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(8, 0, 8, 0);
			gridBagConstraints.gridy = 0;
			gridBagConstraints.gridx = 0;
			pBoton = new JPanel();
			pBoton.setLayout(new GridBagLayout());
			pBoton.add(getBoton(), gridBagConstraints);
			pBoton.add(getBotonVolver(), gridBagConstraints1);
		}
		return pBoton;
	}

	/**
	 * This method initializes boton.
	 * Incluye las acciones correspondientes al botón anular.
	 * 
	 * Comprueba que se ha seleccionado alguna reserva a anular.
	 * Si hay reservas a anular, muestra una pantalla de ResultadosAnular, que mostrará los
	 *  resultados obtenidos tras la anulación.
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBoton() {
		if (boton == null) {
			boton = new JButton();
			boton.setText("Anular");
			boton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int[] res;
					String[] anulaciones;
					int selec=0;
					boolean b;
					for(int i=0;i<vectReservas.size();i++){
						b = ((Boolean)tabla.getValueAt(i,3)).booleanValue();
						if (b){selec++;}
					}
					//alerta si no se selecciona ninguna reserva
					if(selec==0){
						JFrame alerta = new JFrame();
						try {
							JOptionPane.showMessageDialog(alerta,
									"Selecciona alguna reserva para anular",
									"Alerta", JOptionPane.WARNING_MESSAGE);
						} catch (Exception a) {
							System.out.println("error mostrando dialogo");
							a.printStackTrace();
						}
					}else{
						res = new int[selec];
						anulaciones = new String[selec];
						int pos=0;
						for(int i=0;i<vectReservas.size();i++){
							b = ((Boolean)tabla.getValueAt(i,3)).booleanValue();
							if (b){
								anulaciones[pos]=(String)tabla.getValueAt(i, 0);
								pos++;
							}
						}
						try {
							res = PantallaInicio.interfazfachada.anularReservas(anulaciones);
						} catch (RemoteException e1) {
							System.out.println("Error en la conexión remota. ListadoReservas");
							e1.printStackTrace();
						} catch (Exception e1) {
							System.out.println("Error al anular reservas");
							e1.printStackTrace();
						}
						
						ResultadosAnular resu = new ResultadosAnular(anulaciones,res);
						ListadoReservas.this.setVisible(false);
						resu.setVisible(true);
					}
				}
			});
		}
		return boton;
	}


	/**
	 * This method initializes botonVolver.
	 * Oculta la ventana actual, dejando a la vista la correspondiente a AnularReservas.
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBotonVolver() {
		if (botonVolver == null) {
			botonVolver = new JButton();
			botonVolver.setText("Volver");
			botonVolver.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ListadoReservas.this.setVisible(false);
				}
			});
		}
		return botonVolver;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
