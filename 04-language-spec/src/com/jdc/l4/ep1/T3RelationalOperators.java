package com.jdc.l4.ep1;

public class T3RelationalOperators {
	
	static String FORMAT = "(%d %s %d) = %s%n";
	
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		
		System.out.format(FORMAT, a, "==", b, (a == b));
		System.out.format(FORMAT, a, "!=", b, (a != b));
		System.out.format(FORMAT, a, ">", b, (a > b));
		System.out.format(FORMAT, a, "<", b, (a < b));
		System.out.format(FORMAT, a, ">=", b, (a >= b));
		System.out.format(FORMAT, a, "<=", b, (a <= b));
	}

}
