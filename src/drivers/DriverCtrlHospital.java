package drivers;

import java.io.*;
import java.util.*;

import model.Doctor;
import model.Hospital;
import domain.CtrlHospital;
import data.CtrlDatosFichero;

public class DriverCtrlHospital {
	private static void muestraOpciones() {
		System.out.print("¿Que desea hacer?\n\n");
		System.out.print("1: Crear Hospital\n");
		System.out.print("2: Modificar Hospital\n");
		System.out.print("3: Crear Doctor y añadir a Hospital\n");
		System.out.print("NO: Modificar Doctor del hospital\n");
		System.out.print("NO: Eliminar Doctor del hospital\n");
		System.out.print("4: Cargar un hospital\n");
		System.out.print("0: Salir\n");
	}

	
	public static void main(String[] args) throws IOException{
		Scanner teclado;
		teclado = new Scanner(System.in);
		
		int opcion = -1;
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader (isr);
		
	    muestraOpciones();
	    opcion = teclado.nextInt();
	    CtrlHospital domain = new CtrlHospital();
	    
	    int id;
		String nombre;
		double fm, ft, fn;
	    
		while(opcion != 0) {
	        
			switch(opcion){
				case 1:
					System.out.println("Ingrese el id del hospital: ");
					id = teclado.nextInt();
					System.out.println("Ingrese el nombre del hospital: ");
					nombre = br.readLine();
					System.out.println("Ingrese el factorMañana: ");
					fm = teclado.nextDouble();
					System.out.println("Ingrese el factorTarde: ");
					ft = teclado.nextDouble();
					System.out.println("Ingrese el factorNoche: ");
					fn = teclado.nextDouble();
					try{
						domain.crearHospital(id, nombre, fm, ft, fn);
					} catch(IOException e) { throw new IOException(e); }
					System.out.println("Hospital creado correctamente");	
					break;
					
				case 2:
					System.out.println("Ingrese el nuevo nombre del hospital: ");
					nombre = br.readLine();
					System.out.println("Ingrese el nuevo factorMañana: ");
					fm = teclado.nextDouble();
					System.out.println("Ingrese el nuevo factorTarde: ");
					ft = teclado.nextDouble();
					System.out.println("Ingrese el nuevo factorNoche: ");
					fn = teclado.nextDouble();
					try {
						domain.modificarHospital(nombre, fm, ft, fn);
					} catch(IOException e) { throw new IOException(e); }
					System.out.println("Hospital modificado correctamente");
					break;
				
				case 3:
					int numMax;
					Double sueldo;
					System.out.println("Ingrese el identificador del Doctor: ");
					id = teclado.nextInt();
					System.out.println("Ingrese el nombre del Doctor: ");
					nombre = br.readLine();
					System.out.println("Ingrese el número máximo de turnos del Doctor: ");
					numMax = teclado.nextInt();	
					System.out.println("Ingrese el sueldo del Doctor: ");
					sueldo = teclado.nextDouble();
					try {
						domain.crearDoctor(id, nombre, numMax, sueldo);
					}
					catch(IOException e) { throw new IOException(e); }
					System.out.println("Doctor añadido correctamente");
					break;
				
				case 4:
					System.out.println("Ingrese el identificador del Hospital: ");
					int Id = teclado.nextInt();
					try{
						
						domain.cargarHospital(Id);
					}
					catch(IOException e) { throw new IOException(e); }
					System.out.println("Hospital correctamente cargado");
					break;
				
				default:
			}
			
				
			muestraOpciones();
		    opcion = teclado.nextInt();
		}
		System.out.print("PROGRAM EXIT");
	}
}
