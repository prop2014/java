package Drivers;

import java.util.*;
import java.io.*;

import Domain.Graf;
import Domain.FFDijkstra;


public class DriverDijkstra {


public static void main(String[] args) throws IOException{
	Scanner teclado;
	teclado = new Scanner(System.in);
	
	int id = -1;
	int opcion = -1;
	
	Graf<Integer> g = new Graf<Integer>();
	InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader (isr);
	
	while(opcion != 0){
		
		
		System.out.print("¿Que desea hacer?\n\n");
		
		System.out.print("1: Añadir Nodo\n");
		System.out.print("2: Añadir Arista\n");
		System.out.print("3: Encontrar Camino mínimo\n");
		/*System.out.print("4: Crear Restriccion tipo NOT_Especial\n");
		System.out.print("NOP 5: Crear Restriccion tipo NOT_Fecha\n");
		System.out.print("6: Crear Restriccion tipo NOT_Turno\n");
		System.out.print("7: Crear Restriccion tipo MAX_Turnos_por_Dia\n");
		System.out.print("8: Crear Restriccion tipo MAX_Turnos_Consecutivos\n");
		System.out.print("NOP 9: Crear Restriccion tipo MAX_Dias_Rango\n");
		System.out.print("10: Ver Restriccion ya creada\n");*/
	
		
		opcion = teclado.nextInt(); //leemos opcion
		
        
		switch(opcion){
			case 1:
				System.out.println("Pon una ID para el nodo");
    			Integer id_nodo = null;
    			id_nodo = Integer.parseInt(br.readLine());
				try {
					g.afegirNode(id_nodo);
					System.out.println(g.getNode(id_nodo));
				}
				catch (IOException e) {
				    throw new IOException(e);
				}
				break;
				
			case 2:
				System.out.print("Pon una ID para el nodo FROM\n");
				Integer id_from = null;
    			id_from = Integer.parseInt(br.readLine());
				System.out.print("Pon una ID para el nodo TO\n");
				Integer id_to = null;
    			id_to = Integer.parseInt(br.readLine());
				System.out.print("Pon una capacidad para la arista\n");
				Integer capacidad = null;
    			capacidad = Integer.parseInt(br.readLine());
				System.out.print("Pon un coste para la arista\n");
				Double coste = null;
    			coste = Double.parseDouble(br.readLine());
    			System.out.print("Pon un flujo para la arista\n");
				Integer flujo = null;
    			flujo = Integer.parseInt(br.readLine());
				System.out.printf("id_from: %d, id_to: %d, capacidad: %d, coste: %f, flujo: %d \n", id_from, id_to, capacidad, coste, flujo);
				try {
					g.conectarNodes(id_from, id_to, capacidad, coste);
					int arista = g.getIDAresta(id_from, id_to);
					g.setFlujoAresta(arista, flujo);
					
				}
				catch (IOException e) {
				    throw new IOException(e);
				}
				break;
			
			case 3:
				FFDijkstra dijk = new FFDijkstra();
				ArrayList<Integer> camino = new ArrayList<Integer>();
				camino = dijk.dameCamino(g);
				for(int i = 0; i < camino.size(); ++i) System.out.printf("ID: " + camino.get(i) + " -> ");
				break;
			default:
		}
		/*
		// GESTION DE SALIDA DEL BUCLE
		String s;
		System.out.print("Desea Continuar? (Si/No)\n");
		
		s = teclado.next();
		// Si seleccionamos "No" o sus variantes saldremos del bucle
		if(s.equals("No") || s.equals("no") || s.equals("N") || s.equals("NO") || s.equals("n")) opcion = 0; */
		
		
	}
	System.out.print("PROGRAM EXIT");
}
	
}
