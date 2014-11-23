package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Vista principal de gestion de calendario
 * @author Felix Fernando Ramos Velazquez
 */
public class VistaCalendario {
	/* Atributos y metodos privados */
	// Controlador de presentacion
	//private CtrlPresentacion iCtrlPresentacion;

	//-- Components --//
	private JFrame frameView = new JFrame("Gestion calendario");
	private JPanel panelContents = new JPanel();
	private JPanel panelCalendar = new JPanel();
	private JPanel panelTopButtons = new JPanel();
	private JPanel panelBottomButtons = new JPanel();
	private JPanel panelRightButtons = new JPanel();

	//-- Buttons --//
	// Top
	private JButton buttonCreateCal = new JButton("Crear calendario");
	private JButton buttonImportCal = new JButton("Importar calendario");
	// Bottom
	private JButton buttonDeleteCal = new JButton("Eliminar calendario");
	private JButton buttonGoBack = new JButton("Volver");
	// Right
	private JButton buttonAdd = new JButton("Anadir dia vacacional");
	private JButton buttonMod = new JButton("Modificar dia vacacional");
	private JButton buttonDel = new JButton("Eliminar dia vacacional");

	//-- Metodos privados --//
	private void init_frameView() {
		frameView.setMinimumSize(new Dimension(700,400));
		frameView.setPreferredSize(frameView.getMinimumSize());
		frameView.setResizable(false);
		frameView.setLocationRelativeTo(null);
		frameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = (JPanel) frameView.getContentPane();
		contentPane.add(panelContents);
	}

	private void init_panelContents() {
		// Layout
		panelContents.setLayout(new BorderLayout());
		// Components
		panelContents.add(panelTopButtons, BorderLayout.NORTH);
		panelContents.add(panelCalendar, BorderLayout.CENTER);
		panelContents.add(panelBottomButtons, BorderLayout.SOUTH);
		panelContents.add(panelRightButtons, BorderLayout.EAST);
	}

	private void init_panelCalendar() {
//		panelCalendar.setPreferredSize(new Dimension(500,200));;
	}
	private void init_panelTopButtons() {
		// Layout
		GridLayout gl = new GridLayout(0,4);
		gl.setHgap(10);
		panelTopButtons.setLayout(gl);
		panelTopButtons.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
		buttonCreateCal.setPreferredSize(new Dimension(0,35));
		// Components
		panelTopButtons.add(buttonCreateCal);
		panelTopButtons.add(buttonImportCal);
		// ToolTips (optional)
		buttonCreateCal.setToolTipText("Crear nuevo calendario");
		buttonImportCal.setToolTipText("Importar calendario existente");
	}

	private void init_panelBottomButtons() {
		// Layout
		GridLayout gl = new GridLayout(0,4);
		gl.setHgap(10);
		panelBottomButtons.setLayout(gl);
		panelBottomButtons.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
		buttonDeleteCal.setPreferredSize(new Dimension(0,35));
		// Components
		panelBottomButtons.add(buttonDeleteCal);
		panelBottomButtons.add(new JLabel());
		panelBottomButtons.add(new JLabel());
		panelBottomButtons.add(buttonGoBack);
	}

	private void init_panelRightButtons() {
		// Layout
		GridLayout gl = new GridLayout(4,0);
		gl.setVgap(10);
		panelRightButtons.setLayout(gl);
		panelRightButtons.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		// Components
		panelRightButtons.add(buttonAdd);
		panelRightButtons.add(buttonMod);
		panelRightButtons.add(buttonDel);
	}

	private void assign_listenersComponents() {

	}

	private void initComponents() {
		init_frameView();
		init_panelContents();
		init_panelCalendar();
		init_panelTopButtons();
		init_panelBottomButtons();
		init_panelRightButtons();
		assign_listenersComponents();
	}

	/* Constructoras y metodos publicos */
	public VistaCalendario() {
		initComponents();
	}

	public void showView() {
//		frameView.pack();
		frameView.setVisible(true);
	}

	public void enableView() {
		frameView.setEnabled(true);
	}

	public void disableView() {
		frameView.setEnabled(false);
	}

	//	  private JPanel panelContenidos = new JPanel();
	//	  private JPanel panelInformacion = new JPanel();
	//	  private JPanel panelBotones = new JPanel();
	//	  private JButton buttonLlamadaDominio = new JButton("Llamada Dominio");
	//	  private JButton buttonVolver = new JButton("Volver");
	//	  private JTextArea textareaInformacion = new JTextArea(5,25);

	// ((( provisional!!! )))
	public static void main(String[] args) {
		VistaCalendario v = new VistaCalendario();

		v.showView();
	}
}
