//Autor: Axel's Copyright 
package Model;
//import java.util.*;
import Model.Restriccion;

public class  MAX_Turnos_Consecutivos extends Restriccion {

	/* Atributos */
	private int Num_Turnos;


	/* Constructora */

	public MAX_Turnos_Consecutivos (int id, int Num_T) {
		
		super(id, "MAX_Turnos_Consecutivos");
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