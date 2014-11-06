/*Autor: Oscar */

package Model;
import java.util.*;
import Model.Doctor;
import Model.Restriccion;
import Model.Calendari;

public class Hospital {
	
	/* Atributos */

	private int idHospital;
	private String nombre;
	private double factorM;
	private double factorT;
	private double factorN;
	private Map <Integer , Doctor> doctors;
	private Calendari calendari;


	////////////////COOOOOOONSSTRUUUCTOOORAS////////////

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
	
	// creadora con id, nombre, factores, doctores y calendario. //full
	public Hospital (int id, String nom, double fm, double ft, double fn, Doctor[] vdoc, Calendari cal){
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
		//calendari = new Calendari(cal);
	}
	
	//////////////COOOOONSULTORASSSSS//////////////////
	
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
	
		//indica si existeix algun doctor
	public boolean isDEmpty(){
		return doctors.isEmpty();
	}
	
		//indica si existeix un doctor amb identificador = id;
	public boolean existeixdoctor(int id){
		
		return doctors.containsKey(id);
	}
	
	 //consultora del numero de doctors
	public int Dsize(){
		return doctors.size();
	}
	
	

	/////////////////MMMMMMOOOOODIIIFICADORASSSSSS/////////
	
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
	
	
	///////////////MMMMMMEEEETTOOOODOOOOS/////////////////
	
		//afegeix un nou doctor d al hospital si no existeix 
	public void afegirDoctor(Doctor d){
		if(doctors.containsKey(d.getId())==false){
			doctors.put(d.getId(), d);
		}
		
	}
		//afegeix un vector de doctors al hospital. el sobreescriu si existeix
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
	
}//ficlass