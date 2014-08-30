package com.jdc.ls11.ep1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class T2Throw {

	public static void main(String[] args) {
		try {
			showDate("2014-10-10");
		} catch (ParseException e) {
			System.err.println(e.getMessage()	);
		}
	}

	static void showDate(String str) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(str);
		System.out.println(date);
	}

}
