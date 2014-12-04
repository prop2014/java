package views;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * Vista para la creacion de un hospital
 * @author Alex Morral
 */
public class VistaCrearHospital {
	
	private CtrlPresentacion ctrlPresentacion;
	
	//ID VISTA 13
	
	//Componentes interficie
	private JFrame frameView;
	private JPanel panelContents = new JPanel();
	private JPanel panelCenterButtons = new JPanel();
	//CENTER
	private JLabel labelPanel1 = new JLabel("<html><u><b>Crear Hospital</b></u>");
	JButton btnCrearHospital = new JButton("Crear Hospital");
	private JButton btnImportCal = new JButton("<html><CENTER>Importar<br/>Calendario</CENTER>");
	private JButton btnImportDoc = new JButton("<html><CENTER>Importar<br/>Doctores</CENTER>");
	private JButton btnCancel = new JButton("Cancelar");
	private JTextField nameHospTextField;
	private JTextField mTextField;
	private JTextField tTextField;
	private JTextField nTextField;
	
	
	//METODOS PRIVADOS
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
		panelContents.setLayout(new BorderLayout());
		// Componentes
		panelContents.add(panelCenterButtons, BorderLayout.CENTER);
	}
	
	private void inicializar_panelCenterButtons() {
		////// START: GESTIONADO POR EL BUILDER NO TOCAR
		panelCenterButtons.setBorder(new EmptyBorder(70, 20, 20, 0));
		btnImportDoc.setBounds(371, 219, 140, 45);
		btnImportCal.setBounds(187, 219, 140, 45);
		btnCancel.setBounds(167, 322, 160, 25);
		labelPanel1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		labelPanel1.setBounds(66, 30, 112, 15);
		panelCenterButtons.setLayout(null);
		/// END: GESTIONADO POR EL BUILDER NO TOCAR
		// Components
		panelCenterButtons.add(labelPanel1);
		panelCenterButtons.add(btnCancel);
		panelCenterButtons.add(btnImportDoc);
		panelCenterButtons.add(btnImportCal);
		
		JLabel lblNombreDelHospital = new JLabel("Nombre del Hospital: ");
		lblNombreDelHospital.setBounds(185, 90, 138, 16);
		panelCenterButtons.add(lblNombreDelHospital);
		
		nameHospTextField = new JTextField();
		nameHospTextField.setToolTipText("");
		nameHospTextField.setBounds(335, 84, 145, 28);
		panelCenterButtons.add(nameHospTextField);
		nameHospTextField.setColumns(10);
		
		JLabel lblFactorDeTurno = new JLabel("Factor de Turno: ");
		lblFactorDeTurno.setBounds(216, 149, 107, 16);
		panelCenterButtons.add(lblFactorDeTurno);
		
		mTextField = new JTextField();
		mTextField.setText("1.0");
		mTextField.setBounds(335, 143, 40, 28);
		panelCenterButtons.add(mTextField);
		mTextField.setColumns(10);
		
		tTextField = new JTextField();
		tTextField.setText("1.0");
		tTextField.setColumns(10);
		tTextField.setBounds(388, 143, 40, 28);
		panelCenterButtons.add(tTextField);
		
		nTextField = new JTextField();
		nTextField.setText("1.0");
		nTextField.setColumns(10);
		nTextField.setBounds(440, 143, 40, 28);
		panelCenterButtons.add(nTextField);
		
		JLabel lblM = new JLabel("M");
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		lblM.setBounds(341, 124, 24, 16);
		panelCenterButtons.add(lblM);
		
		JLabel lblT = new JLabel("T");
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setBounds(393, 124, 24, 16);
		panelCenterButtons.add(lblT);
		
		JLabel lblN = new JLabel("N");
		lblN.setHorizontalAlignment(SwingConstants.CENTER);
		lblN.setBounds(445, 124, 24, 16);
		panelCenterButtons.add(lblN);
		
	
		btnCrearHospital.setBounds(371, 322, 160, 25);
		panelCenterButtons.add(btnCrearHospital);
	}
	private void inicializarComponents() {
		inicializar_frameView();
		inicializar_panelContents();
		inicializar_panelCenterButtons();
		assignar_listenersComponents();
	}
	
	private void assignar_listenersComponents() {
		
		btnCrearHospital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameHosp = nameHospTextField.getText();
				nameHosp.replaceAll(" ", "%");
				Scanner sc1 = new Scanner(mTextField.getText());
				Scanner sc2 = new Scanner(tTextField.getText());
				Scanner sc3 = new Scanner(nTextField.getText());
				Double factM, factT, factN;
				factM = factT = factN = 0.0;
				
				if(sc1.hasNextDouble() && sc2.hasNextDouble() && sc3.hasNextDouble()) {
					factM = Double.parseDouble(mTextField.getText());
					factT = Double.parseDouble(tTextField.getText());
					factN = Double.parseDouble(nTextField.getText());
					try {
						ctrlPresentacion.crearHospital(nameHosp, factM, factT, factN);
					} catch (IOException eX) {
						System.out.printf("Hospital no creado");
						JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE); 
					}
				} else {
					JOptionPane.showMessageDialog(null, "Alguno de los factores no es un valor correcto", "Error", JOptionPane.ERROR_MESSAGE); 
				}
				sc1.close();
				sc2.close();
				sc3.close();
			}
		});
		
		btnImportCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "Text File (.txt)", "txt");
				    chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(frameView);
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlPresentacion.changeView("vistaCjtHospitales", panelContents);
			}
		});
		
	}
	
	
	//METODOS PUBLICOS
	public VistaCrearHospital(CtrlPresentacion pCtrlPresentacion) {
		ctrlPresentacion = pCtrlPresentacion;
		/** DESCOMENTAR PARA EDITAR *
		 inicializarComponents();
		 /** END DESCOMENTAR PARA EDITAR*/
	}
	
	public void init() {
		inicializarComponents();
	}
	
	public JPanel getPanel() {
		return panelContents;
	}

	public void showView() {
		frameView.setVisible(true);
	}
	
	public void hidePanel() {
		panelContents.setVisible(false);
	}
	public void showPanel() {
		panelContents.setVisible(true);
	}
	
	public void enableView() {
		frameView.setEnabled(true);
	}
	
	public void disableView() {
		frameView.setEnabled(false);
	}
}
