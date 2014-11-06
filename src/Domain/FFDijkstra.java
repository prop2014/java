package Domain; 
import java.util.*;
import java.io.IOException;

import Domain.FordFulkerson;
import Domain.Graf;

public class FFDijkstra extends FordFulkerson {

	//s id origen
	//t id destino
		
		
	/**
	 * Pre: g es un grafo dirigido no vacío con pesos en las aristas.
	 * Post: Devuelve un ArrayList<integer> con los id's de los nodos 
	 * del camino que será de coste mínimo aplicando el algoritmo de Dijkstra.
	*/
	@Override
	public ArrayList<Integer> dameCamino(Graf<Object> g){
		ArrayList<Integer> camino = new ArrayList<Integer>(0);
		/*double[] dist = new double[g.getNSize()];							//Vector de distancias/costes a nodos
		PriorityQueue<Integer> vertexQueue = new PriorityQueue<Integer>(); 	//Necesitamos un comparador de Nodos
		vertexQueue.add(s); 												//Añadimos el primer nodo
		dist[s] = 0.0;
		while (!vertexQueue.isEmpty()) {
			int nodo = vertexQueue.poll(); 									//Actuamos con el nodo
			ArrayList<Integer> neighbours = g.getOutNodes(nodo); 			//Obtenemos los vecinos del nodo con id "nodo"
			for(int neighbour : neighbours){								//Para todos los nodos vecinos
				int arista = g.getIDAresta(nodo, neighbour);				//Obtenemos la arista y sus datos
				int capacidadArista = g.getCapacidadAresta(arista);
				double costeArista = g.getCosteAresta(arista);
				int flujoArista = g.getFlujoAresta(arista);
				double coste = dist[s]+costeArista;
				if(coste < dist[neighbour]){
					dist[neighbour] = coste;
					vertexQueue.add(neighbour);
				}
			}
			
		
		}*/
		return camino;
	}
		
	/* VERSIÓN C++
	typedef pair<double,int> arcP; //<pes,vertex>
	typedef vector<vector<arcP> > grafP;
	int infinit;


	void dijkstra(const grafP& G,int s, vector<double>& d, vector<int>& p) {
		//d[u] : la longitud del cami mes curt des de s fins a u
		//p[u] predecesor de u en aquest cami
		int n = G.size();
		d = vector<double> (n,infinit); d[s] = 0;
		p = vector<int> (n,-1);
		vector<bool> S(n,false);
		priority_queue<arcP,vector<arcP>,greater<arcP> > Q;
		Q.push(arcP(0,s));
		while(not Q.empty()) {
			int u = Q.top().second; Q.pop();
			if(not S[u]) { 		// u no pertany a S
				S[u] = true;	// S:= S+{u}
				for(int i = 0; i < G[u].size(); ++i) {
					int v = G[u][i].second;
					int c = G[u][i].first;
					if (d[v] > (d[u]+c)) {
						d[v] = d[u]+c;
						p[v] = u;
						Q.push(arcP(d[v],v));
					}
				}
			}
		}
	}*/

	public static void main(String[] args) throws IOException {
		Graf<Double> G = new Graf<Double>();
		try {
			G.afegirNode(1.0);
		}
		catch (IOException e) {
		    throw new IOException(e);
		}
		
	}
	//pasos a seguir 
	/*
	1.meter nodo inicial en la p.q
	2.crear vector dist infinitas de tamaño grafo.
	3. dist[s]=0;
	4. 
	
	
	
	
	
	
	*/
	
	

}