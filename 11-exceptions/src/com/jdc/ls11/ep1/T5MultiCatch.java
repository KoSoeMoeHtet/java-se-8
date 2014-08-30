package com.jdc.ls11.ep1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class T5MultiCatch {
	
	public static void main(String[] args) {
		try {
			PrintWriter pw = new PrintWriter(new File("data.txt"));
			Date date = new SimpleDateFormat("yyyyMMdd").parse("20141010");
			pw.println(date);
			pw.close();
		} catch (FileNotFoundException | ParseException e) {
			e.printStackTrace();
		}
	}

}
