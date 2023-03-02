package com.easylearning.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletThree
 */
@WebServlet("/three")
public class ServletThree extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Servet Three get method called");

		PrintWriter out = response.getWriter();
		out.println("<h1>Servet three get method called</h1>");

		response.sendRedirect("https://www.youtube.com/");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Servet three post method called");

		PrintWriter out = response.getWriter();
		out.println("<h1>Servet Three post method called</h1>");

		response.sendRedirect("four");

	}

}
