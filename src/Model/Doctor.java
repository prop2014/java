/* Autor: Sergi Orra */

package Model;
import java.util.*;
import java.io.IOException;

public class Doctor {

		/* Atributos */
	
		private int idDoctor;
		private String nombre;
		private int numMaxTurnos;
		private double SueldoTurno;
		private Map <Integer , Restriccion> Restricciones;
		

/*  CONSTRUCTORAS  */
	
	    /* Constructoras de Doctor */

		public Doctor() {}
		
		public Doctor (int id, String nombre, int numMaxTurnos, double sueldoTurno){
			idDoctor=id;
			this.nombre = nombre;
			this.numMaxTurnos = numMaxTurnos;
			SueldoTurno = sueldoTurno;
			Restricciones = new TreeMap<Integer , Restriccion>();
		}

/*  CONSULTORAS  */

		
		/* Consultora Id del Doctor */
		
		public int getId() {
			return idDoctor;
		}
		
		/* Consultora Nombre del Doctor */
		    
		public String getNombre() {
		    return nombre;
		}
		
		/* Consultora Numero Maximo de Dias que trabajo un doctor */
		    
		public int getNumMaxTurnos() {
			return numMaxTurnos;
		}
		
		/* Consultora Sueldo del Doctor */
		    
		public double getSueldoTurno() {
		    return SueldoTurno;
		}
		
		/* Devuelve un ArrayList con todas las retricciones del Doctor */
		public ArrayList<Restriccion> getRestricciones(){
			ArrayList<Restriccion> restr = new ArrayList<Restriccion>(Restricciones.size());
			Iterator<Integer> it = Restricciones.keySet().iterator();
			while(it.hasNext()) {
			    Integer key = it.next();
			    restr.add(Restricciones.get(key));
			}
			return restr;
		}
		
		/* True si el Doctor del parametro implicito no tiene ninguna restriccion */
		
		public boolean isREmpty(){
			return Restricciones.isEmpty();
		}
		 //consultora del numero de doctors
		public int Rsize(){
			return Restricciones.size();
		}
		
		
/*  MODIFICADORAS  */
		
		/* Modificadora Id del Doctor */
		    
	    public void setId(int id) {
		    this.idDoctor = id;
		}
	    
	    /* Modificadora Nombre del Doctor */
		    
		public void setNombre(String nombre) {
		    this.nombre = nombre;
		}
		
		/* Modificadora Numero Maximo de Dias que trabajo un doctor */
		    
		public void setNumMaxTurnos(int num) {
		    this.numMaxTurnos= num;
		}
		
		/* Modificadora Sueldo del Doctor */
		    
		public void setSueldoTurno(double sueldo) {
		    this.SueldoTurno = sueldo;
		}
		
		
		/*True si se ha podido añadir la restriccion
		  False si no se ha podido añadir la resticcion en el map */
		
		public boolean addRestriccion(Restriccion r) {
			if (Restricciones.containsKey(r.getId())) {
				return false;
			}
			else {
				Restricciones.put(r.getId(), r);
				return true;
			}
		}
		
		/*True si se ha podido eliminar la restriccion
		  False si no se ha podido eliminar la restriccion del map */
		
		public boolean eliminarRestriccion(int id) {
			if (!Restricciones.containsKey(id)) {
				return false;
			}
			else {
				Restricciones.remove(id);
				return true;
			}
		}
		
		/* Borrar todas las restricciones de un Doctor (¿Necesario?) */
		
		public void clearRestricciones(){
			Restricciones.clear();
		}

	
}
