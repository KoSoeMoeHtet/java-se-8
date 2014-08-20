package com.jdc.io.ep1;

import java.io.File;
import java.io.IOException;

public class DirectorySample {
	
	public static void main(String[] args) throws IOException {

		File file = new File("data");
		
		System.out.format("%s : %s%n", "mkdir", file.mkdir());
		System.out.format("%s : %s%n", "exits", file.exists());
		System.out.format("%s : %s%n", "isDirectory", file.isDirectory());
		
		File file2 = new File(file, "data.txt");
		file2.createNewFile();
		
		File files [] = file.listFiles();
		
		for(File f : files) {
			System.out.format("%s : %s%n", "fileName", f.getAbsoluteFile());
			f.delete();
		}
		
		System.out.format("%s : %s%n", "delete directory", file.delete());
	}

}
