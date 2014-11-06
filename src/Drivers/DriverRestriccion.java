package Drivers;
import java.util.*;

import Model.Doctor;
import Model.Hospital;
import Model.Restriccion;
import Model.MAX_Dias_Rango;
import Model.MAX_Turnos_Consecutivos;
import Model.MAX_Turnos_por_Dia;
import Model.NOT_Dia_Mes;
import Model.NOT_Dia_Semana;
import Model.NOT_Especial;
import Model.NOT_Fecha;
import Model.NOT_Turno;
import Model.XOR;


public class DriverRestriccion {
	
	
	static void MostrarRestriccion(Restriccion RES){
		
		Scanner teclado;
		teclado = new Scanner(System.in); 
		
		switch(RES.getTipo()){
		case "XOR" :{//XOR
			
			break;
		}
		
		case "NOT_Dia_Mes" :{ //NOT_Dia_Mes
			System.out.printf("antes del print dentro del case");
			//System.out.printf("ID de Restriccion %d Restriccion tipo:  %s, Dia restringido %d\n", RES.getId(), RES.getTipo(), RES.getDia_Mes());
			//System.out.printf("ID de Restriccion %d Restriccion tipo:  %s \n", RES.getId(), RES.getTipo(), RES.getDiaMes());
			break;
		}
		case "NOT_Dia_Semana" :{ //NOT_Dia_Semana
			
			break;
		}
		case "NOT_Especial" :{// NOT_Especial
			
			break;
		}
		case "NOT_Fecha" :{ //NOT_Fecha
			
			break;
		}
		case "NOT_Turno" :{ //NOT_Turno
			
			break;
		}
		case "MAX_Turnos_por_Dia" :{ //MAX_Turnos_por_Dia
			
			break;
		}
		case "MAX_Turnos_Consecutivos"  :{ //MAX_Turnos_Consecutivos
			
			break;
		}
		
		case "MAX_Dias_Rango"  :{ //MAX_Dias_Rango
			
			break;
		}
		
		}
		
	}
	

	public static void main(String[] args) {
		
		Scanner teclado;
		teclado = new Scanner(System.in);
		
		int id = -1;
		int opcion = -1;
		
		while(opcion != 0){
			
			
			System.out.print("¿Que desea hacer?\n\n");
			
			System.out.print("NOP 1: Crear Restriccion tipo XOR\n");
			System.out.print("2: Crear Restriccion tipo NOT_Dia_Mes\n");
			System.out.print("3: Crear Restriccion tipo NOT_Dia_Semana\n");
			System.out.print("4: Crear Restriccion tipo NOT_Especial\n");
			System.out.print("NOP 5: Crear Restriccion tipo NOT_Fecha\n");
			System.out.print("6: Crear Restriccion tipo NOT_Turno\n");
			System.out.print("7: Crear Restriccion tipo MAX_Turnos_por_Dia\n");
			System.out.print("8: Crear Restriccion tipo MAX_Turnos_Consecutivos\n");
			System.out.print("NOP 9: Crear Restriccion tipo MAX_Dias_Rango\n");
			System.out.print("10: Ver Restriccion ya creada\n");
		
			
			opcion = teclado.nextInt(); //leemos opcion
			
			
			
			Restriccion RES = new Restriccion(); 
			
			
			switch(opcion){
				case 1:{ //XOR
					System.out.print("ESTA RESTRICCION NO ESTA OPERATIVA");
					break;
				}
				case 2: { //NOT_Dia_Mes
					++id;
					int Dia;
					System.out.print("Introduce el dia del mes(1-30) que no quieras trabajar\n");
					Dia = teclado.nextInt();
					RES = new NOT_Dia_Mes(id, Dia);
					
					
					break;
				}
				case 3:{ //NOT_Dia_Semana
					++id;
					String Dia;
					System.out.print("Introduce el dia de la semana(Lunes-Domingo) que no quieras trabajar\n");
					Dia = teclado.next();
					RES = new NOT_Dia_Semana(id, Dia);
					
					break;
				}
				case 4:{ //NOT_Especial
					++id;
					String Dia;
					System.out.print("Introduce el dia Especial(Navidad,SantGervasi,...) que no quieras trabajar\n");
					Dia = teclado.next();
					RES = new NOT_Especial( id, Dia);
					
					break;
				}
				case 5:{ //NOT_Fecha
					System.out.print("ESTA RESTRICCION NO ESTA OPERATIVA");
					/*++id;
					Date Dia;
					System.out.print("Introduce la fecha exacta que no quieras trabajar\n");
			-------->Dia = teclado.next();
					RES = new NOT_Especial( id, Dia); */
				}
					
					break;
					
				case 6:{ //NOT_Turno
					++id;
					String Turno;
					System.out.print("Introduce el Turno (Mañana/Tarde/Noche) que no quieras trabajar\n");
					Turno = teclado.next();
					RES = new NOT_Especial( id, Turno);
					
					break;
				}
				case 7:{ //MAX_Turnos_por_Dia
					++id;
					int Dias;
					System.out.print("Introduce el maximo de turnos que quieras trabajar por dia (1 o 2)\n");
					Dias = teclado.nextInt();
					RES = new MAX_Turnos_por_Dia(id, Dias);
					break;
				}
				case 8:{//MAX_Turnos_Consecutivos
					
					break;
				}
				case 9:{ //MAX_Dias_Rango
					System.out.print("ESTA RESTRICCION NO ESTA OPERATIVA");
					/*++id;
					int Dias;
					Date Dia;
					System.out.print("Introduce la fecha inicial\n");
	 -------------->Dia = teclado.();
					System.out.print("Introduce la fecha final\n");
	 -------------->Dia = teclado.();
					System.out.print("Introduce el maximo de turnos que quieras trabajar en ese rango de dias\n");
					Dias = teclado.nextInt();
					RES = new MAX_Dias_Rango(id, Dias); */
					break;
					
				}
				case 10:{
					
					if(id != -1) {
						
						MostrarRestriccion(RES);
					}
					else System.out.print("Aun No hay ninguna Restriccion!\n\n");
					
					break;
				}
				default: break;
			
			}
			
			// GESTION DE SALIDA DEL BUCLE
			String s;
			System.out.print("Desea Continuar? (Si/No)\n");
			
			s = teclado.next();
			// Si seleccionamos "No" o sus variantes saldremos del bucle
			if(s.equals("No") || s.equals("no") || s.equals("N") || s.equals("NO") || s.equals("n")) opcion = 0; 
			
			
		}
		System.out.print("PROGRAM EXIT");
	}
	
}
