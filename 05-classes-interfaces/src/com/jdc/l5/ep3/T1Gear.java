package com.jdc.l5.ep3;

public interface T1Gear {
	
	/**
	 * Enumeration in Interface
	 *
	 */
	public enum GearNumber {ONE, TWO, THREE, FOUR, BACK}
	
	/**
	 * Abstract Method
	 *
	 */
	public int change(GearNumber number);
	
	/**
	 * Default method of Interface
	 * @param num
	 */
	default public void showMessage(GearNumber num) {
		System.out.println("Gear Number is " + num);
	}
	
	/**
	 * Static Method of Interface
	 */
	public static void start() {
		System.out.println("Starting Car");
	}

}
