package com.jdc.ls11.ep1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class T3TryCatchFinally {
	
	static final String FORMAT = "yyyyMMdd";
	
	static void show(String date) {
		try {
			DateFormat df = new SimpleDateFormat(FORMAT);
			Date dt = df.parse(date);
			
			System.out.println(dt);
			
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Final Message");
		}
	}
	
	public static void main(String[] args) {
		show("10");
	}

}
