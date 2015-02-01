package com.jdc.concurrency.ep2;

import java.util.Date;

public class Thread_3_join {
	
	public static void main(String[] args) throws InterruptedException {
		Runnable r = () -> {
			System.out.format("My Job is run by %s : %s%n", Thread.currentThread().getName(), new Date());
			
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Thread t1 = new Thread(r, "T1");
		Thread t2 = new Thread(r, "T2");
		Thread t3 = new Thread(r, "T3");
		Thread t4 = new Thread(r, "T4");

		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
		t4.start();
		t4.join();
	
		Thread t5 = new Thread(r, "T5");
		Thread t6 = new Thread(r, "T6");
		Thread t7 = new Thread(r, "T7");
		Thread t8 = new Thread(r, "T8");
		
		t5.start();
		t6.start();
		t7.start();
		t8.start();
	}

}
