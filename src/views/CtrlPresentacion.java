package views;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.text.ParseException;
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
	private CtrlAlgorithm ctrlAlgorithm;
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
	private VistaGestionSoluciones vistaGestionSoluciones;
	private VistaSolucion vistaSolucion;
	
	/* Constructora */
	public CtrlPresentacion() {
		init_frameView();
		ctrlHospital = new CtrlHospital();
		ctrlCalendario = new CtrlCalendario(ctrlHospital.getCalendar());
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
		vistaGestionSoluciones = new VistaGestionSoluciones(this);
		vistaSolucion = new VistaSolucion(this);
		
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
		vistaGestionSoluciones.init();
		vistaSolucion.init();
		
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
		vistaGestionSoluciones.hidePanel();
		vistaSolucion.hidePanel();
		
		
	}
	
	public void changeView(String nextView, JPanel panel) {
		JPanel contentPane = (JPanel) frameView.getContentPane();
		contentPane.remove(panel);
		
		switch(nextView){
		
		case "vistaGestionSoluciones":{
			contentPane.add(vistaGestionSoluciones.getPanel());
			vistaGestionSoluciones.showPanel();
			break;
		}
		case "vistaSolucion":{
			contentPane.add(vistaSolucion.getPanel());
			vistaSolucion.showPanel();
			break;
		}
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
	
	public ArrayList<ArrayList<String>> loadDoctores() throws IOException {
		return ctrlHospital.verDoctores();
		
	}
	
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
	
	public void cargarHospital(int idHosp) throws IOException, ParseException {
		ctrlHospital.cargarHospital(idHosp);
		ctrlHospital.getDataDoctors(idHosp);
		ctrlCalendario.readCalendar(idHosp, null);
		ctrlDoctor = new CtrlDoctor(ctrlHospital.getDoctors(), ctrlCalendario.getCalendarYear());
		ctrlAlgorithm = new CtrlAlgorithm(ctrlHospital.getHospital());
		
	}
	
	public String getNameHospital() {
		return ctrlHospital.getNameHospital();
	}
	
	public ArrayList<String> getInfoHospital(int id) throws IOException{
		return ctrlHospital.getInfoHospital(id);
	}
	
	public void deleteHospital(int id) throws IOException {
		ctrlHospital.deleteHospital(id);
	}
	
	/*DOCTORES*/
	public void crearDoctor(String nameDoc, int idD, int maxTurnos, double sueldo) throws IOException{
		try {
			ctrlHospital.crearDoctor(idD, nameDoc, maxTurnos, sueldo);
		} catch (IOException e) {throw new IOException(e);}
		ctrlHospital.saveDataDoctors();
	}
	
	public void eliminarDoc(int id)throws IOException{
		ctrlHospital.eliminarDoctor(id);
		ctrlHospital.saveDataDoctors();
	}
	
	public void setDocInfo(String[] newDocInfo){
		vistaDoctor.setDocInfo(newDocInfo);
	}
	
	public void addResMAX_Turnos_por_Dia(int numD) throws IOException {
		int idDoc = vistaDoctor.getDocId();
		int idRes = ctrlDoctor.getFDIRes(idDoc);
		int idHosp = ctrlHospital.getID();
		try {
			ctrlDoctor.addResMAX_Turnos_por_Dia(idDoc, idRes, numD);
		} catch (IOException e) {throw new IOException(e);}
		ctrlDoctor.saveDataRes(idHosp);
	}
	
	public void addResMAX_Turnos_Rango(int d1, int m1, int a1, int d2, int m2, int a2, int numT) throws IOException {
		int idDoc = vistaDoctor.getDocId();
		int idRes = ctrlDoctor.getFDIRes(idDoc);
		int idHosp = ctrlHospital.getID();
		try {
			ctrlDoctor.addResMAX_Turnos_Rango(idDoc, idRes, d1, m1, a1, d2, m2, a2, numT);
		} catch (IOException e) {throw new IOException(e);}
		ctrlDoctor.saveDataRes(idHosp);
	}
	
	public void addResNOT_Dia_Mes(int diaMes) throws IOException {
		int idDoc = vistaDoctor.getDocId();
		int idRes = ctrlDoctor.getFDIRes(idDoc);
		int idHosp = ctrlHospital.getID();
		try {
			ctrlDoctor.addResNOT_Dia_Mes(idDoc, idRes, diaMes);
		} catch (IOException e) {throw new IOException(e);}
		ctrlDoctor.saveDataRes(idHosp);
	}
	
	public void addResNOT_Dia_Semana(String diaSemana) throws IOException {
		int idDoc = vistaDoctor.getDocId();
		int idRes = ctrlDoctor.getFDIRes(idDoc);
		int idHosp = ctrlHospital.getID();
		try {
			ctrlDoctor.addResNOT_Dia_Semana(idDoc, idRes, diaSemana);
		} catch (IOException e) {throw new IOException(e);}
		ctrlDoctor.saveDataRes(idHosp);
	}
	
	public void addResNOT_Especial(String especial) throws IOException {
		int idDoc = vistaDoctor.getDocId();
		int idRes = ctrlDoctor.getFDIRes(idDoc);
		int idHosp = ctrlHospital.getID();
		try {
			ctrlDoctor.addResNOT_Especial(idDoc, idRes, especial);
		} catch (IOException e) {throw new IOException(e);}
		ctrlDoctor.saveDataRes(idHosp);
	}
	
	public void addResNOT_Fecha(int d, int m, int a) throws IOException {
		int idDoc = vistaDoctor.getDocId();
		int idRes = ctrlDoctor.getFDIRes(idDoc);
		int idHosp = ctrlHospital.getID();
		try {
			ctrlDoctor.addResNOT_Fecha(idDoc, idRes, d, m, a);
		} catch (IOException e) {throw new IOException(e);}
		ctrlDoctor.saveDataRes(idHosp);
	}
	
	public void addResNOT_Turno(String tipoTurno) throws IOException {
		int idDoc = vistaDoctor.getDocId();
		int idRes = ctrlDoctor.getFDIRes(idDoc);
		int idHosp = ctrlHospital.getID();
		try {
			ctrlDoctor.addResNOT_Turno(idDoc, idRes, tipoTurno);
		} catch (IOException e) {throw new IOException(e);}
		ctrlDoctor.saveDataRes(idHosp);
	}
	
	public void addResXOR(ArrayList<Integer> diaXOR, ArrayList<Integer> mesXOR,  ArrayList<Integer> yearXOR, ArrayList<String> tipoTurnoXOR) throws IOException {
		int idDoc = vistaDoctor.getDocId();
		int idRes = ctrlDoctor.getFDIRes(idDoc);
		int idHosp = ctrlHospital.getID();
		try {
			ctrlDoctor.addResXOR(idDoc, idRes, diaXOR, mesXOR, yearXOR, tipoTurnoXOR);
		} catch (IOException e) {throw new IOException(e);}
		ctrlDoctor.saveDataRes(idHosp);
	}
	/* Calendar methods */
	//--------------------------------------------------------------------------//
	public void createCalendar(int year) {
		ctrlHospital.addCalendar(year);
		ctrlCalendario = new CtrlCalendario(ctrlHospital.getCalendar());
	}
	public void importarCalendar(String path){
		try {
			ctrlCalendario.importarCalendario(path,ctrlHospital.getID());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
		}
		catch (IOException e) {throw e;}
//		catch (Exception e) {throw e;}
	}
	
	public int getCalendarYear() {
		return ctrlCalendario.getCalendarYear();
	}
	
	public ArrayList<String> getVacationDay(GregorianCalendar date) throws IOException {
		try {
			return ctrlCalendario.getVacationDay(date);
		}
		catch (IOException e) {throw e;}
	}
	
	public ArrayList<ArrayList<String>> getALLVacations() {
		return ctrlCalendario.getALLVacations();
	}
}
