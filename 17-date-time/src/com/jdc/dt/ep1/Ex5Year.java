package com.jdc.dt.ep1;

import java.time.Year;

public class Ex5Year {
	
	public static void main(String[] args) {
		Year year = Year.of(2012);
		System.out.println(year.isLeap());
	}

}
