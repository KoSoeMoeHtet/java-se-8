package com.jdc.ls16.ep4;

import java.util.stream.IntStream;

public class T1ForEachOrdered {
	
	public static void main(String[] args) {
		IntStream
			.range(1, 10000)
			.parallel()
			.forEachOrdered(System.out::println);
	}

}
