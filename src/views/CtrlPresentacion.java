package views;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;

import domain.*;

/*Controlador principal de la Vista */

public class CtrlPresentacion {

	/* Atributos */
	
	private JFrame frameView;
	private CtrlHospital ctrlHospital;
	private CtrlCalendario ctrlCalendario;
	private CtrlDoctor ctrlDoctor;
	private VistaCjtHospitales vistaCjtHospitales;
	private VistaCrearHospital vistaCrearHospital;
	private VistaGestion vistaGestion;
	private VistaPlantillaDoctores vistaPlantillaDoctores;
	private VistaDoctor vistaDoctor;
	private VistaCalendario vistaCalendario;
	private VistaDiaCalendario vistaDiaCalendario;
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
		ctrlCalendario = new CtrlCalendario(ctrlHospital.getCalendar());
		ctrlDoctor = new CtrlDoctor();
		vistaCjtHospitales = new VistaCjtHospitales(this);
		vistaCrearHospital = new VistaCrearHospital(this);
		vistaGestion = new VistaGestion(this);
		vistaPlantillaDoctores = new VistaPlantillaDoctores(this);
		vistaDoctor = new VistaDoctor(this);
		vistaCalendario = new VistaCalendario(this);
		vistaDiaCalendario = new VistaDiaCalendario(this);
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
//		vistaDiaCalendario.init();
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
		vistaDiaCalendario.hidePanel();
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
		
		case "vistaCalendario": {
			contentPane.add(vistaCalendario.getPanel());
			vistaCalendario.showPanel();
			break;
		}
		
		case "vistaDiaCalendario": {
			contentPane.add(vistaDiaCalendario.getPanel());
			vistaDiaCalendario.showPanel();
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
	
//	public ArrayList<ArrayList<String>> loadDoctores() throws IOException {
//		return ctrlHospital.verDoctores();
//		
//	}
	
	public void crearHospital(String nameHosp, Double factM, Double factT, Double factN, String pathDoc, String pathCal) throws IOException{
		int idHosp = ctrlHospital.getFDI();
		try {
			ctrlHospital.crearHospital(idHosp, nameHosp, factM, factT, factN);
			
		} catch (IOException e) {throw new IOException(e);}
		ctrlHospital.guardarHospital();
	}
	
	public void importarHospital(String path) throws IOException{
		ctrlHospital.importarHospital(path);
	}
	
	public void cargarHospital(int idHosp) throws IOException {
		ctrlHospital.cargarHospital(idHosp);
	}
	
	public String getNameHospital() {
		return ctrlHospital.getNameHospital();
	}
	
	public void crearDoctor(String nameDoc, int idD, int maxTurnos, double sueldo) throws IOException{
		try {
			ctrlHospital.crearDoctor(idD, nameDoc, maxTurnos, sueldo);
		} catch (IOException e) {throw new IOException(e);}
		ctrlHospital.saveDataDoctors();
	}
	
	public void addResMAX_Turnos_por_Dia(int idDoc, int numD) throws IOException {
		int idRes = ctrlDoctor.getFDIRes(idDoc);
		try {
			ctrlDoctor.addResMAX_Turnos_por_Dia(idDoc, idRes, numD);
		} catch (IOException e) {throw new IOException(e);}
		//ctrlDoctor.saveDataRes(idHosp);
	}
	
	public void addResMAX_Turnos_Rango(int idDoc, int d1, int m1, int a1, int d2, int m2, int a2, int numT) throws IOException {
		int idRes = ctrlDoctor.getFDIRes(idDoc);
		try {
			ctrlDoctor.addResMAX_Turnos_Rango(idDoc, idRes, d1, m1, a1, d2, m2, a2, numT);
		} catch (IOException e) {throw new IOException(e);}
		//ctrlDoctor.saveDataRes(idHosp);
	}
	
	public void addResNOT_Dia_Mes(int idDoc, int diaMes) throws IOException {
		int idRes = ctrlDoctor.getFDIRes(idDoc);
		try {
			ctrlDoctor.addResNOT_Dia_Mes(idDoc, idRes, diaMes);
		} catch (IOException e) {throw new IOException(e);}
		//ctrlDoctor.saveDataRes(idHosp);
	}
	
	public void addResNOT_Dia_Semana(int idDoc, String diaSemana) throws IOException {
		int idRes = ctrlDoctor.getFDIRes(idDoc);
		try {
			ctrlDoctor.addResNOT_Dia_Semana(idDoc, idRes, diaSemana);
		} catch (IOException e) {throw new IOException(e);}
		//ctrlDoctor.saveDataRes(idHosp);
	}
	
	public void addResNOT_Especial(int idDoc, String especial) throws IOException {
		int idRes = ctrlDoctor.getFDIRes(idDoc);
		try {
			ctrlDoctor.addResNOT_Especial(idDoc, idRes, especial);
		} catch (IOException e) {throw new IOException(e);}
		//ctrlDoctor.saveDataRes(idHosp);
	}
	
	public void addResNOT_Fecha(int idDoc, int d, int m, int a) throws IOException {
		int idRes = ctrlDoctor.getFDIRes(idDoc);
		try {
			ctrlDoctor.addResNOT_Fecha(idDoc, idRes, d, m, a);
		} catch (IOException e) {throw new IOException(e);}
		//ctrlDoctor.saveDataRes(idHosp);
	}
	
	public void addResNOT_Turno(int idDoc, String tipoTurno) throws IOException {
		int idRes = ctrlDoctor.getFDIRes(idDoc);
		try {
			ctrlDoctor.addResNOT_Turno(idDoc, idRes, tipoTurno);
		} catch (IOException e) {throw new IOException(e);}
		//ctrlDoctor.saveDataRes(idHosp);
	}
	
	public void addResXOR(int idDoc, ArrayList<Integer> diaXOR, ArrayList<Integer> mesXOR,  ArrayList<Integer> yearXOR, ArrayList<String> tipoTurnoXOR) throws IOException {
		int idRes = ctrlDoctor.getFDIRes(idDoc);
		try {
			ctrlDoctor.addResXOR(idDoc, idRes, diaXOR, mesXOR, yearXOR, tipoTurnoXOR);
		} catch (IOException e) {throw new IOException(e);}
		//ctrlDoctor.saveDataRes(idHosp);
	}
	/* Calendar methods */
	//--------------------------------------------------------------------------//
	public void createCalendar(int year) {
		ctrlHospital.addCalendar(year);
		ctrlCalendario = new CtrlCalendario(ctrlHospital.getCalendar());
	}
	
	public boolean addVacation(GregorianCalendar date, int morningDrs, int eveningDrs, int nightDrs, String especialDate) throws IOException {
		try {
			return ctrlCalendario.addVacationDay2(date, morningDrs, eveningDrs, nightDrs, especialDate);
		} catch (IOException e) {throw e;}
	}

	public boolean modifyVacation(GregorianCalendar date, int morningDrs, int eveningDrs, int nightDrs, String especialDate) throws IOException {
		try {
			return ctrlCalendario.modifyVacationDay(date, morningDrs, eveningDrs, nightDrs, especialDate);
		} catch (IOException e) {throw e;}
	}
	
	public boolean deleteVacationDay(GregorianCalendar date) throws IOException {
		try {
			return ctrlCalendario.deleteVacationDay(date);
		} catch (IOException e) {throw e;}
	}
	
	public int getCalendarYear() {
		return ctrlCalendario.getCalendarYear();
	}
	
	public ArrayList<ArrayList<String>> getALLVacations() {
		return ctrlCalendario.getALLVacations();
	}
}
