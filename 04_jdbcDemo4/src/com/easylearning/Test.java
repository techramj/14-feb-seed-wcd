package com.easylearning;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.easylearning.dao.EmployeeDao;
import com.easylearning.dao.Jdbc2Demo;
import com.easylearning.util.ConnectionUtil;

public class Test {
	
	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
		//dao.tranferAmount(100, 107, 1000);
		//callableStatementDemo();
		
		Jdbc2Demo ob2 = new Jdbc2Demo();
		try {
			ob2.example3();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConnectionUtil.close();
	}
	
	
	public static void callableStatementDemo() {
		Connection con = ConnectionUtil.getConnection();
		int a =10;
		int b = 20;
		int res =0 ;
		try (CallableStatement cs = con.prepareCall("call add_num(?,?,?)")) {
			cs.setInt(1, a);
			cs.setInt(2, b);
			cs.registerOutParameter(3,Types.INTEGER);
			cs.execute();
			
			res = cs.getInt(3);
			System.out.println("result is: "+res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
