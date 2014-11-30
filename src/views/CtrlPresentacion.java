package views;

import java.util.ArrayList;

import domain.*;

/*Controlador principal de la Vista */

public class CtrlPresentacion {

	/* Atributos */
	private CtrlHospital ctrlHospital;
	private VistaCjtHospitales vistaCjtHospitales;
	private VistaGestion vistaGestion;
	
	/* Constructora */
	public CtrlPresentacion(){
		ctrlHospital = new CtrlHospital();
		vistaCjtHospitales = new VistaCjtHospitales(this);
		vistaGestion = new VistaGestion();
		
	}
	
	
	/* Metodos publicos */
	public void initPresentation() {
		vistaCjtHospitales.showView();
	}
	
	public void changeViewGestion() {
		vistaCjtHospitales.hideView();
		vistaGestion.showView();
	}
	
	/* Metodos de VistaCjtCalendario */
	public ArrayList<String> loadHospitals() {
		// return ctrlHospital.getHospitals();
		//
		ArrayList<String> hospitales = new ArrayList<String>();
		return hospitales;
	}
	
}
