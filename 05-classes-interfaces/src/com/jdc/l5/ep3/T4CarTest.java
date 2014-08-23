package com.jdc.l5.ep3;

import com.jdc.l5.ep3.T1Gear.GearNumber;


public class T4CarTest {
	
	public static void main(String[] args) {
		
		// by implemented class
		T1Gear mountainGear = new T2MountainGear();
		T3Car car1 = new T3Car(mountainGear);
		
		// by anonymous class
		T3Car car2 = new T3Car(new T1Gear() {
			
			@Override
			public int change(GearNumber number) {
				int speed = 0;
				switch (number) {
				case BACK:
					speed = -15;
					break;
				case ONE:
					speed = 10;
					break;
				case TWO:
					speed = 20;
					break;
				case THREE:
					speed = 30;
					break;
				default:
					break;
				}
				return speed;
			}
		});
		
		// by method reference
		T3Car car3 = new T3Car(T4CarTest::getSpeed);
		
		// by lambda expression
		T3Car car4 = new T3Car(a -> {
			int speed = 0;
			switch (a) {
			case BACK:
				speed = -15;
				break;
			case ONE:
				speed = 10;
				break;
			case TWO:
				speed = 20;
				break;
			case THREE:
				speed = 30;
				break;
			default:
				break;
			}
			return speed;
		});
		
		car1.drive(3, GearNumber.ONE);
		car2.drive(3, GearNumber.ONE);
		car3.drive(3, GearNumber.ONE);
		car4.drive(3, GearNumber.ONE);
		
		car1.drive(10, GearNumber.THREE);
		car2.drive(10, GearNumber.THREE);
		car3.drive(10, GearNumber.THREE);
		car4.drive(10, GearNumber.THREE);
		
		car1.showDistance();
		car2.showDistance();
		car3.showDistance();
		car4.showDistance();

	}
	
	public static int getSpeed(GearNumber num) {
		int speed = 0;
		switch (num) {
		case BACK:
			speed = -15;
			break;
		case ONE:
			speed = 30;
			break;
		case TWO:
			speed = 60;
			break;
		case THREE:
			speed = 90;
			break;
		case FOUR:
			speed = 120;
			break;
		default:
			break;
		}
		return speed;
	}

}
