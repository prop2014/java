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
	private VistaPlantillaDoctores vistaPlantillaDoctores;
	private VistaDoctor vistaDoctor;
	private VistaRestriccion vistaRestriccion;
	
	/* Constructora */
	public CtrlPresentacion(){
		init_frameView();
		ctrlHospital = new CtrlHospital();
		vistaCjtHospitales = new VistaCjtHospitales(this);
		vistaCrearHospital = new VistaCrearHospital(this);
		vistaGestion = new VistaGestion(this);
		vistaPlantillaDoctores = new VistaPlantillaDoctores(this);
		vistaDoctor = new VistaDoctor(this);
		vistaRestriccion = new VistaRestriccion(this);
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
		vistaPlantillaDoctores.init();
		vistaDoctor.init();
		vistaRestriccion.init();
		
		
		vistaRestriccion.hidePanel();
		vistaDoctor.hidePanel();
		vistaCrearHospital.hidePanel();
		vistaGestion.hidePanel();
		vistaPlantillaDoctores.hidePanel();
		
		
		
		vistaCjtHospitales.showView();
	}
	
	public void changeView(String nextView, JPanel panel) {
		JPanel contentPane = (JPanel) frameView.getContentPane();
		contentPane.remove(panel);
		
		switch(nextView){
		case "vistaCjtHospitales":{
		
			contentPane.add(vistaCjtHospitales.getPanel());
			vistaCjtHospitales.showPanel();
			break;
		}
		
		case "vistaCrearHospital":{
			contentPane.add(vistaCrearHospital.getPanel());
			vistaCrearHospital.showPanel();
			break;
		}
		
		case "vistaGestion": {
			contentPane.add(vistaGestion.getPanel());
			vistaGestion.showPanel();
			break;
		}
		
		case "vistaPlantillaDoctores": {
			contentPane.add(vistaPlantillaDoctores.getPanel());
			vistaPlantillaDoctores.showPanel();
			break;
		}
		
		case "vistaDoctor": {
			contentPane.add(vistaDoctor.getPanel());
			vistaDoctor.showPanel();
			break;
		}
		
		case "vistaRestriccion": {
			contentPane.add(vistaRestriccion.getPanel());
			vistaRestriccion.showPanel();
			break;
		}
		
		
	
		}
			contentPane.revalidate();
			contentPane.repaint();
	}
	
	/*public void changeViewCrear(JPanel panel) {
		JPanel contentPane = (JPanel) frameView.getContentPane();
		contentPane.remove(panel);
		contentPane.add(vistaCrearHospital.getPanel());
		vistaCrearHospital.showPanel();
		//vistaCjtHospitales.hidePanel();
		//vistaGestion.init();
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	 public void changeViewGestion(JPanel panel) {
		JPanel contentPane = (JPanel) frameView.getContentPane();
		contentPane.remove(panel);
		contentPane.add(vistaGestion.getPanel());
		vistaGestion.showPanel();
		//vistaCjtHospitales.hidePanel();
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
	}*/
	/* Metodos de VistaCjtCalendario */
	public ArrayList<String> loadHospitals() throws IOException {
		return ctrlHospital.verHospitales();
	}
	
	public void crearHospital(String nameHosp, Double factM, Double factT, Double factN) throws IOException{
		int idHosp = ctrlHospital.getFDI();
		try {
			ctrlHospital.crearHospital(idHosp, nameHosp, factM, factT, factN);
		} catch (IOException e) {throw new IOException(e);}
		ctrlHospital.guardarHospital();
	}
	
}
