package com.jdc.ls1.ep3;

import com.jdc.ls1.ep2.Person;

public class UniversityPerson extends Person {
	
	private String school;

	public UniversityPerson(String name, String school) {
		super(name);
		this.school = school;
	}
	
	public String getSchool() {
		return school;
	}

}
