package Domain; 
import java.util.*;
import java.io.IOException;

import Domain.FordFulkerson;
import Domain.Graf;


class arcP
{
    public double coste;
    public int id;
}

public class FFDijkstra extends FordFulkerson {

	//s id origen
	//t id destino
		
		
	/**
	 * Pre: g es un grafo dirigido no vacío con pesos en las aristas.
	 * Post: Devuelve un ArrayList<integer> con los id's de los nodos 
	 * del camino que será de coste mínimo aplicando el algoritmo de Dijkstra.
	*/
	@Override
	public ArrayList<Integer> dameCamino(Graf<?> g) throws IOException{
		//dist[u] : la longitud del cami mes curt des de s fins a u
		//pred[u] predecesor de u en aquest cami
		try {
			ArrayList<Integer> camino = new ArrayList<Integer>(0);
			int[] pred = new int[g.getNSize()];
			double[] dist = new double[g.getNSize()];							//Vector de distancias/costes a nodos
			for(int k = 0; k < g.getNSize(); k++){
			        dist[k] = Double.POSITIVE_INFINITY;
			}
			
			PriorityQueue<arcP> vertexQueue = new PriorityQueue<arcP>(1,new Comparator<arcP>() //Necesitamos un comparador de Nodos
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
			vertexQueue.add(p); 												//Añadimos el primer nodo
			while (!vertexQueue.isEmpty()) {
				p = vertexQueue.poll();		 									//Actuamos con el nodo
				ArrayList<Integer> neighbours = g.getOutNodes(p.id); 			//Obtenemos los vecinos del nodo con id "nodo"
				for(int neighbour : neighbours){								//Para todos los nodos vecinos
					int arista = g.getIDAresta(p.id, neighbour);				//Obtenemos la arista y sus datos
					System.out.printf("Nodo Princ: %d , Nodo vecino: %d, ID Arista: %d\n", p.id, neighbour, arista);
					int capacidadArista = g.getCapacidadAresta(arista);
					double costeArista = g.getCosteAresta(arista);
					int flujoArista = g.getFlujoAresta(arista);
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
			int sig = g.getNSize() - 1;
			while(sig != 0) {
				cam.push(sig);
				sig = pred[sig];
			}
			cam.push(0);
			while(!cam.isEmpty()) {
				camino.add(cam.pop());
			}
			return camino;
		}
		catch (IOException e) {
		    throw new IOException(e);
		}
	}
		
	/*
	 * 1. Crear Vector dist con infinito
	 * 2. Poner dist del nodo inicial a 0
	 * 3. Meter nodo inicial en p.q. con dist = 0
	 * 4. while(!pq.isEmpty())
	 * 5. Tratar nodo X de p.q. y quitarlo
	 * 6. Obtener nodos adyacentes de X
	 * 7. Tratar nodo vecino Y
	 * 8. Obtener arista de X a Y. idArista = getArista(X,Y)
	 * 9. Obttener Capacidad y flujo de arista getCapacidadArista(idArista) y getFlujoArista(idArista)
	 * 10. Obtenre coste arista getCosteArista(idArista)
	 * 11. Si costeArista + dist[X] es menor a dist[Y], actualiza dist[Y] y añade a p.q.
	 */
	
	
	
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

	/*public static void main(String[] args) throws IOException {
		/*Graf<Double> G = new Graf<Double>();
		try {
			G.afegirNode(1.0);
		}
		catch (IOException e) {
		    throw new IOException(e);
		}
		
		PriorityQueue<arcP> vertexQueue = new PriorityQueue<arcP>(5,new Comparator<arcP>()
	            { public int compare(arcP p, arcP q)
            {
	            if(p.coste > q.coste) return 1;
	            if(p.coste < q.coste) return -1;
                return 0;
            }
        } );
		arcP p = new arcP();
		p.coste = 2.0;
		p.id = 4;
		vertexQueue.offer(p);
		p = new arcP();
		p.coste = 3.0;
		p.id = 3;
		vertexQueue.offer(p);
		p = new arcP();
		p.coste = 3.5;
		p.id = 2;
		vertexQueue.offer(p);
		p = new arcP();
		p.coste = 1.0;
		p.id = 1;
		vertexQueue.offer(p);
		p = new arcP();
		p.coste = 6.0;
		p.id = 5;
		vertexQueue.offer(p);
		p = new arcP();
		p.coste = 2.0;
		p.id = 6;
		vertexQueue.offer(p);
		while(!vertexQueue.isEmpty()){
			p = vertexQueue.poll();
			System.out.printf("id: %d coste: %f \n", p.id, p.coste);
		}
		System.out.printf("Infinito: %f", Double.POSITIVE_INFINITY);
		
	}*/
	//pasos a seguir 
	/*
	1.meter nodo inicial en la p.q
	2.crear vector dist infinitas de tamaño grafo.
	3. dist[s]=0;
	4. 
	
	
	
	
	
	
	*/
	
	

}