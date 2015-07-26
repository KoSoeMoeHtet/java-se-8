package com.jdc.ls16.ep3;

import java.util.stream.IntStream;

public class T4Distinct {

	public static void main(String[] args) {
		IntStream
			.of(1,2,3,4,5,6,4,3,2,5,6,7,8,9,4,4,3,2,1)
			.distinct()
			.sorted()
			.skip(3)
			.limit(5)
			.forEach(System.out::println);
	}
}
