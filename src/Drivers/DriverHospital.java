package Drivers;
import java.util.*;
import Model.Hospital;
import Model.Doctor;

public class DriverHospital {

	
	
	void MostrarHosp(Hospital hosp){
		
		System.out.printf("ID Hospital: %d\n",hosp.getId());
		System.out.printf("Nombre: %s\n",hosp.getNombre());
		System.out.printf("Factor Mati: %f\n",hosp.getFactorM());
		System.out.printf("Factor Tarda: %f\n",hosp.getFactorT());
		System.out.printf("Factor Nit: %f\n",hosp.getFactorN());
		System.out.print("Factors en un vector: ");
		
	}
	/*public static void main(String[] args) {
		Scanner teclado;
		Hospital hosp = new Hospital();
		int id;
		String n;
		double fm;
		double ft;
		double fn;
		
		teclado = new Scanner(System.in);
		System.out.print("Ingrese el codigo del hospital: ");
		id = teclado.nextInt();
		System.out.print("Ingrese el nombre del hospital: ");
		n = teclado.next();
		System.out.print("Ingrese el factorMañana: ");
		fm = teclado.nextDouble();
		System.out.print("Ingrese el factorTarde: ");
		ft = teclado.nextDouble();
		System.out.print("Ingrese el factorNoche: ");
		fn = teclado.nextDouble();
		
		Hospital husp = new Hospital(id,n,fm,ft,fn);
		System.out.printf("ID Hospital %d, Nom Hospital: %s\n", husp.getId(), husp.getNombre());
	
		System.out.print("cambiali el nom: ");
		n = teclado.next();
		husp.setNombre(n);
		System.out.printf("ID Hospital %d, Nom Hospital: %s\n FM: %f, FT: %f, FN: %f\n", husp.getId(), husp.getNombre(), husp.getFactorM(),
			husp.getFactorT(), husp.getFactorN());
		System.out.print("cambiale factorMañana: ");
		fm = teclado.nextDouble();
		husp.setFactorM(fm);
		System.out.print("Ingrese el factorTarde: ");
		ft = teclado.nextDouble();
		husp.setFactorT(ft);
		System.out.print("Ingrese el factorNoche: ");
		fn = teclado.nextDouble();
		husp.setFactorN(fn);
		
		System.out.printf("ID Hospital %d, Nom Hospital: %s\n FM: %f, FT: %f, FN: %f\n", husp.getId(), husp.getNombre(), husp.getFactorM(),
				husp.getFactorT(), husp.getFactorN());
	}*/
	
	
	public static void main(String[] args) {
		
		Scanner teclado;
		teclado = new Scanner(System.in);
		
		int id = -1;
		int opcion = -1;
		
		while(opcion != 0){
			
			
			System.out.print("¿Que desea hacer?\n");
			
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
				case 1:{ 
					
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
				case 5:{ 
				}
					
					break;
					
				case 6:{ 
					break;
				}
				case 7:{ 
					break;
				}
				case 8:{
					
					break;
				}
				case 9:{ 
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