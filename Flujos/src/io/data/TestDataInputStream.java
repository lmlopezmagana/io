package io.data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataInputStream {

	public static void main(String[] args) {

		DataInputStream dataInputStream = null;
		
		try {
			dataInputStream = new DataInputStream(new FileInputStream("data2.out"));

			while(true) {
				int enteroLeido = dataInputStream.readInt();
				System.out.println(enteroLeido);
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) { 
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dataInputStream != null)
				try {
					dataInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
	}

}
