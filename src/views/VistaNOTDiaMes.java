package views;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;

/**
 * Vista secundaria de gestion de restricciones tipo NOT Dia Mes
 * @author Sergi Orra Genero
 */
public class VistaNOTDiaMes {
	
	private CtrlPresentacion ctrlPresentacion;
	
	private JFrame frameView;
	private JPanel panelContents = new JPanel();
	private JPanel panelButtons = new JPanel();
	private JPanel panelInfo = new JPanel();
	
	private JLabel labelPanel1 = new JLabel("<html><u>Crear Restriccion:</u> Tipo NOT Dia Mes");
	
	private JLabel labelPanel3 = new JLabel("<html><CENTER>Escribe el dia del mes:</CENTER>");
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
		labelPanel3.setBounds(155, 92, 150, 30);
		textArea.setBounds(335, 102, 35, 16);
		button.setFont(new Font("Arial", Font.PLAIN, 12));
		button.setBounds(415, 95, 150, 30);
		buttonVolver.setFont(new Font("Arial", Font.PLAIN, 12));
		buttonVolver.setBounds(40, 230, 150, 40);
		panelButtons.setLayout(null);
	    // Botones
	    panelButtons.add(labelPanel3);
	    panelButtons.add(textArea);
	    panelButtons.add(button);
	    panelButtons.add(buttonVolver);
	    // Tooltips
	    button.setToolTipText("[CTRL+ENTER]");
	    buttonVolver.setToolTipText("[ESC]");
	}

	private void assignar_listenersComponents() {
		buttonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				ctrlPresentacion.changeView("vistaRestriccion", panelContents);
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scanner sc1 = new Scanner(textArea.getText());
				int dia;
				if (sc1.hasNextInt()) {
					dia = Integer.parseInt(textArea.getText());
					try {
						ctrlPresentacion.addResNOT_Dia_Mes(dia);
						JOptionPane.showMessageDialog(null, "Restriccion creada correctamente", "Informacion",JOptionPane.INFORMATION_MESSAGE);
						textArea.setText(null);
						ctrlPresentacion.changeView("vistaRestriccion", panelContents);
					} catch (IOException eX) {
						JOptionPane.showMessageDialog(null, "Restriccion no creada", "Error",JOptionPane.ERROR_MESSAGE); 
						textArea.setText(null);
						ctrlPresentacion.changeView("vistaRestriccion", panelContents);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Dia del mes incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
					textArea.setText(null);
				}
				sc1.close();
			}
		});	
		panelContents.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "buttonVolver");
		panelContents.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, java.awt.event.InputEvent.CTRL_DOWN_MASK), "button");
		
		panelContents.getActionMap().put("buttonVolver", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	buttonVolver.doClick();
            }
        });
		
		panelContents.getActionMap().put("button", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	button.doClick();
            }
        });
	}
	
	
	//METODOS PUBLICOS
	
	public VistaNOTDiaMes(CtrlPresentacion pCtrlPresentacion) {
		ctrlPresentacion = pCtrlPresentacion;
		/* DESCOMENTAR PARA EDITAR
		      inicializarComponents();
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