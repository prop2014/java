//Autor: Axel's Copyright 
package Model;
import java.util.*;
import Model.Restriccion;

public class NOT_Turno extends Restriccion {

	/* Atributos */
	private String TipoTurno;


	/* Constructora */
	
	public NOT_Turno(int id, String T_Turno) {
		id_Restriccion = id;
		Tipo = "NOT_Turno"; 
		TipoTurno = T_Turno; 
		
	}

	/* Metodos públicos */
	
//--> Consultoras
	
	public int getId() {
	    return id_Restriccion ;
	}

	public String getTipo(){
		return Tipo;
	}
	
	public String getTipoTurno(){
		return TipoTurno;
	}

	
	
}