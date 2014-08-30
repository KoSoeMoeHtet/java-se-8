package com.jdc.ls15.ep3;

import java.util.stream.IntStream;

public class T4Constructor {
	
	static class Twice {
		public Twice(int i) {
			System.out.println(2 * i);
		}
	}
	
	public static void main(String[] args) {
		IntStream.rangeClosed(1, 10).forEach(Twice::new);
	}

}
