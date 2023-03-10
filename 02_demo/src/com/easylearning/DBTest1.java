package com.easylearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.easylearning.dao.StudentDao;
import com.easylearning.model.Student;
import com.easylearning.model.User;
import com.easylearning.util.ConnectionUtil;

public class DBTest1 {
	
	private static Connection connection = ConnectionUtil.getConnection();

	public static void addStudent() {
		String sql ="insert into student(rollno, name, gender) values (1004,'Maria','F')";
		System.out.println(sql);
		Statement st = null;
		try {
			st = connection.createStatement();
			int rowCount = st.executeUpdate(sql);
			System.out.println(rowCount+" row inserted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void addStudent(int rollno, String name, String gender) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "insert into student(rollno, name, gender) values (" + rollno + ",'" + name + "','" + gender
				+ "')";
		Statement st = null;
		try {
			st = connection.createStatement();
			int rowCount = st.executeUpdate(sql);
			System.out.println(rowCount + " row inserted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void addStudent1(int rollno, String name, String gender) {
		String sql = "insert into student(rollno, name, gender) values (" + rollno + ",'" + name + "','" + gender
				+ "')";
		//try with resource or ARM(automatic resource management)
		try(Statement st = connection.createStatement()) {
			int rowCount = st.executeUpdate(sql);
			System.out.println(rowCount + " row inserted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void addStudent2(int rollno, String name, String gender) {
		String sql = "insert into student(rollno, name, gender) values ( ?,?,?)";
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, rollno);
			ps.setString(2, name);
			ps.setString(3, gender);
			int rowCount = ps.executeUpdate();
			System.out.println(rowCount + " row inserted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void addUser( String username, String firstName,
			                    String lastName,String email, String password) {
		String sql = "INSERT INTO USERS(USERID, USER_NAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) values (seq_user.nextval,?,?,?,?,?)";
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setString(1, username);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, email);
			ps.setString(5, password);
			int rowCount = ps.executeUpdate();
			System.out.println(rowCount+" row inserted");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addUser(User user) {
		String sql = "INSERT INTO USERS(USERID, USER_NAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) values (seq_user.nextval,?,?,?,?,?)";
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPassword());
			int rowCount = ps.executeUpdate();
			System.out.println(rowCount+" row inserted");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void addStudents(List<Student> students) {

		for(Student student:students) {
			String sql = "insert into student(rollno, name, gender) values (" + student.getRollno() + ",'" 
		           + student.getName() + "','" + student.getGender()+ "')";
			System.out.println(sql);
			try(Statement st = connection.createStatement()) {
				int rowCount = st.executeUpdate(sql);
				System.out.println(rowCount + " row inserted.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void addStudents1(List<Student> students) {
		String sql = "insert into student(rollno, name, gender) values ( ?,?,?)";
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			for(Student student: students) {
				ps.setInt(1, student.getRollno());
				ps.setString(2, student.getName());
				ps.setString(3, student.getGender()+"");
				int rowCount = ps.executeUpdate();
				System.out.println(rowCount + " row inserted.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		/*
		 * List<Student> students = getStudents(); //addStudents(students); StudentDao
		 * studentDao = new StudentDao(); int count = studentDao.updateStudent(1010,
		 * "Iron Man"); System.out.println(count+" row updated!!");
		 * 
		 * studentDao.displayStudents();
		 */
		
		addStudent();
		
	}
	
	public static List<Student> getStudents(){
		List<Student> studentList = new ArrayList<>();
		Student student1 = new Student(1010, "tony", 'M');
		Student student2 = new Student(1012, "john", 'M');
		Student student3 = new Student(1013, "sam", 'M');
		Student student4 = new Student(1014, "CLARK", 'M');
		
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		studentList.add(student4);
		
		return studentList;
	}
	
	public static void sampleTest() {
		//addStudent();
		/*
		addStudent(1005, "Ankit", "M");
		addStudent(1006, "Ankita", "F");
		addStudent(1007, "Aniket", "M");
		addStudent(1008, "Aarti", "F");
		
		*/
		
		//addStudent2(1009, "Binod", "M");
	
		//addUser("sachinm", "sachin", "Mukade","sachimm@test.com", "1234");
		//addUser("rohits", "rohit", "sharma","rohits@test.com", "abcd");
		
		/*User user1 = new User();
		user1.setUsername("viratk");
		user1.setFirstName("virat");
		user1.setLastName("kohli");
		user1.setEmail("viratk@test.com");
		user1.setPassword("1111");
		
		addUser(user1);
		
		*/		
	}

}
