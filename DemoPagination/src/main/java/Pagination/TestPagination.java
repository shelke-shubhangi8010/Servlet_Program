package Pagination;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class TestPagination
 */
//@WebServlet("/TestPagination")
public class TestPagination extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestPagination() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		int page=1;
		int recordPerPage=3;
		
		if(request.getParameter("page")!=null) 
		{
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int start = (page-1) * recordPerPage;
		
		String name[]= {"Riya","Amit","John","karan","neha"};
		
		pw.println("<h3>Employee list</h3>");
		
		for(int i=start;i<start+recordPerPage && i<name.length;i++) 
		{
			pw.print(name[i]+"<br>");
		}
		
		pw.print("<br>");
		
		pw.print("<a href='TestPagination?page=1'>1</a> ");
		 pw.print("<a href='TestPagination?page=2'>2</a> ");
		 pw.print("<a href='TestPagination?page=3'>3</a> ");
		 pw.close();

	}

}
