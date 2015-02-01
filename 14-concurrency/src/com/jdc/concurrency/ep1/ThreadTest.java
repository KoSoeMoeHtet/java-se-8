package com.jdc.concurrency.ep1;

public class ThreadTest {

	static class ThreadWrite implements Runnable {

		@Override
		public void run() {
			System.out.println("Hello Thread");
		}
		
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new ThreadWrite());
		thread.start();
	}
}
