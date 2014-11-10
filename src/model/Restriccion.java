
// Autor: Axel's Copyright 
package model;
//import java.util.*;

public class Restriccion {

	/* Atributos */
	
	protected int id_Restriccion;
	
	// Tipo solo puede ser: 
	protected String Tipo;

	
	
	/* Constructora */
	public Restriccion() {}

	public Restriccion(int id, String T) {
		id_Restriccion = id;
		Tipo = T; 
		
	}
	
	
	

	/* Metodos públicos */

	
//----> Consultoras 
	
	public String getTipo() {
	    return Tipo;
	}
	
	public int getId() {
	    return id_Restriccion;
	}
	    
	
}










