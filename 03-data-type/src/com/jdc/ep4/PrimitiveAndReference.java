package com.jdc.ep4;

public class PrimitiveAndReference {

	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		
		System.out.println(a == b);
		
		Integer c = new Integer(10);
		Integer d = new Integer(10);
		
		System.out.println(c == d);
		System.out.println(c.equals(d));
		
		String e = "Hello";
		String f = "Hello";
		
		System.out.println(e == f);
		
		String g = new String("Hello");
		System.out.println(f);
		System.out.println(g);
		
		System.out.println(f == g);
		System.out.println(f.equals(g));
	}
}
