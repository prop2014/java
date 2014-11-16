package drivers;

import java.util.GregorianCalendar;
import java.util.Scanner;

import model.Calendario;
import model.Turno;

public class DriverCtrlCalendario {

	public static void main(String[] args) {
		Calendario c1 = new Calendario(1999);
		Calendario c2 = new Calendario(2000);
		int d,m,y;
		Scanner sc = new Scanner(System.in);
		String answer;
		boolean exit = false;
		int op;
		
		while(!exit){
			System.out.println();
			System.out.println("-- Menu Principal --\n");
			System.out.println(" 1: Calendario(int year)");
			System.out.println(" 2: Calendario(Calendario C)");
			System.out.println(" 3: void addVacationDay(GregorianCalendar date)");
			System.out.println(" 4: void deleteVacationDay(GregorianCalendar date)");			
			System.out.println(" 5: int getCalendarYear()");
			System.out.println(" 6: Turno getShift(GregorianCalendar date, String shiftType)");
			System.out.println(" 7: ArrayList<Turno> getShiftsOfADay(GregorianCalendar date)");
			System.out.println(" 8: ArrayList<Turno> getALLShifts()");
			System.out.println(" 9: boolean existsVacationDay(GregorianCalendar date)");
			System.out.println("10: ArrayList<GregorianCalendar> getALLVacationDates()");		
			System.out.println("11: int getTotalOfVacationDays()");
			System.out.println("12: int getTotalOfShifts()");
			System.out.println(" 0: Salir\n");

			op = sc.nextInt();

			switch(op){
			case 1:{
				System.out.println("1: Calendario(int year)\n");
				System.out.println("Introducir 'anio' del nuevo calendario:");
				int year = sc.nextInt();
				c1 = new Calendario(year);
				System.out.println("\nSe ha creado el calendario c1 del anio " + year + "!\n");
				break;
			}
			case 2:{
				System.out.println("2: Calendario(Calendario calendar)\n");
				c2 = new Calendario(c1);
				System.out.println("\nSe ha creado el calendario c2, que es copia del calendario c1!\n");
				break;
			}
			case 3:{
				System.out.println("3: void addVacationDay(GregorianCalendar date)\n");
				boolean gotoMainMenu = false;				
				while(!gotoMainMenu){
					System.out.println("Introducir 'fecha' del nuevo dia vacacional: {dd} {mm} {aaaa} (separados por espacios)");
					d = sc.nextInt();
					m = sc.nextInt();
					y = sc.nextInt();
					GregorianCalendar date = new GregorianCalendar(y,m-1,d);

					if (!c1.existsVacationDay(date)) {
						c1.addVacationDay(date);
						System.out.println("\nSe ha anadido el dia vacional " + d + "-" + m + "-" + y + " al calendario c1!\n");
						System.out.println("-- Dias vacacionales del calendario c1 --");
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
			case 4:{
				System.out.println("4: deleteVacationDay(GregorianCalendar date)\n");
				System.out.println("Dias vacacionales del calendario c1:");
				printVacationDayList(c1.getALLVacationDates());
				boolean gotoMainMenu = false;
				while(!gotoMainMenu){
					System.out.println("Introducir 'fecha' del dia vacacional que se va a eliminar: {dd} {mm} {aaaa} (separados por espacios)");
					d = sc.nextInt();
					m = sc.nextInt();
					y = sc.nextInt();
					GregorianCalendar date = new GregorianCalendar(y,m-1,d);
					if (c1.existsVacationDay(date)) {
						c1.deleteVacationDay(date);
						System.out.println("\nSe ha eliminado el dia vacional " + d + "-" + m + "-" + y + " del calendario c1!\n");
					}
					else {
						System.out.println("\nEl dia vacacional " + d + "-" + m + "-" + y + " no existe!\n");
					}
					System.out.println("-- Dias vacacionales del calendario c1 --");
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
			case 5:{
				System.out.println("5: int getCalendarYear()\n");
				int year = c1.getCalendarYear();
				if (year != -1) System.out.println("Anio del calendario c1: " + year + "\n");
				else System.out.println("No se ha definido el anio para el calendario c1!");

				break;
			}			
			case 6:{
				System.out.println("6: Turno getShift(GregorianCalendar date, String shiftType)\n");
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
			case 7:{
				System.out.println("7: ArrayList<Turno> getShiftsOfADay(GregorianCalendar date)\n");
				System.out.println("Introducir 'fecha' del dia vacacional: {dd} {mm} {aaaa} (separados por espacios)");
				d = sc.nextInt();
				m = sc.nextInt();
				y = sc.nextInt();
				GregorianCalendar date = new GregorianCalendar(y,m-1,d);
				if (!c1.existsVacationDay(date)) {
					System.out.print("\nEl dia vacacional no existe!\n");
				}
				else {
					printShiftsOfADay(c1.getShiftsOfADay(date));
				}
				break;
			}
			case 8:{
				System.out.println("8: ArrayList<Turno> getALLShifts()\n");
				System.out.println("-- Turnos del calendario c1 --");
				printALLShifts(c1.getALLShifts());
				System.out.println("-- Turnos del calendario c2 --");
				printALLShifts(c2.getALLShifts());
				break;
			}
			case 9:{
				System.out.println("9: existsVacationDay(GregorianCalendar date)\n");
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
			case 10:{
				System.out.println("10: ArrayList<GregorianCalendar> getALLVacationDates()\n");
				System.out.println("-- Dias vacacionales del calendario c1 --");
				printVacationDayList(c1.getALLVacationDates());
				System.out.println("-- Dias vacacionales del calendario c2 --");
				printVacationDayList(c2.getALLVacationDates());
				break;
			}
			case 11:{
				System.out.println("11: getNumberOfVacationDays()\n");
				System.out.println("Numero de dias vacacionales del calendario c1: " + c1.getNumberOfVacationDates());
				System.out.println("Numero de dias vacacionales del calendario c2: " + c2.getNumberOfVacationDates() + "\n");
				break;
			}
			case 12:{
				System.out.println("12: int getNumberOfShifts()\n");
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
		System.out.println("-- fin del programa --");
	}

	}

}
