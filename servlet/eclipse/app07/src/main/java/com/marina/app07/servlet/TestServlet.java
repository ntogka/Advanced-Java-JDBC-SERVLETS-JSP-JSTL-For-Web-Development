package com.marina.app07.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static{
		System.out.println("Static Block ---> Servlet Loading");
	}
	public TestServlet () {
		System.out.println("Constructor ---> Servlet Instantiation");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("init() ---> Servlet Initialization");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() ---> Request Processing");
	}
	@Override
	public void destroy() {
		System.out.println("destroy() ---> Servlet Deinstantiation");
	
	}
	
}
