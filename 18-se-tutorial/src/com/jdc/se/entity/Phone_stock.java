package com.jdc.se.entity;

import java.sql.Timestamp;

public class Phone_stock {

	private Integer id;
	private Integer phone_id;
	private Integer in;
	private Integer out;
	private Integer total;
	private Integer status;
	private Integer buy_price;
	private Integer sell_price;
	private Timestamp creation;
	private Timestamp modification;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPhone_id() {
		return phone_id;
	}
	public void setPhone_id(Integer phone_id) {
		this.phone_id = phone_id;
	}
	public Integer getIn() {
		return in;
	}
	public void setIn(Integer in) {
		this.in = in;
	}
	public Integer getOut() {
		return out;
	}
	public void setOut(Integer out) {
		this.out = out;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getBuy_price() {
		return buy_price;
	}
	public void setBuy_price(Integer buy_price) {
		this.buy_price = buy_price;
	}
	public Integer getSell_price() {
		return sell_price;
	}
	public void setSell_price(Integer sell_price) {
		this.sell_price = sell_price;
	}
	public Timestamp getCreation() {
		return creation;
	}
	public void setCreation(Timestamp creation) {
		this.creation = creation;
	}
	public Timestamp getModification() {
		return modification;
	}
	public void setModification(Timestamp modification) {
		this.modification = modification;
	}
}
