package com.jdc.concurrency.ep1;

public class ThreadTestLambda {

	public static void main(String[] args) {
		Thread thread = new Thread(() -> System.out.println("Hello From Lambda"));
		thread.start();
	}
}
