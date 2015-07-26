package com.jdc.ls6.ep4;

public enum Gender {

	MALE(1, "Male"), FEMALE(2, "Female");
	
	private int value;
	private String strValue;
	
	Gender(int value, String strValue) {
		this.value = value;
		this.strValue = strValue;
	}
	
	public int getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return this.strValue;
	}
	
	public static void main(String[] args) {
		for(Gender g : Gender.values())
			System.out.println(g);
	}
}
