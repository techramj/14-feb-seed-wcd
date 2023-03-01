package com.easylearning.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easylearning.model.User;
import com.easylearning.service.LoginService;

public class RegisterServlet extends HttpServlet {
	
	private LoginService loginService = new LoginService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String confirmPassowrd = req.getParameter("confirmPassword");
		String message = null;
		if(loginService.validatePassword(password, confirmPassowrd)) {
			message = "Password and Confirm password should match.";
		}else if(!loginService.isNewUser(username)) {
			message ="Username is already registered. Please select another username";
		}
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<header>");
		out.println("<title>Home Page</title>");
		out.println("</header>");
		out.println("<body>");
		
	
		if(message!= null) {
			out.println("<h1>"+ username+" successfully registered.</h1>");
			out.println("<a href='login.html'>click here</a> for Login.");
		}else {
			out.println("<p>"+message+"</p>");
			out.println("<a href='register.html'>click here</a> for Signup.");
		}
		out.println("</body>");
		out.println("</html>");
		
	}

}
