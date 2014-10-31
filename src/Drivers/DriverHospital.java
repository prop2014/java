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
	
		System.out.print("cambiali el nom: ");
		n = teclado.next();
		husp.setNombre(n);
		System.out.printf("ID Hospital %d, Nom Hospital: %s\n FM: %f, FT: %f, FN: %f\n", husp.getId(), husp.getNombre(), husp.getFactorM(),
			husp.getFactorT(), husp.getFactorN());
		System.out.print("cambiale factorMañana: ");
		fm = teclado.nextDouble();
		husp.setFactorM(fm);
		System.out.print("Ingrese el factorTarde: ");
		ft = teclado.nextDouble();
		husp.setFactorT(ft);
		System.out.print("Ingrese el factorNoche: ");
		fn = teclado.nextDouble();
		husp.setFactorN(fn);
		
		System.out.printf("ID Hospital %d, Nom Hospital: %s\n FM: %f, FT: %f, FN: %f\n", husp.getId(), husp.getNombre(), husp.getFactorM(),
				husp.getFactorT(), husp.getFactorN());
	}
}