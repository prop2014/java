package Drivers;
import Model.Doctor;

public class DriverDoctor {
	
	
	public static void main(String args[]) {
		Doctor doc = new Doctor();
		doc.setid(100);
		int idDoc = doc.getid();
		System.out.printf("ID Doctor %d", idDoc);
	}

	
}
