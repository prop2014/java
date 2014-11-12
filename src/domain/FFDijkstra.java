package domain; 
import java.util.*;
import java.io.IOException;

import domain.FordFoulkerson;
import domain.Graf;

/**
*
* @author alexmorral 
*/


class arcP {
    public double coste;
    public int id;
}

public class FFDijkstra<T> extends FordFoulkerson<T> {
	
	
	
	public FFDijkstra(Integer nodeInicial, Integer nodeDesti, Graf graf)
 	{
		super(nodeInicial, nodeDesti, graf);
 	}
		
	/**
	 * Pre: g es un grafo dirigido no vacío con pesos en las aristas.
	 * Post: Devuelve un ArrayList<integer> con los id's de los nodos 
	 * del camino que será de coste mínimo aplicando el algoritmo de Dijkstra.
	*/
	@Override
	public ArrayList<Integer> dameCamino(Graf<T> graf) throws IOException {	
		//dist[u] : la longitud del camino más corto desde s hasta t
		//pred[u] predecesor de u en este camino
		try {
			int size = graf.getNSize();
			ArrayList<Integer> camino = new ArrayList<Integer>(0);
			int[] pred = new int[size];
			for(int k = 0; k < size; k++){
		        pred[k] = -1;
			}
			double[] dist = new double[size];							
			for(int k = 0; k < size; k++){
			        dist[k] = Double.POSITIVE_INFINITY;
			}
			
			PriorityQueue<arcP> vertexQueue = new PriorityQueue<arcP>(1,new Comparator<arcP>() 
		            { public int compare(arcP p, arcP q)
		            {
			            if(p.coste > q.coste) return 1;
			            if(p.coste < q.coste) return -1;
		                return 0;
		            }
		            } ); 
			arcP p = new arcP();
			p.id = s;
			p.coste = 0.0;
			dist[s] = 0.0;
			vertexQueue.add(p); 												
			while (!vertexQueue.isEmpty()) {
				p = vertexQueue.poll();		 									
				ArrayList<Integer> neighbours = graf.getOutNodes(p.id); 			
				for(int neighbour : neighbours){								
					int arista = graf.getIDAresta(p.id, neighbour);				
					//System.out.printf("Nodo Princ: %d , Nodo vecino: %d, ID Arista: %d\n", p.id, neighbour, arista);
					int capacidadArista = graf.getCapacidadAresta(arista);
					double costeArista = graf.getCosteAresta(arista);
					int flujoArista = graf.getFlujoAresta(arista);
					if(capacidadArista > 0 && flujoArista < capacidadArista) {
						double coste = dist[p.id]+costeArista;
						if(coste < dist[neighbour]){
							dist[neighbour] = coste;
							pred[neighbour] = p.id;
							arcP q = new arcP();
							q.id = neighbour;
							q.coste = coste;
							vertexQueue.add(q);
						}
					}
				}
			
			}
			
			Stack<Integer> cam = new Stack<Integer>();
			int sig = t;
			if(pred[sig] != -1) { 
				while(sig != 0) {
					cam.push(sig);
					sig = pred[sig];
				}
				cam.push(s);
				while(!cam.isEmpty()) {
					camino.add(cam.pop());
				}
			}
			return camino;
		}
		catch (IOException e) {
		    throw new IOException(e);
		}
	}
		

}