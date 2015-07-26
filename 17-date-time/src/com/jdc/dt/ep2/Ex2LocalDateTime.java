package com.jdc.dt.ep2;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

public class Ex2LocalDateTime {

	public static void main(String[] args) {
		LocalDateTime day1 = LocalDateTime.now();
		LocalDateTime day2 = LocalDateTime.of(LocalDate.of(2015, Month.JANUARY, 28), LocalTime.MIDNIGHT);
		LocalDateTime day3 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDateTime day4 = LocalDateTime.of(2010, 2, 20, 18, 30);
		
		System.out.println(day1);
		System.out.println(day2);
		System.out.println(day3);
		System.out.println(day4);
	}
}
