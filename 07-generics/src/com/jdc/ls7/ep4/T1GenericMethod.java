package com.jdc.ls7.ep4;

public class T1GenericMethod {
	
	public static<T extends Comparable<T>> int compair(T t1, T t2) {
		return t1.compareTo(t2);
	}
	
	public static void main(String[] args) {
		int result1 = compair("Hello", "hello");
		System.out.println(result1);
		
		int result2 = compair(1000, 1001);
		System.out.println(result2);
	}
}
