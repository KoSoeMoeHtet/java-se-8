package com.jdc.l4.ep1;

public class T2ArithmeticOperators {
	
	private static String output = "%d %s %d = %d%n";
	
	public static void main(String[] args) {
		
		// Arithmetic operators
		int a = 10;
		int b = 5;
		
		System.out.format(output, a, "+", b, (a + b));
		System.out.format(output, a, "-", b, (a - b));
		System.out.format(output, a, "*", b, (a * b));
		System.out.format(output, a, "/", b, (a / b));
		System.out.format(output, a, "%", b, (a % b));
		
		// Arithmetic Operator for String
		String c = "Hello ";
		String d = "java";
		
		System.out.format("\"%s\" + \"%s\" = \"%s\"%n", c, d, (c + d));
		
		// Arithmetic Operators in String and primitives
		System.out.format("%d + \"%s\" = \"%s\"%n", 10, "1", (10 + "1"));
	}

}
