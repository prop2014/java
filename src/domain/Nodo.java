package domain;

public class Nodo {
	
	private int id;
	String tipo;
	
	public Nodo() {}
	
	public Nodo(int id, String tipo) {}
	
	public int getId() {
		return id;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
