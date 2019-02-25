package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) {
		
		try {
			
			String thing = "";
			
			FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/thingamabob");
			int c = fr.read();
			while (c != -1) {
				thing += ((char) (c - 1));
				c = fr.read();
			}
			fr.close();
			
			JOptionPane.showMessageDialog(null, thing);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
