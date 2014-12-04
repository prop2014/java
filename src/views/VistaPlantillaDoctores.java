package views;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;

/**
 * Vista principal de la gestion de una plantilla de doctores de un hospital
 * @author Axel Pelaez
 */

// ID VISTA 6


	public class VistaPlantillaDoctores {
		
		private CtrlPresentacion ctrlPresentacion;
		
		//Componentes interficie
		private JFrame frameView;
		private JPanel panelContents = new JPanel();
		
		private JPanel panelCenterButtons = new JPanel();
		
		//SCROLL PANEL
		private JList<String> list = new JList<String>();
		private JScrollPane scrollPanel = new JScrollPane();
		
		//CENTER
		private JLabel labelPanel1 = new JLabel("<html><u>Plantilla de ''NOMBRE DEL HOSPITAL''</u>");
		private JButton buttonCrear = new JButton("<html><CENTER>Crear <br/>Doctor</CENTER>");
		private JButton buttonEliminar = new JButton("<html><CENTER>Eliminar <br/>Doctor</CENTER>");
		private JButton buttonModificar = new JButton("<html><CENTER>Modificar <br/>Doctor</CENTER>");
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
			
			panelContents.setLayout(null);
			panelCenterButtons.setBounds(12, 0, 700, 372);
			// Componentes
			
			panelContents.add(panelCenterButtons);
			
		
		}

	
		
		private void inicializar_panelCenterButtons() {
			
			////// START: GESTIONADO POR EL BUILDER NO TOCAR
			panelCenterButtons.setBorder(new EmptyBorder(70, 20, 20, 0));
			panelCenterButtons.setLayout(null);
			
			
			buttonModificar.setBounds(442, 68, 173, 57);
			buttonEliminar.setBounds(442, 152, 173, 57);
			buttonCrear.setBounds(442, 234, 173, 57);
			
			
			
			
			
			buttonVolver.setBounds(52, 323, 157, 25);
			
			labelPanel1.setBounds(34, 12, 361, 25);
			
			
			
			scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			
			scrollPanel.setBounds(52, 66, 238, 225);
			
			/// END: GESTIONADO POR EL BUILDER NO TOCAR
			
			// Components
			panelCenterButtons.add(scrollPanel);
			scrollPanel.setViewportView(list);
			list.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			list.setModel(new AbstractListModel() {
				String[] values = new String[] {"Dr. Cooper", "Dr. Nick", "Dr. Pelaez" ,"Dr. Perez"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			panelCenterButtons.add(labelPanel1);
			panelCenterButtons.add(buttonVolver);
			panelCenterButtons.add(buttonEliminar);
			panelCenterButtons.add(buttonModificar);
			panelCenterButtons.add(buttonCrear);
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
					ctrlPresentacion.changeView("vistaGestion",panelContents);
				}
			});
			
			buttonModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ctrlPresentacion.changeView("vistaDoctor",panelContents);
				}
			});
			
			buttonCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ctrlPresentacion.changeView("vistaDoctor",panelContents);
				}
			});
			buttonEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				Object[] options = {"Aceptar", "Cancelar"};
				JOptionPane.showOptionDialog(null,
						"Esta seguro de que quiere eliminar el Doctor?",
					    "Alert",
					    JOptionPane.YES_NO_CANCEL_OPTION,
					    JOptionPane.WARNING_MESSAGE,
					    null,
					    options,
					    options[1]);
				}
			});
			
			
		}
		
		
		//METODOS PUBLICOS
		
		/**
		 * @wbp.parser.entryPoint
		 */
		public VistaPlantillaDoctores(CtrlPresentacion pCtrlPresentacion) {
			/** DESCOMENTAR PARA EDITAR*/
			 // inicializarComponents();
			 
			ctrlPresentacion = pCtrlPresentacion;
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


