
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CategoryDisplay
 */
@WebServlet("/CategoryDisplay")
public class CategoryDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");  
	         out.println("<html><body>"); 
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping","root","");
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery("select catname from category");
			out.println("<table border=1 width=50% height=50%>"); 
			out.println("<tr><th>Category Name</th><tr>");
			 while (rs.next()) 
             {  
                 String n = rs.getString("catname");    
                 out.println("<tr><td>" + n + "</td><td>");   
             } 
			 out.println("</table>");  
             out.println("</html></body>");  
             con.close(); 
             
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
