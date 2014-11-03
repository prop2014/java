//Autor: Axel's Copyright 
package Model;
import java.util.*;
import Model.Restriccion;

public class  NOT_Fecha extends Restriccion{

	/* Atributos */
	private Date Fecha;


	/* Constructora */

	public NOT_Fecha(int id,Date Fecha1) {
		id_Restriccion = id;
		Tipo = "NOT_Fecha";
		Fecha = Fecha1; 
	}

	

	/* Metodos públicos */
	
//--> Consultoras

	public int getId() {
	    return id_Restriccion ;
	}

	public String getTipo(){
		return Tipo;
	}
	
	public Date getFecha(){
		return Fecha;
	}	
	
	
}
