package data;
import java.io.*;
import java.util.*;

/*Comunicara con los ficheros de datos*/

public class CtrlDatosFichero {
	
	File archivo;
    FileReader fr;
    BufferedReader br;
	
	/* Atributos */

	/* Constructora */
	public CtrlDatosFichero() {
		archivo = null;
	    fr=null;
	    br=null;
	}
	
   public String[] getHospital (int id) {
	   String[] hosp = new String[4];
	   hosp[0]="0";
	   try{
	   archivo = new File("/prop2014/src/data/inHosp");
	   fr = new FileReader (archivo);
	   br = new BufferedReader(fr);
	   // Lectura del fichero
	   String linea;
	   while((linea=br.readLine())!=null){
		   Scanner sl = new Scanner(linea);
		   String s1 = sl.next();
		  String Id= Integer.toString(id);
		   if(s1.equals(Id)){
			   hosp[0]=sl.next();
			   hosp[1]=sl.next();
			   hosp[2]=sl.next();
			   hosp[3]=sl.next();
		   }
		   sl.close();
	   }
   }
	catch(Exception e){
		e.printStackTrace();
	}finally{
		// En el finally cerramos el fichero, para asegurarnos
		// que se cierra tanto si todo va bien como si salta 
		// una excepcion.
   			try{                    
   				if( null != fr )fr.close();        
   			}catch (Exception e2){ 
   				e2.printStackTrace();
   			}
   		}
   return hosp;
   }
	
}
         
	
	
	/* Metodos públicos */
