package com.marina.app24.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.marina.app24.action.StudentAction;
import com.marina.app24.beans.Student;
import com.marina.app24.factory.StudentActionFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editform")
public class EditFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String sid = request.getParameter("sid");
		
		StudentAction studentAction = StudentActionFactory.getStudentAction();
		Student student = studentAction.getStudent(sid);
		
		out.println("<html>");
		out.println("<body>");
		if (student == null) {
			out.println("<h1 style='color: red;' align='center'>");
			out.println("By Marina");
			out.println("</h1>");
			out.println("<h2 style='color: blue;' align='center'>");
			out.println("Student Edit Form");
			out.println("</h2>");
			out.println("<h1 style='color: red'; align='center'>");
			out.println("Student Not Existed");
			out.println("</h1>");
			out.println("<h3 align='center'>");
			out.println("<a href='./updateform.html'>|Update Form|</a>");
			out.println("</h3>");
		} else {
			out.println("<h1 style='color: red;' align='center'>");
			out.println("By Marina");
			out.println("</h1>");
			out.println("<h2 style='color: blue;' align='center'>");
			out.println("<Student Edit Form>");
			out.println("</h2>");
			out.println("<form method='POST' action='./update'>");
			out.println("<table align='center'>");
			out.println("<tr><td>Student Id</td><td>"+student.getSid()+"</td></tr>");
			out.println("<input type='hidden' name='sid' value='"+student.getSid()+"'>");
			out.println("<tr><td>Student Name</td><td><input type='text' name='sname' value='"+student.getSname()+"'></td></tr>");
			out.println("<tr><td>Student Address</td><td><input type='text' name='saddr' value='"+student.getSaddr()+"'></td></tr>");
			out.println("<tr><td><input type='submit' value='Update'></td></tr>");
			out.println("</table></form>");
		}
		out.println("</body></html>");
	}

}
