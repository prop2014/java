package data;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;



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
					   			hosp = hosp+"-"+word;
					   			alHosp.add(hosp);
					   		}
				   		}
				   		sl.close();
				   		fr.close();
				   }catch(Exception e) {e.printStackTrace();}
			   }
		   }
		   return alHosp;
	   }
	

	public boolean existHospId(int id){
		String num = Integer.toString(id);
		   String path = new File("").getAbsolutePath();
		   String realpath = path+ "/datos/Hospital";
		   File archivo = new File(realpath+num);
		   return archivo.exists();
	}
	
	/**
	 * 
	 * @param id es el identificador del hospital
	 * @return los datos basicos del Hospital
	 * @throws IOException Ficheros incorrectos
	 */
	 public ArrayList<String> getDataHospital (int id)throws IOException {
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
	   		Scanner sl = new Scanner(linea);
	   		if(sl.hasNext()){
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
	 public ArrayList<String> getDataDoctors (int id)throws IOException {
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
			   			} //fifordoc
					}//fi if
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
		   		boolean HD;
		   		linea=br.readLine();
		   		linea=br.readLine();
		   		Scanner sl = new Scanner(linea);
		   		if(sl.hasNext()){
			   		word=sl.next();
			   		if(word.equals(".D")){
			   			HD=true;
			   		
					}//fi if
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
		   		while((linea=br.readLine())!=null & !exists){
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
   public ArrayList<Integer> getIdHopitals() {
	   ArrayList<Integer> alIdHosp=new ArrayList<Integer>();
	   String path = new File("").getAbsolutePath();
	   String realpath = path+"/datos/";
	   File archivo = new File(realpath);
	   File[] ficheros = archivo.listFiles();
	   for (int x=0;x<ficheros.length;x++){
		   if(ficheros[x].exists()){
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
      
   
   public void saveDataHosp(ArrayList<String> alhosp,Integer id) throws IOException{
		ArrayList<String> bufferD = new  ArrayList<String>();
	   ArrayList<String> bufferC = new  ArrayList<String>();
	   String num = Integer.toString(id);
	   String path = new File("").getAbsolutePath();
	   String realpath = path+ "/datos/Hospital"+num;
	   File archivo = new File(realpath);
	   boolean D=false,C = false;
	   if(archivo.exists()){
		   	   if(existsDoctors(id)) {
		   		   bufferD=getDataDoctors(id);
		   		   D=true;
		   	   }
			   if(existsCalendar(id)){
				   bufferC=getDataCale(id);
				   C=true;
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
			   pw.close();
		   }catch(Exception e) {e.printStackTrace();}
		   
	   }
	   else{
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
	   
   }
   public void saveDataDoctors(ArrayList<String> alhosp,Integer id) throws IOException{
	   ArrayList<String> bufferH = new  ArrayList<String>();
	   ArrayList<String> bufferC = new  ArrayList<String>();
	   String num = Integer.toString(id);
	   String path = new File("").getAbsolutePath();
	   String realpath = path+ "/datos/Hospital"+num;
	   File archivo = new File(realpath);
	   boolean C = false;
	   if(archivo.exists()){
			   bufferH=getDataHospital(id);
			   if(existsCalendar(id))  {
				   bufferC=getDataCale(id);
				   C=true;
			   }
		   try{
			   FileWriter fw = new FileWriter(archivo);
			   PrintWriter pw = new PrintWriter(fw);
			   pw.print(".H");
			   for (int i = 0; i < bufferH.size(); i++){
				   pw.print(" "+bufferH.get(i));
			   }
			   if(!alhosp.isEmpty()){
				   pw.println();
				   pw.print(".D");
				   for(int i=0; i<alhosp.size();++i){
					   pw.print(" "+alhosp.get(i));
			   		}
			   }
			   else{
				   pw.close();
				   throw new IOException("No hay datos a guardar");
			   }
			   if(C){
				   pw.println();
				   pw.print(".C");
				   for (int i = 0; i < bufferC.size(); i++){
					   pw.print(" "+bufferC.get(i));
				   } 
			   }
			   pw.close();
		   }catch(Exception e) {e.printStackTrace();}
		   
	   }
	   else{
		   throw new IOException ("Debes crear un Hospital\n");
	   }
	   
   }
   public void saveDataCale(ArrayList<String> alhosp,Integer id) throws IOException{
	   ArrayList<String> bufferH = new  ArrayList<String>();
	   ArrayList<String> bufferD = new  ArrayList<String>();
	   String num = Integer.toString(id);
	   String path = new File("").getAbsolutePath();
	   String realpath = path+ "/datos/Hospital"+num;
	   File archivo = new File(realpath);
	   boolean D = false;
	   if(archivo.exists()){
			   bufferH=getDataHospital(id);
			   if(existsDoctors(id)){
				   bufferD=getDataDoctors(id);
				   D=true;
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
				   pw.close();
			   }
			   else{
				   pw.close();
				   throw new IOException("No hay datos a guardar");
			   }
		   }catch(Exception e) {e.printStackTrace();}
		   
	   }
	   else{
		   throw new IOException ("Debes Crear un Hospital\n");
	   }
	   
   }
   
  /* public void saveHosp(ArrayList<String> alhosp,Integer id)throws IOException{
       	   bufferD.clear();
       	   bufferC.clear();
    	   String num = Integer.toString(id);
    	   String path = new File("").getAbsolutePath();
    	   String realpath = path+ "/datos/Hospital"+num;
    	   File archivo = new File(realpath);
    	   if(archivo.exists()){
	    		   bufferD = getDataDoctors(id);
	    		   bufferC = getDataCale(id);
    	   	   try{
    	   		   //archiu llegit i gurardat en buffer
    	   		   FileWriter fw = new FileWriter(archivo);
    	   		   PrintWriter pw = new PrintWriter(fw);
    	   		   int i;
    	   		   for (i = 0; i < alhosp.size()-1; i++){
    	   			   pw.print(alhosp.get(i)+ " ");
    	   		   }
    	   		   pw.print(alhosp.get(alhosp.size()-1));
    	   		   for(int j=0;j<bufferD.size()-1;++i){
    	   			   if(bufferD.get(j).equals(".D")){
    	   				   pw.println(bufferD.get(j));
    	   		   	   }
    	   			   else{
    	   				   pw.print(bufferD.get(j)+ " ");
    	   			   }
    	   		   }
    	   		   pw.print(bufferD.get(bufferD.size()-1));
    	   		   
    	   		   for(int j=0;j<bufferC.size()-1;++i){
	 	   			   if(bufferC.get(j).equals(".C")){
	 	   				   pw.println(bufferC.get(j));
	 	   		   	   }
	 	   			   else{
	 	   				   pw.print(bufferC.get(j)+ " ");
	 	   			   }
	 	   		   }
    	   		   pw.print(bufferC.get(bufferC.size()-1));
    	   		   pw.close();
    	   		   fw.close();
    	   	   }catch (Exception e) {e.printStackTrace();} 
    	   }
    	   else {
    		   try{
    			   FileWriter fw = new FileWriter(archivo);
    			   PrintWriter pw = new PrintWriter(fw);
	    		   int i;
	    		   for (i = 0; i < 5; i++){
	    			   pw.print(alhosp.get(i)+ " ");
	    		   }
	    		   pw.print(alhosp.get(5));
	    		   pw.println(alhosp.get(6)+" ");
	    		   i=7;
	    		   while (!alhosp.get(i).equals(".C")){
	    			   pw.print(alhosp.get(i));
	    			   ++i;
	    		   }
	    		   pw.println(alhosp.get(i));
	    		   ++i;
	    		   int size=Integer.parseInt(alhosp.get(i));
	    		   for(int j=size;j<alhosp.size();++j){
	    			   pw.print(" "+alhosp.get(i));
	    			   ++i;
	    		   }
	    		   pw.close();
	    		   fw.close();
    		   }catch (Exception e) {e.printStackTrace();} 
    	   }//fielse 
       }
*/
   
}//ficlas
