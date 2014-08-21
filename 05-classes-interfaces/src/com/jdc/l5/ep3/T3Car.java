package com.jdc.l5.ep3;

import com.jdc.l5.ep3.T1Gear.GearNumber;

public class T3Car {
	
	private T1Gear gear;
	private int distance;
	
	public T3Car(T1Gear gear) {
		this.gear = gear;
	}
	
	public void drive(int min, GearNumber num) {
		distance = gear.change(num) * min;
	}
	
	public void showDistance() {
		System.out.format("Total Distance is %d%n", distance);
	}
}
