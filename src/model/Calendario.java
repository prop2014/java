package model;
//import Model.Turno;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.TreeMap;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Iterator;
//import java.util.Collection;
import java.io.IOException;

/**
 *
 * @author Felix Fernando Ramos Velázquez
 */
public class Calendario
{
	/* Atributos privados */

	private TreeMap<GregorianCalendar,Vector<Turno>> cal;


	/* Constructoras */

	/** @brief Constructora por defecto
	 * 
	 * Crea un calendario vacío.
	 */
	public Calendario()
	{
		cal = new TreeMap<GregorianCalendar,Vector<Turno>>();
	}
	

	/** @brief Constructora copia
	 * 
	 * Crea un calendario que es una copia de <i>c</i>.
	 * 
	 * @param <i>c</i> es el calendario que se copiará.
	 */
	public Calendario(Calendario c)
	{
		cal.putAll(c.cal);
	}


	//------ Métodos públicos -------//

	/* Modificadoras */

	/** @brief Modificadora añadir día vacacional
	 * 
	 * Añade un nuevo día vacacional al calendario (si éste no existe) y sus 3 turnos de guardias correspondientes.
	 *
	 * @param <i>d</i> es la fecha del día vacacional que se añadirá al calendario.
	 */
	public void addDiaVacacional(GregorianCalendar d) throws IllegalArgumentException
	{
		if(cal.containsKey(d)){			
			throw new IllegalArgumentException("Error al añadir el dia vacacional: el dia vacacional ya existe.\n");
		}
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

	
	/** @brief Modificadora eliminar día vacacional
	 * 
	 * Elimina un día vacacional del calendario (si éste ya existe) y sus 3 turnos de guardias correspondientes.
	 *
	 * @param <i>d</i> es la fecha del día vacacional que se eliminará del calendario.
	 */
	public void deleteDiaVacacional(GregorianCalendar d) throws IllegalArgumentException
	{
		if(!cal.containsKey(d)){			 
			throw new IllegalArgumentException("Error al eliminar el dia vacacional: el dia vacacional NO existe.\n");
		}
		cal.remove(d);
	}

	
	/** @brief Modificadora de un turno
	 * 
	 * Reemplaza por <i>t</i> al turno del calendario que coincide con la fecha y tipo de <i>t</i>.
	 *
	 * @param <i>t</i> es el turno que reemplazará al turno existente en el calendario con igual fecha y tipo.
	 */
	public void replaceTurno(Turno t) throws IllegalArgumentException
	{
		GregorianCalendar gc = new GregorianCalendar();
		gc = t.getFecha();
		if(!cal.containsKey(gc)){
			throw new IllegalArgumentException("Error al reemplazar el turno: el turno NO existe.\n");
		}
		int i;
		String tt = t.getTipoTurno();
		if(tt == "m") i=0;
		else if(tt == "t") i=1;
		else i=2;
		cal.get(gc).add(i,t);
	}


	/* Consultoras */
	
	/** @brief Consultora de un turno
	 * 
	 * Devuelve el turno de tipo <i>tt</i> correspondiente a la fecha <i>d</i>.
	 * Si <i>d</i> no corresponde a ningún día vacacional (no existen turnos en dicha fecha), devuelve Null.
	 * 
	 * @param <i>d</i> Fecha del turno
	 * @param <i>tt</i> Tipo de turno, que será "m" (mañana), "t" (tarde) o "n" (noche).
	 * @return Turno de tipo <i>tt</i> con fecha <i>d</i>, o Null.
	 */
	public Turno getTurno(GregorianCalendar d, String tt) throws IllegalArgumentException
	{
		if(!cal.containsKey(d)){
			throw new IllegalArgumentException("Error al consultar el turno: el turno NO existe.\n");
		}
		int i;
		if(tt == "m") i=0;
		else if(tt == "t") i=1;
		else i=2;
		Turno t = new Turno();
		t = cal.get(d).get(i);
		return t;
	}
	

	/** @brief Consultora de los turnos de un día vacacional
	 * 
	 * Devuelve los 3 turnos correspondientes a la fecha d.
	 * Si d no corresponde a ningún día vacacional (no existen turnos en dicha fecha), devuelve Null.
	 * 
	 * @param d Fecha del día vacacional.
	 * @return 
	 */
	public ArrayList<Turno> getTurnosDiaVacacional(GregorianCalendar d) throws IllegalArgumentException
	{
		if(!cal.containsKey(d)){
			throw new IllegalArgumentException("Error al consultar los turnos: el dia vacacional NO existe.\n");
		}
		ArrayList<Turno> al = new ArrayList<Turno>();
				for(int i=0; i<3; ++i){
					al.add(cal.get(d).get(i));
				}
		return al;
	}

	
	/** @brief Consultora de todos los turnos
	 * 
	 * @return Todos los turnos de los días vacacionales del calendario.
	 */
	public ArrayList<Turno> getAllTurnos(){
		ArrayList<Turno> al = new ArrayList<Turno>(cal.size());
		Iterator<GregorianCalendar> it = cal.keySet().iterator();
		while(it.hasNext()) {
			GregorianCalendar gc = it.next();
			for(int i=0; i<3; ++i){
				al.add(cal.get(gc).get(i));
			}
		}
		return al;
	}
	

	/** @brief Consultora existe día vacacional
	 * 
	 * Comprueba si existe en el calendario un día vacacional con fecha <i>d</i>.
	 * 
	 * @param <i>d</i> es la fecha del día vacacional que se comprueba
	 * @return True si existe un día vacacional con fecha <i>d</i>, False en caso contrario.
	 */
	public boolean existsDiaVacacional(GregorianCalendar d){
		return cal.containsKey(d);
	}


	/** @brief Consultora de todas las fechas
	 * 
	 * @return Todas las fechas de los días vacacionales del calendario.
	 */
	public ArrayList<GregorianCalendar> getAllDias(){
		ArrayList<GregorianCalendar> al = new ArrayList<GregorianCalendar>(cal.size());
		Iterator<GregorianCalendar> it = cal.keySet().iterator();
		while(it.hasNext()) {
			al.add(it.next());
		}
		return al;
	}
	
	
	/** @brief Consultora del número total de días vacacionales
	 * 
	 * @return Número de días vacacionales del calendario.
	 */
	public int getNumDias(){
		return cal.size();
	}
	

	/** @brief Consultora del número total de turnos
	 * 
	 * @return Número de turnos vacacionales del calendario.
	 */
	public int getNumTurnos(){
		return cal.size()*3;
	}
	
	
//	public ArrayList<Vector<Turno>> getTurnos(){
//		ArrayList<Vector<Turno>> alturno = new ArrayList<Vector<Turno>>(cal.size());
//		Iterator<GregorianCalendar> itr = cal.keySet().iterator();
//		while(itr.hasNext()) {
//			GregorianCalendar key = itr.next();
//			alturno.add(cal.get(key));
//		}
//		return alturno;
//	}

}