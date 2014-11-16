package domain;
import java.io.IOException;
import java.util.*;

import model.*;


public class CtrlDoctor {
	/** Atributos */
	private ArrayList<Doctor> Doctors;
	
	
	/* Constructora */
	public CtrlDoctor(){
		Doctors = new ArrayList<Doctor>();
	}
	
	public CtrlDoctor(ArrayList<Doctor> Doc){
		Doctors = Doc;
	}
	
	
	/* Metodos publicos */

/* ---------------DOCTORES ------------------- */
	
	public Integer getIdDoctor(int idDoc) throws IOException {		
		if(idDoc < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				return Doctors.get(i).getId();
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
		return null;
	}
	
	public String getNombreDoctor(int idDoc) throws IOException {	
		if(idDoc < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				return Doctors.get(i).getName();
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
		return null;
	}
	
	public Integer getNumMaxTurnosDoctor(int idDoc) throws IOException {		
		if(idDoc < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				return Doctors.get(i).getNumMaxTurn();
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
		return null;
	}
	
	public Double getSueldoTurnosDoctor(int idDoc) throws IOException {		
		if(idDoc < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				return Doctors.get(i).getSalaryTurn();
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
		return null;
	}
	
	public void setDoctor(int idDoc, String nombre, int numMax, double sueldo) throws IOException {
		if(idDoc < 0) throw new IOException("Valor del identificador incorrecto");
		if(numMax < 0) throw new IOException("Numero maximo de turnos incorrecto");
		if(sueldo < 0.0) throw new IOException("Sueldo por turno incorrecto");
		boolean trobat = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				Doctors.get(i).setName(nombre);
				Doctors.get(i).setNumMaxTurn(numMax);
				Doctors.get(i).setSalaryTurn(sueldo);
				break;
			}
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
	}
	
	
	
/* --------------- RESTRICCIONES -------------------- */
	
	
	/* --------------- GETS COMUNES RESTRICCIONES -------------------- */
	
	public Integer getIdRestriccion(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = new ArrayList<Restriccion>();
				alres = Doctors.get(i).getRestrictions();
				for (int j = 0; j < alres.size(); ++j) {
					if (alres.get(j).getIdRestriccion() == idRes) {
						trobat2 = true;
						return alres.get(j).getIdRestriccion();
					}
					if (trobat2) break;
				}
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
		if (!trobat2) throw new IOException("No existe una Restriccion con esta Id");
		return null;
	}
	
	public String getTipoRestriccion(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = new ArrayList<Restriccion>();
				alres = Doctors.get(i).getRestrictions();
				for (int j = 0; j < alres.size(); ++j) {
					if (alres.get(j).getIdRestriccion() == idRes) {
						trobat2 = true;
						return alres.get(j).getTipo();
					}
					if (trobat2) break;
				}
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
		if (!trobat2) throw new IOException("No existe una Restriccion con esta Id");
		return null;
	}
	
	/* --------------- GETS TIPO MAX TURNOS CONSECUTIVOS -------------------- */
	
	public Integer getMAX_Turnos_Por_Dia(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = new ArrayList<Restriccion>();
				alres = Doctors.get(i).getRestrictions();
				for (int j = 0; j < alres.size(); ++j) {
					if (alres.get(j).getIdRestriccion() == idRes) {
						trobat2 = true;
						MAX_Turnos_por_Dia N = (MAX_Turnos_por_Dia)alres.get(j);
						return N.getNumTurnos();
					}
					if (trobat2) break;
				}
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
		if (!trobat2) throw new IOException("No existe una Restriccion con esta Id");
		return null;
	}
	
	/* --------------- GETS TIPO MAX TURNOS RANGO -------------------- */
	
	public GregorianCalendar getMAX_Turnos_Rango_FeIni(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = new ArrayList<Restriccion>();
				alres = Doctors.get(i).getRestrictions();
				for (int j = 0; j < alres.size(); ++j) {
					if (alres.get(j).getIdRestriccion() == idRes) {
						trobat2 = true;
						MAX_Turnos_Rango N = (MAX_Turnos_Rango)alres.get(j);
						return N.getFechaIni();
					}
					if (trobat2) break;
				}
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
		if (!trobat2) throw new IOException("No existe una Restriccion con esta Id");
		return null;
	}
	
	public GregorianCalendar getMAX_Turnos_Rango_FeFin(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = new ArrayList<Restriccion>();
				alres = Doctors.get(i).getRestrictions();
				for (int j = 0; j < alres.size(); ++j) {
					if (alres.get(j).getIdRestriccion() == idRes) {
						trobat2 = true;
						MAX_Turnos_Rango N = (MAX_Turnos_Rango)alres.get(j);
						return N.getFechaFin();
					}
					if (trobat2) break;
				}
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
		if (!trobat2) throw new IOException("No existe una Restriccion con esta Id");
		return null;
	}
	
	public Integer getMAX_Turnos_Rango_numT(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = new ArrayList<Restriccion>();
				alres = Doctors.get(i).getRestrictions();
				for (int j = 0; j < alres.size(); ++j) {
					if (alres.get(j).getIdRestriccion() == idRes) {
						trobat2 = true;
						MAX_Turnos_Rango N = (MAX_Turnos_Rango)alres.get(j);
						return N.getNumDias();
					}
					if (trobat2) break;
				}
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
		if (!trobat2) throw new IOException("No existe una Restriccion con esta Id");
		return null;
	}
	
	/* --------------- GETS TIPO NOT DIA MES -------------------- */
	
	public Integer getNOT_Dia_Mes(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = new ArrayList<Restriccion>();
				alres = Doctors.get(i).getRestrictions();
				for (int j = 0; j < alres.size(); ++j) {
					if (alres.get(j).getIdRestriccion() == idRes) {
						trobat2 = true;
						NOT_Dia_Mes N = (NOT_Dia_Mes)alres.get(j);
						return N.getDiaMes();
					}
					if (trobat2) break;
				}
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
		if (!trobat2) throw new IOException("No existe una Restriccion con esta Id");
		return null;
	}
	
	/* --------------- GETS TIPO NOT DIA SEMANA -------------------- */
	
	public String getNOT_Dia_Semana(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = new ArrayList<Restriccion>();
				alres = Doctors.get(i).getRestrictions();
				for (int j = 0; j < alres.size(); ++j) {
					if (alres.get(j).getIdRestriccion() == idRes) {
						trobat2 = true;
						NOT_Dia_Semana N = (NOT_Dia_Semana)alres.get(j);
						return N.getDiaSemana();
					}
					if (trobat2) break;
				}
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
		if (!trobat2) throw new IOException("No existe una Restriccion con esta Id");
		return null;
	}
	
	/* --------------- GETS TIPO NOT ESPECIAL -------------------- */
	
	public String getNOT_Especial(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = new ArrayList<Restriccion>();
				alres = Doctors.get(i).getRestrictions();
				for (int j = 0; j < alres.size(); ++j) {
					if (alres.get(j).getIdRestriccion() == idRes) {
						trobat2 = true;
						NOT_Especial N = (NOT_Especial)alres.get(j);
						return N.getEspecial();
					}
					if (trobat2) break;
				}
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
		if (!trobat2) throw new IOException("No existe una Restriccion con esta Id");
		return null;
	}
	
	/* --------------- GETS TIPO NOT FECHA -------------------- */
	
	public GregorianCalendar getNOT_Fecha(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = new ArrayList<Restriccion>();
				alres = Doctors.get(i).getRestrictions();
				for (int j = 0; j < alres.size(); ++j) {
					if (alres.get(j).getIdRestriccion() == idRes) {
						trobat2 = true;
						NOT_Fecha N = (NOT_Fecha)alres.get(j);
						return N.getFecha();
					}
					if (trobat2) break;
				}
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
		if (!trobat2) throw new IOException("No existe una Restriccion con esta Id");
		return null;
	}
	
	/* --------------- GETS TIPO NOT TURNO -------------------- */
	
	public String getNOT_Turno(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = new ArrayList<Restriccion>();
				alres = Doctors.get(i).getRestrictions();
				for (int j = 0; j < alres.size(); ++j) {
					if (alres.get(j).getIdRestriccion() == idRes) {
						trobat2 = true;
						NOT_Turno N = (NOT_Turno)alres.get(j);
						return N.getTipoTurno();
					}
					if (trobat2) break;
				}
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
		if (!trobat2) throw new IOException("No existe una Restriccion con esta Id");
		return null;
	}
	
	/* --------------- GETS TIPO XOR -------------------- */
	
	public ArrayList<GregorianCalendar> getXOR_Dates(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = new ArrayList<Restriccion>();
				alres = Doctors.get(i).getRestrictions();
				for (int j = 0; j < alres.size(); ++j) {
					if (alres.get(j).getIdRestriccion() == idRes) {
						trobat2 = true;
						XOR N = (XOR)alres.get(j);
						ArrayList<GregorianCalendar> dates = new ArrayList<GregorianCalendar>();
						ArrayList<Turno> turnos = N.getListTurnos();
						for (int z = 0; z < turnos.size(); ++z) {
							GregorianCalendar fecha = new GregorianCalendar();
							fecha = turnos.get(z).getDate();
							dates.add(fecha);
						}
					}
					if (trobat2) break;
				}
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
		if (!trobat2) throw new IOException("No existe una Restriccion con esta Id");
		return null;
	}
	
	
	
	
	
	public void addResMAX_Turnos_por_Dia(int idDoc, int idRes, int numT) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		if(numT < 0 || numT > 3) throw new IOException("Valor del numero de turnos incorrecto");
		boolean trobat = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				Restriccion res = new MAX_Turnos_por_Dia(idRes, numT);
				boolean c = Doctors.get(i).addRestriction(res);
				if (!c) throw new IOException("Ya existe una restriccion con esta Id");	
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
	}
	
	public void addResMAX_Turnos_Rango(int idDoc, int idRes, int d1, int m1, int a1, int d2, int m2, int a2, int numT) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		if (d1 < 1 || d1 > 31 || m1 < 1 || m1 > 12 || a1 < 1) throw new IOException("Valores de la fecha incorrecto");
		if (d2 < 1 || d2 > 31 || m2 < 1 || m2 > 12 || a2 < 1) throw new IOException("Valores de la fecha incorrecto");
		if(idDoc < numT) throw new IOException("Numero de turnos incorrecto");
		GregorianCalendar fecha1 = new GregorianCalendar(a1,m1-1,d1);
		GregorianCalendar fecha2 = new GregorianCalendar(a2,m2-1,d2);
		if (!fecha1.isLenient() || !fecha2.isLenient()) throw new IOException("Fecha invalida");
		boolean trobat = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				Restriccion res = new MAX_Turnos_Rango(idRes, d1, m1, a1, d2, m2, a2, numT);
				boolean c = Doctors.get(i).addRestriction(res);
				if (!c) throw new IOException("Ya existe una restriccion con esta Id");	
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
	}
	
	public void addResNOT_Dia_Mes(int idDoc, int idRes, int diaMes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		if (diaMes < 1 || diaMes > 31) throw new IOException("Dia del mes incorrecto");
		boolean trobat = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				Restriccion res = new NOT_Dia_Mes(idRes, diaMes);
				boolean c = Doctors.get(i).addRestriction(res);
				if (!c) throw new IOException("Ya existe una restriccion con esta Id");	
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
	}
	
	public void addResNOT_Dia_Semana(int idDoc, int idRes, String dia) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		if (!dia.equals("lunes") && !dia.equals("martes") && !dia.equals("miercoles") && !dia.equals("jueves") &&
			!dia.equals("viernes") && !dia.equals("sabado") && !dia.equals("domingo")) throw new IOException("Dia de la semana incorrecto");
		boolean trobat = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				Restriccion res = new NOT_Dia_Semana(idRes, dia);
				boolean c = Doctors.get(i).addRestriction(res);
				if (!c) throw new IOException("Ya existe una restriccion con esta Id");	
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
	}
	
	public void addResNOT_Especial(int idDoc, int idRes, String especial) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		if (!especial.equals("navidad") && !especial.equals("semana_santa") && !especial.equals("noche_vieja") &&
			!especial.equals("noche_buena")) throw new IOException("Dia especial incorrecto");
		boolean trobat = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				Restriccion res = new NOT_Especial(idRes, especial);
				boolean c = Doctors.get(i).addRestriction(res);
				if (!c) throw new IOException("Ya existe una restriccion con esta Id");	
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
	}
	
	public void addResNOT_Fecha(int idDoc, int idRes, int d, int m, int a) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		if (d < 1 || d > 31 || m < 1 || m > 12 || a < 1) throw new IOException("Valores de la fecha incorrecto");
		GregorianCalendar fecha = new GregorianCalendar(a,m-1,d);
		if (!fecha.isLenient()) throw new IOException("Fecha invalida");
		boolean trobat = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				Restriccion res = new NOT_Fecha(idRes, d, m, a);
				boolean c = Doctors.get(i).addRestriction(res);
				if (!c) throw new IOException("Ya existe una restriccion con esta Id");	
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
	}
	
	public void addResNOT_Turno(int idDoc, int idRes, String turno) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		if (!turno.equals("manana") && !turno.equals("tarde") && !turno.equals("noche")) throw new IOException("Tipo de turno incorrecto");
		boolean trobat = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				Restriccion res = new NOT_Turno(idRes, turno);
				boolean c = Doctors.get(i).addRestriction(res);
				if (!c) throw new IOException("Ya existe una restriccion con esta Id");	
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
	}
	
	public void addResXOR(int idDoc, int idRes, ArrayList<Integer> diaXOR, ArrayList<Integer> mesXOR,  ArrayList<Integer> yearXOR, ArrayList<String> tipoTurnoXOR) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		for (int i = 0; i < diaXOR.size(); ++i) {
			if (diaXOR.get(i) < 1 || diaXOR.get(i) > 31 || mesXOR.get(i) < 1 || mesXOR.get(i) > 12 ||
				yearXOR.get(i) < 1) throw new IOException("valores de la fecha incorrecto");
			if (!tipoTurnoXOR.get(i).equals("manana") && !tipoTurnoXOR.get(i).equals("tarde") && !tipoTurnoXOR.get(i).equals("noche")) throw new IOException("Tipo del turno incorrecto");
			GregorianCalendar fecha = new GregorianCalendar(diaXOR.get(i),mesXOR.get(i)-1,yearXOR.get(i));
			if (!fecha.isLenient()) throw new IOException("Fecha invalida");
		}
		boolean trobat = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Turno> listXOR = new ArrayList<Turno>();
				for (int j = 0; j < diaXOR.size(); ++j) {
					GregorianCalendar fecha = new GregorianCalendar(diaXOR.get(j),mesXOR.get(j)-1,yearXOR.get(j));
					Turno turno = new Turno(fecha, tipoTurnoXOR.get(j));
					listXOR.add(turno);
				}
				Restriccion res = new XOR(idRes, listXOR);
				boolean c = Doctors.get(i).addRestriction(res);
				if (!c) throw new IOException("Ya existe una restriccion con esta Id");	
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
		
	}
	
	public void eliminarRestriccion(int idRes, int idDoc) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				boolean c = Doctors.get(i).deleteRestriction(idRes);
				if (!c) throw new IOException("No existe una restriccion con esta Id");	
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
	}
}
