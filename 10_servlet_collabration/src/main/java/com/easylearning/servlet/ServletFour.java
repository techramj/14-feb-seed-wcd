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
 * Servlet implementation class ServletFour
 */
@WebServlet("/four")
public class ServletFour extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Servet four get method called");

		PrintWriter out = response.getWriter();
		out.println("<h1>Servet four get method called</h1>");
		out.println("<br><hr><br><a href='index.html' >Go to Home page</a>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Servet four post method called");

		PrintWriter out = response.getWriter();
		out.println("<h1>Servet four post method called</h1>");
		out.println("<br><hr><br><a href='index.html' >Go to Home page</a>");
		
	}

}
