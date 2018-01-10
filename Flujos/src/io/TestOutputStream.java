package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestOutputStream {

	public static void main(String[] args) {
		

		OutputStream output = null;
		
		try {
			output = new FileOutputStream("data.out");
			
			for(int i = 0; i< 1024; i++)
				output.write(i);
			
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado o problemas al crear el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error de entrada/salida");
			e.printStackTrace();
		} finally {
			if (output != null)
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
			
			
		
		
		

	}

}
