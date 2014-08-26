package com.jdc.ls9.ep2;

public class T4Compare {
	
	static String str1 = "Hello Java";
	static String str2 = "hello java";
	
	public static void main(String[] args) {

		// start with and end with
		System.out.println(str1.startsWith("hello"));
		System.out.println(str1.endsWith("java"));
		
		System.out.println(str2.startsWith("hello"));
		System.out.println(str2.endsWith("java"));
		
		// compare to and compare to ignore case
		System.out.println(str1.compareTo(str2));
		System.out.println(str1.compareToIgnoreCase(str2));
		
		// equals and equalsIgnoreCase
		System.out.println(str1.equals(str2));
		System.out.println(str1.equalsIgnoreCase(str2));
		
		// region match
		System.out.println(str1.regionMatches(6, "Java", 0, 4));
		System.out.println(str2.regionMatches(6, "Java", 0, 4));
		
		// region match with ignore
		System.out.println(str2.regionMatches(true, 6, "Java", 0, 4));

	}

}
