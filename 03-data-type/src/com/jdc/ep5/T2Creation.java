package com.jdc.ep5;

import java.util.Arrays;

public class T2Creation {
	
	public static void main(String[] args) {
		
		// direct assertion
		Integer [] array1 = {1,2,3,4};
		
		// using Arrays utility class
		Integer [] array2 = Arrays.asList(1,2,3).toArray(new Integer[3]);
		
		// allocation and assertion
		Integer [] array3 = new Integer[3];
		array1[0] = 1;
		array1[1] = 2;
		array1[2] = 3;
		
		System.out.println(array1);
		System.out.println(array2);
		System.out.println(array3);
	}

}
