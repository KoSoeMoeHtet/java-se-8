package com.jdc.ls6.ep1;

public class T2AftEnumerations {
	
	public enum Day {
		MON, TUE, WED, THU, FRI, SAT, SUN;
	}
	
	public static void main(String[] args) {
		// by using enum value can only assign by it's value
		Day day = Day.MON;
		
		// print it's name
		System.out.println(day);
		
	}

}
