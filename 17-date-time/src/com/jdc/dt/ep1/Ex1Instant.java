package com.jdc.dt.ep1;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Ex1Instant {
	
	public static void main(String[] args) {
		
		Instant timeStamp = Instant.now();
		Instant oneHourLater = timeStamp.plus(1, ChronoUnit.HOURS);
				
		System.out.println(timeStamp);
		System.out.println(oneHourLater);
				
		LocalDateTime ldt = LocalDateTime.ofInstant(timeStamp,
		ZoneId.systemDefault());
		System.out.println(ldt);
		
	}

}
