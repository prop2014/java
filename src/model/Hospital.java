/*Autor: Oscar */

package model;
import java.util.*;

import model.Calendario;
import model.Doctor;


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
		
		  /** 
		   * Elimina todos los datos de un hospital
		   * 
		   */
		public void deleteHospital(){
			idHospital=0;
			nombre=null;
			factorM=0.0;
			factorT=0.0;
			factorN=0.0;
			doctors = new TreeMap<Integer , Doctor>();
			calendari = new Calendario();
			
		}
	
	
	private void gets_de_hospital__________(){}
	
	/**
	 *  Consultora de la id del Hospital
	 *  @return la id del Hospital
	 */
	public int getId(){
		return idHospital;
	}
	
	/** 
	 * Consultora del Nombre del Hospital
	 * @return el Nombre del Hospital
	 */
	public String getNombre(){
		return nombre;
	}
	
	/** 
	 * Consultora del factor mañana
	 * @return el factor mañana
	 */
	public double getFactorM(){
		return factorM;
	}
	
	/** 
	 * Consultora del factor tarde
	 * @return el factor tarde
	 */
	public double getFactorT(){
		return factorT;
	}
	
	/** 
	 * Consultora del factor noche
	 * @return el factor noche
	 */
	public double getFactorN(){
		return factorN;
	}
	
	/** 
	 * Consultora de los factores del Hospital
	 * @return el vector double con los tres factores(M,T,N).
	 */
	public double[] getFactors(){
		double[] fac;  
		fac=new double[3];
		fac[0]=factorM;
		fac[1]=factorT;
		fac[2]=factorN;
		return fac;
	}
	
	private void gets_de_doctor__________(){};
	
	/** 
	 * Consultora de un Doctor del Hospital con su Id.
	 * pre: el Hospital contiene ese doctor.
	 * @param id 	es la id del doctor
	 * @return el doctor con identificador = id.
	 */
	public Doctor getDoctor(int id){
		return doctors.get(id);
	}
	
	/** 
	 * Consultora de todos los doctores del Hospital
	 * @return el Arraylist<Doctor> con todos los doctores del Hospital
	 */
	public ArrayList<Doctor> getDoctors(){
		ArrayList<Doctor> aldoc = new ArrayList<Doctor>(doctors.size());
		Iterator<Integer> itr = doctors.keySet().iterator();
		while(itr.hasNext()) {
		    Integer key = itr.next();
		    aldoc.add(doctors.get(key));
		}
		return aldoc;
	}
	
	/** 
	 * Indica si hay algun Doctor en el Hospital
	 * @return un boolean que indica si esta vacio.
	 */
	public boolean isDocEmpty(){
		return doctors.isEmpty();
	}
	
	/** 
	 * Consultora del numero de Doctores del Hospital
	 * @return el numero de Doctores del Hospital
	 */
	public int Docsize(){
		return doctors.size();
	}
	
	/** 
	 * Consultora de la existencia de un doctor con identificador = id
	 * @param id	es el identificador del doctor.
	 * @return un boolean que indica si existe ese doctor
	 */
	public boolean existsDoctor(int id){
		return doctors.containsKey(id);
	}
	
	private void gets_de_Calendari__________(){};
	
	/** 
	 * Consultora de la existencia de un dia vacacional = d
	 * @param d		es la fecha del dia Vacacional
	 * @return un boolean que indica si el dia Vacacional existe.
	 */
    public boolean existsDiaVacacional(GregorianCalendar d){
    	return calendari.existsDiaVacacional(d);
    }
    
    /** 
	 * Consultora del numero de dias contenidos en el Calendario del Hospital
	 * @return el numero de dias Vacacionales
	 */
    public int getNumDias(){
		return calendari.getNumDias();
	}
    
    /** 
	 * Consultora del numero de turnos contenidos en el Calendario del Hospital
	 * @return el numero de turnos Vacacionales del Hospital
	 */
	public int getNumTurnos(){
		return calendari.getNumTurnos();
	
	}
	
	/** 
	 * Consultora de todos los turnos del Hospital
	 * @return un ArrayList<Vector<Turno>> con todos los Turnos del Hospital
	 */
	public ArrayList<Vector<Turno>> getTurnos(){
		return calendari.getTurnos();
	}

	private void sets_de_hospital_____________(){};
	
	/** 
	 * Modificadora del Nombre del Hospital
	 * @param nom	es el nuevo Nombre del Hospital
	 */
	public void setNombre(String nom){
		this.nombre=nom;
	}
	
		//modificadora del factorMañana
	/** 
	 * Modificadora del factor Mañana del Hospital
	 * @param factor	es el nuevo factorMañana del Hospital
	 */
	public void setFactorM(double factor){
		this.factorM=factor;
	}
	
	/** 
	 * Modificadora del factor Tarde del Hospital
	 * @param factor	es el nuevo factorTarde del Hospital
	 */
	public void setFactorT(double factor){
		this.factorT=factor;
	}
	
	/** 
	 * Modificadora del factor Noche del Hospital
	 * @param factor	es el nuevo factorNoche del Hospital
	 */
	public void setFactorN(double factor){
		this.factorN=factor;
	}
	
	private void set_de_doctor_____________(){};
	
	/** 
	 * Modificadora de un Doctor del Hospital
	 * 	Esta funcion sobreescirbe el doctor existente.
	 * @param d		es el doctor ya modificado
	 */
	public void setDoctor(Doctor d){
		if(doctors.containsKey(d.getId())==true){
			doctors.remove(d.getId());
			doctors.put(d.getId(), d);
		}	
	}
	
	private void set_de_Calendario_____________(){};
	
	/** 
	 * Modificadora de un Turno del Hospital
	 * @param d		es la fecha del Turno
	 * @param tt 	es el tipoturno("m","t","n")
	 * faltara el Turno t modificado
	 */
	public void replaceTurno(GregorianCalendar d, String tt){
		calendari.replaceTurno(d,tt);
	}
	
	private void metodos_de_doctor_________(){};
	
	
	/** 
	 * Metodo que inserta un doctor nuevo en el Hospital
	 * 	pre - El Hospital no contiene el Doctor d. 
	 * @param d		es el nuevo doctor del Hospital
	 */
	public void addDoctor(Doctor d){
		if(doctors.containsKey(d.getId())==false){
			doctors.put(d.getId(), d);
		}
		
	}
	
	/** 
	 * Metodo que inserta un vector de doctores en el Hospital
	 * 	post- se ha insertado el vector de doctores en el Hospital
	 * 		  Si algun doctor ia existia se ha remplazado por el nuevo.
	 * @param vdoc		es un vector de Doctores
	 */
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
	
	/** 
	 * Metodo que inserta un ArrayList de doctores en el Hospital
	 * 	post- se ha insertado el ArayList de doctores en el Hospital
	 * 		  Si algun doctor ia existia se ha remplazado por el nuevo.
	 * @param aldoc		es un ArrayList de Doctores
	 */
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