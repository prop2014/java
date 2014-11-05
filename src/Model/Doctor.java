//Autor Sergi Orra
package Model;
import java.util.*;

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
		
		
		/*añadir una restriccion r al Doctor */
		
		public void addRestriccion(Restriccion r) {
		}
		
		/* Eliminar una Restriccion r al Doctor */
		
		public void eliminarRestriccion(Restriccion r) {
		}
		
		/* Borrar todas las restricciones de un Doctor (¿Necesario?) */
		
		public void clearRestricciones(){
			Restricciones.clear();
		}

	
}
