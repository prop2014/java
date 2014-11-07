/*Clase Autor: Felix */ 


package Model;
import java.util.*;

import Model.Turno;

public class Calendari {

	private Map <Date, Turno[]> cale;
	
	public Calendari(){}
		//constructora copia
	public Calendari(Calendari cal){}
	
	// modifica el turno t de la fecha data
	public void modificarTurno(Date data,Turno t){}
	
	//añade un turno al calendario en la fecha t
	public void afegirTorn(Date data, Turno t){}
	
	// 	** mes requisits
	public int Csize(){
		return cale.size();
	}
	 // devuelve un arraylist de todos los turnos
	public ArrayList<Turno>  getTorns(){
		ArrayList<Turno> blabla = new ArrayList<Turno>();
		return blabla;
	}
	
}
