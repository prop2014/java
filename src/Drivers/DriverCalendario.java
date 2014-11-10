package Drivers;
//import Model.Turno;
import Model.Calendario;

import java.util.GregorianCalendar;
//import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DriverCalendario {
	
	static boolean checkDateIn(int d, int m, int n){
		/* en construcción */
		return true;
	}
	static void printDiaVacacional(Calendario c, GregorianCalendar d){
		if(c.existsDiaVacacional(d)){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String date = sdf.format(d.getTime());
		String especial;
		System.out.println("** Día vacacional " + date + " **");
		System.out.println("---------------------------------");
		System.out.println("Turno de mañana");
		System.out.println("- num. doctores: " + c.getTurno(d, "m").getNumDoctores());
		especial = c.getTurno(d, "m").getEspecial();
		if(especial != null){
		System.out.println("- día especial: "+ c.getTurno(d, "m").getEspecial());
		}
		System.out.println("---------------------------------");
		System.out.println("Turno de tarde");
		System.out.println("- num. doctores: "+ c.getTurno(d, "t").getNumDoctores());
		especial = c.getTurno(d, "t").getEspecial();
		if(especial != null){
		System.out.println("- día especial: "+ c.getTurno(d, "t").getEspecial());
		}
		System.out.println("---------------------------------");
		System.out.println("Turno de noche");
		System.out.println("- num. doctores: "+ c.getTurno(d, "n").getNumDoctores());
		especial = c.getTurno(d, "n").getEspecial();
		if(especial != null){
		System.out.println("- día especial: "+ c.getTurno(d, "n").getEspecial());
		}
		System.out.println("---------------------------------\n");
		}
	}

	public static void main(String[] args) {

		System.out.print("Opciones:\n");
		System.out.print("1: Añadir dia vacacional\n");
		System.out.print("2: Eliminar dia vacacional\n");
		System.out.print("3: Consultar dia vacacional\n");
		System.out.print("4: Consultar turno vacacional\n");
		System.out.print("0: Salir\n");

		Calendario c = new Calendario();
		int d,m,a;
		Scanner key = new Scanner(System.in);
		int op = key.nextInt();
		while(op!=0){
			switch(op){
			case 1:{
				System.out.println("Añadir dia vacacional\nIntroducir fecha (dd mm aaaa):");
				d = key.nextInt();
				m = key.nextInt();
				a = key.nextInt();
				GregorianCalendar gc = new GregorianCalendar(a,m-1,d);
				c.addDiaVacacional(gc);
				break;
			}
			case 2:{
				System.out.println("Eliminar dia vacacional\nIntroducir fecha (dd mm aaaa):");
				d = key.nextInt();
				m = key.nextInt();
				a = key.nextInt();
				GregorianCalendar gc = new GregorianCalendar(a,m-1,d);
				c.deleteDiaVacacional(gc);
				break;
			}
			case 3:{
				System.out.println("Consultar dia vacacional\nIntroducir fecha (dd mm aaaa):");
				d = key.nextInt();
				m = key.nextInt();
				a = key.nextInt();
				GregorianCalendar gc = new GregorianCalendar(a,m-1,d);
				printDiaVacacional(c, gc);
				break;
			}
			case 4:{
				//System.out.println("Consultar turno vacacional\nIntroducir fecha (dd mm aaaa):");
				System.out.println("**No disponible**");
				
				break;
			}
			}
			op = key.nextInt();
		}

	}

}
