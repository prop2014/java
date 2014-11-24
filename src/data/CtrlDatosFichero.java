package data;
import java.io.*;
import java.util.*;

/*Comunicara con los ficheros de datos*/

public class CtrlDatosFichero {
	
	File archivo;
    FileReader fr;
    BufferedReader br;
    FileWriter fw;
    PrintWriter pw;
	
	/* Atributos */

	/* Constructora */
	public CtrlDatosFichero() {
		archivo = null;
	    fr=null;
	    br=null;
	    fw = null;
	    pw = null;
	}
	
   public ArrayList<String> getHospital (int id) {
	   ArrayList<String> alhosp = new ArrayList<String>();
	   
	   try{
	   String num = Integer.toString(id);
	   String path = new File("").getAbsolutePath();
	   String realpath = path+ "/datos/Hospital";
	   archivo = new File(realpath+num);
	   fr = new FileReader (archivo);
	   br = new BufferedReader(fr);
	   String linea;
	   String s;
	   while((linea=br.readLine())!=null){
		   Scanner sl = new Scanner(linea);
		   for(int i=0; i<linea.length()-1;++i){
			   s=sl.next().toString();
		   alhosp.add(s);
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
   return alhosp;
   }
   
   
   
       public void saveHosp(ArrayList<String> alhosp,Integer archivo)
       {
           try
           {   
        	   String num = Integer.toString(archivo);
        	   String path = new File("").getAbsolutePath();
        	   String realpath = path+ "/datos/Hospital"+num;
        	  
               fw = new FileWriter(realpath);
               pw = new PrintWriter(fw);
               int i;
               for (i = 0; i < alhosp.size()-1; i++){
                   pw.print(alhosp.get(i)+ " ");
               }
               pw.print(alhosp.get(alhosp.size()-1));
           } catch (Exception e) {
               e.printStackTrace();
           } finally {
              try {
              // Nuevamente aprovechamos el finally para
              // asegurarnos que se cierra el fichero.
              if (null != fw)
                 fw.close();
              } catch (Exception e2) {
                 e2.printStackTrace();
              }
           }
       }
   
	
}
         
	
	
	/* Metodos públicos */
