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
 * @author Felix Fernando Ramos Velázquez
 */
public class DriverCalendario {

	private static void printDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		System.out.print(date);
	}
		
	private static GregorianCalendar readDate() {
		int d, m, a;
		System.out.println("Introducir DIA MES AÑO (separados por espacios):");
		d = sc.nextInt();
		m = sc.nextInt();
		a = sc.nextInt();
		GregorianCalendar c = new GregorianCalendar(a,m-1,d);
		return c;
	}
	
	public void testGetShiftsOfOneDay() {
		
	}
	/**
	 * Muestra la información de 3 turnos, que corresponden a un día vacacional.
	 *
	 * @param <i>cv</i> es un calendario vacacional.
	 * @param <i>gc</i> es la fecha del día vacacional al que corresponden los turnos que se mostrarán.
	 */

	
	/**
	 * Muestra la información de un turno
	 * @param turno Turno del calendario vacacional
	 */
	public static void printShift(Turno turno) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		System.out.println("Fecha:\t\t" + sdf.format(turno.getDate().getTime()));
		System.out.println("Tipo:\t\t" + turno.getShiftType());
		System.out.println("Día especial:\t" + turno.getSpecialDate());
		System.out.println("Num. doctores:\t" + turno.getNumberOfDoctors());
	}

	/**
	 * Muestra el contenido de una lista de fechas que corresponden a días vacacionales
	 * @param VacationDaylist Lista de fechas
	 */
	private static void printVacationDayList(ArrayList<GregorianCalendar> VacationDaylist) {
		//System.out.println("Calendario: " + calendarYear);
		System.out.println("Días vacacionales:");
		if (VacationDaylist.isEmpty()) System.out.println("¡Lista vacía!");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		Iterator<GregorianCalendar> it = VacationDaylist.iterator();		
		while (it.hasNext()) {
			System.out.println(sdf.format(it.next().getTime()));
		}
		System.out.println();
	}
	
//	private static GregorianCalendar readDate() {
//		Scanner kbrd = new Scanner(System.in);
//		System.out.println("Introducir fecha (DIA MES AÑO separados por espacios)");
//		int d = kbrd.nextInt();
//		int m = kbrd.nextInt();
//		int a = kbrd.nextInt();
//		GregorianCalendar date = new GregorianCalendar(a,m-1,d);
//		kbrd.close();
//		return date;
//	}

	public static void main(String[] args) {

		ArrayList<Calendario> calendars;
		Scanner sc = new Scanner(System.in);

		//Calendario c1 = new Calendario(1999);
		//Calendario c2 = new Calendario(2000);
		int op = -1;
		while(op != 0){
			System.out.println();
			System.out.println("Menu Principal");
			System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
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
				System.out.println("1:Calendario();\n");
				testCalendario();
				break;
			}
			case 2:{
				System.out.println("2: Calendario(int calendarYear)\n");
				System.out.println("Introducir AÑO del nuevo calendario que se va a crear:\n");
				int year = sc.nextInt();
				c2 = new Calendario(year);
				break;
			}
			case 3:{
				System.out.println("3: Calendario(Calendario C)\n");
				c2 = new Calendario(c1);
				printVacationDayList(c2.getCalendarYear(), c2.getALLVacationDates());
				break;
			}
			case 4:{
				System.out.println("4: void setCalendarYear(int year)\n");
				System.out.println("Introducir AÑO del calendario:\n");
				int year = sc.nextInt();
				c1.setCalendarYear(year);;
				break;
			}
			case 5:{
				System.out.println("5: void addHoliday(GregorianCalendar date)\n");
				while(op != 1){
				c1.addOneVacationDay(readDate(sc));
				System.out.println();
				System.out.println("5: Añadir otra fecha     |     1: Volver al Menú Principal");
				op = sc.nextInt();
				}
				op  = -1;
				break;
			}
			case 6:{
				System.out.println("6: void deleteHoliday(GregorianCalendar date)\n");
				System.out.println("Introducir DIA MES AÑO (separados por espacios)");
				int d = sc.nextInt();
				int m = sc.nextInt();
				int a = sc.nextInt();
				GregorianCalendar date = new GregorianCalendar(a,m-1,d);
				c1.deleteOneVacationDay(date);
				break;
			}
			case 7:{
				System.out.println("7: int getCalendarYear()\n");
				System.out.println("Año del calendario actual: " + c1.getCalendarYear());
				break;
			}			
			case 8:{
				System.out.println("8: Turno getShift(GregorianCalendar date, String shiftType\n");
				System.out.println("Introducir DIA MES AÑO (separados por espacios)");
				int d = sc.nextInt();
				int m = sc.nextInt();
				int a = sc.nextInt();
				GregorianCalendar date = new GregorianCalendar(a,m-1,d);
				System.out.println("Introducir TIPO del turno:\n");
				String shiftType = sc.next();
				Turno T = c1.getShift(date, shiftType);
				printShift(T);
				break;
			}
			case 9:{
				System.out.println("9: ArrayList<Turno> getShiftsOfOneDay(GregorianCalendar date)\n");
				
				System.out.println("## NOP ##");
				break;
			}
			case 10:{
				System.out.println("10: ArrayList<Turno> getALLShifts()\n");
				System.out.println("## NOP ##");
				break;
			}
			case 11:{
				System.out.println("11: boolean existsVacationDay(GregorianCalendar date)\n");
				System.out.println("Introducir fecha (DIA MES AÑO separados por espacios)");
				int d = sc.nextInt();
				int m = sc.nextInt();
				int a = sc.nextInt();
				GregorianCalendar date = new GregorianCalendar(a,m-1,d);
				if (c1.existsVacationDay(date))
					System.out.println("La fecha introducida corresponde a un día vacacional\n");
				else
					System.out.println("La fecha introducida no corresponde a ningún día vacacional\n");
				break;
			}
			case 12:{
				System.out.println("12: ArrayList<GregorianCalendar> getSubsetOfVacationDates()\n");
				System.out.println("## NOP ##");
				break;
			}
			case 13:{
				System.out.println("13: ArrayList<GregorianCalendar> getALLVacationDates(GregorianCalendar date1, GregorianCalendar date2)\n");
				printVacationDayList(c1.getCalendarYear(), c1.getALLVacationDates());
				printVacationDayList(c2.getCalendarYear(), c2.getALLVacationDates());
				break;
			}
			case 14:{
				System.out.println("14: getNumberOfVacationDays()\n");
				System.out.println("Número de días vacacionales: ");
				break;
			}
			case 15:{
				System.out.println("15: int getNumberOfShifts()\n");
				System.out.println("Número de turnos: ");
				break;
			}
			default: {
				System.out.println("Opcion incorrecta");
				break;
			}
			}

//			System.out.println();
//			System.out.println("1: Volver al Menú Principal     |     0: Salir");
//			System.out.println();
//
//			op = sc.nextInt();

		}
		sc.close();
	}
}
