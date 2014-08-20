package com.jdc.ls2.ep1;

import com.jdc.ls2.ep2.WaterServer;

public class User {
	
	private Television tv;
	private WaterServer ws;
	
	public User(Television tv, WaterServer ws) {
		super();
		this.tv = tv;
		this.ws = ws;
	}

	public void watchTV() {
		tv.showTv();
	}
	
	public void drinkWater() {
		ws.getWater();
	}

}
