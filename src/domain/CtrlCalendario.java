package domain;

import model.Calendario;

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.IOException;


/**
 * Controladora de la clase Calendario
 * @author Felix Fernando Ramos Velazquez
 */
public class CtrlCalendario {
	private Calendario calendar;
	private static final String[] shiftTypes = {"manana","tarde","noche"};

	//-- Constructora --//
	/**
	 * Constructora por defecto
	 */
	public CtrlCalendario(Calendario C) {
		calendar = C;
	}

	/* Metodos publicos */

	public void addVacationDay(String fecha, int numDrsManana, int numDrsTarde, int numDrsNoche, String especialManana, String especialTarde, String especialNoche) {
		try {
			// checking input data
			SimpleDateFormat sdf = new SimpleDateFormat("d-M-yyyy");
			GregorianCalendar date = new GregorianCalendar();
			date.setTime(sdf.parse(fecha));
			if (!date.isLenient() || date.get(GregorianCalendar.YEAR) != calendar.getCalendarYear()) throw new IOException("La fecha no es correcta");
			else if (calendar.existsVacationDay(date)) throw new IOException("El dia vacacional ya existe");
			else if (numDrsManana < 0) throw new IOException("El numero de doctores del turno de manana no es correcto");
			else if (numDrsTarde < 0) throw new IOException("El numero de doctores del turno de tarde no es correcto");
			else if (numDrsNoche < 0) throw new IOException("El numero de doctores del turno de noche no es correcto");
			// making changes
			else {
				calendar.addVacationDay(date);
				calendar.getShift(date, shiftTypes[0]).setNumberOfDoctors(numDrsManana);
				calendar.getShift(date, shiftTypes[1]).setNumberOfDoctors(numDrsTarde);
				calendar.getShift(date, shiftTypes[2]).setNumberOfDoctors(numDrsNoche);
				calendar.getShift(date, shiftTypes[0]).setSpecialDate(especialManana);
				calendar.getShift(date, shiftTypes[1]).setSpecialDate(especialTarde);
				calendar.getShift(date, shiftTypes[2]).setSpecialDate(especialNoche);
			}

		}
		catch (ParseException e) {
			System.out.println("Formato de fecha incorrecto: " + e.toString());
		}
		catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
	}


	public void modifyVacationDay(String fecha, int numDrsManana, int numDrsTarde, int numDrsNoche, String especialManana, String especialTarde, String especialNoche) {
		try {
			// checking input data
			SimpleDateFormat sdf = new SimpleDateFormat("d-M-yyyy");
			GregorianCalendar date = new GregorianCalendar();
			date.setTime(sdf.parse(fecha));
			if (!date.isLenient() || date.get(GregorianCalendar.YEAR) != calendar.getCalendarYear()) throw new IOException("La fecha no es correcta");
			else if (!calendar.existsVacationDay(date)) throw new IOException("La fecha no corresponde a ningun dia vacacional");
			else if (numDrsManana < 0) throw new IOException("El numero de doctores del turno de manana no es correcto");
			else if (numDrsTarde < 0) throw new IOException("El numero de doctores del turno de tarde no es correcto");
			else if (numDrsNoche < 0) throw new IOException("El numero de doctores del turno de noche no es correcto");
			// making changes
			else {
				calendar.getShift(date, shiftTypes[0]).setNumberOfDoctors(numDrsManana);
				calendar.getShift(date, shiftTypes[1]).setNumberOfDoctors(numDrsTarde);
				calendar.getShift(date, shiftTypes[2]).setNumberOfDoctors(numDrsNoche);
				calendar.getShift(date, shiftTypes[0]).setSpecialDate(especialManana);
				calendar.getShift(date, shiftTypes[1]).setSpecialDate(especialTarde);
				calendar.getShift(date, shiftTypes[2]).setSpecialDate(especialNoche);
			}

		}
		catch (ParseException e) {
			System.out.println("Formato de fecha incorrecto: " + e.toString());
		}
		catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
	}

	public void deleteVacationDay(String fecha) {
		try {
			// checking input data
			SimpleDateFormat sdf = new SimpleDateFormat("d-M-yyyy");
			GregorianCalendar date = new GregorianCalendar();
			date.setTime(sdf.parse(fecha));
			if (!date.isLenient()) throw new IOException("La fecha no es correcta");
			else if (!calendar.existsVacationDay(date)) throw new IOException("La fecha no corresponde a ningun dia vacacional del calendario");

			// making changes
			else {
				calendar.deleteVacationDay(date);
			}

		}
		catch (ParseException e) {
			System.out.println("Formato de fecha incorrecto: " + e.toString());
		}
		catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
	}
}
