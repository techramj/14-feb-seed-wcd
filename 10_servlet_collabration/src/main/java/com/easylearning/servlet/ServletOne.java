package com.easylearning.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/a.do", "/one" })
public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Servet one get method called");

		PrintWriter out = response.getWriter();
		out.println("<h1>Servet one get method called</h1>");

		RequestDispatcher rd = request.getRequestDispatcher("two");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Servet one post method called");
		PrintWriter out = response.getWriter();
		out.println("Servet one post method called");

		RequestDispatcher rd = request.getRequestDispatcher("two");
		rd.include(request, response);
	}

}
