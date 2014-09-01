package com.jdc.ls16.ep3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class T0Common {
	
	public static class User {
		String name;
		int age;
		public User(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
	}
	
	public static List<User> getUser() {
		return Arrays.asList(new User("Mg Mg", 20),
				new User("Aung Aung", 21),
				new User("Ma Ni Lar", 23),
				new User("Ma Thidar", 19));
	}
	
	public static Stream<List<User>> listStream() {
		return Arrays.asList(getUser(), 
				Arrays.asList(
						new User("Ba Oo", 32),
						new User("Ba Myint", 35)
						)).stream();
	}

}
