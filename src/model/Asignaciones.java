package model;

import java.util.ArrayList;
import java.util.HashMap;

import domain.nodoTurno;

/**
* Representa las asignaciones de doctores a turnos
* de una solucion posible
* 
* @author Axel Pelaez
*/


/**
 * Estructura para guardar las asignaciones de UN solo doctor
 * 
 */
class listAndSalary{
    public ArrayList<nodoTurno> listaTurnos;
    public double sueldoTotal;
}



public class Asignaciones {
	
	private HashMap<Integer,listAndSalary> mapSol;
	
	/**
	 * Creadora por defecto
	* 	Crea un conjunto de asignaciones vacia
	* 
	*/
	public Asignaciones(){
		mapSol = new HashMap<Integer,listAndSalary>();
	}

	//Consultoras
	public HashMap<Integer,listAndSalary> getAsignaciones(){
		return mapSol;
	}
	
	
	/**
	*Consultora de los turnos Asignados a un doctor
	* @param: idDoctor: id del Doctor
	* @return una lista con los turnos asignados al Doctor de id idDoctor
	*/
	public ArrayList<nodoTurno> getTurnosAsigando(int idDoctor){
		listAndSalary ls = mapSol.get(idDoctor);
		return  ls.listaTurnos;
		
	}
	
	/**
	*Consultora del sueldo total de un Doctor
	* @param: idDoctor: id del Doctor
	* @return el sueldo total que cobrara el Doctor con idDoctor 
	* 		  por todos los turnos trabajados
	*/
	public double getSueldoTotal(int idDoctor){
		listAndSalary ls = mapSol.get(idDoctor);
		return  ls.sueldoTotal;
	}
	
	//Setter 
	
	/**
	*Setter de Asignacion 
	* Se añade las asignaciones y el sueldo total al Doctor con idDoctor;
	* @param: idDoctor: id del Doctor
	* 		  turnos: lista con los turnos asignados al Doctor con idDoctor
	* 		  sueldo: sueldo total que cobrara el Doctor con idDoctor por trabajar todos los turnos
	* 
	*/
	public void setAsignacion(int idDoctor, ArrayList<nodoTurno> turnos, double sueldo){
		listAndSalary ls = new listAndSalary(); 
		ls.listaTurnos = turnos;
		ls.sueldoTotal = sueldo;
		mapSol.put(idDoctor, ls);
	}

	
}