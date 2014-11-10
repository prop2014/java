
//Autor: Axel's Copyright 
package model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import model.Restriccion;

public class  MAX_Dias_Rango extends Restriccion {

	/* Atributos */
	
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	private Date Fecha_INI;
	private Date Fecha_FIN;
	
	
	private int Num_Dias;


	/* Constructora */

	public MAX_Dias_Rango (int id, String Fecha_I, String Fecha_F, int Num_D) throws ParseException {
		
		super(id,"MAX_Dias_Rango");
		
		Fecha_INI = formato.parse(Fecha_I);
		Fecha_FIN = formato.parse(Fecha_F);

		Num_Dias = Num_D;
	}

	

	/* Metodos públicos */
	
//--> Consultoras

	public int getId() {
	    return id_Restriccion ;
	}
	
	
	public String getTipo(){
		return Tipo;
	}
	//OBTENER LA FECHAS EN FORMATO STRING
	public String getStringFechaINI(){
		return formato.format(Fecha_INI);
		
	}
	public String getStringFechaFIN(){
		return formato.format(Fecha_FIN);
		
	}
	
	
	
	//OBTENER LA FECHA EN FORMATO DATE
	public Date getDateFechaINI(){
		return Fecha_INI;
	}
	public Date getDateFechaFIN(){
		return Fecha_FIN;
	}
	
	
	public int getNumDias(){
		return Num_Dias;
	}
	
	
}