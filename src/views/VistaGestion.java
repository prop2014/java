package views;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;



	
	public class VistaGestion {
		
		//Componentes interficie
		private JFrame frameView = new JFrame("Programador de Guardias");
		private JPanel panelContents = new JPanel();
		
		
		private JPanel panelCenterButtons = new JPanel();
		private JPanel panelSouthButtons = new JPanel();
		private JPanel panelInfo = new JPanel();
		
		private JLabel labelPanel1 = new JLabel("''NOMBRE DEL HOSPITAL''");
		
		//CENTER
		
		private JButton buttonCal = new JButton("Gestion de " + "\n" + "Calendario");
		private JButton buttonDoc = new JButton("Gestion de " + "\n" + "Doctores");
		private JButton buttonSol = new JButton("Gestion de " + "\n" + "Soluciones");
		
		// SOUTH
		private JButton buttonVolver = new JButton("Volver");
		
		
		
		//METODOS PRIVADOS
		
		private void inicializarComponents() {
		    inicializar_frameView();
		    inicializar_panelContents();
		    
		    inicializar_panelInfo();
		  
		    inicializar_panelCenterButtons();
		    inicializar_panelSouthButtons();
		    
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
		
		    JPanel contentPane = (JPanel) frameView.getContentPane();
		    contentPane.add(panelContents);
		}
		
	
		
		private void inicializar_panelContents() {
			panelContents.setLayout(new BorderLayout());
			// Componentes
			panelContents.add(panelInfo,BorderLayout.NORTH);
			panelContents.add(panelCenterButtons, BorderLayout.CENTER);
			panelContents.add(panelSouthButtons, BorderLayout.SOUTH);
			
		}
		
		
		
		private void inicializar_panelInfo() {
											// MODIFICA los bordes del encuadre (peq/grande,?,mover abajo, ?)
			panelInfo.setBorder(BorderFactory.createEmptyBorder(10, 75, 0, 75));
			panelInfo.add(labelPanel1);
			
			
		}
		

		
		
		private void inicializar_panelCenterButtons() {
			// Layout
			GridLayout gl = new GridLayout(0,4);
			gl.setHgap(10);
			panelCenterButtons.setLayout(gl);
			panelCenterButtons.setBorder(new EmptyBorder(70, 20, 20, 0));
			buttonCal.setPreferredSize(new Dimension(0,35));
			
			buttonSol.setPreferredSize(new Dimension(0,35));
			buttonDoc.setPreferredSize(new Dimension(0,35));
			
			
			// Components
			
			panelCenterButtons.add(buttonCal);
			
			panelCenterButtons.add(buttonSol);
			
			panelCenterButtons.add(buttonDoc);
		}
		
		
		private void inicializar_panelSouthButtons() {
			// Layout
			GridLayout gl = new GridLayout(0,4);
			gl.setHgap(10);
			panelSouthButtons.setLayout(gl);
			panelSouthButtons.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
			buttonCal.setPreferredSize(new Dimension(0,35));
			// Components
			panelSouthButtons.add(buttonVolver);
			
			
		}


		private void assignar_listenersComponents() {
		}
		
		
		//METODOS PUBLICOS
		
		public VistaGestion() {
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


