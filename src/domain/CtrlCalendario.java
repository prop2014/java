package domain;

import model.Calendario;
import model.Turno;

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import data.CtrlDatosFichero;


/**
 * Controladora de la clase Calendario
 * @author Felix Fernando Ramos Velazquez
 */
public class CtrlCalendario {
	private Calendario calendar;
	private static final String[] shiftTypes = {"manana","tarde","noche"};
	private CtrlDatosFichero inOut;
	//-- Constructora --//
	/**
	 * Constructora por defecto
	 */
	public CtrlCalendario(Calendario C) {
		calendar = C;
	}
	
	
	/* Metodos publicos */
	/** Crea un calendario comprovando errores de fechas
	 * @param id identificador del Hospital
	 * @throws IOException fichero incorrecto
	 */
	public void getDataCalendar (int id) throws IOException{
		ArrayList<String> alcale =new ArrayList<String>();
		if(inOut.existsCalendar(id)){
			alcale=inOut.getDataCale(id);
		}
		if(!alcale.isEmpty()){
			int year = Integer.parseInt(alcale.get(0));
			int size=Integer.parseInt(alcale.get(1));
			int dia,mes,any,numDrsManana,numDrsTarde,numDrsNoche;
			String specialManana;
			String specialTarde;
			String specialNoche;
			
				int j=2;
			for (int i = 0; i < size;++i){
				dia=Integer.parseInt(alcale.get(j));
				++j;
				mes=Integer.parseInt(alcale.get(j));
				++j;
				any=Integer.parseInt(alcale.get(j));
				++j;
				numDrsManana=Integer.parseInt(alcale.get(j));
				++j;
				numDrsTarde=Integer.parseInt(alcale.get(j));
				++j;
				numDrsNoche=Integer.parseInt(alcale.get(j));
				++j;
				specialManana=alcale.get(j);
				++j;
				specialTarde=alcale.get(j);
				++j;
				specialNoche=alcale.get(j);
				addVacationDay(dia,mes,any,numDrsManana,numDrsTarde,numDrsNoche,specialManana,specialTarde,specialNoche);
			    ++j;
			}
		}
	}
	
	/** 
	 *@return el calendario
	 */
	public Calendario getCale(){
		return calendar;
	}
	
	public void addVacationDay(int dia, int mes, int year, int numDrsManana, int numDrsTarde, int numDrsNoche, String especialManana, String especialTarde, String especialNoche) throws IOException{
		try {
			if(year != calendar.getCalendarYear()) throw new IOException("Anyo incorrecto");
			// checking input data
			//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			GregorianCalendar date = new GregorianCalendar(year, mes-1, dia);
			//date.setTime(sdf.parse(fecha));
			//if (!date.isLenient() || date.get(GregorianCalendar.YEAR) != calendar.getCalendarYear()) throw new IOException("La fecha no es correcta");
			if (calendar.existsVacationDay(date)) throw new IOException("El dia vacacional ya existe");
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
		catch (IOException e) {
			throw new IOException(e);
		}
	}


	public void modifyVacationDay(int dia, int mes, int year, int numDrsManana, int numDrsTarde, int numDrsNoche, String especialManana, String especialTarde, String especialNoche) throws IOException{
		try {
			// checking input data
			SimpleDateFormat sdf = new SimpleDateFormat("d-M-yyyy");
			GregorianCalendar date= new GregorianCalendar(year, mes-1, dia);
			//if (!date.isLenient() || date.get(GregorianCalendar.YEAR) != calendar.getCalendarYear()) throw new IOException("La fecha no es correcta");
			if (!calendar.existsVacationDay(date)) throw new IOException("La fecha no corresponde a ningun dia vacacional");
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
		catch (IOException e) {
			throw new IOException(e);
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
	
	public void saveDataCale(int id) throws IOException{
		ArrayList<String> alcal = new ArrayList<String>();
		if(calendar.getNumberOfVacationDates()>0){	
	   		alcal.add(Integer.toString(calendar.getCalendarYear()));
	   		alcal.add(Integer.toString(calendar.getNumberOfVacationDates()));
	   		ArrayList<GregorianCalendar> cal =calendar.getALLVacationDates();
	   		ArrayList<Turno> turns =new ArrayList<Turno>();
	   		for(int i=0;i<cal.size();++i){
	   			turns=calendar.getShiftsOfADay(cal.get(i));
	   			int dia=0,mes=0,year=0,numDrsManana=0,numDrsTarde=0,numDrsNoche=0;
	   			String especialm = null,especialt=null,especialn=null;
	   			for(int j=0;j<turns.size();++j){
	   				Turno t=turns.get(j);
	   				dia=t.getDate().DAY_OF_MONTH;
	   				mes=t.getDate().MONTH;
	   				year=t.getDate().YEAR;
	   				if(t.getShiftType().equals("manana")){
	   					numDrsManana=t.getNumberOfDoctors();
	   					especialm=t.getSpecialDate();
	   				}
	   				else if(t.getShiftType().equals("tarde")){
	   					numDrsTarde=t.getNumberOfDoctors();
	   					especialt=t.getSpecialDate();
	   				}
	   				else if(t.getShiftType().equals("noche")){
	   					numDrsNoche=t.getNumberOfDoctors();
	   					especialn=t.getSpecialDate();
	   				}
	   			}
	   			alcal.add(Integer.toString(dia));
	   			alcal.add(Integer.toString(mes));
	   			alcal.add(Integer.toString(year));
	   			alcal.add(Integer.toString(numDrsManana));
	   			alcal.add(Integer.toString(numDrsTarde));
	   			alcal.add(Integer.toString(numDrsNoche));
	   			alcal.add(especialm);
	   			alcal.add(especialt);
	   			alcal.add(especialn);
	   		}
		}
		inOut.saveDataCale(alcal, id);
    }
	
	
	public int getCalendarYear() {
		return calendar.getCalendarYear();
	}
}
