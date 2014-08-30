package com.jdc.io.ep2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class T1ByteStreamSample {

	public static void main(String[] args) {
		// bite stream
		try (FileInputStream fi = new FileInputStream("in.txt");
				FileOutputStream fo = new FileOutputStream("out.txt")) {

			int b;
			
			while((b=fi.read()) != -1) {
				fo.write(b);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
