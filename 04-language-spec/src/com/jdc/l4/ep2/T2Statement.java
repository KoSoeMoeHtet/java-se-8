package com.jdc.l4.ep2;

public class T2Statement {
	
	public static void main(String[] args) {
		// declaration statement
		int i;
		
		// assignment statement
		i = 100;
		System.out.println(i);

		// increment statement
		i++;
		++i;
		System.out.println(i);
		
		// decrement statment
		i--;
		--i;
		System.out.println(i);

		// object creation
		String str = new String("Hello Java");
		
		// method invocation statement
		System.out.println(str.length());		
	}

}
