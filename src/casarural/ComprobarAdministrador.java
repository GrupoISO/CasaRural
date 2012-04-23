package casarural;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComprobarAdministrador extends JFrame {

	private static final long serialVersionUID = -2750970328123899698L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JButton sendButton;
		
	/**
	 * Inicializa la pantalla de autorizaci—n.
	 */
	public ComprobarAdministrador() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		
		JLabel lblIdentificadorDeAdministrador = new JLabel("Identificador de administrador:");
		lblIdentificadorDeAdministrador.setBounds(30, 11, 195, 16);
		lblIdentificadorDeAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setBounds(30, 39, 195, 29);
		textField.setColumns(10);
		
		sendButton = new JButton("Enviar");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		sendButton.setBounds(80, 80, 82, 29);
		contentPane.setLayout(null);
		contentPane.add(lblIdentificadorDeAdministrador);
		contentPane.add(textField);
		contentPane.add(sendButton);
	}

	/**
	 * A–ade una verificaci—n de autenticaci—n para comprobar si el identificador corresponde a un usuario.
	 * @param runnable La acci—n a realizar si se autoriza al usuario
	 */
	public void comprobar(final Runnable runnable) {
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GestorAdministrador gestor = GestorAdministrador.getInstance();
				boolean esAdministrador = gestor.esAdministrador(textField.getText());
				
				if (esAdministrador) {
					ComprobarAdministrador.this.dispose();
					EventQueue.invokeLater(runnable);
				} else {
					JOptionPane.showMessageDialog(contentPane, "Se ha denegado el acceso.", "Acceso denegado", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		this.setVisible(true);
	}
}
