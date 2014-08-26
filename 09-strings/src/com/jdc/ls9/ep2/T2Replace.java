package com.jdc.ls9.ep2;

public class T2Replace {
	
	public static void main(String[] args) {
		String origin = "This is original String";
		String fnl = origin.replace('s', '$');
		
		System.out.println(fnl);
		
		fnl = origin.replace("original", "final");
		System.out.println(fnl);
		
		fnl = origin.replaceFirst("is", "IS");
		System.out.println(fnl);
		
		fnl = origin.replaceAll("is", "IS");
		System.out.println(fnl);
	}

}
