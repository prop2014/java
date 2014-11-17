package drivers;

import java.util.GregorianCalendar;
import java.util.Scanner;

import model.Calendario;
import model.Turno;

public class DriverCtrlCalendario {

	public static void main(String[] args) {
		Calendario c1 = new Calendario(1999);
		Calendario c2 = new Calendario(2000);
		Scanner sc = new Scanner(System.in);
		String answer;
		boolean exit = false;
		int op;

		while(!exit){
			System.out.println();
			System.out.println("-- Menu Principal --\n");
			System.out.println(" *** ");
			System.out.println(" *** ");
			System.out.println(" *** ");
			System.out.println(" *** ");			
			System.out.println(" *** ");
			System.out.println(" *** ");
			System.out.println(" *** ");
			System.out.println(" 0: Salir\n");

			op = sc.nextInt();

			switch(op){
			case 1:{
				break;
			}
			case 2:{
				break;
			}
			case 3:{
				break;
			}
			case 4:{
				break;
			}
			case 5:{
				break;
			}			
			case 6:{
				break;
			}
			case 7:{
				break;
			}
			case 8:{
				break;
			}
			case 9:{
				break;
			}
			case 10:{

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

