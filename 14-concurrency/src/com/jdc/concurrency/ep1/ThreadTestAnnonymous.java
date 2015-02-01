package com.jdc.concurrency.ep1;

public class ThreadTestAnnonymous {

	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello thread from anonymous class.");
			}
		});
		
		thread.start();
	}
}
