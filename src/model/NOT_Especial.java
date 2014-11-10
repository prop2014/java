//Autor: Axel's Copyright 
package model;
//import java.util.*;
import model.Restriccion;

public class  NOT_Especial extends Restriccion{

	/* Atributos */
	private String Especial; 


	/* Constructora */

	public NOT_Especial(int id, String Esp) {
		
		super(id,"NOT_Especial");
		Especial = Esp;
		
	}

	

	/* Metodos públicos */
	
//--> Consultoras

	public int getId() {
	    return id_Restriccion ;
	}

	public String getTipo(){
		return Tipo;
	}
	
	public String getEspecial(){
		return Especial;
	}
	
	
}