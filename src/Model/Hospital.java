/*Autor: Oscar */

package Model;
import java.util.*;

import Model.Doctor;
import Model.Restriccion;
import Model.Calendari;
import Model.Turno;

public class Hospital {
	
	/* Atributos */

	private int idHospital;
	private String nombre;
	private double factorM;
	private double factorT;
	private double factorN;
	private Map <Integer , Doctor> doctors;
	private Calendari calendari;



	
	private void Constructoras____(){}
	
	
	public Hospital() {}
	
	//creadora amb id, nombre y factores
	public Hospital (int id, String nom, double fm, double ft, double fn){
		idHospital=id;
		nombre=nom;
		factorM=fm;
		factorT=ft;
		factorN=fn;
		doctors = new TreeMap<Integer , Doctor>();
		calendari = new Calendari();
	}
	
	// creadora con id, nombre, factores,vector de doctores y calendario.//full
	public Hospital (int id, String nom, double fm, double ft, double fn,
			Doctor[] vdoc, Calendari cal){
		idHospital=id;
		nombre=nom;
		factorM=fm;
		factorT=ft;
		factorN=fn;
		doctors = new TreeMap<Integer , Doctor>();
		for(int i = 0; i < vdoc.length; ++i){
			if(doctors.containsKey(vdoc[i].getId())==false){
				doctors.put(vdoc[i].getId(), vdoc[i]);
			}
		}
		calendari = new Calendari(cal);
	}
	
// creadora con id, nombre, factores, arraylist de doctores y calendario. //full
		public Hospital (int id, String nom, double fm, double ft, double fn,
				ArrayList<Doctor> aldoc, Calendari cal){
			idHospital=id;
			nombre=nom;
			factorM=fm;
			factorT=ft;
			factorN=fn;
			doctors = new TreeMap<Integer , Doctor>();
			for(int i = 0; i < aldoc.size(); ++i){
				if(doctors.containsKey(aldoc.get(i).getId())==false){
					doctors.put(aldoc.get(i).getId(), aldoc.get(i));
				}
			}
			//calendari = new Calendari(cal);
		}
	
	
	private void gets__________(){};
	
	
	
	// consultora de la id
	public int getId(){
		return idHospital;
	}
	
	// consultora del Nombre
	public String getNombre(){
		return nombre;
	}
	
	// consultora del factorM
	public double getFactorM(){
		return factorM;
	}
	
	// consultora del factorT
	public double getFactorT(){
		return factorT;
	}
	
	// consultora del factorN
	public double getFactorN(){
		return factorN;
	}
	//consultora que devuelve un vector con los factores(M,T,N);
	public double[] getFactors(){
		double[] fac;  
		fac=new double[3];
		fac[0]=factorM;
		fac[1]=factorT;
		fac[2]=factorN;
		return fac;
	}
	
	//consulta tots els doctors
	public ArrayList<Doctor> getDoctors(){
		ArrayList<Doctor> aldoc = new ArrayList<Doctor>(doctors.size());
		Iterator<Integer> itr = doctors.keySet().iterator();
		while(itr.hasNext()) {
		    Integer key = itr.next();
		    aldoc.add(doctors.get(key));
		}
		return aldoc;
	}
	
		//indica si l'hospital conte algun doctor
	public boolean isDocEmpty(){
		return doctors.isEmpty();
	}
	
	 //consultora del numero de doctors
		public int Docsize(){
			return doctors.size();
		}
	
		//indica si existeix un doctor amb identificador = id;
	public boolean existsDoctor(int id){
		
		return doctors.containsKey(id);
	}
	
	
	public ArrayList<Turno> getTorns(){
		
		ArrayList<Turno> altorns = new ArrayList<Turno>();
		altorns = calendari.getTorns();
		return altorns;
	}
		
	
	//////private//////////MMMMMMOOOOODIIIFICADORASSSSSS/////////
	private void sets_____________(){};
	
		//modificadora del nombre   //
	public void setNombre(String nom){
		this.nombre=nom;
	}
	
		//modificadora del factorMañana
	public void setFactorM(double factor){
		this.factorM=factor;
	}
	
		//modificadora del factorTarde
	public void setFactorT(double factor){
		this.factorT=factor;
	}
	
		//modificadora del factorNoche
	public void setFactorN(double factor){
		this.factorN=factor;
	}
	
		//Modifica un doctor d
	public void setDoctor(Doctor d){
		if(doctors.containsKey(d.getId())==true){
			doctors.remove(d.getId());
			doctors.put(d.getId(), d);
		}	
	}
	
		//modifica el torn de la fecha data
	public void setTorn(Date data,Turno t){
		calendari.modificarTurno(data,t);
	}
	
	
	private void metodos__________(){};
	
	
	
		//afegeix un nou doctor d al hospital si no el contenia ja.
	public void afegirDoctor(Doctor d){
		if(doctors.containsKey(d.getId())==false){
			doctors.put(d.getId(), d);
		}
		
	}
		//afegeix un conjunt de  doctors al hospital,sobreescriu si ja existia doctor
	public void afegirDoctors(Doctor[] vdoc){
		for(int i = 0; i < vdoc.length; ++i){
			if(doctors.containsKey(vdoc[i].getId())==false){
				doctors.put(vdoc[i].getId(), vdoc[i]);
			}
			else {
				doctors.remove(vdoc[i].getId());
				doctors.put(vdoc[i].getId(), vdoc[i]);
			}
		}
	}
	
	//afegeix un arraylist de doctors al hospital, sobreescriu si ja existia doctor
	public void afegirDoctors(ArrayList<Doctor> aldoc){

		for(int i=0; i < aldoc.size();++i){
			if(doctors.containsKey(aldoc.get(i).getId())==false){
				doctors.put(aldoc.get(i).getId(), aldoc.get(i));
			}
			else {
				doctors.remove(aldoc.get(i).getId());
				doctors.put(aldoc.get(i).getId(), aldoc.get(i));
			}
		}
	}
	
		//borra el doctor d del hospital
	public void borrarDoctor(Doctor d){
		if(doctors.containsKey(d.getId())){
			doctors.remove(d.getId());
		}
	}
	
	// borra todos los doctores del hospital (alert!);
	public void cleardoctors(){
		doctors.clear();
	}
	
		//añade un turno t a la fecha data
	public void addTurno(Date data, Turno t){
		calendari.afegirTorn(data,t);
	}
	
}//ficlass