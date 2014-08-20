package com.jdc.ls15.ep3;

public class FunctionalInterfaceTest {

	@FunctionalInterface
	static interface FindEvenNumber {
		public boolean isEven(int number);
	}
	
	public static void main(String[] args) {
		FindEvenNumber even = a -> a % 2 == 0;
		System.out.println(even.isEven(2));
		System.out.println(even.isEven(3));
	}
}
