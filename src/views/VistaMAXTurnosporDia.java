
package views;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

/**
 * Vista secundaria de gestion de restricciones tipo MAX Turnos por Dia
 * @author Sergi Orra Genero
 */
public class VistaMAXTurnosporDia {
	
	private CtrlPresentacion ctrlPresentacion;
	
	private JFrame frameView;
	private JPanel panelContents = new JPanel();
	private JPanel panelButtons = new JPanel();
	private JPanel panelInfo = new JPanel();
	
	private JLabel labelPanel1 = new JLabel("<html><u>Crear Restriccion:</u> Tipo MAX Turnos por Dia");
	
	private JLabel labelPanel3 = new JLabel("<html><CENTER>Escribe el numero<br/> de turnos:</CENTER>");
	private JTextArea textArea = new JTextArea(1,1);
	private JButton button = new JButton("Aceptar");
	private JButton buttonVolver = new JButton("Volver");
	
	
	private void inicializarComponents() {
	    inicializar_frameView();
	    inicializar_panelContents();
	    inicializar_panelInfo();
	    inicializar_panelButtons();
	    assignar_listenersComponents();
	  }
	
	// METODOS PRIVADOS
	
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
	    // Layout
	    panelContents.setLayout(new BorderLayout());
	    // Paneles
	    panelContents.add(panelInfo,BorderLayout.NORTH);
	    panelContents.add(panelButtons,BorderLayout.CENTER);
	}
	
	private void inicializar_panelInfo() {
		panelInfo.setBorder(BorderFactory.createEmptyBorder(55, 75, 0, 75));
		labelPanel1.setFont(new Font("Arial", Font.PLAIN, 18));
		panelInfo.add(labelPanel1);
	}
	
	private void inicializar_panelButtons() {
		//layout
		panelButtons.setBorder(new EmptyBorder(70, 20, 20, 0));
		labelPanel3.setFont(new Font("Arial", Font.PLAIN, 15));
		labelPanel3.setBounds(150, 95, 150, 30);
		textArea.setBounds(305, 102, 35, 16);
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBounds(390, 95, 150, 30);
		buttonVolver.setFont(new Font("Arial", Font.PLAIN, 12));
		buttonVolver.setBounds(40, 230, 150, 40);
		panelButtons.setLayout(null);
	    // Botones
	    panelButtons.add(labelPanel3);
	    panelButtons.add(textArea);
	    panelButtons.add(button);
	    panelButtons.add(buttonVolver);
	    // Tooltips
	    button.setToolTipText("Aceptar");
	}

	private void assignar_listenersComponents() {
		
		buttonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlPresentacion.changeView("vistaRestriccion", panelContents);
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scanner sc1 = new Scanner(textArea.getText());
				int numT;
				if (sc1.hasNextInt()) {
					numT = Integer.parseInt(textArea.getText());
					try {
						ctrlPresentacion.addResMAX_Turnos_por_Dia(numT);
						JOptionPane.showMessageDialog(null, "Restriccion creada correctamente", "Informacion",JOptionPane.INFORMATION_MESSAGE);
						ctrlPresentacion.changeView("vistaRestriccion", panelContents);
					} catch (IOException eX) {
						JOptionPane.showMessageDialog(null, "Restriccion no creada", "Error",JOptionPane.ERROR_MESSAGE); 
						ctrlPresentacion.changeView("vistaRestriccion", panelContents);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Numero de turnos incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
				}
				sc1.close();
			}
		});	
	}
	
	
	//METODOS PUBLICOS
	
	public VistaMAXTurnosporDia() {
	}
	
	public VistaMAXTurnosporDia(CtrlPresentacion pCtrlPresentacion) {
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
	/*public static void main(String[] args)  {
		VistaMAXTurnosporDia v = new VistaMAXTurnosporDia();
		v.showView();
	}*/

}