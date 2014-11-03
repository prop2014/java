
//Autor: Axel's Copyright 
package Model;
import java.util.*;
import Model.Restriccion;

public class  MAX_Dias_Rango extends Restriccion {

	/* Atributos */
	private Date Fecha_INI;
	private Date Fecha_FIN;
	private int Num_Dias;


	/* Constructora */

	public MAX_Dias_Rango (int id, Date Fecha_I, Date Fecha_F, int Num_D) {
		id_Restriccion = id;
		Tipo = "MAX_Dias_Rango";
		Fecha_INI = Fecha_I;
		Fecha_FIN = Fecha_F;
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
	
	public Date getFechaINI(){
		return Fecha_INI;
	}
	public Date getFechaFIN(){
		return Fecha_FIN;
	}
	public int getNumDias(){
		return Num_Dias;
	}
	
	
}