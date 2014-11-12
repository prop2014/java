package model;

import java.util.GregorianCalendar;
import java.util.ArrayList;


/**
 * Representa un calendario
 * @author Felix Fernando Ramos Velázquez
 */
public class Calendario {
	//-- Atributos privados --//
	private int calYear; // año al que corresponde el calendario
	private ArrayList<ArrayList<Turno>> calendar;
	private int totalHolidays; // num. total de días vacacionales
	private static final String[] shifts = {"morning","afternoon","evening"};

	//-- Constructoras --//
	/**
	 * Constructora por defecto
	 * @param year Año al que corresponderá el calendario
	 */
	public Calendario(int calendarYear) {
		calYear = calendarYear;
		GregorianCalendar gc = new GregorianCalendar();
		if (gc.isLeapYear(calYear)) // comprueba si el año es bisiesto
			calendar  = new ArrayList<ArrayList<Turno>>(366);
		else
			calendar  = new ArrayList<ArrayList<Turno>>(365);
		totalHolidays = 0;
	}

	/**
	 * Constructora copia 
	 * @param C Calendario que se copiará
	 */
	public Calendario(Calendario C) {
		calYear = C.calYear;
		calendar  = new ArrayList<ArrayList<Turno>>(C.calendar.size());
		int calSize = calendar.size();
		for (int i = 0; i < calSize; ++i) {
			if (C.calendar.get(i) != null)
				calendar.add(i, new ArrayList<Turno>(3));
			for (int j = 0; j < 3; ++j)
				calendar.get(i).add(j, C.calendar.get(i).get(j));
		}
		totalHolidays = C.totalHolidays;
	}


	/* Métodos públicos */

	//-- Modificadoras --//
	/**
	 * Modificadora que añade un nuevo día vacacional al calendario
	 * @param date Fecha del día vacacional que se añadirá
	 */
	public void addHoliday(GregorianCalendar date) throws IllegalArgumentException {
		int index = date.get(GregorianCalendar.DAY_OF_YEAR) - 1;
		if (calendar.get(index) != null)		
			throw new IllegalArgumentException("Error al añadir el dia vacacional: el dia vacacional ya existe\n");

		calendar.add(index, new ArrayList<Turno>(3));
		for (int i = 0; i < 3; ++i) {
			calendar.get(index).get(i).setDate(date);
			calendar.get(index).get(i).setSpecialDate(shifts[i]);
		}
		++totalHolidays;
	}

	/**
	 * Modificadora que elimina un día vacacional del calendario
	 * @param date Fecha del día vacacional que se eliminirá
	 */
	public void deleteHoliday(GregorianCalendar date) throws IllegalArgumentException {
		int index = date.get(GregorianCalendar.DAY_OF_YEAR) - 1;
		if (calendar.get(index) == null)		
			throw new IllegalArgumentException("Error al eliminar el dia vacacional: el dia vacacional no existe\n");

		calendar.add(index, null);
		--totalHolidays;
	}

	/**
	 * Modificadora que reemplaza por T al turno del calendario que coincide con su misma fecha y su mismo tipo
	 * @param T Turno que reemplazará al turno existente
	 */
	public void replaceShift(Turno T) throws IllegalArgumentException {
		int index = T.getDate().get(GregorianCalendar.DAY_OF_YEAR) - 1;
		if (calendar.get(index) == null)		
			throw new IllegalArgumentException("Error al reemplazar el turno: la fecha del turno no corresponde a ningun dia vacacional\n");

		String shiftType = T.getShiftType();
		if (shiftType == "morning")
			calendar.get(index).add(0, T);
		else if (shiftType == "afternoon")
			calendar.get(index).add(1, T);
		else if (shiftType == "evening")
			calendar.get(index).add(2, T);
	}


	//-- Consultoras --//
	/**
	 * Consultora del año al que corresponde el calendario
	 * @return Año del calendario
	 */
	public int getCalendarYear() {
		return calYear;
	}

	/**
	 * Consultora de un turno
	 * @param date Fecha del turno que se quiere consultar
	 * @param shiftType Tipo del turno que se quiere consultar. Ha de ser "morning", "afternoon" o "evening"
	 * @return Turno correspondiente a la fecha y el tipo solicitados.
	 */
	public Turno getShift(GregorianCalendar date, String shiftType) throws IllegalArgumentException {
		int index = date.get(GregorianCalendar.DAY_OF_YEAR) - 1;
		if (calendar.get(index) == null)		
			throw new IllegalArgumentException("Error al consultar el turno: el turno no existe\n");

		if (shiftType == "morning") return calendar.get(index).get(0);
		else if (shiftType == "afternoon") return calendar.get(index).get(1);
		else return calendar.get(index).get(2);
	}

	/**
	 * Consultora de los turnos de un día vacacional
	 * @param date Fecha correspondiente al día vacacional que se solicita
	 * @return Los 3 turnos del día vacacional solicitado
	 */
	public ArrayList<Turno> getShiftsOfDay(GregorianCalendar date) throws IllegalArgumentException {
		int index = date.get(GregorianCalendar.DAY_OF_YEAR) - 1;
		if (calendar.get(index) == null)		
			throw new IllegalArgumentException("Error al consultar los turnos: el dia vacacional no existe.\n");

		ArrayList<Turno> arrayList = new ArrayList<Turno>(3);
		for (int i = 0; i < 3; ++i)
			arrayList.add(i, calendar.get(index).get(i));
		
		return arrayList;
	}

	/**
	 * Consultora de TODOS los turnos del calendario
	 * @return Los turnos correspondientes a cada uno de los días vacacionales
	 */
	public ArrayList<Turno> getAllShifts() {
		ArrayList<Turno> arrayList = new ArrayList<Turno>();
		int calSize = calendar.size();
		for (int i = 0; i < calSize; ++i) {
			if (calendar.get(i) != null) {
				for (int j = 0; j < 3; ++j)
					arrayList.add(calendar.get(i).get(j));
			}
		}
		
		return arrayList;
	}

	/**
	 * Consulta si existe un determinado día vacacional
	 * @param date Fecha del día vacacional
	 * @return True si existe el día vacacional especificado, False en caso contrario
	 */
	public boolean existsHoliday(GregorianCalendar date) {
		int index = date.get(GregorianCalendar.DAY_OF_YEAR) - 1;
		return calendar.get(index) != null;
	}

	/**
	 * Consultora de todos los días vacacionales
	 * @return Las fechas de todos los días vacacionales
	 */
	public ArrayList<GregorianCalendar> getAllHolidays() {
		ArrayList<GregorianCalendar> arrayList = new ArrayList<GregorianCalendar>();
		int calSize = calendar.size();
		for (int i = 0; i < calSize; ++i) {
			if (calendar.get(i) != null)
				arrayList.add(calendar.get(i).get(0).getDate());
		}

		return arrayList;
	}

	/**
	 * Consultora del número total de días vacacionales del calendario
	 * @return El número total de días vacacionales
	 */
	public int getNumberOfDays() {
		return totalHolidays;
	}

	/**
	 * Consultora del número total de turnos de guardia del calendario
	 * @return El número total de turnos de guardia
	 */
	public int getNumberOfShifts() {
		return totalHolidays*3;
	}
}