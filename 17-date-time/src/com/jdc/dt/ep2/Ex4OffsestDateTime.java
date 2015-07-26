package com.jdc.dt.ep2;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjusters;

public class Ex4OffsestDateTime {

	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.of(2015, Month.MARCH, 20, 10, 30);
		
		OffsetDateTime tronto = OffsetDateTime
				.of(date, ZoneOffset.of("-04:00"));
		OffsetDateTime lastMonday = tronto
				.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));
		
		System.out.format("Last Monday of March is %s%n",lastMonday.getDayOfMonth());
	}
}
