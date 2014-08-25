package com.jdc.ls7.ep1;

import java.util.ArrayList;
import java.util.List;

public class T1Container {

	private List<Object> list = new ArrayList<>();
	
	public void add(Object obj) {
		list.add(obj);
	}
	
	public Object get(int i) {
		return list.get(i);
	}
}
