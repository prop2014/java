package domain;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;
import data.CtrlDatosFichero;

import model.*;

public class CtrlHospital {
	/**Atributos */
	private Hospital hosp;
	private CtrlDatosFichero inOut;
	
	
	/* Constructora */
	public CtrlHospital(){
		inOut = new CtrlDatosFichero();
	}
	
	
	/* Metodos públicos */
	
	public ArrayList<Hospital> verHospitales() throws IOException {
		ArrayList<Hospital> hospitales = new ArrayList<>(); //hospitales = getHospitalesCtrlData()
		return hospitales;
	}
	/**
	 * 
	 * @param id identificador del Hospital
	 * @throws IOException Hospital no encontrado
	 */
	public void cargarHospital(int id) throws IOException {
		ArrayList<String> alhosp = new ArrayList<String>();
		alhosp=inOut.getHospital(id);
		if(alhosp.get(0)==null) throw new IOException("Id Hospital no encontrado"); 
		hosp = new Hospital(id,alhosp.get(1),Double.parseDouble(alhosp.get(2)),Double.parseDouble(alhosp.get(3)),Double.parseDouble(alhosp.get(4)));
		int i = 5;
		while(!alhosp.get(i).equals(".")){
			int idDoctor = Integer.parseInt(alhosp.get(i));
			++i;
			String nombre = alhosp.get(i);
			++i;
			int numMaxTurnos = Integer.parseInt(alhosp.get(i));
			++i;
			double SueldoTurno = Double.parseDouble(alhosp.get(i));
			Doctor d = new Doctor(idDoctor,nombre,numMaxTurnos,SueldoTurno);
			++i;
			if(alhosp.get(i).equals("0"))++i;
			else {
				++i; //em saltu la coma
				int idRestriccion =Integer.parseInt(alhosp.get(i));
				++i;
				String tipo = alhosp.get(i);
				if(tipo.equals("NOT_Turno")){
					++i;
					NOT_Turno N = new NOT_Turno(idRestriccion,alhosp.get(i));
					d.addRestriction(N);
				}
				else if(tipo.equals("NOT_Fecha")){
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
					++i;
				}
				else if(tipo.equals("NOT_Especial")){
					
				}
				else if(tipo.equals("NOT_Dia_Semana")){
					
				}
				else if(tipo.equals("NOT_Dia_Mes")){
					
				}
				else if(tipo.equals("MAX_Turnos_Rango")){
					
				}
				else if(tipo.equals("MAX_Turnos_por_Dia")){
					
				}
				else if(tipo.equals("XOR")){
				}
				
				
			}
			hosp.addDoctor(d);
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
	
	public ArrayList<Doctor> getDoctors(){
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
	
	public void guardarHospital(){
		ArrayList<String> alhosp = new ArrayList<String>();
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
			alhosp.add(i,".");
		}
		else{
			ArrayList<Doctor> aldocs=hosp.getDoctors();
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
					++i;
					alhosp.add(i,","); // te restriccions
					ArrayList<Restriccion> Res=aldocs.get(j).getRestrictions();
					for(int k=0;k<Res.size();++k){
						++i;
						alhosp.add(i,Integer.toString(Res.get(k).getIdRestriccion()));
						++i;
						alhosp.add(i,Res.get(k).getTipo());
						if(Res.get(k).getTipo().equals("NOT_Turno")){
							++i;
							NOT_Turno N = (NOT_Turno)Res.get(k);
							alhosp.add(i,N.getTipoTurno());
						}
						else if(Res.get(k).getTipo().equals("NOT_Fecha")){
							++i;
							NOT_Fecha N = (NOT_Fecha)Res.get(k);
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
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
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
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
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
							for(int l=0; l< listXOR.size();++l){
								++i;
								alhosp.add(i,sdf.format(listXOR.get(l).getDate().getTime()));
								++i;
								alhosp.add(i,listXOR.get(l).getShiftType());
							}
						}
					}
				}
			}
			++i;
			alhosp.add(i,".");
		}
		
		inOut.saveHosp(alhosp,hosp.getId());
	}
}
