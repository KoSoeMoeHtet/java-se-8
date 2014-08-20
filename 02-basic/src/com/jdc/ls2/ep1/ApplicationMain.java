package com.jdc.ls2.ep1;

import com.jdc.ls2.ep2.WaterServer;

public class ApplicationMain {
	
	public static void main(String[] args) {
		
		WaterServer ws = new WaterServer();
		Television tv = new Television();
		
		User user = new User(tv, ws);
		user.watchTV();
		user.drinkWater();
		
		User user2 = new User(tv, ws);
		user2.watchTV();
		user2.drinkWater();
	}

}
