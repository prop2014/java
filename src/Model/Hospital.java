/*Autor: Oscar */

package Model;
import java.util.*;
import Model.Doctor;

public class Hospital {
	
	/* Atributos */

	private int idHospital;
	private String nombre;
	private double factorM;
	private double factorT;
	private double factorN;
	private Map <Integer , Doctor> doctors;
	


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
		double[] fac;  //a de ser privat=?
		fac=new double[3];
		fac[0]=factorM;
		fac[1]=factorT;
		fac[2]=factorN;
		return fac;
	}
	//doctors buit?
	public boolean isDEmpty(){
		return doctors.isEmpty();
	}
	 //consultora del numero de doctors
	public int Dsize(){
		return doctors.size();
	}
	
	
	
	/* Metodos públicos */
/*	public void incicializar() {
		int n, i;
		teclado = new Scanner(System.in);
		System.out.print("Ingrese el codigo del hospital: ");
		id_hospital = teclado.nextInt();
		System.out.print("Ingrese el nombre del hospital: ");
		nombre = teclado.next();
		System.out.print("Ingrese el nombre de doctores del hospital: ");
		n = teclado.nextInt();
		doctors = new ArrayList<Doctor>(n);
		for (i = 0; i < n; ++i) {
			Doctor doctor;
	        doctor = new Doctor();
			doctor.inicializarDoctor(i);
			doctors.add(doctor);
		}
	}*/
	/////////////////MMMMMMOOOOODIIIFICADORASSSSSS/////////
		//modificadora del nombre
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
	
	
	
	///////////////MMMMMMEEEETTOOOODOOOOS/////////////////
	
		//afegeix un doctor d al hospital
	public void afegirDoctor(Doctor d){
		
		
	}
		//borra el doctor d del hospital
	public void borarDoctor(Doctor d){
		
		
	}
	
	// borra todos los doctores del hospital (alert!);
		public void cleardoctors(){
			doctors.clear();
		}
	
}//ficlass