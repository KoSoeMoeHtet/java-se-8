package com.jdc.l4.ep2;

public class T1Expression {
	
	public static void main(String[] args) {
	/*
	 * writing codes with variables and operators
	 * method invocations
	 *	
	 */
		int a = 10;
		int b = a + 1;
		
		System.out.println(b);
		
		String str1 = "hello java";
		String str2 = new String("hello java");
		boolean result = str1 == str2;
		
		System.out.println(result);
		
		System.out.println(str1.equals(str2));
	}
}
