package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class viewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
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
		 PrintWriter pw = response.getWriter();
		 pw.print("<a href='index.html'>Add Employees</a>");
		 pw.print("List of Employees");
		 List<Employee> list = EmpDataAccess.getAllEmployees();
		 //pw.print("<h1>Page No. "+pid+"</h1>");
		 pw.print("<table border='1' cellpadding ='4' width ='100%'>");
		 for(Employee e :list)
		 {
			 pw.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getCountry()+"</td></tr>"+e.getEmail()+"</td></tr>"+e.getPassword()+"</td><td><a href='EditServlet?id="+e.getId()+"'>Edit</a></td>"+"<td><a href='DeleteServlet?id='"+e.getId()+"'Delete</a></td></tr>");
			 
			
		 }
		 pw.print("</table>");
		 pw.close();
	}
	}


