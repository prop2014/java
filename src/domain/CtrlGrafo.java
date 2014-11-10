package domain;
import java.io.IOException;
import java.util.*;

import model.*;
import domain.*;

public class CtrlGrafo {
	
	public Graf<Nodo> llenarGrafo(Hospital h) throws IOException {
		int id = 1;
		Graf<Nodo> grafo = new Graf<Nodo>(); 	// creamos grafo
		Nodo Source = new Nodo(0, "Source");	// creamos nodo source		
		grafo.afegirNode(Source);    			//A�adimos el source
		ArrayList<Doctor> aldoc = new ArrayList<Doctor>();
		aldoc = h.getDoctors();					//aldoc: lista de doctores del hospital
		for (int i = 0; i < aldoc.size(); ++i) {
			nodoDoctor Doctor = new nodoDoctor(id, "Doctor", aldoc.get(i).getId());
			grafo.conectarNodes(0, id, aldoc.get(i).getNumMaxTurnos(), 0.0);
			++id;
		}
		
		
		
		return grafo;
		
	}

	
}
