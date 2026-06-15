package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
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
		pw.print("<h1>Update Employee</h1>");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		Employee e = EmpDataAccess.getElemenetBy(id);
		
		pw.print("<form action = 'Editservlet2' method ='post'>");
	    pw.print("<table>");
	    pw.print("<tr><td><input type='hidden' name ='id' value='"+e.getId()+"'/></td></tr>");
        pw.print("<tr><td>Name :</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
        pw.print("<tr><td>Password :</td><td><input type='password' name='password' value ='"+e.getPassword()+"'/></td></tr>");
        pw.print("<tr><td>Email :</td><td><input type='text' name='email value='"+e.getEmail()+"'/></td></tr>");
        pw.print("<tr><td>Country</td><td>");
        pw.print("<select name='country' style='width:150px'>");
        pw.print("<option>India</option>");
        pw.print("<option>USA</option>");
        pw.print("<option>UK</option>");
        pw.print("<option>Others</option>");
        pw.print("</select>");
        pw.print("</td></tr>");
        
        pw.print("<tr><td colspan='2'><input type='submit' value='Edit & save'/></td></tr>");
        pw.print("</table>");
        pw.print("</form>");
        pw.close();
		
	}

}
