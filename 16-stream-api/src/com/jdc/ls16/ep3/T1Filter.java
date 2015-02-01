package com.jdc.ls16.ep3;


public class T1Filter {

	public static void main(String[] args) {
		T0Common.getUser().stream().filter(a -> a.getAge() > 20)
				.map(a -> a.getName()).forEach(System.out::println);
	}
}
