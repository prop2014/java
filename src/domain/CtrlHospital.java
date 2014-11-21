package domain;

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
		String[] vHosp = new String[4];
		vHosp=inOut.getHospital(id);
		if(vHosp[0].equals("0")) throw new IOException("Id Hospital no encontrado"); 
		hosp = new Hospital(id,vHosp[0],Double.parseDouble(vHosp[1]),Double.parseDouble(vHosp[2]),Double.parseDouble(vHosp[3]));
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
}
