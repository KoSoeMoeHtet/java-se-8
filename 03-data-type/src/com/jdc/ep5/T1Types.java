package com.jdc.ep5;

public class T1Types {
	
	public static void main(String[] args) {
		int [] intArray1 = {1,2,3};
		int intArray2[] = intArray1;
		
		String [] stringArray = new String[3];
		
		Object objectArray[] = new Object[4];
		
		System.out.println(intArray2);
		System.out.println(stringArray);
		System.out.println(objectArray);
	}

}
