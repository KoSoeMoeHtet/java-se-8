package com.jdc.io.ep1;

import java.io.File;

public class CreationSample {
	
	public static void main(String[] args) {
		// creation of file object
		File parent = new File("/Users/minlwin/temp/");
		File file1 = new File(parent, "file1.txt");
		File file2 = new File("/Users/minlwin/temp/", "file2.txt");
		
		// Show Data
		System.out.format("%s : %s%n","parent", parent.getAbsolutePath());
		System.out.format("%s : %s%n","file1", file1.getAbsolutePath());
		System.out.format("%s : %s%n","file2", file2.getAbsolutePath());
	}

}
