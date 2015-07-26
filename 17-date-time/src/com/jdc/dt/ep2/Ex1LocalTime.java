package com.jdc.dt.ep2;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ex1LocalTime {
	
	public static void main(String[] args) {
		
		LocalTime time1 = LocalTime.now();
		LocalTime time2 = LocalTime.of(12, 30);
		
		LocalTime time3 = LocalDateTime.now().toLocalTime();
		
		System.out.println(time1);
		System.out.println(time2);
		System.out.println(time3);
	}

}
