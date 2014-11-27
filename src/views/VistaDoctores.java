package views;
import javax.swing.*;

import java.awt.*;
import javax.swing.border.EmptyBorder;

/**
 * Vista principal de la gestion de una plantilla de doctores de un hospital
 * @author Axel Pelaez
 */
	
	public class VistaDoctores {
		
		//Componentes interficie
		private JFrame frameView = new JFrame("Programador de Guardias");
		private JPanel panelContents = new JPanel();
		
		private JPanel panelCenterButtons = new JPanel();
		
		//SCROLL PANEL
		private JList<String> list = new JList<String>();
		private JScrollPane scrollPanel = new JScrollPane();
		
		//CENTER
		private JLabel labelPanel1 = new JLabel("<html><u>Plantilla de ''NOMBRE DEL HOSPITAL''</u>");
		private JButton buttonCal = new JButton("<html><CENTER>Crear <br/>Doctor</CENTER>");
		private JButton buttonDoc = new JButton("<html><CENTER>Eliminar <br/>Doctor</CENTER>");
		private JButton buttonSol = new JButton("<html><CENTER>Modificar <br/>Doctor</CENTER>");
		private JButton buttonVolver = new JButton("Volver");
		
		
		
		//METODOS PRIVADOS
		
	
		
		private void inicializar_frameView() {
			// Tamanyo
		    frameView.setMinimumSize(new Dimension(700,400));
		    frameView.setPreferredSize(frameView.getMinimumSize());
		    frameView.setResizable(false);
		    // Posicion y operaciones por defecto
		    frameView.setLocationRelativeTo(null);
		    frameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		    JPanel contentPane = (JPanel) frameView.getContentPane();
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
			
			buttonCal.setBounds(442, 234, 173, 57);;
			
			buttonSol.setBounds(442, 68, 173, 57);
			
			buttonDoc.setBounds(442, 152, 173, 57);
			
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
			panelCenterButtons.add(buttonCal);
			panelCenterButtons.add(buttonSol);
			panelCenterButtons.add(buttonDoc);
		}
		
		
		private void inicializarComponents() {
		    inicializar_frameView();
		    inicializar_panelContents();
		    inicializar_panelCenterButtons();
		    assignar_listenersComponents();
		  }


		private void assignar_listenersComponents() {
		}
		
		
		//METODOS PUBLICOS
		
		/**
		 * @wbp.parser.entryPoint
		 */
		public VistaDoctores() {
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
			VistaGestion v = new VistaGestion();
			v.showView();
		}
	}


