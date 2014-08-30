package com.jdc.ls15.ep3;

import java.util.stream.IntStream;

public class T3StaticMethod {
	
	static void showTwice(int i) {
		System.out.println(2 * i);
	}
	
	public static void main(String[] args) {
		IntStream.rangeClosed(1, 10).forEach(T3StaticMethod::showTwice);
	}

}
