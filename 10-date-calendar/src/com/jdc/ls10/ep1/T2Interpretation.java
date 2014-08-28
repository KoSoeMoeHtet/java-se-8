package com.jdc.ls10.ep1;

import java.util.Calendar;

public class T2Interpretation {

	public static void main(String[] args) {
		// although date has it's own interpretation methods
		// it shouldn't use as localization
		// you should use calendar interpretation methods
		Calendar c = Calendar.getInstance();
		// before setting
		doGet(c);

		// setting
		c.set(Calendar.YEAR, 2010);
		c.set(Calendar.MONTH, 12);
		c.set(Calendar.DAY_OF_MONTH, 15);

		// after setting
		doGet(c);
	}
	
	public static void doGet(Calendar c) {
		// get
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH));
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.HOUR_OF_DAY));
		
		System.out.println(c.getTimeInMillis());
		System.out.println(c.getTime());
	}
}
