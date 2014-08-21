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
				// TODO Auto-generated method stub
				return 0;
			}
		});
		
		// by method reference
		T3Car car3 = new T3Car(T4CarTest::getSpeed);
		
		// by lambda expression
		T3Car car4 = new T3Car(a -> {
			return 0;
		});

	}
	
	public static int getSpeed(GearNumber num) {
		return 0;
	}

}
