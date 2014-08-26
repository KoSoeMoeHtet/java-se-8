package com.jdc.ls9.ep1;

public class T2ConvertingNumbers {
	
	public static void main(String[] args) {
		// string to number
		int i = Integer.valueOf("10");
		double d = Double.valueOf("10.009");
		
		System.out.println(i);
		System.out.println(d);
		
		// numbers to string
		String sFloat = String.valueOf(10.56);
		String sLong = String.valueOf(10008L);
		
		System.out.println(sFloat);
		System.out.println(sLong);
	}

}
