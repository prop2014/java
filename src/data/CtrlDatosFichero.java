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
	

	/* Constructora */
	public CtrlDatosFichero() {
		archivo = null;
	    fr=null;
	    br=null;
	    fw = null;
	    pw = null;
	}
	
	public boolean existHospId(int id){
		String num = Integer.toString(id);
		   String path = new File("").getAbsolutePath();
		   String realpath = path+ "/datos/Hospital";
		   archivo = new File(realpath+num);
		   return archivo.exists();
	}
	
	
   public ArrayList<String> getHospital (int id)throws IOException {
	   ArrayList<String> alhosp = new ArrayList<String>();
	   
	   try{
	   String num = Integer.toString(id);
	   String path = new File("").getAbsolutePath();
	   String realpath = path+ "/datos/Hospital";
	   archivo = new File(realpath+num);
	   if(!archivo.exists()) throw new IOException("No Existe Este fichero");
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
   		if( null != fr )fr.close();        
   		}
   return alhosp;
   }
   
   public ArrayList<String> getIdHopitals() throws IOException{
	   ArrayList<String> alIdHosp=new ArrayList<String>();
	   String path = new File("").getAbsolutePath();
	   String realpath = path+"/datos/";
	   this.archivo = new File(realpath);
	   File[] ficheros = archivo.listFiles();
	   if(ficheros.length==0) throw new IOException("No contiene ficheros este directorio");
	   for (int x=0;x<ficheros.length;x++){
		   if(ficheros[x].exists()){
			   String fix= ficheros[x].getName();
			   int fixsize=fix.length();
			   String id = new String();
			   for(int i=8;i<fixsize;++i){
				   id=id+fix.charAt(i);
			   }
			   alIdHosp.add(id);
		   }
		   else {}
	   }
	   return alIdHosp;
   }
   
   
   public void saveHosp(ArrayList<String> alhosp,Integer id){
       try
       {   
    	   String num = Integer.toString(id);
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
          if (null != fw)
             fw.close();
          } catch (Exception e2) {
             e2.printStackTrace();
          }
       }
   }

   
}
