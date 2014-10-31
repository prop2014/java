//Autor Sergi Orra
package Model;

public class Doctor {

	/* Atributos */
	private int id_doctor;
	private String nombre;
	private int num_max_turnos;
	private double SueldoTurno;
	private Scanner teclado;

	
	
	/* Constructora */

		public Doctor() {}

	

	/* Metodos públicos */

		public void inicializarDoctor(int i) {}
		
		public void imprimirDoctor(Doctor d) {}
		
		public int getId() {
			return id_doctor;
		}

		    
		public String getNombre() {
		    return nombre;
		}
		    
		public int getNum_max_turnos() {
			return num_max_turnos;
		}
		    
		public double getSueldoTurno() {
		    return SueldoTurno;
		}
		    
	    public void setId(int id) {
		    this.id_doctor = id;
		}
		    
		public void setNombre(String nombre) {
		    this.nombre = nombre;
		}
		    
		public void setNum_max_turnos(int num) {
		    this.num_max_turnos= num;
		}
		    
		public void setSueldoTurno(float sueldo) {
		    this.SueldoTurno = sueldo;
		}
	
}
