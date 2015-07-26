package com.jdc.dt.ep3;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class ChangingValue {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		
		System.out.format("%s : %s%n", "withDayOfMonth", now.withDayOfMonth(10));
		System.out.format("%s : %s%n", "withMonth", now.withMonth(12));
		System.out.format("%s : %s%n", "withYear", now.withYear(2012));
		
		System.out.format("%s : %s%n", "plusDays", now.plusDays(20));
		System.out.format("%s : %s%n", "plusWeeks", now.plusWeeks(10));
		System.out.format("%s : %s%n", "ChronoUnit", now.plus(1, ChronoUnit.CENTURIES));
		
		System.out.format("%s : %s%n", "minusYears", now.minusYears(20));
		System.out.format("%s : %s%n", "minusMonths", now.minusMonths(13));
		
		System.out.format("%s : %s%n", "firstDayOfNextMonth", now.with(TemporalAdjusters.firstDayOfNextMonth()));
		System.out.format("%s : %s%n", "lastDayOfMonth", now.with(TemporalAdjusters.lastDayOfMonth()));
		
		System.out.format("%s : %s%n", "Truncate To", now.truncatedTo(ChronoUnit.MINUTES));
		
	}
}
