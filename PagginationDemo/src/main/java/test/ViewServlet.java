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
 * Servlet implementation class ViewServlet
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
		PrintWriter pw= response.getWriter();
		String pid=request.getParameter("page");
		int pageid=Integer.parseInt(pid);
		int pagelimit =5;
		if(pageid==1)
		{
			
		}
		else {
			pageid=pageid-1;
			pageid=pageid*pagelimit+1;
		}
		List<Emp> list=EmpDataAccess.getRecords(pageid, pagelimit);
		pw.print("<h1> page No. "+pid +"</h1>");
		pw.print("<table border ='1' cellpadding='4' width='60%'>");
		pw.print("<tr><th>id</th><th>Name</th><th>Country</th> </tr>");
		for(Emp e:list) 
		{
			
			pw.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getCountry()+"</td></tr>");
		}
		pw.print("</table>");
			 pw.print("<a href='ViewServlet?page=1'>1</a> ");
			 pw.print("<a href='ViewServlet?page=2'>2</a> ");
			 pw.print("<a href='ViewServlet?page=3'>3</a> ");
			 pw.close();

		
	}

}
