package com.jdc.ep5;

public class T4MultiDimension {
	
	public static void main(String[] args) {
		int [] array1 [] = {{1,2,3}, {4,5,6}, {7,8,9}};
		int [][] array2 = array1;
		int array3 [] [] = array2;
		
		System.out.println(array3[0][0]);
		System.out.println(array3[0][1]);
		System.out.println(array3[0][2]);

		System.out.println(array3[1][0]);
		System.out.println(array3[1][1]);
		System.out.println(array3[1][2]);

		System.out.println(array3[2][0]);
		System.out.println(array3[2][1]);
		System.out.println(array3[2][2]);
}
}
