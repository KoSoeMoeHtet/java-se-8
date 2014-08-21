package com.jdc.l5.ep1;

public class T3Test {

	public static void main(String[] args) {
		
		// Abstract Class Object with Concrete Class
		T1Animal dog = new T2Dog("Aung Net");
		
		dog.speak();
		
		// Abstract Class Object with Anonymous Class
		T1Animal duck = new T1Animal("Shwe Bae") {
			
			@Override
			public void speak() {
				System.out.println("Quack");
				super.greet();
			}
		};
		
		duck.speak();
		
	}
}
