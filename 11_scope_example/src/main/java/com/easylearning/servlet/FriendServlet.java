package com.easylearning.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.easylearning.service.LoginService;

@WebServlet("/friend")
public class FriendServlet extends HttpServlet {

	private LoginService service = new LoginService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("Friend servlet called");
		String username = null;

		HttpSession session = req.getSession(false);
		username = (String) session.getAttribute("user");

		List<String> friends = service.getFriends(username);

		RequestDispatcher rd = req.getRequestDispatcher("anotherFriend");
		req.setAttribute("friendList", friends);
		rd.forward(req, resp);

	}

}
