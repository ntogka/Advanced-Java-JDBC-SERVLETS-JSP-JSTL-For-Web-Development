package com.marina.app16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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
		 
		ServletContext context = getServletContext();
		
		String driverClass = context.getInitParameter("driverClass");
		String driverURL = context.getInitParameter("driverURL");
		String dbUserName = context.getInitParameter("dbUserName");
		String dbPassword = context.getInitParameter("dbPassword");
		Enumeration<String> e1 = context.getInitParameterNames();
		String contextparamNames = "";
		while (e1.hasMoreElements()) {
			contextparamNames = contextparamNames + e1.nextElement() + "<br>";
		}
		
		context.setAttribute("DataSourceClass", "oracle.jdbc.pool.OracleDataSource");
		context.setAttribute("minPoolSize", 5);
		context.setAttribute("maxPoolSize", 10);
		
		Enumeration<String> e2 = context.getAttributeNames();
		String attributesNames = "";
		while(e2.hasMoreElements()) {
			attributesNames = attributesNames + e2.nextElement() + "<br>";
		}
				
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1' align='center'>");
		out.println("<tr><th colspan='2' align='center'>Context Parameters Data</th></tr>");
		out.println("<tr><td>Driver Class Name</td><td>" +driverClass+ "</td></tr>");
		out.println("<tr><td>Driver URL</td><td>" +driverURL+ "</td></tr>");
		out.println("<tr><td>Database User Name</td><td>" +dbUserName+ "</td></tr>");
		out.println("<tr><td>Database Password</td><td>" +dbPassword+ "</td></tr>");
		out.println("<tr><td>Context Parameter Names</td><td>" +contextparamNames+ "</td></tr>");
		
		out.println("<table border='1' align='center'>");
		out.println("<tr><th colspan='2' align='center'>Context Attributes Data</th></tr>");
		out.println("<tr><td>Datasource Class </td><td>" +context.getAttribute("DataSourceClass")+ "</td></tr>");
		out.println("<tr><td>Pool Minimum Size</td><td>" +context.getAttribute("minPoolSize")+ "</td></tr>");
		out.println("<tr><td>Pool Maximum Size</td><td>" +context.getAttribute("maxPoolSize")+ "</td></tr>");
		out.println("<tr><td>Context Attributes Names</td><td>" +attributesNames+ "</td></tr>");
		out.println("<tr><td>Foreign Context</td><td>" + context.getContext("app15")+ "</td></tr>");
		out.println("</table></body></html>");
	}

}
