package com.jdc.ls7.ep3;

public class T3Test {
	
	public static void main(String[] args) {
		T1Pair<String, Double> pair = new T2Pair<>("Orange", 200.50);
		System.out.println(pair.key());
		System.out.println(pair.value());
	}

}
