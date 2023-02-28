package com.easylearning.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		String j = getServletConfig().getInitParameter("j");
		String h = getServletConfig().getInitParameter("h");
		String s = getServletConfig().getInitParameter("s");
		System.out.println("J= "+j+"    h="+h+"   s="+s);
		
		String trainer = getServletContext().getInitParameter("trainer");
		System.out.println("trainer="+trainer);
	}
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
