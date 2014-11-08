package Drivers;
import java.util.*;

import Model.Hospital;
import Model.Doctor;

public class DriverHospital {

	
	
	static void MostrarHosp(Hospital hosp){
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
			System.out.printf("Hi ha %d Doctors\n",hosp.Docsize());
			aldoc=hosp.getDoctors();
			Iterator<Doctor> itr = aldoc.iterator();
			int i = 0;
			while(itr.hasNext()){
				Doctor d = new Doctor();
				d=itr.next();
				System.out.printf("%d.\n",i);
				System.out.printf("ID: %d\n",d.getId());
				System.out.printf("Nom: %s\n",d.getNombre());
				System.out.printf("Num Max turnos: %d\n",d.getNumMaxTurnos());
				System.out.printf("Sueldo Por turno: %s\n",d.getSueldoTurno());
				if(d.isREmpty()) System.out.printf("No te restriccions: \n");
				else System.out.printf("Te restriccions\n");
				++i;
			}
		}
		
		System.out.printf("Actualment no te calendari\n");
		
		System.out.printf("______________________________\n");
		
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
			
			System.out.print("1: Crea Hospital vacio\n");
			System.out.print("2: Crea Hospital con id, nombre y factores\n");
			System.out.print("3:No OPERATIVA Crea Hospital con id, nombre, factores, arraylist de doctores y calendario.\n");
			System.out.print("4: Canviali el nom al hospital\n");
			System.out.print("5: Canviali el factor Mati\n");
			System.out.print("6: Canviali el factor Tarda\n");
			System.out.print("7: Canviali el factor Nit\n");
			System.out.print("8: Canviali els 3 factors de cop\n");
			System.out.print("9: Afegiex un doctor\n");
			System.out.print("10: Afegeix un Vector de doctors\n");
			System.out.print("11: Afegeix un Arraylist de doctors\n");
			System.out.print("12: Borra un doctor\n");
			System.out.print("13: Borra tots els Doctors\n");
			System.out.print("14:No Operativa Afegeix un torn\n");
			System.out.print("15: Mostra l'hospital\n");
			
		
			
			opcion = teclado.nextInt(); //leemos opcion
			
			
			
			Hospital HOSP = new Hospital();
			
			
			switch(opcion){
				case 1:{ //
					Hospital h = new Hospital();
					MostrarHosp(h);
					break;
				}
				case 2: { //
					id=1;
					
					System.out.print("\n");
					//HOSP =...
					
					
					break;
				}
				case 3:{ //
					++id;
					System.out.print("\n");

					//HOSP... 
					
					break;
				}
				case 4:{ //
					++id;

					System.out.print("\n");
					//HOSP=..
					
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
					break;
					
				}
				case 11:{ 
					break;
					
				}
				case 12:{ 
					break;
					
				}
				case 13:{ 
					break;
					
				}
				case 14:{ 
					break;
					
				}
				case 15:{
					
					if(id != -1) {
						MostrarHosp(HOSP);
					}
					else System.out.print("No existe Hosp!\n\n");
					
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