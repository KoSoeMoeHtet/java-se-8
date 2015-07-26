package com.jdc.dt.ep2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Ex3ZoneDateTime {

	public static void main(String[] args) {
		DateTimeFormatter format = DateTimeFormatter
				.ofPattern("dd MMM yyyy HH:mm");
		
		LocalDate date = LocalDate.of(2015, Month.MARCH, 15);
		LocalTime time = LocalTime.of(10, 30);
		
		LocalDateTime departure = LocalDateTime.of(date, time);
		
		ZonedDateTime yangonDeparture = ZonedDateTime
				.of(departure, ZoneId.of("Asia/Rangoon"));
		System.out.println(yangonDeparture.format(format));
		
		ZonedDateTime tokyoArraival = yangonDeparture
				.withZoneSameInstant(ZoneId.of("Asia/Tokyo")).plusHours(6);
		System.out.println(tokyoArraival.format(format));
	}
}
