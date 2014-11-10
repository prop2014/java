//Autor: Axel's Copyright 
package model;
//import java.util.*;
import model.Restriccion;

public class NOT_Dia_Mes extends Restriccion{

	/* Atributos */
	private int Dia_Mes;


	/* Constructora */	
	
	
	public NOT_Dia_Mes(int id, int Dia_M) {
		
		super(id,"NOT_Dia_Mes");
		Dia_Mes= Dia_M;
	}

	

	/* Metodos públicos */
	
//--> Consultoras
	public int getId() {
	    return id_Restriccion ;
	}

	public String getTipo(){
		return Tipo;
	}
	
	public int getDia_Mes(){
		return Dia_Mes;
	}

	
}