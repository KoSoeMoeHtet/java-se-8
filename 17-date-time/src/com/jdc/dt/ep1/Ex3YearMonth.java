package com.jdc.dt.ep1;

import java.time.Month;
import java.time.YearMonth;

public class Ex3YearMonth {
	
	public static void main(String[] args) {
		YearMonth ym1 = YearMonth.of(2010, Month.FEBRUARY);
		YearMonth ym2 = YearMonth.of(2012, Month.FEBRUARY);
		
		System.out.format("%s : %d%n", ym1, ym1.lengthOfMonth());
		System.out.format("%s : %d%n", ym2, ym2.lengthOfMonth());
	}

}
