package com.jdc.ls6.ep2;

public enum T1MyanmarKyat {
	
	ONE(1), FIVE(5), TEN(10), FIFTY(50), 
	HUNDRED(100), TWO_HUNDRED(200),
	FIVE_HUNDRED(500),
	THOUSAND(1000), FIVE_THOUSAND(5000), 
	TEN_THOUSAND(10000);
	
	private int value;
	
	private T1MyanmarKyat(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		String res = "";
		String [] strs =
			 super.toString().split("_");
		for(String str : strs) {
			res += str.toLowerCase();
			res += " ";
		}
		res += "kyat";
		return res;
	}
}
