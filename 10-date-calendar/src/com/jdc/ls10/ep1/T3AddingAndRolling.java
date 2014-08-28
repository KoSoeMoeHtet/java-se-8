package com.jdc.ls10.ep1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class T3AddingAndRolling {

	public static void main(String[] args) throws ParseException {
		Date d = new SimpleDateFormat("yyyyMMdd").parse("20130410");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(d);
		c2.setTime(d);

		c1.add(Calendar.DAY_OF_MONTH, -15);
		c2.roll(Calendar.DAY_OF_MONTH, -15);

		System.out.println(c1.getTime());
		System.out.println(c2.getTime());
	}
}
