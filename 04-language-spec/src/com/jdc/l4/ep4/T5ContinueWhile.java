package com.jdc.l4.ep4;

public class T5ContinueWhile {
	public static void main(String[] args) {
		
		int [] data = {1,2,5,67,30,6};
		int i = 0;

		while(i++ < data.length-1) {
			if(data[i] % 3 == 0) {
				System.out.println("The digit which can be divided by 3 is " + data[i]);
				continue;
			}
		}
	}

}
