package drivers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.io.IOException;

import model.Calendario;
import model.Doctor;
import model.Hospital;
import model.Restriccion;
import model.NOT_Dia_Semana;
import model.NOT_Dia_Mes;
import model.NOT_Fecha;
import model.Turno;
import domain.CtrlGrafo;
import domain.Nodo;
import domain.Graf;
import domain.nodoDoctor;
import domain.nodoTurno;

/**
 * 
 * @author Alex Morral
 *
 */

public class DriverCtrlGraf {
	
	
	private static void muestraOpciones() {
		System.out.print("¿Que desea hacer?\n\n");
		System.out.print("1: Hospital (id,nom,fm,ft,fn,aldoc,cal)\n");
		System.out.print("2: addDoctor(d)\n");
		System.out.print("3: Llenar Grafo y mostrar conexiones\n");
		System.out.print("4: añadir Restriccion a un Doctor\n");
		System.out.print("0: Salir\n");
	}
	
	
	
	static void MostrarTurno(Turno t){
		GregorianCalendar c1 = t.getDate();
		String fecha = DateFormat.getDateInstance(DateFormat.SHORT).format(c1.getTime());
		System.out.printf("Turno Fecha: %s, Tipo: %s, Especial: %s, NumDoctores: %d \n", fecha, t.getShiftType(), t.getSpecialDate(), t.getNumberOfDoctors());
	}

	
	static void MostrarDoc(Doctor doc){
		System.out.printf("Doctor ID: %d, Nombre: %s, numMax: %d, Sueldo: %s, Restricciones: ", doc.getId(), doc.getName(), doc.getNumMaxTurn(), doc.getSalaryTurn());
		if(doc.isREmpty()) System.out.printf("No\n");
		else System.out.printf("Si\n");
	}

	static void MostrarHospital(Hospital hosp){
		ArrayList<Doctor> aldoc;
		
		System.out.printf("ID Hospital: %d\n",hosp.getId());
		System.out.printf("Nombre: %s\n",hosp.getNombre());
		System.out.printf("Factor Mañana: %f\n",hosp.getFactorM());
		System.out.printf("Factor Tarde: %f\n",hosp.getFactorT());
		System.out.printf("Factor Noche: %f\n",hosp.getFactorN());
		
		System.out.printf("Hay %d Doctores\n", hosp.docSize());
		aldoc=hosp.getDoctors();
		for (Doctor d : aldoc) {
			MostrarDoc(d);
		}
		Calendario cal = hosp.getCalendario();
		System.out.printf("El calendario tiene %d Turnos Vacacionales\n",cal.getNumberOfShifts());
		ArrayList<Turno> alturno = cal.getALLShifts();
		for(Turno t : alturno) {
			MostrarTurno(t);
		}
		System.out.printf("______________________________\n");
		
	}

	public static void main(String[] args) throws IOException{
		
		Scanner teclado;
		teclado = new Scanner(System.in);
		Hospital HOSP = new Hospital();
		int id = -1;
		int opcion = -1;
		muestraOpciones();
		opcion = teclado.nextInt();
		
		while(opcion != 0){
			
			switch(opcion){
				case 1:
					if(id!=1){
					id=1;
					int codigo;
					String n;
					double fm, ft, fn;
					System.out.print("Ingrese el id del hospital: ");
					codigo = teclado.nextInt();
					System.out.print("Ingrese el nombre del hospital: ");
					n = teclado.next();
					System.out.print("Ingrese el factorMañana: ");
					fm = teclado.nextDouble();
					System.out.print("Ingrese el factorTarde: ");
					ft = teclado.nextDouble();
					System.out.print("Ingrese el factorNoche: ");
					fn = teclado.nextDouble();
					Doctor doc1= new Doctor(1,"PRIMERO",1,1.0);
					Doctor doc2= new Doctor(2,"SEGUNDO",2,2.0);
					Doctor doc3= new Doctor(3,"TERCERO",3,3.0);	
					Doctor doc4= new Doctor(4,"QUARTO",4,4.0);	
					Doctor doc5= new Doctor(5,"QUINTO",5,5.0);
					ArrayList<Doctor> aldoc = new ArrayList<Doctor>();
					aldoc.add(doc1);
					aldoc.add(doc2);
					aldoc.add(doc3);
					aldoc.add(doc4);
					aldoc.add(doc5);
					System.out.print("Se añaden 5 doctores al hospital\n");
					int year, month, day;
					year = 2014;
					month = 2;
					day = 20;
					GregorianCalendar gc1= new GregorianCalendar(year, month-1, day);
					GregorianCalendar gc2= new GregorianCalendar(year, month-1, day+1);
					Calendario cale = new Calendario(year);
					cale.addOneVacationDay(gc1);
					cale.addOneVacationDay(gc2);
					System.out.print("Se añade un calendario con 2 dias (6 turnos) al hospital\n");
					HOSP = new Hospital(codigo,n,fm,ft,fn,aldoc,cale);
					Calendario cal = HOSP.getCalendario();
					ArrayList<Turno> turnos = cal.getALLShifts();
					for(Turno turno : turnos){
						turno.setNumberOfDoctors(5);
					}
					System.out.print("Hospital Creado Correctamente\n");
					MostrarHospital(HOSP);
				}
				break;
				
				case 2:
					System.out.print("Introduce el ID del doctor\n");
					int Id;
					Id = teclado.nextInt();
					System.out.print("Introduce el nombre del doctor\n");
					String nombre;
					nombre = teclado.next();
					System.out.print("Introduce el número máximo de turnos del doctor\n");
					int numMax;
					numMax = teclado.nextInt();
					System.out.print("Introduce el sueldo del doctor\n");
					Double sueldo;
					sueldo = teclado.nextDouble();
					Doctor doc = new Doctor(Id, nombre, numMax, sueldo);
					if(HOSP.existsDoctor(Id)) System.out.print("Ya existe un doctor con este identificador\n");
					else{
						HOSP.addDoctor(doc);
						System.out.print("Doctor Añadido!\n");
						MostrarHospital(HOSP);
					}
					break;
				
				case 3:
					CtrlGrafo ctrlGraf = new CtrlGrafo();
					try {
						ctrlGraf.llenarGrafo(HOSP);
					}
					catch (IOException e) {
					    throw new IOException(e);
					}
					Graf<Nodo> g = ctrlGraf.getGraf();
					ArrayList<Integer> nodos = g.getOutNodes(0);
					System.out.printf("Source Conectado con:\n");
					for(int i : nodos) {
						nodoDoctor nod = (nodoDoctor)g.getNode(i);
						System.out.printf("DOCTOR: IdDoc: %d, IdNodo: %d -> ",nod.getIdDoc(), i);
						for(int j : g.getOutNodes(i)){
							nodoTurno nod2 = (nodoTurno)g.getNode(j);
							GregorianCalendar c1 = nod2.getFecha();
							String fecha = DateFormat.getDateInstance(DateFormat.SHORT).format(c1.getTime());
							System.out.printf("Fecha: %s Turno: %s (conectado con): ", fecha, nod2.getTipoTurno());
							for(int k : g.getOutNodes(j)) {
								Nodo nod3 = g.getNode(k);
								System.out.printf("%s ", nod3.getTipo());
							}
							System.out.printf("|| ");
						}
						System.out.printf("\n");
					}
					break;
					
				case 4:
					System.out.print("Introduce el ID del doctor para ponerle una Restriccion NOT DiaSemana\n");
					int iden;
					System.out.print("(1,2,3,4,5)\n");
					iden = teclado.nextInt();
					Doctor doctor = HOSP.getDoctor(iden);
					Restriccion Res2 = new NOT_Dia_Mes(1,20);
					doctor.addRestriction(Res2);
					HOSP.setDoctor(doctor);
					MostrarDoc(doctor);
					
					break;
					
				case 5:
					CtrlGrafo CtrGra = new CtrlGrafo();
					try {
						CtrGra.llenarGrafo(HOSP);
					}
					catch (IOException e) {
					    throw new IOException(e);
					}
					Graf<Nodo> g1 = CtrGra.getGraf();
					ArrayList<Integer> nodos2 = g1.getOutNodes(0);
					System.out.printf("Source Conectado con:\n");
					for(int i = 1; i <= nodos2.size();++i){
						nodoDoctor nod2 = (nodoDoctor)g1.getNode(i);
						System.out.printf("DOCTOR: IdDoc: %d, IdNodo: %d -> ",nod2.getIdDoc(), i);
						for(int j : g1.getOutNodes(i)){
							System.out.printf("conected whit %d",j);
						}
						System.out.printf("\n");
					}
				
				default: break;
			}
			muestraOpciones();
			opcion = teclado.nextInt();
		}
		teclado.close();
		System.out.print("PROGRAM EXIT");
	}
}