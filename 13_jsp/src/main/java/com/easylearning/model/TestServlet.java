package com.easylearning.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user1 = new User("jack","jack","d","123");
		User user2 = new User("om","om","tiwari","abc");
		User user3 = new User("Johnj","John","Johnson","12345");
		
		String page = request.getParameter("page");
		
		HttpSession session = request.getSession();
		session.setAttribute("one", user1);
		request.setAttribute("two", user2);
		
		
		
		List<User> list = new ArrayList<User>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		request.setAttribute("users", list);
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}

	

}
