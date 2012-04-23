package casarural;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;


import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.rmi.Naming;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/** @startuml

left to right direction

Propietario -> (Asignar Disponibilidad)
Propietario -> (Anular Reserva)

Cliente -> (Buscar Ofertas)
Cliente -> (Consultar Disponibilidad)
Cliente -> (Reservar Casa Rural)
Cliente -> (Encontrar Mejor Reserva)
(Encontrar Mejor Reserva) .> (Reservar Casa Rural) : <>


* @enduml
*/

public class PantallaInicio extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton boton1 = null;

	private JButton boton2 = null;

	private JPanel pReservar = null;

	private JPanel pAsignar = null;

	private JPanel pConsultar = null;

	private JButton boton3 = null;

	private JPanel pMejor = null;

	private JButton boton4 = null;

	private JPanel pSalir = null;

	private JButton boton5 = null;

	private JPanel pBuscar = null;

	private JButton boton6 = null;
	
	private JPanel pAnular = null;
	
	private JButton boton7 = null;
	
	public static InterfazFachada interfazfachada;
	
	private JPanel pRecorrido;
	
	private JButton btnCrearRecorrido;
	
	private JPanel pRecogida;
	
	private JButton btnServRecogida;

	/**
	 * This is the default constructor
	 */
	public PantallaInicio() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(271, 377);
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
			jContentPane.add(getPReservar(), null);
			jContentPane.add(getPAsignar(), null);
			jContentPane.add(getPConsultar(), null);
			jContentPane.add(getPMejor(), null);
			jContentPane.add(getPBuscar(), null);
			jContentPane.add(getPAnular(), null);
			jContentPane.add(getPRecorrido());
			jContentPane.add(getPRecogida());
			jContentPane.add(getPSalir(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes boton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBoton1() {
		if (boton1 == null) {
			boton1 = new JButton();
			boton1.setText("Reservar Casa Rural");
			boton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFrame a = new ReservarCasa();
				    a.setVisible(true);
				}
			});
		}
		return boton1;
	}

	/**
	 * This method initializes boton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBoton2() {
		if (boton2 == null) {
			boton2 = new JButton();
			boton2.setText("Asignar Disponibilidad");
			boton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				    JFrame a = new AsignarDisponibilidad();
				    a.setVisible(true);
				}
			});
		}
		return boton2;
	}

	/**
	 * This method initializes pReservar	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPReservar() {
		if (pReservar == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.fill = GridBagConstraints.NONE;
			gridBagConstraints2.gridwidth = 1;
			gridBagConstraints2.ipadx = 45;
			gridBagConstraints2.insets = new Insets(8, 0, 5, 0);
			pReservar = new JPanel();
			pReservar.setLayout(new GridBagLayout());
			pReservar.add(getBoton1(), gridBagConstraints2);
		}
		return pReservar;
	}

	/**
	 * This method initializes pAsignar	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPAsignar() {
		if (pAsignar == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.insets = new Insets(5, 0, 5, 0);
			gridBagConstraints3.ipadx = 38;
			pAsignar = new JPanel();
			pAsignar.setLayout(new GridBagLayout());
			pAsignar.add(getBoton2(), gridBagConstraints3);
		}
		return pAsignar;
	}

	/**
	 * This method initializes pConsultar	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPConsultar() {
		if (pConsultar == null) {
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.insets = new Insets(5, 0, 5, 0);
			gridBagConstraints4.ipadx = 28;
			pConsultar = new JPanel();
			pConsultar.setLayout(new GridBagLayout());
			pConsultar.add(getBoton3(), gridBagConstraints4);
		}
		return pConsultar;
	}

	/**
	 * This method initializes boton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBoton3() {
		if (boton3 == null) {
			boton3 = new JButton();
			boton3.setText("Consultar Disponibilidad");
			boton3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFrame a = new ConsultarDisponibilidad();
				    a.setVisible(true);
				}
			});
		}
		return boton3;
	}

	/**
	 * This method initializes pMejor	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPMejor() {
		if (pMejor == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.insets = new Insets(5, 0, 5, 0);
			gridBagConstraints5.ipadx = 21;
			pMejor = new JPanel();
			pMejor.setLayout(new GridBagLayout());
			pMejor.add(getBoton4(), gridBagConstraints5);
		}
		return pMejor;
	}

	/**
	 * This method initializes boton4	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBoton4() {
		if (boton4 == null) {
			boton4 = new JButton();
			boton4.setText("Encontrar Mejor Reserva");
			boton4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					encontrarMejorReserva emr=new encontrarMejorReserva();
					  emr.setVisible(true);
				}
			});
		}
		return boton4;
	}

	/**
	 * This method initializes pSalir	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPSalir() {
		if (pSalir == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = -1;
			gridBagConstraints1.insets = new Insets(5, 0, 5, 0);
			gridBagConstraints1.gridy = -1;
			pSalir = new JPanel();
			pSalir.setLayout(new GridBagLayout());
			pSalir.add(getBoton6(), gridBagConstraints1);
		}
		return pSalir;
	}

	/**
	 * This method initializes boton5	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBoton5() {
		if (boton5 == null) {
			boton5 = new JButton();
			boton5.setText("Buscar Ofertas");
			boton5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					BuscarOfertas ventanaBuscarOfertas = new BuscarOfertas();
					ventanaBuscarOfertas.setVisible(true);
				}
			});
		}
		return boton5;
	}

	/**
	 * This method initializes pBuscar	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPBuscar() {
		if (pBuscar == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(5, 0, 5, 0);
			gridBagConstraints.ipadx = 76;
			gridBagConstraints.gridy = -1;
			pBuscar = new JPanel();
			pBuscar.setLayout(new GridBagLayout());
			pBuscar.add(getBoton5(), gridBagConstraints);
		}
		return pBuscar;
	}

	/**
	 * This method initializes boton6	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBoton6() {
		if (boton6 == null) {
			boton6 = new JButton();
			boton6.setText("Salir");
			boton6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return boton6;
	}
	
	/**
	 * This method initializes boton7	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBoton7() {
		if (boton7 == null) {
			boton7 = new JButton();
			boton7.setText("Anular Reserva");
			boton7.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFrame a = new AnularReservas();
				    a.setVisible(true);
				}
			});
		}
		return boton7;
	}
	
	/**
	 * This method initializes pAnular	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPAnular() {
		if (pAnular == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(5, 0, 5, 0);
			gridBagConstraints.ipadx = 76;
			gridBagConstraints.gridy = -1;
			pAnular = new JPanel();
			pAnular.setLayout(new GridBagLayout());
			pAnular.add(getBoton7(), gridBagConstraints);
		}
		return pAnular;
	}
	
	  public static void main(String[] args)
	  {
	  	final String IPMAQUINA = "localhost";
	  	final String DIRECTORIOCLASES= "/ISOServidor/";
	  	//
	  	System.setProperty ("java.rmi.server.codebase", "http://"+IPMAQUINA+DIRECTORIOCLASES);
	    // Aqui realizamos las operaciones necesarias para trabajar
	    // mediante RMI
	   try {
				
				// Nombre servicio remoto
	      String servicio = "/CasaRural";
				//System.setSecurityManager(new RMISecurityManager());
				// Numero puerto servidor RMI
	      int numPuerto = InterfazFachada.numPuerto;
	      // IP maquina servidor RMI
				String maquina = IPMAQUINA;
				interfazfachada = (InterfazFachada) Naming.lookup("rmi://" + maquina + ":" + numPuerto + servicio);
				
			}

			catch (Exception e) {
				System.out.println(e.toString());
			}
	    JFrame a = new PantallaInicio();
	    a.setVisible(true);
	  }
	private JPanel getPRecorrido() {
		if (pRecorrido == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(5, 0, 5, 0);
			gridBagConstraints.ipadx = 72;
			gridBagConstraints.gridy = -1;
			pRecorrido = new JPanel();
			pRecorrido.setLayout(new GridBagLayout());
			pRecorrido.add(getBtnCrearRecorrido(), gridBagConstraints);
		}
		return pRecorrido;
	}
	private JButton getBtnCrearRecorrido() {
		if (btnCrearRecorrido == null) {
			btnCrearRecorrido = new JButton("Crear Recorrido");
			btnCrearRecorrido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IURecorrido recorrido = new IURecorrido();
				    recorrido.crearRecorrido();
				}
			});
		}
		return btnCrearRecorrido;
	}
	private JPanel getPRecogida() {
		if (pRecogida == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(5, 0, 5, 0);
			gridBagConstraints.ipadx = 28;
			gridBagConstraints.gridy = -1;
			pRecogida = new JPanel();
			pRecogida.setLayout(new GridBagLayout());
			pRecogida.add(getBtnServRecogida(), gridBagConstraints);
		}
		return pRecogida;
	}
	private JButton getBtnServRecogida() {
		if (btnServRecogida == null) {
			btnServRecogida = new JButton("Crear Servicio Recogida");
			btnServRecogida.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ServicioRecogida iuServicioRecogida = new ServicioRecogida();
					iuServicioRecogida.crearServicio();
				}
			});
		}
		return btnServRecogida;
	}
}  //  @jve:decl-index=0:visual-constraint="0,0"
