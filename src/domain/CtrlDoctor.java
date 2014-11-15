package domain;
import java.io.IOException;
import java.util.*;

import model.*;


public class CtrlDoctor {
	/** Atributos */
	private ArrayList<Doctor> Doctors;
	
	/* Constructora */
	public CtrlDoctor(){}
	
	/* Metodos publicos */

/* ---------------DOCTORES -------------------*/
	
	//public Doctor getDoctor(int idDoc) throws IOException {		
	//}
	
	public void setDoctor(int idDoc) throws IOException {		
	}
	
	
	
/* --------------- RESTRICCIONES -------------------- */
	public void addResMAX_Turnos_Consecutivos(int idDoc) throws IOException {
		//updateDoctorData()?
	}
	
	public void addResMAX_Turnos_por_Dia(int idDoc, int idRes, int numT) throws IOException {
		if(numT < 0 || numT > 3) throw new IOException("Valor del numero de turnos incorrecto");
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				Restriccion res = new MAX_Turnos_por_Dia(idRes, numT);
				boolean c = Doctors.get(i).addRestriction(res);
				if (!c) throw new IOException("Ya existe una restriccion con esta Id");	
			}
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
	}
	
	public void addResMAX_Turnos_Rango(int idDoc) throws IOException {
		//updateDoctorData()?
	}
	
	public void addResNOT_Dia_Mes(int idDoc) throws IOException {
		//updateDoctorData()?
	}
	
	public void addResNOT_Dia_Semana(int idDoc) throws IOException {
		//updateDoctorData()?
	}
	
	public void addResNOT_Especial(int idDoc) throws IOException {
		//updateDoctorData()?
	}
	
	public void addResNOT_Fecha(int idDoc) throws IOException {
		//updateDoctorData()?
	}
	
	public void addResNOT_Turno(int idDoc) throws IOException {
		//updateDoctorData()?
	}
	
	public void addResXOR(int idDoc) throws IOException {
		//updateDoctorData()?
	}
	
	public void eliminarRestriccion(int idRes, int idDoc) throws IOException {
		//updateDoctorData()?
	}
}
