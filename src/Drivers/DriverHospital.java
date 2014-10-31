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
		System.out.print("Ingrese el factorM: ");
		fm = teclado.nextDouble();
		System.out.print("Ingrese el factorT: ");
		ft = teclado.nextDouble();
		System.out.print("Ingrese el factorN: ");
		fn = teclado.nextDouble();
		
		
		Hospital husp = new Hospital(id,n,fm,ft,fn);
	System.out.printf("ID Hospital %d, Nom Hospital: %s\n", husp.getId(), husp.getNombre());
	System.out.printf("ID 1 %d", hosp.getId());
	}
}