package com.jdc.l5.ep2;

public class T2InstanceInner {
	
	static int COUNT;
	String name;
	
	public T2InstanceInner(String name) {
		this.name = name;
	}
	
	public void countUp() {
		COUNT ++;
	}
	
	class InnerClass {
		void showMessage() {
			System.out.println(name + " : " + COUNT);
		}
	}
	
	public static void main(String[] args) {
		T2InstanceInner test = new T2InstanceInner("Static Inner Class Test");
		
		InnerClass inner = test.new InnerClass();
		
		test.countUp();
		
		inner.showMessage();
	}

}
