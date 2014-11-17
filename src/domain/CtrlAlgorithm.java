package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import model.Hospital;

public class CtrlAlgorithm {
	private Graf<Nodo> g;
	private Graf<Nodo> gResidual;
	private Hospital hosp;
	private HashMap<Integer, listAndSalary> resMap;
	private ArrayList<nodoTurno> turnosSinSol;
	
	
	public CtrlAlgorithm(Hospital h) {
		hosp = h;
		gResidual = null;
		resMap = new HashMap<Integer, listAndSalary>();
		turnosSinSol = new ArrayList<nodoTurno>();
	}
	
	public void generateGraf() throws IOException{
		CtrlGrafo CtrlGraf = new CtrlGrafo();
		try	{
			CtrlGraf.fillGrafo(hosp);
		} catch(IOException e) {
			System.out.println(e);
		}
		g = CtrlGraf.getGraf();
		CtrlGraf.showNodos();
		
	}
	
	public void findMaxFlowFulk(int in, int out) {
		FordFulkerson<Nodo> ffulk = new FordFulkerson<Nodo>(in,out,g); //nodo ini, fin
		try {
			gResidual = new Graf<Nodo>();
			gResidual = ffulk.findMaxFlow(g, in, out);
		} catch(IOException e){
			System.out.println(e);
		}
		
	}
	
	public void findMaxFlowEk(int in, int out) {
		EdmondsKarp<Nodo> ffulk = new EdmondsKarp<Nodo>(in,out,g); //nodo ini, fin
		try {
			gResidual = new Graf<Nodo>();
			gResidual = ffulk.findMaxFlow(g, in, out);
		} catch(IOException e){
			System.out.println(e);
		}
		
	}
	
	public void findMaxFlowDijk(int in, int out) {
		FFDijkstra<Nodo> ffulk = new FFDijkstra<Nodo>(in,out,g); //nodo ini, fin
		try {
			gResidual = new Graf<Nodo>();
			gResidual = ffulk.findMaxFlow(g, in, out);
		} catch(IOException e){
			System.out.println(e);
		}
		
	}
	
	public boolean findSolution(int in, int out) {
		InterpretarResultado result = new InterpretarResultado(gResidual, in, out);
		HashMap<Integer, listAndSalary> resMap = new HashMap<Integer, listAndSalary>();
		ArrayList<nodoTurno> turnosSinSol = new ArrayList<nodoTurno>();
		try {
			result.InterpretarGrafo();
			resMap = result.getMapSol();
			turnosSinSol = result.getTurnosSinSol();
		} catch (IOException e) {
			System.out.println(e);
		}
		return result.hasSolution();
	}
	
	public Graf<Nodo> getGraf() {
		return gResidual;
	}
	
	public HashMap<Integer,listAndSalary> getMapSol(){
		return resMap;
	}
	
	public ArrayList<nodoTurno> getTurnosSinSol(){
		return turnosSinSol;
	}
}
