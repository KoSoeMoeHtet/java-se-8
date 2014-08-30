package com.jdc.ls15.ep3;

import java.util.function.Consumer;

public class T1EffectiveFinal {
	
	public static void main(String[] args) {
		int sum = 10;
		
		Consumer<Integer> cons = a -> System.out.println(sum + a);
		
		cons.accept(10);
	}

}
