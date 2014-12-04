package views;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Vista secundaria de gestion de restricciones tipo XOR
 * @author Sergi Orra Genero
 */
public class VistaXOR {
	
	private CtrlPresentacion ctrlPresentacion;
	
	private JFrame frameView;
	private JPanel panelContents = new JPanel();
	private JPanel panelButtons = new JPanel();
	private JPanel panelInfo = new JPanel();
	
	private JLabel labelPanel1 = new JLabel("<html><u>Crear Restriccion: Tipo XOR</u>");
	private JLabel labelPanel2 = new JLabel("<html><CENTER>Seleccione fecha:</CENTER>");
	private JLabel labelPanel3 = new JLabel("<html><CENTER>Seleccione<br/> tipo del turno:</CENTER>");
	private JDateChooser dataChooser = new JDateChooser("dd/MM/yyyy", "##/##/##", '_');
	private JCheckBox checkBox1 = new JCheckBox("manana");
	private JCheckBox checkBox2 = new JCheckBox("tarde");
	private JCheckBox checkBox3 = new JCheckBox("noche");
	private JButton buttonSiguiente = new JButton("Siguiente fecha");
	private JButton button = new JButton("Aceptar");
	private JButton buttonVolver = new JButton("Volver");
	
	
	private void inicializarComponents() {
	    inicializar_frameView();
	    inicializar_panelContents();
	    inicializar_panelInfo();
	    inicializar_panelButtons();
	    assignar_listenersComponents();
	  }
	
	// METODOS PRIVADOS
	
	private void inicializar_frameView() {
		/*** DESCOMENTAR PARA EDITAR *
		frameView =  new JFrame("Programador Guardias");
		frameView.setMinimumSize(new Dimension(700, 400));
		frameView.setPreferredSize(frameView.getMinimumSize());
		frameView.setResizable(false);
		frameView.setLocationRelativeTo(null);
		frameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameView.getContentPane().setBackground(Color.WHITE);
		/*** END DESCOMENTAR PARA EDITAR */
		frameView = ctrlPresentacion.getFrame();
		JPanel contentPane = (JPanel) frameView.getContentPane();
		contentPane.setLayout(null);
		panelContents.setBounds(0,0,700,378);
		contentPane.add(panelContents);
	}
	
	private void inicializar_panelContents() {
	    // Layout
	    panelContents.setLayout(new BorderLayout());
	    // Paneles
	    panelContents.add(panelInfo,BorderLayout.NORTH);
	    panelContents.add(panelButtons,BorderLayout.CENTER);
	}
	
	private void inicializar_panelInfo() {
		panelInfo.setBorder(BorderFactory.createEmptyBorder(55, 75, 0, 75));
		panelInfo.add(labelPanel1);
	}
	
	private void inicializar_panelButtons() {
		//layout
		panelButtons.setBorder(new EmptyBorder(70, 20, 20, 0));
		
		labelPanel2.setBounds(125, 50, 150, 30);
		dataChooser.setBounds(280, 50, 150, 30);
		labelPanel3.setBounds(125, 100, 150, 30);
		checkBox1.setBounds(280, 85, 100, 20);
		checkBox2.setBounds(280, 105, 100, 20);
		checkBox3.setBounds(280, 125, 100, 20);
		button.setBounds(510, 80, 150, 30);
		buttonSiguiente.setBounds(225, 160, 150, 30);
		
		buttonVolver.setBounds(40, 230, 150, 40);
		panelButtons.setLayout(null);
	    // Botones
	    panelButtons.add(labelPanel2);
	    panelButtons.add(checkBox1);
	    panelButtons.add(checkBox2);
	    panelButtons.add(checkBox3);
	    panelButtons.add(labelPanel3);
	    panelButtons.add(dataChooser);
	    panelButtons.add(button);
	    panelButtons.add(buttonSiguiente);
	    panelButtons.add(buttonVolver);
	    // Tooltips
	    button.setToolTipText("Aceptar");
	}

	private void assignar_listenersComponents() {
		buttonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlPresentacion.changeView("vistaRestriccion", panelContents);
			}
		});
	}
	
	
	//METODOS PUBLICOS
	
	public VistaXOR(CtrlPresentacion pCtrlPresentacion) {
		ctrlPresentacion = pCtrlPresentacion;
		/** DESCOMENTAR PARA EDITAR
		 * inicializarComponents();
		 */
	}
	
	public void init() {
		inicializarComponents();
	}
	
	public JPanel getPanel() {
		return panelContents;
	}
	
	public void hidePanel() {
		panelContents.setVisible(false);
	}
	public void showPanel() {
		panelContents.setVisible(true);
	}
	
	public void showView() {
		panelContents.setVisible(true);
	}
	
	public void enableView() {
		frameView.setEnabled(true);
	}
	
	public void disableView() {
		frameView.setEnabled(false);
	}

}