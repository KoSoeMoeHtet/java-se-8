package com.jdc.ls7.ep2;

import java.util.ArrayList;
import java.util.List;

public class T1Container<T> {

	private List<T> list = new ArrayList<>();
	
	public void add(T t) {
		list.add(t);
	}
	
	public T get(int i) {
		return list.get(i);
	}
}
