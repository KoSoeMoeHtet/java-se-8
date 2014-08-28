package com.jdc.ls10.ep1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class T1Creation {
	
	public static void main(String[] args) throws ParseException {
		// from constructor
		Date d1 = new Date();
		System.out.println(d1);
		
		// from constructor with long argument
		long time = d1.getTime();
		Date d2 = new Date(time);
		System.out.println(d2);
		
		// from calendar class
		Calendar cal = Calendar.getInstance();
		Date d3 = cal.getTime();
		System.out.println(d3);
		
		// from Date Format
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date d4 = df.parse("20141010");
		System.out.println(d4);	
	}

}
