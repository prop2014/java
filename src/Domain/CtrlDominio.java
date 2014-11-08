package Domain;

import Model.*;

import java.util.*;
import java.io.IOException;

/* Comunicara con el Controlador de datos*/

public class CtrlDominio {
	/* Atributos */
	private Hospital hosp;
	
	
	/* Constructora */
	public CtrlDominio(){}
	
	
	/* Metodos públicos */
	
	public ArrayList<Hospital> verHospitales() throws IOException {
		ArrayList<Hospital> hospitales = new ArrayList<>(); //hospitales = getHospitalesCtrlData()
		return hospitales;
	}
	
	public void cargarHospital(int id) throws IOException {
		//hosp = getHospitalCtrlData(id);
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
	
	public Hospital getHospital() {
		return hosp;
	}
	
	
	public void crearDoctor(int id, String nombre, int numMax, double sueldo) throws IOException {
		if(numMax < 0) throw new IOException("Número máximo de turnos incorrecto");
		if(sueldo < 0) throw new IOException("Sueldo incorrecto");
		Doctor doc = new Doctor(id, nombre, numMax, sueldo);
		if(hosp.existsDoctor(id)) throw new IOException("Ya existe un doctor con este identificador");
		else hosp.afegirDoctor(doc);
		//createDoctorData()?
	}
	
	public void modificarDoctor(int id, String nombre, int numMax, double sueldo) throws IOException {
		if(numMax < 0) throw new IOException("Número máximo de turnos incorrecto");
		if(sueldo < 0) throw new IOException("Sueldo incorrecto");
		//try {
			Doctor doc = new Doctor();// = hosp.getDoctor(id);
		//}
		/*catch IOException(e) { // Que devuelva que no existe doctor con ID = id
			throw new IOException(e);
		} */
		doc.setNombre(nombre);
		doc.setNumMaxTurnos(numMax);
		doc.setSueldoTurno(sueldo);
		//updateDoctorData(id)?
	}
	
	public void eliminarDoctor(int id) throws IOException {
		//try {
		Doctor doc = new Doctor();// = hosp.getDoctor(id);
		//}
		/*catch IOException(e) { //Que devuelva que no existe doctor con ID = id
			throw new IOException(e);
		} */
		hosp.borrarDoctor(doc);
		//deleteDoctorData(id)?
	}
	
	public Doctor getDoctor(int id) throws IOException {
		//try {
			Doctor doc = new Doctor();// = hosp.getDoctor(id);
		//}
		/*catch IOException(e) { //Que devuelva que no existe doctor con ID = id
			throw new IOException(e);
		} */
		return doc;
	}
	
	public void asignarDoctores(ArrayList<Doctor> arrayDoc) {
		hosp.afegirDoctors(arrayDoc);
		//updateHospitalData()?
	}
	
	public void anadirRestriccion(Doctor doc, Restriccion res) {
		doc.addRestriccion(res);
		//updateDoctorData()?
	}
	
	public void eliminarRestriccion(Doctor doc, Restriccion res) {
		doc.eliminarRestriccion(res);
		//updateDoctorData()?
	}
	
	public ArrayList<Restriccion> getRestricciones(Doctor doc) {
		return doc.getRestriccions();
	}
	
	public void asignarCalendario(Calendario cal) {
		//updateHospitalData()?
	}
	
	
	
	
}
