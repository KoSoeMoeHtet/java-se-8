package com.jdc.ls1.ep3;

public class Student extends UniversityPerson {

	private String studentId;
	
	public Student(String name, String school, String studentId) {
		super(name, school);
		this.studentId = studentId;
	}
	
	public String getStudentId() {
		return studentId;
	}

}
