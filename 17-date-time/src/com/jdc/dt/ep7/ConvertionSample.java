package com.jdc.dt.ep7;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ConvertionSample {

	public static void main(String[] args) {
		// LocalDate/LocalTime <-> LocalDateTime
		LocalDateTime now = LocalDateTime.now();
		System.out.format("%s : %s%n", "toLocalDate", now.toLocalDate());
		System.out.format("%s : %s%n", "toLocalTime", now.toLocalTime());
		System.out.format("%s : %s%n", "toInstant", now.atZone(ZoneId.systemDefault()).toInstant());
		System.out.format("%s : %s%n", "toInstant", LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

		// Instant <-> LocalDateTime
		Instant instant = Instant.now();
		System.out.format("%s : %s%n", "ofInstant", LocalDateTime.ofInstant(instant, ZoneId.of("America/Los_Angeles")));
		System.out.format("%s : %s%n", "toInstant", now.toInstant(ZoneOffset.ofHours(-2)));
		 
		// convert old date/calendar/timezone classes
		System.out.format("%s : %s%n", "Date -> Instant", new Date().toInstant());
		System.out.format("%s : %s%n", "Calendar -> Instant", Calendar.getInstance().toInstant());
		System.out.format("%s : %s%n", "TimeZone -> ZoneId", TimeZone.getDefault().toZoneId());
		System.out.format("%s : %s%n", "GregorianCalendar -> ZonedDateTime", new GregorianCalendar().toZonedDateTime());
		 
		// convert to old classes
		System.out.format("%s : %s%n", "Instant -> Date", Date.from(Instant.now()));
		System.out.format("%s : %s%n", "ZoneId -> TimeZone", TimeZone.getTimeZone(ZoneId.of("America/Los_Angeles")));
		System.out.format("%s : %s%n", "ZonedDateTime -> GregorianCalendar", GregorianCalendar.from(ZonedDateTime.now()));
	}
}
