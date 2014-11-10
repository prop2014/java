//Autor: Axel's Copyright 
package model;
//import java.util.*;
import model.Restriccion;

public class  MAX_Turnos_por_Dia extends Restriccion{

	/* Atributos */
	
	private int Num_Turnos;


	/* Constructora */

	public MAX_Turnos_por_Dia(int id, int Num_T) {
		
		super(id,"MAX_Turnos_por_Dia");
		Num_Turnos = Num_T;
	}

	

	/* Metodos públicos */
	
//--> Consultoras
	
	public int getId() {
	    return id_Restriccion ;
	}

	public String getTipo(){
		return Tipo;
	}
	
	public int getDia_Num_Turnos(){
		return Num_Turnos;
	}
	
	
}
