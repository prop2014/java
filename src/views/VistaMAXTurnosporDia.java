
package views;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

/**
 * Vista secundaria de gestion de restricciones tipo MAX Turnos por Dia
 * @author Sergi Orra Genero
 */
public class VistaMAXTurnosporDia {
	
	private JFrame frameView = new JFrame("Programador de Guardias");
	private JPanel panelContents = new JPanel();
	private JPanel panelButtons = new JPanel();
	private JPanel panelInfo = new JPanel();
	
	private JLabel labelPanel1 = new JLabel("<html><u>Crear Restriccion: Tipo MAX Turnos por Dia</u>");
	
	private JLabel labelPanel3 = new JLabel("<html><CENTER>Escribe el numero<br/> de turnos:</CENTER>");
	private JTextArea textArea = new JTextArea(1,1);
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
	    // Tamanyo
	    frameView.setMinimumSize(new Dimension(700,400));
	    frameView.setPreferredSize(frameView.getMinimumSize());
	    frameView.setResizable(false);
	    // Posicion y operaciones por defecto
	    frameView.setLocationRelativeTo(null);
	    frameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    // Se agrega panelContents al contentPane (el panelContents se
	    // podria ahorrar y trabajar directamente sobre el contentPane)
	    JPanel contentPane = (JPanel) frameView.getContentPane();
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
		
		labelPanel3.setBounds(150, 95, 150, 30);
		textArea.setBounds(305, 102, 50, 16);
		button.setBounds(400, 95, 150, 30);
		
		buttonVolver.setBounds(40, 230, 150, 40);
		panelButtons.setLayout(null);
	    // Botones
	    panelButtons.add(labelPanel3);
	    panelButtons.add(textArea);
	    panelButtons.add(button);
	    panelButtons.add(buttonVolver);
	    // Tooltips
	    button.setToolTipText("Aceptar");
	}

	private void assignar_listenersComponents() {
	}
	
	
	//METODOS PUBLICOS
	
	public VistaMAXTurnosporDia() {
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
	
	public static void main(String[] args) {
		VistaMAXTurnosporDia v = new VistaMAXTurnosporDia();
		v.showView();
	}

}