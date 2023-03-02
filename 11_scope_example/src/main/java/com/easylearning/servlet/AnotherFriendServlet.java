package com.easylearning.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AnotherFriendServlet
 */
@WebServlet("/anotherFriend")
public class AnotherFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("anotherfriendservlet");
		HttpSession session = request.getSession();
		ServletContext context = getServletContext();
		
		
		String username = (String)session.getAttribute("user");
		//String username = (String) context.getAttribute("user");
		
		//String username = (String) request.getAttribute("user");
		List<String> friends = (List<String>)request.getAttribute("friendList");
		
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<header>");
		out.println("<title>Home Page</title>");
		out.println("</header>");
		out.println("<body>");
		if (friends.size() == 0) {
			out.println(username + " has no friend");
		} else {
			out.println("<h3>"+username+" Friend's Name</h3>");
			out.println("<hr>");
			for (String name : friends) {
				out.println("<p>" + name + "</p>");
			}
		}
		out.println("</body>");
		out.println("</html>");
	}



}
