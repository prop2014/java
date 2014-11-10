//Autor: Axel's Copyright 
package model;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.Restriccion;
public class  NOT_Fecha extends Restriccion{

	/* Atributos */
	
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	private Date Fecha;

	/* Constructora */

	public NOT_Fecha(int id, String Fecha1) throws ParseException {
		
		super(id,"NOT_Fecha");
		
		Fecha = formato.parse(Fecha1);
		
		
	}

	

	/* Metodos públicos */
	
//--> Consultoras

	public int getId() {
	    return id_Restriccion ;
	}

	public String getTipo(){
		return Tipo;
	}
	
	//OBTENER LA FECHA EN FORMATO STRING
	public String getStringFecha(){
		return formato.format(Fecha);
		
	}	
	//OBTENER LA FECHA EN FORMATO DATE
	public Date getDateFecha(){
		return Fecha;
	}
	
	
}
