//Autor: Axel's Copyright 
package Model;
//import java.util.*;
import Model.Restriccion;

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