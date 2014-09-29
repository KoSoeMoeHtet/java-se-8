package com.jdc.se.entity;

import java.sql.Timestamp;

public class Customer {
	private Integer id;
	private Integer township_id;
	private String name;
	private String phone;
	private String nac;
	private String email;
	private String address;
	private Timestamp creation;
	private Timestamp modification;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTownship_id() {
		return township_id;
	}
	public void setTownship_id(Integer township_id) {
		this.township_id = township_id;
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
	public String getNac() {
		return nac;
	}
	public void setNac(String nac) {
		this.nac = nac;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
