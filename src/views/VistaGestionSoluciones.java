package views;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Vista principal del Conjunto soluciones para un Hospital
 * @author Axel Pelaez
 */

public class VistaGestionSoluciones {	/* Atributos y metodos privados */
	
	private CtrlPresentacion ctrlPresentacion;
	private ArrayList<String> soluciones;
	

	//Componentes interficie
	private JFrame frameView;
	private JPanel panelContents = new JPanel();
	private JPanel panelCenterButtons = new JPanel();
	
	//Componentes
	private JLabel labelPanel1 = new JLabel();
	private JButton buttonGenerarFF = new JButton("<html><CENTER>Generar Solucion <br/>[FordFulkerson]</CENTER>");
	private JButton buttonGenerarED = new JButton("<html><CENTER>Generar Solucion <br/>[EdmondKarp]</CENTER>");
	private JButton buttonGenerarDI = new JButton("<html><CENTER>Generar Solucion Optima <br/>[Dijkstra]</CENTER>");
	private JButton buttonModSol = new JButton("<html><CENTER> Modificar Solucion</CENTER>");
	private JButton buttonVolver = new JButton("Volver");
	
	private final JList<String> list = new JList<String>();
	private final JScrollPane scrollPanel = new JScrollPane();
	
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
		
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Solucion Simple EK 1", "Solucion Simple FF 1",
					"Solucion Simple EK 2", "Solucion Optima DI 1 " };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		
	}
	
	private void inicializar_panelCenterButtons() {
		////// START: GESTIONADO POR EL BUILDER NO TOCAR
		panelCenterButtons.setBorder(new EmptyBorder(70, 20, 20, 0));
		
		buttonGenerarFF.setBounds(426, 63, 173, 53);
		buttonGenerarFF.setFont(new Font("Arial", Font.PLAIN, 12));
		
		buttonGenerarED.setFont(new Font("Arial", Font.PLAIN, 12));
		buttonGenerarED.setBounds(426, 128, 173, 53);
		
		buttonGenerarDI.setFont(new Font("Arial", Font.PLAIN, 12));
		buttonGenerarDI.setBounds(426, 193, 173, 53);
		
		buttonModSol.setFont(new Font("Arial", Font.PLAIN, 12));
		buttonModSol.setBounds(426, 257, 173, 53);
		
		buttonVolver.setFont(new Font("Arial", Font.PLAIN, 12));
		buttonVolver.setBounds(40, 324, 157, 25);
		
		labelPanel1.setFont(new Font("Arial", Font.PLAIN, 15));
		labelPanel1.setBounds(40, 26, 361, 25);
		
		panelCenterButtons.setLayout(null);
		/// END: GESTIONADO POR EL BUILDER NO TOCAR
		// Components
		scrollPanel.setBounds(40, 57, 206, 253);
		scrollPanel.setPreferredSize(new Dimension(150, 10));
		scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelCenterButtons.add(scrollPanel);
		list.setFont(new Font("Arial", Font.PLAIN, 13));
		scrollPanel.setViewportView(list);
		panelCenterButtons.setBounds(254, 125, 150, 0);
		panelCenterButtons.setPreferredSize(new Dimension(150, 0));
		
		panelCenterButtons.add(labelPanel1);
		panelCenterButtons.add(buttonVolver);
		panelCenterButtons.add(buttonGenerarFF);
		panelCenterButtons.add(buttonGenerarDI);
		panelCenterButtons.add(buttonGenerarED);
		panelCenterButtons.add(buttonModSol);
		
		buttonModSol.setEnabled(false);
	}
	private void inicializarComponents() {
		inicializar_frameView();
		inicializar_panelContents();
		inicializar_panelCenterButtons();
		assignar_listenersComponents();
	}
	
	private void assignar_listenersComponents() {
		
		ListSelectionModel listSelectionModel = list.getSelectionModel();
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {
		        public void valueChanged(ListSelectionEvent e) { 
		            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
		            buttonModSol.setEnabled(!lsm.isSelectionEmpty()); 
		       
		        }
		});

		buttonGenerarFF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			
			
		});
		

		
		buttonGenerarED.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			
			
		});
		
		buttonGenerarDI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			
			
		});
		
	
		
		buttonModSol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlPresentacion.changeView("vistaSolucion", panelContents);
				
			}
			
			
		});
		
		buttonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlPresentacion.changeView("vistaGestion", panelContents);
			}
		});
		
		
		
	}
	
	
	/* Constructoras y metodos publicos */
	public VistaGestionSoluciones(CtrlPresentacion pCtrlVistaPrincipal) {
		ctrlPresentacion = pCtrlVistaPrincipal;
		/* DESCOMENTAR PARA EDITAR *
		 inicializarComponents();
		/*  END DESCOMENTAR PARA EDITAR */
	}
	
	public void init() {
		 inicializarComponents();
	}
	
	public void cargarHospital() {
		
		String name = new String(ctrlPresentacion.getNameHospital());
		//name = name.replace("%", " ");
		name = 	"Soluciones del Hospital: "	+ name;
		
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
		//cargarSoluciones();
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