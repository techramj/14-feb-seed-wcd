package com.easylearning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.easylearning.model.Student;
import com.easylearning.util.ConnectionUtil;

public class StudentDao {
	
	public static Connection connection = ConnectionUtil.getConnection();
	
	public int addStudent(Student student) {
		return 0;
	}
	
	public int addStudent(int rollNo, String name, char gender) {
		
		return 0;
		
	}
	
	public int updateStudent(int rollNo, String newName) {
		String sql ="update student set name=? where rollno =?";
		try(PreparedStatement ps= connection.prepareStatement(sql)){
			ps.setString(1, newName);
			ps.setInt(2, rollNo);
			return ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteStudent(int rollNo) {
		return 0;
	}
	
	public int deleteStudents(int fromRollNo, int toRollNo) {
		return 0;
	}
	
	public void displayStudents() {
		String sql = "select * from student";
		try(Statement st= connection.createStatement();
				ResultSet rs = st.executeQuery(sql)){
		 	while(rs.next()) {
		 		int rollno = rs.getInt(1);   //rs.getInt("rollno");
		 		String name = rs.getString(2);
		 		String gender = rs.getString(3);
		 		System.out.println("roll no: "+rollno);
		 		System.out.println("name: "+name);
		 		System.out.println("gender: "+gender);
		 		System.out.println();
		 	}
		}catch(SQLException e) {
			
		}
	}
	
	public List<Student> getStudents(){
		return null;
	}
	

}
