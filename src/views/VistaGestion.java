package views;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;
/**
 * Vista principal de la gestion de un hospital
 * @author Axel Pelaez
 */
public class VistaGestion {
	
	private CtrlPresentacion ctrlPresentacion;
	
	//Componentes interficie
	private JFrame frameView;
	private JPanel panelContents = new JPanel();
	private JPanel panelCenterButtons = new JPanel();
	//CENTER
	private JLabel labelPanel1 = new JLabel("<html><u>''NOMBRE DEL HOSPITAL''</u>");
	private JButton buttonCal = new JButton("<html><CENTER>Gestion de <br/>Calendario</CENTER>");
	private JButton buttonDoc = new JButton("<html><CENTER>Gestion de <br/>Doctores</CENTER>");
	private JButton buttonSol = new JButton("<html><CENTER>Gestion de <br/>Solucion</CENTER>");
	private JButton buttonVolver = new JButton("Volver");
	
	
	//METODOS PRIVADOS
	private void inicializar_frameView() {
		frameView = ctrlPresentacion.getFrame();
		JPanel contentPane = (JPanel) frameView.getContentPane();
		contentPane.setLayout(null);
		panelContents.setBounds(0,0,700,378);
		contentPane.add(panelContents);
	}
	
	private void inicializar_panelContents() {
		panelContents.setLayout(new BorderLayout());
		// Componentes
		panelContents.add(panelCenterButtons, BorderLayout.CENTER);
	}
	
	private void inicializar_panelCenterButtons() {
		////// START: GESTIONADO POR EL BUILDER NO TOCAR
		panelCenterButtons.setBorder(new EmptyBorder(70, 20, 20, 0));
		buttonCal.setBounds(49, 134, 173, 119);
		buttonSol.setBounds(467, 132, 181, 122);
		buttonDoc.setBounds(263, 134, 173, 119);
		buttonVolver.setBounds(40, 324, 157, 25);
		labelPanel1.setBounds(32, 12, 177, 15);
		panelCenterButtons.setLayout(null);
		/// END: GESTIONADO POR EL BUILDER NO TOCAR
		// Components
		panelCenterButtons.add(labelPanel1);
		panelCenterButtons.add(buttonVolver);
		panelCenterButtons.add(buttonCal);
		panelCenterButtons.add(buttonSol);
		panelCenterButtons.add(buttonDoc);
	}
	private void inicializarComponents() {
		inicializar_frameView();
		inicializar_panelContents();
		inicializar_panelCenterButtons();
		assignar_listenersComponents();
	}
	
	private void assignar_listenersComponents() {
		buttonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlPresentacion.changeVolver();
			}
		});
		
	}
	
	
	//METODOS PUBLICOS
	public VistaGestion(CtrlPresentacion pCtrlPresentacion) {
		
		ctrlPresentacion = pCtrlPresentacion;
	}
	
	public void init() {
		inicializarComponents();
	}
	
	public void showView() {
		frameView.setVisible(true);
	}
	
	public void enableView() {
		frameView.setEnabled(true);
	}
	
	public void disableView() {
		frameView.setEnabled(false);
	}
}
