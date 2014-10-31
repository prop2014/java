/*Autor: Oscar */

package Model;
import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
	
	/* Atributos */

	private int id_hospital;
	private String nombre;
	private ArrayList<Doctor> doctors;
	private Scanner teclado;


	/* Constructora */	

	public Hospital() {}


	/* Metodos públicos */
	public void incicializar() {
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
	}
		
	public void consultar_doctor() {
		int id;
		teclado = new Scanner(System.in);
		System.out.print("Id del doctor que quieres consultar: ");
		id = teclado.nextInt();
		Doctor doctor;
        doctor = new Doctor();
		doctor.imprimirDoctor(doctors.get(id));
	}
	
	public static void main(String[] args) {
		

	}

}