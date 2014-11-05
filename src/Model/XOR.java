// Autor: Axel's Copyright 
package Model;
import java.util.*;
import Model.Restriccion;

public class XOR extends Restriccion {

	/* Atributos */
	
	//Vector de Fechas
	Vector<Date> vector_XOR = new Vector<Date>();
	
	/* Constructora */

	public XOR(int id, Vector<Date> vector_X) {
		id_Restriccion = id;
		Tipo = "XOR";
		vector_XOR = vector_X;
	}

	

	/* Metodos públicos */

//--> Consultoras

	public int getId() {
	    return id_Restriccion ;
	}

	public String getTipo(){
		return Tipo;
	}
	
	public Vector<Date> getVecDates(){
		return vector_XOR; 
	}

}
