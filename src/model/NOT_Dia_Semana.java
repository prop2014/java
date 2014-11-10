
//Autor: Axel's Copyright 
package model;
//import java.util.*;
import model.Restriccion;

public class NOT_Dia_Semana extends Restriccion{

	/* Atributos */
	private String Dia_Semana;


	/* Constructora */

	public NOT_Dia_Semana(int id, String Dia_Se) {
		
		super(id,"NOT_Dia_Semana");
		Dia_Semana = Dia_Se;
	}

	

	/* Metodos públicos */
	
//--> Consultoras
	public int getId() {
	    return id_Restriccion ;
	}

	public String getTipo(){
		return Tipo;
	}
	
	public String getDia_Semana(){
		return Dia_Semana;
	}
	
}