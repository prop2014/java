package drivers;

import model.Turno;
import model.Calendario;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 * Driver de la clase Calendario
 * @author Felix Fernando Ramos Velazquez
 */
public class DriverCalendario {

	//	private static void printDate(Date date) {
	//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	//		System.out.print(date);
	//	}
	//		
	//	private static GregorianCalendar readDate() {
	//		int d, m, a;
	//		System.out.println("Introducir DIA MES AÃ‘O (separados por espacios):");
	//		d = sc.nextInt();
	//		m = sc.nextInt();
	//		a = sc.nextInt();
	//		GregorianCalendar c = new GregorianCalendar(a,m-1,d);
	//		return c;
	//	}

	public void testGetShiftsOfOneDay() {

	}
	//	/**
	//	 * Muestra la informaciÃ³n de 3 turnos, que corresponden a un dÃ­a vacacional.
	//	 *
	//	 * @param <i>cv</i> es un calendario vacacional.
	//	 * @param <i>gc</i> es la fecha del dÃ­a vacacional al que corresponden los turnos que se mostrarÃ¡n.
	//	 */
	//
	//	
	//	/**
	//	 * Muestra la informaciÃ³n de un turno
	//	 * @param turno Turno del calendario vacacional
	//	 */
	//	public static void printShift(Turno turno) {
	//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	//		System.out.println("Fecha:\t\t" + sdf.format(turno.getDate().getTime()));
	//		System.out.println("Tipo:\t\t" + turno.getShiftType());
	//		System.out.println("DÃ­a especial:\t" + turno.getSpecialDate());
	//		System.out.println("Num. doctores:\t" + turno.getNumberOfDoctors());
	//	}
	//
	//	/**
	//	 * Muestra el contenido de una lista de fechas que corresponden a dÃ­as vacacionales
	//	 * @param VacationDaylist Lista de fechas
	//	 */
	private static void printVacationDayList(ArrayList<GregorianCalendar> VacationDaylist) {
		if (VacationDaylist.isEmpty()) System.out.println("¡No hay dias vacacionales!");
		else {
			SimpleDateFormat sdf = new SimpleDateFormat("d-M-yyyy");
			Iterator<GregorianCalendar> it = VacationDaylist.iterator();		
			while (it.hasNext()) {
				System.out.println(sdf.format(it.next().getTime()));
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Calendario c1 = new Calendario();
		Calendario c1_copy = new Calendario();

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
			System.out.println("14: int getNumberOfVacationDays()");
			System.out.println("15: int getNumberOfShifts()");
			System.out.println(" 0: Salir\n");


			op = sc.nextInt();

			switch(op){
			case 1:{
				System.out.println("1: Calendario()");
				c1 = new Calendario();
				System.out.println("\n¡Se ha creado el calendario c1!\n");
				break;
			}
			case 2:{
				System.out.println("2: Calendario(int year)");
				System.out.println("Introducir 'año' del nuevo calendario:");
				int year = sc.nextInt();
				c1 = new Calendario(year);
				System.out.println("\n¡Se ha creado el calendario c1 del año " + year + "!\n");
				break;
			}
			case 3:{
				System.out.println("3: Calendario(Calendario calendar)");
				c1_copy = new Calendario(c1);
				System.out.println("\n¡Se ha creado el calendario c1_copy!\n");
				break;
			}
			case 4:{
				System.out.println("4: void setCalendarYear(int year)");
				System.out.println("Introducir 'año' para el calendario:\n");
				int year = sc.nextInt();
				c1.setCalendarYear(year);
				System.out.println("\n¡Se ha modificado el año del calendario c1!\n");
				break;
			}
			case 5:{
				System.out.println("5: void addOneVacationDay(GregorianCalendar date)");
				gotoMainMenu = false;
				int d,m,y;
				while(!gotoMainMenu){
					System.out.println("Introducir 'fecha' del nuevo dia vacacional: {dd} {mm} {aaaa} (separados por espacios)");
					d = sc.nextInt();
					m = sc.nextInt();
					y = sc.nextInt();
					GregorianCalendar date = new GregorianCalendar(y,m-1,d);

					if (!c1.existsVacationDay(date)) {
						c1.addOneVacationDay(date);
						System.out.println("\n¡Se ha añadido el dia vacional " + d + "-" + m + "-" + y + " al calendario c1!\n");
						System.out.println("Dias vacacionales del calendario c1:");
						printVacationDayList(c1.getALLVacationDates());
					}
					else {
						System.out.println("\n¡El dia vacacional " + d + "-" + m + "-" + y + " ya existe!\n");
					}
					System.out.println("¿Añadir otro dia vacacional? {s|n}: \n");
					answer = sc.next();
					while (!(answer.equals("s") || answer.equals("n"))) {
						System.out.println("Elegir una de las siguientes opciones:");
						System.out.println("s: Añadir dia vacacional     |     n: Volver al Menu Principal");
						answer = sc.next();
					}
					if (answer.equals("n")) gotoMainMenu = true;
				}
				break;
			}
			case 6:{
				System.out.println("6: deleteOneVacationDay(GregorianCalendar date)");
				System.out.println("Dias vacacionales del calendario c1:");
				printVacationDayList(c1.getALLVacationDates());
				gotoMainMenu = false;
				int d,m,y;
				while(!gotoMainMenu){
					System.out.println("Introducir 'fecha' del dia vacacional que se quiere eliminar: {dd} {mm} {aaaa} (separados por espacios)");
					d = sc.nextInt();
					m = sc.nextInt();
					y = sc.nextInt();
					GregorianCalendar date = new GregorianCalendar(y,m-1,d);
					if (c1.existsVacationDay(date)) {
						c1.deleteOneVacationDay(date);
						System.out.println("\n¡Se ha eliminado el dia vacional " + d + "-" + m + "-" + y + " del calendario c1!\n");
					}
					else {
						System.out.println("\n¡El dia vacacional " + d + "-" + m + "-" + y + " no existe!\n");
					}
					System.out.println("Dias vacacionales del calendario c1:");
					printVacationDayList(c1.getALLVacationDates());
					System.out.println("¿Eliminar otro dia vacacional? {s|n}: \n");
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
				if (year != -1) System.out.println("Año del calendario c1: " + year + "\n");
				else System.out.println("¡No se ha definido un año para c1!");
					
				break;
			}			
			//			case 8:{
			//				System.out.println("8: Turno getShift(GregorianCalendar date, String shiftType\n");
			//				System.out.println("Introducir DIA MES AÃ‘O (separados por espacios)");
			//				int d = sc.nextInt();
			//				int m = sc.nextInt();
			//				int a = sc.nextInt();
			//				GregorianCalendar date = new GregorianCalendar(a,m-1,d);
			//				System.out.println("Introducir TIPO del turno:\n");
			//				String shiftType = sc.next();
			//				Turno T = c1.getShift(date, shiftType);
			//				printShift(T);
			//				break;
			//			}
			//			case 9:{
			//				System.out.println("9: ArrayList<Turno> getShiftsOfOneDay(GregorianCalendar date)\n");
			//				
			//				System.out.println("## NOP ##");
			//				break;
			//			}
			//			case 10:{
			//				System.out.println("10: ArrayList<Turno> getALLShifts()\n");
			//				System.out.println("## NOP ##");
			//				break;
			//			}
			case 11:{
				System.out.println("11: existsVacationDay(GregorianCalendar date)");
				int d,m,y;
				System.out.println("Introducir 'fecha' del dia vacacional que se quiere comprobar: {dd} {mm} {aaaa} (separados por espacios)");
				d = sc.nextInt();
				m = sc.nextInt();
				y = sc.nextInt();
				GregorianCalendar date = new GregorianCalendar(y,m-1,d);
				System.out.print("\n¡El dia vacional " + d + "-" + m + "-" + y);
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
				System.out.println("Dias vacacionales del calendario c1_copy:");
				printVacationDayList(c1_copy.getALLVacationDates());
				break;
			}
			//			case 14:{
			//				System.out.println("14: getNumberOfVacationDays()\n");
			//				System.out.println("NÃºmero de dÃ­as vacacionales: ");
			//				break;
			//			}
			//			case 15:{
			//				System.out.println("15: int getNumberOfShifts()\n");
			//				System.out.println("NÃºmero de turnos: ");
			//				break;
			//			}
			case 0:{
				System.out.println("¿Salir? {s|n}: \n");
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
				System.out.println("Opcion incorrecta");
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
