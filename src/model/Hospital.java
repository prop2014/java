package model;
import java.util.*;

import model.Calendario;
import model.Doctor;

/**
* Representa un Hospital
* @author oscar.urgelles
*/
public class Hospital {
	
	private int idHospital;
	private String name;
	private double factorM;
	private double factorT;
	private double factorN;
	private Map <Integer , Doctor> doctors;
	private Calendario calendari;
	
	
	/**
	 * Creadora Por defecto
	 */
	public Hospital() {
		idHospital=0;
		name=null;
		factorM=0.0;
		factorT=0.0;
		factorN=0.0;
		doctors = new TreeMap<Integer , Doctor>();
		calendari = new Calendario();
	}
	
	/**
	 *Creadora de Hospital con algunos de los parametros de la clase
	 * @param id 	Un identificador unico de hospital
	 * @param nom	Nombre del Hospital
	 * @param fm 	FactorMorning Se multiplicara al sueldoxTurno del doctor Para calcular el coste
	 * @param ft	FactorTarde Se multiplicara al sueldoxTurno del doctor Para calcular el coste
	 * @param fn	Factorevening Se multiplicara al sueldoxTurno del doctor Para calcular el coste
	 
	 */
	public Hospital (int id, String nom, double fm, double ft, double fn){
		idHospital=id;
		name=nom;
		factorM=fm;
		factorT=ft;
		factorN=fn;
		doctors = new TreeMap<Integer , Doctor>();
		calendari = new Calendario();
	}
	
	/**
	 *  Creadora de Hospital con todos los parametros de la clase
	 * @param id 	Un identificador unico de hospital
	 * @param nom	Nombre del Hospital
	 * @param fm 	FactorMorning Se multiplicara al sueldoxTurno del doctor Para calcular el coste
	 * @param ft	FactorTarde Se multiplicara al sueldoxTurno del doctor Para calcular el coste
	 * @param fn	Factorevening Se multiplicara al sueldoxTurno del doctor Para calcular el coste
	 * @param aldoc	ArrayList de Doctores con los que se inicializara el Hospital
	 * @param cal	Representa el Calendario de turnos de guardia
	 */
	public Hospital (int id, String nom, double fm, double ft, double fn,
		ArrayList<Doctor> aldoc, Calendario cal){
		idHospital=id;
		name=nom;
		factorM=fm;
		factorT=ft;
		factorN=fn;
		doctors = new TreeMap<Integer , Doctor>();
		for(int i = 0; i < aldoc.size(); ++i){
			if(doctors.containsKey(aldoc.get(i).getId())==false){
				doctors.put(aldoc.get(i).getId(), aldoc.get(i));
			}
		}
		calendari = new Calendario(cal);
	}
			
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
		return name;
	}
	
	/** 
	 * Consultora del factor manana
	 * @return el factor manana
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
	 * Devuelve el calendario
	 */
	
	public Calendario getCalendario(){
		
		return calendari;
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
	public int docSize(){
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
	
	/** 
	 * Modificadora del Nombre del Hospital
	 * @param nom	es el nuevo Nombre del Hospital
	 */
	public void setNombre(String nom){
		this.name=nom;
	}
	
		//modificadora del factorManana
	/** 
	 * Modificadora del factor Manana del Hospital
	 * @param factor	es el nuevo factorManana del Hospital
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
	public void addDoctors(Doctor[] vdoc){
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
	public void addDoctors(ArrayList<Doctor> aldoc){

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
	
	/** 
	 * Metodo que elimina un doctor del Hospital
	 * 
	 * @param id 	es el identificador del doctor a borrar
	 */
	public void deleteDoctor(int id){
		if(doctors.containsKey(id)){
			doctors.remove(id);
		}
	}
	
	/** 
	 * Metodo que elimina todos los doctores del Hospital
	 */
	public void cleardoctors(){
		doctors.clear();
	}
	
	
	/** 
	 * Metodo que reseta todos los datos del Hospital
	 */
	public void resetHosp(){
		idHospital=0;
		name=null;
		factorM=0.0;
		factorT=0.0;
		factorN=0.0;
		doctors = new TreeMap<Integer , Doctor>();
		calendari = new Calendario(0);
	}
	
}//ficlass