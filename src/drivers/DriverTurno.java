package drivers;

import model.Calendario;
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

		GregorianCalendar date = new GregorianCalendar(2000,0,1);
		Turno t1 = new Turno(date,"manana"); // turno por defecto: 1-ene-2000, manana
		Turno t2;
		int d,m,y;
		Scanner sc = new Scanner(System.in);
		String answer;
		boolean exit = false;
		int op;

		while(!exit){
			
			System.out.println("-- Menu Principal --\n");
			System.out.println(" 1: Turno()");
			System.out.println(" 2: Turno(Turno T)");
			System.out.println(" 3: Turno (GregorianCalendar date, String shiftType, String specialDate, int numberOfDoctors)");
			System.out.println(" 4: void setSpecialDate(String specialDate)");
			System.out.println(" 5: void setNumberOfDoctors(int numberOfDoctors)");
			System.out.println(" 6: GregorianCalendar getDate()");
			System.out.println(" 7: String getShiftType()");
			System.out.println(" 8: String getSpecialDate()");
			System.out.println("10: int getNumberOfDoctors()");
			System.out.println(" 0: Salir");
			
			op = sc.nextInt();
			
			switch(op){
			case 1:{
				System.out.println("Introducir 'fecha' del nuevo turno: {dd} {mm} {aaaa} (separados por espacios)");
				d = sc.nextInt();
				m = sc.nextInt();
				y = sc.nextInt();
				date = new GregorianCalendar(y,m-1,d);
				System.out.println("Introducir 'tipo' del nuevo turno:");
				String shiftType = sc.next();
				Turno t = new Turno(date, shiftType);
				System.out.println("\nSe ha creado un turno t1\n");
				break;
			}
			case 2:{
				System.out.println("Se ha creado un turno t2, que es copia del turno t1");
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
				date = new GregorianCalendar(year,month-1,dayOfMonth);
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
			case 0:{
				System.out.println("Salir? {s|n}: \n");
				answer = sc.next();
				while (!(answer.equals("s") || answer.equals("n"))) {
					System.out.println("Elegir una de las siguientes opciones:");
					System.out.println("s: Salir     |     n: Continuar");
					answer = sc.next();
				}
				if (answer.equals("s")) exit = true;
				break;
			}
			default: {
				System.out.println("Opcion incorrecta o no disponible!\n");
				break;
			}
			}
			
			if (!exit) {
				System.out.println("Teclear c para continuar\n");
				answer = sc.next();
				while (!answer.equals("c")) {
					System.out.println("Teclear c para continuar\n");
					answer = sc.next();
				}
			}
		}
		sc.close();
		System.out.println("-- fin del programa --");
	}

}
