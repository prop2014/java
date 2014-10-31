package Drivers;
import Model.Doctor;
import Model.Hospital;

import java.util.*;

public class DriverDoctor {
	
	
	public static void main(String args[]) {
		Scanner teclado;
		int id, numMax;
		String nombre;
		Double sueldo;		
		teclado = new Scanner(System.in);
		
		System.out.print("Ingrese el identificador del doctor: ");
		id = teclado.nextInt();
		System.out.print("Ingrese el nombre del doctor: ");
		nombre = teclado.next();
		System.out.print("Ingrese el numero maximo de turnos del doctor: ");
		numMax = teclado.nextInt();	
		System.out.print("Ingrese el sueldo del doctor: ");
		sueldo = teclado.nextDouble();
		
		Doctor doc = new Doctor(id,nombre, numMax, sueldo);
		System.out.printf("ID Doctor: %d\n", doc.getId());
		System.out.printf("Nombre Doctor: %s\n", doc.getNombre());
		System.out.printf("NumMaxTurnos Doctor: %d\n", doc.getNumMaxTurnos());
		System.out.printf("Sueldo Doctor: %f\n", doc.getSueldoTurno());
		}	
}
