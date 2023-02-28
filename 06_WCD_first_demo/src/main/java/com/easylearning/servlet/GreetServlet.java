package com.easylearning.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetServlet extends HttpServlet {
	
	public GreetServlet() {
		display();
		System.out.println("default consturctor called");
	}
	
	@Override
	public void init() throws ServletException {
		display();
		System.out.println("init method called");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		display();
		System.out.println("service method called");
		
		super.service(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		display();
		System.out.println("get method called");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		display();
		System.out.println("post method called!!!");
	}
	
	@Override
	public void destroy() {
		display();
		System.out.println("destroy method called!!!!");
	}
	
	private void display() {
		System.out.print(this.getClass().getTypeName()+" : ");
	}

}
