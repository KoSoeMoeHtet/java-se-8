package com.jdc.concurrency.ep2;

public class Thread_1_sleep {
	
	public static void main(String[] args) {
		
		new Thread(() -> {
			int i = 0;
			
			while(i < 10) {
				try {
					System.out.println(String.format("%d Message", ++i));
					Thread.sleep(1000);
				} catch (Exception e) {
					return;
				}
			}
		}).start();
	}

}
