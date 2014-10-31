package Drivers;
import java.util.Scanner;
import Model.Hospital;

public class DriverHospital {

	
	public static void main(String[] args) {
		Scanner teclado;
		Hospital hosp = new Hospital();
		int id;
		String n;
		double fm;
		double ft;
		double fn;
		
		
		teclado = new Scanner(System.in);
		System.out.print("Ingrese el codigo del hospital: ");
		id = teclado.nextInt();
		System.out.print("Ingrese el nombre del hospital: ");
		n = teclado.next();
		System.out.print("Ingrese el factorMañana: ");
		fm = teclado.nextDouble();
		System.out.print("Ingrese el factorTarde: ");
		ft = teclado.nextDouble();
		System.out.print("Ingrese el factorNoche: ");
		fn = teclado.nextDouble();
		
		
		Hospital husp = new Hospital(id,n,fm,ft,fn);
	System.out.printf("ID Hospital %d, Nom Hospital: %s\n", husp.getId(), husp.getNombre());
	System.out.printf("ID %d", hosp.getId());
	}
}