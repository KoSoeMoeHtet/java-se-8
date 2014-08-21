package com.jdc.ls1.ep6;

public class Person {

	public String say(String word) {
		return word;
	}
	
	public static void main(String[] args) {
		
		Person person = new Person();
		Animal dog = new Dog();
		Animal cat = new Cat();
		Animal duck = new Duck();
		
		if("speak".equals(person.say("speak"))) {
			dog.speak();
			cat.speak();
			duck.speak();
		}
	}
}
