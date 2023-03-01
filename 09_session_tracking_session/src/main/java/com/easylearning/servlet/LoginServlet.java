package com.easylearning.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.easylearning.model.User;
import com.easylearning.service.LoginService;

public class LoginServlet extends HttpServlet {
	
	private LoginService loginService = new LoginService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("LoginServlet get method called!!!!!!");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//System.out.println("username: "+username+"   password: "+password);
		User user = loginService.getUser(username, password);
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<header>");
		out.println("<title>Home Page</title>");
		out.println("</header>");
		out.println("<body>");
		
	
		if(user!= null) {
			HttpSession session = req.getSession();   //req.getSession(false)
			session.setAttribute("user", username);
			
			out.println("<h1> Welcome  "+user.getFirstName()+" "+user.getLastName() +"</h1>");
			out.println("<hr>");
			out.println("<form action=\"friend\">");
			
			out.println("<button type=\"submit\">Display Friend's Name</button>");
			out.println("</form>");
			out.println("<hr>");
		}else {
			out.println("<p>Invalid username or password</p>");
			out.println("<a href='login.html'>click here</a> for Login.");
		}
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("LoginServlet post method called");
	}

}
