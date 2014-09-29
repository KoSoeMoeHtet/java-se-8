package com.jdc.se.entity;

import java.sql.Timestamp;

public class Sim_transaction {
	private Integer sim_id;
	private Integer transaction_id;
	private String card_number;
	private Integer version;
	private Integer price;
	private Timestamp creation;
	private Timestamp modification;
	public Integer getSim_id() {
		return sim_id;
	}
	public void setSim_id(Integer sim_id) {
		this.sim_id = sim_id;
	}
	public Integer getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(Integer transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getCard_number() {
		return card_number;
	}
	public void setCard_number(String card_number) {
		this.card_number = card_number;
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
