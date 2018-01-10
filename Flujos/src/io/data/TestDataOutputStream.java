package io.data;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataOutputStream {

	public static void main(String[] args) {

		DataOutputStream dataOutputStream = null;
		
		try {
			dataOutputStream = new DataOutputStream(new FileOutputStream("data2.out"));
			
			for(int i = -1000; i < 1000; i++)
				dataOutputStream.writeInt(i);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dataOutputStream != null)
				try {
					dataOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
	}

}
