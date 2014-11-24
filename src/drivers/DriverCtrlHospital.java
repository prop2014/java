package drivers;

import java.io.*;
import java.text.DateFormat;
import java.util.*;

import model.Calendario;
import model.Hospital;
import model.Restriccion;
import model.MAX_Turnos_Rango;
import model.Doctor;
import model.Turno;



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

	static void MostrarTurno(Turno t){
		System.out.printf("--------------------.\n");
		GregorianCalendar c1 = t.getDate();
		String fecha = DateFormat.getDateInstance(DateFormat.SHORT).format(c1.getTime());
		System.out.printf("fecha: %s\n", fecha);
		System.out.printf("\n");
		System.out.printf("tipoturno: %s\n",t.getShiftType());
		System.out.printf("especial: %s\n",t.getSpecialDate());
		System.out.printf("numDoctores: %d\n",t.getNumberOfDoctors());
		System.out.printf("--------------------.\n");

	}
	static void MostrarDoc(Doctor doc){
		System.out.printf("--------------------.\n");
		System.out.printf("ID: %d\n",doc.getId());
		System.out.printf("Nom: %s\n",doc.getName());
		System.out.printf("Num Max turnos: %d\n",doc.getNumMaxTurn());
		System.out.printf("Sueldo Por turno: %s €\n",doc.getSalaryTurn());
		if(doc.isREmpty()) System.out.printf("No te restriccions: \n");
		else System.out.printf("Te restriccions\n");
		System.out.printf("--------------------.\n");
	}
	static void MostrarHospital(Hospital hosp){
		ArrayList<Doctor> aldoc;
		
		System.out.printf("ID Hospital: %d\n",hosp.getId());
		System.out.printf("Nombre: %s\n",hosp.getNombre());
		System.out.printf("Factor Mati: %f\n",hosp.getFactorM());
		System.out.printf("Factor Tarda: %f\n",hosp.getFactorT());
		System.out.printf("Factor Nit: %f\n",hosp.getFactorN());
		if(hosp.isDocEmpty()) {
			System.out.printf("No hi ha doctors\n");
		}
		else {
			System.out.printf("LLista de Doctors:\n");
			System.out.printf("Hi ha %d Doctors\n",hosp.docSize());
			aldoc=hosp.getDoctors();
			Iterator<Doctor> itr = aldoc.iterator();
			int i = 1;
			while(itr.hasNext()){
				Doctor d = new Doctor();
				d=itr.next();
				System.out.printf("%d.\n",i);
				MostrarDoc(d);
				++i;
			}
		}
		Calendario cal = hosp.getCalendario();
		if(cal.getNumberOfVacationDates()==0) System.out.printf("Actualment l'Hospital no te calendari\n");
		else {
			System.out.printf("El calendari te %d Turns Vacacionals\n",cal.getNumberOfShifts());
			ArrayList<Turno> alturno = cal.getALLShifts();
			for(int i=0;i<alturno.size();++i){
				MostrarTurno(alturno.get(i));
			}
		}
		System.out.printf("______________________________\n");
		
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
						System.out.printf("%d : doctor:%s\n",i,aldoctor.get(i).getName());
					}
					System.out.print("Ingrese el numero del doctor:\n");
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
				case 7:
					Hospital Hosp =domain.getHospital();
					MostrarHospital(Hosp);
					
				default:
			}
			
				
			muestraOpciones();
		    opcion = teclado.nextInt();
		}
		teclado.close();
		System.out.print("PROGRAM EXIT");
	}
}
