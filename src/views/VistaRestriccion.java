package views;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

/**
 * Vista principal de la gestion de restricciones
 * @author Sergi Orra Genero
 */
public class VistaRestriccion {
	
	//Componentes interficie
	private JFrame frameView = new JFrame("Programador de Guardias: Gestion de restricciones");
	private JPanel panelContents = new JPanel();
	private JPanel panelButtons = new JPanel();
	private JPanel panelVolver = new JPanel();
	private JPanel panelInfo = new JPanel();
	
	//Etiquetas
	  private JLabel labelPanel = new JLabel("Elije el tipo de restriccion para crear:");
	
	//Botones
	private JButton buttonNOTFecha = new JButton("NOT Fecha");
	private JButton buttonNOTTurno = new JButton("NOT Turno");
	private JButton buttonNOTEspecial = new JButton("NOT Especial");
	private JButton buttonNOTDiaMes = new JButton("NOT Dia Mes");
	private JButton buttonNOTDiaSemana = new JButton("NOT Dia Semana");
	private JButton buttonMAXTurnosRango = new JButton("MAX Turnos Rango");
	private JButton buttonMAXTurnosDia = new JButton("MAX Turnos por Dia");
	private JButton buttonXOR = new JButton("XOR");
	private JButton buttonVolver = new JButton("Volver");
	
	//METODOS PRIVADOS
	
	private void inicializarComponents() {
	    inicializar_frameView();
	    inicializar_panelContents();
	    inicializar_panelInfo();
	    inicializar_panelButtons();
	    assignar_listenersComponents();
	  }
	
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
		panelInfo.setBorder(BorderFactory.createEmptyBorder(25, 50, 0, 300));
		panelInfo.add(labelPanel);
	}
	
	private void inicializar_panelButtons() {
	    // Layout
		//GridLayout gl = new GridLayout(4,0);
		//gl.setVgap(5); //distancia entre botones (vertical)
		//gl.setHgap(10); //distancia entre botones (horizontal)
		//panelButtons.setLayout(gl); //mida de los botones iguales
		//panelButtons.setBorder(BorderFactory.createEmptyBorder(20, 190, 80, 190)); 
		
		//panelButtons.setLayout(new GridLayout(4,4,10,5));
		//panelButtons.setBorder(BorderFactory.createEmptyBorder(20, 175, 80, 175));
		
		panelButtons.setBorder(new EmptyBorder(70, 20, 20, 0));
		buttonNOTFecha.setBounds(200, 50, 150, 40);
		buttonNOTTurno.setBounds(355, 50, 150, 40);
		buttonNOTEspecial.setBounds(200, 95, 150, 40);
		buttonNOTDiaMes.setBounds(355, 95, 150, 40);
		buttonNOTDiaSemana.setBounds(200, 140, 150, 40);
		buttonMAXTurnosRango.setBounds(355, 140, 150, 40);
		buttonMAXTurnosDia.setBounds(200, 185, 150, 40);
		buttonXOR.setBounds(355, 185, 150, 40);
		buttonVolver.setBounds(40, 260, 150, 40);
		panelButtons.setLayout(null);
		
	    // Botones
	    panelButtons.add(buttonNOTFecha);
	    panelButtons.add(buttonNOTTurno);
	    panelButtons.add(buttonNOTEspecial);
	    panelButtons.add(buttonNOTDiaMes);
	    panelButtons.add(buttonNOTDiaSemana);
	    panelButtons.add(buttonMAXTurnosRango);
	    panelButtons.add(buttonMAXTurnosDia);
	    panelButtons.add(buttonXOR);
	    panelButtons.add(buttonVolver);
	    // Tooltips
	    buttonNOTFecha.setToolTipText("Crear Restriccion tipo NOT Fecha");
	    buttonNOTTurno.setToolTipText("Crear Restriccion tipo NOT Turno");
	    buttonNOTEspecial.setToolTipText("Crear Restriccion tipo NOT Especial");
	    buttonNOTDiaMes.setToolTipText("Crear Restriccion tipo NOT Dia Mes");
	    buttonNOTDiaSemana.setToolTipText("Crear Restriccion tipo NOT Dia Semana");
	    buttonMAXTurnosRango.setToolTipText("Crear Restriccion tipo MAX Turnos en un Rango");
	    buttonMAXTurnosDia.setToolTipText("Crear Restriccion tipo MAX Turnos por Dia");
	    buttonXOR.setToolTipText("Crear Restriccion tipo XOR");
	}

	private void assignar_listenersComponents() {
	}
	
	
	//METODOS PUBLICOS
	
	public VistaRestriccion() {
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
		VistaRestriccion v = new VistaRestriccion();
		v.showView();
	}
}
