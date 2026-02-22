package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class StudentInfoForm
 */
@WebServlet("/StudentInfoForm")
public class StudentInfoForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInfoForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("Text/html");
		PrintWriter  pw = response.getWriter();
		
	     
		String name= request.getParameter("UserName");
		String city = request.getParameter("City");
		String  age = request.getParameter("Age");
		String Education = request.getParameter("Education");
				
		pw.println("<html><body>");
		pw.println("<h2> Student Login Form</h2>");
		pw.println("<h2> Name : "+name+"</h2>");
		pw.println("<h2> City :"+city+"</h2>");
		pw.println("<h2> Age  : "+age+"</h2>");
		pw.println("<h2> Education : "+ Education +"</h2>");
		
		pw.println("</html></body>");
		
		
		
		
		
	}

}
