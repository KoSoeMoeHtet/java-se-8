package com.jdc.se.entity;

public class Phone {
	
	private Integer id;
	private String name;
	private Integer phone_maker_id;
	private String memory;
	private String model;
	private String color;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPhone_maker_id() {
		return phone_maker_id;
	}
	public void setPhone_maker_id(Integer phone_maker_id) {
		this.phone_maker_id = phone_maker_id;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return String.format("%s - %s", this.name, this.memory);
	}
}
