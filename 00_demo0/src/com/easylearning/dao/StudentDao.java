package com.easylearning.dao;

import java.sql.Connection;

import com.easylearning.ConnectionUtil;
import com.easylearning.Test;

public class StudentDao {
	
	private Connection connection = ConnectionUtil.getConnection();
	
	public void addStuendent(int rollno, String name, String gender) {
		System.out.println();
	}
	
	public void updateStudent(int rollno, String newName, String newGender) {
		//
	}
	
	public void deleteStudent(int rollno) {
		
	}
	
	public void displayStudents() {
		
	}
	


}
