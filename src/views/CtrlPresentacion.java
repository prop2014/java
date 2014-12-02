package views;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import domain.*;

/*Controlador principal de la Vista */

public class CtrlPresentacion {

	/* Atributos */
	private JFrame frameView;
	private CtrlHospital ctrlHospital;
	private VistaCjtHospitales vistaCjtHospitales;
	private VistaGestion vistaGestion;
	
	/* Constructora */
	public CtrlPresentacion(){
		init_frameView();
		ctrlHospital = new CtrlHospital();
		vistaCjtHospitales = new VistaCjtHospitales(this);
		vistaGestion = new VistaGestion(this);
		
	}
	
	private void init_frameView() {
		frameView = new JFrame("Programador de Guardias");  //$NON-NLS-1$
		frameView.setMinimumSize(new Dimension(700, 400));
		frameView.setPreferredSize(frameView.getMinimumSize());
		frameView.setResizable(false);
		frameView.setLocationRelativeTo(null);
		frameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameView.getContentPane().setBackground(Color.WHITE);
		
	}
	
	
	/* Metodos publicos */
	
	public JFrame getFrame(){
		return frameView;
	}
	
	public void initPresentation() {
		vistaCjtHospitales.init();
		vistaCjtHospitales.showView();
	}
	
	public void changeViewGestion() {
		JPanel contentPane = (JPanel) frameView.getContentPane();
		contentPane.removeAll();
		vistaGestion.init();
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	public void changeVolver() {
		JPanel contentPane = (JPanel) frameView.getContentPane();
		contentPane.removeAll();
		vistaCjtHospitales.init();
		contentPane.revalidate();
		contentPane.repaint();
	}
	/* Metodos de VistaCjtCalendario */
	public ArrayList<String> loadHospitals() throws IOException {
		return ctrlHospital.verHospitales();
	}
	
}
