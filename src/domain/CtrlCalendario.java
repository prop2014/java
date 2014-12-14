package domain;

import model.Calendario;
import model.Turno;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	private CtrlDatosFichero ctrlDatosFichero = new CtrlDatosFichero();

	//-- Constructora --//
	/**
	 * Constructora por defecto
	 */
	public CtrlCalendario(Calendario C) {
		calendar = C;
	}

	/* Metodos publicos */
	/** 
	 *@return el calendario
	 */
	public Calendario getCalendar(){
		return calendar;
	}

	public boolean addVacationDay(GregorianCalendar date, int morningDrs, int eveningDrs, int nightDrs, String especialDate) throws IOException{
		// checking input data
		if (calendar.existsVacationDay(date)) throw new IOException("El dia vacacional ya existe ");
		else if (morningDrs < 0) throw new IOException("El numero de doctores del turno de manana no es correcto ");
		else if (eveningDrs < 0) throw new IOException("El numero de doctores del turno de tarde no es correcto ");
		else if (nightDrs < 0) throw new IOException("El numero de doctores del turno de noche no es correcto ");
		// making changes
		else {
			calendar.addVacationDay(date);
			calendar.getShift(date, shiftTypes[0]).setNumberOfDoctors(morningDrs);
			calendar.getShift(date, shiftTypes[1]).setNumberOfDoctors(eveningDrs);
			calendar.getShift(date, shiftTypes[2]).setNumberOfDoctors(nightDrs);
			calendar.getShift(date, shiftTypes[0]).setSpecialDate(especialDate);
			calendar.getShift(date, shiftTypes[1]).setSpecialDate(especialDate);
			calendar.getShift(date, shiftTypes[2]).setSpecialDate(especialDate);
			return true;
		}
	}

	public boolean modifyVacationDay(GregorianCalendar date, int morningDrs, int eveningDrs, int nightDrs, String especialDate) throws IOException{
		// checking input data
		if (!calendar.existsVacationDay(date)) throw new IOException("La fecha no corresponde a ningun dia vacacional ");
		else if (morningDrs < 0) throw new IOException("El numero de doctores del turno de manana no es correcto ");
		else if (eveningDrs < 0) throw new IOException("El numero de doctores del turno de tarde no es correcto ");
		else if (nightDrs < 0) throw new IOException("El numero de doctores del turno de noche no es correcto ");
		// making changes
		else {
			calendar.getShift(date, shiftTypes[0]).setNumberOfDoctors(morningDrs);
			calendar.getShift(date, shiftTypes[1]).setNumberOfDoctors(eveningDrs);
			calendar.getShift(date, shiftTypes[2]).setNumberOfDoctors(nightDrs);
			calendar.getShift(date, shiftTypes[0]).setSpecialDate(especialDate);
			calendar.getShift(date, shiftTypes[1]).setSpecialDate(especialDate);
			calendar.getShift(date, shiftTypes[2]).setSpecialDate(especialDate);
		}
		return true;
	}

	public boolean deleteVacationDay(GregorianCalendar date) throws IOException {
		// checking input data
		if (!calendar.existsVacationDay(date))
			throw new IOException("La fecha no corresponde a ningun dia vacacional ");
		// making changes
		else {
			calendar.deleteVacationDay(date);
			return true;
		}
	}

	public int getCalendarYear() {
		return calendar.getCalendarYear();
	}

	public void setCalendarYear(int year) {
		calendar.setCalendarYear(year);
	}

	public ArrayList<String> getVacationDay(GregorianCalendar date) throws IOException {
		ArrayList<String> vacation = new ArrayList<String>();
		if (calendar.existsVacationDay(date)) {
			ArrayList<Turno> shifts = calendar.getShiftsOfADay(date); // se obtienen los 3 turnos del dia vacacional
			for (Turno t : shifts) {
				vacation.add(Integer.toString(t.getNumberOfDoctors())); // anade el numero de Drs. de cada turno
			}
			String special = shifts.get(0).getSpecialDate();
			if (special.isEmpty()){ special = "-";}
			vacation.add(special); // anade la fecha especial (la coge del turno de manana)
			return vacation;
		}
		else throw new IOException("La fecha no corresponde a ningun dia vacacional ");	
	}

	public ArrayList<ArrayList<String>> getALLVacations() {
		ArrayList<GregorianCalendar> vacations = calendar.getALLVacations();
		ArrayList<ArrayList<String>> listVacations = new ArrayList<ArrayList<String>>();
		SimpleDateFormat sdf = new SimpleDateFormat("d-MMM", new Locale("es","ES"));
		for (GregorianCalendar date : vacations) {
			ArrayList<String> vacationDay = new ArrayList<String>();
			vacationDay.add(sdf.format(date.getTime()));
			vacationDay.add(Integer.toString(calendar.getShift(date, shiftTypes[0]).getNumberOfDoctors()));
			vacationDay.add(Integer.toString(calendar.getShift(date, shiftTypes[1]).getNumberOfDoctors()));
			vacationDay.add(Integer.toString(calendar.getShift(date, shiftTypes[2]).getNumberOfDoctors()));
			vacationDay.add(calendar.getShift(date, shiftTypes[0]).getSpecialDate());
			listVacations.add(vacationDay);
		}
		return listVacations;
	}

	@Deprecated
	public void addVacationDayDeprecated(int dia, int mes, int any, int numDrsManana, int numDrsTarde, int numDrsNoche, String especialManana, String especialTarde, String especialNoche) throws IOException{
		GregorianCalendar date = new GregorianCalendar(any,mes-1,dia);
		try {
			if(date.get(GregorianCalendar.YEAR) != calendar.getCalendarYear()) throw new IOException("Anyo incorrecto ");
			else if (calendar.existsVacationDay(date)) throw new IOException("El dia vacacional ya existe");
			else if (numDrsManana < 0) throw new IOException("El numero de doctores del turno de manana no es correcto ");
			else if (numDrsTarde < 0) throw new IOException("El numero de doctores del turno de tarde no es correcto ");
			else if (numDrsNoche < 0) throw new IOException("El numero de doctores del turno de noche no es correcto ");
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

	/* Reading and Writing */
	/**
	 * Lee el calendario contenido en el fichero de texto
	 * @param idHospital Identificador del Hospital
	 * @param path Ruta del fichero de texto
	 * @throws IOException
	 */
	public void readCalendar(int idHospital, String path) throws IOException, ParseException{
		// llamada a datos
		if(ctrlDatosFichero.existsCalendar(idHospital)){
			ArrayList<String> calendarData = ctrlDatosFichero.getDataCale(idHospital, path);
//			ArrayList<String> calendarData = new ArrayList<String>(ctrlDatosFichero.getDataCale(idHospital, path));
			int calendarYear = Integer.parseInt(calendarData.get(0));
			if (calendarYear != -1) {
				calendar.setCalendarYear(calendarYear);
				int numberOfVacations = Integer.parseInt(calendarData.get(1));
				for (int i=0,j=2; i<numberOfVacations; ++i) {
					// getting date
					String strDate = calendarData.get(j++);
					int d = Integer.parseInt(strDate.substring(0, 2));
					int M = Integer.parseInt(strDate.substring(3, 5));
					int y = Integer.parseInt(strDate.substring(6));
					GregorianCalendar date = new GregorianCalendar(y,M-1,d,0,0,0);
					// getting number of doctors
					int morningDrs = Integer.parseInt(calendarData.get(j++));
					int eveningDrs = Integer.parseInt(calendarData.get(j++));
					int nightDrs = Integer.parseInt(calendarData.get(j++));
					// getting special date
					String specialDate = calendarData.get(j++);
					if (specialDate.equals("-")) specialDate = "";
					// adding vacation day
					addVacationDay(date, morningDrs, eveningDrs, nightDrs, specialDate);
				}
			}
		}
	}

	/**
	 * Guarda el contenido del calendario actual en el fichero de texto del hospital correspondiente
	 * @param idHospital Identificador del Hospital
	 * @throws IOException
	 */
	public void writeCalendar(int idHospital) throws IOException{
		ArrayList<String> calendarData = new ArrayList<String>();
		calendarData.add(Integer.toString(calendar.getCalendarYear()));
		calendarData.add(Integer.toString(calendar.getNumberOfVacations()));	
		if(!calendar.isEmpty()) {
			ArrayList<GregorianCalendar> vacations = calendar.getALLVacations();
			//			ArrayList<GregorianCalendar> vacations = new ArrayList<GregorianCalendar>(calendar.getALLVacations());
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			for (GregorianCalendar date : vacations) {
				calendarData.add(sdf.format(date.getTime()));
				calendarData.addAll(getVacationDay(date));
				//				calendarData.addAll(new ArrayList<String>(getVacationDay(date)));
			}
		}
		// llamada a datos
		ctrlDatosFichero.saveDataCale(calendarData, idHospital);
	}
	
	/** Importa un calendario desde un fichero de texto externo
	 * @param idHospital Identificador del hospital
	 * @param path Ruta del fichero
	 * @throws IOException
	 */
	public void importCalendar(int idHospital, String path) throws IOException, ParseException {
		ArrayList<String> listVacations = new ArrayList<String>();
		listVacations = ctrlDatosFichero.getDataCale(idHospital, path);
		ctrlDatosFichero.saveDataCale(listVacations, idHospital);
	}

	//		public void readCalendar(int id, String path) throws IOException,ParseException{
	//			ArrayList<String> alcale =new ArrayList<String>();
	//			Integer num = id;
	//			CtrlDatosFichero inOut = new CtrlDatosFichero();
	//			if(inOut.existsCalendar(id)){
	//				alcale=inOut.getDataCale(num,path);
	//			}
	//			if(!alcale.isEmpty()){
	//				int year = Integer.parseInt(alcale.get(0));
	//				int size=Integer.parseInt(alcale.get(1));
	//				int numDrsManana,numDrsTarde,numDrsNoche;
	//				String fecha;
	//				String special;
	//	
	//				calendar.setCalendarYear(year);
	//				int j=2;
	//				for (int i = 0; i < size;++i){
	//					fecha=alcale.get(j);
	//					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	//					GregorianCalendar gc=new GregorianCalendar();
	//					sdf.setLenient(false);
	//					gc.setTime(sdf.parse(fecha));
	//					++j;
	//					numDrsManana=Integer.parseInt(alcale.get(j));
	//					++j;
	//					numDrsTarde=Integer.parseInt(alcale.get(j));
	//					++j;
	//					numDrsNoche=Integer.parseInt(alcale.get(j));
	//					++j;
	//					special=alcale.get(j);
	//					if (special.equals("-")) special = "";
	//					if(!addVacationDay(gc,numDrsManana,numDrsTarde,numDrsNoche,special)) throw new IOException("DIA no anyadido");
	//					++j;
	//				}
	//			}
	//			/*else{
	//			throw new IOException ("No hay datos a leer");
	//			}*/
	//		}


	//	public void writeCalendar(int idHospital) throws IOException{
	//		ArrayList<String> alcal = new ArrayList<String>();
	//		if(calendar.getNumberOfVacationDates()>0){	
	//			alcal.add(Integer.toString(calendar.getCalendarYear()));
	//			alcal.add(Integer.toString(calendar.getNumberOfVacationDates()));
	//			ArrayList<GregorianCalendar> cal = calendar.getALLVacationDates();
	//			ArrayList<Turno> turns =new ArrayList<Turno>();
	//			for(int i=0;i<cal.size();++i){
	//				turns=calendar.getShiftsOfADay(cal.get(i));
	//				int numDrsManana=0,numDrsTarde=0,numDrsNoche=0;
	//				String especialm = null;
	//				String fecha=null;
	//				for(int j=0;j<turns.size();++j){
	//					Turno t=turns.get(j);
	//					GregorianCalendar gc=t.getDate();
	//					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	//					fecha =sdf.format(gc.getTime());
	//					if(t.getShiftType().equals("manana")){
	//						numDrsManana=t.getNumberOfDoctors();
	//						especialm=t.getSpecialDate();
	//						if (especialm.equals("")) {
	//							especialm = "-";
	//						}
	//					}
	//					else if(t.getShiftType().equals("tarde")){
	//						numDrsTarde=t.getNumberOfDoctors();
	//
	//					}
	//					else if(t.getShiftType().equals("noche")){
	//						numDrsNoche=t.getNumberOfDoctors();
	//
	//					}
	//				}
	//				alcal.add(fecha);
	//				alcal.add(Integer.toString(numDrsManana));
	//				alcal.add(Integer.toString(numDrsTarde));
	//				alcal.add(Integer.toString(numDrsNoche));
	//				alcal.add(especialm);
	//			}
	//		}
	//		CtrlDatosFichero inOut = new CtrlDatosFichero();
	//		inOut.saveDataCale(alcal, idHospital);
	//	}
}
