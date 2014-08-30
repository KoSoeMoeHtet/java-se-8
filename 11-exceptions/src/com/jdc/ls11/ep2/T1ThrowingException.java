package com.jdc.ls11.ep2;

public class T1ThrowingException {

	public static void main(String[] args) {
		showLength(null);
	}
	
	public static void showLength(String str) {
		if(null == str)
			throw new RuntimeException("Parameter should not be null");
		
		System.out.println(str.length());
	}
}
