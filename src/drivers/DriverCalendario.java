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
	 * @param Holidays Conjunto de días vacacionales
	 */
	private static void printALLHolidays(ArrayList<GregorianCalendar> Holidays) {
		System.out.println("Días vacacionales:");
		if (Holidays.isEmpty()) System.out.println("¡No hay días vacacionales actualmente!");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		Iterator<GregorianCalendar> it = Holidays.iterator();		
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

		Scanner kbrd = new Scanner(System.in);
		int op = -1;
		Calendario C = new Calendario(2000);
		while(op != 0){
			System.out.println("Operaciones de la clase Calendario");
			System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");		
			System.out.println(" 1: Calendario(int calendarYear)");
			System.out.println(" 2: Calendario(Calendario C)");
			System.out.println(" 3: void addHoliday(GregorianCalendar date)");
			System.out.println(" 4: void deleteHoliday(GregorianCalendar date)");
			System.out.println(" 5: void replaceShift(Turno T)");
			System.out.println(" 6: int getCalendarYear()");
			System.out.println(" 7: int getCalendarSize()");
			System.out.println(" 8: Turno getShift(GregorianCalendar date, String shiftType)");
			System.out.println(" 9: ArrayList<Turno> getShiftsOfADay(GregorianCalendar date)");
			System.out.println("10: ArrayList<Turno> getALLShifts()");
			System.out.println("11: boolean QueryByDate(GregorianCalendar date)");
			System.out.println("12: boolean QueryByDayOfYear(int dayOfYear)");
			System.out.println("13: ArrayList<GregorianCalendar> getHolidaysInARange()");
			System.out.println("14: ArrayList<GregorianCalendar> getALLHolidays()");		
			System.out.println("15: int getTotalHolidays()");
			System.out.println("16: int getTotalShifts()");
			System.out.println(" 0: EXIT\n");

			
			op = kbrd.nextInt();

			switch(op){
			case 1:{
				System.out.println("1: Calendario(int calendarYear)\n");
				System.out.println("Introducir el AÑO del nuevo calendario que se va a crear:\n");
				int year = kbrd.nextInt();
				C = new Calendario(year);
				break;
			}
			case 2:{
				System.out.println("2: Calendario(Calendario C)\n");
				System.out.println("## NOP ##");
				break;
			}
			case 3:{
				System.out.println("3: void addHoliday(GregorianCalendar date)\n");
				System.out.println("Introducir FECHA (DIA MES AÑO separados por espacios)");
				int d = kbrd.nextInt();
				int m = kbrd.nextInt();
				int a = kbrd.nextInt();
				GregorianCalendar date = new GregorianCalendar(a,m-1,d);
				C.addHoliday(date);
				break;
			}
			case 4:{
				System.out.println("4: void deleteHoliday(GregorianCalendar date)\n");
				System.out.println("Introducir FECHA (DIA MES AÑO separados por espacios)");
				int d = kbrd.nextInt();
				int m = kbrd.nextInt();
				int a = kbrd.nextInt();
				GregorianCalendar date = new GregorianCalendar(a,m-1,d);
				C.deleteHoliday(date);
				break;
			}
			case 5:{
				System.out.println("5: void replaceShift(Turno T)");
				System.out.println("Introducir FECHA (DIA MES AÑO separados por espacios)");
				int d = kbrd.nextInt();
				int m = kbrd.nextInt();
				int a = kbrd.nextInt();
				GregorianCalendar date = new GregorianCalendar(a,m-1,d);
				System.out.println("Introducir TIPO del turno:");
				String shiftType = kbrd.next();
				System.out.println("Introducir FECHA ESPECIAL del turno:");
				String specialDate = kbrd.next();
				System.out.println("Introducir NUM. DOCTORES del turno:");
				int numberOfDoctors = kbrd.nextInt();
				Turno T = new Turno(date, shiftType, specialDate, numberOfDoctors);
				C.replaceShift(T);
				break;
			}
			
			case 6:{
				System.out.println("6: int getCalendarYear()\n");
				System.out.println("Año del calendario actual: " + C.getCalendarYear());
				break;
			}
			
			case 7:{
				System.out.println("7: int getCalendarSize()\n");
				System.out.println("Número de días del calendario actual: " + C.getCalendarSize());
				break;
			}
			
			case 8:{
				System.out.println("8: Turno getShift(GregorianCalendar date, String shiftType\n");
				System.out.println("Introducir FECHA (DIA MES AÑO separados por espacios)");
				int d = kbrd.nextInt();
				int m = kbrd.nextInt();
				int a = kbrd.nextInt();
				GregorianCalendar date = new GregorianCalendar(a,m-1,d);
				System.out.println("Introducir TIPO del turno:\n");
				String shiftType = kbrd.next();
				Turno T = C.getShift(date, shiftType);
				printShift(T);
				break;
			}
			 
			case 9:{
				System.out.println("9: ArrayList<Turno> getShiftsOfADay(GregorianCalendar date)\n");
				System.out.println("## NOP ##");
				break;
			}
			
			case 10:{
				System.out.println("10: ArrayList<Turno> getALLShifts()\n");
				System.out.println("## NOP ##");
				break;
			}
			
			case 11:{
				System.out.println("11: boolean QueryByDate(GregorianCalendar date)\n");
				System.out.println("Introducir fecha (DIA MES AÑO separados por espacios)");
				int d = kbrd.nextInt();
				int m = kbrd.nextInt();
				int a = kbrd.nextInt();
				GregorianCalendar date = new GregorianCalendar(a,m-1,d);
				if (C.QueryByDate(date))
					System.out.println("La fecha introducida corresponde a un día vacacional\n");
				else
					System.out.println("La fecha introducida no corresponde a ningún día vacacional\n");
				break;
			}
			
			case 12:{
				System.out.println("12: boolean QueryByDayOfYear(int dayOfYear)\n");
				int day = kbrd.nextInt();
				if (C.QueryByDayOfYear(day))
					System.out.println("El día del año introducido corresponde a un día vacacional\n");
				else
					System.out.println("El día del año introducido no corresponde a ningún día vacacional\n");
				break;
			}
			
			case 14:{
				System.out.println("14: ArrayList<GregorianCalendar> getAllHolidays()\n");
				ArrayList<GregorianCalendar> Holidays = C.getALLHolidays();
				printALLHolidays(Holidays);
				break;
			}
			
			case 15:{
				System.out.println("15: int getTotalHolidays()\n");
				System.out.println("TOTAL de días vacacionales del calendario actual: " + C.getTotalHolidays());
				break;
			}
			
			case 16:{
				System.out.println("16: int getTotalShifts()\n");
				System.out.println("TOTAL de turnos del calendario actual: " + C.getTotalShifts());
				break;
			}

			default: {
				System.out.println("Opcion incorrecta");
				break;
			}
			}

			System.out.println();
			System.out.println("0: EXIT     |     1: CONTINUAR");
			System.out.println();

			op = kbrd.nextInt();

		}
		kbrd.close();
	}
}
