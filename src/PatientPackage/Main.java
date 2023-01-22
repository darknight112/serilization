package PatientPackage;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sr = new Scanner(System.in);
		Patient a = new Patient();
		System.out.println("Enter 1 to create new patient / 2 to read the previous file  ");
		int input = sr.nextInt();
		if (input == 1) {
			System.out.println("Enter the Patient name ");
			String name = sr.next();
			a.setName(name);
			System.out.println("Enter the Patient id ");
			int id = sr.nextInt();
			a.setId(id);
			System.out.println("Enter the Patient age ");
			int age = sr.nextInt();
			a.setAge(age);

			try {
				FileOutputStream file = new FileOutputStream("patient.txt");
				ObjectOutputStream out = new ObjectOutputStream(file);
				out.writeObject(a);
				out.close();
				file.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Patient read = null;

			// Deserialization
			try {
				// Reading the object from a file
				FileInputStream file = new FileInputStream("patient.txt");
				ObjectInputStream in = new ObjectInputStream(file);

				// Method for deserialization of object
				read = (Patient) in.readObject();

				in.close();
				file.close();

				System.out.println("Object has been deserialized ");
				System.out.println("Patient name = " + read.getName());
				System.out.println("Patient ID = " + read.getId());
			}

			catch (IOException ex) {
				System.out.println("IOException is caught");
			}
			 catch(ClassNotFoundException ex)
	        {
	            System.out.println("ClassNotFoundException is caught");
	        }
		}
		
	}

}
