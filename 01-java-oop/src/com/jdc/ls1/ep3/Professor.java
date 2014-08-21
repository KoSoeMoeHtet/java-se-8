package com.jdc.ls1.ep3;

public class Professor extends UniversityPerson {
	
	private String classId;

	public Professor(String name, String school, String classId) {
		super(name, school);
		this.classId = classId;
	}

	public String getStudentId() {
		return classId;
	}
}
