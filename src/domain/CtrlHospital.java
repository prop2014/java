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
	
	
	
	
	private static GregorianCalendar readDate(String s) throws ParseException {
		GregorianCalendar date =new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);
		try{
			date.setTime(sdf.parse(s));
		}catch(
			Exception e2){ 
   				e2.printStackTrace();
		}
		return date;
	}
	
	
	
	/* Constructora */
	public CtrlHospital(){
		hosp = new Hospital();
		inOut = new CtrlDatosFichero();
	}
	
	
	/* Metodos públicos */
	
	public ArrayList<Hospital> verHospitales() throws IOException {
		ArrayList<Hospital> hospitales = new ArrayList<>(); //hospitales = getHospitalesCtrlData()
		return hospitales;
	}
	
	/**
	 * @param id identificador del Hospital
	 * @throws IOException Hospital no encontrado
	 */
	public void cargarHospital(int id) throws IOException {
		ArrayList<String> alhosp = new ArrayList<String>();
		
		alhosp=inOut.getDataHospital(id);
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
		ArrayList<String> aldocs = inOut.getDataDoctors(id);
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
	
	
	/*
		int i = 5;
		
		if(!alhosp.get(i).equals("0")){
			int docs=Integer.parseInt(alhosp.get(i));
			for(int s1=0;s1<docs;++s1){
				++i;
				int idDoctor = Integer.parseInt(alhosp.get(i));
				++i;
				String nombre = alhosp.get(i);
				++i;
				int numMaxTurnos = Integer.parseInt(alhosp.get(i));
				++i;
				double SueldoTurno = Double.parseDouble(alhosp.get(i));
				Doctor d = new Doctor(idDoctor,nombre,numMaxTurnos,SueldoTurno);
				++i; // 0 o num
				if(!alhosp.get(i).equals("0")){
					int rest=Integer.parseInt(alhosp.get(i));//num de restriccions
					for(int i1=0;i1<rest;++i1){
						++i;
						int idRestriccion =Integer.parseInt(alhosp.get(i));
						++i;
						String tipo = alhosp.get(i);
						if(tipo.equals("NOT_Turno")){
							++i;
							NOT_Turno N = new NOT_Turno(idRestriccion,alhosp.get(i));
							d.addRestriction(N);
						}
						else if(tipo.equals("NOT_Fecha")){
							++i;
							String s = alhosp.get(i);
							GregorianCalendar gc = new GregorianCalendar();
							try{
							gc = readDate(s);
							}catch (Exception e2){ 
				   				e2.printStackTrace();
							}
							NOT_Fecha N = new NOT_Fecha(idRestriccion,gc);
							d.addRestriction(N);
						}
						else if(tipo.equals("NOT_Especial")){
							++i;
							NOT_Especial N = new NOT_Especial(idRestriccion,alhosp.get(i));
							d.addRestriction(N);
						}
						else if(tipo.equals("NOT_Dia_Semana")){
							++i;
							NOT_Dia_Semana N = new NOT_Dia_Semana(idRestriccion,alhosp.get(i));
							d.addRestriction(N);
						}
						else if(tipo.equals("NOT_Dia_Mes")){
							++i;
							NOT_Dia_Mes N = new NOT_Dia_Mes(idRestriccion,Integer.parseInt(alhosp.get(i)));
							d.addRestriction(N);
						}
						else if(tipo.equals("MAX_Turnos_Rango")){
							++i;
							String si = alhosp.get(i);
							++i;
							String sf = alhosp.get(i);
							GregorianCalendar gci = new GregorianCalendar();
							GregorianCalendar gcf= new GregorianCalendar();
							try{
							gci = readDate(si);
							gcf = readDate(sf);
							}catch (Exception e2){ 
				   				e2.printStackTrace();
							}
							++i;
							int mt = Integer.parseInt(alhosp.get(i));
							MAX_Turnos_Rango N = new MAX_Turnos_Rango(idRestriccion,gci,gcf,mt);
							d.addRestriction(N);					
						}
						else if(tipo.equals("MAX_Turnos_por_Dia")){
							++i;
							MAX_Turnos_por_Dia N = new MAX_Turnos_por_Dia(idRestriccion,Integer.parseInt(alhosp.get(i)));
							d.addRestriction(N);
						}
						else if(tipo.equals("XOR")){
							++i;
							int size=Integer.parseInt(alhosp.get(i));
							ArrayList<Turno> listXOR = new ArrayList<Turno>();
							for(int l=0; l<size;++l){
								++i;
								String s = alhosp.get(i);
								++i;
								String t=alhosp.get(i);
								GregorianCalendar gc = new GregorianCalendar();
								try{
									gc = readDate(s);
									}catch (Exception e2){ 
						   				e2.printStackTrace();
									}
								Turno turn= new Turno(gc,t);
								listXOR.add(turn);
							}
							XOR N = new XOR(idRestriccion,listXOR);
							d.addRestriction(N);
						}
					}
				}
				hosp.addDoctor(d);
				System.out.print("BIIIEN\n");
			}
			++i;
			if(alhosp.get(i).equals("0")) System.out.print("fi doctores\n");
		}
		Calendario cale =hosp.getCalendario();
		++i;
		int calesize = Integer.parseInt(alhosp.get(i));
		for(int n=0;n<calesize;++n){
			++i;
			String s = alhosp.get(i); //  fecha
			++i;
			String shiftType=alhosp.get(i); // tipoturno
			GregorianCalendar gc = new GregorianCalendar();
			try{
				gc = readDate(s);
			}catch (Exception e2){ 
	   			e2.printStackTrace();
			}
			++i;
			String specialDate =alhosp.get(i); //fecha especial
			++i;
			int numberOfDoctors= Integer.parseInt(alhosp.get(i));
			cale.addVacationDay(gc); //dia puesto
			Turno turn = cale.getShift(gc, shiftType);
			turn.setSpecialDate(specialDate);
			turn.setNumberOfDoctors(numberOfDoctors);			
		}
		//inportar cale
	}
	*/
	
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
	
	public void eliminarHospital(int id) throws IOException{
		//deleteHospitalData(id);
	}
	
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
		ArrayList<Doctor> aldoctor = hosp.getDoctors();
		return aldoctor;
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
	 * @return Devuelve el Hospital
	 */
	public Hospital getHospital(){
		return hosp;
	}
	
	public void eliminarDoctor(int id) throws IOException {
		//try {
		
		Doctor doc = new Doctor();// = hosp.getDoctor(id);
		//}
		/*catch IOException(e) { //Que devuelva que no existe doctor con ID = id
			throw new IOException(e);
		} */
		hosp.deleteDoctor(id);
		//deleteDoctorData(id)?
	}
	
	public void asignarCalendario(Calendario cal) {
		//updateHospitalData()?
	}
	public void saveDataHosp()throws IOException{
		ArrayList<String> alhosp = new ArrayList<String>();
			alhosp.add(".H");
			alhosp.add(Integer.toString(hosp.getId()));
			alhosp.add(hosp.getNombre());
			alhosp.add(Double.toString(hosp.getFactorM()));
			alhosp.add(Double.toString(hosp.getFactorT()));
			alhosp.add(Double.toString(hosp.getFactorN()));
		inOut.saveDataHosp(alhosp, hosp.getId());
	}
	public void saveDataDoctors()throws IOException{
		ArrayList<String> alhosp = new ArrayList<String>();
		alhosp.add(".D");
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
	   		alcal.add(Integer.toString(calendar.getCalendarYear()));
	   		alcal.add(Integer.toString(calendar.getNumberOfVacationDates()));
	   		ArrayList<GregorianCalendar> cal =calendar.getALLVacationDates();
	   		ArrayList<Turno> turns =new ArrayList<Turno>();
	   		for(int i=0;i<cal.size();++i){
	   			turns=calendar.getShiftsOfADay(cal.get(i));
	   			int dia=0,mes=0,year=0,numDrsManana=0,numDrsTarde=0,numDrsNoche=0;
	   			String especialm = null,especialt=null,especialn=null;
	   			for(int j=0;j<turns.size();++j){
	   				Turno t=turns.get(j);
	   				dia=t.getDate().DAY_OF_MONTH;
	   				mes=t.getDate().MONTH;
	   				year=t.getDate().YEAR;
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
		inOut.saveDataCale(alcal, id);
    }
	public void guardarHospital()throws IOException{
		ArrayList<String> alhosp = new ArrayList<String>();
		saveDataHosp();
		if(!hosp.isDocEmpty()) saveDataDoctors();
		if(!hosp.isCaleEmpty()) saveDataCale(hosp.getId());
	}/*
		int i =0;
		alhosp.add(i,Integer.toString(hosp.getId()));
		++i;
		alhosp.add(i,hosp.getNombre());
		++i;
		alhosp.add(i,Double.toString(hosp.getFactorM()));
		++i;
		alhosp.add(i,Double.toString(hosp.getFactorT()));
		++i;
		alhosp.add(i,Double.toString(hosp.getFactorN()));
		if(hosp.isDocEmpty()){//no hi han doctors
			++i;
			alhosp.add(i,"0");
		}
		else{
			ArrayList<Doctor> aldocs=hosp.getDoctors();
			String sizeD = Integer.toString(aldocs.size());
			++i;
			alhosp.add(i,sizeD); // he afegit num docs
			for(int j=0;j<aldocs.size();++j){
				++i;
				alhosp.add(i,Integer.toString(aldocs.get(j).getId()));
				++i;
				alhosp.add(i,aldocs.get(j).getName());
				++i;
				alhosp.add(i,Integer.toString(aldocs.get(j).getNumMaxTurn()));
				++i;
				alhosp.add(i,Double.toString(aldocs.get(j).getSalaryTurn()));
				if(aldocs.get(j).isREmpty()){
					++i;
					alhosp.add(i,"0"); //noteRestriccions
				}
				else{
					++i;// te restriccions
					ArrayList<Restriccion> Res=aldocs.get(j).getRestrictions();
					System.out.printf("te %d Restriccions",Res.size());
					alhosp.add(i,Integer.toString(Res.size()));// posu cuantes te
					for(int k=0;k<Res.size();++k){
						++i;
						alhosp.add(i,Integer.toString(Res.get(k).getIdRestriccion()));
						++i;
						alhosp.add(i,Res.get(k).getTipo()); // ok vamos a ver kual es
						if(Res.get(k).getTipo().equals("NOT_Turno")){
							++i;
							NOT_Turno N = (NOT_Turno)Res.get(k);
							alhosp.add(i,N.getTipoTurno());
						}
						else if(Res.get(k).getTipo().equals("NOT_Fecha")){
							++i;
							NOT_Fecha N = (NOT_Fecha)Res.get(k);
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							alhosp.add(i,sdf.format(N.getFecha().getTime()));
						}
						else if(Res.get(k).getTipo().equals("NOT_Especial")){
							++i;
							NOT_Especial N = (NOT_Especial)Res.get(k);
							alhosp.add(i,N.getEspecial());
						}
						else if(Res.get(k).getTipo().equals("NOT_Dia_Semana")){
							++i;
							NOT_Dia_Semana N = (NOT_Dia_Semana)Res.get(k);
							alhosp.add(i,N.getDiaSemana());
						}
						else if(Res.get(k).getTipo().equals("NOT_Dia_Mes")){
							++i;
							NOT_Dia_Mes N = (NOT_Dia_Mes)Res.get(k);
							alhosp.add(i,Integer.toString(N.getDiaMes()));
						}
						else if(Res.get(k).getTipo().equals("MAX_Turnos_Rango")){
							++i;
							MAX_Turnos_Rango N = (MAX_Turnos_Rango)Res.get(k);
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							alhosp.add(i,sdf.format(N.getFechaIni().getTime()));
							++i;
							alhosp.add(i,sdf.format(N.getFechaFin().getTime()));
							++i;
							alhosp.add(i,Integer.toString(N.getNumDias()));
						}
						else if(Res.get(k).getTipo().equals("MAX_Turnos_por_Dia")){
							++i;
							MAX_Turnos_por_Dia N = (MAX_Turnos_por_Dia)Res.get(k);
							alhosp.add(i,Integer.toString(N.getNumTurnos()));
						}
						else if(Res.get(k).getTipo().equals("XOR")){
							XOR N = (XOR)Res.get(k);
							ArrayList<Turno> listXOR = N.getListTurnos();
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							++i;
							alhosp.add(i,Integer.toString(listXOR.size()));
							for(int l=0; l< listXOR.size();++l){
								++i;
								alhosp.add(i,sdf.format(listXOR.get(l).getDate().getTime()));
								++i;
								alhosp.add(i,listXOR.get(l).getShiftType());
							}
						}
						//fi restriccion
					}//fi restricciones
				}
			}
			++i;//ok
			alhosp.add(i,"0");
		}
		Calendario cale = hosp.getCalendario();
		ArrayList<Turno> alturns=cale.getALLShifts();
		int calesize = alturns.size();
		++i;
		alhosp.add(i,Integer.toString(calesize));
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		for(int y=0;y<alturns.size();++y){
			++i;
			alhosp.add(i,sdf.format(alturns.get(y).getDate().getTime()));
			++i;
			alhosp.add(i,alturns.get(y).getShiftType());
			++i;
			alhosp.add(i,alturns.get(y).getSpecialDate());
			++i;
			alhosp.add(i,Integer.toString(alturns.get(y).getNumberOfDoctors()));
		}
		++i;
		alhosp.add(i,"0");
		inOut.saveHosp(alhosp,hosp.getId());
		*/
	
	
	
	
	
}//FICLAS
