package com.jdc.ls11.ep1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class T1TryCatch {
	
	public static void main(String[] args) {
		showDate("2014-10-10");
	}
	
	
	static void showDate(String str) {
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(str);
			System.out.println(date);
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
	}

}
