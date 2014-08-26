package com.jdc.ls9.ep2;

public class T1Manipulating {

	public static void main(String[] args) {
		String str = "HELLO JAVA";
		
		// char at
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(6));
		System.out.println(str.charAt(str.length() - 1));
		
		// substring
		System.out.println(str.substring(6));
		System.out.println(str.substring(1, 5));
		
		// searching
		System.out.println(str.indexOf('A'));
		System.out.println(str.indexOf("LL"));
		System.out.println(str.indexOf('A', 3));
		System.out.println(str.indexOf("LL", 2));

		System.out.println(str.lastIndexOf('A'));
		System.out.println(str.lastIndexOf("LL"));
		System.out.println(str.lastIndexOf('A', 9));
		System.out.println(str.lastIndexOf("LL", 9));
		
		System.out.println(str.contains("JA"));
		
	}
}
