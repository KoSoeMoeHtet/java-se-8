package com.jdc.l4.ep5;

public class T1LabelBreak {
	
	public static void main(String[] args) {
		int [][] array = {{1,2,3,4,5, 6}, 
				{10,20,30,40},
				{100,200,300,400, 140,500},
				{14, 111,123,102,105}};
		outer:
		for(int i = 0; i < array.length; i ++) {
			
			for(int j=0; j < array[i].length; j++) {
				
				if(array[i][j] % 6 == 0) {
					System.out.println("divided by 6 : break");
					System.out.println(array[i][j]);
					break;
				}

				if(array[i][j] % 3 == 0) {
					System.out.println("divided by 3 : continue");
					System.out.println(array[i][j]);
					continue;
				}
				

				if(array[i][j] % 50 == 0) {
					System.out.println("divided by 50 : continue outer");
					System.out.println(array[i][j]);
					continue outer;
				}

				if (array[i][j] % 7 == 0) {
					System.out.println("divided by 7 : break outer");
					System.out.println(array[i][j]);
					break outer;
				}
				
			}
		}
	}
}
