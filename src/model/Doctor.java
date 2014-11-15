package model;
import java.util.*;

/**
* Representa un Doctor de l'hospital
* @author sergi.orra
*/

public class Doctor {
	
		private int idDoctor;
		private String nombre;
		private int numMaxTurnos;
		private double SueldoTurno;
		private Map <Integer , Restriccion> Restricciones;
		
/*  CONSTRUCTORAS  */
		
		/**
		* Crea un Doctor generico sin atributos
		*/
		public Doctor() {
		}
		
		/**
		* Crea un Doctor generico con atributos
		* @param id: identificador del Doctor,
		* 		 nombre: nombre del Doctor,
		* 		 numMaxTurnos: numero maximo de turnos que quiere trabajar un doctor
		* 		 sueldoTurno: sueldo base que cobra el doctor por turno
		*/
		public Doctor (int id, String nombre, int numMaxTurnos, double sueldoTurno){
			idDoctor=id;
			this.nombre = nombre;
			this.numMaxTurnos = numMaxTurnos;
			SueldoTurno = sueldoTurno;
			Restricciones = new TreeMap<Integer , Restriccion>();
		}

		
/*  CONSULTORAS  */
	
		/**
		*Consultora del identificador del Doctor
		* @return La id del Doctor
		*/
		public int getId() {
			return idDoctor;
		}
		
		/**
		*Consultora del nombre del Doctor
		* @return El nombre del Doctor
		*/
		public String getName() {
		    return nombre;
		}
		
		/**
		*Consultora del numero maximo de turnos del Doctor
		* @return numero maximo de turnos
		*/ 
		public int getNumMaxTurn() {
			return numMaxTurnos;
		}
		
		/**
		*Consultora del sueldo por turno del Doctor
		* @return sueldo por turno del Doctor
		*/ 
		public double getSalaryTurn() {
		    return SueldoTurno;
		}
		
		/**
		*Consultora del conjunto de restricciones del Doctor
		* @return el ArrayList<Restriccion> de las restricciones del Doctor
		*/
		public ArrayList<Restriccion> getRestrictions(){
			ArrayList<Restriccion> restr = new ArrayList<Restriccion>(Restricciones.size());
			Iterator<Integer> it = Restricciones.keySet().iterator();
			while(it.hasNext()) {
			    Integer key = it.next();
			    restr.add(Restricciones.get(key));
			}
			return restr;
		}
		
		/**
		 * Consulta si el Doctor tiene restricciones
		 * @return True si el Doctor no tiene restricciones, False si tiene minimo una
		 */
		public boolean isREmpty(){
			return Restricciones.isEmpty();
		}
		
		/**
		*Consultora del numero de restricciones del Doctor
		* @return cantidad de restricciones del Doctor
		*/
		public int Rsize(){
			return Restricciones.size();
		}
		
		
/*  MODIFICADORAS  */
		
		/** 
		* Modificadora del identificador del Doctor
		* @param id: es el nuevo identificador del Doctor
		*/
	    public void setId(int id) {
		    this.idDoctor = id;
		}
	    
	    /** 
		* Modificadora del nombre del Doctor
		* @param nombre: es el nuevo nombre del Doctor
		*/ 
		public void setName(String nombre) {
		    this.nombre = nombre;
		}
		
		/** 
		* Modificadora del numero maximo de turnos del Doctor
		* @param num: es el nuevo numero maximo de turnos del Doctor
		*/ 
		public void setNumMaxTurn(int num) {
		    this.numMaxTurnos= num;
		}
		
		/** 
		* Modificadora del sueldo por turno del Doctor
		* @param sueldo: es el nuevo sueldo por turno del Doctor
		*/ 
		public void setSalaryTurn(double sueldo) {
		    this.SueldoTurno = sueldo;
		}
		
		/** 
		 * Metodo que inserta una restriccion nueva en el Doctor
		 * pre: El Doctor no contiene la restriccion r. 
		 * @param r: es la nueva restriccion que se quiere anadir al Doctor
		 * @return True si se ha podido insertar la restriccion, False en caso contrario
		 */
		public boolean addRestriction(Restriccion r) {
			if (Restricciones.containsKey(r.getIdRestriccion())) {
				return false;
			}
			else {
				Restricciones.put(r.getIdRestriccion(), r);
				return true;
			}
		}
		
		/** 
		 * Metodo que elimina una restriccion en el Doctor
		 * @param id: id de la restriccion que se quiere eliminar del Doctor
		 * @return True si se ha podido eliminar la restriccion, False en caso contrario
		 */
		public boolean deleteRestriction(int id) {
			if (!Restricciones.containsKey(id)) {
				return false;
			}
			else {
				Restricciones.remove(id);
				return true;
			}
		}
		
		/** 
		* Metodo que elimina todas las restricciones del Doctor
		*/
		public void clearRestrictions(){
			Restricciones.clear();
		}

	
}
