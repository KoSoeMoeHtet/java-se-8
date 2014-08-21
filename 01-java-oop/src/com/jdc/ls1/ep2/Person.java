package com.jdc.ls1.ep2;

public class Person {

	protected String name;
	private static int count;
	
	public Person(String name) {
		this.name = name;
		count ++;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCount() {
		return count;
	}
}
