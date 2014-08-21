package com.jdc.l5.ep3;

public class T2MountainGear implements T1Gear {


	@Override
	public int change(GearNumber number) {
		int speed = 0;
		switch (number) {
		case BACK:
			speed = -15;
			break;
		case ONE:
			speed = 15;
		case TWO:
			speed = 30;
		case THREE:
			speed = 45;
		case FOUR:
			speed = 60;
		default:
			break;
		}
		return speed;
	}

}
