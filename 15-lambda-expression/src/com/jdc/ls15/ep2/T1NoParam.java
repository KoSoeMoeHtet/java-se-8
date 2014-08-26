package com.jdc.ls15.ep2;

import java.util.function.Consumer;

public class T1NoParam {
	
	@FunctionalInterface
	static interface NoParameter {
		void showMessage();
	}

	public static void main(String[] args) {
		Consumer<NoParameter> cons = a -> a.showMessage();
		
		// lambda
		cons.accept(() -> {System.out.println("Hello type 1");});
		cons.accept(() -> System.out.println("Hello type 2"));
		
		// method reference
		cons.accept(System.out::println);
	}
}
