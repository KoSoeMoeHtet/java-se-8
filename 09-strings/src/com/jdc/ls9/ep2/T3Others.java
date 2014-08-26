package com.jdc.ls9.ep2;

public class T3Others {
	
	public static void main(String[] args) {
		String original = "Yangon, Mandalay, Pathane";
		
		// splitting string
		String [] splits = original.split(", ");
		System.out.println(splits.length);
		
		// split with limitation
		splits = original.split(", ", 2);
		System.out.println(splits.length);

		// before trim
		splits = original.split(",");
		for(String s : splits)
			System.out.println(s);
		
		// after trim
		for(String s: splits)
			System.out.println(s.trim());
		
		// lower case
		System.out.println(original.toLowerCase());
		
		// upper case
		System.out.println(original.toUpperCase());
		
	}

}
