package domain;

import java.io.IOException;
import java.util.ArrayList;

import model.Hospital;
import model.Asignaciones;

/**
 * 
 * @author Alex Morral
 *
 */

public class CtrlAlgorithm {
	private Graf<Nodo> g;
	private Graf<Nodo> gResidual;
	private Hospital hosp;
	private Asignaciones resMap;
	private ArrayList<nodoTurno> turnosSinSol;
	
	//Creadora por defecto
	public CtrlAlgorithm(Hospital h) {
		hosp = h;
		gResidual = null;
		resMap = new Asignaciones();
		turnosSinSol = new ArrayList<nodoTurno>();
	}
	
	
	//Funcion que genera el grafo del hospital
	public void generateGraf() throws IOException{
		CtrlGrafo CtrlGraf = new CtrlGrafo();
		try	{
			CtrlGraf.fillGrafo(hosp);
		} catch(IOException e) {
			System.out.println(e);
		}
		g = CtrlGraf.getGraf();
		
	}
	
	//Funcion que llama al algoritmo Max Flow con DFS
	public void findMaxFlowFulk(int in, int out) {
		FordFulkerson<Nodo> ffulk = new FordFulkerson<Nodo>(in,out,g);
		try {
			gResidual = new Graf<Nodo>();
			gResidual = ffulk.findMaxFlow(g, in, out);
			System.out.println("MaxFlow: " + ffulk.getMaxFlow());
		} catch(IOException e){
			System.out.println(e);
		}
		
	}
	//Funcion que llama al algoritmo Max Flow con BFS
	public void findMaxFlowEk(int in, int out) {
		EdmondsKarp<Nodo> ffulk = new EdmondsKarp<Nodo>(in,out,g); 
		try {
			gResidual = new Graf<Nodo>();
			gResidual = ffulk.findMaxFlow(g, in, out);
			System.out.println("MaxFlow: " + ffulk.getMaxFlow());
		} catch(IOException e){
			System.out.println(e);
		}
		
	}
	
	//Funcion que llama al algoritmo Max Flow con Dijkstra
	public void findMaxFlowDijk(int in, int out) {
		FFDijkstra<Nodo> ffulk = new FFDijkstra<Nodo>(in,out,g);
		try {
			gResidual = new Graf<Nodo>();
			gResidual = ffulk.findMaxFlow(g, in, out);
			System.out.println("MaxFlow: " + ffulk.getMaxFlow());
		} catch(IOException e){
			System.out.println(e);
		}
		
	}
	
	//Funcion que interpreta el grafo residual
	public boolean findSolution(int in, int out) {
		InterpretarResultado result = new InterpretarResultado(gResidual, in, out);
		try {
			result.InterpretarGrafo();
			resMap = result.getMapSol();
			turnosSinSol = result.getTurnosSinSol();
		} catch (IOException e) {
			System.out.println(e);
		}
		return result.hasSolution();
	}
	
	//Funcion que retorna el grafo
	public Graf<Nodo> getGraf() {
		return gResidual;
	}
	
	//Funcion devuelve las fechas asignadas de un doctor con id = id
	public ArrayList<String> getDatesAssigned(int id){
		return resMap.getFechasAsignaciones(id);
	}
	
	//Funcion devuelve los turnos asignados de un doctor con id = id
	public ArrayList<String> getTurnosAssigned(int id){
		return resMap.getTipoTurnoAsignaciones(id);
	}
	
	//Funcion devuelve el sueldo de un doctor con id = id
	public double getSueldoAssigned(int id){
		return resMap.getSueldoTotal(id);
	}
	
	//Funcion que devuelve los turnos que se quedan sin solucion
	public ArrayList<nodoTurno> getTurnosSinSol(){
		return turnosSinSol;
	}
}
