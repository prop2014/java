package domain;
import java.util.*;

public class nodoTurno extends Nodo {
	private Date fecha;
	private String tipoTurno;
	
	public nodoTurno() {}
	
	public nodoTurno(int id, String tipo, Date fecha, String tipoTurno) {
		super(id,tipo);
		this.fecha=fecha;
		this.tipoTurno=tipoTurno;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public String getTipoTurno() {
		return tipoTurno;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public void setTipoTurno(String tipoTurno) {
		this.tipoTurno = tipoTurno;
	}
}
