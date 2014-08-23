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
			break;
		case TWO:
			speed = 30;
			break;
		case THREE:
			speed = 45;
			break;
		case FOUR:
			speed = 60;
			break;
		default:
			break;
		}
		return speed;
	}

}
