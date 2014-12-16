package views;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.border.EmptyBorder;
/**
 * Vista principal de la gestion de un hospital
 * @author Axel Pelaez
 */


//ID VISTA 2

public class VistaGestion extends Vista {
	
	private static final int CENTER = 0;
	private static final int LEFT = 0;


//	private CtrlPresentacion ctrlPresentacion;
	
	
	//Componentes interficie
//	private JFrame frameView;
//	private JPanel panelContents = new JPanel();
	private JPanel panelCenterButtons = new JPanel();
	//CENTER
	private JLabel labelPanel1 = new JLabel();
	private JButton buttonCal = new JButton("<html><CENTER>Gestion de <br/>Calendario</CENTER>");
	private JButton buttonDoc = new JButton("<html><CENTER>Gestion de <br/>Doctores</CENTER>");
	private JButton buttonSol = new JButton("<html><CENTER>Gestion de <br/>Solucion</CENTER>");
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
		
		frameView.setFocusable(true);
		frameView.requestFocusInWindow();
		
		contentPane.add(panelContents);
		
		
	}
	
	protected void init_panelContents() {
		panelContents.setLayout(new BorderLayout());
		// Componentes
		panelContents.add(panelCenterButtons, BorderLayout.CENTER);
		
		
		
	}
	
	private void inicializar_panelCenterButtons() {
		////// START: GESTIONADO POR EL BUILDER NO TOCAR
		panelCenterButtons.setBorder(new EmptyBorder(70, 20, 20, 0));
		buttonCal.setFont(new Font("Arial", Font.PLAIN, 16));
		buttonCal.setBounds(49, 134, 173, 119);
		
		buttonSol.setFont(new Font("Arial", Font.PLAIN, 16));
		buttonSol.setBounds(467, 132, 181, 122);
		
		buttonDoc.setFont(new Font("Arial", Font.PLAIN, 16));
		buttonDoc.setBounds(263, 134, 173, 119);
		
		buttonVolver.setFont(new Font("Arial", Font.PLAIN, 12));
		buttonVolver.setBounds(40, 324, 157, 25);
		
		labelPanel1.setFont(new Font("Arial", Font.PLAIN, 20));
		labelPanel1.setBounds(49, 32, 599, 45);
		
		panelCenterButtons.setLayout(null);
		/// END: GESTIONADO POR EL BUILDER NO TOCAR
		// Components
		panelCenterButtons.add(labelPanel1);
		panelCenterButtons.add(buttonVolver);
		panelCenterButtons.add(buttonCal);
		panelCenterButtons.add(buttonSol);
		panelCenterButtons.add(buttonDoc);
		
		buttonVolver.setToolTipText("[ESC]");
		buttonSol.setToolTipText("[S]");
		buttonCal.setToolTipText("[C]");
		buttonDoc.setToolTipText("[D]");
	}
//	private void inicializarComponents() {
//		inicializar_frameView();
//		inicializar_panelContents();
//		inicializar_panelCenterButtons();
//		assignar_listenersComponents();
//	}
	
	protected void assign_listenersComponents() {
		buttonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlPresentacion.changeView("vistaCjtHospitales", panelContents);
			}
		});
		
		buttonDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlPresentacion.changeView("vistaPlantillaDoctores", panelContents);
			}
			
			
		});
		
		buttonCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlPresentacion.changeView("vistaCalendario", panelContents);
			}
			
			
		});
		
		buttonSol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlPresentacion.changeView("vistaGestionSoluciones", panelContents);
			}
		});
		
	

		 panelContents.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "buttonCal");
	     panelContents.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S,0), "buttonSol");
	     panelContents.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "buttonDoc");
	     panelContents.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "buttonVolver");
	    
	     panelContents.getActionMap().put("buttonDoc", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	buttonDoc.doClick();
	            }
	        });
	        panelContents.getActionMap().put("buttonSol", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	buttonSol.doClick();
	            }
	        });
	        panelContents.getActionMap().put("buttonCal", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	buttonCal.doClick();
	            }
	        });
	        panelContents.getActionMap().put("buttonVolver", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	buttonVolver.doClick();
	            }
	        });
	      
	   
		
		
	}
	
	
	
	//METODOS PUBLICOS
	public VistaGestion(CtrlPresentacion pCtrlPresentacion) {
//		ctrlPresentacion = pCtrlPresentacion;
		super(pCtrlPresentacion);
		/** DESCOMENTAR PARA EDITAR *
		  inicializarComponents();
		 /**/
	}
	
	public void init() {
//		inicializarComponents();
		inicializar_frameView();
		init_panelContents();
		inicializar_panelCenterButtons();
		assign_listenersComponents();
	}
	
	public void cargarHospital() {
		String name = ctrlPresentacion.getNameHospital();
		name = name.replace("%", " ");
	
		labelPanel1.setHorizontalAlignment(LEFT);
		labelPanel1.setVerticalAlignment(CENTER);
		labelPanel1.setText(name);
		labelPanel1.setVerticalTextPosition(CENTER);
	}
	
//	public JPanel getPanel() {
//		return panelContents;
//	}
//	
//	public void hidePanel() {
//		panelContents.setVisible(false);
//	}
//	public void showPanel() {
//		cargarHospital();
//		panelContents.setVisible(true);
//	}
//	
//	public void showView() {
//		panelContents.setVisible(true);
//	}
//	
//	public void enableView() {
//		frameView.setEnabled(true);
//	}
//	
//	public void disableView() {
//		frameView.setEnabled(false);
//	}
}
