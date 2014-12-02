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
	private VistaCrearHospital vistaCrearHospital;
	private VistaGestion vistaGestion;
	
	
	/* Constructora */
	public CtrlPresentacion(){
		init_frameView();
		ctrlHospital = new CtrlHospital();
		vistaCjtHospitales = new VistaCjtHospitales(this);
		vistaCrearHospital = new VistaCrearHospital(this);
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
		vistaGestion.init();
		vistaCrearHospital.init();
		vistaCrearHospital.hidePanel();
		vistaGestion.hidePanel();
		vistaCjtHospitales.showView();
	}
	
	public void changeViewCrear() {
		JPanel contentPane = (JPanel) frameView.getContentPane();
		contentPane.remove(vistaCjtHospitales.getPanel());
		contentPane.add(vistaCrearHospital.getPanel());
		vistaCrearHospital.showPanel();
		//contentPane.removeAll();
		//vistaCrearHospital.init();
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	public void changeViewGestion() {
		JPanel contentPane = (JPanel) frameView.getContentPane();
		contentPane.remove(vistaCjtHospitales.getPanel());
		//vistaCjtHospitales.hidePanel();
		contentPane.add(vistaGestion.getPanel());
		vistaGestion.showPanel();
		//vistaGestion.init();
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	public void changeVolver(JPanel panel) {
		JPanel contentPane = (JPanel) frameView.getContentPane();
		contentPane.remove(panel);
		//vistaGestion.hidePanel();
		contentPane.add(vistaCjtHospitales.getPanel());
		vistaCjtHospitales.showPanel();
		//vistaCjtHospitales.init();
		contentPane.revalidate();
		contentPane.repaint();
	}
	/* Metodos de VistaCjtCalendario */
	public ArrayList<String> loadHospitals() throws IOException {
		return ctrlHospital.verHospitales();
	}
	
}
