package Drivers;
import Model.Doctor;
import Model.Hospital;

import java.util.*;

public class DriverDoctor {
	
	
	public static void main(String args[]) {
		Scanner teclado;
		teclado = new Scanner(System.in);		
		int id = -1;
		int opcion = -1;
		int Id, numMax;
		String nombre;
		Double sueldo;
		
		System.out.print("¿Que desea hacer?\n");
		System.out.print("1: Crear Doctor\n");
		System.out.print("2: Añadir restriccion a un Doctor\n");
		System.out.print("3: Eliminar restriccion a un doctor\n");
		System.out.print("4: Consultar retriccions del Doctor\n");
		
			
		opcion = teclado.nextInt(); //leemos opcion
		
		while(opcion != 0){		
			if (opcion == 1){
				System.out.print("Ingrese el Id, Nombre, Numero màximo de turnos y Sueldo del Doctor\n");
				id = teclado.nextInt();
				nombre = teclado.next();
				numMax = teclado.nextInt();	
				sueldo = teclado.nextDouble();
				Doctor doc = new Doctor(id, nombre, numMax, sueldo);
				System.out.printf("El Doctor %d ha sido creado.\n", doc.getId());			
			}
			else if (opcion == 2) {
				//Restriccion r = new Restriccion();
			}
			else if (opcion == 3) {
			}
			else if (opcion == 4) {
			}
			else if (opcion == 5) {
			}
			opcion = teclado.nextInt();
			
		}
		
		
		/*Scanner teclado;
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
		}	*/
		
	}
}
