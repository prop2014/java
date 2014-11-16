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
	
	private HashMap<Integer,listAndSalary> mapSol;
	private ArrayList<nodoTurno> turnosSinSol;
	private boolean sol;
	
	InterpretarResultado(Graf<Nodo> g, int NodoF, int NodoS){
		graf = g;
		idFuente = NodoF;
		idSumidero = NodoS;
		mapSol = new HashMap<Integer,listAndSalary>();
		turnosSinSol = new  ArrayList<nodoTurno>();
		sol = false;
	}
	
	InterpretarResultado(Graf<Nodo> g, Nodo NodoF, Nodo NodoS) throws IOException{
		graf = g;
		idFuente = g.getNodeId(NodoF);
		idSumidero = g.getNodeId(NodoS);	
		mapSol = new HashMap<Integer,listAndSalary>();
		turnosSinSol = new  ArrayList<nodoTurno>();
		sol = false;
		}
	
	
	//Metodos Publicos
	public HashMap<Integer,listAndSalary> getMapSol(){
		return mapSol;
	}
	
	public ArrayList<nodoTurno> getTurnosSinSol(){
		return turnosSinSol;
	}
	
	public boolean hasSolution() {
		return sol;
	}
	
	//Metodos Privados 
	
	/*
	 * PRE: Hay solucion.
	 * 
	 * Vamos recoriendo el grafo desde cada Doctor al sumidero,
	 * almacenando los turnos qe trabaja y sumando su sueldo por turno. 
	 * 
	 */
	private void interpretarDFS(int idNodo, ArrayList<nodoTurno> turnos, double sueldo) throws IOException{
		if(idNodo != idSumidero){
			ArrayList<Integer> vecinos = graf.getOutNodes(idNodo);
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
	
	
	/*
	 * Comprueba que hay solucion, si no la hay,
	 * mientras va comprobando guarda los turnos que no han sido completamente cubiertos
	 * 
	 */
	private void haySolucion() throws IOException{
		int flujoFuenteADoctor = 0;
		int flujoTurnoASumidero = 0;
		ArrayList<Integer> vecinosFuente = graf.getOutNodes(idFuente);
		for(int vecino:vecinosFuente){
			
			int idArista = graf.getIDAresta(idFuente, vecino);
			flujoFuenteADoctor += graf.getFlujoAresta(idArista);
		}
		
		ArrayList<Integer> vecinosSumidero = graf.getInNodes(idSumidero);
		for(int vecino:vecinosSumidero){	
			int idArista = graf.getIDAresta(vecino, idSumidero);
			flujoTurnoASumidero += graf.getCapacidadAresta(idArista);
			
			//if(graf.getFlujoAresta(idArista) > graf.getCapacidadAresta(idArista)){
			nodoTurno n = (nodoTurno)graf.getNode(vecino);
				turnosSinSol.add(n);
			//}
		}
		
		if(flujoFuenteADoctor < flujoTurnoASumidero || flujoTurnoASumidero > 0) sol = false;
		else sol = true;
	}
	
	/*
	 * POST:
	 * 		-Si hay solucion mapSol estara lleno con la id de los Doctores, 
	 * 			sus turnos asignados y el sueldo total.
	 * 		-Si NO hay solucion turnosSinSol estara lleno 
	 * 			con los turnos que no han sido completamente cubiertos
	 */
	public void  InterpretarGrafo() throws IOException{
		
		haySolucion();

		if(sol){
			
			//Obtener id de los vecinos de la fuente
			ArrayList<Integer> vecinos = graf.getOutNodes(idFuente);
			
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
					mapSol.put(vecino, ls);
					
					
				}
			}
			
		}
		 
		
		}
	

		
	}

