package com.jdc.l5.ep1;

public class T2Dog extends T1Animal {

	public T2Dog(String name) {
		super(name);
	}

	@Override
	public void speak() {
		System.out.println("Woof");
		super.greet();
	}

}
