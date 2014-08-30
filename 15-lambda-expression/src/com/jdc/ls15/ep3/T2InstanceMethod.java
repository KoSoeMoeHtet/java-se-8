package com.jdc.ls15.ep3;

import java.util.stream.IntStream;

public class T2InstanceMethod {
	
	void doTwice(int i) {
		System.out.println(2*i);
	}
	
	interface DoTwice {
		void showTwice(int i);
	}
	
	public static void main(String[] args) {
		IntStream.rangeClosed(1, 10).forEach(new T2InstanceMethod()::doTwice);
	}

}
