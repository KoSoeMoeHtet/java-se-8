package com.jdc.ls6.ep1;

public class T1BefEnumerations {
	
	public static interface Day {
		public static int MON = 1, TUE = 2, WED = 3, THU = 4, FRI = 5, SAT = 6, SUN = 7;
	}
	
	public static void main(String[] args) {
		int day = Day.MON;
		
		// value can assign by other values
		day = 10;
		
		// prints it's value not name
		System.out.println(day);
	}

}
