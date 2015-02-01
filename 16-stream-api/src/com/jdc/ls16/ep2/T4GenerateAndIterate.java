package com.jdc.ls16.ep2;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class T4GenerateAndIterate {
	
	public static void main(String[] args) {
		
		// double stream generate
		DoubleStream.generate(Math::random).limit(20)
			.forEach(System.out::println);
		
		// int stream iterate
		IntStream.iterate(0, a -> a + 1).limit(10)
			.forEach(System.out::println);
		
		// Stream iterate
		Stream.iterate("", a -> a + "a").limit(10)
			.forEach(System.out::println);
	}

}
