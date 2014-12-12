package views;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;


import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 * Vista principal de la gestion de una plantilla de doctores de un hospital
 * @author Axel Pelaez
 */




	public class VistaPlantillaDoctores {
		
		private CtrlPresentacion ctrlPresentacion;
		ArrayList<ArrayList<String>> doctores;
		
		//Componentes interficie
		private JFrame frameView;
		private JPanel panelContents = new JPanel();
		
		private JPanel panelCenterButtons = new JPanel();
		
		//SCROLL PANEL
		
		final String[] fila1 ={"<html><LEFT>Id</LEFT></html>","<html><LEFT>Nombre</LEFT></html>",
								"<html><LEFT>Sueldo/Turnos</LEFT></html>", "<html><LEFT>Max turno</LEFT></html>"};
		final Object[][] datos={};
		
		private JTable tabla = new JTable();
		private JScrollPane scrollPanel = new JScrollPane();
		
		//CENTER
		private JLabel labelPanel1 = new JLabel();
		private JButton buttonCrear = new JButton("<html><CENTER>Crear <br/>Doctor</CENTER>");
		private JButton buttonEliminar = new JButton("<html><CENTER>Eliminar <br/>Doctor</CENTER>");
		private JButton buttonModificar = new JButton("<html><CENTER>Modificar <br/>Doctor</CENTER>");
		private JButton buttonVolver = new JButton("Volver");
		
		
		
		//METODOS PRIVADOS
		
	
		
		private void inicializar_frameView() {
			
			/** DESCOMENTAR PARA EDITAR *
			frameView =  new JFrame("Programador Guardias");
			frameView.setMinimumSize(new Dimension(700, 400));
			frameView.setPreferredSize(frameView.getMinimumSize());
			frameView.setResizable(false);
			frameView.setLocationRelativeTo(null);
			frameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameView.getContentPane().setBackground(Color.WHITE);
			 //END DESCOMENTAR PARA EDITAR **/
			
			frameView = ctrlPresentacion.getFrame();
			JPanel contentPane = (JPanel) frameView.getContentPane();
			contentPane.setLayout(null);
			panelContents.setBounds(0,0,700,378);
			contentPane.add(panelContents);
		}
		
	
		
		private void inicializar_panelContents() {
			
			panelContents.setLayout(null);
			panelCenterButtons.setBounds(12, 0, 700, 372);
			// Componentes
			
			panelContents.add(panelCenterButtons);
			
		
		}

	
		
		private void inicializar_panelCenterButtons() {
			
			////// START: GESTIONADO POR EL BUILDER NO TOCAR
			panelCenterButtons.setBorder(new EmptyBorder(70, 20, 20, 0));
			panelCenterButtons.setLayout(null);
			
			buttonModificar.setFont(new Font("Arial", Font.PLAIN, 15));
			buttonModificar.setBounds(442, 68, 173, 57);
			buttonEliminar.setFont(new Font("Arial", Font.PLAIN, 15));
			buttonEliminar.setBounds(442, 152, 173, 57);
			buttonCrear.setFont(new Font("Arial", Font.PLAIN, 15));
			buttonCrear.setBounds(442, 234, 173, 57);	
			buttonVolver.setFont(new Font("Arial", Font.PLAIN, 15));
			buttonVolver.setBounds(52, 323, 157, 25);
	
			labelPanel1.setFont(new Font("Arial", Font.PLAIN, 18));
			labelPanel1.setBounds(52, 29, 361, 25);
			
			
			
			scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPanel.setBounds(52, 66, 361, 225);
			
			/// END: GESTIONADO POR EL BUILDER NO TOCAR
			
			// Components
			panelCenterButtons.add(scrollPanel);
			
			scrollPanel.setViewportView(tabla);
			tabla.setFont(new Font("Arial", Font.PLAIN, 12));
			
			tabla.setForeground(Color.red);
			tabla.setBackground(Color.white);
			
			panelCenterButtons.add(labelPanel1);
			panelCenterButtons.add(buttonVolver);
			panelCenterButtons.add(buttonEliminar);
			panelCenterButtons.add(buttonModificar);
			panelCenterButtons.add(buttonCrear);
			
			buttonModificar.setEnabled(false); 
	        buttonEliminar.setEnabled(false);
		}
		
		
		private void inicializarComponents() {
		    inicializar_frameView();
		    inicializar_panelContents();
		    inicializar_panelCenterButtons();
		    assignar_listenersComponents();
		  }


		private void assignar_listenersComponents() {
			
			
			//OCULTAR los botones
			ListSelectionModel listSelectionModel = tabla.getSelectionModel();
			listSelectionModel.addListSelectionListener(new ListSelectionListener() {
			        public void valueChanged(ListSelectionEvent e) { 
			            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
			            buttonModificar.setEnabled(!lsm.isSelectionEmpty()); 
			            buttonEliminar.setEnabled(!lsm.isSelectionEmpty()); 
			        }
			});
			
			
			
			buttonVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ctrlPresentacion.changeView("vistaGestion",panelContents);
				}
			});
			
			buttonModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int row = tabla.getSelectedRow();
				
					
					ctrlPresentacion.setDocActual((String) tabla.getValueAt(row, 0), 
													(String) tabla.getValueAt(row, 1),
													(String) tabla.getValueAt(row, 2),
													(String) tabla.getValueAt(row, 3));
					
					ctrlPresentacion.changeView("vistaDoctor",panelContents);
				}
			});
			
			buttonCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ctrlPresentacion.clearDocActual();
					ctrlPresentacion.changeView("vistaDoctor",panelContents);
				}
			});
			buttonEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					int row = tabla.getSelectedRow();
					String name = (String) tabla.getValueAt(row, 1);
					Object[] options = {"Aceptar", "Cancelar"};
					int option = JOptionPane.showOptionDialog(null,
							"Esta seguro de que quiere eliminar el Doctor "
							+ name +" ?",
						    "Alert",
						    JOptionPane.YES_NO_CANCEL_OPTION,
						    JOptionPane.WARNING_MESSAGE,
						    null,
						    options,
						    options[1]);
					
					
					if(option == JOptionPane.YES_OPTION){

						String id = (String) tabla.getValueAt(row, 0); 
						try {
							
							ctrlPresentacion.eliminarDoc(Integer.parseInt(id));
							ctrlPresentacion.clearDocActual();
						} catch (IOException e1) {
							//Error
						}
						loadDoctores();
					}
				}
			});
					
			
		}
		
		private void loadDoctores() {
			ArrayList<ArrayList<String>> doctores = new ArrayList<ArrayList<String>>();
			try {
				
				doctores = ctrlPresentacion.loadDoctores();
			} catch (IOException e) {
				// "No doctores disponibles";
			}
			
			
			DefaultTableModel dtm = new DefaultTableModel(datos,fila1){
			    public boolean isCellEditable(int row, int column) {
			        return false;
			    }
			
			}; 
			//Que no se muevan las columnas
			tabla.getTableHeader().setReorderingAllowed(false);
		
			
			if(!doctores.isEmpty()){
				for(ArrayList<String> arrayDoc : doctores){
					String[] row = new String[arrayDoc.size()];
					row = arrayDoc.toArray(row);
					dtm.addRow(row); 
				}
			
			}
			
			tabla.setModel(dtm);  
			tabla.revalidate();
			tabla.repaint();
			
		}
		
		
		
		
		//METODOS PUBLICOS
		
		/**
		 * @wbp.parser.entryPoint
		 */
		public VistaPlantillaDoctores(CtrlPresentacion pCtrlPresentacion) {
			/** DESCOMENTAR PARA EDITAR*
			  //inicializarComponents(); */
			 
			ctrlPresentacion = pCtrlPresentacion;
		}
		
		
		public void init() {
			loadDoctores();
			inicializarComponents();
		}
		public void cargarHospital() {
			String name = ctrlPresentacion.getNameHospital();
			name = "Plantilla de "+ name.replace("%", " ");
			labelPanel1.setText(name);
		}
		
		public JPanel getPanel() {
			return panelContents;
		}
		
		public void hidePanel() {
			panelContents.setVisible(false);
		}
		public void showPanel() {
			cargarHospital();
			loadDoctores();
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


