package com.jdc.dt.ep6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class FormartAndParseSample {
	
	public static void main(String[] args) {
		// 2014-04-01 10:45
		LocalDateTime dateTime = LocalDateTime.of(2014, Month.APRIL, 1, 10, 45);
		System.out.format("%s : %s%n", "dateTime", dateTime);
		 
		// format as basic ISO date format (20140220)
		String asBasicIsoDate = dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
		System.out.format("%s : %s%n", "asBasicIsoDate", asBasicIsoDate);
		 
		// format as ISO week date (2014-W08-4)
		String asIsoWeekDate = dateTime.format(DateTimeFormatter.ISO_WEEK_DATE);
		System.out.format("%s : %s%n", "asIsoWeekDate", asIsoWeekDate);
		 
		// format ISO date time (2014-02-20T20:04:05.867)
		String asIsoDateTime = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
		System.out.format("%s : %s%n", "asIsoDateTime", asIsoDateTime);
		 
		// using a custom pattern (01/04/2014)
		String asCustomPattern = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.format("%s : %s%n", "asCustomPattern", asCustomPattern);
		 
		// french date formatting (1. avril 2014)
		String frenchDate = dateTime.format(DateTimeFormatter.ofPattern("d. MMMM yyyy", new Locale("fr")));
		System.out.format("%s : %s%n", "frenchDate", frenchDate);
		 
		// using short german date/time formatting (01.04.14 10:45)
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
		    .withLocale(new Locale("de"));
		String germanDateTime = dateTime.format(formatter);
		System.out.format("%s : %s%n", "germanDateTime", germanDateTime);
		 
		// parsing date strings
		LocalDate fromIsoDate = LocalDate.parse("2014-01-20");
		LocalDate fromIsoWeekDate = LocalDate.parse("2014-W14-2", DateTimeFormatter.ISO_WEEK_DATE);
		LocalDate fromCustomPattern = LocalDate.parse("20.01.2014", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		System.out.format("%s : %s%n", "fromIsoDate", fromIsoDate);
		System.out.format("%s : %s%n", "fromIsoWeekDate", fromIsoWeekDate);
		System.out.format("%s : %s%n", "fromCustomPattern", fromCustomPattern);
	}

}
