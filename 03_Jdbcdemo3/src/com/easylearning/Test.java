package com.easylearning;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.easylearning.dao.EmployeeDao;
import com.easylearning.dao.UserDao;
import com.easylearning.model.Employee;
import com.easylearning.model.Student;
import com.easylearning.util.ConnectionUtil;

public class Test {
	
	public static void main(String[] args) {
		//exampleForExecuteMethod();
		//dbInfo();
		addEmployee(employees());
	}
	
	public static void addEmployee(List<Employee> list) {
		int count =0;
		long l1 = System.currentTimeMillis();
		Connection con = ConnectionUtil.getConnection();
		try(Statement st = con.createStatement()){
			
			for(Employee emp:list) {
				++count;
				String sql ="insert into emp values (emp_seq1.nextval,'"+emp.getName()+"',"+emp.getSalary()+")";
				//System.out.println(sql);
				//st.executeQuery(sql);	
				st.addBatch(sql);
//				if(count%2000 == 0) {
//					int[] a= st.executeBatch();
//					System.out.println(a.length);
//				}
			}
			int[] arr = st.executeBatch();
			System.out.println(arr.length);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		long l2 = System.currentTimeMillis();
		System.out.println("Time taken: "+(l2-l1)+" ms");
		
	}
	
	public static List<Employee> employees(){
		List<Employee> list = new ArrayList<Employee>();
		for(int i=0;i<=10000;i++) {
			Employee emp = new Employee("John-"+i,1000+i);
			list.add(emp);
		}
		return list;
	}
	
	public static void dbInfo() {
		Connection con = ConnectionUtil.getConnection();
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println("Product version: "+dbmd.getDatabaseProductVersion());
			System.out.println("Product Name: "+ dbmd.getDatabaseProductName());
			System.out.println("Max no of column in select: "+dbmd.getMaxColumnsInSelect());
			System.out.println("column length: "+dbmd.getMaxColumnNameLength());
//			ResultSet schemas = dbmd.getSchemas();
//			while(schemas.next()) {
//				System.out.println(schemas.getObject(1)+"\t"+schemas.getObject(2));
//			}
			
			System.out.println(dbmd.getSQLKeywords());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void exampleForExecuteMethod() {
		String dml1 ="insert into emp select employee_id,last_name,salary from employees "+
	                  "where employee_id>110 and department_id=50";
		String dml2 = "update emp set salary = salary + 1000";
		String dml3 = "delete emp where id<=150";
		String selectQuery1 = "select * from emp";
		String selectQuery2 = "select * from employees";
		String ddl = "alter table dept add(mgr_id number)";
		
		executeQuery(selectQuery1);
		printLine();
		
		executeQuery(selectQuery2);
		printLine();
		
		executeQuery("select * from departments");
		printLine();
		
		executeQuery("delete emp where rownum<=10");
		printLine();
		
		executeQuery(dml2);
		printLine();
		
		executeQuery("alter table dept add (loc_id number)");
	}
	
	
	public static void executeQuery(String sql) {
		//executeUpdate or executeQuery
		Connection con = ConnectionUtil.getConnection();
		System.out.println(sql);
		try(Statement st = con.createStatement()){
			if(st.execute(sql)) {
				//select query
				try(ResultSet rs = st.getResultSet()){
					ResultSetMetaData rsmd = rs.getMetaData();
					
					int columnCount = rsmd.getColumnCount();
					System.out.println("no of columns: "+columnCount);
					
					//print column name
					for(int i=1;i<=columnCount; i++) {
						String colName = rsmd.getColumnName(i);
						System.out.print(colName+"\t");
					}
					System.out.println();

					//print the data
					while(rs.next()) {
						for(int i=1;i<=columnCount; i++) {
							System.out.print(rs.getObject(i)+"\t");
						}
						System.out.println();
					}
					System.out.println();
				}	
			}else {
				int rowAffected = st.getUpdateCount();
				System.out.println(rowAffected+" rows affected");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void executeAnyQuery(String sql) {
		//executeUpdate or executeQuery
		Connection con = ConnectionUtil.getConnection();
		System.out.println(sql);
		try(Statement st = con.createStatement()){
			if(st.execute(sql)) {
				//select query
				try(ResultSet rs = st.getResultSet()){
					while(rs.next()) {
						int id = rs.getInt(1);
						String name = rs.getString(2);
						double salary = rs.getDouble(3);
						System.out.println(id+ "   "+name+"  "+salary);
					}
				}	
			}else {
				int rowAffected = st.getUpdateCount();
				System.out.println(rowAffected+" rows affected");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void printLine() {
		System.out.println("_____________________________________________________________________________");
		System.out.println();
	}
	
}
