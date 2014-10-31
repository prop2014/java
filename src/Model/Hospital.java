/*Autor: Oscar */

package Model;

public class Hospital {
	
	/* Atributos */

	private int idHospital;
	private String nombre;
	private double factorM;
	private double factorT;
	private double factorN;
		


	////////////////COOOOOOONSSTRUUUCTOOORAS////////////

	public Hospital() {}
	
	//creadora amb id, nombre y factores
	public Hospital (int id, String nom, double fm, double ft, double fn){
		idHospital=id;
		nombre=nom;
		factorM=fm;
		factorT=ft;
		factorN=fn;
	}
	
	//////////////COOOOONSULTORASSSSS//////////////////
	
	// consultora de la id
	public int getId(){
		return idHospital;
	}
	
	// consultora del Nombre
	public String getNombre(){
		return nombre;
	}
	
	// consultora del factorM
	public double getFactorM(){
		return factorM;
	}
	
	// consultor del factorT
	public double getFactorT(){
		return factorT;
	}
	
	// consultora del factorN
	public double getFactorN(){
		return factorN;
	}

	/* Metodos públicos */
/*	public void incicializar() {
		int n, i;
		teclado = new Scanner(System.in);
		System.out.print("Ingrese el codigo del hospital: ");
		id_hospital = teclado.nextInt();
		System.out.print("Ingrese el nombre del hospital: ");
		nombre = teclado.next();
		System.out.print("Ingrese el nombre de doctores del hospital: ");
		n = teclado.nextInt();
		doctors = new ArrayList<Doctor>(n);
		for (i = 0; i < n; ++i) {
			Doctor doctor;
	        doctor = new Doctor();
			doctor.inicializarDoctor(i);
			doctors.add(doctor);
		}
	}*/
	/////////////////MMMMMMOOOOODIIIFICADORASSSSSS/////////
	
	
	
	///////////////MMMMMMEEEETTOOOODOOOOS/////////////////
	public static void main(String[] args) {
		

	}

}