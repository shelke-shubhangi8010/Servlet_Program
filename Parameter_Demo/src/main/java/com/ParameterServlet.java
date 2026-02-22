package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ParameterServlet
 */
@WebServlet("/ParameterServlet")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ParameterServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("Text/html");
		PrintWriter  pw = response.getWriter();
		
	     
		String name= request.getParameter("Raj");
		pw.println("<html><body>");
		pw.println("<h2> Get</h2>");
		pw.println("<h2> Shubhangi"+name+"</h2>");
		pw.println("</html></body>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		response.setContentType("Text/html");
		PrintWriter  pw = response.getWriter();
		
	     
		String name= request.getParameter("UserName");
		String pass= request.getParameter("Upass");
		
		pw.println("<html><body>");
		pw.println("<h2> Post</h2>");
		pw.println("<h2> Shubhangi"+name+"</h2>");
		pw.println("<h4> Your Password is : "+pass+"</h4>");
		pw.println("</html></body>");
		
	}

}
