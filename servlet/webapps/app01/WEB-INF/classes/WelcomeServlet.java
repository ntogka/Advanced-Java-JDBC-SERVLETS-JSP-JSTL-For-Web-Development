import java.io.*;
import jakarta.servlet.*;

public class WelcomeServlet implements Servlet{
	public void init(ServletConfig config)throws ServletException{
	}
	public void service(ServletRequest request, ServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1 style='color: red;' align='center'>");
		out.println("Welcome");
		out.println("</h1></body></html>");
	}
	public ServletConfig getServletConfig(){
		return null;
	}
	public String getServletInfo(){
		return "";
	}
	public void destroy(){
	}
}
