package com.jdc.se.entity;

public class Phone_transaction {
	private Integer phone_id;
	private Integer transaction_id;
	private Integer version;
	private Integer price;
	private Integer creation;
	private Integer modification;
	public Integer getPhone_id() {
		return phone_id;
	}
	public void setPhone_id(Integer phone_id) {
		this.phone_id = phone_id;
	}
	public Integer getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(Integer transaction_id) {
		this.transaction_id = transaction_id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getCreation() {
		return creation;
	}
	public void setCreation(Integer creation) {
		this.creation = creation;
	}
	public Integer getModification() {
		return modification;
	}
	public void setModification(Integer modification) {
		this.modification = modification;
	}
}
