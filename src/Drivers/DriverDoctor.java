package Drivers;
import Model.*;

import java.util.*;

public class DriverDoctor {
	
	
	public static void main(String args[]) {
		Scanner teclado;
		teclado = new Scanner(System.in);		
		int numMax, idDoctor, opcion, idRestriccion;
		opcion = -1;
		String nombreDoctor, tipoRestriccion;
		Double sueldo;
		
		System.out.print("¿Que desea hacer?\n");
		System.out.print("1: Crear Doctor\n");
		System.out.print("2: Añadir restriccion a un Doctor\n");
		System.out.print("3: Eliminar restriccion a un doctor\n");
		System.out.print("4: Consultar retriccions del Doctor\n");
		
			
		opcion = teclado.nextInt(); //leemos opcion
		
		while(opcion != 0){	
			Doctor doc = new Doctor();
			Restriccion res = new Restriccion();
			if (opcion == 1){
				System.out.print("Ingrese el Id, Nombre, Numero màximo de turnos y Sueldo del Doctor\n");
				idDoctor = teclado.nextInt();
				nombreDoctor = teclado.next();
				numMax = teclado.nextInt();	
				sueldo = teclado.nextDouble();
				doc = new Doctor(idDoctor, nombreDoctor, numMax, sueldo);
				System.out.printf("El Doctor %d ha sido creado.\n", doc.getId());			
			}
			else if (opcion == 2) {
				System.out.printf("Ingrese la id y el tipo de restriccion\n");
				idRestriccion = teclado.nextInt();
				tipoRestriccion = teclado.next();
				if (tipoRestriccion == "MAX_Dies_Rango") {
					System.out.printf("Restriccion tipo MAX_Dies_Rango, ingrese la fecha inico, fin y el numero de dias.\n");
					//Date fechaIn, fechaFin;
					//int numDias;
					//fechaIn = 
					//fechaFin = 
					//numDias = 
					//res = new MAX_Dias_Rango(idRestriccion, fechaIn, fechaFin, numDias);
				}
				else if (tipoRestriccion == "MAX_Turnos_Consecutivos") {
					System.out.printf("Restriccion tipo MAX_Turnos_Consecutivos, ingrese el numero maximo de turnos.\n");
					int numTurnos;
					numTurnos = teclado.nextInt();
					res = new MAX_Turnos_Consecutivos(idRestriccion, numTurnos);										
				}
				else if (tipoRestriccion == "MAX_Turnos_por_Dia") {
					System.out.printf("Restriccion tipo MAX_Turnos_por_Dia, ingrese el numero maximo de turnos.\n");
					int numTurnos;
					numTurnos = teclado.nextInt();
					res = new MAX_Turnos_por_Dia(idRestriccion, numTurnos);						
				}
				else if (tipoRestriccion == "NOT_Dia_Mes") {
					System.out.printf("Restriccion tipo NOT_Dia_Mes, ingrese el dia del mes.\n");
					int diaMes;
					diaMes = teclado.nextInt();
					res = new NOT_Dia_Mes(idRestriccion, diaMes);					
				}
				else if (tipoRestriccion == "NOT_Dia_Setmana") {
					System.out.printf("Restriccion tipo NOT_Dia_Setmana, ingrese el dia de la semana.\n");
					String diaSemana;
					diaSemana = teclado.next();
					res = new NOT_Dia_Semana(idRestriccion, diaSemana);
				}
				else if (tipoRestriccion == "NOT_Especial") {
					System.out.printf("Restriccion tipo NOT_Especial, ingrese el dia especial.\n");
					String diaEspecial;
					diaEspecial = teclado.next();
					res = new NOT_Especial(idRestriccion, diaEspecial);
				}
				else if (tipoRestriccion == "NOT_Fecha") {
					System.out.printf("Restriccion tipo NOT_Fecha, ingrese la fecha.\n");
					//Date fecha;
					//fecha =
					//res = new NOT_Fecha(idRestriccion, fecha);
				}
				else if (tipoRestriccion == "NOT_Turno") {
					System.out.printf("Restriccion tipo NOT_Turno, ingrese el tipo del dia.\n");
					String tipoDia;
					tipoDia = teclado.next();
					res = new NOT_Especial(idRestriccion, tipoDia);
				}
				else if (tipoRestriccion == "XOR") {
					System.out.printf("Restriccion tipo XOR, ingrese las diferentas fechas.\n");
					Vector<Date> vector_XOR = new Vector<Date>();
					Date fecha;
					//while (fecha = ) {
					//	vector_XOR.add(fecha);
					//}
					//res = new NOT_Especial(idRestriccion, vector_XOR);					
				}
				boolean c = doc.addRestriccion(res);
				if (c) System.out.printf("Restriccion añadida.\n");	
				else System.out.printf("Ya existe una restriccion con este Id.\n");				
			}
			/*else if (opcion == 3) {
			}
			else if (opcion == 4) {
			}
			else if (opcion == 5) {
			}*/
			opcion = teclado.nextInt();
			
		}
		
	}
}
