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





class listAndSalary{
    public ArrayList<nodoTurno> listaTurnos;
    public double sueldoTotal;
}



public class Asignaciones {
	
	private HashMap<Integer,listAndSalary> mapSol;
	
	/**
	* Crea un conjunto de asignaciones vacia
	* 
	*/
	public Asignaciones(){
		mapSol = new HashMap<Integer,listAndSalary>();
	}

	//Consultoras
	public HashMap<Integer,listAndSalary> getAsignaciones(){
		return mapSol;
	}
	
	public ArrayList<nodoTurno> getTurnosAsigando(int idDoctor){
		listAndSalary ls = mapSol.get(idDoctor);
		return  ls.listaTurnos;
		
	}
	
	public double getSueldoTotal(int idDoctor){
		listAndSalary ls = mapSol.get(idDoctor);
		return  ls.sueldoTotal;
	}
	
	//Setter 
	public void setAsignacion(int idDoctor, ArrayList<nodoTurno> turnos, double sueldo){
		listAndSalary ls = new listAndSalary(); 
		ls.listaTurnos = turnos;
		ls.sueldoTotal = sueldo;
		mapSol.put(idDoctor, ls);
	}

	
}