package views;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 * Vista principal de los datos de un Doctor
 * 
 * @author Axel Pelaez
 */

public class VistaDoctor {
	// Componentes interficie

	private CtrlPresentacion ctrlPresentacion;

	private JFrame frameView;
	private JPanel panelContents = new JPanel();
	private JPanel panelCenterButtons = new JPanel();

	

	//SCROLL PANEL
	
	final String[] fila1 ={"<html><LEFT>Tipo</LEFT></html>","<html><LEFT>Info</LEFT></html>"};
	final Object[][] datos={};
	
	private JTable tabla = new JTable();
	private JScrollPane scrollPanel = new JScrollPane();
	
	
	//private String[] docInfo;

	// CENTER

	private JLabel labelPanel1 = new JLabel();
	private JLabel labelPanelID = new JLabel("ID:");
	private JLabel labelPanelNombre = new JLabel("Nombre:");
	private JLabel labelPanelMaxTurnos = new JLabel("Max. Turnos:");
	private JLabel labelPanelSueldo = new JLabel("Sueldo:");

	private JTextArea textID = new JTextArea();
	private JTextArea textNombre = new JTextArea();
	private JTextArea textMaxTurnos = new JTextArea();
	private JTextArea textSueldo = new JTextArea();

	private JButton buttonEliminar = new JButton(
			"<html><CENTER>Eliminar<br/>Restriccion</CENTER>");
	private JButton buttonAnadir = new JButton(
			"<html><CENTER>Añadir<br/>Restriccion</CENTER>");
	private JButton buttonGuardar = new JButton(
			"<html><CENTER>Guardar<br/>cambios</CENTER>");
	private JButton buttonVolver = new JButton("Volver");

	// METODOS PRIVADOS

	private void inicializar_frameView() {
		/*** DESCOMENTAR PARA EDITAR * 
		 frameView = new
		 JFrame("Programador Guardias"); frameView.setMinimumSize(new
		 Dimension(700, 400));
		 frameView.setPreferredSize(frameView.getMinimumSize());
		 frameView.setResizable(false); frameView.setLocationRelativeTo(null);
		 frameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frameView.getContentPane().setBackground(Color.WHITE); 
		 /*** END DESCOMENTAR PARA EDITAR */
		frameView = ctrlPresentacion.getFrame();
		JPanel contentPane = (JPanel) frameView.getContentPane();
		contentPane.setLayout(null);
		panelContents.setBounds(0, 0, 700, 378);
		contentPane.add(panelContents);
	}

	private void inicializar_panelContents() {

		panelContents.setLayout(new BorderLayout());
		// Componentes
		panelContents.add(panelCenterButtons, BorderLayout.CENTER);

	}

	private void inicializar_panelCenterButtons() {

		// //// START: GESTIONADO POR EL BUILDER NO TOCAR

		// BOTONES
		panelCenterButtons.setBorder(new EmptyBorder(70, 20, 20, 0));
		panelCenterButtons.setLayout(null);

		buttonAnadir.setFont(new Font("Arial", Font.PLAIN, 12));
		buttonAnadir.setBounds(449, 128, 173, 40);

		buttonEliminar.setFont(new Font("Arial", Font.PLAIN, 12));
		buttonEliminar.setBounds(449, 180, 173, 40);

		buttonGuardar.setFont(new Font("Arial", Font.PLAIN, 12));
		buttonGuardar.setBounds(449, 233, 173, 40);

		buttonVolver.setFont(new Font("Arial", Font.PLAIN, 12));
		buttonVolver.setBounds(52, 323, 157, 25);

		// labels
		labelPanel1.setFont(new Font("Arial", Font.PLAIN, 12));
		labelPanel1.setBounds(44, 16, 361, 25);

		labelPanelID.setFont(new Font("Arial", Font.PLAIN, 12));
		labelPanelID.setBounds(52, 45, 28, 30);

		labelPanelNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		labelPanelNombre.setBounds(52, 69, 71, 33);

		labelPanelMaxTurnos.setFont(new Font("Arial", Font.PLAIN, 12));
		labelPanelMaxTurnos.setBounds(340, 45, 101, 31);

		labelPanelSueldo.setFont(new Font("Arial", Font.PLAIN, 12));
		labelPanelSueldo.setBounds(340, 70, 88, 31);

		// textArea
		textID.setBounds(124, 53, 166, 15);
		textNombre.setBounds(124, 78, 166, 15);
		textMaxTurnos.setBounds(449, 53, 166, 15);
		textSueldo.setBounds(449, 78, 166, 15);

		// Scroll
		panelCenterButtons.add(scrollPanel);
		
		scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanel.setBounds(52, 107, 377, 191);
		scrollPanel.setViewportView(tabla);
		tabla.setFont(new Font("Arial", Font.PLAIN, 12));
		
		tabla.setForeground(Color.red);
		tabla.setBackground(Color.white);

		// / END: GESTIONADO POR EL BUILDER NO TOCAR


		// Components
		

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
		
		buttonEliminar.setEnabled(false);
	}

	private void inicializarComponents() {
		inicializar_frameView();
		inicializar_panelContents();
		inicializar_panelCenterButtons();
		assignar_listenersComponents();

	}

	private void assignar_listenersComponents() {

		ListSelectionModel listSelectionModel = tabla.getSelectionModel();
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {
		        public void valueChanged(ListSelectionEvent e) { 
		            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
		            buttonEliminar.setEnabled(!lsm.isSelectionEmpty()); 
		        }
		});
		
		
		
		buttonGuardar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (ctrlPresentacion.isEmptyDocActual()) {// Se a entrado para crear

					String nameDoc = textNombre.getText();
					nameDoc = nameDoc.replaceAll(" ", "%");
					try {
						int id = Integer.parseInt(textID.getText());
						int maxTurnos = Integer.parseInt(textMaxTurnos
								.getText());
						Double sueldo = Double.parseDouble(textSueldo.getText());
						if (nameDoc.isEmpty())
							throw new IOException("El doctor no tiene nombre");
						ctrlPresentacion.crearDoctor(nameDoc, id, maxTurnos,
								sueldo);
					} catch (IOException eX) {
						JOptionPane.showMessageDialog(null, eX, "Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (NumberFormatException nE) {
						JOptionPane
								.showMessageDialog(
										null,
										"Alguno de los factores no es un valor correcto",
										"Error", JOptionPane.ERROR_MESSAGE);
					}

				}

				else {// Se a entrado para modificar
					
					String[] docActual = ctrlPresentacion.getDocActual();
					
					if (!docActual.equals(textID.getText())
							|| !docActual.equals(textNombre.getText())
							|| !docActual.equals(textSueldo.getText())
							|| !docActual.equals(textMaxTurnos.getText())) {
						// Habra que comprobar si se han modificado las
						// restricciones

						try {
							String nombre = textNombre.getText();
							nombre = nombre.replaceAll(" ", "%");
							int idDoc = Integer.parseInt(textID.getText());
							int maxTurnos = Integer.parseInt(textMaxTurnos
									.getText());
							Double sueldo = Double.parseDouble(textSueldo
									.getText());
							ctrlPresentacion.setDoctor(idDoc, nombre,
									maxTurnos, sueldo);

							/*
							 * if(nameDoc.isEmpty()) throw new
							 * IOException("El doctor no tiene nombre");
							 * 
							 * //ctrlPresentacion.eliminarDoc(id);
							 * //ctrlPresentacion.crearDoctor(nameDoc, id,
							 * maxTurnos, sueldo);
							 */
						} catch (IOException eX) {
							JOptionPane.showMessageDialog(null, eX, "Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (NumberFormatException nE) {
							JOptionPane
									.showMessageDialog(
											null,
											"Alguno de los factores no es un valor correcto",
											"Error", JOptionPane.ERROR_MESSAGE);
						}

					}

				}

				ctrlPresentacion.changeView("vistaPlantillaDoctores",
						panelContents);
			}

		});

		buttonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlPresentacion.changeView("vistaPlantillaDoctores",
						panelContents);
			}
		});

		buttonAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (ctrlPresentacion.isEmptyDocActual()) {// Se entra para CREAR

					
					try {
						
						String nameDoc = textNombre.getText();
						nameDoc = nameDoc.replaceAll(" ", "%");
						ctrlPresentacion.setDocActual(textID.getText(), nameDoc,  
													textSueldo.getText(), textMaxTurnos.getText());
						
						if (nameDoc.isEmpty()) throw new IOException("El doctor no tiene nombre");
						
						ctrlPresentacion.crearDoctor(ctrlPresentacion.getNameDocAc(), ctrlPresentacion.getIdDocAc(),
											ctrlPresentacion.getMaxTurnDocAc(), ctrlPresentacion.getSueldoDocAc());
						ctrlPresentacion.changeView("vistaRestriccion", panelContents);
						
					} catch (IOException eX) {
						JOptionPane.showMessageDialog(null, eX, "Error", JOptionPane.ERROR_MESSAGE);
					} catch (NumberFormatException nE) {
						JOptionPane	.showMessageDialog(null,
										"Alguno de los factores no es un valor correcto",
										"Error", JOptionPane.ERROR_MESSAGE);
					}

				}

				
			}
		});

		buttonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object[] options = { "Aceptar", "Cancelar" };
				JOptionPane.showOptionDialog(null,
						"Esta seguro de que quiere eliminar la restriccion?",
						"Alert", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, options[1]);
			}
		});

	}


	
	private void loadRest() {
		ArrayList<ArrayList<String>> restricciones = new ArrayList<ArrayList<String>>() ;
		if(! ctrlPresentacion.isEmptyDocActual())restricciones = 
				ctrlPresentacion.loadRest(ctrlPresentacion.getIdDocAc());
		
		DefaultTableModel dtm = new DefaultTableModel(datos,fila1){
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		
		}; 
		//Que no se muevan las columnas
		tabla.getTableHeader().setReorderingAllowed(false);
	
		if(!restricciones.isEmpty()){
			for(ArrayList<String> rest : restricciones){
				String[] row = new String[rest.size()];
				row = rest.toArray(row);
				dtm.addRow(row); 
			}
		
		}
		
		tabla.setModel(dtm);  
		tabla.revalidate();
		tabla.repaint();
		
	}
	
	// METODOS PUBLICOS


	/**
	 * @wbp.parser.entryPoint
	 */
	public VistaDoctor(CtrlPresentacion pCtrlPresentacion) {
		ctrlPresentacion = pCtrlPresentacion;
		/** DESCOMENTAR PARA EDITAR *
		 inicializarComponents();
		 //*/
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

		loadRest();
		
		String [] docAc = ctrlPresentacion.getDocActual();
		
		textID.setText(docAc[0]);
		textNombre.setText(docAc[1]);
		textSueldo.setText(docAc[2]);
		textMaxTurnos.setText(docAc[3]);

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
