package data;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import model.Calendario;
import model.Turno;

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
	
	/**Devuelve un ArrayList con strings de la forma
	 * IDHospital NombreHospital*/
	/* 					POR HACER				*/
	/*public ArrayList<String> getHospitals() {
		
	}*/
	
	public boolean existHospId(int id){
		String num = Integer.toString(id);
		   String path = new File("").getAbsolutePath();
		   String realpath = path+ "/datos/Hospital";
		   archivo = new File(realpath+num);
		   return archivo.exists();
	}
	
	
	 public ArrayList<String> getDataHospital (int id)throws IOException {
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
	   		String word;
	   		linea=br.readLine();
	   		Scanner sl = new Scanner(linea);
	   		word=sl.next();
	   		if(word.equals(".H")){
	   			int iden = sl.nextInt(); //id
	   			alhosp.add(Integer.toString(iden));
	   			word = sl.next(); // name
	   			alhosp.add(word);
	   			double fact = sl.nextDouble();//fm
	   			alhosp.add(Double.toString(fact));
	   			fact=sl.nextDouble();//ft
	   			alhosp.add(Double.toString(fact));
	   			fact=sl.nextDouble();//fn
	   			alhosp.add(Double.toString(fact));
	   		}
	   		sl.close();
	   	}catch(Exception e) {e.printStackTrace();}
	 	finally{                   
   		if( null != fr )fr.close();        
   		}
   return alhosp;
   }
	
	 public ArrayList<String> getDataDoctors (int id)throws IOException {
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
		   		String word;
		   		linea=br.readLine();
		   		linea=br.readLine();
		   		Scanner sl = new Scanner(linea);
		   		word=sl.next();
		   		if(word.equals(".D")){
		   			int numD=sl.nextInt(); //numero de doctores
		   			alhosp.add(Integer.toString(numD));
		   			for(int i=0;i<numD;++i){ //para cada doctor
						int idDoctor = sl.nextInt(); //id
						alhosp.add(Integer.toString(idDoctor));
						word = sl.next(); //nombre
						alhosp.add(word);
						int numMaxTurnos = sl.nextInt();//Maxturnos
						alhosp.add(Integer.toString(numMaxTurnos));
						double SueldoTurno = sl.nextDouble(); //sueldo
						alhosp.add(Double.toString(SueldoTurno));
						int rest = sl.nextInt();
						alhosp.add(Integer.toString(rest));
						for(int j=0;j<rest;++j){
							int idRestriccion = sl.nextInt();
							alhosp.add(Integer.toString(idRestriccion));
							word = sl.next(); //tipo
							alhosp.add(word);
							if(word.equals("NOT_Turno")){
								word = sl.next(); //tipoturno
								alhosp.add(word);
							}
							else if(word.equals("NOT_Fecha")){
								word=sl.next();//fecha
								alhosp.add(word);
							}
							else if(word.equals("NOT_Especial")){
								word=sl.next(); //especial
								alhosp.add(word);
							}
							else if(word.equals("NOT_Dia_Semana")){
								word=sl.next(); //diasemana
								alhosp.add(word);
							}
							else if(word.equals("NOT_Dia_Mes")){
								int dia =sl.nextInt();
								alhosp.add(Integer.toString(dia));
							}
							else if(word.equals("MAX_Turnos_Rango")){
								word=sl.next(); //fecha ini
								alhosp.add(word);
								word=sl.next();
								alhosp.add(word);//fecha fin
								int mt = sl.nextInt();
								alhosp.add(Integer.toString(mt));					
							}
							else if(word.equals("MAX_Turnos_por_Dia")){
								int dia =sl.nextInt();
								alhosp.add(Integer.toString(dia));
							}
							else if(word.equals("XOR")){
								int size=sl.nextInt();
								alhosp.add(Integer.toString(size));
								for(int l=0; l<size;++l){
									word=sl.next(); //fecha
									alhosp.add(word);
									word=sl.next(); //tipoturno
									alhosp.add(word);
								}
							}
						//nextres
						}//fiforRes
						//nextdoc
		   			} //fifordoc
				}//fi if	   		
		   		sl.close();
		   	}catch(Exception e) {e.printStackTrace();}
		 	finally{                   
		 		if( null != fr )fr.close();        
	   		}
		 return alhosp;
	 }
	 
	 public ArrayList<String> getDataCale (int id)throws IOException {
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
		   		String word;
		   		linea=br.readLine();
		   		linea=br.readLine();
		   		linea=br.readLine();
		   		Scanner sl = new Scanner(linea);
		   		word=sl.next();
		   		if(word.equals(".C")){
		   			int calesize = sl.nextInt();
		   			alhosp.add(Integer.toString(calesize));
		   			int value;
		   			for(int i=0;i<calesize;++i){
		   				//dia,mes,year,numDrsManana,numDrsTarde,numDrsNoche
		   				for(int j=0; j<6;++j){
		   					value=sl.nextInt();
		   					alhosp.add(Integer.toString(value));
		   				}
		   				word=sl.next(); //specialManana
		   				alhosp.add(word);
		   				word=sl.next(); //specialTarde
		   				alhosp.add(word);
		   				word=sl.next(); //specialNoche
		   				alhosp.add(word);
		   			}
		   		}//fi if	   		
		   		sl.close();
		   	}catch(Exception e) {e.printStackTrace();}
		 	finally{                   
		 		if( null != fr )fr.close();        
	   		}
	   return alhosp;
	   }
	 
	 
	/*
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
   */
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
