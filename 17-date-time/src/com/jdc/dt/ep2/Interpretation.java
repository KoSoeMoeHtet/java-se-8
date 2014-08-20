package com.jdc.dt.ep2;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Interpretation {

	
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.format("%s : %d%n", "DayOfMonth", now.getDayOfMonth());
		System.out.format("%s : %s%n", "DayOfWeek", now.getDayOfWeek());
		System.out.format("%s : %d%n", "DayOfYear", now.getDayOfYear());
		System.out.format("%s : %d%n", "Hour", now.getHour());
		System.out.format("%s : %d%n", "Minute", now.getMinute());
		System.out.format("%s : %s%n", "Month", now.getMonth());
		System.out.format("%s : %d%n", "MonthValue", now.getMonthValue());
		System.out.format("%s : %d%n", "Nano", now.getNano());
		System.out.format("%s : %d%n", "Second", now.getSecond());
		System.out.format("%s : %d%n", "Year", now.getYear());
		
		System.out.format("%s : %s%n", "isAfter", LocalDate.now().isAfter(LocalDate.of(2014, 10, 19)));
		System.out.format("%s : %s%n", "isBefore", LocalDate.now().isBefore(LocalDate.of(2014, 10, 19)));
		System.out.format("%s : %s%n", "isLeapYear", LocalDate.now().isLeapYear());
	}
}
