package com.jdc.ls11.ep1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class T4MultiCatch {
	static final String FORMAT = "yyyyMMdd";
	
	static void show(String date, String data) {
		try {
			DateFormat df = new SimpleDateFormat(FORMAT);
			Date dt = df.parse(date);
			
			System.out.println(dt);
			
			int i = Integer.parseInt(data);
			System.out.println(i);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		show("10", "aa");
	}
}
