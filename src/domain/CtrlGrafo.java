package domain;
import java.io.IOException;
import java.util.*;

import model.*;

public class CtrlGrafo {
	
	private int firstdoc;
	private int lastdoc;
	private int firsttorn;
	private int lasttorn;
	private int sink;
	private Graf<Nodo> grafo;
	
	
	public CtrlGrafo(){
		grafo=new Graf<Nodo>();
	}
	
	public Graf<Nodo> getGraf(){
		return grafo;
	}
	
	static String itos (int dia){
		String t;
		if(dia==0) t="monday";
		else if(dia==1) t = "tuesday";
		else if(dia==2) t = "wednesday";
		else if(dia==3) t = "thursday";
		else if(dia==4) t = "friday";
		else if(dia==5) t = "saturday";
		else t = "sunday";
		return t; 
	}
	
	public void llenarGrafo(Hospital h) throws IOException {
		
		double fm, ft, fn;
		fm=h.getFactorM();
		ft=h.getFactorT();
		fn=h.getFactorN();
		
		int id = 0;
		// creamos grafo
		Nodo Source = new Nodo(0, "Source");	// creamos nodo source
		grafo.afegirNode(Source);    			//A�adimos el source
		ArrayList<Doctor> aldoc = new ArrayList<Doctor>();
		aldoc = h.getDoctors();					//aldoc: lista de doctores del hospital
		for (int i = 0; i < aldoc.size(); ++i) {
			++id;
			if(i==0) firstdoc = id;
			nodoDoctor nDoc = new nodoDoctor(id, "Doctor", aldoc.get(i).getId());
			grafo.afegirNode(nDoc);
			grafo.conectarNodes(0, id, aldoc.get(i).getNumMaxTurn(), 0.0);
		}
		
		lastdoc = id;
		++id;
		Nodo Sink = new Nodo(id, "Sink");
		grafo.afegirNode(Sink);
		sink = id;
		//nodos de doctores añadidos
		//añadimos todos los turnos al grafo
		ArrayList<Turno> alturnos = new ArrayList<Turno> ();
		Calendario cal = h.getCalendario();
		alturnos = cal.getALLShifts();
		
		for (int i = 0; i < alturnos.size(); ++i) {
			++id;
			if(i==0) firsttorn = id;
			nodoTurno nturn = new nodoTurno(id,"Turno", alturnos.get(i).getDate(), alturnos.get(i).getShiftType());
			grafo.afegirNode(nturn);
			grafo.conectarNodes(id, sink, alturnos.get(i).getNumberOfDoctors(),0.0); 
		}
		lasttorn=id;
		++id; //id nodo reestriccion actualizado!!!!!!!!!!!!!!!!!
				
		
		//nodos de turnos añadidos	
		// ahora vamos a añadir las restricciones de cada doctor.
		for(int i=firstdoc;i<=lastdoc;++i){ //para cada doctor:
			
				//caso base donde no hay restricciones
			if(aldoc.get(i-firstdoc).isREmpty()){
				 //lo conectamos con todos los turnos
				for(int j=firsttorn;j<=lasttorn;++j){
					int capacidad=1; //
					double coste =0;
					String tt = alturnos.get(j-firsttorn).getShiftType();
					double sueldo = aldoc.get(i-firstdoc).getSalaryTurn();
					if(tt.equals("morning")) coste=fm*sueldo;
					else if(tt.equals("afternoon")) coste=ft*sueldo;
					else if(tt.equals("evening")) coste=fn*sueldo;
					grafo.conectarNodes(i, j, capacidad, coste);
				}
			}
			else {
			//caso donde si hay restricciones
				boolean Turnos[] = new boolean[alturnos.size()];
				for(int k=0;k<alturnos.size();++k) {
					Turnos[k]=true;
				}
				ArrayList<Restriccion> alRest = aldoc.get(i-firstdoc).getRestrictions();
				
				for(int k=0;k<alRest.size();++k){
					Restriccion res = alRest.get(k); //tengo la restriccion
					String restipe =res.getTipo(); // tengo el tipo
					
					if(restipe.equals("NOT_Turno")){
						NOT_Turno N = (NOT_Turno)res;
						String t = N.getTipoTurno();  
						for(int m=0;m<alturnos.size();++m){
							String tipot=alturnos.get(m).getShiftType(); //tipo de turno;
							if(t.equals(tipot)){
								Turnos[m]=false;
							}
						}
					}
					else if(restipe.equals("NOT_Fecha")){
						NOT_Fecha N = (NOT_Fecha)res;
						GregorianCalendar gc = N.getFecha();
						int cont=0;
						for(int m=0;m<alturnos.size();++m){
							GregorianCalendar gc1 = alturnos.get(m).getDate();
							if(gc1==gc){
								Turnos[m]=false;
								++cont;
							}
							if (cont==3) break;
						}
					}
					else if(restipe.equals("NOT_Especial")){
						NOT_Especial N = (NOT_Especial)res;
						String t =N.getEspecial();
						for(int m=0;m<alturnos.size();++m){
							String tipot=alturnos.get(m).getSpecialDate();
							if(t.equals(tipot)){
								Turnos[m]=false;
							}
						}
					}
					else if(restipe.equals("NOT_Dia_Semana")){
						NOT_Dia_Semana N = (NOT_Dia_Semana)res;
						String t = N.getDiaSemana();
						for(int m=0;m<alturnos.size();++m){
							GregorianCalendar gc1=alturnos.get(m).getDate();
							int weekN = gc1.get(GregorianCalendar.DAY_OF_WEEK);
							String strWeek=itos(weekN);
							if(t.equals(strWeek)){
								Turnos[m]=false;
							}
						}
						
					}
					else if (restipe.equals("NOT_Dia_Mes")){
						NOT_Dia_Mes N = (NOT_Dia_Mes)res;
						int  dia = N.getDiaMes();
						for(int m=0;m<alturnos.size();++m){
							GregorianCalendar gc1=alturnos.get(m).getDate();
							int day = gc1.get(GregorianCalendar.DAY_OF_MONTH);
							if(dia==day){
								Turnos[m]=false;
							}
						}
						
					}				
				}
				//hemos tratado las NOT vamos a tratar las demas
				for(int k=0;k<alRest.size();++k){
					Restriccion res = alRest.get(k); //tengo la restriccion
					String restipe =res.getTipo(); // tengo el tipo
					
					if (restipe.equals("XOR")){
						Nodo XOR = new Nodo(id, "XOR");
						grafo.afegirNode(XOR);
						grafo.conectarNodes(i, id ,1, 0.0);
						ArrayList<Turno> xorTurnos = ((XOR)res).getListTurnos();
						boolean modif = false;
						for(Turno turno : xorTurnos) {
							for(int m = 0; m < alturnos.size(); ++m) {
								if(alturnos.get(m).getDate() == turno.getDate() && alturnos.get(m).getShiftType() == turno.getShiftType()) {
									modif = true;
									int capacidad = 1;
									double coste = 0;
									String tt = alturnos.get(m).getShiftType();
									double sueldo = aldoc.get(i-firstdoc).getSalaryTurn();
									if(tt.equals("morning")) coste=fm*sueldo;
									else if(tt.equals("afternoon")) coste=ft*sueldo;
									else if(tt.equals("evening")) coste=fn*sueldo;
									grafo.conectarNodes(id, m+firsttorn, capacidad, coste);
								}
							}
						}
						if(modif==true)++id;
						else {
							grafo.removeNode(id);
						}
					}
				}
				for(int k=0;k<alRest.size();++k){
					Restriccion res = alRest.get(k);
					String restipe =res.getTipo(); 
					if (restipe.equals("MAX_Turnos_por_Dia")){
						MAX_Turnos_por_Dia N = (MAX_Turnos_por_Dia)res;
						int max = N.getNumTurnos();	
						if(max==0) for(int m=0;i<alturnos.size();++m) Turnos[m]=false;
						else if(max == 1 | max ==2){
							for(int m=0;m<alturnos.size();m=m+3){
								boolean modif =false;
								Nodo MAX = new Nodo(id, "MAX");
								grafo.afegirNode(MAX);
								grafo.conectarNodes(i, id, max, 0.0);
								if(Turnos[m]==true){
									modif=true;
									int capacidad = 1;
									double coste = 0;
									String tt = alturnos.get(m).getShiftType();
									double sueldo = aldoc.get(i-firstdoc).getSalaryTurn();
									if(tt.equals("morning")) coste=fm*sueldo;
									else if(tt.equals("afternoon")) coste=ft*sueldo;
									else if(tt.equals("evening")) coste=fn*sueldo;
									grafo.conectarNodes(id, m+firsttorn, capacidad, coste);
								}
								if(Turnos[m+1]==true){
									modif=true;
									int capacidad = 1;
									double coste = 0;
									String tt = alturnos.get(m+1).getShiftType();
									double sueldo = aldoc.get(i-firstdoc).getSalaryTurn();
									if(tt.equals("morning")) coste=fm*sueldo;
									else if(tt.equals("afternoon")) coste=ft*sueldo;
									else if(tt.equals("evening")) coste=fn*sueldo;
									grafo.conectarNodes(id, m+1+firsttorn, capacidad, coste);
								}
								if(Turnos[m+2]==true){
									modif=true;
									int capacidad = 1;
									double coste = 0;
									String tt = alturnos.get(m+2).getShiftType();
									double sueldo = aldoc.get(i-firstdoc).getSalaryTurn();
									if(tt.equals("morning")) coste=fm*sueldo;
									else if(tt.equals("afternoon")) coste=ft*sueldo;
									else if(tt.equals("evening")) coste=fn*sueldo;
									grafo.conectarNodes(id, m+2+firsttorn, capacidad, coste);
								}
								if(modif==true)++id;
								else grafo.removeNode(id);
							}
						}
					}
					else if (restipe.equals("MAX_Turnos_Rango")){
						//se obtiene el MaxDIASenRango
						//se crea Nodo MaxDiasRango
						//se une el doctor con el nodo con capacidad MaxDiasenRango
						//en el for(m) se comprueva que la fecha sea >=minRango
						// & <=maxRango si la fecha es > break?
						//se comprueva que Turnos[m]==true 
						//se conecta el nodo con el turno con capacidad 1
						//se añade coste i avanti
						MAX_Turnos_Rango N = ((MAX_Turnos_Rango)res);
						GregorianCalendar fechaIni = ((MAX_Turnos_Rango)res).getFechaIni();
						GregorianCalendar fechaFin = ((MAX_Turnos_Rango)res).getFechaFin();
						int firstDay = fechaIni.get(GregorianCalendar.DAY_OF_YEAR);
						int  lastDay = fechaFin.get(GregorianCalendar.DAY_OF_YEAR);
						int numDias=N.getNumDias();
						boolean modif = false;
						Nodo MRango = new Nodo(id, "MRango");
						grafo.afegirNode(MRango);
						grafo.conectarNodes(i, id, numDias, 0.0);
						for(int m=0;m<alturnos.size();++m){
							GregorianCalendar gc1 = alturnos.get(m).getDate();
							int day = gc1.get(GregorianCalendar.DAY_OF_YEAR);
							if((day>=firstDay & day <=lastDay) & Turnos[m]==true){
								modif=true;
								int capacidad = 1;
								double coste = 0;
								String tt = alturnos.get(m+2).getShiftType();
								double sueldo = aldoc.get(i-firstdoc).getSalaryTurn();
								if(tt.equals("morning")) coste=fm*sueldo;
								else if(tt.equals("afternoon")) coste=ft*sueldo;
								else if(tt.equals("evening")) coste=fn*sueldo;
								grafo.conectarNodes(id, m+firsttorn, capacidad, coste);
							}
						}
						
					}
					/*else if (restipe.equals("MAX_Turnos_Consecutivos")){
						//posible implementacion
						//se busca el primer Turno[m] en false
						//de mientras si ++m >= MaxTurnosconsecutivos se pone ese dia en False
						// al encontrar el primero en true cada MaxTurnosConsecutivos pones uno en false
						//cumples especificafion? si // es la unica solucion ? nop ia que puede variar a partir de
						//maxturnosconsecutivos >=3
					}*/
					
				}//fi else de restricciones
				//biieen hEmos llegado al punto donde solo falta tirar cables
				//for(m) compruevas si turnos[m]==true
				//i le metes capacidad 1 i coste
				for(int j=firsttorn;j<=lasttorn;++j){
					if(Turnos[j-firsttorn]==true ){
						int capacidad=1; //
						double coste =0;
						String tt = alturnos.get(j-firsttorn).getShiftType();
						double sueldo = aldoc.get(i-firstdoc).getSalaryTurn();
						if(tt.equals("morning")) coste=fm*sueldo;
						else if(tt.equals("afternoon")) coste=ft*sueldo;
						else if(tt.equals("evening")) coste=fn*sueldo;
						grafo.conectarNodes(i, j, capacidad, coste);	
					}
				}
				
			}//fin de restricciones de un doctor
			//pasamos al siguiente doctor
			
		}//fi for de llenar restricciones para todos los doctores

	}//fin de llenagrafo
}//ficlas
