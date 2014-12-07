package views;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

/**
 * Vista secundaria de gestion de restricciones tipo NOT Dia Semana
 * @author Sergi Orra Genero
 */
public class VistaNOTDiaSemana {
	
	private CtrlPresentacion ctrlPresentacion;
	
	private JFrame frameView;
	private JPanel panelContents = new JPanel();
	private JPanel panelButtons = new JPanel();
	private JPanel panelInfo = new JPanel();
	
	private JLabel labelPanel1 = new JLabel("<html><u>Crear Restriccion: Tipo NOT Dia Semana</u>");
	
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
	    // Layout
		panelButtons.setBorder(new EmptyBorder(70, 20, 20, 0));
		
		labelPanel3.setBounds(100, 95, 150, 30);
		comboboxInformacion1.setBounds(275, 95, 150, 30);
		button.setBounds(440, 95, 150, 30);
		
		buttonVolver.setBounds(40, 230, 150, 40);
		panelButtons.setLayout(null);
	    // Botones
	    panelButtons.add(labelPanel3);
	    panelButtons.add(comboboxInformacion1);
	    comboboxInformacion1.addItem("lunes");
	    comboboxInformacion1.addItem("martes");
	    comboboxInformacion1.addItem("miercoles");
	    comboboxInformacion1.addItem("jueves");
	    comboboxInformacion1.addItem("viernes");
	    comboboxInformacion1.addItem("sabado");
	    comboboxInformacion1.addItem("domingo");
	    panelButtons.add(button);
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
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String diaSemana = comboboxInformacion1.getSelectedItem().toString();
				try {
					ctrlPresentacion.addResNOT_Dia_Semana(1, diaSemana);
				} catch (IOException eX) {
					System.out.printf("Restriccion no creada");
					JOptionPane.showMessageDialog(null, "Restriccion no creada", "Error",JOptionPane.ERROR_MESSAGE); 
				}
			}
		});	
	}
	
	
	//METODOS PUBLICOS
	
	public VistaNOTDiaSemana(CtrlPresentacion pCtrlPresentacion) {
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