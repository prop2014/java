package domain;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import model.Doctor;
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
	private ArrayList<Integer> numSinSol;
	private HashMap<Integer, ArrayList<String>> asignDoc;
	private ArrayList<String> tSinSol;
	
	//Creadora por defecto
	public CtrlAlgorithm(Hospital h) {
		hosp = h;
		gResidual = null;
		resMap = new Asignaciones();
		turnosSinSol = new ArrayList<nodoTurno>();
		numSinSol = new ArrayList<Integer>();
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
			numSinSol = result.getnumSinSol();
		} catch (IOException e) {
			System.out.println(e);
		}
		return result.hasSolution();
	}
	
	//Funcion que retorna el grafo
	public Graf<Nodo> getGraf() {
		return gResidual;
	}
	
	//Funcion devuelve las fechas y turnos asignados de un doctor con id = id
	public HashMap<Integer,ArrayList<String>> getDatesAssigned(){
		asignDoc = new HashMap<Integer, ArrayList<String>>();
		ArrayList<Doctor> docs = hosp.getDoctors();
		for(Doctor d : docs) {
			ArrayList<String> asign = new ArrayList<String>();
			ArrayList<String> fechasAsignadas = resMap.getFechasAsignaciones(d.getId());
			ArrayList<String> turnosAsignados = resMap.getTipoTurnoAsignaciones(d.getId());
			for(int i = 0; i < fechasAsignadas.size(); ++i) {
				asign.add(fechasAsignadas.get(i) + " " + turnosAsignados.get(i));
			}
			asignDoc.put(d.getId(), asign);
		}
		
		return asignDoc;
	}
	
	
	//Funcion devuelve el sueldo de un doctor con id = id
	public double getSueldoAssigned(int id){
		return resMap.getSueldoTotal(id);
	}
	
	
	public ArrayList<String> getTurnosSinSol(){
		tSinSol = new ArrayList<String>();
		String fecha;
		for(int i = 0; i < turnosSinSol.size(); ++i) {
			nodoTurno n = turnosSinSol.get(i);
			GregorianCalendar c1 = n.getFecha();
			fecha = DateFormat.getDateInstance(DateFormat.SHORT).format(c1.getTime());
			tSinSol.add(fecha + " " + n.getTipoTurno() + " (" + numSinSol.get(i) + ")");
			
		}
		return tSinSol;
	}
	
}
