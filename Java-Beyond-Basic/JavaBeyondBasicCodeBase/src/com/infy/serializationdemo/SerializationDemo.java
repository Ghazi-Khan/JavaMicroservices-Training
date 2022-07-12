package com.infy.serializationdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	int rollNumber;
	String name;

	public Student(int rollNumber, String name) {
		this.rollNumber = rollNumber;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Roll Number: " + rollNumber + "\nName: "+ name;
	}
}

public class SerializationDemo {
	public static void main(String[] args) throws Exception {
		System.out.println("Serialization & Deerialization Example");
		System.out.println("----------------------------------------");

		Student student1 = new Student(101, "Ghazi");
		System.out.println("\nStudent details : (Before Serialization) \n" + student1);

		// Serialization
		File file = new File("Student.txt");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

		// writing student object to Student.txt file
		objectOutputStream.writeObject(student1);
		objectOutputStream.close();

		// Deserialization
		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

		Student student2 = (Student) inputStream.readObject();
		inputStream.close();
		System.out.println("\nStudent details : (After Deserialization) \n" + student2);

	}

}
