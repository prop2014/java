package Domain; 
import java.util.*;

import Domain.FordFulkerson;
import Domain.Graf;

public class FFDijkstra extends FordFulkerson {

/*PRE: g es un grafo dirigido no vacío con pesos en las aristas.
POST: Devuelve un ArrayList<integer> con los id's de los nodos 
del camino que será de coste mínimo aplicando el algoritmo de Dijkstra.*/

	public ArrayList<Integer> dameCamino(Graf<Object> g){
		ArrayList<Integer> camino = new ArrayList<Integer>(0);
		return camino;
	}

}