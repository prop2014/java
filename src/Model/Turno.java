package Model;
import java.util.GregorianCalendar;

/**
 *
 * @author Felix Fernando Ramos Velázquez
 */
public class Turno {

	/* Atributos */
	private GregorianCalendar fecha;
	private String tipoTurno;
	private String especial;
	private int numDoctores;

	/* Constructoras */

	/**
	 *
	 * Constructora por defecto
	 */
	public Turno(){
		fecha = null;
		tipoTurno = null;
		especial = null;
		numDoctores = 0;
	}

	/**
	 *
	 * Constructora con parámetros
	 */
	public Turno(GregorianCalendar d, String tt, String de, int nd){
		fecha = d;
		tipoTurno = tt;
		especial = de;
		numDoctores = nd;
	}
	/* Metodos públicos */

	/* Modificadoras */

	public void setFecha(GregorianCalendar d){
		fecha = d;
	}

	public void setTipoTurno(String tt){
		tipoTurno = tt;
	}

	public void setEspecial(String de){
		especial = de;
	}

	public void setNumDoctores(int n){
		numDoctores = n;
	}

	/* Consultoras */

	public GregorianCalendar getFecha(){
		return fecha;
	}

	public String getTipoTurno(){
		return tipoTurno;
	}

	public String getEspecial(){
		return especial;
	}

	public int getNumDoctores(){
		return numDoctores;
	}
}