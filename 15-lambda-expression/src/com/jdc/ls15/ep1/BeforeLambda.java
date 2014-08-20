package com.jdc.ls15.ep1;

public class BeforeLambda {
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello Thread");
			}
		});
		
		thread.start();
	}

}
