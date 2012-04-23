package casarural;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;

public class ResultadosAnular extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane scroll = null;
	private JPanel panResul = null;
	private String[] anulaciones;
	private int[] res;
	private JPanel PBoton = null;  //  @jve:decl-index=0:visual-constraint="493,130"
	private JButton botonCerrar = null;
	private JPanel PLabel = null;
	
	/**
	 * Constructor para la ventana que muestra los resultados de las anulaciones.
	 * 
	 * @param String[] anu, números de reserva
	 * @param int[] res, resultados de las anulaciones
	 */
	public ResultadosAnular(String[] anu, int[] res) {
		super();
		this.res=res;
		anulaciones=anu;
		initialize();
	}
	
	/**
	 * Constructor para la ventana que muestra un mensaje de aviso "No hay reservas para las fechas indicadas".
	 * 
	 */
	public ResultadosAnular(){
		super();
		initialize();
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(376, 285);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane.
	 * Introducirá un panel u otro en función de la ventana que tenga que mostrarse.
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			//Se mostrará el mensaje de aviso
			if(anulaciones==null || res==null){
				jContentPane.setLayout(new BoxLayout(getJContentPane(), BoxLayout.Y_AXIS));
				jContentPane.add(getLabel(), null);
			}
			//Se mostrarán los resultados de las anulaciones
			else{
				jContentPane.setLayout(new BoxLayout(getJContentPane(), BoxLayout.Y_AXIS));
				jContentPane.add(getScroll(), null);
			}
			jContentPane.add(getPBoton(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes PLabel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getLabel(){
		if(PLabel==null){
			PLabel = new JPanel();
			PLabel.setLayout(null);
			PLabel.setPreferredSize(new Dimension(400,200));
			JLabel l = new JLabel();
			l.setText("No hay reservas entre las fechas escogidas");
			l.setBounds(new Rectangle(55, 91, 249, 16));
			PLabel.add(l, null);
		}
		return PLabel;
	}
	
	/**
	 * This method initializes scroll	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScroll() {
		if (scroll == null) {
			scroll = new JScrollPane();
			scroll.setViewportView(getPanResul());
			scroll.setPreferredSize(new Dimension(400, 200));
			scroll.setSize(400, 200);
			scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		}
		return scroll;
	}

	/**
	 * This method initializes panResul
	 * Introduce una etiqueta por cada uno de los resultados, con el texto correspondiente.	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanResul() {
		if (panResul == null) {
			panResul = new JPanel();
			panResul.setLayout(new BoxLayout(getPanResul(), BoxLayout.Y_AXIS));
			JLabel l=null;
			for(int i=0;i<anulaciones.length;i++){
				if(res[i]==0){
					l = new JLabel("Reserva "+anulaciones[i]+": Anulación correcta.");
				}
				else if(res[i]==1){
					l = new JLabel("Reserva "+anulaciones[i]+": Error en la anulación.");
				}
				else if(res[i]==2){
					l = new JLabel("Reserva "+anulaciones[i]+": Anulación correcta. Se le devolverá el 20%.");
				}
				panResul.add(l, null);
			}
		}
		return panResul;
	}

	/**
	 * This method initializes PBoton	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPBoton() {
		if (PBoton == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.gridy = 0;
			PBoton = new JPanel();
			PBoton.setLayout(new GridBagLayout());
			PBoton.add(getBotonCerrar(), gridBagConstraints2);
		}
		return PBoton;
	}

	/**
	 * This method initializes botonCerrar
	 * Incluye las acciones correspondientes al botonCerrar.
	 * 
	 * Oculta la ventana actual dejando visible la correspondiente a ListadoReservas o AnularReservas 
	 * según el caso del que provenga.	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBotonCerrar() {
		if (botonCerrar == null) {
			botonCerrar = new JButton();
			botonCerrar.setText("Cerrar");
			botonCerrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ResultadosAnular.this.setVisible(false);
				}
			});
		}
		return botonCerrar;
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
