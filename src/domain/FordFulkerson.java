package domain;
import java.io.IOException;
import java.util.ArrayList;

import domain.Graf;

public class FordFulkerson {
		
	//Public:
		public int maxFlow;
		//El flow màxim del graf

		//Operacions públiques:
		 
		//Constructors:
		    
		           // Crea un objecte de la clase FordFulkerson
		public FordFulkerson(){}

		//Crea objecte de la clase FordFulkerson inicialitzat
		public FordFulkerson(int nodeInicial, int nodeDesti, Graf<Object> graf){}
		           
		//Càlcul:

		//Mètode que computa el càlcul del max flow i retorna el graf residual resultant del càlcul.
		protected Graf<Object> g;
		//El graf del qual es parteix
		protected int s; 
		//El node origen
		protected int t; 
		//El node destí

		// Algoritme MaxFlow de FordFoulkerson
		public Graf<Integer> findMaxFlow(Graf<?> g, int s, int t){
			Graf<Integer> graf = new Graf<Integer>();
			return graf;
		}
		 
		//Mètode helper de cerca que implementa el DFS. Aquest mètode es heredat per //les classes i que es cridat desde el mètode findMaxFlow();
		public ArrayList<Integer> dameCamino(Graf<?> g) throws IOException{
			ArrayList<Integer>camino = new ArrayList<Integer>(0);
	    	return camino;
		}

		//Getters i setters
		public int getNodeDesti(){
			return 0;
		}
		public int setNodeDesti(int desti){
			return 0;
		}
		public int getNodeOrigen(){
			return 0;
		}
		public int setNodeOrigen(int origen){
			return 0;
		}
		public Graf<Integer> getGrafInicial(){
			Graf<Integer> graf = new Graf<Integer>();
			return graf;
		}
		public int setGrafInicial(Graf<Object> gInicial){
			return 0;
		}

	
	
		
}
