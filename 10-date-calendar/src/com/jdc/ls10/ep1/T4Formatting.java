package com.jdc.ls10.ep1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class T4Formatting {

	public static void main(String[] args) {
		DateFormat df1 = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
		DateFormat df2 = new SimpleDateFormat("EEE, MMM d, ''yy");
		DateFormat df3 = new SimpleDateFormat("h:mm a");
		DateFormat df4 = new SimpleDateFormat("hh 'o''clock' a, zzzz");
		DateFormat df5 = new SimpleDateFormat("K:mm a, z");
		DateFormat df6 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
		DateFormat df7 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		DateFormat df8 = new SimpleDateFormat("yyMMddHHmmssZ");
		DateFormat df9 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		DateFormat df10 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		DateFormat df11 = new SimpleDateFormat("YYYY-'W'ww-u");
		
		Date date = new Date();
		
		System.out.println(df1.format(date));
		System.out.println(df2.format(date));
		System.out.println(df3.format(date));
		System.out.println(df4.format(date));
		System.out.println(df5.format(date));
		System.out.println(df6.format(date));
		System.out.println(df7.format(date));
		System.out.println(df8.format(date));
		System.out.println(df9.format(date));
		System.out.println(df10.format(date));
		System.out.println(df11.format(date));
	}
}
