package drivers;

import model.Turno;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author Felix Fernando Ramos Velazquez
 */
public class DriverTurno {

	private static boolean checkInputParameters() {
		// provisional
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int op = -1;

		while(op != 0){
			
			System.out.println("Menú principal");
			System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
			System.out.println(" 1: Turno()");
			System.out.println(" 2: Turno(Turno T)");
			System.out.println(" 3: Turno (GregorianCalendar date, String shiftType, String specialDate, int numberOfDoctors)");
			System.out.println(" 4: void setDate(GregorianCalendar date)");
			System.out.println(" 5: void setShiftType(String shiftType)");
			System.out.println(" 6: void setSpecialDate(String specialDate)");
			System.out.println(" 7: void setNumberOfDoctors(int numberOfDoctors)");
			System.out.println(" 8: GregorianCalendar getDate()");
			System.out.println(" 9: String getShiftType()");
			System.out.println("10: String getSpecialDate()");
			System.out.println("11: int getNumberOfDoctors()");
			System.out.println(" 0: Salir");
			
			op = sc.nextInt();
			switch(op){
			case 1:{
				Turno t = new Turno();
				System.out.println("Se ha creado un turno vacío");
				break;
			}
			case 2:{
				System.out.println("Se ha creado un turno que es copia de...");
				break;
			}
			case 3:{
				System.out.println("Introducir la fecha (dayOfMonth month year) del turno:");
				int dayOfMonth, month, year;
				dayOfMonth = sc.nextInt();
				month = sc.nextInt();
				year = sc.nextInt();
				System.out.println("Introducir el tipo {morning | afternoon | evening} del turno:");
				String shiftType = sc.next();
				System.out.println("Introducir la fecha especial del turno:");
				String specialDate = sc.next();
				System.out.println("Introducir el numero de doctores del turno:");
				int numberOfDoctors = sc.nextInt();
				GregorianCalendar date = new GregorianCalendar(year,month-1,dayOfMonth);
				//t = new Turno(date, shiftType, specialDate, numberOfDoctors);
				System.out.println("Se ha creado un turno con los parámetros introducidos");
				break;
			}
			case 4:{
				System.out.println("---");
				break;
			}
			case 5:{
				System.out.println("---");
				break;
			}
			case 6:{
				System.out.println("---");
				break;
			}
			case 7:{
				System.out.println("---");
				break;
			}
			case 8:{
				System.out.println("---");
				break;
			}
			case 9:{
				System.out.println("---");
				break;
			}
			case 10:{
				System.out.println("---");
				break;
			}
			case 11:{
				System.out.println("---");
				break;
			}
			}
		}
		sc.close();
	}

}
