package data;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import model.Turno;
import model.XOR;



/**Gestiona el sistema de almacenamiento de datos
 * 
 * @author oscar
 *
 */
public class CtrlDatosFichero {
	
	public CtrlDatosFichero() {}

	 public ArrayList<String> getHopitals() throws IOException{
		   ArrayList<String> alHosp=new ArrayList<String>();
		   String hosp = new String();
		   String path = new File("").getAbsolutePath();
		   String realpath = path+"/datos/";
		   File archivo = new File(realpath);
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
				   hosp = id;
				   //alHosp.add(id);
				   try{
					   	FileReader fr = new FileReader (archivo+"/"+fix);
						BufferedReader br = new BufferedReader(fr);
				   		String linea;
				   		String word;
				   		linea=br.readLine();
				   		Scanner sl = new Scanner(linea);
				   		if(sl.hasNext()){
				   			word=sl.next();
					   		if(word.equals(".H")){
					   			int iden = sl.nextInt(); //id
					   			word = sl.next(); // name
					   			hosp = iden+"-"+word;
					   			alHosp.add(hosp);
					   		}
				   		}
				   		sl.close();
				   		fr.close();
				   }catch(Exception e) {e.printStackTrace();}
			   }
		   }
		   Collections.sort(alHosp, new Comparator<String>() 
		            { public int compare(String p, String q)
		            {
		            	String[] partP = p.split("-");
		            	String[] partQ = q.split("-");
		            	int pNum = Integer.parseInt(partP[0]);
		            	int qNum = Integer.parseInt(partQ[0]);
			            if(pNum > qNum) return 1;
			            if(pNum < qNum) return -1;
		                return 0;
		            }
		            } ); 
		   return alHosp;
	   }
	
	 

	 public ArrayList<Integer> getIdHopitals() {
		   ArrayList<Integer> alIdHosp=new ArrayList<Integer>();
		   String path = new File("").getAbsolutePath();
		   String realpath = path+"/datos/";
		   File archivo = new File(realpath);
		   File[] ficheros = archivo.listFiles();
		   for (int x=0;x<ficheros.length;x++){
			   if(ficheros[x].exists() && !((ficheros[x].getName()).equals(".DS_Store"))){
				   String fix= ficheros[x].getName();
				   int fixsize=fix.length();
				   String id = new String();
				   for(int i=8;i<fixsize;++i){
					   id=id+fix.charAt(i);
				   }
				   alIdHosp.add(Integer.parseInt(id));
			   }
		   }
		   Collections.sort(alIdHosp, new Comparator<Integer>() 
			            { public int compare(Integer p, Integer q)
			            {
				            if(p > q) return 1;
				            if(p < q) return -1;
			                return 0;
			            }
			            } ); 
	   
			   
		   return alIdHosp;
	   }
	 
	 
	 
	 public ArrayList<String> getInfoHospital (int id)throws IOException {
		 	ArrayList<String> alhosp = new ArrayList<String>();
		 	try{
		 		File archivo;
	 			String num = Integer.toString(id);
		   		String path = new File("").getAbsolutePath();
		   		String realpath = path+ "/datos/Hospital";
		   		archivo = new File(realpath+num);
		 		
				if(!archivo.exists()) throw new IOException("No Existe Este fichero");
				FileReader fr = new FileReader (archivo);
				BufferedReader br = new BufferedReader(fr);
		   		String linea;
		   		String word;
		   		linea=br.readLine();
		   		Scanner sl = new Scanner(linea);
		   		if(sl.hasNext()){
		   			word=sl.next();
			   		if(word.equals(".H")){
			   			int iden = sl.nextInt(); //id
			   			alhosp.add(Integer.toString(iden));
			   			word = sl.next(); // name
			   			alhosp.add(word);
			   			String fact = sl.next();//fm
			   			alhosp.add(fact);
			   			fact=sl.next();//ft
			   			alhosp.add(fact);
			   			fact=sl.next();//fn
			   			alhosp.add(fact);
			   		}
			   		boolean foundD = false;
			   		boolean foundC = false;
			   		sl.close();
			   		linea=br.readLine();
			   		if(linea != null) {
				   		Scanner sl2 = new Scanner(linea);
				   		while(sl2.hasNext() && !foundD) {
				   			word = sl2.next();
				   			if(word.equals(".D")){
				   				foundD = true;
				   				word = sl2.next(); //numDoc
				   				alhosp.add(word);
				   				break;
				   			}
				   		}
				   		sl2.close();
			   		}
			   		if(!foundD) alhosp.add("0");
			   		
			   		linea=br.readLine();
			   		if(linea != null) {
			   			Scanner sl3 = new Scanner(linea);
				   		while(sl3.hasNext() && !foundC) {
				   			word = sl3.next();
				   			if(word.equals(".C")){
				   				foundC = true;
				   				word = sl3.next(); //anyo
				   				word = sl3.next(); //nTurnos
				   				alhosp.add(word);
				   				break;
				   			}
				   		}
				   		sl3.close();
			   		}
			   		if(!foundC) alhosp.add("0");
		   		}
		   		
		   		fr.close();
		   	}catch(Exception e) {e.printStackTrace();}
	   return alhosp;
	   }
	 
	 
	/**
	 * 
	 * @param id es el identificador del hospital
	 * @return los datos basicos del Hospital
	 * @throws IOException Ficheros incorrectos
	 */
	 public ArrayList<String> getDataHospital (int id,String importar)throws IOException {
	 	ArrayList<String> alhosp = new ArrayList<String>();
	 	try{
	 		File archivo;
	 		if(importar==null){
	 			String num = Integer.toString(id);
		   		String path = new File("").getAbsolutePath();
		   		String realpath = path+ "/datos/Hospital";
		   		archivo = new File(realpath+num);
	 		}
	 		else{
	 			archivo = new File(importar);
	 			
	 		}
			if(!archivo.exists()) throw new IOException("No Existe Este fichero");
			FileReader fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
	   		String linea;
	   		String word;
	   		linea=br.readLine();
	   		Scanner sl = new Scanner(linea);
	   		if(sl.hasNext()){
	   			word=sl.next();
		   		if(word.equals(".H")){
		   			int iden = sl.nextInt(); //id
		   			alhosp.add(Integer.toString(iden));
		   			word = sl.next(); // name
		   			alhosp.add(word);
		   			String fact = sl.next();//fm
		   			alhosp.add(fact);
		   			fact=sl.next();//ft
		   			alhosp.add(fact);
		   			fact=sl.next();//fn
		   			alhosp.add(fact);
		   		}
	   		}
	   		sl.close();
	   		fr.close();
	   	}catch(Exception e) {e.printStackTrace();}
   return alhosp;
   }
	
	 /**
	  * 
	  * @param id el identificador del Hospital
	  * @return los datos de los doctores del hospital
	  * @throws IOException existencia de fichero
	  */
	 public ArrayList<String> getDataDoctors (int id,String importar)throws IOException {
		 	ArrayList<String> alhosp = new ArrayList<String>();
		 	try{
		 		File archivo;
		 		if(importar==null){
		 			String num = Integer.toString(id);
			   		String path = new File("").getAbsolutePath();
			   		String realpath = path+ "/datos/Hospital";
			   		archivo = new File(realpath+num);
		 		}
		 		else{
		 			archivo = new File(importar);
		 			
		 		}
				if(!archivo.exists()) throw new IOException("No Existe Este fichero");
				FileReader fr = new FileReader (archivo);
				BufferedReader br = new BufferedReader(fr);
				boolean exists =false;
		   		String linea;
		   		String word;
		   		while(((linea=br.readLine())!=null) && !exists ){
		   			Scanner sl = new Scanner(linea);
			   		if(sl.hasNext()){
				   		word=sl.next();
				   		if(word.equals(".D")){
				   			exists=true;
				   			int numD=sl.nextInt(); //numero de doctores
				   			alhosp.add(Integer.toString(numD));
				   			for(int i=0;i<numD;++i){ //para cada doctor
								String idDoctor = sl.next(); //id
								alhosp.add(idDoctor);
								word = sl.next(); //nombre
								alhosp.add(word);
								String numMaxTurnos = sl.next();//Maxturnos
								alhosp.add(numMaxTurnos);
								String SueldoTurno = sl.next(); //sueldo
								alhosp.add(SueldoTurno);
				   			} //fifordoc
						}//fi if
			   		}
			   		sl.close();
		   		}
			   		fr.close();
			   		/*if(!exists) {
			   			throw new IOException("No hay doctores");
			   		}*/
		   	}catch(Exception e) {e.printStackTrace();}
		 return alhosp;
	 }
	 
	 
	 
	 /**
	  * 
	  * @param id identificador del Hospital
	  * @return los datos del calendario del hospital con identificador=id
	  * @throws IOException no existe fichero
	  */
	 public ArrayList<String> getDataCale (int id)throws IOException {
		 	ArrayList<String> alhosp = new ArrayList<String>();
		 	try{
		   		String num = Integer.toString(id);
		   		String path = new File("").getAbsolutePath();
		   		String realpath = path+ "/datos/Hospital";
		   		File archivo = new File(realpath+num);
				if(!archivo.exists()) throw new IOException("No Existe Este fichero");
				FileReader fr = new FileReader (archivo);
				BufferedReader br = new BufferedReader(fr);
		   		String linea;
		   		boolean exists=false;
		   		String word;
		   		while((linea=br.readLine())!=null && !exists){
			   		Scanner sl = new Scanner(linea);
			   		if(sl.hasNext()){
				   		word=sl.next();
				   		if(word.equals(".C")){
				   			exists=true;
				   			int year = sl.nextInt(); //any
				   			alhosp.add(Integer.toString(year));
				   			int calesize = sl.nextInt(); //calesize
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
				   		}
				   		sl.close();
			   		}
			   	}
		   		br.close();
		   	}catch(Exception e) {e.printStackTrace();}
	   return alhosp;
	   }
	 public ArrayList<String> getDataRes (int id)throws IOException {
		 	ArrayList<String> alhosp = new ArrayList<String>();
		 	try{
		   		String num = Integer.toString(id);
		   		String path = new File("").getAbsolutePath();
		   		String realpath = path+ "/datos/Hospital";
		   		File archivo = new File(realpath+num);
				if(!archivo.exists()) throw new IOException("No Existe Este fichero");
				FileReader fr = new FileReader (archivo);
				BufferedReader br = new BufferedReader(fr);
		   		String linea;
		   		String word;
		   		linea=br.readLine();
		   		linea=br.readLine();
		   		Scanner sl = new Scanner(linea);
		   		if(sl.hasNext()){
			   		word=sl.next();
			   		if(word.equals(".D")){
			   			while((linea=br.readLine())!=null){
				   			Scanner sl1 = new Scanner(linea);
				   			if(sl1.hasNext()){
				   				word=sl1.next();
				   				if(word.equals(".R")){
				   					while(sl1.hasNext()){
					   					alhosp.add(sl1.next());
					   					int numRes = sl1.nextInt();
					   					alhosp.add(Integer.toString(numRes));
					   					for(int i=0;i<numRes;++i){
					   						alhosp.add(sl1.next());
					   						String Tipo=sl1.next();
					   						alhosp.add(Tipo);
					   						if(Tipo.equals("NOT_Turno")){
					   							alhosp.add(sl1.next());
					   						}
					   						else if(Tipo.equals("NOT_Fecha")){
					   							alhosp.add(sl1.next());
					   						}
					   						else if(Tipo.equals("NOT_Especial")){
					   							alhosp.add(sl1.next());
					   						}
					   						else if(Tipo.equals("NOT_Dia_Semana")){
					   							alhosp.add(sl1.next());
					   						}
					   						else if(Tipo.equals("NOT_Dia_Mes")){
					   							alhosp.add(sl1.next());
					   						}
					   						else if(Tipo.equals("MAX_Turnos_Rango")){
												alhosp.add(sl1.next());
												alhosp.add(sl1.next());
												alhosp.add(sl1.next());					
					   						}
					   						else if(Tipo.equals("MAX_Turnos_por_Dia")){
					   							int dia =sl1.nextInt();
					   							alhosp.add(Integer.toString(dia));
					   						}
					   						else if(Tipo.equals("XOR")){
					   							int size=sl1.nextInt();
					   							alhosp.add(Integer.toString(size));
					   							for(int l=0; l<size;++l){
					   								alhosp.add(sl.next());
					   								alhosp.add(sl.next());
					   								alhosp.add(sl.next());
					   								alhosp.add(sl.next());
					   							}
					   						}
					   					}
					   					
				   					}
				   				}
				   			}
				   			sl1.close();
				   		}
					}
			   		else {
			   			sl.close();
			   			fr.close();
			   			throw new IOException("No hay doctores");
			   		}
		   		}
		   		sl.close();
		   		fr.close();
		   	}catch(Exception e) {e.printStackTrace();}
		 return alhosp;
	   }
	 
	public int getYear(int id,String Path) throws IOException{
		int year=-1;
		
		File archivo;
 		if(Path==null){
 			String num = Integer.toString(id);
	   		String path = new File("").getAbsolutePath();
	   		String realpath = path+ "/datos/Hospital";
	   		archivo = new File(realpath+num);
 		}
 		else{
 			archivo = new File(Path);
 			
 		}
		if(!archivo.exists()) throw new IOException("No Existe Este fichero");
		try{
			FileReader fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea;
   			String word;
   			while((linea=br.readLine())!=null){
		   		Scanner sl = new Scanner(linea);
		   		if(sl.hasNext()){
			   		word=sl.next();
			   		if(word.equals(".C")){
			   			year = sl.nextInt();
   					}
   				sl.close();
		   		}
		   	}
   			br.close();
		}catch(Exception e) {e.printStackTrace();}
		if(year<0)throw new IOException("id Negativo");
		return year;
	}
	 
	public int getId(String Path)throws IOException{
		int id=-1;
		File archivo = new File(Path);
		if(!archivo.exists()) throw new IOException("No Existe Este fichero");
		try{
			FileReader fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea;
   			String word;
   			linea=br.readLine();
   			Scanner sl = new Scanner(linea);
   			if(sl.hasNext()){
   				word=sl.next();
   				if(word.equals(".H")){
   					id = sl.nextInt(); //id
   				}
   				sl.close();
   			}
   			br.close();
		}catch(Exception e) {e.printStackTrace();}
		if(id<0)throw new IOException("id Negativo");
		return id;
	}
	 
	public boolean existHospId(int id){
		String num = Integer.toString(id);
		   String path = new File("").getAbsolutePath();
		   String realpath = path+ "/datos/Hospital";
		   File archivo = new File(realpath+num);
		   return archivo.exists();
	}
	 
	 public boolean existsCalendar(int id) throws IOException{
		 boolean exists=false;
		 try{
		   		String num = Integer.toString(id);
		   		String path = new File("").getAbsolutePath();
		   		String realpath = path+ "/datos/Hospital";
		   		File archivo = new File(realpath+num);
				if(archivo.exists()) {
					FileReader fr = new FileReader (archivo);
					BufferedReader br = new BufferedReader(fr);
					String linea;
					while((linea=br.readLine())!=null){
			   			Scanner sl = new Scanner(linea);
			   			if(sl.hasNext()){
			   				if(sl.next().equals(".C")) exists=true;
			   			}
			   			sl.close();
			   		}
					br.close();
				}
		 }catch(Exception e) {e.printStackTrace();}
		  return exists;
	 }
	 
	 public boolean existsDoctors(int id) throws IOException{
		 boolean exists=false;
		 try{
		   		String num = Integer.toString(id);
		   		String path = new File("").getAbsolutePath();
		   		String realpath = path+ "/datos/Hospital";
		   		File archivo = new File(realpath+num);
				if(archivo.exists()) {
					FileReader fr = new FileReader (archivo);
					BufferedReader br = new BufferedReader(fr);
					String linea;
					while((linea=br.readLine())!=null & !exists){
			   			Scanner sl = new Scanner(linea);
			   			if(sl.hasNext()){
			   				if(sl.next().equals(".D")) exists=true;
			   			}
			   			sl.close();
			   		}
					br.close();
				}
		 }catch(Exception e) {e.printStackTrace();}
		  return exists;
	 }
	 
	 public boolean existsRes(int id) throws IOException{
		 boolean exists=false;
		 try{
		   		String num = Integer.toString(id);
		   		String path = new File("").getAbsolutePath();
		   		String realpath = path+ "/datos/Hospital";
		   		File archivo = new File(realpath+num);
				if(archivo.exists()) {
					FileReader fr = new FileReader (archivo);
					BufferedReader br = new BufferedReader(fr);
					String linea;
					while((linea=br.readLine())!=null & !exists){
			   			Scanner sl = new Scanner(linea);
			   			if(sl.hasNext()){
			   				if(sl.next().equals(".R")) exists=true;
			   			}
			   			sl.close();
			   		}
					br.close();
				}
		 }catch(Exception e) {e.printStackTrace();}
		  return exists;
	 }
	 
	 
	 
	 /*int rest = sl.nextInt();
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
		} */
	 
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
   
      
   
   public void saveDataHosp(ArrayList<String> alhosp,Integer id) throws IOException{
		ArrayList<String> bufferD = new  ArrayList<String>();
	   ArrayList<String> bufferC = new  ArrayList<String>();
	   ArrayList<String> bufferR = new  ArrayList<String>();
	   String num = Integer.toString(id);
	   String path = new File("").getAbsolutePath();
	   String realpath = path+ "/datos/Hospital"+num;
	   File archivo = new File(realpath);
	   boolean D=false,C = false, R = false;
	   if(archivo.exists() && !alhosp.isEmpty()){
		   	   if(existsDoctors(id)) {
		   		   bufferD=getDataDoctors(id,null);
		   		   D=true;
		   	   }
			   if(existsCalendar(id)){
				   bufferC=getDataCale(id);
				   C=true;
		   	   }
			   if(existsRes(id)){
				   bufferR=getDataRes(id);
				   R=true;
			   }
		   try{
			   FileWriter fw = new FileWriter(archivo);
			   PrintWriter pw = new PrintWriter(fw);
			   int i;
			   pw.print(".H");
			   for (i = 0; i < alhosp.size(); i++){
				   pw.print(" "+alhosp.get(i));
			   }
			   if(D){
				   pw.println();
				   pw.print(".D");
				   for (i = 0; i <bufferD.size(); i++){
					   pw.print(" "+bufferD.get(i));
				   }
			   }
			   if(C){
				   pw.println();
				   pw.print(".C");
				   for (i = 0; i <bufferC.size(); i++){
					   pw.print(" "+bufferC.get(i));
				   }
			   }
			   if(D&&R){
				   pw.println();
				   pw.print(".R");
				   for (i = 0; i <bufferR.size(); i++){
					   pw.print(" "+bufferR.get(i));
				   }
			   }
			   pw.close();
		   }catch(Exception e) {e.printStackTrace();}
		   
	   }
	   else if (!alhosp.isEmpty()){
		   try{
			   FileWriter fw = new FileWriter(archivo);
			   PrintWriter pw = new PrintWriter(fw);
			   int i;
			   pw.print(".H");
			   for (i = 0; i < alhosp.size(); i++){
				   pw.print(" "+alhosp.get(i));
			   }
			   pw.close();
		   }catch(Exception e) {e.printStackTrace();}
	   }
	   else {
		   throw new IOException ("No Hay datos a guardar");
	   }
	   
   }
   public void saveDataDoctors(ArrayList<String> alhosp,Integer id) throws IOException{
	   ArrayList<String> bufferH = new  ArrayList<String>();
	   ArrayList<String> bufferC = new  ArrayList<String>();
	   ArrayList<String> bufferR = new ArrayList<String>();
	   String num = Integer.toString(id);
	   String path = new File("").getAbsolutePath();
	   String realpath = path+ "/datos/Hospital"+num;
	   File archivo = new File(realpath);
	   boolean C = false, R=false;
	   if(archivo.exists()){
			   bufferH=getDataHospital(id,null);
			   if(existsCalendar(id))  {
				   bufferC=getDataCale(id);
				   C=true;
			   }
			   if(existsRes(id)){
				   bufferR=getDataRes(id);
				   R=true;
			   }
		   try{
			   if(!alhosp.isEmpty()){
				   FileWriter fw = new FileWriter(archivo);
				   PrintWriter pw = new PrintWriter(fw);
				   pw.print(".H");
				   for (int i = 0; i < bufferH.size(); i++){
					   pw.print(" "+bufferH.get(i));
				   }
				   pw.println();
				   pw.print(".D");
				   for(int i=0; i<alhosp.size();++i){
					   pw.print(" "+alhosp.get(i));
			   		}
				   if(C){
					   pw.println();
					   pw.print(".C");
					   for (int i = 0; i < bufferC.size(); i++){
						   pw.print(" "+bufferC.get(i));
					   } 
				   }
				   if(R){
					   pw.println();
					   pw.print(".R");
					   for (int i = 0; i < bufferR.size(); i++){
						   pw.print(" "+bufferR.get(i));
					   } 
				   }
				   pw.close();
			   }
			   else{
				   throw new IOException("No hay datos a guardar");
			   }
		   }catch(Exception e) {e.printStackTrace();}
		   
	   }
	   else{
		   throw new IOException ("Debes crear un Hospital\n");
	   }
	   
   }
   
   public void saveDataRes(ArrayList<String> alhosp,Integer id) throws IOException{
	   ArrayList<String> bufferH = new  ArrayList<String>();
	   ArrayList<String> bufferD = new  ArrayList<String>();
	   ArrayList<String> bufferC = new  ArrayList<String>();
	   String num = Integer.toString(id);
	   String path = new File("").getAbsolutePath();
	   String realpath = path+ "/datos/Hospital"+num;
	   File archivo = new File(realpath);
	   boolean C = false, D = false;
	   if(archivo.exists()){
		   	if(existsDoctors(id)){
		   			D=true;
				   bufferH=getDataHospital(id,null);
				   if(existsCalendar(id))  {
					   bufferC=getDataCale(id);
					   C=true;
				   }
				   bufferD=getDataDoctors(id,null);
			   try{
				   FileWriter fw = new FileWriter(archivo);
				   PrintWriter pw = new PrintWriter(fw);
				   pw.print(".H");
				   for (int i = 0; i < bufferH.size(); i++){
					   pw.print(" "+bufferH.get(i));
				   }
				   if(D){
					   pw.println();
					   pw.print(".D");
					   for(int i=0; i<bufferD.size();++i){
						   pw.print(" "+bufferD.get(i));
				   		}
				   }
				   if(C){
					   pw.println();
					   pw.print(".C");
					   for (int i = 0; i < bufferC.size(); i++){
						   pw.print(" "+bufferC.get(i));
					   } 
				   }
				   if(!alhosp.isEmpty()){
					   pw.println();
					   pw.print(".R");
					   for(int i=0; i<alhosp.size();++i){
						   pw.print(" "+alhosp.get(i));
				   		}
				   }
				   else{
					   pw.close(); 
					   throw new IOException("no hay datos a guardar\n");
				   }
				   pw.close();
			   }catch(Exception e) {e.printStackTrace();}
		   	}
		   	else {
		   		throw new IOException ("No hay doctores\n");
		   	}
	   }
	   else{
		   throw new IOException ("Debes crear un Hospital\n");
	   }
	   
   }
   
   public void saveDataCale(ArrayList<String> alhosp,Integer id) throws IOException{
	   ArrayList<String> bufferH = new  ArrayList<String>();
	   ArrayList<String> bufferD = new  ArrayList<String>();
	   ArrayList<String> bufferR = new  ArrayList<String>();
	   String num = Integer.toString(id);
	   String path = new File("").getAbsolutePath();
	   String realpath = path+ "/datos/Hospital"+num;
	   File archivo = new File(realpath);
	   boolean D = false, R = false;
	   if(archivo.exists()){
			   bufferH=getDataHospital(id,null);
			   if(existsDoctors(id)){
				   bufferD=getDataDoctors(id,null);
				   D=true;
				   if(existsRes(id)){
					   bufferR=getDataRes(id);
					   R=true;
				   }
			   }
		   try{
			   FileWriter fw = new FileWriter(archivo);
			   PrintWriter pw = new PrintWriter(fw);
			   pw.print(".H");
			   for (int i = 0; i < bufferH.size(); i++){
				   pw.print(" "+bufferH.get(i));
			   }
			   if(D){
				   pw.println();
				   pw.print(".D");
				   for(int i=0; i<bufferD.size();++i){
					   pw.print(" "+bufferD.get(i));
				   	}
			   }
			   if(!alhosp.isEmpty()){
				   pw.println();
				   pw.print(".C");
				   for (int i = 0; i < alhosp.size(); i++){
					  pw.print(" "+alhosp.get(i));
				   }
			   }
			   else{
				   pw.close();
				   throw new IOException("No hay datos a guardar");
			   }
			   if(R){
				   pw.println();
				   pw.print(".R");
				   for (int i = 0; i < bufferR.size(); i++){
					  pw.print(" "+bufferR.get(i));
				   }
			   }
			   pw.close();
		   }catch(Exception e) {e.printStackTrace();}
		   
	   }
	   else{
		   throw new IOException ("Debes Crear un Hospital\n");
	   }
	   
   }
   
   public void removePart(int id,String part)throws IOException{
	   ArrayList<String> bufferH = new  ArrayList<String>();
	   ArrayList<String> bufferD = new  ArrayList<String>();
	   ArrayList<String> bufferR = new  ArrayList<String>();
	   ArrayList<String> bufferC = new  ArrayList<String>();
	   String num = Integer.toString(id);
	   String path = new File("").getAbsolutePath();
	   String realpath = path+ "/datos/Hospital"+num;
	   File archivo = new File(realpath);
	   boolean H = false, D =false, C=false, R = false;
	   if(archivo.exists()){
			   bufferH=getDataHospital(id,null);
			   H =true;
			   if(existsDoctors(id)){
				   bufferD=getDataDoctors(id,null);
				   D=true;
			   }
			   if(existsRes(id)){
				   bufferR=getDataRes(id);
				   R=true;
			   }
			   if(existsCalendar(id)){
				   bufferC=getDataCale(id);
				   C=true;
			   }
			   if(part.equals(".H")){
				   H=false;
				   D=false;
				   C=false;
				   R=false;
			   }
			   if(part.equals(".D")){
				   D=false;
				   R=false;
			   }
			   if(part.equals(".C")){
				   C=false;
			   }
			   if(part.equals(".R")){
				   R=false;
			   }
			 
		   try{
			   FileWriter fw = new FileWriter(archivo);
			   PrintWriter pw = new PrintWriter(fw);
			   if(H){
			   pw.print(".H");
			   for (int i = 0; i < bufferH.size(); i++){
				   pw.print(" "+bufferH.get(i));
			   }
			   }
			   if(D){
				   pw.println();
				   pw.print(".D");
				   for(int i=0; i<bufferD.size();++i){
					   pw.print(" "+bufferD.get(i));
				   	}
			   }
			   if(C){
				   pw.println();
				   pw.print(".C");
				   for (int i = 0; i < bufferC.size(); i++){
					  pw.print(" "+bufferC.get(i));
				   }
			   }
			   if(R){
				   pw.println();
				   pw.print(".R");
				   for (int i = 0; i < bufferR.size(); i++){
					  pw.print(" "+bufferR.get(i));
				   }
			   }
			   pw.close();
			   if(!H){
				   if(!archivo.delete())throw new IOException("No se ha borrado el archivo");
				   fw.close();
			   }
		   }catch(Exception e) {e.printStackTrace();}
		   
	   }
   }
   
}//ficlas
