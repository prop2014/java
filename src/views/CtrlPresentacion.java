package views;

import domain.*;

/*Controlador principal de la Vista */

public class CtrlPresentacion {

	/* Atributos */
	private CtrlHospital ctrlHospital;
	private VistaCjtHospitales vistaCjtHospitales;
	
	/* Constructora */
	public CtrlPresentacion(){
		ctrlHospital = new CtrlHospital();
		vistaCjtHospitales = new VistaCjtHospitales(this);
	}
	
	
	/* Metodos públicos */
	public void initPresentation() {
		vistaCjtHospitales.showView();
	}
	
}
