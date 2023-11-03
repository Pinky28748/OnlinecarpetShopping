import java.io.PrintWriter;
import java.sql.*;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Viewcart
 */
@WebServlet("/Viewcart")
public class Viewcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewcart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String q;
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping","root","");
		PreparedStatement ps;
		ResultSet rs;
		Cookie c = new Cookie(request.getParameter("Itemid"),"1");
		c.setMaxAge(10);
		response.addCookie(c);
		pw.print("Product Removed From Cart successfully");
		
		
		
		}
		catch(Exception ex) { }
		pw.print("<a href='Displaycart'>Go Back</a>");
		try
		{
			Cookie ck[] = request.getCookies();
			pw.print(
					"<style>"
							+ "td,th{padding:14px 30px;}"
							+ "body{font-family:arial;}"	
							+ "table{border:1px solid black;padding:20px;margin-top:-50px;}"
							+ "a{text-decoration:none;border:1px solid black;padding:10px 10px;}"
							+ "a:hover{color:red;}"
						+"</style"
							+"<table>"
							+"<tr>"
							+"<th>ID<th>"
							+"<th>Product Name</th>"
							+"<th>Product Price</th>"
						);
					for(int i=0;i<ck.length;i++)
					{
						q = "Select * from product1 where pid =" + ck[i].getName()+" ";
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping","root","");
						PreparedStatement ps;
						ResultSet rs;
						ps=con.prepareStatement(q);
						rs=ps.executeQuery();
						
						
						
						
						while(rs.next())
						{
							pw.print("<tr><td>"+rs.getInt(1)+"</td>"
									+"<td>"+rs.getString(2)+"</td>"
									+"<td>"+rs.getInt(3)+"</td>"
									+"<td><a href='Viewcart?Itemid=" + rs.getInt(1)+"'>Add To cart</a></td>"
									+"</tr><br><br>");
						}
						
					}
					
					
					pw.println("</table></body></html>");
			
			
		}
		catch(Exception ex)
		{
			
		}
		
		
		
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
