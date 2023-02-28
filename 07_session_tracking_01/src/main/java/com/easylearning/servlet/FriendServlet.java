package com.easylearning.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easylearning.service.LoginService;

public class FriendServlet extends HttpServlet{
	
	private LoginService service = new LoginService();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Friend servlet called");
		String username= req.getParameter("username");
		System.out.println("username: ="+username);
		List<String> friends = service.getFriends(username);
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<header>");
		out.println("<title>Home Page</title>");
		out.println("</header>");
		out.println("<body>");
		if(friends.size() == 0) {
			out.println(username+" has no friend");
		}else {
			out.println("<h3>Friend's Name</h3>");
			out.println("<hr>");
			for(String name:friends) {
				out.println("<p>"+name+"</p>");
			}
		}
		out.println("</body>");
		out.println("</html>");
	}

}
