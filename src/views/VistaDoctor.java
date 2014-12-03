package views;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;

/**
 * Vista principal de los datos de un Doctor
 * @author Axel Pelaez
 */

//ID VISTA 8


public class VistaDoctor {
	//Componentes interficie
	
			private CtrlPresentacion ctrlPresentacion;
			
			private JFrame frameView;
			private JPanel panelContents = new JPanel();
			
			private JPanel panelCenterButtons = new JPanel();
			
			//SCROLL PANEL
			private JList<String> list = new JList<String>();
			private JScrollPane scrollPanel = new JScrollPane();
			
			//CENTER
			
			
			private JLabel labelPanel1 = new JLabel("<html><u>Doctor ''NOMBRE DEL DOCTOR''</u>");
			private JLabel labelPanelID  = new JLabel("ID:");
			private JLabel labelPanelNombre = new JLabel("Nombre:");
			private JLabel labelPanelMaxTurnos = new JLabel("Max. Turnos:");
			private JLabel labelPanelSueldo = new JLabel("Sueldo:");
			
			private JTextArea textID = new JTextArea("666");
			private JTextArea textNombre = new JTextArea("Axel Pelaez");
			private JTextArea textMaxTurnos = new JTextArea("3");
			private JTextArea textSueldo = new JTextArea("100");
			
			private JButton buttonEliminar = new JButton("<html><CENTER>Eliminar<br/>Restriccion</CENTER>");
			private JButton buttonAnadir = new JButton("<html><CENTER>Añadir<br/>Restriccion</CENTER>");
			private JButton buttonGuardar = new JButton("<html><CENTER>Guardar<br/>cambios</CENTER>");
			private JButton buttonVolver = new JButton("Volver");
			
			
			
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
				
				//BOTONES
				panelCenterButtons.setBorder(new EmptyBorder(70, 20, 20, 0));
				panelCenterButtons.setLayout(null);
				
				
				/* OLD SETTINGS
				buttonAnadir.setBounds(442, 152, 173, 57);
				
				buttonEliminar.setBounds(442, 234, 173, 57);
				*/
				
				buttonAnadir.setBounds(449, 128, 173, 40);
				buttonEliminar.setBounds(449, 180, 173, 40);
				buttonGuardar.setBounds(449, 233, 173, 40);
				buttonVolver.setBounds(52, 323, 157, 25);
				
				//labels
				labelPanel1.setBounds(44, 16, 361, 25);
				
				labelPanelID.setBounds(52, 45, 28, 30);
				labelPanelNombre.setBounds(52, 69, 71, 33);
				labelPanelMaxTurnos.setBounds(340, 45, 101, 31);
				labelPanelSueldo.setBounds(340, 70, 88, 31);
				
				//textArea
				textID.setBounds(124, 53, 166, 15);
				textNombre.setBounds(124, 78, 166, 15);
				textMaxTurnos.setBounds(449, 53, 166, 15);
				textSueldo.setBounds(449, 78, 166, 15);
				
				
				
				//Scroll
				scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPanel.setBounds(52, 114, 246, 177);
				
				
				
				/// END: GESTIONADO POR EL BUILDER NO TOCAR
				
				// Components
				panelCenterButtons.add(scrollPanel);
				scrollPanel.setViewportView(list);
				list.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
				list.setModel(new AbstractListModel() {
					String[] values = new String[] {"<html>NOT Dia Mes: <br/>-> 13 <html/>", "<html>NOT Fecha: <br/>-> 5/01/2007<html/>", 
													"<html>NOT Tipo Turno: <br/>-> Noche<html/>",
													"<html>XOR: <br/>-> 5/07/2007 Mañana <br/>-> 5/07/2007 Tarde <br/>-> 5/07/2007 Noche<html/>"};
					
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
				
				panelCenterButtons.add(labelPanel1);
				panelCenterButtons.add(labelPanelID);
				panelCenterButtons.add(labelPanelNombre);
				panelCenterButtons.add(labelPanelMaxTurnos);
				panelCenterButtons.add(labelPanelSueldo);
				
				panelCenterButtons.add(textID);
				panelCenterButtons.add(textNombre);
				panelCenterButtons.add(textMaxTurnos);
				panelCenterButtons.add(textSueldo);
				
				panelCenterButtons.add(buttonEliminar);
				panelCenterButtons.add(buttonAnadir);
				panelCenterButtons.add(buttonGuardar);
				panelCenterButtons.add(buttonVolver);
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
						ctrlPresentacion.changeView("vistaPlantillaDoctores",panelContents);
					}
				});
				
				buttonAnadir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ctrlPresentacion.changeView("vistaRestriccion",panelContents);
					}
				});
			}
			
			
			//METODOS PUBLICOS
			
			/**
			 * @wbp.parser.entryPoint
			 */
			public VistaDoctor(CtrlPresentacion pCtrlPresentacion) {
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


