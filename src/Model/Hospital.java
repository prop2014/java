/*Autor: Oscar */

package Model;
import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
	
	/* Atributos */

	private int idHospital;
	private String nombre;
	private double factorM;
	private double factorT;
	private double factorN;
	
	private ArrayList<Doctor> doctors;
	
	private Scanner teclado;


	/* Constructora */	

	public Hospital() {}
	
	//creadora amb id, nombre y factores
	public Hospital (int id, String nom, double fm, double ft, double fn){
		idHospital=id;
		nombre=nom;
		factorM=fm;
		factorT=ft;
		factorN=fn;
	}
	
	//////////////COOOOONSULTORASSSSS//////////////////
	
	// consultora de la id
	public int consultarId(){
		return idHospital;
	}
	
	// consultora del Nombre
	public String consultarNombre(){
		return nombre;
	}
	
	// consultora del factorM
	public double consultarFactorM(){
		return factorM;
	}
	
	// consultor del factorT
	public double consultarFactorT(){
		return factorT;
	}
	
	// consultora del factorN
	public double consultarFactorN(){
		return factorN;
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
		
	public void consultar_doctor() {
		int id;
		teclado = new Scanner(System.in);
		System.out.print("Id del doctor que quieres consultar: ");
		id = teclado.nextInt();
		Doctor doctor;
        doctor = new Doctor();
		doctor.imprimirDoctor(doctors.get(id));
	}
	
	/////////////////MMMMMMOOOOODIIIFICADORASSSSSS/////////
	
	
	
	///////////////MMMMMMEEEETTOOOODOOOOS/////////////////
	
	public static void main(String[] args) {
		

	}

}