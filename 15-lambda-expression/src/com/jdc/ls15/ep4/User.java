package com.jdc.ls15.ep4;

public class User {
	String name, password;
	
	User(String [] u) {
		name = u [0];
		password = u [1];
	}

	User(String n, String p) {
		name = n;
		password = p;
	}

	public void write() {
		System.out.format("Name : %s Password : %s%n", name, password);
	}

}
