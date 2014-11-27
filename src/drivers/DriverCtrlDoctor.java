package drivers;
import model.*;
import domain.*;

import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;


public class DriverCtrlDoctor {

	private static void mostrarOpciones() {
		System.out.print("-----------------------------------------------\n");
		System.out.print("�Que desea hacer?\n");
		System.out.print("0: Salir\n");
		System.out.print("1: Consultar Doctor\n");
		System.out.print("2: Modificar Doctor\n");
		System.out.print("3: Anadir restriccion tipo MAX_Turnos_por_Dia\n");
		System.out.print("4: Anadir restriccion tipo MAX_Turnos_Rango\n");
		System.out.print("5: Anadir restriccion tipo NOT_Dia_Mes\n");
		System.out.print("6: Anadir restriccion tipo NOT_Dia_Semana\n");
		System.out.print("7: Anadir restriccion tipo NOT_Especial\n");
		System.out.print("8: Anadir restriccion tipo NOT_Fecha\n");
		System.out.print("9: Anadir restriccion tipo NOT_Turno\n");
		System.out.print("10: Anadir restriccion tipo XOR\n");
		System.out.print("11: Eliminar restriccion\n");
		System.out.print("12: Consultar restricciones Doctor\n");
		System.out.print("-----------------------------------------------\n\n");
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner teclado;
		teclado = new Scanner(System.in);
		
		int opcion, idDoc, idRes;
		ArrayList<Doctor> docs = new ArrayList<Doctor>();
		
		Doctor doc1 = new Doctor(0, "Juan", 10, 50);
		Doctor doc2 = new Doctor(1, "Julio", 12, 60);
		Doctor doc3 = new Doctor(2, "Sergio", 15, 50);
		Doctor doc4 = new Doctor(3, "David", 5, 70);
		Doctor doc5 = new Doctor(4, "Jorge", 20, 40);
		docs.add(doc1);
		docs.add(doc2);
		docs.add(doc3);
		docs.add(doc4);
		docs.add(doc5);
		
		CtrlDoctor ctrlDoc = new CtrlDoctor(docs, 2014);
		
		mostrarOpciones();
		opcion = teclado.nextInt();
		
		while(opcion != 0){	
			if (opcion == 1) {
				System.out.print("Ingrese ID del doctor a consultar\n");
				idDoc = teclado.nextInt();
				try {
					System.out.println("Nombre Doctor: "+ctrlDoc.getNombreDoctor(idDoc)+"\n"
					+"NumMaxTurnos: "+ctrlDoc.getNumMaxTurnosDoctor(idDoc)+ "\nSueldo por Turno: "+
					ctrlDoc.getSueldoTurnosDoctor(idDoc)+"\n");
				} catch(IOException e) { System.out.println(e); }
			}
			else if (opcion == 2) {
				String nom;
				int numMax;
				double sueldo;
				System.out.print("Ingrese ID del doctor a consultar\n");
				idDoc = teclado.nextInt();
				System.out.print("Ingrese el nuevo nombre del doctor\n");
				nom = teclado.next();
				System.out.print("Ingrese el nuevo numero maximo de turnos del doctor\n");
				numMax = teclado.nextInt();
				System.out.print("Ingrese el nuevo sueldo por turno del doctor\n");
				sueldo = teclado.nextDouble();
				try {
					ctrlDoc.setDoctor(idDoc, nom, numMax, sueldo);
					System.out.println("Doctor modificado correctamente\n");
				} catch(IOException e) { System.out.println(e); }
			}
			else if (opcion == 3) {
				int turnos;
				System.out.print("Ingrese el ID del doctor\n");
				idDoc = teclado.nextInt();
				System.out.print("Ingrese el ID de la restriccion\n");
				idRes = teclado.nextInt();
				System.out.print("Ingrese el numero maximo de turnos por dia\n");
				turnos = teclado.nextInt();
				try {
					ctrlDoc.addResMAX_Turnos_por_Dia(idDoc, idRes, turnos);
					System.out.println("Restriccion anadida correctamente\n");
				} catch (IOException e) { System.out.println(e); }
			}
			else if (opcion == 4) {
				int d1, m1, a1, d2, m2, a2, turnos;
				System.out.print("Ingrese el ID del doctor\n");
				idDoc = teclado.nextInt();
				System.out.print("Ingrese el ID de la restriccion\n");
				idRes = teclado.nextInt();
				System.out.print("Ingrese la fecha inicial (dd MM yyyy)\n");
				d1 = teclado.nextInt();
				m1 = teclado.nextInt();
				a1 = teclado.nextInt();
				System.out.print("Ingrese la fecha final (dd MM yyyy)\n");
				d2 = teclado.nextInt();
				m2 = teclado.nextInt();
				a2 = teclado.nextInt();
				System.out.print("Igrese el numero maximo de turnos en el rango\n");
				turnos = teclado.nextInt();
				try {
					ctrlDoc.addResMAX_Turnos_Rango(idDoc, idRes, d1, m1, a1, d2, m2, a2, turnos);
					System.out.println("Restriccion anadida correctamente\n");
				} catch (IOException e) { System.out.println(e); }
			}
			else if (opcion == 5) {
				int dia;
				System.out.print("Ingrese el ID del doctor\n");
				idDoc = teclado.nextInt();
				System.out.print("Ingrese el ID de la restriccion\n");
				idRes = teclado.nextInt();
				System.out.print("Ingrese el dia del mes\n");
				dia = teclado.nextInt();
				try {
					ctrlDoc.addResNOT_Dia_Mes(idDoc, idRes, dia);
					System.out.println("Restriccion anadida correctamente\n");
				} catch (IOException e) { System.out.println(e); }			
			}
			else if (opcion == 6) {
				String dia;
				System.out.print("Ingrese el ID del doctor\n");
				idDoc = teclado.nextInt();
				System.out.print("Ingrese el ID de la restriccion\n");
				idRes = teclado.nextInt();
				System.out.print("Ingrese el dia de la semana (lunes, martes, miercoles, jueves, viernes, sabado o domingo)\n");
				dia = teclado.next();
				try {
					ctrlDoc.addResNOT_Dia_Semana(idDoc, idRes, dia);
					System.out.println("Restriccion anadida correctamente\n");
				} catch (IOException e) { System.out.println(e); }
			}
			else if (opcion == 7) {
				String especial;
				System.out.print("Ingrese el ID del doctor\n");
				idDoc = teclado.nextInt();
				System.out.print("Ingrese el ID de la restriccion\n");
				idRes = teclado.nextInt();
				System.out.print("Ingrese el dia especial (navidad, semana_santa, noche_vieja o noche_buena)\n");
				especial = teclado.next();
				try {
					ctrlDoc.addResNOT_Especial(idDoc, idRes, especial);
					System.out.println("Restriccion anadida correctamente\n");
				} catch (IOException e) { System.out.println(e); }
			}
			else if (opcion == 8) {
				int d1, m1, a1;
				System.out.print("Ingrese el ID del doctor\n");
				idDoc = teclado.nextInt();
				System.out.print("Ingrese el ID de la restriccion\n");
				idRes = teclado.nextInt();
				System.out.print("Ingrese la fecha (dd MM yyyy)\n");
				d1 = teclado.nextInt();
				m1 = teclado.nextInt();
				a1 = teclado.nextInt();
				try {
					ctrlDoc.addResNOT_Fecha(idDoc, idRes, d1, m1, a1);
					System.out.println("Restriccion anadida correctamente\n");
				} catch (IOException e) { System.out.println(e); }
			}
			else if (opcion == 9) {
				String turno;
				System.out.print("Ingrese el ID del doctor\n");
				idDoc = teclado.nextInt();
				System.out.print("Ingrese el ID de la restriccion\n");
				idRes = teclado.nextInt();
				System.out.print("Ingrese el turno (manana, tarde o noche)\n");
				turno = teclado.next();
				try {
					ctrlDoc.addResNOT_Turno(idDoc, idRes, turno);
					System.out.println("Restriccion anadida correctamente");
				} catch (IOException e) { System.out.println(e); }
			}			
			else if (opcion == 10) {
				int d1, m1, a1;
				String turno;
				ArrayList<Integer> dia = new ArrayList<Integer>();
				ArrayList<Integer> mes = new ArrayList<Integer>();
				ArrayList<Integer> any = new ArrayList<Integer>();
				ArrayList<String> turnos = new ArrayList<String>();
				System.out.print("Ingrese el ID del doctor\n");
				idDoc = teclado.nextInt();
				System.out.print("Introduce el id de la restriccion\n");
				idRes = teclado.nextInt();
				String opt = "S";
				while(opt.equals("s") || opt.equals("S")) {
					System.out.print("Ingrese la fecha (dd MM yyyy)\n");
					d1 = teclado.nextInt();
					dia.add(d1);
					m1 = teclado.nextInt();
					mes.add(m1);
					a1 = teclado.nextInt();
					any.add(a1);
					System.out.print("Ingrese el turno (manana, tarde o noche)\n");
					turno = teclado.next();
					turnos.add(turno);
					System.out.print("Quieres anadir otro turno? (S/s N/n)\n");
					opt = teclado.next();
				}
				try {
					ctrlDoc.addResXOR(idDoc, idRes, dia, mes, any, turnos);
					System.out.println("Restriccion anadida correctamente\n");
				} catch (IOException e) { System.out.println(e); }
			}
			else if (opcion == 11) {
				System.out.print("Ingrese el ID del doctor\n");
				idDoc = teclado.nextInt();
				System.out.print("Ingrese el ID de la restriccion\n");
				idRes = teclado.nextInt();
				try {
					ctrlDoc.eliminarRestriccion(idRes, idDoc);
					System.out.println("Restriccion eliminada correctamente\n");
				} catch (IOException e) { System.out.println(e); }
			}
			else if (opcion == 12) {
				System.out.print("Ingrese el ID del doctor del cual quieres consultar sus restricciones\n");
				idDoc = teclado.nextInt();
				try {
					if (idDoc < 0 || idDoc > 4) System.out.println("Esta ID de doctor no existe\n");
					else {
						Doctor doc = docs.get(idDoc);
						if (doc.isREmpty())  System.out.println("Este doctor no contiene restricciones\n");
						else {
							ArrayList<Restriccion> alres = doc.getRestrictions();
							for (int i = 0; i < alres.size(); ++i) {
								int idR = alres.get(i).getIdRestriccion();
								if (alres.get(i).getTipo().equals("MAX_Turnos_por_Dia")) {
									System.out.println("Restriccion tipo: "+ctrlDoc.getTipoRestriccion(idDoc, idR));
									System.out.println("Maximo numero de turnos por dia: "+ctrlDoc.getMAX_Turnos_Por_Dia(idDoc,idR)+"\n");
								}
								else if (alres.get(i).getTipo().equals("MAX_Turnos_Rango")) {
									GregorianCalendar fecha1 = ctrlDoc.getMAX_Turnos_Rango_FeIni(idDoc, idR);
									GregorianCalendar fecha2 = ctrlDoc.getMAX_Turnos_Rango_FeFin(idDoc, idR);
									System.out.println("Restriccion tipo: "+ctrlDoc.getTipoRestriccion(idDoc, idR));
									System.out.println("Fecha inicio: "+fecha1.get(fecha1.DAY_OF_MONTH)+"/"+(fecha1.get(fecha1.MONTH)+1)+"/"+fecha1.get(fecha1.YEAR));
									System.out.println("Fecha fin: "+fecha2.get(fecha2.DAY_OF_MONTH)+"/"+(fecha2.get(fecha2.MONTH)+1)+"/"+fecha2.get(fecha2.YEAR));
									System.out.println("Numero maximo de turnos: "+ctrlDoc.getMAX_Turnos_Rango_numT(idDoc, idR));
								}
								else if (alres.get(i).getTipo().equals("NOT_Dia_Mes")) {
									System.out.println("Restriccion tipo: "+ctrlDoc.getTipoRestriccion(idDoc, idR));
									System.out.println("Dia del mes: "+ctrlDoc.getNOT_Dia_Mes(idDoc,idR)+"\n");
								}
								else if (alres.get(i).getTipo().equals("Not_Dia_Semana")) {
									System.out.println("Restriccion tipo: "+ctrlDoc.getTipoRestriccion(idDoc, idR));
									System.out.println("Dia de la semana: "+ctrlDoc.getNOT_Dia_Semana(idDoc,idR)+"\n");
								}
								else if (alres.get(i).getTipo().equals("NOT_Especial")) {
									System.out.println("Restriccion tipo: "+ctrlDoc.getTipoRestriccion(idDoc, idR));
									System.out.println("Dia Especial: "+ctrlDoc.getNOT_Especial(idDoc,idR)+"\n");
								}
								else if (alres.get(i).getTipo().equals("NOT_Fecha")) {
									System.out.println("Restriccion tipo: "+ctrlDoc.getTipoRestriccion(idDoc, idR));
								}
								else if (alres.get(i).getTipo().equals("NOT_Turno")) {
									System.out.println("Restriccion tipo: "+ctrlDoc.getTipoRestriccion(idDoc, idR));
								}
								else if (alres.get(i).getTipo().equals("XOR")) {
									System.out.println("Restriccion tipo: "+ctrlDoc.getTipoRestriccion(idDoc, idR));
								}
							}
						}
					}
					
				} catch (IOException e) { System.out.println(e); }
			}
			mostrarOpciones();
			opcion = teclado.nextInt();
		}
		teclado.close();
		System.out.print("PROGRAM EXIT");
	}

}