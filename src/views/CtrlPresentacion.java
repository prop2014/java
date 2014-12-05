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
	private CtrlDoctor crtlDoctor;
	private VistaCjtHospitales vistaCjtHospitales;
	private VistaCrearHospital vistaCrearHospital;
	private VistaGestion vistaGestion;
	private VistaPlantillaDoctores vistaPlantillaDoctores;
	private VistaDoctor vistaDoctor;
	private VistaCalendario vistaCalendario;
	private VistaRestriccion vistaRestriccion;
	private VistaMAXTurnosporDia vistaMAXTurnosporDia;
	private VistaNOTTurno vistaNOTTurno;
	private VistaNOTDiaMes vistaNOTDiaMes;
	private VistaNOTEspecial vistaNOTEspecial; 
	private VistaNOTDiaSemana vistaNOTDiaSemana;
	private VistaNOTFecha vistaNOTFecha;
	private VistaXOR vistaXOR;
	private VistaMAXTurnosRango vistaMAXTurnosRango;
	
	/* Constructora */
	public CtrlPresentacion(){
		init_frameView();
		ctrlHospital = new CtrlHospital();
		crtlDoctor = new CtrlDoctor();
		vistaCjtHospitales = new VistaCjtHospitales(this);
		vistaCrearHospital = new VistaCrearHospital(this);
		vistaGestion = new VistaGestion(this);
		vistaPlantillaDoctores = new VistaPlantillaDoctores(this);
		vistaDoctor = new VistaDoctor(this);
		vistaCalendario = new VistaCalendario(this);
		vistaRestriccion = new VistaRestriccion(this);
		vistaMAXTurnosporDia = new VistaMAXTurnosporDia(this);
		vistaNOTTurno = new VistaNOTTurno(this);
		vistaNOTDiaMes = new VistaNOTDiaMes(this);
		vistaNOTEspecial = new VistaNOTEspecial(this);
		vistaNOTDiaSemana = new VistaNOTDiaSemana(this);
		vistaNOTFecha = new VistaNOTFecha(this);
		vistaXOR = new VistaXOR(this);
		vistaMAXTurnosRango = new VistaMAXTurnosRango(this);
		
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
		vistaCalendario.init();
		vistaRestriccion.init();
		vistaMAXTurnosporDia.init();
		vistaNOTTurno.init();
		vistaNOTDiaMes.init();
		vistaNOTEspecial.init();
		vistaNOTDiaSemana.init();
		vistaNOTFecha.init();
		vistaXOR.init();
		vistaMAXTurnosRango.init();
		
		vistaCjtHospitales.showView();
		vistaGestion.hidePanel();
		vistaCrearHospital.hidePanel();
		vistaPlantillaDoctores.hidePanel();
		vistaDoctor.hidePanel();
		vistaCalendario.hidePanel();
		vistaRestriccion.hidePanel();
		vistaMAXTurnosporDia.hidePanel();
		vistaNOTTurno.hidePanel();
		vistaNOTDiaMes.hidePanel();
		vistaNOTEspecial.hidePanel();
		vistaNOTDiaSemana.hidePanel();
		vistaNOTFecha.hidePanel();
		vistaXOR.hidePanel();
		vistaMAXTurnosRango.hidePanel();
		
		
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
		
		case "vistaCalendario":{
			contentPane.add(vistaCalendario.getPanel());
			vistaCalendario.showPanel();
			break;
		}
		
		case "vistaRestriccion": {
			contentPane.add(vistaRestriccion.getPanel());
			vistaRestriccion.showPanel();
			break;
		}
		
		case "vistaMAXTurnosporDia":{
			contentPane.add(vistaMAXTurnosporDia.getPanel());
			vistaMAXTurnosporDia.showPanel();
			break;
			
		}
		
		case "vistaNOTTurno":{
			contentPane.add(vistaNOTTurno.getPanel());
			vistaNOTTurno.showPanel();
			break;
			
		}
		
		case "vistaNOTDiaMes":{
			contentPane.add(vistaNOTDiaMes.getPanel());
			vistaNOTDiaMes.showPanel();
			break;
			
		}
		case "vistaNOTEspecial" :{
			contentPane.add(vistaNOTEspecial.getPanel());
			vistaNOTEspecial.showPanel();
			break;
		}
		case "vistaNOTDiaSemana" :{
			contentPane.add(vistaNOTDiaSemana.getPanel());
			vistaNOTDiaSemana.showPanel();
			break;
		}
		case "vistaNOTFecha": {
			contentPane.add(vistaNOTFecha.getPanel());
			vistaNOTFecha.showPanel();
			break;
		}
		
		
		case "vistaXOR":{
			contentPane.add(vistaXOR.getPanel());
			vistaXOR.showPanel();
			break;
		}
		
		
		case "vistaMAXTurnosRango":{
		contentPane.add(vistaMAXTurnosRango.getPanel());
		vistaMAXTurnosRango.showPanel();
		break;
		}
		 
		
	
		}
			contentPane.revalidate();
			contentPane.repaint();
	}
	
	/* Metodos de VistaCjtCalendario */
	public ArrayList<String> loadHospitals() throws IOException {
		return ctrlHospital.verHospitales();
	}
	
	public ArrayList<String> loadDoctores() throws IOException {
		return ctrlHospital.verDoctores();
		
	}
	
	public void crearHospital(String nameHosp, Double factM, Double factT, Double factN) throws IOException{
		int idHosp = ctrlHospital.getFDI();
		try {
			ctrlHospital.crearHospital(idHosp, nameHosp, factM, factT, factN);
		} catch (IOException e) {throw new IOException(e);}
		ctrlHospital.guardarHospital();
	}
	
	public void importarHospital(String path) throws IOException{
		ctrlHospital.importarHospital(path);
	}
	

	
	public void crearDoctor(String nameDoc, int idD, int maxTurnos, double sueldo) throws IOException{
		try {
			ctrlHospital.crearDoctor(idD, nameDoc, maxTurnos, sueldo);
		} catch (IOException e) {throw new IOException(e);}
		ctrlHospital.saveDataDoctors();
	}
	
	
}
