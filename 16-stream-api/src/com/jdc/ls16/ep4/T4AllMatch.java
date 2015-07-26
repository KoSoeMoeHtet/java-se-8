package com.jdc.ls16.ep4;

import com.jdc.ls16.ep3.T0Common;

public class T4AllMatch {
	
	public static void main(String[] args) {
		boolean result = T0Common.getUser()
				.stream()
				.allMatch(a -> a.getAge() > 10);
		
		System.out.println(result);
	}

}
