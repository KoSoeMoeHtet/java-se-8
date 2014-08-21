package com.jdc.l4.ep4;

public class T1Return {
	
	public static void main(String[] args) {
		int [] data = {1,2,5,67,30,6};
		int i;
		for(i = 0; i < data.length; i ++) {
			isEven(data[i]);
		}
	}
	
	public static void isEven(int i) {
		if(i % 2 == 0) {
			System.out.println(i + " is even number");
			return;
		}
		System.out.println(i + " is not even number");
	}

}
