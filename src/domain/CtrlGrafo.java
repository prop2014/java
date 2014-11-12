package domain;
import java.io.IOException;
import java.util.*;

import model.*;

public class CtrlGrafo {
	
	private int firstdoc;
	private int lastdoc;
	private int firsttorn;
	private int lasttorn;
	
	
	
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
		//nodos de doctores añadidos
		//añadimos todos los turnos al grafo
		ArrayList<Turno> alturnos = new ArrayList<Turno> ();
		alturnos = h.getAllTurnos();
		
		for (int i = 0; i < alturnos.size(); ++i) {
			++id;
			if(i==0) firsttorn = id;
			nodoTurno nturn = new nodoTurno(id,"Turno", alturnos.get(i).getDate(),alturnos.get(i).getShiftType());
			grafo.afegirNode(nturn);
			grafo.conectarNodes(id, lastdoc+1, alturnos.get(i).getNumberOfDoctors(),0.0); 
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
				
				
				
				
			}//fin de restricciones //los doctores ia han puesto todas sus restricciones
			
			//?quedan por conectar los dias sin restricciones
		
		}//fi for de llenar restricciones
		return grafo;
	}//fillenagrafo
}//ficlas
