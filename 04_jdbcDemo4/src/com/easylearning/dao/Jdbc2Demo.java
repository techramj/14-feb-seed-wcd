package com.easylearning.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.easylearning.util.ConnectionUtil;

public class Jdbc2Demo {
	
	private Connection con = ConnectionUtil.getConnection();
	
	public void example1() throws SQLException{
		String sql = "select * from emp";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		rs.next();
		displayEmployee(rs);
		
		rs.next();
		displayEmployee(rs);
		
		rs.next();
		displayEmployee(rs);
		
		rs.previous();  //will throw exception. by default resultset will move in forward direction only
		displayEmployee(rs);
		
	}
	
	public void example2() throws SQLException{
		String sql = "select * from emp";
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = st.executeQuery(sql);
		
		rs.next();
		displayEmployee(rs,"next");
		
		rs.next();
		displayEmployee(rs,"next");
		
		rs.next();
		displayEmployee(rs,"next");
		
		rs.previous(); 
		displayEmployee(rs,"previous");
		
		rs.last();
		displayEmployee(rs,"last");
		
		rs.first();
		displayEmployee(rs,"first");
		
		rs.absolute(4);
		displayEmployee(rs,"absolute(4)");
		
		rs.absolute(3);
		displayEmployee(rs,"absolute(3)");
		
		rs.relative(2);
		displayEmployee(rs,"relative(2)");
		
		rs.relative(2);
		displayEmployee(rs,"relative(2)");
		
		rs.beforeFirst();
		rs.afterLast();
	}
	
	public void example3() throws SQLException{
		String sql = "select id,name,salary from emp";
		//for CONCUR_UPDATABLE don't use * in select query.
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery(sql);

	
		rs.absolute(3);
		displayEmployee(rs,"absolute(3)");
		
		rs.updateDouble(3, 1000);
		rs.updateRow();
		System.out.println("row updated!!!!");
		
		rs.absolute(8);
		displayEmployee(rs,"absolute(3)");
		rs.deleteRow();
		System.out.println("row deleted");
		
		rs.moveToInsertRow();
		rs.updateInt(1, 11);
		rs.updateString(2, "Jack");
		rs.updateDouble(3, 1000);
		rs.insertRow();
		System.out.println("1 row inserted");
		
	}
	
	private void displayEmployee(ResultSet rs) throws SQLException{
		int id = rs.getInt(1);
		String name = rs.getString(2);
		double salary = rs.getDouble(3);
		System.out.println("id: "+id+"    name: "+name+"    salary:"+salary);
	}
	
	private void displayEmployee(ResultSet rs,String message) throws SQLException{
		System.out.println(message);
		int id = rs.getInt(1);
		String name = rs.getString(2);
		double salary = rs.getDouble(3);
		System.out.println("id: "+id+"    name: "+name+"    salary:"+salary);
		System.out.println();
	}

}
