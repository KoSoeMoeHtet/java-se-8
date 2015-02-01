package com.jdc.ls16.ep3;

public class T3FlatMap {

	public static void main(String[] args) {
		// flat mapping list stream
		T0Common.listStream()
				.flatMap(l -> l.stream().map(a -> a.getName()))
				.sorted()
				.forEach(System.out::println);
	}
}
