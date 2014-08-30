package com.jdc.io.ep1;

import java.io.File;
import java.io.IOException;

public class T2FileMethods {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("file.txt");
		
		System.out.format("%s : %s%n","getAbsolutePath", file.getAbsolutePath());
		System.out.format("%s : %s%n","getAbsoluteFile", file.getAbsoluteFile());
		System.out.format("%s : %s%n","getName", file.getName());

		System.out.format("%s : %s%n","isAbsolute", file.isAbsolute());
		
		// create file
		System.out.format("%s : %s%n","exists:beforeCreate", file.exists());
		System.out.format("%s : %s%n","createNewFile", file.createNewFile());
		System.out.format("%s : %s%n","exists:afterCreate", file.exists());

		// delete file
		System.out.format("%s : %s%n","delete", file.delete());
		System.out.format("%s : %s%n","exists:afterDelete", file.exists());

	}

}
