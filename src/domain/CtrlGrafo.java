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
	
	static String warrada3 (int warrada){
		String t;
		if(warrada==0) t="monday";
		else if(warrada==1) t = "tuesday";
		else if(warrada==2) t = "wednesday";
		else if(warrada==3) t = "thursday";
		else if(warrada==4) t = "friday";
		else if(warrada==5) t = "saturday";
		else t = "sunday";
		return t; 
	}
	
	public Graf<Nodo> llenarGrafo(Hospital h) throws IOException {
		
		double fm, ft, fn;
		fm=h.getFactorM();
		ft=h.getFactorT();
		fn=h.getFactorN();
		
		int id = 0;
		Graf<Nodo> grafo = new Graf<Nodo>(); 	// creamos grafo
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
		Nodo Sink = new Nodo(lastdoc+1, "Sink");
		grafo.afegirNode(Sink);
		sink = lastdoc+1;
		//nodos de doctores añadidos
		//añadimos todos los turnos al grafo
		ArrayList<Turno> alturnos = new ArrayList<Turno> ();
		Calendario cal = h.getCalendario();
		alturnos = cal.getAllShifts();
		
		for (int i = 0; i < alturnos.size(); ++i) {
			++id;
			if(i==0) firsttorn = id;
			nodoTurno nturn = new nodoTurno(id,"Turno", alturnos.get(i).getDate(),alturnos.get(i).getShiftType());
			grafo.afegirNode(nturn);
			grafo.conectarNodes(id, sink, alturnos.get(i).getNumberOfDoctors(),0.0); 
		}
		lasttorn=id;
				
		
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
					else if(tt.equals("night")) coste=fn*sueldo;
					grafo.conectarNodes(i, j, capacidad, coste);
				}
			}
			else {
			//caso donde si hay restricciones
				boolean Turnos[] = new boolean[alturnos.size()];
				for(int k=0;k<alturnos.size();++k) Turnos[k]=true;
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
							int warrada = gc1.get(GregorianCalendar.DAY_OF_WEEK);
							String warrada2=warrada3(warrada);
							if(t.equals(warrada2))Turnos[m]=false;
						}
						
					}
					else if (restipe.equals("NOT_Dia_Mes")){
						NOT_Dia_Mes N = (NOT_Dia_Mes)res;
						int  dia = N.getDiaMes();
						for(int m=0;m<alturnos.size();++m){
							GregorianCalendar gc1=alturnos.get(m).getDate();
							int day = gc1.get(GregorianCalendar.DAY_OF_MONTH);
							if(dia==day)Turnos[m]=false;
						}
						
					}				
				}
				//hemos tratado las NOT vamos a tratar las demas
				for(int k=0;k<alRest.size();++k){
					Restriccion res = alRest.get(k); //tengo la restriccion
					String restipe =res.getTipo(); // tengo el tipo
					//leerse linia 196 antes de empezar a pikar codigo
					if (restipe.equals("XOR")){ 
						//se crea un nodo XOR
						//se conecta el doctor al nodo XOR con capacidad 1
						//se une con los turnos con capacidad 1
						//se ha comprovado que el Turno esta en true;
						//se ha añadido coste desde nodo XOR a turno
						
					}
					else if (restipe.equals("MAX_Turnos_por_Dia")){
						//se obtiene el numMaxTurnosxdia
						//si es 0 se pone TURNOS[] a false;
						//si es 3 no se hace nada;
						//else se crea 1 nodo para cada 3 iteraciones del for(m)
						// comprovar si el dia esta en true;
						// se le pone (capacidad MaxTurnosxdia) 
						// se le pone coste i avanti
						
					}
					else if (restipe.equals("MAX_Dias_Rango")){
						//se obtiene el MaxDIASenRango
						//se crea Nodo MaxDiasRango
						//se une el doctor con el nodo con capacidad MaxDiasenRango
						//en el for(m) se comprueva que la fecha sea >=minRango
						// & <=maxRango si la fecha es > break?
						//se comprueva que Turnos[m]==true 
						//se conecta el nodo con el turno con capacidad 1
						//se añade coste i avanti
					}
					else if (restipe.equals("MAX_Turnos_Consecutivos")){
						//posible implementacion
						//se busca el primer Turno[m] en false
						//de mientras si ++m >= MaxTurnosconsecutivos se pone ese dia en False
						// al encontrar el primero en true cada MaxTurnosConsecutivos pones uno en false
						//cumples especificafion? si // es la unica solucion ? nop ia que puede variar a partir de
						//maxturnosconsecutivos >=3
					}
					
				} //fi else de restricciones
				//biieen hEmos llegado al punto donde solo falta tirar cables
				//for(m) compruevas si turnos[m]==true
				//i le metes capacidad 1 i coste
				//IMPORTANTE
				//para encontrar todas las id de turnos hacer
				//for(int j=firsttorn;j<=lasttorn;++j){
				//Turnos[m] es equivalente a alturnos.get(j-firsttorn)
				//IMPORTANTE referenciamos un doctor con
				//aldoc.get(i-firstdoc) en todo el bucle
				// la i es la id del nodo doctor
				// j es la id del nodo turno
				
			}//fin de restricciones de un doctor
			//pasamos al siguiente doctor
			
		}//fi for de llenar restricciones para todos los doctores
		return grafo;
	}//fin de llenagrafo
}//ficlas
