package com.jdc.ls6.ep2;

public class T2Main {

	public static void main(String[] args) {
		for(T2DataType t2 : T2DataType.values()) {
			System.out.println(t2.doSomething());
		}
	}
}
