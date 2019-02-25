package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) {
		
		String thing = JOptionPane.showInputDialog("Type: ");
		String x = "";
		for (int i = 0; i < thing.length(); i++) {
			x += (char) (thing.charAt(i) + 1);
		}
		
		try {
			
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/thingamabob");
			fw.write(x);
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
