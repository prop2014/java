package Domain;

import java.util.ArrayList;

import Domain.FordFulkerson;
import Domain.Graf;

public class EdmondKarp extends FordFulkerson{
	/*Creadora:
	    Pre: -
	    Post: Crea una instància d’Edmond karp buida.*/
	public EdmondKarp(){}

	/*Pre: nodeInicial i nodeDesti han de pertànyer al graf.
	    Post: Crea una instància d’Edmond.*/
	public EdmondKarp (Integer nodeInicial, Integer nodeDesti, Graf<Object> graf ){}

	/*Càlcul:
	    Pre: El mateix que la funció a la classe FordFulkerson
	Post: Retorna un camí del graf g amb inici al node nodeInicial i destí al nodeDesti. Si no existeix un camí retorna un ArrayList buit.
	@Override*/
	public ArrayList<Integer> dameCamino(Graf<Object> g){
		ArrayList<Integer> camino = new ArrayList<Integer>(0);
		return camino;
	}

	/*Pre: n ha de ser un numero més gran que 0.
	Post: Retorna suficients camins del graf g per un flow de n. Si no n’hi ha suficients 
	saltarà un IOException.*/
	public ArrayList<Graf> retorna_camins(Graf<Object> g, int n){
		ArrayList<Graf> camino = new ArrayList<Graf>(0);
		return camino;
	}

}
