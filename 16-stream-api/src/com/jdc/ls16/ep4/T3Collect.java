package com.jdc.ls16.ep4;

import java.util.List;
import java.util.stream.Collectors;

import com.jdc.ls16.ep3.T0Common;

public class T3Collect {
	
	public static void main(String[] args) {
		List<String> names = T0Common.getUser()
								.stream()
								.map(a -> a.getName())
								.collect(Collectors.toList());
		
		System.out.println(names);
	}

}
