package com.jdc.ls2.ep3;

public class Counter {

	static int count;
	String name;
	
	public Counter(String n) {
		super();
		this.name = n;
	}

	public void countUp() {
		count ++;
	}
	
	public void showCount() {
		System.out.println(name + " : " + count);
	}
	
	public static void main(String[] args) {
		Counter c1 = new Counter("c1");
		Counter c2 = new Counter("c2");
		
		c1.countUp();
		c1.showCount();

		c2.countUp();
		
		c1.showCount();
		c2.showCount();
	}

}



