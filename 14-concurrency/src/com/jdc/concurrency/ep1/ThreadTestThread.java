package com.jdc.concurrency.ep1;

public class ThreadTestThread extends Thread{

	@Override
	public void run() {
		System.out.println("Hello from thread!");
	}
	
	public static void main(String[] args) {
		new ThreadTestThread().start();
	}
}
