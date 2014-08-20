package com.jdc.io.ep2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferedStreamSample {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("in.txt"));
				PrintWriter pw = new PrintWriter(new File("out.txt"))) {
			String line;
			
			while((line = br.readLine()) != null) {
				pw.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
