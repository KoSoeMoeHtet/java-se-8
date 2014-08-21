package com.jdc.l4.ep4;

public class T4ContinueFor {

	public static void main(String[] args) {
		int [] data = {1,2,5,67,30,6};

		for(int i = 0; i < data.length; i ++) {
			if(data[i] % 3 == 0) {
				System.out.println("The digit which can be divided by 3 is " + data[i]);
				continue;
			}
		}
	}

}
