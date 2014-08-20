package com.jdc.dt.ep1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

public class Creation {
	
	public static void main(String[] args) {
		// local date time
		System.out.format("%s : %s%n", "Local DateTime", LocalDateTime.now());

		// local date
		System.out.format("%s : %s%n", "Local Date", LocalDate.now());
		
		// local time
		System.out.format("%s : %s%n", "Local Time", LocalTime.now());

		// time with specific zone
		System.out.format("%s : %s%n", "Zone Time", LocalDateTime.now(ZoneId.of("Asia/Tokyo")));
		
		// local date of 
		System.out.format("%s : %s%n", "Date of", LocalDate.of(2013, 10, 12));
		System.out.format("%s : %s%n", "Date of", LocalDate.of(2013, Month.APRIL, 12));
		System.out.format("%s : %s%n", "Year of day ", LocalDate.ofYearDay(2013, 150));
		System.out.format("%s : %s%n", "Parse Date", LocalDate.parse("2014-10-11"));
		
		
		// local time of
		System.out.format("%s : %s%n", "Time of", LocalTime.of(17, 10, 12));
		System.out.format("%s : %s%n", "Parse Time", LocalTime.parse("15:30:00"));
		
		// local date time of
		System.out.format("%s : %s%n", "Date Time of", LocalDateTime.of(LocalDate.now(), LocalTime.now()));

	}

}
