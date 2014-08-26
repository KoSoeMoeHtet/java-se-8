package com.jdc.ls15.ep2;

import java.util.function.BiConsumer;

public class T2OneParam {
	
	static BiConsumer<String, OneParam> cons;
	
	static {
		cons = (a, b) -> b.showMessage(a);
	}
	
	@FunctionalInterface
	static interface OneParam {
		void showMessage(String message);
	}
	
	public static void main(String[] args) {
		// not omit
		cons.accept("Hello Type 1", (String a) -> {System.out.println(a);} );
		
		// omit type
		cons.accept("Hello Type 2", (a) -> {System.out.println(a);} );
		
		// omit type and ()
		cons.accept("Hello Type 3", a -> {System.out.println(a);} );
		
		// if only one line omit {}
		cons.accept("Hello Type 4", a -> System.out.println(a));
	}

}
