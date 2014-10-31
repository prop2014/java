package Domain;
import java.util.*;

public class Graf<T> {
	private T t;
	/*Creadora:
	    Pre: -
	    Post: Crea una instància de Graf buida.*/
	public Graf(int i){}

	/*Add:
	Pre: -
	Post: Afegeix l’objecte node al Graf. Si el node ja existeix saltarà una IOException.*/
	public void afegirNode(T node){}
	    
	/*Pre: capacitat i cost han de ser més grans o iguals que 0. Id_from ha de ser diferent de Id_to.
	Post: Afegeix una aresta al graf amb origen al node id_from i destí id_to amb la capacitat i cost que 
	ens passen per paràmetres. Si les ids no són vàlides o l’aresta ja existeix saltarà una IOException.*/
	public void conectarNodes(Integer id_from, Integer id_to, Integer capacidad, Double coste){}

	
	/*Setters: 
	    Pre: -
	Post: Substitueix el node id amb el nou node. Si la id no és vàlida saltarà un IOException.*/
	    public void substituirNode(Integer id, T node){}
	    


	/*Pre: Els atributs capacidad ha de ser més gran de 0 i coste han de ser més gran   o igual a 0.
	Post: Substitueix l’aresta id amb la nova capacidad i coste.*/
	    public void substituirAresta (Integer id, Integer capacidad, Double coste){}

	/*Pre: flujo ha de ser més gran o igual que 0.
	Post: La aresta id té el nou flujo. Si id no és vàlid saltarà una IOException.*/
	public void setFlujoAresta(Integer id, Integer flujo){}
	    
	//Getters :
	    

	/*Pre: -
	Post: Retorna la id del node dintre el graf. Si el node no pertany al graf saltarà una IOException.*/
	    public Integer getNodeId( T node ){
	    	return 0;
	    }
	
	/*Pre: -
	Post: Retorna una array de Integers amb els identificadors ( Integers ) dels nodes que 
	poden accedir al node id. Si id no és vàlid retornarà una IOException.*/
	public ArrayList<Integer> getInNodes( Integer id){
		ArrayList<Integer> inNodes = new ArrayList<Integer>(0);
    	return inNodes;
	}

	/*Pre: inID ha de ser diferent de outID.
	Post: True si el node outID comunica amb el node inID. Si alguna de les ids no és vàlida 
	saltarà una IOException.*/
	public boolean adjacents(Integer inID, Integer outID){
		return false;
	}

	   /* Pre: -
	Post: Retorna una array amb les ids dels nodes als que es pot accedir des del 
	node id. Si id no és vàlida retornarà una IOException.*/
	    public ArrayList<Integer> getOutNodes(Integer id){
	    	ArrayList<Integer> outNodes = new ArrayList<Integer>(0);
	    	return outNodes;
	    }
	        
	/*Pre: -
	Post: Retorna la classe Objecte del node id. Si la id no és vàlida retornarà una IOException.*/
	public T getNode(Integer id){
		return t;
	}
	    
	/*Pre: -
	Post: Retorna el número de nodes del graf. */
	    public Integer getNSize(){
	    	return 0;
	    }
	
	/*Pre: -
	Post: Retorna el número d’arestes del graf.*/
	    public Integer getASize(){
	    	return 0;
	    }

	    /*Pre: inID ha de ser diferent de outID.
	Post: Retorna la id de l’aresta que conecta el node outID amb el node inID. Si alguna de les 
	ids no és vàlida o no hi ha aresta entre els nodes saltarà una IOException.*/
	    public Integer getIDAresta(Integer inID, Integer outID){
	    	return 0;
	    }
	    


	    /*Pre: -
	Post: Retorna la capacitat de l’aresta id. Si id no és vàlid saltarà una IOException.*/
	    public Integer getCapacidadAresta(Integer id ){
	    	return 0;
	    }
	    
	   /* Pre:  - 
	Post: Retorna el cost de l’aresta id. Si la id no és vàlida saltarà una IOException.*/
	    public Double getCosteAresta( Integer id ){
	    	return 0.0;
	    }


	    /*Pre: -
	    Post: Retorna el flujo de l’aresta id. Si id no és vàlida saltarà una IOException.*/
	    public Integer getFlujoAresta(Integer id){
	    	return 0;
	    }
	    
	    
	    /*Removers:
	    	Pre: -
	    	Post: Borra el node id del graf. Si id no és vàlid saltarà una IOException.*/
	    	    public void removeNode(Integer id){}
	    	    
	    /*	Pre: id_to i id_from no poden ser iguals.
	    	Post: Borra l’aresta amb origen node id_from i destí node id_to del Graf. 
	    	Si l’aresta no existeix o els ids no són vàlids saltarà un error IOException.*/
	    	    public void removeAresta(Integer id_to, Integer id_from){}

	    

	
}
