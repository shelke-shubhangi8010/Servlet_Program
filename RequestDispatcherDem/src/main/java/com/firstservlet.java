package com;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class firstservlet
 */
@WebServlet("/firstservlet")
public class firstservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firstservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			response.setContentType("text/html");
			PrintWriter pw= response.getWriter();
			String uname = request.getParameter("username");
			
			String upass= request.getParameter("password");
			
			if(upass.equals("abc@123")) 
			{
				RequestDispatcher  rd= request.getRequestDispatcher("Servlet2");
				rd.forward(request, response);
				
				
			}
			else
			{
				pw.print(" Sorry.... Incorrect password");
				RequestDispatcher  rd= request.getRequestDispatcher("/index.html");
				rd.include(request, response);
			}
		}catch(Exception e) 
		{
			System.out.println(e);
		}
	}

}
