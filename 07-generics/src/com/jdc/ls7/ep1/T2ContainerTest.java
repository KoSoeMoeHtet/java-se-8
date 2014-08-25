package com.jdc.ls7.ep1;

import java.util.Date;

public class T2ContainerTest {
	
	public static void main(String[] args) {
		T1Container cont = new T1Container();
		
		cont.add(new Date());
		cont.add(10);
		cont.add("Every thing can add");
		
		Date date = (Date) cont.get(0);
		String str = (String) cont.get(2);
		
		System.out.println(date);
		System.out.println(str);
	}

}
