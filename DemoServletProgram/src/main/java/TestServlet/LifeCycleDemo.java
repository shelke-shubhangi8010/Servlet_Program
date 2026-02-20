package TestServlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LifeCycleDemo
 */
@WebServlet("/LifeCycleDemo")
public class LifeCycleDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String msg="Thank You";
    
    public LifeCycleDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

		public void init(ServletConfig config) throws ServletException {
		System.out.println("Init Method Execute");
	}

	
	public void destroy() {
		System.out.println("Destroy method execute");
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		pw.println("<html><body>");
		pw.println(msg + "  service method executed");
		pw.println("</body></html>");
		pw.close();*/
		
		if(request.getMethod().equalsIgnoreCase("get")) 
		{
			doGet(request,response);
		}
		
		else if(request.getMethod().equalsIgnoreCase("post")) 
		{
			doPost(request,response);
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().println("Request Handled by doGet");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().println("Request Handled by dopost");
		
	}
	
	}
	
	

/*
 * 
 * response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		pw.println("<html><body>");
		pw.println(msg + "  service method executed");
		pw.println("</body></html>");
		pw.close();
		
 * 
 * 
 * */
