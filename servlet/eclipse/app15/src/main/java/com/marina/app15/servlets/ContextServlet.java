package com.marina.app15.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//ServletContext context = getServletContext();
		
		/*ServletConfig config = getServletConfig();
		ServletContext context = config.getServletContext();
		*/
		
		ServletContext context = request.getServletContext();
		
		String lname = context.getServletContextName();
		
		out.println("<h1>Logical Name : " + lname + "</h1>");
	}

}
