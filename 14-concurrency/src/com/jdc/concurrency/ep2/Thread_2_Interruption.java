package com.jdc.concurrency.ep2;

public class Thread_2_Interruption {
	
	public static void main(String[] args) {
		Thread th = new Thread(() -> {
			
			while(true) {
				try {
					Thread.sleep(5000L);
					System.out.println("Hello Thread Interruption");

					if(Thread.interrupted()) {
						System.out.println("Thread has been interrupted.");
						return;
					}
				} catch (Exception e) {
					System.err.println("Interrupted Exception.");
					return;
				}
				
			}
		});
		
		th.start();
		
		try {
			Thread.sleep(4500L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		th.interrupt();
		
	}

}
