package com.marina.app10.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("Servlet Loading");
	}
	public TestServlet() {
		System.out.println("Servlet Instantiation");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet Initialization");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Request Processing");
	}
	@Override
	public void destroy() {
		System.out.println("Servlet Deinstantiation");
	}

}
