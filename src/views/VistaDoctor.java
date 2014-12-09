package views;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.border.EmptyBorder;

/**
 * Vista principal de los datos de un Doctor
 * @author Axel Pelaez
 */

public class VistaDoctor {
	//Componentes interficie
	
			private CtrlPresentacion ctrlPresentacion;
			
			private JFrame frameView;
			private JPanel panelContents = new JPanel();
			
			private JPanel panelCenterButtons = new JPanel();
			
			//SCROLL PANEL
			private JList<String> list = new JList<String>();
			private JScrollPane scrollPanel = new JScrollPane();
			
			private String[] docInfo;
			
			//CENTER
			
			private JLabel labelPanel1 = new JLabel();
			private JLabel labelPanelID  = new JLabel("ID:");
			private JLabel labelPanelNombre = new JLabel("Nombre:");
			private JLabel labelPanelMaxTurnos = new JLabel("Max. Turnos:");
			private JLabel labelPanelSueldo = new JLabel("Sueldo:");
			
			private JTextArea textID = new JTextArea();
			private JTextArea textNombre = new JTextArea();
			private JTextArea textMaxTurnos = new JTextArea();
			private JTextArea textSueldo = new JTextArea();
			
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
				
				list.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
				scrollPanel.setViewportView(list);
				// Components
				panelCenterButtons.add(scrollPanel);
				scrollPanel.setViewportView(list);
				list.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

				
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
				
				buttonGuardar.addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent e) {
						
						if(docInfo[0].equals("")){//Se a entrado para crear
							
							
							String nameDoc = textNombre.getText();
							nameDoc=nameDoc.replaceAll(" ", "%");
							try {
								int id = Integer.parseInt(textID.getText());
								int maxTurnos = Integer.parseInt(textMaxTurnos.getText());
								Double sueldo = Double.parseDouble(textSueldo.getText());
								if(nameDoc.isEmpty()) throw new IOException("El doctor no tiene nombre");
								ctrlPresentacion.crearDoctor(nameDoc, id, maxTurnos, sueldo);
							} catch (IOException eX) {
								JOptionPane.showMessageDialog(null, eX, "Error",JOptionPane.ERROR_MESSAGE); 
							} catch (NumberFormatException nE){
								JOptionPane.showMessageDialog(null, "Alguno de los factores no es un valor correcto", "Error", JOptionPane.ERROR_MESSAGE); 
							}
							
						}
						
						else{//Se a entrado para modificar
						

							
							if(!docInfo[0].equals(textID.getText()) 
								|| !docInfo[1].equals(textNombre.getText())
								|| !docInfo[2].equals(textSueldo.getText()) 
								|| !docInfo[3].equals(textMaxTurnos.getText())){
								// Habra que comprobar si se han modificado las restricciones
									
							
							String nameDoc = textNombre.getText();
							nameDoc=nameDoc.replaceAll(" ", "%");
							
							
							
							try {
								int id = Integer.parseInt(textID.getText());
								int maxTurnos = Integer.parseInt(textMaxTurnos.getText());
								Double sueldo = Double.parseDouble(textSueldo.getText());
								
								if(nameDoc.isEmpty()) throw new IOException("El doctor no tiene nombre");
								
								ctrlPresentacion.eliminarDoc(id);
								ctrlPresentacion.crearDoctor(nameDoc, id, maxTurnos, sueldo);
							} catch (IOException eX) {
								JOptionPane.showMessageDialog(null, eX, "Error",JOptionPane.ERROR_MESSAGE); 
							} catch (NumberFormatException nE){
								JOptionPane.showMessageDialog(null, "Alguno de los factores no es un valor correcto", "Error", JOptionPane.ERROR_MESSAGE); 
							}
							
							
							
						}
							
						}
						
						ctrlPresentacion.changeView("vistaPlantillaDoctores", panelContents);
					}
					
					
				});
		
				
				
				
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
				
				buttonEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
					Object[] options = {"Aceptar", "Cancelar"};
					JOptionPane.showOptionDialog(null,
							"Esta seguro de que quiere eliminar la restriccion?",
						    "Alert",
						    JOptionPane.YES_NO_CANCEL_OPTION,
						    JOptionPane.WARNING_MESSAGE,
						    null,
						    options,
						    options[1]);
					}
				});
				
				
				

			}
			

		/*	private void loadDoctores() {
				doctores = new ArrayList<String>();
				try {
					doctores = ctrlPresentacion.loadDoctores();
				} catch (IOException e) {
					doctores.add("No hay doctores disponibles");
				}
				
				DefaultListModel<String> model = new DefaultListModel<String>();
			    for(String st : doctores){
			    	st = st.replace("%", " ");
			         model.addElement(st);
			    }    
			    list.setModel(model);  
			    list.revalidate();
				list.repaint();
				
			}*/
			
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
			
			public void setDocInfo(String[] newDocInfo){
				docInfo = newDocInfo;
			}
			
			public JPanel getPanel() {
				return panelContents;
			}
			
			public void hidePanel() {
				panelContents.setVisible(false);
			}
			public void showPanel() {
				
				textID.setText(docInfo[0]);
				textNombre.setText(docInfo[1]);
				textSueldo.setText(docInfo[2]);
				textMaxTurnos.setText(docInfo[3]);
				
					
				
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


