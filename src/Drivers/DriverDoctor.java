package Drivers;
import Model.Doctor;

public class DriverDoctor {
	
	
	public static void main(String args[]) {
		Doctor doc = new Doctor();
		doc.setId(100);
		int idDoc = doc.getId();
		System.out.printf("ID Doctor %d", idDoc);
	}

	
}
