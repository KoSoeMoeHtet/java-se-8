package com.jdc.dt.ep4;

import java.time.Instant;

public class TimeStampSample {
	
	public static void main(String[] args) {
		// current time
		Instant now = Instant.now();
		 
		// from unix timestamp, 2010-01-01 12:00:00
		Instant fromUnixTimestamp = Instant.ofEpochSecond(1262347200);
		System.out.format("%s : %s%n", "fromUnixTimestamp", fromUnixTimestamp);
		 
		// same time in millis
		Instant fromEpochMilli = Instant.ofEpochMilli(1262347200000l);
		System.out.format("%s : %s%n", "fromEpochMilli", fromEpochMilli);
		 
		// parsing from ISO 8601
		Instant fromIso8601 = Instant.parse("2010-01-01T12:00:00Z");
		System.out.format("%s : %s%n", "fromIso8601", fromIso8601);
		 
		// toString() returns ISO 8601 format, e.g. 2014-02-15T01:02:03Z
		String toIso8601 = now.toString();
		System.out.format("%s : %s%n", "toIso8601", toIso8601);
		 
		// as unix timestamp
		long toUnixTimestamp = now.getEpochSecond();
		System.out.format("%s : %d%n", "toUnixTimestamp", toUnixTimestamp);
		 
		// in millis
		long toEpochMillis = now.toEpochMilli();
		System.out.format("%s : %d%n", "toEpochMillis", toEpochMillis);
		 
		// plus/minus methods are available too
		Instant nowPlusTenSeconds = now.plusSeconds(10);
		System.out.format("%s : %s%n", "nowPlusTenSeconds", nowPlusTenSeconds);
	}

}
