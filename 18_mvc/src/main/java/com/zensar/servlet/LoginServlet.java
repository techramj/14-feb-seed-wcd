package com.zensar.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zensar.model.Employee;
import com.zensar.model.User;
import com.zensar.service.EmployeeService;
import com.zensar.service.UserService;
import com.zensar.util.ConnectionUtil;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	private EmployeeService empService;
	
	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		String driver = context.getInitParameter("oracle.drivername");
		String url = context.getInitParameter("oracle.url");
		String username = context.getInitParameter("oracle.username");
		String password = context.getInitParameter("oracle.password");

		ConnectionUtil.
				createConnectionObject(driver, url, username, password);
		
		empService = new EmployeeService();
		userService = new UserService();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page="";
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = userService.getUser(username, password);
		if(user==null) {
			page = "login.jsp";
			request.setAttribute("errorFlag", true);
			request.setAttribute("errorMessage", "Invalid Username & Password");
		}else if( userService.isPasswordExpired(user)) {
			request.setAttribute("errorFlag", true);
			request.setAttribute("errorMessage", "Password Expired. Please reset the password");
			request.setAttribute("username", username);
			page ="resetPassword.jsp";
		}else {
			page = "homePage.jsp";
			HttpSession session =request.getSession();
			List<Employee> employees = empService.getEmployees();
			session.setAttribute("empList", employees);
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
