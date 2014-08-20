package com.jdc.dt.ep4;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Set;

public class TimeZoneSample {

	public static void main(String[] args) {
		ZoneId losAngeles = ZoneId.of("America/Los_Angeles");
		ZoneId berlin = ZoneId.of("Europe/Berlin");
		 
		// 2014-02-20 12:00
		LocalDateTime dateTime = LocalDateTime.of(2014, 02, 20, 12, 0);
		System.out.format("%s : %s%n", "dateTime", dateTime);
		 
		// 2014-02-20 12:00, Europe/Berlin (+01:00)
		ZonedDateTime berlinDateTime = ZonedDateTime.of(dateTime, berlin);
		System.out.format("%s : %s%n", "berlinDateTime", berlinDateTime);
		 
		// 2014-02-20 03:00, America/Los_Angeles (-08:00)
		ZonedDateTime losAngelesDateTime = berlinDateTime.withZoneSameInstant(losAngeles);
		System.out.format("%s : %s%n", "losAngelesDateTime", losAngelesDateTime);
		 
		int offsetInSeconds = losAngelesDateTime.getOffset().getTotalSeconds(); // -28800
		System.out.format("%s : %s%n", "offsetInSeconds", offsetInSeconds);
		 
		// a collection of all available zones
		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		System.out.format("%s : %s%n", "allZoneIds", allZoneIds);
		 
		// using offsets
		LocalDateTime date = LocalDateTime.of(2013, Month.JULY, 20, 3, 30);
		ZoneOffset offset = ZoneOffset.of("+05:00");
		System.out.format("%s : %s%n", "offset", offset);
		 
		// 2013-07-20 03:30 +05:00
		OffsetDateTime plusFive = OffsetDateTime.of(date, offset);
		System.out.format("%s : %s%n", "plusFive", plusFive);
		 
		// 2013-07-19 20:30 -02:00
		OffsetDateTime minusTwo = plusFive.withOffsetSameInstant(ZoneOffset.ofHours(-2));
		System.out.format("%s : %s%n", "minusTwo", minusTwo);
	}
}
