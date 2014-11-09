package Model;
//import Model.Turno;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.TreeMap;
import java.util.Vector;
import java.util.Collection;

/**
 *
 * @author Felix Fernando Ramos Velázquez
 */
public class Calendario {

	private TreeMap <GregorianCalendar, Vector<Turno>> cal;

	private SimpleDateFormat sdf;

	/* Constructoras */

	/**
	 * Constructora por defecto.
	 * Crea un calendario vacío.
	 */
	public Calendario(){
		cal = new TreeMap <GregorianCalendar, Vector<Turno>>();
		sdf = new SimpleDateFormat("dd/M/yyyy");
	}

	/**
	 * Constructora copia.
	 * 
	 */
	public Calendario(Calendario cal){
		/* en construcción */
	}

	/* Metodos públicos */

	/* Modificadoras */

	/**
	 * Añade un nuevo día vacacional al calendario (si éste no existe),
	 * y sus 3 turnos de guardias correspondientes.
	 *
	 * @param d Fecha del día vacacional que se añadirá al calendario.
	 */
	public void addDiaVacacional(GregorianCalendar d){
		if(cal.containsKey(d)){			
			String date = sdf.format(d); 
			throw new IllegalArgumentException("Error al añadir el dia vacacional: el dia vacacional " + date + " ya existe.\n");
		}

		else{
			Vector<Turno> v = new Vector<Turno>(3);
			for(int i=0; i<3; ++i){
				Turno t = new Turno();
				String tt;
				if(i==0) tt = "m";
				else if(i==1) tt = "t";
				else tt = "n";
				t.setFecha(d);
				t.setTipoTurno(tt);
				v.add(i,t);
			}
			cal.put(d,v);
		}
	}

	/**
	 * Elimina un día vacacional del calendario (si éste ya existe),
	 * y sus 3 turnos de guardias correspondientes.
	 *
	 * @param d Fecha del día vacacional que se eliminará del calendario.
	 */
	public void deleteDiaVacacional(GregorianCalendar d){
		if(!cal.containsKey(d)){			
			String date = sdf.format(d); 
			throw new IllegalArgumentException("Error al eliminar el dia vacacional: el dia vacacional " + date + " NO existe.\n");
		}
		else{
			cal.remove(d);
		}
	}
	
	public void setTurno(GregorianCalendar d, String tt){
		/* en construcción */
	}

	/* Consultoras */

	/**
	 * Devuelve los 3 turnos correspondientes a la fecha d.
	 * Si d no corresponde a ningún día vacacional (no existen turnos en dicha fecha), devuelve Null.
	 * 
	 * @param d Fecha del día vacacional.
	 * @return 
	 */
	public Collection<Turno> getTurnosDiaVacacional(GregorianCalendar d){
		/* en construcción */
		Collection<Turno> c;
		//		for(int i=0; i<3; ++i){
		//			Turno t = new Turno();
		//			t = cal.get(d).get(i);
		//			c.add(t);
		//		}
		return c;
	}


	/**
	 * Devuelve el turno de tipo tt correspondiente a la fecha d.
	 * Si d no corresponde a ningún día vacacional (no existen turnos en dicha fecha), devuelve Null.
	 *  
	 * @param d Fecha del turno
	 * @param tt Tipo de turno, que será "m" (mañana), "t" (tarde) o "n" (noche).
	 * @return Turno de tipo tt con fecha d, o Null.
	 */
	public Turno getTurno(GregorianCalendar d, String tt){
		int i;
		if(tt == "m") i=0;
		else if(tt == "t") i=1;
		else i=2;
		Turno t = new Turno();
		t = cal.get(d).get(i);
		return t;
	}
	
	
	// devuelve si existeel dia vacacional
	public boolean existDiaVacacional(GregorianCalendar d){
		return cal.containsKey(d);
	}
	

	/**
	 * Consultora del número total de días vacacionales.
	 * 
	 * @return Número de días vacacionales del calendario.
	 */
	public int getNumDias(){
		return cal.size();
	}

	/**
	 * Consultora del número total de turnos.
	 * 
	 * @return Número de turnos vacacionales del calendario.
	 */
	public int getNumTurnos(){
		return cal.size()*3;
	}
}
