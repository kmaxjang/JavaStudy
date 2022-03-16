package com.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {

		FileInputStream finput = null;
		FileOutputStream foutput = null;
		byte b = (byte) 0xff;
		int intager = b;
		System.out.printf("bit %h intager %d", b, intager);
		try {
			finput = new FileInputStream("src/io/FileCopy.java");
			foutput = new FileOutputStream("FileCopy.txt");

			int readlength = -1, size = 0;
			byte[] buffer = new byte[1020];
			while ((readlength = finput.read(buffer)) != -1) {
				foutput.write(buffer, 0, readlength);

				for (int i = 0; i < readlength; i++) {
					if ((i % 6) == 0)
						System.out.print("  ");
					if ((i % 30) == 0)
						System.out.println("");
					System.out.printf("%02X ", buffer[i]);
				}
				System.out.println("\nBuffer[" + readlength + "] Copy ");
				size += readlength;
			}
			System.out.println("Size[" + size + "]");
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				finput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				foutput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
