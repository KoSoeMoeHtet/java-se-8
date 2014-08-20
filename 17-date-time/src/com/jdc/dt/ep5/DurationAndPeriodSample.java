package com.jdc.dt.ep5;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

public class DurationAndPeriodSample {
	
	public static void main(String[] args) {
		// periods
		 
		LocalDate firstDate = LocalDate.of(2010, 5, 17); // 2010-05-17
		LocalDate secondDate = LocalDate.of(2015, 3, 7); // 2015-03-07
		Period period = Period.between(firstDate, secondDate);
		 
		int days = period.getDays(); // 18
		int months = period.getMonths(); // 9
		int years = period.getYears(); // 4
		boolean isNegative = period.isNegative(); // false
		System.out.format("%s : %s%n", "days", days);
		System.out.format("%s : %s%n", "months", months);
		System.out.format("%s : %s%n", "years", years);
		System.out.format("%s : %s%n", "isNegative", isNegative);
		 
		Period twoMonthsAndFiveDays = Period.ofMonths(2).plusDays(5);
		LocalDate sixthOfJanuary = LocalDate.of(2014, 1, 6);
		System.out.format("%s : %s%n", "twoMonthsAndFiveDays", twoMonthsAndFiveDays);
		System.out.format("%s : %s%n", "sixthOfJanuary", sixthOfJanuary);
		 
		// add two months and five days to 2014-01-06, result is 2014-03-11
		LocalDate eleventhOfMarch = sixthOfJanuary.plus(twoMonthsAndFiveDays);
		System.out.format("%s : %s%n", "eleventhOfMarch", eleventhOfMarch);
		 
		 
		// durations
		 
		Instant firstInstant= Instant.ofEpochSecond( 1294881180 ); // 2011-01-13 01:13
		Instant secondInstant = Instant.ofEpochSecond(1294708260); // 2011-01-11 01:11
		System.out.format("%s : %s%n", "firstInstant", firstInstant);
		System.out.format("%s : %s%n", "secondInstant", secondInstant);
		 
		Duration between = Duration.between(firstInstant, secondInstant);
		System.out.format("%s : %s%n", "between", between);
		 
		// negative because firstInstant is after secondInstant (-172920)
		long seconds = between.getSeconds();
		System.out.format("%s : %d%n", "seconds", seconds);
		 
		// get absolute result in minutes (2882)
		long absoluteResult = between.abs().toMinutes();
		System.out.format("%s : %d%n", "absoluteResult", absoluteResult);
		 
		// two hours in seconds (7200)
		long twoHoursInSeconds = Duration.ofHours(2).getSeconds();
		System.out.format("%s : %d%n", "twoHoursInSeconds", twoHoursInSeconds);
	}

}
