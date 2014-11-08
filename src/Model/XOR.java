// Autor: Axel's Copyright 
package Model;

import java.util.*;

import Model.Restriccion;

public class XOR extends Restriccion {

	/* Atributos */
	
	//array de Fechas
	
	
	List<Date> Lista_XOR = new ArrayList<Date>();
	
	/* Constructora */

	public XOR(int id, List<Date> Lista_X) {
		
		super(id,"XOR");
		 Lista_XOR  = Lista_X;
	}

	

	/* Metodos públicos */

//--> Consultoras

	public int getId() {
	    return id_Restriccion ;
	}

	public String getTipo(){
		return Tipo;
	}
	
	public List<Date> getListDates(){
		return Lista_XOR; 
	}

}
