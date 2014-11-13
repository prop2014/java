package model;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Arrays;

/**
 * Representa un calendario
 * @author Felix Fernando Ramos Velázquez
 */
public class Calendario {
	//-- Atributos privados --//
	private int calendarYear; // año al que corresponde el calendario
	private boolean[] calendar;
	private TreeSet<Integer> holidays;
	private Turno[][] shifts;
	private static final String[] shiftsType = {"morning","afternoon","evening"};

	//-- Constructoras --//
	/**
	 * Constructora por defecto
	 * @param year Año al que corresponderá el calendario
	 */
	public Calendario(int calendarYear) {
		this.calendarYear = calendarYear;
		int calendarSize;
		GregorianCalendar gc = new GregorianCalendar();
		if (gc.isLeapYear(calendarYear)) calendarSize = 366; // comprueba si el año es bisiesto
		else calendarSize = 365;
		calendar = new boolean[calendarSize];
		Arrays.fill(calendar, false);
		holidays = new TreeSet<Integer>();
		shifts = new Turno[calendarSize][];
	}

	/**
	 * Constructora copia 
	 * @param C Calendario que se copiará
	 */
	public Calendario(Calendario C) {
		//mirate esto felix
		/*this.calendarYear = C.getCalendarYear();
		int calendarSize;
		GregorianCalendar gc = new GregorianCalendar();
		if (gc.isLeapYear(calendarYear)) calendarSize = 366; // comprueba si el año es bisiesto
		else calendarSize = 365;
		calendar = Arrays.copyOf(C.calendar, calendarSize);
		Arrays.fill(calendar, false);
		
		shifts = new Turno[calendarSize][];
		for (int i = 0; i < calendarSize; ++i) {
					if (C.calendar[i]) {
						holidays[i] = C.getShiftsOfDay(i);
						}
					}
		*/
		
		//		calendarYear = C.getCalendarYear();
		//		int calendarSize = C.getCalendarSize();
		//		calendar = Arrays.copyOf(C.calendar, calendarSize);
		//		for (int i = 0; i < calendarSize; ++i) {
		//			if (C.calendar[i]) {
		//				holidays[i] = Arrays.copyOf(C.holidays[i], C.holidays[i].length);
		//			}
		//		}
		//		totalHolidays = C.totalHolidays;
	}


	/* Métodos públicos */

	//-- Modificadoras --//
	/**
	 * Modificadora que añade un nuevo día vacacional al calendario
	 * @param date Fecha del día vacacional que se añadirá
	 */
	public void addHoliday(GregorianCalendar date) throws IllegalArgumentException {
		int index = date.get(GregorianCalendar.DAY_OF_YEAR) - 1;
		if (calendar[index])		
			throw new IllegalArgumentException("Error al añadir el dia vacacional: el dia vacacional ya existe\n");

		calendar[index] = true;
		Turno[] T = new Turno[3];		
		for (int i = 0; i < 3; ++i) {
			T[i] = new Turno();
			T[i].setDate(date);
			T[i].setSpecialDate(shiftsType[i]);;
		}
		shifts[index] = T;
		holidays.add(index);
	}

	/**
	 * Modificadora que elimina un día vacacional del calendario
	 * @param date Fecha del día vacacional que se eliminirá
	 */
	public void deleteHoliday(GregorianCalendar date) throws IllegalArgumentException {
				int index = date.get(GregorianCalendar.DAY_OF_YEAR) - 1;
				if (!calendar[index])		
					throw new IllegalArgumentException("Error al eliminar el dia vacacional: el dia vacacional no existe\n");
		
				calendar[index] = false;
				shifts[index] = null;
				holidays.remove(index);
	}

	/**
	 * Modificadora que reemplaza por T al turno del calendario que coincide con su misma fecha y su mismo tipo
	 * @param T Turno que reemplazará al turno existente
	 */
	public void replaceShift(Turno T) throws IllegalArgumentException {
				int index = T.getDate().get(GregorianCalendar.DAY_OF_YEAR) - 1;
				if (!calendar[index])		
					throw new IllegalArgumentException("Error al reemplazar el turno: la fecha del turno no corresponde a ningun dia vacacional\n");
		
				String shiftType = T.getShiftType();
				if (shiftType.equals(shiftsType[0]))
					shifts[index][0] = T;
				else if (shiftType.equals(shiftsType[1]))
					shifts[index][1] = T;
				else
					shifts[index][2] = T;
	}


	//-- Consultoras --//
	/**
	 * Consultora del año al que corresponde el calendario
	 * @return Año del calendario
	 */
	public int getCalendarYear() {
		return calendarYear;
	}

	/**
	 * Consultora del tamaño (num. de días) del calendario
	 * @return Tamaño del calendario
	 */
	public int getCalendarSize() {
		return calendar.length;
	}

	/**
	 * Consultora de un turno
	 * @param date Fecha del turno que se quiere consultar
	 * @param shiftType Tipo del turno que se quiere consultar. Ha de ser "morning", "afternoon" o "evening"
	 * @return Turno correspondiente a la fecha y el tipo solicitados.
	 */
	public Turno getShift(GregorianCalendar date, String shiftType) throws IllegalArgumentException {
		int index = date.get(GregorianCalendar.DAY_OF_YEAR) - 1;
		if (!calendar[index])		
			throw new IllegalArgumentException("Error al consultar el turno: el turno no existe\n");

		if (shiftType.equals(shiftsType[0])) return shifts[index][0];
		if (shiftType.equals(shiftsType[1])) return shifts[index][1];
		return shifts[index][2];
	}

	/**
	 * Consultora de los turnos de un día vacacional
	 * @param date Fecha correspondiente al día vacacional que se solicita
	 * @return Los 3 turnos del día vacacional solicitado
	 */
	public ArrayList<Turno> getShiftsOfDay(GregorianCalendar date) throws IllegalArgumentException {
		int index = date.get(GregorianCalendar.DAY_OF_YEAR) - 1;
		if (calendar[index])		
			throw new IllegalArgumentException("Error al consultar los turnos: el dia vacacional no existe.\n");

		ArrayList<Turno> Shifts = new ArrayList<Turno>(3);
		for (int i = 0; i < 3; ++i)
			Shifts.add(shifts[index][i]);

		return Shifts;
	}

	/**
	 * Consultora de TODOS los turnos
	 * @return Todos los turnos de días vacacionales
	 */
	public ArrayList<Turno> getALLShifts() {
		ArrayList<Turno> Shifts = new ArrayList<Turno>();
		Iterator<Integer> it = holidays.iterator();		
		while (it.hasNext()) {
			int index = it.next();
			for (int i = 0; i < 3; ++i) {
				Shifts.add(shifts[index][i]);
			}
		}
		return Shifts;
	}

	/**
	 * Dada una fecha, comprueba si dicha fecha corresponde a un día vacacional
	 * @param date Fecha
	 * @return True si la fecha corresponde a un día vacacional, False en caso contrario
	 */
	public boolean QueryByDate(GregorianCalendar date) {
		return calendar[date.get(GregorianCalendar.DAY_OF_YEAR)-1];
	}

	/**
	 * Dado un día del año, comprueba si dicho día corresponde a un día vacacional
	 * @param int Día del año [1..366]
	 * @return True si el día corresponde a un día vacacional, False en caso contrario
	 */
	public boolean QueryByDayOfYear(int dayOfYear) {
		return calendar[dayOfYear-1];
	}

	/**
	 * Consultora de todos los días vacacionales
	 * @return Las fechas de todos los días vacacionales
	 */
	public ArrayList<GregorianCalendar> getALLHolidays() {
		ArrayList<GregorianCalendar> Holidays = new ArrayList<GregorianCalendar>();
		Iterator<Integer> it = holidays.iterator();		
		while (it.hasNext()) {
			Holidays.add(shifts[it.next()][0].getDate());
		}

		return Holidays;
	}

	/**
	 * Consultora del número total de días vacacionales del calendario
	 * @return El número total de días vacacionales
	 */
	public int getTotalHolidays() {
		return holidays.size();
	}

	/**
	 * Consultora del número total de turnos de guardia del calendario
	 * @return El número total de turnos de guardia
	 */
	public int getTotalShifts() {
		return 3*holidays.size();
	}
}