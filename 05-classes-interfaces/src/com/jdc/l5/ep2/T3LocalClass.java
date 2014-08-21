package com.jdc.l5.ep2;

public class T3LocalClass {
	
	
	public static void main(String[] args) {
		abstract class TwiceMaker {
			abstract void doTwice(int data);
		}
		
		for(int i =0; i < 10; i ++) {
			
			TwiceMaker twice = new TwiceMaker() {
				@Override
				void doTwice(int data) {
					System.out.println(data * 2);
				}
			};
			
			twice.doTwice(i);
		}
	}

}
