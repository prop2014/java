package domain;
import java.io.IOException;
import java.util.*;

import model.*;

/**
 * Controladora de la clase Doctor y Restriccion
 * @author Sergi Orra 
 */
public class CtrlDoctor {
	/** Atributos */
	private ArrayList<Doctor> Doctors;
	
	
	/**
	* Constructora del control
	*/
	public CtrlDoctor(){
		Doctors = new ArrayList<Doctor>();
	}
	
	/**
	* Constructora del control con atributo
	* @param Doc: Lista de los Doctores del hospital
	*/
	public CtrlDoctor(ArrayList<Doctor> Doc){
		Doctors = Doc;
	}
	
	
	/* Metodos publicos */

/* ---------------DOCTORES ------------------- */
	
	/**
	*Consultora de todos los identificadores dels doctores
	* @return ids de los doctores
	*/
	public ArrayList<Integer> getAllDoctors() {
		ArrayList<Integer> docs = new ArrayList<Integer>();
		for (int i = 0; i < Doctors.size(); ++i) {
			docs.add(Doctors.get(i).getId());
		}
		return docs;
	}
	
	/**
	*Consultora del identificador del Doctor
	* @param idDoc: Identificador del Doctor
	* @return La id del Doctor
	* @throws Exception
	*/	
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
	
	/**
	*Consultora del nombre del Doctor
	* @param idDoc: Identificador del Doctor
	* @return El nombre del Doctor
	* @throws Exception
	*/	
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
	
	/**
	*Consultora del numero maximo de turnos del Doctor
	* @param idDoc: Identificador del Doctor
	* @return Numero maximo de turnos del Doctor
	* @throws Exception
	*/	
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
	
	/**
	*Consultora del sueldo por turno del Doctor
	* @param idDoc: Identificador del Doctor
	* @return Sueldo por turno del Doctor
	* @throws Exception
	*/	
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
	
	/** 
	* Modificadora del Doctor
	* @param idDoc: es el nuevo identificador del Doctor
	* 		 nombre: nuevo nombre del Doctor
	* 		 numMax: nuevo  numero maximo de turnos del Doctor
	* 		 sueldo: nuevo suledo por turno del doctor
	* @throws Exception
	*/
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
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
	}
	
	
	
/* --------------- RESTRICCIONES CONSULTORAS-------------------- */
	
	
	/* --------------- GETS COMUNES RESTRICCIONES -------------------- */
	
	
	/**
	* Consultora del tipo de la Restriccion
	* @param idDoc: Identificador del Doctor
	* 		 idRes: Identificador de la restriccion
	* @return El tipo de la restriccion
	* @throws Exception
	*/
	public String getTipoRestriccion(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = Doctors.get(i).getRestrictions();
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
	
	/**
	* Consultora del numero maximo de turnos que se trabaja por dia de la Restriccion MAX_Turnos_por_Dia
	* @param idDoc: Identificador del Doctor
	* 		 idRes: Identificador de la restriccion
	* @return numero maximo de turnos que se trabaja por dia
	* @throws Exception
	*/
	public Integer getMAX_Turnos_Por_Dia(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = Doctors.get(i).getRestrictions();
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
	
	/**
	* Consultora de la fecha de inicio de la Restriccion MAX_Turnos_Rango
	* @param idDoc: Identificador del Doctor
	* 		 idRes: Identificador de la restriccion
	* @return fecha inicio de la restriccion
	* @throws Exception
	*/
	public GregorianCalendar getMAX_Turnos_Rango_FeIni(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = Doctors.get(i).getRestrictions();
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
	
	/**
	* Consultora de la fecha fin de la Restriccion MAX_Turnos_Rango
	* @param idDoc: Identificador del Doctor
	* 		 idRes: Identificador de la restriccion
	* @return fecha fin de la restriccion
	* @throws Exception
	*/
	public GregorianCalendar getMAX_Turnos_Rango_FeFin(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = Doctors.get(i).getRestrictions();
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
	
	/**
	* Consultora del numero de turnos de la Restriccion MAX_Turnos_Rango
	* @param idDoc: Identificador del Doctor
	* 		 idRes: Identificador de la restriccion
	* @return numero de turnos de la restriccion
	* @throws Exception
	*/
	public Integer getMAX_Turnos_Rango_numT(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = Doctors.get(i).getRestrictions();
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
	
	/**
	* Consultora del dia del mes de la Restriccion NOT_Dia_Mes
	* @param idDoc: Identificador del Doctor
	* 		 idRes: Identificador de la restriccion
	* @return Dia del mes de la restriccion
	* @throws Exception
	*/
	public Integer getNOT_Dia_Mes(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = Doctors.get(i).getRestrictions();
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
	
	/**
	* Consultora del dia de la semana de la Restriccion NOT_Dia_Semana
	* @param idDoc: Identificador del Doctor
	* 		 idRes: Identificador de la restriccion
	* @return Dia de la semana de la restriccion
	* @throws Exception
	*/
	public String getNOT_Dia_Semana(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = Doctors.get(i).getRestrictions();
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
	
	/**
	* Consultora del dia especial de la Restriccion NOT_Especial
	* @param idDoc: Identificador del Doctor
	* 		 idRes: Identificador de la restriccion
	* @return Dia especial de la restriccion
	* @throws Exception
	*/
	public String getNOT_Especial(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = Doctors.get(i).getRestrictions();
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
	
	/**
	* Consultora de la fecha de la Restriccion NOT_Fecha
	* @param idDoc: Identificador del Doctor
	* 		 idRes: Identificador de la restriccion
	* @return Fecha de la restriccion
	* @throws Exception
	*/
	public GregorianCalendar getNOT_Fecha(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = Doctors.get(i).getRestrictions();
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
	
	/**
	* Consultora del tipo de tunro de la Restriccion NOT_Turno
	* @param idDoc: Identificador del Doctor
	* 		 idRes: Identificador de la restriccion
	* @return Tipo de turno de la restriccion
	* @throws Exception
	*/
	public String getNOT_Turno(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = Doctors.get(i).getRestrictions();
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
	
	/**
	* Consultora de la lista de fechas de la restriccion XOR
	* @param idDoc: Identificador del Doctor
	* 		 idRes: Identificador de la restriccion
	* @return Lista de fechas de la restriccion
	* @throws Exception
	*/
	public ArrayList<GregorianCalendar> getXOR_Dates(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = Doctors.get(i).getRestrictions();
				for (int j = 0; j < alres.size(); ++j) {
					if (alres.get(j).getIdRestriccion() == idRes) {
						trobat2 = true;
						XOR N = (XOR)alres.get(j);
						ArrayList<GregorianCalendar> dates = new ArrayList<GregorianCalendar>();
						ArrayList<Turno> turnos = N.getListTurnos();
						for (int z = 0; z < turnos.size(); ++z) {
							GregorianCalendar fecha = turnos.get(z).getDate();
							dates.add(fecha);
						}
						return dates;
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
	
	/**
	* Consultora de la lista de tipos de turnos de la restriccion XOR
	* @param idDoc: Identificador del Doctor
	* 		 idRes: Identificador de la restriccion
	* @return Lista de tipos de turnos de la restriccion
	* @throws Exception
	*/
	public ArrayList<String> getXOR_TipoTurno(int idDoc, int idRes) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		boolean trobat, trobat2;
		trobat = trobat2 = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = Doctors.get(i).getRestrictions();
				for (int j = 0; j < alres.size(); ++j) {
					if (alres.get(j).getIdRestriccion() == idRes) {
						trobat2 = true;
						XOR N = (XOR)alres.get(j);
						ArrayList<String> tTurno = new ArrayList<String>();
						ArrayList<Turno> turnos = N.getListTurnos();
						for (int z = 0; z < turnos.size(); ++z) {
							tTurno.add(turnos.get(z).getShiftType());
						}
						return tTurno;
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
	
	
	
/* --------------- RESTRICCIONES METODOS PUBLICOS-------------------- */
	
	/** 
	 * Metodo que inserta una restriccion tipo MAX_Turnos_por_Dia nueva en el Doctor
	 * @param idDoc: Identificador del Doctor
	 * 		  idRes: Identificador de la restriccion
	 * 		  numT: Numero de turnos	
	 * @throws Exception
	 */
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
	
	/** 
	 * Metodo que inserta una restriccion tipo MAX_Turnos_Rango nueva en el Doctor
	 * @param idDoc: Identificador del Doctor
	 * 		  idRes: Identificador de la restriccion
	 * 		  d1: Dia primera fecha
	 * 		  m1: Mes primera fecha
	 * 		  a1: Year primera fecha	
	 * 		  d2: Dia segunda fecha
	 * 		  m2: Mes segunda fecha
	 * 		  a2: Year segunda fecha
	 * 		  numT: Numero de turnos
	 * @throws Exception
	 */
	public void addResMAX_Turnos_Rango(int idDoc, int idRes, int d1, int m1, int a1, int d2, int m2, int a2, int numT) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		if (d1 < 1 || d1 > 31 || m1 < 1 || m1 > 12 || a1 < 1) throw new IOException("Valores de la fecha incorrecto");
		if (d2 < 1 || d2 > 31 || m2 < 1 || m2 > 12 || a2 < 1) throw new IOException("Valores de la fecha incorrecto");
		if(numT < 0) throw new IOException("Numero de turnos incorrecto");
		GregorianCalendar fecha1 = new GregorianCalendar(a1,m1-1,d1);
		GregorianCalendar fecha2 = new GregorianCalendar(a2,m2-1,d2);
		if (!fecha1.isLenient() || !fecha2.isLenient()) throw new IOException("Fecha invalida");
		boolean trobat = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Restriccion> alres = Doctors.get(i).getRestrictions();
				/*Comprovar si el doctor tiene una XOR con una fecha dentro del rango de la MAX que se quiere poner */
				for (int j = 0; j < alres.size(); ++j) {
					if (alres.get(j).getTipo().equals("XOR")) {
						XOR N = (XOR)alres.get(j);
						ArrayList<Turno> listXOR = N.getListTurnos();
						for (int z = 0; z < listXOR.size(); ++z) {
							
						}
					}
				}
				Restriccion res = new MAX_Turnos_Rango(idRes, d1, m1, a1, d2, m2, a2, numT);
				boolean c = Doctors.get(i).addRestriction(res);
				if (!c) throw new IOException("Ya existe una restriccion con esta Id");	
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
	}
	
	/** 
	 * Metodo que inserta una restriccion tipo NOT_Dia_Mes nueva en el Doctor
	 * @param idDoc: Identificador del Doctor
	 * 		  idRes: Identificador de la restriccion
	 * 		  diaMes: Dia del mes	
	 * @throws Exception
	 */
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
	
	/** 
	 * Metodo que inserta una restriccion tipo NOT_Dia_Semana nueva en el Doctor
	 * @param idDoc: Identificador del Doctor
	 * 		  idRes: Identificador de la restriccion
	 * 		  dia: Dia de la semana	
	 * @throws Exception
	 */
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
	
	/** 
	 * Metodo que inserta una restriccion tipo NOT_Especial nueva en el Doctor
	 * @param idDoc: Identificador del Doctor
	 * 		  idRes: Identificador de la restriccion
	 * 		  especial: Dia especial
	 * @throws Exception
	 */
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
	
	/** 
	 * Metodo que inserta una restriccion tipo NOT_Fecha nueva en el Doctor
	 * @param idDoc: Identificador del Doctor
	 * 		  idRes: Identificador de la restriccion
	 * 		  d: Dia de la fecha
	 * 		  m: Mes de la fecha
	 * 		  a: Year de la fecha	
	 * @throws Exception
	 */
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
	
	/** 
	 * Metodo que inserta una restriccion tipo NOT_Turno nueva en el Doctor
	 * @param idDoc: Identificador del Doctor
	 * 		  idRes: Identificador de la restriccion
	 * 		  turno: Tipo del turno	
	 * @throws Exception
	 */
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
	
	/** 
	 * Metodo que inserta una restriccion tipo XOR nueva en el Doctor
	 * @param idDoc: Identificador del Doctor
	 * 		  idRes: Identificador de la restriccion
	 * 		  diaXOR: Lista de los dias de las diferentes fechas de la restriccion	
	 * 		  mesXOR: Lista de los meses de las diferentes fechas de la restriccion	
	 *        yearXOR: Lista de los years de las diferentes fechas de la restriccion	
	 *        tipoTurnoXOR: Lista de los tipos de tunros de las diferentes fechas de la restriccion	
	 * @throws Exception
	 */
	public void addResXOR(int idDoc, int idRes, ArrayList<Integer> diaXOR, ArrayList<Integer> mesXOR,  ArrayList<Integer> yearXOR, ArrayList<String> tipoTurnoXOR) throws IOException {
		if(idDoc < 0 || idRes < 0) throw new IOException("Valor del identificador incorrecto");
		for (int i = 0; i < diaXOR.size(); ++i) {
			if (diaXOR.get(i) < 1 || diaXOR.get(i) > 31 || mesXOR.get(i) < 1 || mesXOR.get(i) > 12 ||
				yearXOR.get(i) < 1) throw new IOException("valores de la fecha incorrecto");
			if (!tipoTurnoXOR.get(i).equals("manana") && !tipoTurnoXOR.get(i).equals("tarde") && !tipoTurnoXOR.get(i).equals("noche")) throw new IOException("Tipo del turno incorrecto");
			GregorianCalendar fecha = new GregorianCalendar(yearXOR.get(i),mesXOR.get(i)-1,diaXOR.get(i));
			if (!fecha.isLenient()) throw new IOException("Fecha invalida");
		}
		boolean trobat = false;
		for (int i = 0; i < Doctors.size(); ++i) {
			if (Doctors.get(i).getId() == idDoc) {
				trobat = true;
				ArrayList<Turno> listXOR = new ArrayList<Turno>();
				ArrayList<Restriccion> alres = Doctors.get(i).getRestrictions();
				for (int j = 0; j < diaXOR.size(); ++j) {
					GregorianCalendar fecha = new GregorianCalendar(yearXOR.get(j),mesXOR.get(j)-1,diaXOR.get(j));
					Turno turno = new Turno(fecha, tipoTurnoXOR.get(j));
					listXOR.add(turno);
				}
				/* Comprovar si hay alguna otra XOR o MAX_Turnos_Rango en algun mismo turno de la XOR que se quiere poner */
				for (int z = 0; z < alres.size(); ++z) {
					if (alres.get(z).getTipo().equals("XOR")) {
						XOR N = (XOR)alres.get(z);
						ArrayList<Turno> listXOR2 = N.getListTurnos();
						for (int j = 0; j < listXOR.size(); ++j) {
							for (int k = 0; k < listXOR2.size(); ++k) {
								if (listXOR.get(j) == listXOR2.get(k)) throw new IOException("Este doctor ya tiene una restriccion XOR apuntando a algun turno de la que quieres poner");
							}
						}
					}
					if (alres.get(z).getTipo().equals("MAX_Turnos_Rango")) {
						MAX_Turnos_Rango N = (MAX_Turnos_Rango)alres.get(z);
						int firstDay = N.getFechaIni().get(GregorianCalendar.DAY_OF_YEAR);
						int lastDay = N.getFechaFin().get(GregorianCalendar.DAY_OF_YEAR);
						for (int j = 0; j < listXOR.size(); ++j) {
							GregorianCalendar t = listXOR.get(j).getDate();
							int diaXor = t.get(GregorianCalendar.DAY_OF_YEAR);
							if (diaXor <= lastDay && diaXor >= firstDay) throw new IOException("Este Doctor ya tiene una restriccion MAX_Turnos_Rango con una fecha de la XOR"); 
						}
					}
				}
				Restriccion res = new XOR(idRes, listXOR);
				boolean c = Doctors.get(i).addRestriction(res);
				if (!c) throw new IOException("Ya existe una restriccion con esta Id");	
			}
			if (trobat) break;
		}
		if (!trobat) throw new IOException("No existe un Doctor con esta Id");
		
	}
	
	/** 
	 * Metodo que elimina una restriccion del Doctor
	 * @param idRes: Identificador de la restriccion
	 * 		  idDoc: Identificador del Doctor
	 * @throws Exception
	 */
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
