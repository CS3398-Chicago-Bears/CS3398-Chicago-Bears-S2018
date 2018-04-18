package com.cs3398.sportsapp.Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Backup file for writing object data into a file

public class WriteFile {
	// Write object data into a file
	public static void serializeDataOut(User userData)throws IOException{
		// initializing output streams to null value
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {
			String fileName = "Database.txt";
			fout = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(userData);
			System.out.println("Done");

		} catch(Exception ex) {
			ex.printStackTrace();
		  }

		oos.close();
	}

	// Read object data from a file
	public static User serializeDataIn() throws IOException, ClassNotFoundException {
		// initializing input streams to null value
		FileInputStream fin = null;
		ObjectInputStream ois = null;

		String fileName = "Database.txt";
		fin = new FileInputStream(fileName);
		ois = new ObjectInputStream(fin);
		User user = (User) ois.readObject();
		System.out.println("Done");
		ois.close();
		return user;
	}
}
