package drivers;

import java.io.*;
import java.util.*;
import model.Restriccion;
import model.MAX_Turnos_Rango;
import model.Doctor;



import domain.CtrlHospital;


public class DriverCtrlHospital {
	private static void muestraOpciones() {
		System.out.print("¿Que desea hacer?\n\n");
		System.out.print("1: Crear Hospital\n");
		System.out.print("2: Modificar Hospital\n");
		System.out.print("3: Crear Doctor y añadir a Hospital\n");
		System.out.print("4: Cargar un hospital\n");
		System.out.print("5: Guradar Hospital\n");
		System.out.print("6: Anadir Restriccion maxturnosRango a un doctor\n");
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
				
				case 5: 
						domain.guardarHospital();
					System.out.println("Hospital correctamente guardado");
					break;
					
				case 6: //Res Max Turnos Rango
					ArrayList<Doctor> aldoctor = new ArrayList<Doctor>();
					try{
					aldoctor = domain.getDoctors();
					}catch(IOException e) { throw new IOException(e); }
					System.out.println("Doctores Obtenidos:");
					for(int i=0;i<aldoctor.size();++i){
						System.out.printf("%d : doctor:%d\n",i,aldoctor.get(i).getId());
					}
					
					int x = teclado.nextInt();
					Doctor	m = aldoctor.get(x);
					Restriccion res;
					System.out.println("Ingrese el id Restriccion:");
					int idRestriccion = teclado.nextInt();
						System.out.printf("Restriccion tipo MAX_Turnos_Rango, ingrese la fecha inico (dd MM aaaa), fecha fin y el numero de Turnos.\n");
						int numTurnos;
						int d1, d2, m1, m2, a1, a2;
						d1 = teclado.nextInt();
						m1 = teclado.nextInt();
						a1 = teclado.nextInt();
						d2 = teclado.nextInt();
						m2 = teclado.nextInt();
						a2 = teclado.nextInt();
						numTurnos = teclado.nextInt();
						res = new MAX_Turnos_Rango(idRestriccion, d1, m1, a1, d2, m2, a2, numTurnos);
					m.addRestriction(res);
					break;
					
				default:
			}
			
				
			muestraOpciones();
		    opcion = teclado.nextInt();
		}
		teclado.close();
		System.out.print("PROGRAM EXIT");
	}
}
