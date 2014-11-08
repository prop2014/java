//autor: Oscar Urgelles

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
			int i = 1;
			while(itr.hasNext()){
				Doctor d = new Doctor();
				d=itr.next();
				System.out.printf("--------------------.\n");
				System.out.printf("%d.\n",i);
				System.out.printf("ID: %d\n",d.getId());
				System.out.printf("Nom: %s\n",d.getNombre());
				System.out.printf("Num Max turnos: %d\n",d.getNumMaxTurnos());
				System.out.printf("Sueldo Por turno: %s €",d.getSueldoTurno());
				if(d.getSueldoTurno()< 1000.0) System.out.printf(" si ke pasa no soi ni mileurista\n");
				else System.out.printf(" i Like Money Bitches\n");
				if(d.isREmpty()) System.out.printf("No te restriccions: \n");
				else System.out.printf("Te restriccions\n");
				++i;
				System.out.printf("--------------------.\n");
			}
		}
		
		System.out.printf("Actualment l'Hospital no te calendari\n");
		
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
		Hospital HOSP = new Hospital();
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
			System.out.print("8: Afegiex un doctor\n");
			System.out.print("9: Afegeix un Vector de doctors (vector de doctors creat per defecte)\n");
			System.out.print("10: Afegeix un Arraylist de doctors (arraylist de doctors creat per defecte) \n");
			System.out.print("11: Borra un doctor\n");
			System.out.print("12: Borra tots els Doctors\n");
			System.out.print("13:No Operativa Afegeix un torn\n");
			System.out.print("15: Mostra l'hospital\n");
			
		
			
			opcion = teclado.nextInt(); //leemos opcion
						
			switch(opcion){
				case 1:{ //
					id=1;
					System.out.print("Hospital Creat Correctament (prova opcio 15 despres de continuar)\n");
					break;
				}
				case 2: { //Crea Hospital con id, nombre y factores
					id=1;
					int codigo;
					String n;
					double fm;
					double ft;
					double fn;
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
					
					HOSP = new Hospital(codigo,n,fm,ft,fn);
					System.out.print("Hospital Creat Correctament (prova opcio 15 despres de continuar)\n");		
					break;
				}
				case 3:{ //
					id=-1;
					System.out.print("No OPERATIVA\n");
					
					break;
				}
				case 4:{ //Canviali el nom al hospital
					if(id!=-1){
						String n;
						System.out.print("Ingrese el nuevo nombre del hospital: ");
						n = teclado.next();
						HOSP.setNombre(n);
						System.out.print("Nom Canviat!\n");
					}
					else System.out.print("Hospital No creat\n");
					break;
				}
				case 5:{ 
					if(id!=-1){
						double fm;
						System.out.print("Ingrese el nuevo factorMañana: ");
						fm = teclado.nextDouble();
						HOSP.setFactorM(fm);
						System.out.print("\n Factor Mati canviat! (prova opcio 15 despres de continuar) \n");
					}	
					else System.out.print("Hospital No creat\n");	
					break;
				}
				case 6:{ 
					if(id!=-1){
						double ft;
						System.out.print("Ingrese el nuevo factorTarde: ");
						ft = teclado.nextDouble();
						HOSP.setFactorT(ft);
						System.out.print("\n Factor Tarda canviat! (prova opcio 15 despres de continuar) \n");
					}
					else System.out.print("Hospital No creat\n");
					break;
				}
				case 7:{ 
					if(id!=-1){
						double fn;
						System.out.print("Ingrese el nuevo factorNoche: ");
						fn = teclado.nextDouble();
						HOSP.setFactorN(fn);
						System.out.print("\n Factor Nit canviat! (prova opcio 15 despres de continuar) \n");
					}
					else System.out.print("Hospital No creat\n");
					break;
				}
				case 8:{ //afegir doctor
					if(id!=-1){
						System.out.print("Ingrese el Id, Nombre, Numero maximo de turnos y Sueldo del Doctor\n");
						int Id, numMax;
						String nombre;
						Double sueldo;
						Id = teclado.nextInt();
						nombre = teclado.next();
						numMax = teclado.nextInt();	
						sueldo = teclado.nextDouble();
						Doctor doc = new Doctor(Id, nombre, numMax, sueldo);
						if(HOSP.existsDoctor(Id)) System.out.print("Et recordo que ja existeix aquest identificador\n");
						else{
							HOSP.afegirDoctor(doc);
							System.out.print("\n Doctor Afegit! (prova opcio 15 despres de continuar) \n");
						}
					}
					else System.out.print("Hospital No creat\n");
					
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
					if(id!=-1)	MostrarHosp(HOSP);
					else System.out.print("L'hospital no esta creat\n");
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