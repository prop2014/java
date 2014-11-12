package model;

import java.util.GregorianCalendar;

/**
 * Representa un turno de guardia
 * @author Felix Fernando Ramos Velázquez
 */
public class Turno {
	//-- Atributos privados --//
	private GregorianCalendar date;
	private String shiftType;
	private String specialDate;
	private int numberOfDoctors;

	
	//-- Constructoras --//
	/**
	 * Constructora por defecto
	 */
	public Turno() {
		date = null;
		shiftType = null;
		specialDate = null;
		numberOfDoctors = 0;
	}

	/**
	 * Constructora copia
	 * @param T Turno que se copiará
	 */
	public Turno(Turno T) {
		date = T.date;
		shiftType = T.shiftType;
		specialDate = T.specialDate;
		numberOfDoctors = T.numberOfDoctors;
	}
	
	/**
	 * Constructora completa
	 * @param date Fecha del turno
	 * @param shiftType Tipo del turno
	 * @param specialDate Fecha especial
	 * @param numberOfDoctors Número de doctores del turno
	 */
	public Turno (GregorianCalendar date, String shiftType, String specialDate, int numberOfDoctors) {
		this.date = date;
		this.shiftType = shiftType;
		this.specialDate = specialDate;
		this.numberOfDoctors = numberOfDoctors;
	}
	
	
	/* Metodos públicos */
	
	//-- Modificadoras --//
	/**
	 * Modifica la fecha del turno
	 * @param date Fecha del turno
	 */
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	/**
	 * Modifica el tipo del turno
	 * @param shiftType Tipo del turno
	 */
	public void setShiftType(String shiftType) {
		this.shiftType = shiftType;
	}

	/**
	 * Modifica el tipo de fecha especial del turno
	 * @param specialDate Tipo de fecha especial
	 */
	public void setSpecialDate(String specialDate) {
		this.specialDate = specialDate;
	}

	/**
	 * Modifica el número de doctores del turno
	 * @param numberOfDoctors Número de doctores
	 */
	public void setNumberOfDoctors(int numberOfDoctors) {
		this.numberOfDoctors = numberOfDoctors;
	}

	
	//-- Consultoras --//
	/**
	 * Consultora de la fecha del turno
	 * @return La fecha del turno
	 */
	public GregorianCalendar getDate() {
		return date;
	}

	/**
	 * Consultora del tipo del turno
	 * @return El tipo del turno
	 */
	public String getShiftType() {
		return shiftType;
	}

	/**
	 * Consultora del tipo de fecha especial del turno
	 * @return El tipo de fecha especial
	 */
	public String getSpecialDate() {
		return specialDate;
	}

	/**
	 * Consultora del número de doctores del turno
	 * @return El número de doctores
	 */
	public int getNumberOfDoctors() {
		return numberOfDoctors;
	}
}