package model;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Iterator;

/**
 * Representa un calendario
 * @author Felix Fernando Ramos Velazquez
 */
public class Calendario {
	//-- Atributos privados --//
	private int calendarYear; // año al que corresponde el calendario
	private TreeMap<Integer,Turno[]> vacationDates;
	private static int shiftsPerDay = 3;
	private static final String[] shiftTypes = {"morning","afternoon","evening"};

	//-- Constructoras --//
	/**
	 * Constructora por defecto
	 */
	public Calendario() {
		calendarYear = -1;
		vacationDates = new TreeMap<Integer,Turno[]>();
	}

	/**
	 * Constructora con argumento
	 * @param year Ano del calendario
	 */
	public Calendario(int year) {
		calendarYear = year;
		vacationDates = new TreeMap<Integer,Turno[]>();
	}

	/**
	 * Constructora copia 
	 * @param calendar Calendario que se copiara
	 */
	public Calendario(Calendario calendar) {
		calendarYear = calendar.getCalendarYear();		
		vacationDates = new TreeMap<Integer,Turno[]>();		
		Iterator<Integer> it = calendar.vacationDates.keySet().iterator();		
		while (it.hasNext()) {
			Integer key = it.next();
			Turno[] T = new Turno[shiftsPerDay];
			T = calendar.vacationDates.get(key);
			vacationDates.put(key,T);
		}
	}


	/* Métodos públicos */

	//-- Modificadoras --//
	/**
	 * Modificadora del ano del calendario
	 * pre: El calendario esta vacio
	 * @param year Ano del calendario
	 */
	public void setCalendarYear(int year) {
		calendarYear = year;
	}

	/**
	 * Modificadora que a�ade un nuevo d�a vacacional al calendario
	 * @param date Fecha del d�a vacacional que se a�adir�
	 */
	public void addOneVacationDay(GregorianCalendar date) {
		int key = date.get(GregorianCalendar.DAY_OF_YEAR) - 1;
		Turno[] t = new Turno[shiftsPerDay];		
		for (int i = 0; i < shiftsPerDay; ++i)
			t[i] = new Turno(date,shiftTypes[i]);
		vacationDates.put(key,t);
	}

	/**
	 * Modificadora que elimina un día vacacional del calendario
	 * @param date Fecha del día vacacional que se eliminirá
	 */
	public void deleteOneVacationDay(GregorianCalendar date) {
		int key = date.get(GregorianCalendar.DAY_OF_YEAR) - 1;
		vacationDates.remove(key);
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
	 * Consultora de un turno 
	 * @param date Fecha del turno
	 * @param shiftType Tipo del turno {"morning" | "afternoon" | "evening"}
	 * @return Turno correspondiente a la fecha y tipo indicados
	 */
	public Turno getShift(GregorianCalendar date, String shiftType) {
		int key = date.get(GregorianCalendar.DAY_OF_YEAR) - 1;
		if (shiftType.equals(shiftTypes[0])) return vacationDates.get(key)[0];
		if (shiftType.equals(shiftTypes[1])) return vacationDates.get(key)[1];
		return vacationDates.get(key)[2];
	}

	/**
	 * Consultora de los tres turnos de un día vacacional
	 * @param date Fecha del día vacacional
	 * @return Lista con los tres turnos
	 */
	public ArrayList<Turno> getShiftsOfOneDay(GregorianCalendar date) {
		int key = date.get(GregorianCalendar.DAY_OF_YEAR) - 1;
		ArrayList<Turno> shiftsList = new ArrayList<Turno>(shiftsPerDay);
		for (int i = 0; i < shiftsPerDay; ++i)
			shiftsList.add(vacationDates.get(key)[i]);

		return shiftsList;
	}

	/**
	 * Consultora de todos los turnos del calendario vacacional
	 * @return Lista con todos los turnos
	 */
	public ArrayList<Turno> getALLShifts() {
		ArrayList<Turno> shiftsList = new ArrayList<Turno>();
		Iterator<Integer> it = vacationDates.keySet().iterator();		
		while (it.hasNext()) {
			int key = it.next();
			for (int i = 0; i < shiftsPerDay; ++i) {
				shiftsList.add(vacationDates.get(key)[i]);
			}
		}
		return shiftsList;
	}

	/**
	 * Comprueba si existe un día vacacional en una fecha dada
	 * @param date Fecha del día vacacional
	 * @return True si el día vacacional existe, False en caso contrario
	 */
	public boolean existsVacationDay(GregorianCalendar date) {
		return vacationDates.containsKey(date.get(GregorianCalendar.DAY_OF_YEAR) - 1);
	}

	/**
	 * Consultora de todas las fechas del calendario vacacional
	 * @return Lista con todas las fechas
	 */
	public ArrayList<GregorianCalendar> getALLVacationDates() {
		ArrayList<GregorianCalendar> datesList = new ArrayList<GregorianCalendar>();
		Iterator<Integer> it = vacationDates.keySet().iterator();		
		while (it.hasNext()) 
			datesList.add(vacationDates.get(it.next())[0].getDate());
		return datesList;
	}

	/**
	 * Consultora del número total de días vacacionales
	 * @return El número total de días
	 */
	public int getTotalOfVacationDates() {
		return vacationDates.size();
	}

	/**
	 * Consultora del número total de turnos de días vacacionales
	 * @return El número total de turnos
	 */
	public int getTotalOfShifts() {
		return 3*vacationDates.size();
	}
}