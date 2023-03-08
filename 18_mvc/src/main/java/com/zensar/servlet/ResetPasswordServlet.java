package com.zensar.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.service.UserService;

/**
 * Servlet implementation class ResetPasswordServlet
 */
@WebServlet("/resetPassword")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String currentPassword = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPassword");
		String username = request.getParameter("username");
		String page= null;
		if(userService.isValidPassword(username,currentPassword,newPassword)) {
			userService.resetPassword(username, newPassword);
			page ="login.jsp";
		}else {
			page ="resetPassword.jsp";
			request.setAttribute("errorFlag", true);
			request.setAttribute("errorMessage", "Invalid Password");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
		

	}

}
