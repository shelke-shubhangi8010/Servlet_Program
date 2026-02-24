package SessionTrackingExample;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
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
		
		doGet(request, response);
		
		
		try {
			response.setContentType("text/html");
			PrintWriter pw =response.getWriter();
			
			String n= request.getParameter("username");
			pw.print("welcome "+n);
			
			Cookie ck= new Cookie ("uname",n);
			response.addCookie(ck);
			
			pw.print("<form action = 'SecondServlet method' method='post'>");
			pw.print("<input type='submit' value='visit'>");
			
			
			
		}catch(Exception e) 
		{
			System.out.println(e);
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
