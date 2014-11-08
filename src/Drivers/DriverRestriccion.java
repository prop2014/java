package Drivers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		
		String TIPO = RES.getTipo(); 
		
		switch(TIPO){
		case "XOR":{//XOR
			
			//Especificamos el formato
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			
			XOR N = (XOR)RES;
			String a = N.getTipo();
			System.out.print("Los dias de la restriccion " + a + " son: \n");
			
			List<Date> L_XOR = N.getListDates();
			
			
			for (Date Fecha : L_XOR){//Para cada elemento de la lista
				
				//Parseo
				String Dia = formato.format(Fecha);
				
				System.out.print("String: " + Dia + "\n");
				System.out.print("Full info Date: " + Fecha + "\n");
				
			}
			
			
			break;
		}
		
		case "NOT_Dia_Mes" :{ //NOT_Dia_Mes
			
			NOT_Dia_Mes N = (NOT_Dia_Mes)RES;
			int  t = N.getDia_Mes(); 
			String a = N.getTipo();
			System.out.print("El dia del mes de la restriccion " + a + " es " + t + "\n");
			
			break;
		}
		case "NOT_Dia_Semana" :{ //NOT_Dia_Semana
			
			NOT_Dia_Semana N = (NOT_Dia_Semana)RES;
			String  t = N.getDia_Semana(); 
			String a = N.getTipo();
			System.out.print("El dia de la semana de la restriccion " + a + " es " + t + "\n");
			
			break;
		}
		case "NOT_Especial" :{// NOT_Especial
			
			NOT_Especial N = (NOT_Especial)RES;
			String  t = N.getEspecial(); 
			String a = N.getTipo();
			System.out.print("El dia Especial de la restriccion " + a + " es " + t + "\n");;
			
			break;
		}
		case "NOT_Fecha" :{ //NOT_Fecha
			
			NOT_Fecha N = (NOT_Fecha)RES;
			String  t = N.getStringFecha(); 
			Date d = N.getDateFecha();
			String a = N.getTipo();
			System.out.print("El Dia de la restriccion " + a + " es " + t + "\n");
			System.out.print("Como variables Date: " + d + "\n");
			
			break;
		}
		case "NOT_Turno" :{ //NOT_Turno
			
			NOT_Turno N = (NOT_Turno)RES;
			String  t = N.getTipoTurno(); 
			String a = N.getTipo();
			System.out.print("El turno de la restriccion " + a + " es " + t + "\n");
			break;
		}
		case "MAX_Turnos_por_Dia" :{ //MAX_Turnos_por_Dia
			
			MAX_Turnos_por_Dia N = (MAX_Turnos_por_Dia)RES;
			int  t = N.getDia_Num_Turnos(); 
			String a = N.getTipo();
			System.out.print("El maximo de turnos de la restriccion " + a + " es " + t + "\n");
			
			break;
		}
		case "MAX_Turnos_Consecutivos"  :{ //MAX_Turnos_Consecutivos
			
			MAX_Turnos_Consecutivos N = (MAX_Turnos_Consecutivos)RES;
			int  t = N.getDia_Num_Turnos(); 
			String a = N.getTipo();
			System.out.print("El el maximo de turnos consecutivos de la restriccion " + a + " es " + t + "\n");
			
			break;
		}
		
		case "MAX_Dias_Rango"  :{ //MAX_Dias_Rango
			
			MAX_Dias_Rango N = (MAX_Dias_Rango)RES;
			int  t = N.getNumDias(); 
			String a = N.getTipo();
			String fi = N.getStringFechaINI();
			String ff = N.getStringFechaFIN();
			System.out.print("La fecha inicial de la restriccion" + a + " es " + fi + "\n");
			System.out.print("La fecha final es " + ff + "\n");
			System.out.print("El numero maximo de dias a trabajar es " + t + "\n");
			break;
		}
		
		}
		return;
	}
	

	public static void main(String[] args) throws ParseException {
		
		Scanner teclado;
		teclado = new Scanner(System.in);
		
		int id = -1;
		int opcion = -1;
		
		Restriccion RES = new Restriccion(); 
		
		while(opcion != 0){
			
			System.out.print("-----------------------------------------------------\n");
			System.out.print("|               ¿Que desea hacer?                   |\n");
			System.out.print("|---------------------------------------------------|\n");
			System.out.print("| 1: Crear Restriccion tipo XOR                     |\n");
			System.out.print("| 2: Crear Restriccion tipo NOT_Dia_Mes             |\n");
			System.out.print("| 3: Crear Restriccion tipo NOT_Dia_Semana          |\n");
			System.out.print("| 4: Crear Restriccion tipo NOT_Especial            |\n");
			System.out.print("| 5: Crear Restriccion tipo NOT_Fecha               |\n");
			System.out.print("| 6: Crear Restriccion tipo NOT_Turno               |\n"); 
			System.out.print("| 7: Crear Restriccion tipo MAX_Turnos_por_Dia      |\n");
			System.out.print("| 8: Crear Restriccion tipo MAX_Turnos_Consecutivos |\n");
			System.out.print("| 9: Crear Restriccion tipo MAX_Dias_Rango          |\n");
			System.out.print("| 10: Ver Restriccion ya creada                     |\n");
			System.out.print("-----------------------------------------------------\n");
			
			
			opcion = teclado.nextInt(); //leemos opcion
				
			switch(opcion){
				case 1:{ //XOR
					++id;
					
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					
					//Gestionar el bucle interno
					boolean next = true;
					String seguir;
					
					List<Date> L_XOR = new ArrayList<Date>();
					
					//Leer fecha y parsearla
					System.out.print("Introduce una fecha (dd/MM/aaaa) \n");
					String Dia = teclado.next();
					Date Fecha = formato.parse(Dia);
					
					L_XOR.add(Fecha);
					
					
					do {
						//Leer fecha y parsearla
						System.out.print("Introduce otra fecha (dd/MM/aaaa) \n");
						Dia = teclado.next();
						Fecha = formato.parse(Dia);
						
						L_XOR.add(Fecha);
						
						System.out.print("Seguir añadiendo fechas? (Si/No) \n");
						seguir = teclado.next();
						// Si seleccionamos "No" o sus variantes saldremos del bucle
						if(seguir.equals("No") || seguir.equals("no") || seguir.equals("N") || seguir.equals("NO") || seguir.equals("n")) next = false; 
						
					} while(next);
					
					RES = new XOR(id, L_XOR);
					System.out.print("DONE\n");
					
					
					break;
				}
				case 2: { //NOT_Dia_Mes
					++id;
					int Dia;
					System.out.print("Introduce el dia del mes(1-31) que no quieras trabajar\n");
					Dia = teclado.nextInt();
					RES = new NOT_Dia_Mes(id, Dia);
					System.out.print("DONE\n");

					
					break;
					
				}
				case 3:{ //NOT_Dia_Semana
					++id;
					String Dia;
					System.out.print("Introduce el dia de la semana(Lunes-Domingo) que no quieras trabajar\n");
					Dia = teclado.next();
					RES = new NOT_Dia_Semana(id, Dia);
					System.out.print("DONE\n");
					
					break;
				}
				case 4:{ //NOT_Especial
					++id;
					String Dia;
					System.out.print("Introduce el dia Especial(Navidad,SantGervasi,...) que no quieras trabajar\n");
					Dia = teclado.next();
					RES = new NOT_Especial( id, Dia);
					System.out.print("DONE\n");
					
					break;
				}
				case 5:{ //NOT_Fecha
					System.out.print("Introduce una fecha (dd/MM/aaaa) que no quieras trabajar\n");
					++id;
					String Fecha;
					Fecha = teclado.next();
					
					RES = new NOT_Fecha( id, Fecha);
					System.out.print("DONE\n");
				}
					
					break;
					
				case 6:{ //NOT_Turno
					++id;
					String Turno;
					System.out.print("Introduce el Turno (Mañana/Tarde/Noche) que no quieras trabajar\n");
					Turno = teclado.next();
					RES = new NOT_Especial( id, Turno);
					System.out.print("DONE\n");
					
					break;
				}
				case 7:{ //MAX_Turnos_por_Dia
					++id;
					int Dias;
					System.out.print("Introduce el maximo de turnos por dia que quieras trabajar (1 o 2)\n");
					Dias = teclado.nextInt();
					RES = new MAX_Turnos_por_Dia(id, Dias);
					System.out.print("DONE\n");
					break;
				}
				case 8:{//MAX_Turnos_Consecutivos
					++id;
					int Dias;
					System.out.print("Introduce el maximo de turnos consecutivos que quieras trabajar\n");
					Dias = teclado.nextInt();
					RES = new MAX_Turnos_Consecutivos(id, Dias);
					System.out.print("DONE\n");
					break;
					
				}
				case 9:{ //MAX_Dias_Rango
					
					++id;
					String FechaINI, FechaFIN;
					int Dias;
					System.out.print("Introduce la fecha inicial (dd/MM/aaaa) del rango de dias\n");
					FechaINI = teclado.next();
					System.out.print("Introduce la fecha final (dd/MM/aaaa) del rango de dias\n");
					FechaFIN = teclado.next();
					System.out.print("Introduce el numero de dias\n");
					Dias = teclado.nextInt();
					
					RES = new MAX_Dias_Rango( id,FechaINI,FechaFIN, Dias);
					System.out.print("DONE\n");
				
					
					break;
					
				}
				case 10:{
					
					if(id != -1) MostrarRestriccion(RES);
					else System.out.print("Aun no hay ninguna Restriccion!\n\n");
					
					break;
				}
				default: break;
			
			}
			
			// GESTION DE SALIDA DEL BUCLE
			String s;
			System.out.print("\n Desea Continuar? (Si/No)\n");
			
			s = teclado.next();
			// Si seleccionamos "No" o sus variantes saldremos del bucle
			if(s.equals("No") || s.equals("no") || s.equals("N") || s.equals("NO") || s.equals("n")) opcion = 0; 
			
			
		}
		System.out.print("PROGRAM EXIT");
	}
	
}
