package com.marina.app09.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
