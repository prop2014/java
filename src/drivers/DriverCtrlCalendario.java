package drivers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import java.io.IOException;
import data.CtrlDatosFichero;
import domain.*;
import model.*;

public class DriverCtrlCalendario {
	static void MostrarTurno(Turno t){
		System.out.printf("--------------------.\n");
		GregorianCalendar c1 = t.getDate();
		String fecha = DateFormat.getDateInstance(DateFormat.SHORT).format(c1.getTime());
		System.out.printf("fecha: %s\n", fecha);
		System.out.printf("\n");
		System.out.printf("tipoturno: %s\n",t.getShiftType());
		System.out.printf("especial: %s\n",t.getSpecialDate());
		System.out.printf("numDoctores: %d\n",t.getNumberOfDoctors());
		System.out.printf("--------------------.\n");

	}
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String answer;
		boolean exit = false;
		int op;
		CtrlDatosFichero inOut= new CtrlDatosFichero();
		CtrlHospital Ho = new CtrlHospital();
		System.out.print("El Calendario corresponde a un Hospital porfavor introdzca el id de Hospital");
		int id = sc.nextInt();
		int year=-1;
		try{
		Ho.cargarHospital(id);
		}catch (IOException e){System.out.print("fallo");}
		try {
		year = inOut.getYear(id,null);
		}catch (IOException e){
			System.out.print("fallo el anyo");
		}
		if(year ==-1) exit=true;
		Ho.addCalendar(year);
		CtrlCalendario cal = new CtrlCalendario(Ho.getCalendar());
		
		Calendario calendar1 = cal.getCalendar();
		if(calendar1.getNumberOfVacationDates()==0) System.out.printf("Actualment l'Hospital no te calendari\n");
		else {
			System.out.printf("El calendari te %d Turns Vacacionals\n",calendar1.getNumberOfShifts());
			ArrayList<Turno> alturno = calendar1.getALLShifts();
			for(int i=0;i<alturno.size();++i){
				MostrarTurno(alturno.get(i));
			}
		}
		
		
		
		
		System.out.print("Driver CtrlCalendario\n");

		while(!exit){
			System.out.println();
			System.out.println("-- Menu Principal --\n");
			System.out.println("1: readCalendar \n");
			System.out.println("2: addVacationDay \n");
			System.out.println("3: modifyVacationDay \n");			
			System.out.println("4: deleteVacationDay \n");
			System.out.println("5: writeCalendar \n");
			System.out.println("6:  getCalendarYear \n");
			System.out.println(" 0: Salir\n");
			
			
			op = sc.nextInt();

			switch(op){
			case 1:{
				try{
				cal.readCalendar(id);
				}catch (IOException e){System.out.print("No se ha podido leer");}
				System.out.print("Se ha cargado el calendario\n");
				Calendario calendar = cal.getCalendar();
				if(calendar.getNumberOfVacationDates()==0) System.out.printf("Actualment l'Hospital no te calendari\n");
				else {
					System.out.printf("El calendari te %d Turns Vacacionals\n",calendar.getNumberOfShifts());
					ArrayList<Turno> alturno = calendar.getALLShifts();
					for(int i=0;i<alturno.size();++i){
						MostrarTurno(alturno.get(i));
					}
				}
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

