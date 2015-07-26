package com.jdc.dt.ep1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Ex2LocalDate {
	
	public static void main(String[] args) {
		
		LocalDate memorialDay = LocalDate.of(1988, Month.AUGUST, 8);
		System.out.println(LocalDate.now());
		System.out.println(memorialDay);
		
		LocalDate nextWed = memorialDay.with(
				TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
		
		System.out.println(memorialDay.plus(10, ChronoUnit.YEARS));
		System.out.println(nextWed);
	}

}
