package com.jdc.l5.ep2;

public class T1StaticNested {
	
	private static int COUNTER;
	
	static class InnerClass {
		public void countUp() {
			COUNTER ++;
		}
		
		public int getCounter() {
			return COUNTER;
		}
	}
	
	public static void main(String[] args) {
		InnerClass inner = new InnerClass();
		inner.countUp();
		System.out.println(inner.getCounter());
	}

}
