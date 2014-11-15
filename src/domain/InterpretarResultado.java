package domain;

import domain.Nodo;
import domain.Graf;
import domain.Nodo;
import domain.nodoDoctor;
import domain.nodoTurno;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
*
* @author Axel Pelaez
*/

class listAndSalary{
    public ArrayList<nodoTurno> listaTurnos;
    public double sueldoTotal;
}

public class InterpretarResultado {

	private Graf<Nodo> graf;
	private int idFuente; 
	private int idSumidero;
	
	InterpretarResultado(Graf<Nodo> g, int NodoF, int NodoS){
		graf = g;
		idFuente = NodoF;
		idSumidero = NodoS;	
	}
	
	InterpretarResultado(Graf<Nodo> g, Nodo NodoF, Nodo NodoS) throws IOException{
		graf = g;
		idFuente = g.getNodeId(NodoF);
		idSumidero = g.getNodeId(NodoS);	
		}
	
	/*PSEUDOCODE::
	 * mainprogram{
	 * 	getfuente;
	 * 	//vecino fuente siempre son Doctores
	 * 	foreach(vecinoFuente){ 
	 * 		create Array Fechas del doctor;
	 * 		if(suficiente flujo) DFS(vecinoFuente,Array);
	 * 		guardar datos.
	 * 
	 * 
	 * DFS(Nodo,Array fechas){
	 * if (Nodo == sumidero) ?CONTROL DE ERRORES?
	 * else{
	 * 		getvecinos;
	 * 		foreach(vecino){
	 * 			if(el flujo lo permite){
	 * 				if(Nodo == Turno) Add.Array(turno);
	 * 				DFS(vecino,Array);
	 * 			}
	 * 		}
	 * }
	 * 
	 *
	 */
	private void interpretarDFS(int idNodo, ArrayList<nodoTurno> turnos, double sueldo) throws IOException{
		if(idNodo == idSumidero); //control de errores??????????
		else{
			ArrayList<Integer> vecinos = graf.getInNodes(idNodo);
			for(int vecino : vecinos){
				//CONTROL DE FLUJO
				int idArista = graf.getIDAresta(idNodo, vecino);
				if(graf.getFlujoAresta(idArista) > 0){
					Nodo veci = graf.getNode(vecino);
					//Si es tipo turno lo guardamos y sumamos su sueldo
					if(veci.getTipo().equals("Turno")){
						turnos.add((nodoTurno)(veci));
						sueldo += graf.getCosteAresta(idArista);
					}
					
					//llamada recursiva
					interpretarDFS(vecino, turnos,sueldo);
				}
			}
			
			
		}
	}
	
	public HashMap<Integer,listAndSalary> InterpretarGrafo() throws IOException{
		
		HashMap<Integer,listAndSalary> resMap = new HashMap<Integer,listAndSalary>();
		//Obtener id de los vecinos de la fuente
		ArrayList<Integer> vecinos = graf.getInNodes(idFuente);
		
		for(int vecino:vecinos){
			
			int idArista = graf.getIDAresta(idFuente, vecino);
			if(graf.getFlujoAresta(idArista) > 0){
				ArrayList<nodoTurno> turnos = new ArrayList<nodoTurno>();
				double sueldo = 0;
				interpretarDFS(vecino,turnos,sueldo);
				
				//Almacenar datos
				listAndSalary ls = new listAndSalary(); 
				ls.listaTurnos = turnos;
				ls.sueldoTotal = sueldo;
				
				resMap.put(vecino, ls);
				
				
			}
			
		}
		return resMap; 
		
		
		
		
	}
}
