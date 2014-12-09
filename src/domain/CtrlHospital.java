package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;
import data.CtrlDatosFichero;

import model.*;
/**Controladora del Hospital
 * 
 * @author oscar
 *
 */
public class CtrlHospital {
	/**Atributos */
	private Hospital hosp;
	private CtrlDatosFichero inOut;
	
	/* Constructora */
	public CtrlHospital(){
		hosp = new Hospital();
		inOut = new CtrlDatosFichero();
	}
	
	
	/* Metodos públicos */
	
	public ArrayList<String> verHospitales() throws IOException {
		return inOut.getHopitals();
	}
	
	public void importarHospital(String path)throws IOException{
		ArrayList<String> alhosp = new ArrayList<String>();
		if(path!=null){
			int id=inOut.getId(path);
			alhosp=inOut.getDataHospital(id,path);
			inOut.saveDataHosp(alhosp, id); //comprovarids
		}
	}
	
	public ArrayList<ArrayList<String>> verDoctores() throws IOException {
		return hosp.verDoctores();
	}
	
	
	public ArrayList<String> getInfoHospital(int id) throws IOException {
		return inOut.getInfoHospital(id);
	}
	/**
	 * obtiene los datos basicos del Hospital(no doctores ni calendario)
	 * @param id identificador del Hospital
	 * @throws IOException Hospital no encontrado
	 */
	public void cargarHospital(int id) throws IOException {
		ArrayList<String> alhosp = new ArrayList<String>();
		
		alhosp=inOut.getDataHospital(id,null);
		if(alhosp.size()==0) throw new IOException("El fichero no contenia datos correctos");
		else{
			int iden=Integer.parseInt(alhosp.get(0));
			if(iden<0) throw new IOException("Valor de id incorrecto");
			String name = alhosp.get(1);
			double fm = Double.parseDouble(alhosp.get(2));
			double ft= Double.parseDouble(alhosp.get(3));
			double fn= Double.parseDouble(alhosp.get(4));
			if(fm < 0.0 || ft < 0.0 || fn < 0.0) throw new IOException("Valor de factor incorrecto");
			hosp = new Hospital(iden,name,fm,ft,fn);
		}
	}
	
	public void addCalendar(int year){
		hosp.setCalendarYear(year);
	}
	/**
	 * obte de fitxer els doctors i els posa al hospital
	 * @param id identificador del hospital
	 * @throws IOException valores incorrectos, fichero no encontrado
	 */
	public void getDataDoctors(int id)throws IOException{
		ArrayList<String> aldocs = inOut.getDataDoctors(id,null);
		if(!aldocs.isEmpty()){
			int docs=Integer.parseInt(aldocs.get(0));
				int j =0;
			for(int s1=0;s1<docs;++s1){
				++j;
				int idDoctor = Integer.parseInt(aldocs.get(j));
				++j;
				String nombre = aldocs.get(j);
				++j;
				int numMaxTurnos = Integer.parseInt(aldocs.get(j));
				++j;
				double SueldoTurno = Double.parseDouble(aldocs.get(j));
				crearDoctor(idDoctor,nombre,numMaxTurnos,SueldoTurno);
			}
		}
	}
	
	
	public void crearHospital(int id, String nombre, double fm, double ft, double fn) throws IOException {
		if(fm < 0.0 || ft < 0.0 || fn < 0.0) throw new IOException("Valor de factor incorrecto");
		hosp = new Hospital(id,nombre,fm,ft,fn);
		//saveHospitalCtrlData(hosp);
	}
	
	
	public void modificarHospital(String nombre, double fm, double ft, double fn) throws IOException {
		if(fm < 0.0 || ft < 0.0 || fn < 0.0) throw new IOException("Valor de factor incorrecto");
		hosp.setFactorM(fm);
		hosp.setFactorT(ft);
		hosp.setFactorN(fn);
		hosp.setNombre(nombre);
		//updateHospitalData()?
	}
	
	
	/*DOCTORES*/
	public void crearDoctor(int id, String nombre, int numMax, double sueldo) throws IOException {
		if(numMax < 0) throw new IOException("Número máximo de turnos incorrecto");
		if(sueldo < 0) throw new IOException("Sueldo incorrecto");
		Doctor doc = new Doctor(id, nombre, numMax, sueldo);
		if(hosp.existsDoctor(id)) throw new IOException("Ya existe un doctor con este identificador");
		else hosp.addDoctor(doc);
		//createDoctorData()?
	}
	
	/**
	 * @return devuelve un arraylist con los doctores del hospital
	 */
	
	public ArrayList<Doctor> getDoctors()  throws IOException{
		return hosp.getDoctors();
	}
	
	/**
	 * 
	 * @return Devuelve el calendario
	 */
	public Calendario getCalendar(){
		return hosp.getCalendario();
	}
	
	
	/**
	 * 
	 * @return return el primer id disponible
	 * @throws IOE
	 */
	public Integer getFDI(){
		ArrayList<Integer> ids = inOut.getIdHopitals();
		for(int i=0; i< ids.size();++i){
			if(i!=ids.get(i)){
				return i;
			}
		}
		return ids.size();
	}
	
	
	/**
	 * 
	 * @return Devuelve el Hospital
	 */
	public Hospital getHospital(){
		return hosp;
	}
	
	public String getNameHospital(){
		return hosp.getNombre();
	}
	
	public void eliminarDoctor(int id) throws IOException {
		
		if(!hosp.existsDoctor(id)){
			throw new IOException("No existe este doctor en el Hospital");
		}
		hosp.deleteDoctor(id);
		
	}
	
	//public void asignarCalendario(Calendario cal) {
		//updateHospitalData()?
//	}
	public void saveDataHosp()throws IOException{
		ArrayList<String> alhosp = new ArrayList<String>();
			alhosp.add(Integer.toString(hosp.getId()));
			alhosp.add(hosp.getNombre());
			alhosp.add(Double.toString(hosp.getFactorM()));
			alhosp.add(Double.toString(hosp.getFactorT()));
			alhosp.add(Double.toString(hosp.getFactorN()));
		inOut.saveDataHosp(alhosp, hosp.getId());
	}
	
	
	public void saveDataDoctors()throws IOException{
		ArrayList<String> alhosp = new ArrayList<String>();
		alhosp.add(Integer.toString(hosp.docSize()));
		ArrayList<Doctor>aldoc = hosp.getDoctors();
		for(int i=0; i<hosp.docSize();++i){
			alhosp.add(Integer.toString(aldoc.get(i).getId()));
			alhosp.add(aldoc.get(i).getName());
			alhosp.add(Integer.toString(aldoc.get(i).getNumMaxTurn()));
			alhosp.add(Double.toString(aldoc.get(i).getSalaryTurn()));
		}
		inOut.saveDataDoctors(alhosp,hosp.getId());
	}	
	
	public void saveDataCale(int id) throws IOException{
		ArrayList<String> alcal = new ArrayList<String>();
		if(!hosp.isCaleEmpty()){	
			Calendario calendar =hosp.getCalendario();
			if(calendar.getNumberOfVacationDates()>0){	
				alcal.add(Integer.toString(calendar.getCalendarYear()));
				alcal.add(Integer.toString(calendar.getNumberOfVacationDates()));
				ArrayList<GregorianCalendar> cal = calendar.getALLVacationDates();
				ArrayList<Turno> turns =new ArrayList<Turno>();
				for(int i=0;i<cal.size();++i){
					turns=calendar.getShiftsOfADay(cal.get(i));
					int dia=0,mes=0,year=0,numDrsManana=0,numDrsTarde=0,numDrsNoche=0;
					String especialm = null,especialt=null,especialn=null;
					for(int j=0;j<turns.size();++j){
						Turno t=turns.get(j);
						dia=t.getDate().get(GregorianCalendar.DAY_OF_MONTH);
						System.out.printf("Dia: %d\n",dia);
						mes=t.getDate().get(GregorianCalendar.MONTH);
						System.out.printf("MeS: %d\n",mes);
						year=t.getDate().get(GregorianCalendar.YEAR);
						System.out.printf("Year: %d\n",year);
						if(t.getShiftType().equals("manana")){
							numDrsManana=t.getNumberOfDoctors();
							especialm=t.getSpecialDate();
						}
						else if(t.getShiftType().equals("tarde")){
							numDrsTarde=t.getNumberOfDoctors();
							especialt=t.getSpecialDate();
						}
						else if(t.getShiftType().equals("noche")){
							numDrsNoche=t.getNumberOfDoctors();
							especialn=t.getSpecialDate();
						}
					}
					alcal.add(Integer.toString(dia));
					alcal.add(Integer.toString(mes));
					alcal.add(Integer.toString(year));
					alcal.add(Integer.toString(numDrsManana));
					alcal.add(Integer.toString(numDrsTarde));
					alcal.add(Integer.toString(numDrsNoche));
					alcal.add(especialm);
					alcal.add(especialt);
					alcal.add(especialn);
				}
			}
	   		
		}
		inOut.saveDataCale(alcal, id);
    }
	public void guardarHospital()throws IOException{
		saveDataHosp();
		if(!hosp.isDocEmpty()) saveDataDoctors();
		if(!hosp.isCaleEmpty()) saveDataCale(hosp.getId());
	}
	
	public void deleteHospital(int id) throws IOException {
		inOut.removePart(id, ".H");
	}
	
	
}//FICLAS

