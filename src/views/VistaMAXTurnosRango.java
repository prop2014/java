package views;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Vista secundaria de gestion de restricciones tipo MAXTurnosRango
 * @author Sergi Orra Genero
 */
public class VistaMAXTurnosRango {
	
	private CtrlPresentacion ctrlPresentacion;
	
	private JFrame frameView = new JFrame("Programador de Guardias");
	private JPanel panelContents = new JPanel();
	private JPanel panelButtons = new JPanel();
	private JPanel panelInfo = new JPanel();
	
	private JLabel labelPanel1 = new JLabel("<html><u>Crear Restriccion: Tipo MAX Turnos Rango</u>");
	private JLabel labelPanel2 = new JLabel("<html><CENTER>Seleccione fecha inicial:</CENTER>");
	private JLabel labelPanel3 = new JLabel("<html><CENTER>Seleccione fecha final:</CENTER>");
	private JLabel labelPanel4 = new JLabel("<html>Escribe numero de turnos:<CENTER></CENTER>");
	private JDateChooser dataChooser1 = new JDateChooser("dd/MM/yyyy", "##/##/##", '_');
	private JDateChooser dataChooser2 = new JDateChooser("dd/MM/yyyy", "##/##/##", '_');
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
		panelInfo.add(labelPanel1);
	}
	
	private void inicializar_panelButtons() {
		//layout
		panelButtons.setBorder(new EmptyBorder(70, 20, 20, 0));
		
		labelPanel2.setBounds(100, 75, 150, 30);
		labelPanel3.setBounds(100, 110, 150, 30);
		labelPanel4.setBounds(100, 145, 150, 30);
		dataChooser1.setBounds(340, 75, 150, 30);
		dataChooser2.setBounds(340, 110, 150, 30);
		textArea.setBounds(340, 152, 50, 16);
		button.setBounds(510, 110, 150, 30);
		
		buttonVolver.setBounds(40, 230, 150, 40);
		panelButtons.setLayout(null);
	    // Botones
	    panelButtons.add(labelPanel2);
	    panelButtons.add(labelPanel3);
	    panelButtons.add(labelPanel4);
	    panelButtons.add(dataChooser1);
	    panelButtons.add(dataChooser2);
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
				Date data1 = dataChooser1.getDate();
				Date data2 = dataChooser2.getDate();
				Scanner sc1 = new Scanner(textArea.getText());
				if (data1 != null && data2 != null && sc1.hasNextInt()) {
					GregorianCalendar cal1 = new GregorianCalendar();
				    cal1.setTime(data1);	
					int dia1 = cal1.get(GregorianCalendar.DAY_OF_MONTH);
					int mes1 = cal1.get(GregorianCalendar.MONTH)+1;
					int year1 = cal1.get(GregorianCalendar.YEAR);
					GregorianCalendar cal2 = new GregorianCalendar();
				    cal2.setTime(data2);	
				    int dia2 = cal2.get(GregorianCalendar.DAY_OF_MONTH);
					int mes2 = cal2.get(GregorianCalendar.MONTH)+1;
					int year2 = cal2.get(GregorianCalendar.YEAR);
					int num = Integer.parseInt(textArea.getText());
					try {
						ctrlPresentacion.addResMAX_Turnos_Rango(dia1, mes1, year1, dia2, mes2, year2, num);
						JOptionPane.showMessageDialog(null, "Restriccion creada correctamente", "Informacion",JOptionPane.INFORMATION_MESSAGE);
						ctrlPresentacion.changeView("vistaRestriccion", panelContents);
					} catch (IOException eX) {
						JOptionPane.showMessageDialog(null, "Restriccion no creada", "Error",JOptionPane.ERROR_MESSAGE); 
						ctrlPresentacion.changeView("vistaRestriccion", panelContents);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Valores introducidos incorrectamente", "Error", JOptionPane.ERROR_MESSAGE);
				}
				sc1.close();
			}
		});	
	}
	
	
	//METODOS PUBLICOS
	
	public VistaMAXTurnosRango(CtrlPresentacion pCtrlPresentacion) {
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