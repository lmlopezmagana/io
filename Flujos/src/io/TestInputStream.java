package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestInputStream {

	public static void main(String[] args) {
		

		InputStream input = null;
		
		try {
			input = new FileInputStream("data.out");

			int byteLeido;
			
			while ((byteLeido = input.read()) != -1) {
				System.out.println(byteLeido);
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado o problemas al abrir el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error de entrada/salida");
			e.printStackTrace();
		} finally {
			if (input != null)
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
			
			
		

	}
}
