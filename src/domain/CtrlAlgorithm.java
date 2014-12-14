package domain;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

import data.CtrlDatosFichero;

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
	private HashMap<Integer, Double> sueldos;
	
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
	public void generateDatesAsigned(){
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
	}
	
	
	//Funcion devuelve el sueldo de un doctor con id = id
	public void generateSueldoAsigned(){
		sueldos = new HashMap<Integer, Double>();
		ArrayList<Doctor> docs = hosp.getDoctors();
		for(Doctor d : docs) {
			sueldos.put(d.getId(), resMap.getSueldoTotal(d.getId()));
		}
	}
	
	
	public void generateTurnosSinSol(){
		tSinSol = new ArrayList<String>();
		String fecha;
		for(int i = 0; i < turnosSinSol.size(); ++i) {
			nodoTurno n = turnosSinSol.get(i);
			GregorianCalendar c1 = n.getFecha();
			fecha = DateFormat.getDateInstance(DateFormat.SHORT).format(c1.getTime());
			tSinSol.add(fecha + " " + n.getTipoTurno() + " (" + numSinSol.get(i) + ")");
			
		}
	}
	
	public HashMap<Integer, ArrayList<String>> getDatesAsigned(){
		return asignDoc;
	}
	
	public ArrayList<String> getTurnosSinSol () {
		return tSinSol;
	}
	
	public HashMap<Integer, Double> getSueldoAsigned(){
		return sueldos;
	}
	
	public void getSol(int id) throws IOException{
		CtrlDatosFichero inOut = new CtrlDatosFichero();
		ArrayList<String> sol = inOut.getDataSol(id);
		ArrayList<String> noSol = inOut.getDataNoSol(id);
		if(!sol.isEmpty()){
			int i = 0;
			int doc=Integer.parseInt(sol.get(i)); //iddoc
			ArrayList<String> asigsDoc = new ArrayList<String>();
			++i;
			int size = Integer.parseInt(sol.get(i));//numFechas
			for(int j = 0; j<size;++j){
				++i;
				asigsDoc.add(sol.get(i));
			}
			if(asignDoc.containsKey(doc)){
				asignDoc.remove(doc);
			}
			asignDoc.put(doc, asigsDoc); //ponemos las fechas en asigndoc
			if(sueldos.containsKey(doc)){
				sueldos.remove(doc);
			}
			++i;
			sueldos.put(doc,Double.parseDouble(sol.get(i))); //ponemos el sueldo en sueldos
		}
			tSinSol.clear();
		if(!noSol.isEmpty()){
			for(int j=0;j<noSol.size();++j){
				tSinSol.add(noSol.get(j));//llenamos tSinSol
			}
		}
		
	}
	public void saveSol(int id) throws IOException{
		CtrlDatosFichero inOut = new CtrlDatosFichero();
		ArrayList<String> sol = new ArrayList<String>();
		ArrayList<String> noSol = new ArrayList<String>();
		Iterator<Integer> it = asignDoc.keySet().iterator();
		while(it.hasNext()){
		 Integer doc = it.next();
		 ArrayList<String> assigs = asignDoc.get(doc);
		 	sol.add(Integer.toString(doc)); //iddoc
		 	sol.add(Integer.toString(assigs.size())); //numFechas
		  for(int i=0;i<assigs.size();++i){
			 sol.add(assigs.get(i)); //fechas
		  }
		  sol.add(Double.toString(sueldos.get(doc))); //sueldo
		}
		for(String s : tSinSol){
			noSol.add(s);
		}
		inOut.saveDataSol(sol, noSol, id);
	}
	
	public void addTurnToDoctor(int idDoc, String turnoConDoctors) throws IOException{
		String[] parts = turnoConDoctors.split(" ");
		String turno = parts[0]+" "+parts[1];
		for(String t : asignDoc.get(idDoc)) {
			if(t.equals(turno)) throw new IOException("Este doctor ya trabaja este turno");
		}
		/** EDIT SUELDO FROM sueldos*/
		String tipoT = parts[1];
		double sueldoBase = (hosp.getDoctor(idDoc)).getSalaryTurn();
		double sueldoASumar = 0;
		switch(tipoT) {
			case "manana":
				sueldoASumar = sueldoBase*hosp.getFactorM();
				break;
			case "tarde":
				sueldoASumar = sueldoBase*hosp.getFactorT();
				break;
			case "noche":
				sueldoASumar = sueldoBase*hosp.getFactorN();
				break;
		}
		double oldSueldo = sueldos.get(idDoc);
		sueldos.put(idDoc, oldSueldo+sueldoASumar);
		/** ADD TO asignDoc*/
		asignDoc.get(idDoc).add(turno);
		/** REMOVE/EDIT FROM tSinSol*/
		boolean modified = false;	
		for(int i = 0; i < tSinSol.size() && !modified; ++i) {
			String t = tSinSol.get(i);
			if(t.equals(turnoConDoctors)) {
				modified = true;
				String[] parts2 = parts[2].split("[()]");
				int numDocs = Integer.parseInt(parts2[1]);
				tSinSol.remove(turnoConDoctors);
				if(numDocs > 1) {
					--numDocs;
					tSinSol.add(turno+" "+"("+numDocs+")");
				}
			}
		}
	}
	public void deleteTurnFromDoctor(int idDoc, String turno) throws IOException{
		ArrayList<String> asignacionesDoc = asignDoc.get(idDoc);
		turno = turno.replaceAll("-", "");
		turno = turno.replaceFirst(" ", "");
		String[] split = turno.split(" ");
		/** EDIT SUELDO FROM sueldos*/
		String tipoT = split[1];
		double sueldoBase = (hosp.getDoctor(idDoc)).getSalaryTurn();
		double sueldoADescontar = 0;
		switch(tipoT) {
			case "manana":
				sueldoADescontar = sueldoBase*hosp.getFactorM();
				break;
			case "tarde":
				sueldoADescontar = sueldoBase*hosp.getFactorT();
				break;
			case "noche":
				sueldoADescontar = sueldoBase*hosp.getFactorN();
				break;
		}
		double oldSueldo = sueldos.get(idDoc);
		sueldos.put(idDoc, oldSueldo-sueldoADescontar);
		/** REMOVE FROM asignDoc*/
		boolean deleted = false;
		for(int i = 0; i < asignacionesDoc.size() && !deleted; ++i){
			String t = asignacionesDoc.get(i);
			if(t.equals(turno)) {
				asignacionesDoc.remove(t);
				deleted = true;
			}
		}
		/** ADD/EDIT TO tSinSol*/
		boolean modified = false;
		for(int i = 0; i < tSinSol.size() && !modified; ++i) {
			String[] parts = (tSinSol.get(i)).split(" ");
			String t = parts[0]+" "+parts[1];
			if(t.equals(turno)) {
				modified = true;
				String[] parts2 = parts[2].split("[()]");
				int numDocs = Integer.parseInt(parts2[1]);
				tSinSol.remove(t);
				++numDocs;
				tSinSol.add(turno+" "+"("+numDocs+")");
				
			}
		}
		if(!modified) {tSinSol.add(turno+" "+"("+1+")");}
	}
	
}
