package com.jdc.ls16.ep2;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class T3SpecificStream {
	
	public static void main(String[] args) {
		// IntStream
		IntStream.range(1, 10).forEach(System.out::println);
		IntStream.rangeClosed(1, 10).forEach(System.out::println);
		
		// LongStream
		LongStream.range(1, 10).forEach(System.out::println);
		
		// DoubleStream
		DoubleStream.of(19.001, 12.201,11,111).forEach(System.out::println);
	}

}
