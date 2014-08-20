package com.jdc.shop.model;

import java.io.Serializable;

public class Township implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	
	public Township(String [] array) {
		id = Integer.parseInt(array[0]);
		name = array[1];
	}
	
	@Override
	public String toString() {
		return name;
	}
	public Township(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
