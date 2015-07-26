package com.jdc.dt.ep1;

import java.time.Month;
import java.time.MonthDay;

public class Ex4MonthDay {
	
	public static void main(String[] args) {
		MonthDay day = MonthDay.of(Month.FEBRUARY, 29);
		System.out.println(day.isValidYear(2010));
		System.out.println(day.isValidYear(2012));
	}

}
