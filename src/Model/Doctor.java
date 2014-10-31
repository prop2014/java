//Autor Sergi Orra
package Model;
import java.util.*;

public class Doctor {

	/* Atributos */
	private int idDoctor;
	private String nombre;
	private int numMaxTurnos;
	private double SueldoTurno;
		
	//private Scanner teclado;

	
	
	/* Constructora */

		public Doctor() {}
		
		public Doctor (int id, String nombre, int numMaxTurnos, double sueldoTurno){
			idDoctor=id;
			this.nombre = nombre;
			this.numMaxTurnos = numMaxTurnos;
			SueldoTurno = sueldoTurno;
		}

	

	/* Metodos publicos */

		public void inicializarDoctor(int i) {}
		
		public int getId() {
			return idDoctor;
		}

		    
		public String getNombre() {
		    return nombre;
		}
		    
		public int getNumMaxTurnos() {
			return numMaxTurnos;
		}
		    
		public double getSueldoTurno() {
		    return SueldoTurno;
		}
		    
	    public void setId(int id) {
		    this.idDoctor = id;
		}
		    
		public void setNombre(String nombre) {
		    this.nombre = nombre;
		}
		    
		public void setNumMaxTurnos(int num) {
		    this.numMaxTurnos= num;
		}
		    
		public void setSueldoTurno(double sueldo) {
		    this.SueldoTurno = sueldo;
		}
		
		public void addRestriccion(Restriccion r) {
		}
		
		public void eliminarRestriccion(Restriccion r) {
		}

	
}
