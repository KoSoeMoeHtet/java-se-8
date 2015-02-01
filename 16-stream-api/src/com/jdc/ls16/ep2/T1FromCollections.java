package com.jdc.ls16.ep2;

import java.util.Arrays;
import java.util.Collection;

public class T1FromCollections {
	
	public static void main(String[] args) {
		
		// from array
		int [] array = {1,2,4,5,6,7,8};
		Arrays.stream(array).forEach(System.out::println);
		
		// from collection
		Collection<String> col = Arrays.asList("Hello", "Java", "I am a developer");
		col.stream().forEach(System.out::println);
	}

}
