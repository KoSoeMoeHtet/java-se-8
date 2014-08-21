package com.jdc.l5.ep1;

public abstract class T1Animal {

	protected String name;
	
	public T1Animal(String name) {
		this.name = name;
	}
	
	public abstract void speak();
	
	protected void greet() {
		System.out.println("My Name is " + name);
	}
}
