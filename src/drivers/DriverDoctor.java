package drivers;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.*;

public class DriverDoctor {
	
	
	public static void main(String args[]) throws ParseException {
		Scanner teclado;
		teclado = new Scanner(System.in);		
		int numMax, idDoctor, opcion;
		opcion = -1;
		String nombreDoctor;
		Double sueldo;
		Doctor doc = new Doctor();
		Restriccion res = new Restriccion();
		
		System.out.print("�Que desea hacer?\n");
		System.out.print("0: Terminar programa\n");
		System.out.print("1: Crear Doctor\n");
		System.out.print("2: A�adir restriccion a un Doctor\n");
		System.out.print("3: Eliminar restriccion a un doctor\n");
		System.out.print("4: Consultar retriccions del Doctor\n");
		
			
		opcion = teclado.nextInt(); //leemos opcion
		
		while(opcion != 0){	
			if (opcion == 1){
				System.out.printf("Ingrese el Id, Nombre, Numero m�ximo de turnos y Sueldo del Doctor\n");
				idDoctor = teclado.nextInt();
				nombreDoctor = teclado.next();
				numMax = teclado.nextInt();	
				sueldo = teclado.nextDouble();
				doc = new Doctor(idDoctor, nombreDoctor, numMax, sueldo);
				System.out.printf("El Doctor %d ha sido creado.\n", doc.getId());			
			}
			else if (opcion == 2) {
				System.out.printf("Ingrese la id y el tipo de restriccion\n");
				int idRestriccion = teclado.nextInt();
				String tipoRestriccion = teclado.next();
				if (tipoRestriccion.equals("maxdiesrango")) {
					System.out.printf("Restriccion tipo MAX_Dies_Rango, ingrese la fecha inico, fin y el numero de dias.\n");
					String fechaIn, fechaFin;
					int numDias;
					fechaIn = teclado.next();
					fechaFin = teclado.next();
					numDias = teclado.nextInt();
					res = new MAX_Dias_Rango(idRestriccion, fechaIn, fechaFin, numDias);
				}
				else if (tipoRestriccion.equals("MAX_Turnos_Consecutivos")) {
					System.out.printf("Restriccion tipo MAX_Turnos_Consecutivos, ingrese el numero maximo de turnos.\n");
					int numTurnos;
					numTurnos = teclado.nextInt();
					res = new MAX_Turnos_Consecutivos(idRestriccion, numTurnos);
				}
				else if (tipoRestriccion.equals("MAX_Turnos_por_Dia")) {
					System.out.printf("Restriccion tipo MAX_Turnos_por_Dia, ingrese el numero maximo de turnos.\n");
					int numTurnos;
					numTurnos = teclado.nextInt();
					res = new MAX_Turnos_por_Dia(idRestriccion, numTurnos);
				}
				else if (tipoRestriccion.equals("NOT_Dia_Mes")) {
					System.out.printf("Restriccion tipo NOT_Dia_Mes, ingrese el dia del mes.\n");
					int diaMes;
					diaMes = teclado.nextInt();
					res = new NOT_Dia_Mes(idRestriccion, diaMes);
				}
				else if (tipoRestriccion.equals("NOT_Dia_Setmana")) {
					System.out.printf("Restriccion tipo NOT_Dia_Setmana, ingrese el dia de la semana.\n");
					String diaSemana;
					diaSemana = teclado.next();
					res = new NOT_Dia_Semana(idRestriccion, diaSemana);
				}
				else if (tipoRestriccion.equals("NOT_Especial")) {
					System.out.printf("Restriccion tipo NOT_Especial, ingrese el dia especial.\n");
					String diaEspecial;
					diaEspecial = teclado.next();
					res = new NOT_Especial(idRestriccion, diaEspecial);
				}
				else if (tipoRestriccion.equals("NOT_Fecha")) {
					System.out.printf("Restriccion tipo NOT_Fecha, ingrese la fecha.\n");
					String fecha;
					fecha = teclado.next();
					res = new NOT_Fecha(idRestriccion, fecha);
				}
				else if (tipoRestriccion.equals("NOT_Turno")) {
					System.out.printf("Restriccion tipo NOT_Turno, ingrese el tipo del dia.\n");
					String tipoDia;
					tipoDia = teclado.next();
					res = new NOT_Especial(idRestriccion, tipoDia);
				}
				else if (tipoRestriccion.equals("XOR")) {
					System.out.printf("Restriccion tipo XOR, ingrese las diferentas fechas y pon una n para terminar.\n");
					List<String> Lista_XOR = new ArrayList<String>();
					List<Date> Lista_XOR2 = new ArrayList<Date>();
					String fecha;
					fecha = teclado.next();
					Lista_XOR.add(fecha);
					while (!fecha.equals("n")) {
						Lista_XOR.add(fecha);
						fecha = teclado.next();
					}
					for (int i = 0; i < Lista_XOR.size(); ++i) {
						SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
						Date Fecha = formato.parse(Lista_XOR.get(i));						
						Lista_XOR2.add(Fecha);
					}
					res = new XOR(idRestriccion, Lista_XOR2);	
				}	
				else System.out.printf("Restriccion erronea");
				boolean c = doc.addRestriccion(res);
				if (c) System.out.printf("Restriccion a�adida.\n");	
				else System.out.printf("Ya existe una restriccion con este Id.\n");
			}
			else if (opcion == 3) {
				System.out.printf("Ingrese la id de la restriccion que quieras eliminar\n");
				int idRestriccion = teclado.nextInt();
				boolean c = doc.eliminarRestriccion(idRestriccion);
				if (c) System.out.printf("Restriccion eliminada.\n");	
				else System.out.printf("Esta Id de restriccion no existe.\n");
			}
			else if (opcion == 4) {
				if (doc.isREmpty()) System.out.printf("El Doctor no tiene ninguna restriccion");
				else {
					ArrayList<Restriccion> restr = new ArrayList<Restriccion>();
					restr = doc.getRestricciones();
					for (int i = 0; i < restr.size(); ++i) {
						System.out.printf("Id: %d\nTipo: %s\n\n", restr.get(i).getId(), restr.get(i).getTipo());
					}
				}
			}
			opcion = teclado.nextInt();
			
		}
		
	}
}
