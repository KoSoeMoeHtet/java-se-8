package com.jdc.ls16.ep1;

import java.util.Arrays;
import java.util.Collection;

public class T1FromCollections {
	
	public static void main(String[] args) {
		Collection<String> col = Arrays.asList("Hello", "Java", "I am a developer");
		col.stream().forEach(System.out::println);
	}

}
