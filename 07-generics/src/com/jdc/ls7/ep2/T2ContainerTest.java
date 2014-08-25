package com.jdc.ls7.ep2;

public class T2ContainerTest {
	
	public static void main(String[] args) {
		T1Container<String> cont = new T1Container<String>();
		cont.add("Only String can add");
		
		// by using generics we do not need to cast
		String str = cont.get(0);
		System.out.println(str);
	}

}
