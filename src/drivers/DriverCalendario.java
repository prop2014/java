package drivers;

import model.Turno;
import model.Calendario;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.text.SimpleDateFormat;


/**
 * Driver de la clase Calendario
 * @author Felix Fernando Ramos Velazquez
 */
public class DriverCalendario {

	private static int shiftsPerDay = 3;
	private static final String[] shiftTypes = {"manana","tarde","noche"};

	/**
	 * Muestra la informacion de un turno del calendario vacacional
	 * @param turno Turno de un dia vacacional
	 */
	public static void printShift(Turno turno) {
		SimpleDateFormat sdf = new SimpleDateFormat("d-M-yyyy");
		System.out.println("\tDia vacacional:\t" + sdf.format(turno.getDate().getTime()));
		System.out.println("\tTipo de turno:\t" + turno.getShiftType());
		System.out.println("\tFecha especial:\t" + turno.getSpecialDate());
		System.out.println("\tNum. doctores:\t" + turno.getNumberOfDoctors() + "\n");
	}

	/**
	 * Muestra la informacion de los 3 turnos de un dia vacacional
	 * @param shiftList Lista de turnos de un dia vacacional
	 */
	private static void printShiftsOfOneDay(ArrayList<Turno> shiftList) {
		SimpleDateFormat sdf = new SimpleDateFormat("d-M-yyyy");
		System.out.println("\tDia vacacional:\t" + sdf.format(shiftList.get(0).getDate().getTime()) + "\n");
		for (int i = 0; i < shiftsPerDay; ++i) {
			Turno t = shiftList.get(i);
			System.out.println("\tTurno de turno:\t" + t.getShiftType());
			System.out.println("\tFecha especial:\t" + t.getSpecialDate());
			System.out.println("\tNum. de doctores: " + t.getNumberOfDoctors() + "\n");
		}
	}

	/**
	 * Muestra la informacion de todos los turnos del calendario vacacional
	 * @param shiftList Lista de los turnos del calendario vacacional
	 */
	private static void printALLShifts(ArrayList<Turno> shiftList) {
		if (shiftList.isEmpty()) System.out.println("No hay turnos vacacionales!\n");
		else {
			SimpleDateFormat sdf = new SimpleDateFormat("d-M-yyyy");
			Iterator<Turno> it = shiftList.iterator();		
			while (it.hasNext()) {
				Turno t = it.next();
				System.out.println("\tDia vacacional:\t" + sdf.format(t.getDate().getTime()));
				System.out.println("\tTipo de turno:\t" + t.getShiftType());
				System.out.println("\tFecha especial:\t" + t.getSpecialDate());
				System.out.println("\tNum. doctores:\t" + t.getNumberOfDoctors() + "\n");
			}
		}
	}

	/**
	 * Muestra una lista de las fechas correspondientes a los dias vacacionales
	 * @param vacationDaylist Lista de las fechas de dias vacacionales
	 */
	private static void printVacationDayList(ArrayList<GregorianCalendar> vacationDaylist) {
		if (vacationDaylist.isEmpty()) System.out.println("No hay dias vacacionales!");
		else {
			SimpleDateFormat sdf = new SimpleDateFormat("d-M-yyyy");
			Iterator<GregorianCalendar> it = vacationDaylist.iterator();		
			while (it.hasNext()) {
				System.out.println(sdf.format(it.next().getTime()));
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Calendario c1 = new Calendario();
		Calendario c2 = new Calendario();
		int d,m,y;
		Scanner sc = new Scanner(System.in);
		String answer = "";
		boolean exit = false;
		boolean gotoMainMenu = true;
		int op;
		while(!exit){
			System.out.println();
			System.out.println("-- Menu Principal --\n");
			System.out.println(" 1: Calendario()");
			System.out.println(" 2: Calendario(int year)");
			System.out.println(" 3: Calendario(Calendario C)");
			System.out.println(" 4: void setCalendarYear(int year)");
			System.out.println(" 5: void addOneVacationDay(GregorianCalendar date)");
			System.out.println(" 6: void deleteOneVacationDay(GregorianCalendar date)");			
			System.out.println(" 7: int getCalendarYear()");
			System.out.println(" 8: Turno getShift(GregorianCalendar date, String shiftType)");
			System.out.println(" 9: ArrayList<Turno> getShiftsOfOneDay(GregorianCalendar date)");
			System.out.println("10: ArrayList<Turno> getALLShifts()");
			System.out.println("11: boolean existsVacationDay(GregorianCalendar date)");
			System.out.println("12: ArrayList<GregorianCalendar> getSubsetOfVacationDates()");
			System.out.println("13: ArrayList<GregorianCalendar> getALLVacationDates()");		
			System.out.println("14: int getTotalOfVacationDays()");
			System.out.println("15: int getTotalOfShifts()");
			System.out.println(" 0: Salir\n");


			op = sc.nextInt();

			switch(op){
			case 1:{
				System.out.println("1: Calendario()\n");
				c1 = new Calendario();
				System.out.println("\nSe ha creado el calendario c1!\n");
				break;
			}
			case 2:{
				System.out.println("2: Calendario(int year)\n");
				System.out.println("Introducir 'anio' del nuevo calendario:");
				int year = sc.nextInt();
				c1 = new Calendario(year);
				System.out.println("\nSe ha creado el calendario c1 del anio " + year + "!\n");
				break;
			}
			case 3:{
				System.out.println("3: Calendario(Calendario calendar)\n");
				c2 = new Calendario(c1);
				System.out.println("\nSe ha creado el calendario c2, que es copia del calendario c1!\n");
				break;
			}
			case 4:{
				System.out.println("4: void setCalendarYear(int year)\n");
				System.out.println("Introducir 'anio' para el calendario:\n");
				int year = sc.nextInt();
				c1.setCalendarYear(year);
				System.out.println("\nSe ha modificado el anio del calendario c1!\n");
				break;
			}
			case 5:{
				System.out.println("5: void addOneVacationDay(GregorianCalendar date)\n");
				gotoMainMenu = false;				
				while(!gotoMainMenu){
					System.out.println("Introducir 'fecha' del nuevo dia vacacional: {dd} {mm} {aaaa} (separados por espacios)");
					d = sc.nextInt();
					m = sc.nextInt();
					y = sc.nextInt();
					GregorianCalendar date = new GregorianCalendar(y,m-1,d);

					if (!c1.existsVacationDay(date)) {
						c1.addOneVacationDay(date);
						System.out.println("\nSe ha anadido el dia vacional " + d + "-" + m + "-" + y + " al calendario c1!\n");
						System.out.println("Dias vacacionales del calendario c1:");
						printVacationDayList(c1.getALLVacationDates());
					}
					else {
						System.out.println("\nEl dia vacacional " + d + "-" + m + "-" + y + " ya existe!\n");
					}
					System.out.println("Anadir otro dia vacacional? {s|n}: \n");
					answer = sc.next();
					while (!(answer.equals("s") || answer.equals("n"))) {
						System.out.println("Elegir una de las siguientes opciones:");
						System.out.println("s: Anadir dia vacacional     |     n: Volver al Menu Principal");
						answer = sc.next();
					}
					if (answer.equals("n")) gotoMainMenu = true;
				}
				break;
			}
			case 6:{
				System.out.println("6: deleteOneVacationDay(GregorianCalendar date)\n");
				System.out.println("Dias vacacionales del calendario c1:");
				printVacationDayList(c1.getALLVacationDates());
				gotoMainMenu = false;
				while(!gotoMainMenu){
					System.out.println("Introducir 'fecha' del dia vacacional que se va a eliminar: {dd} {mm} {aaaa} (separados por espacios)");
					d = sc.nextInt();
					m = sc.nextInt();
					y = sc.nextInt();
					GregorianCalendar date = new GregorianCalendar(y,m-1,d);
					if (c1.existsVacationDay(date)) {
						c1.deleteOneVacationDay(date);
						System.out.println("\nSe ha eliminado el dia vacional " + d + "-" + m + "-" + y + " del calendario c1!\n");
					}
					else {
						System.out.println("\nEl dia vacacional " + d + "-" + m + "-" + y + " no existe!\n");
					}
					System.out.println("Dias vacacionales del calendario c1:");
					printVacationDayList(c1.getALLVacationDates());
					System.out.println("Eliminar otro dia vacacional? {s|n}: \n");
					answer = sc.next();
					while (!(answer.equals("s") || answer.equals("n"))) {
						System.out.println("Elegir una de las siguientes opciones:");
						System.out.println("s: Eliminar dia vacacional     |     n: Volver al Menu Principal");
						answer = sc.next();
					}
					if (answer.equals("n")) gotoMainMenu = true;

				}
				break;
			}
			case 7:{
				System.out.println("7: int getCalendarYear()\n");
				int year = c1.getCalendarYear();
				if (year != -1) System.out.println("Anio del calendario c1: " + year + "\n");
				else System.out.println("No se ha definido el anio para el calendario c1!");

				break;
			}			
			case 8:{
				System.out.println("8: Turno getShift(GregorianCalendar date, String shiftType)\n");
				System.out.println("Introducir 'fecha' del turno: {dd} {mm} {aaaa} (separados por espacios)");
				d = sc.nextInt();
				m = sc.nextInt();
				y = sc.nextInt();
				GregorianCalendar date = new GregorianCalendar(y,m-1,d);
				if (!c1.existsVacationDay(date)) {
					System.out.print("\nEl turno no existe!\n");
				}
				else {
					System.out.println("Introducir 'tipo' del turno: {manana | tarde | noche}");
					String shiftType = sc.next();
					if (!shiftType.equals(shiftTypes[0]) && !shiftType.equals(shiftTypes[1]) && !shiftType.equals(shiftTypes[2])) {
						System.out.print("\nEl tipo de turno introducido no es correcto!\n");
					}
					else {
						Turno T = c1.getShift(date, shiftType);
						printShift(T);
					}
				}
				break;
			}
			case 9:{
				System.out.println("9: ArrayList<Turno> getShiftsOfOneDay(GregorianCalendar date)\n");
				System.out.println("Introducir 'fecha' del dia vacacional: {dd} {mm} {aaaa} (separados por espacios)");
				d = sc.nextInt();
				m = sc.nextInt();
				y = sc.nextInt();
				GregorianCalendar date = new GregorianCalendar(y,m-1,d);
				if (!c1.existsVacationDay(date)) {
					System.out.print("\nEl dia vacacional no existe!\n");
				}
				else {
					printShiftsOfOneDay(c1.getShiftsOfOneDay(date));
				}
				break;
			}
			case 10:{
				System.out.println("10: ArrayList<Turno> getALLShifts()");
				printALLShifts(c1.getALLShifts());
				break;
			}
			case 11:{
				System.out.println("11: existsVacationDay(GregorianCalendar date)\n");
				System.out.println("Introducir 'fecha' del dia vacacional que se quiere comprobar: {dd} {mm} {aaaa} (separados por espacios)");
				d = sc.nextInt();
				m = sc.nextInt();
				y = sc.nextInt();
				GregorianCalendar date = new GregorianCalendar(y,m-1,d);
				System.out.print("\nEl dia vacional " + d + "-" + m + "-" + y);
				if (c1.existsVacationDay(date)) System.out.println(" existe!\n");
				else System.out.println(" no existe!\n");
				break;
			}
			//			case 12:{
			//				System.out.println("12: ArrayList<GregorianCalendar> getSubsetOfVacationDates()\n");
			//				System.out.println("## NOP ##");
			//				break;
			//			}
			case 13:{
				System.out.println("13: ArrayList<GregorianCalendar> getALLVacationDates()\n");
				System.out.println("Dias vacacionales del calendario c1:");
				printVacationDayList(c1.getALLVacationDates());
				System.out.println("Dias vacacionales del calendario c2:");
				printVacationDayList(c2.getALLVacationDates());
				break;
			}
			case 14:{
				System.out.println("14: getNumberOfVacationDays()\n");
				System.out.println("Numero de dias vacacionales del calendario c1: " + c1.getNumberOfVacationDates());
				System.out.println("Numero de dias vacacionales del calendario c2: " + c2.getNumberOfVacationDates() + "\n");
				break;
			}
			case 15:{
				System.out.println("15: int getNumberOfShifts()\n");
				System.out.println("Numero de turnos del calendario c1: " + c1.getNumberOfShifts());
				System.out.println("Numero de turnos del calendario c2: " + c2.getNumberOfShifts() + "\n");
				break;
			}
			case 0:{
				System.out.println("Salir? {s|n}: \n");
				answer = sc.next();
				while (!(answer.equals("s") || answer.equals("n"))) {
					System.out.println("Elegir una de las siguientes opciones:");
					System.out.println("s: Salir     |     n: Continuar");
					answer = sc.next();
				}
				if (answer.equals("s")) exit = true;
				break;
			}
			default: {
				System.out.println("Opcion incorrecta o no disponible!\n");
				break;
			}
			}

			if (!exit) {
				System.out.println("Teclear c para continuar\n");
				answer = sc.next();
				while (!answer.equals("c")) {
					System.out.println("Teclear c para continuar\n");
					answer = sc.next();
				}
			}
		}
		sc.close();
	}
}
