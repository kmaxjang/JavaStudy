package com.lotto.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOStream {

	
	
	public boolean createFile(String filename){
		
		File file = new File(filename);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {				
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		return false;		
	}
	

	
	public static void main(String[] ages){
		

//		Path path = Paths.get("text.txt");
		FileInputStream in = null;
		File file = new File("data.dat");
		if(file.isFile()){
			
		}else{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			in = new FileInputStream(file.getAbsolutePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
