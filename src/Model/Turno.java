package Model;

/**
 *
 * @author Felix Fernando Ramos Velázquez
 */
public class Turno {

	/* Atributos */
  private Date fecha;
  private TipoTurno turno;
  private String especial;
  private int numDoctores;

	/* Constructoras */

  /**
   *
   * Constructora por defecto
   */
	public Turno() {
    fecha = null;
    turno = null;
    especial = null;
    numDoctores = 0;
  }

	

	/* Metodos públicos */

	/* Modificadoras */
  
  public void setFecha(Date d){
    fecha = d;
  }
  
  public void setTipoTurno(TipoTurno tt){
    turno = tt;
  }
  
  public void setEspecial(String esp){
    especial = esp;
  }
  
  public void setNumDoctores(int n){
    numDoctores = n;
  }
  
  /* Consultoras */
  
  public Date getFecha(){
    return fecha;
  }
	
  public String getTipoTurno(){
    return turno;
  }
  
  public String getEspecial(){
    return especial;
  }
  
  public int getNumDoctores(){
    return numDoctores;
  }
}