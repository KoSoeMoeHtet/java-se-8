package com.jdc.dt.ep2;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class Ex5ZoneId {

	public static void main(String[] args) {
		String format = "%40s :%8s";

		ZoneId.getAvailableZoneIds().stream()
			.map(a -> ZoneId.of(a))
			.sorted((a,b) -> {
				 ZoneOffset zoa = ZonedDateTime.now(a).getOffset();
				 ZoneOffset zob = ZonedDateTime.now(b).getOffset();
				 return zoa.compareTo(zob);
			})
			.map(a -> String.format(format, a.getId(), ZonedDateTime.now(a).getOffset()))
			.forEach(System.out::println);
	}
}
