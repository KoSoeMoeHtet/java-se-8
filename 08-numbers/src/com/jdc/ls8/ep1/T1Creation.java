package com.jdc.ls8.ep1;

public class T1Creation {
	
	public static void main(String[] args) {
		// can create wrapper object by using static methods
		Integer i1 = Integer.decode("101");
		System.out.println(i1);
		
		Integer i2 = Integer.parseInt("10");
		System.out.println(i2);
		
		Integer i3 = Integer.valueOf("100");
		System.out.println(i3);
		
		Double d1 = Double.valueOf("10.10");
		System.out.println(d1);
		
		Float f1 = Float.valueOf("10.001");
		System.out.println(f1);
		
		// can change any other type of number
		Short s1 = d1.shortValue();
		System.out.println(s1);
		
		Integer i4 = d1.intValue();
		System.out.println(i4);
		
		// can compare by using wrapper class
		System.out.println(i1.compareTo(i2));
	}

}
