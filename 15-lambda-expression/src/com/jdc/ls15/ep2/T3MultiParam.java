package com.jdc.ls15.ep2;


public class T3MultiParam {
	
	static interface MultiParam {
		int add(int a, int b);
	}
	
	public static void main(String[] args) {
		// without omitting
		MultiParam m1 = (int a, int b) -> {
			return a + b;
		};
		System.out.println(m1.add(10, 20));
		
		// omit types (if omit type you need to omit all)
		MultiParam m2 = (a, b) -> {
			return a + b;
		};
		System.out.println(m2.add(10, 20));
		
		// if only one line you can omit both {} and return keyword
		MultiParam m3 = (a, b) -> a + b;
		System.out.println(m3.add(10, 20));
	}
}
