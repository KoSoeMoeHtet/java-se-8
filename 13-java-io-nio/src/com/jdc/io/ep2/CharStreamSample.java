package com.jdc.io.ep2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamSample {
	
	public static void main(String[] args) {
		try(FileReader fr = new FileReader("in.txt");
				FileWriter fw = new FileWriter("out.txt")) {
			int c;
			
			while((c = fr.read()) != -1) {
				fw.write(c);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
