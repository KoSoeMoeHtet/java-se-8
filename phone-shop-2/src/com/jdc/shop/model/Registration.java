package com.jdc.shop.model;

import java.util.Date;

public class Registration {
	
	public static String DATE = "yyyyMMdd HH:mm:ss";
	
	private String name;
	private boolean gender = true;
	private String nrc; 
	private Date birthDate;
	private String address;
	private Township township;
	private Date creation = new Date();
	private Date modification = new Date();
	private String cardNumber;
	
	public Registration() {}
	
	public Registration(String name, boolean gender, String nrc,
			Date birthDate, String address, Township township) {
		super();
		this.name = name;
		this.gender = gender;
		this.nrc = nrc;
		this.birthDate = birthDate;
		this.address = address;
		this.township = township;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Township getTownship() {
		return township;
	}

	public void setTownship(Township township) {
		this.township = township;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public Date getModification() {
		return modification;
	}

	public void setModification(Date modification) {
		this.modification = modification;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	
}
