
//autor: Oscar Urgelles

package drivers;
import java.util.*;
import java.io.*;

import model.Calendario;
import model.Doctor;
import model.Hospital;
import model.Turno;

public class DriverHospital {
	
		//provando
	static void MostrarTurno(Turno t){
		//GregorianCalendar getFecha()
		System.out.printf("--------------------.\n");
		Calendar c1 = t.getFecha();
		System.out.printf("fecha:\n"+c1.getTime().toLocaleString());
		System.out.printf("\n");
		System.out.printf("tipoturno: %s\n",t.getTipoTurno());
		System.out.printf("especial: %s\n",t.getEspecial());
		System.out.printf("numDoctores: %d\n",t.getNumDoctores());
		System.out.printf("--------------------.\n");

	}
	//provando
	static void MostrarCalendario(Vector<Turno> vt){
		for(int i=0; i<vt.size();++i){
			MostrarTurno(vt.get(i));
		}
	}
	
	static void MostrarDoc(Doctor doc){
		System.out.printf("--------------------.\n");
		System.out.printf("ID: %d\n",doc.getId());
		System.out.printf("Nom: %s\n",doc.getNombre());
		System.out.printf("Num Max turnos: %d\n",doc.getNumMaxTurnos());
		System.out.printf("Sueldo Por turno: %s €\n",doc.getSueldoTurno());
		if(doc.isREmpty()) System.out.printf("No te restriccions: \n");
		else System.out.printf("Te restriccions\n");
		System.out.printf("--------------------.\n");
	}
	
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
				System.out.printf("%d.\n",i);
				MostrarDoc(d);
				++i;
			}
		}
		if(hosp.getNumDias()==0) System.out.printf("Actualment l'Hospital no te calendari\n");
		else {
			System.out.printf("El calendari te %d Dies Vacacionals\n",hosp.getNumDias());
			ArrayList<Vector<Turno>> alturno = hosp.getTurnos();
			for(int i=0;i<alturno.size();++i){
				MostrarCalendario(alturno.get(i));
			}
		}
		System.out.printf("______________________________\n");
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.print("¿Has iniciat el driver d'hospital!!\n");
		System.out.print("\n\n\n");
		
		Scanner teclado;
		teclado = new Scanner(System.in);
		Hospital HOSP = new Hospital();
		int id = -1;
		int opcion = -1;
		
		while(opcion != 0){
			
			
			System.out.print("¿Que desea hacer?\n");
			
			System.out.print("1: Crea Hospital vacio\n");
			System.out.print("2: Crea Hospital con id, nombre y factores\n");
			System.out.print("3: No va Crea Hospital con id, nombre, factores, arraylist de doctores y calendario.\n");
			System.out.print("4: Canviali el nom al hospital\n");
			System.out.print("5: Canviali el factor Mati\n");
			System.out.print("6: Canviali el factor Tarda\n");
			System.out.print("7: Canviali el factor Nit\n");
			System.out.print("8: Afegiex un doctor\n");
			System.out.print("9: Afegeix un Vector de doctors (vector de doctors creat per defecte)\n");
			System.out.print("10: Afegeix un Arraylist de doctors (arraylist de doctors creat per defecte) \n");
			System.out.print("11: mostra doctor\n");
			System.out.print("12: Borra un doctor\n");
			System.out.print("13: Borra tots els Doctors\n");
			System.out.print("14: Afegeix un Dia Vacacional\n");
			System.out.print("15: Elimina un Dia Vacacional\n");
			System.out.print("16: Mostra l'hospital\n");
			System.out.print("17: Borra totes les dades de l'hospital\n");
			System.out.print("\n");
			
		
			
			opcion = teclado.nextInt(); //leemos opcion
						
			switch(opcion){
				case 1:{ //
					if(id!=1){
						id=1;
						System.out.print("Hospital Creat Correctament (prova opcio 15 despres de continuar)\n");
					}
					else {
						System.out.print("Ja havies creat un hospital\n");
					}
					break;
				}
				case 2: { //Crea Hospital con id, nombre y factores
					if(id!=1){
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
					}
					else {
						System.out.print("Ja havies creat un hospital\n");
					}
					break;
				}
				case 3:{ 
					if(id!=1){
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
					System.out.print("S'ha Creat un Arraylist amb 5 doctors per simular l'entrada\n");
					Calendario cale = new Calendario();
					GregorianCalendar gc1= new GregorianCalendar(1,1,1);
					GregorianCalendar gc2= new GregorianCalendar(2,2,2);
					cale.addDiaVacacional(gc1);
					cale.addDiaVacacional(gc2);
					System.out.print("S'ha Creat un calendari amb els dies 1 1 1 y 2 2 2 per " +
							"simular l'entrada\n");
					HOSP = new Hospital(codigo,n,fm,ft,fn,aldoc,cale);
					System.out.print("Hospital Creat Correctament (prova opcio 15 despres de continuar)\n");		
				}
				else {
					System.out.print("Ja havies creat un hospital\n");
				}
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
				case 9:{ //Afegeix un Vector de doctors (vector de doctors creat per defecte)
					if(id!=-1){
						Doctor[] vdoc = new Doctor[5];
						
						vdoc[0]= new Doctor(1,"PRIMERO",1,1.0);
						vdoc[1]= new Doctor(2,"SEGUNDO",2,2.0);
						vdoc[2]= new Doctor(3,"TERCERO",3,3.0);	
						vdoc[3]= new Doctor(4,"QUARTO",4,4.0);	
						vdoc[4]= new Doctor(5,"QUINTO",5,5.0);
						System.out.print("vdoc[0]=Doctor(1,PRIMERO,1,1.0)\n");
						System.out.print("vdoc[1]=Doctor(2,SEGUNDO,2,2.0)\n");
						System.out.print("vdoc[2]=Doctor(3,TERCERO,3,3.0)\n");
						System.out.print("vdoc[3]=Doctor(4,QUARTO,4,4.0)\n");
						System.out.print("vdoc[4]=Doctor(5,QUINTO,5,5.0)\n");
						HOSP.afegirDoctors(vdoc);
						System.out.print("S'han afegit els 5 doctors al Hospital. +" +
								"Recorda que aquesta funcio sobreescriu els doctors\n");
					}
					else System.out.print("Hospital No creat\n");
					break;
					
				}
				
				case 10:{ //afegeix un arraylist de doctors al hospital
					if(id!=-1){
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
						System.out.print("doc1=Doctor(1,PRIMERO,1,1.0)\n");
						System.out.print("doc2=Doctor(2,SEGUNDO,2,2.0)\n");
						System.out.print("doc3=Doctor(3,TERCERO,3,3.0)\n");
						System.out.print("doc4=Doctor(4,QUARTO,4,4.0)\n");
						System.out.print("doc5=Doctor(5,QUINTO,5,5.0)\n");
						HOSP.afegirDoctors(aldoc);
						System.out.print("S'han afegit els 5 doctors al Hospital. +" +
								"Recorda que aquesta funcio sobreescriu els doctors\n");
					}
					else System.out.print("Hospital No creat\n");
					break;
					
				}
					
				case 11:{ //mostra un doctor
					if(id!=-1){
						System.out.print("ID de los doctores del hospital: \n");
						ArrayList<Doctor> aldoc;
						aldoc=HOSP.getDoctors();
						Iterator<Doctor> itr = aldoc.iterator();
						Doctor doc;
						while(itr.hasNext()){
							doc=itr.next();
							System.out.printf("ID: %d\n",doc.getId());
						}
						System.out.print("Ingrese el id del doctor a mostrar \n");
						int d=teclado.nextInt();
						if(HOSP.existsDoctor(d)) {
							doc=HOSP.getDoctor(d);
							MostrarDoc(doc);
						}
						else{
							System.out.print("No existia aquest doctor al hospital\n");
						}
						
					}
					else System.out.print("Hospital No creat\n");
					break;	
				}
				case 12:{ //Borra un doctor
					if(id!=-1){
						int iden;
						ArrayList<Doctor> aldoc;
						aldoc=HOSP.getDoctors();
						Iterator<Doctor> itr = aldoc.iterator();
						while(itr.hasNext()){
							Doctor d = new Doctor();
							d=itr.next();
							System.out.printf("ID: %d\n",d.getId());
						}
						System.out.print("Ingrese el Id del Doctor a borrar\n");
						
						iden = teclado.nextInt();
						if(HOSP.existsDoctor(iden)== false) System.out.print("Et recordo que no existeix aquest identificador\n");
						else{
							HOSP.borrarDoctor(iden);
							System.out.print("\n Doctor Borrat! (prova opcio 15 despres de continuar) \n");
						}
					}
					else System.out.print("Hospital No creat\n");
					break;
					
				}
				case 13:{ //Borra tots els Doctors
					
					if(id!=-1){
						if(HOSP.Docsize()>0)HOSP.cleardoctors();
						System.out.print("L'hospital ja no te doctors\n");
					}
					else System.out.print("Hospital No creat\n");
					break;
					
				}
				case 14:{ //afegeix dia vacacional
					if(id!=-1){
						System.out.print("introdueix el dia vacacional: (dd mm yyyy) \n");
						int dia = teclado.nextInt();
						int mes = teclado.nextInt();
						int year = teclado.nextInt();
						GregorianCalendar d= new GregorianCalendar(dia,mes,year);
						if(HOSP.existsDiaVacacional(d)==true){ //ya existeix
							System.out.print("ya existeix aquest dia vacacional\n");
						}
						else {
							HOSP.addDiaVacacional(d);
							System.out.print("DiaVacacional introduit (prova opcio 15) \n");
						}
					}
					else System.out.print("Hospital No creat\n");
					break;
				}
				case 15:{ //borra dia vacacional
					if(id!=-1){
						System.out.print("introdueix el dia vacacional a eliminar: (dd mm yyyy) \n");
						int dia = teclado.nextInt();
						int mes = teclado.nextInt();
						int year = teclado.nextInt();
						GregorianCalendar d= new GregorianCalendar(dia,mes,year);
						if(HOSP.existsDiaVacacional(d)==true){ //ya existeix
							HOSP.deleteDiaVacacional(d);
							System.out.print("DiaVacacional borrat (prova opcio 15) \n");
						}
						else {
							System.out.print("Aquest dia no pertany al calendari\n");
						}
					}
					else System.out.print("Hospital No creat\n");
					System.out.print("\n");
					break;
					
				}
				case 16:{
					if(id!=-1)	MostrarHosp(HOSP);
					else System.out.print("L'hospital no esta creat\n");
					break;
				}
				case 17:{ //borra dades Hosp
					if(id!=-1){
						HOSP.borraHosp();
						System.out.print("Les dades del hospital han estat resetejades\n");
					}
					else System.out.print("Hospital No creat\n");
					break;
					
				}
				default: break;
			
			}
			
			// GESTION DE SALIDA DEL BUCLE
			String s;
			System.out.print("Desea Continuar? (Si/No)\n");
			System.out.print("\n");
			s = teclado.next();
			// Si seleccionamos "No" o sus variantes saldremos del bucle
			if(s.equals("No") || s.equals("no") || s.equals("N") || s.equals("NO") || s.equals("n")) opcion = 0; 
			System.out.print("\n");
			
		}
		System.out.print("PROGRAM EXIT");
	}
}