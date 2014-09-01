package com.jdc.ls16.ep3;


public class T1Map {

	public static void main(String[] args) {
		// mapping User to String
		T0Common.getUser().stream().map(a -> a.getName()).forEach(System.out::println);
		
		// mapping User to int
		int sum = T0Common.getUser().stream().mapToInt(a -> a.getAge()).sum();
		System.out.println(sum);
	}
}
