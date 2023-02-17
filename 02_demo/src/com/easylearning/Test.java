package com.easylearning;

import java.util.ArrayList;
import java.util.List;

import com.easylearning.dao.EmployeeDao;
import com.easylearning.model.Employee;

public class Test {
	
	public static void main(String[] args) {
		EmployeeDao empDao = new EmployeeDao();
		
		Employee emp = new Employee("Tejas", 10000);
		System.out.println(emp);
		emp = empDao.addEmployee(emp);
		System.out.println("After adding in db:\n"+emp);
	}
	
	
}
