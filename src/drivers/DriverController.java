package drivers;

import java.text.DateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Calendario;
import model.Doctor;
import model.NOT_Dia_Mes;
import model.Restriccion;
import domain.*;


public class DriverController {
	
	private static void muestraOpciones() {
		System.out.print("¿Que desea hacer?\n\n");
		System.out.print("X: Crear Hospital\n");
		System.out.print("2: Anadir Doctor al Hospital\n");
		System.out.print("3: Modificar un Doctor\n");
		System.out.print("4: Anadir un dia al Calendario\n");
		System.out.print("5: Anadir restriccion dia_mes\n");
		System.out.print("6: FordFulkerson\n");
		System.out.print("7: EdmondsKarp\n");
		System.out.print("8: Dijkstra\n");
		System.out.print("0: Salir\n");
	}
	
public static void main(String[] args) throws IOException{
		
		Scanner teclado;
		teclado = new Scanner(System.in);
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader (isr);
	    
	    CtrlHospital CtrlHosp = new CtrlHospital();

	    int id;
		String nombre, fecha;
		int numMax;
		double sueldo;
	    double fm, ft, fn;
		System.out.print("Introduce el ID del hospital: ");
		id = teclado.nextInt();
		System.out.print("Introduce el nombre del hospital: ");
		nombre = teclado.next();
		System.out.print("Introduce el factorManana: ");
		fm = teclado.nextDouble();
		System.out.print("Introduce el factorTarde: ");
		ft = teclado.nextDouble();
		System.out.print("Introduce el factorNoche: ");
		fn = teclado.nextDouble();
		
		try {
			CtrlHosp.crearHospital(id, nombre, fm, ft, fn);
			System.out.println("Hospital Creado Correctamente");
		} catch (IOException e) {
			System.out.println(e);
		}
		 
	    CtrlDoctor CtrlDoct = new CtrlDoctor(CtrlHosp.getDoctors());
	    CtrlCalendario CtrlCal = new CtrlCalendario(CtrlHosp.getCalendar());
	    CtrlAlgorithm CtrlAlg = new CtrlAlgorithm(CtrlHosp.getHospital());
	    
		int opcion = -1;
		muestraOpciones();
		opcion = teclado.nextInt();
		
		
		while(opcion != 0){
			
			switch(opcion){
				case 1:
					
					break;
				
				case 2:
					System.out.print("Introduce el ID del doctor: ");
					id = teclado.nextInt();
					System.out.print("Introduce el nombre del doctor: ");
					nombre = teclado.next();
					System.out.print("Introduce el numero máximo de turnos del doctor: ");
					numMax = teclado.nextInt();
					System.out.print("Introduce el sueldo del doctor: ");
					sueldo = teclado.nextDouble();
					
					try {
						CtrlHosp.crearDoctor(id, nombre, numMax, sueldo);
						System.out.println("Doctor Creado Correctamente");
					} catch(IOException e) {
						System.out.println(e);
					}
					break;
				
				case 3:
					System.out.print("Introduce el ID del doctor que quieres eliminar: ");
					id = teclado.nextInt();
				
					try {
						CtrlHosp.eliminarDoctor(id);
						System.out.println("Doctor Eliminado Correctamente");
					} catch(IOException e) {
						System.out.println(e);
					}
					break;
					
				case 4:
					String especial;
					int dia, mes, year, numDocM, numDocT, numDocN;
					System.out.print("Introduce el dia: ");
					dia = teclado.nextInt();
					System.out.print("Introduce el mes: ");
					mes = teclado.nextInt();
					System.out.print("Introduce el year: ");
					year = teclado.nextInt();
					System.out.print("Introduce el numero de doctores para el turno morning: ");
					numDocM = teclado.nextInt();
					System.out.print("Introduce el numero de doctores para el turno afternoon: ");
					numDocT = teclado.nextInt();
					System.out.print("Introduce el numero de doctores para el turno night: ");
					numDocN = teclado.nextInt();
					System.out.print("Introduce un dia especial (navidad): ");
					especial = teclado.next();
					try {
						CtrlCal.addVacationDay(dia, mes, year, numDocM, numDocT, numDocN, especial);
						System.out.println("Fecha (3 turnos) introducida correctamente");
					} catch(IOException e) { System.out.println(e); }
					break;
				
				case 5:
					System.out.print("Introduce el ID del doctor\n");
					id = teclado.nextInt();
					System.out.print("Introduce el dia del mes\n");
					int dia_mes = teclado.nextInt();
					System.out.print("Introduce el id de la restriccion\n");
					int idRes = teclado.nextInt();
					try {
						CtrlDoct.addResNOT_Dia_Mes(id, idRes, dia_mes);
						System.out.println("Restriccion anadida correctamente al doctor: id="+ id);
					} catch (IOException e) { System.out.println(e); }
					break;
					
					
				case 6:
					CtrlAlg = new CtrlAlgorithm(CtrlHosp.getHospital());
					System.out.println("NODOS:");
					CtrlAlg.generateGraf();
					int ini, fin;
					System.out.println("Introduce el vertice inicio:");
					ini = teclado.nextInt();
					System.out.println("Introduce el vertice fin:");
					fin = teclado.nextInt();
					CtrlAlg.findMaxFlowFulk(ini, fin);
					/*Graf<Nodo> gr = CtrlAlg.getGraf();
					ArrayList<Integer> nodosr = gr.getOutNodes(0);
					System.out.printf("Source Conectado con:\n");
					for(int i : nodosr) {
						nodoDoctor nodr = (nodoDoctor)gr.getNode(i);
						System.out.printf("DOCTOR %d: ",nodr.getIdDoc());
						for(int j : gr.getOutNodes(i)){
							Nodo nod2r1 = gr.getNode(j);
							if(nod2r1.getTipo().equals("Turno")) {
								nodoTurno nod2r = (nodoTurno)nod2r1;
								GregorianCalendar c1 = nod2r.getFecha();
								fecha = DateFormat.getDateInstance(DateFormat.SHORT).format(c1.getTime());
								System.out.printf("Fecha: %s - %s", fecha, nod2r.getTipoTurno());
								System.out.printf(" ******* ");
							}
						}
						System.out.printf("\n");
					}*/
					if(CtrlAlg.findSolution(ini, fin)){
						System.out.println("Hay solucion");
					} else {
						ArrayList<nodoTurno> turnosSinSol = CtrlAlg.getTurnosSinSol();
						System.out.println("No hay solucion.\nTurnos sin solucion:");
						for(nodoTurno t : turnosSinSol) {
							String tipo = t.getTipoTurno();
							GregorianCalendar c1 = t.getFecha();
							fecha = DateFormat.getDateInstance(DateFormat.SHORT).format(c1.getTime());
							System.out.printf("Fecha:%s - %s\n", fecha, tipo);
						}
					}
					break;
					
				case 7:
					
					break;
				
				default: break;
			}
			muestraOpciones();
			opcion = teclado.nextInt();
		}
		teclado.close();
		System.out.print("PROGRAM EXIT");
	}
	
	
	
}
