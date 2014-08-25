package com.jdc.ls8.ep1;

import java.util.Calendar;

public class T3Formatting {
	public static void main(String[] args) {
		long data = 756659;
		
		System.out.format("%d%n", data);		// "756659"
		System.out.format("%08d%n", data);	// "00756659"
		System.out.format("%+08d%n", data);	// "+0756659"
		System.out.format("%,08d%n", data);	// "0756,659"
		System.out.format("%+,08d%n", data);	// "+756,659"
		
		double pi = Math.PI;
		
		System.out.format("%f%n", pi);		// "3.141593"
		System.out.format("%.3f%n", pi);		// "3.142"
		System.out.format("%10.3f%n", pi);	// "     3.142"
		System.out.format("%-10.3f%n", pi);	// "3.142     "
		
		Calendar c = Calendar.getInstance();
		
		System.out.format("%tB %te, %tY%n", c,c,c);	// "March 12, 2014"
		System.out.format("%tD%n", c);			// "03/12/14"
	}
}
