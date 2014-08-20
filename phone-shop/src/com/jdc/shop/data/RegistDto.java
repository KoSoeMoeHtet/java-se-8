package com.jdc.shop.data;

import java.util.Date;

public class RegistDto implements Cloneable{
	
	private String name;
	private String phone;
	private String address;
	private Date date = new Date();
	private String cardNum = "NO_CARD";

	public RegistDto clone() throws CloneNotSupportedException {
		return (RegistDto) super.clone();
	}	
	
	
	public RegistDto(String name, String phone, String address) {
		super();
		if(null == name || name.isEmpty())
			throw new NeedToAlertException("Please set Name");
		
		if(null == phone || phone.isEmpty())
			throw new NeedToAlertException("Please set Phone");
		
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

	public boolean sameRegistration(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistDto other = (RegistDto) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
	
	
}
