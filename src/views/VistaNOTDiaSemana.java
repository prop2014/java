package views;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

/**
 * Vista secundaria de gestion de restricciones tipo NOT Dia Semana
 * @author Sergi Orra Genero
 */
public class VistaNOTDiaSemana {
	
	private JFrame frameView = new JFrame("Programador de Guardias: Restriccion tipo NOT Dia Semana");
	private JPanel panelContents = new JPanel();
	private JPanel panelButtons = new JPanel();
	private JPanel panelInfo = new JPanel();
	
	private JLabel labelPanel1 = new JLabel("Crear Restriccion: Tipo NOT Dia Semana");
	
	//private JLabel labelPanel2 = new JLabel("NOT DIA SEMANA");
	private JLabel labelPanel3 = new JLabel("<html><CENTER>Seleccione dia de <br/>la semana:</CENTER>");
	private JComboBox comboboxInformacion1 = new JComboBox();
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
	    // Layout
		/*GridLayout gl = new GridLayout(1,0);
		gl.setVgap(5); //distancia entre botones (vertical)
		gl.setHgap(10); //distancia entre botones (horizontal)
		panelButtons.setLayout(gl); //mida de los botones iguales
		panelButtons.setBorder(BorderFactory.createEmptyBorder(90, 100, 170, 90));
		buttonVolver.setBounds(40, 260, 150, 40);*/
		panelButtons.setBorder(new EmptyBorder(70, 20, 20, 0));
		
		labelPanel3.setBounds(100, 95, 150, 30);
		comboboxInformacion1.setBounds(275, 95, 150, 30);
		button.setBounds(440, 95, 150, 30);
		
		buttonVolver.setBounds(40, 230, 150, 40);
		panelButtons.setLayout(null);
	    // Botones
	   // panelButtons.add(labelPanel2);
	    panelButtons.add(labelPanel3);
	    panelButtons.add(comboboxInformacion1);
	    comboboxInformacion1.addItem("Lunes");
	    comboboxInformacion1.addItem("Martes");
	    comboboxInformacion1.addItem("Miercoles");
	    comboboxInformacion1.addItem("Jueves");
	    comboboxInformacion1.addItem("Viernes");
	    comboboxInformacion1.addItem("Sabado");
	    comboboxInformacion1.addItem("Domingo");
	    panelButtons.add(button);
	    panelButtons.add(buttonVolver);
	    // Tooltips
	    button.setToolTipText("Aceptar");
	}

	private void assignar_listenersComponents() {
	}
	
	
	//METODOS PUBLICOS
	
	public VistaNOTDiaSemana() {
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
		VistaNOTDiaSemana v = new VistaNOTDiaSemana();
		v.showView();
	}

}