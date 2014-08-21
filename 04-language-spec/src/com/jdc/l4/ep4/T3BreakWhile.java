package com.jdc.l4.ep4;

public class T3BreakWhile {
	public static void main(String[] args) {
		
		int [] data = {1,2,5,67,30,6};
		int i = 0;
		boolean found = false;
		
		while(i++ < data.length-1) {
			if(data[i] % 3 == 0) {
				found = true;
				break;
			}
		}
		
		if(found)
			System.out.println("The first digit which can be divided by 3 is " + data[i]);
		else
			System.out.println("There is no data which can be divided by 3");
	}
}
