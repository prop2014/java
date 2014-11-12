package domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;
import java.util.Collections;

/**
 *
 * @author Mingjian 
 */
 public class EdmondsKarp<T> extends FordFoulkerson<T>
 {

 	// nombre de nodes
 	private ArrayList<ArrayList<Integer>> camins;
 	private Integer[] parent;


 	/**
 	 *
 	 *
 	 *
 	 */
 	public EdmondsKarp(Integer nodeInicial, Integer nodeDesti, Graf<T> graf)
 	{
 		super(nodeInicial, nodeDesti, graf);
 		this.parent = new Integer[graf.getNSize()];
 		this.camins = new ArrayList<ArrayList<Integer>>();
 	}

 	/**
 	 *
 	 *
 	 *
 	 */
 	public ArrayList<ArrayList<Integer>> retorna_camins(Graf<T> graf, Integer n) throws IOException
 	{
 		if(n < 1) throw new IOException("n ha de ser major que 1");

 		//Graf<T> rGraf = new Graf<T>();
 		//rGraf = graf.getGrafInicial(); 		
 		ArrayList<Integer> cami = new ArrayList<Integer>();
 		cami = dameCamino(graf);
 		Integer sumFlow = 0;
 		while(cami != null && sumFlow < n)
 		{
 			//System.out.println("haciendo un while");
 			Integer mfc = maxFlowCurrent(graf, parent);
 			if(mfc <= n)
 			{
 				camins.add(cami);
 				sumFlow += mfc;
 			}
 			cami = dameCamino(graf);
 		}

 		return camins;
 	}

 	/**
 	 *
 	 *
 	 */
 	private Integer maxFlowCurrent(Graf<T> graf, Integer[] parent) throws IOException
 	{
 		Integer path_flow = Integer.MAX_VALUE;

 		Integer u;
 		Integer idArestaUV;
 		Integer capacitatUV;
 		Double cost;

 		for (Integer v = t; v != s; v = parent[v])
        {
            u = parent[v];
            idArestaUV = graf.getIDAresta(u, v);
            //System.out.println("idAresta de padre a hijo = " + idArestaUV);
            capacitatUV = graf.getCapacidadAresta(idArestaUV);
            //System.out.println("capacitatAresta de padre a hijo = " + capacitatUV);
            path_flow = Math.min(path_flow, capacitatUV);
        }
 
        for (Integer v = t; v != s; v = parent[v])
        {
            u = parent[v];
            idArestaUV = graf.getIDAresta(u, v);
            //idArestaVU = graf.getIDAresta(v, u);
            //System.out.println("idAresta de hijo a padre = " + idArestaVU);
            capacitatUV = graf.getCapacidadAresta(idArestaUV);
            //capacitatVU = graf.getCapacidadAresta(idArestaVU);	
            //System.out.println("capacitat DE HIJO A PADRE = " + capacitatVU);
            //System.out.println("path_flow = " + path_flow);
            capacitatUV -= path_flow;
            cost = graf.getCosteAresta(idArestaUV);
            graf.substituirAresta(idArestaUV, capacitatUV, cost);
            //capacitatVU += path_flow;
        }
        //System.out.println("return = " + path_flow + "\n");
        return path_flow;

 	}

 	/**
 	 * 
 	 *
 	 *
 	 *
 	 */
 	@Override
 	public ArrayList<Integer> dameCamino(Graf<T> graf) throws IOException
 	{


 		//Integer V = graf.getNSize();

 		ArrayList<Integer> path = new ArrayList<Integer>();
 
 		
 		//create a queue, enqueue the vertex and mark the vertex as visited
 		Queue<Integer> queue = new LinkedList<Integer>();
 		queue.add(s);
 		parent[s] = -1;
 		Boolean found = false; 
 		while(! queue.isEmpty() && (! found))
 		{
 			//remove the vertex at the head
 			Integer head = queue.poll();
 			
 			if(head == t) found = true;
 			else 
 			{
	 			ArrayList<Integer> outArray = new ArrayList<Integer>();
	 			
	 			outArray = graf.getOutNodes(head);
	 			for(Integer i = 0; i < outArray.size(); ++i)
	 			{

	 				Integer idEdge = graf.getIDAresta(head, outArray.get(i));
	 				
	 				Integer flux = graf.getFlujoAresta(idEdge);
	 			
	 				Integer capacity = graf.getCapacidadAresta(idEdge);
	 				
	 				if((capacity > 0) && (flux < capacity))
	 				{
	 					parent[outArray.get(i)] = head;
	 					queue.add(outArray.get(i));
	 				}
	 			}
	 		}
 		}

 		if(found)
 		{
 			Integer aux = t;
 			path.add(aux);
	 		while(parent[aux] != -1)
	 		{
	 			aux = parent[aux];
	 			path.add(aux);
	 		}
	 		Collections.reverse(path);
	 		return path;
	 	}
	 	else 
	 		return null;
 		
 	}

 }