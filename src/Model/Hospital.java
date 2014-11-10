/*Autor: Oscar */

package Model;
import java.util.*;

import Model.Doctor;
import Model.Calendario;


public class Hospital {
	
	/* Atributos */

	private int idHospital;
	private String nombre;
	private double factorM;
	private double factorT;
	private double factorN;
	private Map <Integer , Doctor> doctors;
	private Calendario calendari;



	
	private void Constructoras____(){}
	
	
	public Hospital() {
		idHospital=0;
		nombre=null;
		factorM=0.0;
		factorT=0.0;
		factorN=0.0;
		doctors = new TreeMap<Integer , Doctor>();
		calendari = new Calendario();
	}
	
	//creadora amb id, nombre y factores
	public Hospital (int id, String nom, double fm, double ft, double fn){
		idHospital=id;
		nombre=nom;
		factorM=fm;
		factorT=ft;
		factorN=fn;
		doctors = new TreeMap<Integer , Doctor>();
		calendari = new Calendario();
	}
	
	// creadora con id, nombre, factores,vector de doctores y calendario.//full
	public Hospital (int id, String nom, double fm, double ft, double fn,
			Doctor[] vdoc, Calendario cal){
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
		//calendari = new Calendario(cal);
	}
	
// creadora con id, nombre, factores, arraylist de doctores y calendario. //full
		public Hospital (int id, String nom, double fm, double ft, double fn,
				ArrayList<Doctor> aldoc, Calendario cal){
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
			//calendari = new Calendario(cal);
		}
		
		//Elimina todos los datos de un hospital
		public void borraHosp(){
			idHospital=0;
			nombre=null;
			factorM=0.0;
			factorT=0.0;
			factorN=0.0;
			doctors = new TreeMap<Integer , Doctor>();
			calendari = new Calendario();
			
		}
	
	
	private void gets_de_hospital__________(){}
	
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
	
	private void gets_de_doctor__________(){};
	
	//pre existe un doctor con identificador = id;
	//devuelve el doctor con identificador = id.
	public Doctor getDoctor(int id){
		return doctors.get(id);
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
	
	

	private void gets_de_Calendari__________(){};
	
    public boolean existsDiaVacacional(GregorianCalendar d){
    	return calendari.existsDiaVacacional(d);
    }
    
    public int getNumDias(){
		return calendari.getNumDias();
	}

	public int getNumTurnos(){
		return calendari.getNumTurnos();
	
	}
	//devuelve un arraylist de vectores de turnos cada uno un dia
	public ArrayList<Vector<Turno>> getTurnos(){
		return calendari.getTurnos();
	}

	private void sets_de_hospital_____________(){};
	
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
	
	private void set_de_doctor_____________(){};
	
		//Sobreescrive un doctor presente en el hospital
	public void setDoctor(Doctor d){
		if(doctors.containsKey(d.getId())==true){
			doctors.remove(d.getId());
			doctors.put(d.getId(), d);
		}	
	}
	
	private void set_de_Calendario_____________(){};
	
		//modifica el turno tt de la fecha d
	public void setTurno(GregorianCalendar d, String tt){
		calendari.setTurno(d,tt);
	}
	
	private void metodos_de_doctor_________(){};
	
	
		//afegeix un nou doctor d al hospital si no el contenia ja.
	public void afegirDoctor(Doctor d){
		if(doctors.containsKey(d.getId())==false){
			doctors.put(d.getId(), d);
		}
		
	}
		//afegeix un conjunt de  doctors al hospital,SOBREESCRIU si ja existia doctor
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
	
	//afegeix un arraylist de doctors al hospital,  si ja existia doctor
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
	
		//borra el doctor amb identificador id del hospital
	public void borrarDoctor(int id){
		if(doctors.containsKey(id)){
			doctors.remove(id);
		}
	}
	
	// borra todos los doctores del hospital (alert!);
	public void cleardoctors(){
		doctors.clear();
	}
	
	
	private void metodos_de_calendari________(){};
	
		//Añade un nuevo día vacacional al calendario (si éste no existe),
	 //* y sus 3 turnos de guardias correspondientes.
	public void addDiaVacacional(GregorianCalendar d){
		calendari.addDiaVacacional(d);
	}
	
	//Elimina un día vacacional del calendario (si éste ya existe),
	 //* y sus 3 turnos de guardias correspondientes.
	public void deleteDiaVacacional(GregorianCalendar d){
		calendari.deleteDiaVacacional(d);
	}
	
	
}//ficlass