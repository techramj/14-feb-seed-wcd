package com.easylearning.model;

public class Student {

	int rollno;
	String name;
	char gender;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int rollno, String name, char gender) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.gender = gender;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

}
