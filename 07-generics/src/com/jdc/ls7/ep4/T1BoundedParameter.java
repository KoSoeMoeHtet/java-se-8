package com.jdc.ls7.ep4;

public class T1BoundedParameter {
	
	static class UpperBounded<T extends Number> {
		T data;
		
		public UpperBounded(T t) {
			data = t;
		}
		
		void show() {
			System.out.println(data);
		}
	}
	
	static class LowerBounded<T> {
		T data;
		
		public LowerBounded(T t) {
			data = t;
		}
		
		void show() {
			System.out.println(data);
		}
	}
	
	public static void main(String[] args) {
		// using wild card ?
		UpperBounded<?> d1 = new UpperBounded<Double>(10.11);
		d1.show();
		
		// using wild card with lower bounded parameter
		LowerBounded<? super Integer> d2 = new LowerBounded<Integer>(10); 
		d2.show();
	}
}
