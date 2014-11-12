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
			grafo.conectarNodes(0, id, aldoc.get(i).getNumMaxTurnos(), 0.0);
		}
		lastdoc = id;
		Nodo Sink = new Nodo(lastdoc+1, "Sink");
		grafo.afegirNode(Sink);
		sink = lastdoc+1;
		//nodos de doctores añadidos
		//añadimos todos los turnos al grafo
		ArrayList<Turno> alturnos = new ArrayList<Turno> ();
		alturnos = h.getAllTurnos();
		
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
					double sueldo = aldoc.get(i-firstdoc).getSueldoTurno();
					if(tt.equals("morning")) coste=fm*sueldo;
					else if(tt.equals("afternoon")) coste=ft*sueldo;
					else if(tt.equals("night")) coste=fn*sueldo;
					 //se tiene que calcular //sueldodoctor
						//los doctores empiezan en firstdoc hasta lastdoc
					grafo.conectarNodes(i, j, capacidad, coste);
				}
			}
			else {
			//caso donde si hay restricciones
				boolean Turnos[] = new boolean[alturnos.size()];
				for(int k=0;k<alturnos.size();++k) Turnos[k]=true;
				ArrayList<Restriccion> alRest = aldoc.get(i-firstdoc).getRestricciones();
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
							if(){
								Turnos[m]=false;
							}
						}
						
					}
					else if (restipe.equals("NOT_Dia_Mes")){
						
					}
					else if (restipe.equals("XOR")){
						
					}
					else if (restipe.equals("MAX_Turnos_por_Dia")){
						
					}
					else if (restipe.equals("MAX_Dias_Rango")){
						
					}
					/*else if (restipe.equals("MAX_Turnos_Consecutivos")){
						
					}*/					
				}
				
				
			}//fin de restricciones //los doctores ia han puesto todas sus restricciones
			
			//?quedan por conectar los dias sin restricciones
		
		}//fi for de llenar restricciones
		return grafo;
	}//fillenagrafo
}//ficlas
