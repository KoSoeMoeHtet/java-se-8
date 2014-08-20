package com.jdc.ep2;

public class UserTest {
	
	public static void main(String[] args) {
		
		User u = new User("User", 20);
		User u2 = u;
		
		u2.setAge(24);
		
		System.out.println(u.getAge());
	}

}
