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
 * @author Felix Fernando Ramos Velázquez
 */
public class DriverCalendario {

	/**
	 * Muestra por pantalla la información de 3 turnos, que corresponden a un día vacacional.
	 *
	 * @param <i>cv</i> es un calendario vacacional.
	 * @param <i>gc</i> es la fecha del día vacacional al que corresponden los turnos que se mostrarán.
	 */
	public static void printHoliday(Calendario C, GregorianCalendar date)
	{
		//		if(!cv.existsDiaVacacional(gc)){
		//			System.out.println("El día vacacional solicitado no existe");
		//		}
		//		else{
		//			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		//			String date = sdf.format(gc.getTime());
		//			String especial;
		//			System.out.println("** Día vacacional " + date + " **");
		//			System.out.println("---------------------------------");
		//			printTurno(cv.getTurno(gc, "m"));
		////			
		////			System.out.println("- num. doctores: " + c.getTurno(d, "m").getNumDoctores());
		////			especial = c.getTurno(d, "m").getEspecial();
		////			if(especial != null){
		////			System.out.println("- día especial: "+ c.getTurno(d, "m").getEspecial());
		////			}
		//			System.out.println("---------------------------------");
		//			System.out.println("Turno de tarde");
		//			System.out.println("- num. doctores: "+ cv.getTurno(gc, "t").getNumDoctores());
		//			especial = cv.getTurno(gc, "t").getEspecial();
		//			if(especial != null){
		//			System.out.println("- día especial: "+ cv.getTurno(gc, "t").getEspecial());
		//			}
		//			System.out.println("---------------------------------");
		//			System.out.println("Turno de noche");
		//			System.out.println("- num. doctores: "+ cv.getTurno(gc, "n").getNumDoctores());
		//			especial = cv.getTurno(gc, "n").getEspecial();
		//			if(especial != null){
		//			System.out.println("- día especial: "+ cv.getTurno(gc, "n").getEspecial());
		//			}
		//			System.out.println("---------------------------------\n");
		//		}
	}
	
	/**
	 * Muestra la información de un turno
	 * @param T Turno del calendario que se mostrará
	 */
	public static void printShift(Turno T) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		System.out.println("Fecha:\t\t" + sdf.format(T.getDate().getTime()));
		System.out.println("Tipo:\t\t" + T.getShiftType());
		System.out.println("Día especial:\t" + T.getSpecialDate());
		System.out.println("Num. doctores:\t" + T.getNumberOfDoctors());
	}

	/**
	 * Muestra la lista de todos los días vacacionales
	 * @param VacationDaylist Conjunto de días vacacionales
	 */
	private static void printVacationDayList(int calendarYear, ArrayList<GregorianCalendar> VacationDaylist) {
		System.out.println("Calendario: " + calendarYear);
		System.out.println("Días vacacionales:");
		if (VacationDaylist.isEmpty()) System.out.println("¡No hay días vacacionales actualmente!");
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

		Scanner sc = new Scanner(System.in);
		int op = -1;
		Calendario c1 = new Calendario(1999);
		Calendario c2 = new Calendario(2000);
		
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
			System.out.println("14: int getTotalOfVacationDates()");
			System.out.println("15: int getTotalOfShifts()");
			System.out.println(" 0: Salir\n");

			
			op = sc.nextInt();

			switch(op){
			case 1:{
				System.out.println("1: Calendario()\n");
				c1 = new Calendario();
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
				System.out.println("Introducir DIA MES AÑO (separados por espacios)");
				int d = sc.nextInt();
				int m = sc.nextInt();
				int a = sc.nextInt();
				GregorianCalendar date = new GregorianCalendar(a,m-1,d);
				c1.addOneVacationDay(date);
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
				System.out.println("14: getTotalOfVacationDates()\n");
				System.out.println("TOTAL de días vacacionales del calendario actual: " + c1.getTotalOfVacationDates());
				System.out.println("TOTAL de días vacacionales del calendario actual: " + c2.getTotalOfVacationDates());
				break;
			}
			case 15:{
				System.out.println("15: int getTotalOfShifts()\n");
				System.out.println("TOTAL de turnos del calendario actual: " + c1.getTotalOfShifts());
				break;
			}
			default: {
				System.out.println("Opcion incorrecta");
				break;
			}
			}

			System.out.println();
			System.out.println("0: Salir     |     1: Ir a Menu Principal");
			System.out.println();

			op = sc.nextInt();

		}
		sc.close();
	}
}
