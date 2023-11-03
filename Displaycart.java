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
 * Servlet implementation class Displaycart
 */
@WebServlet("/Displaycart")
public class Displaycart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Displaycart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		int added_cart_product=0;
		Cookie mo=null;
	
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping","root","");
			String q = "select * from product1";
			
			
			PreparedStatement ps =con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			try
			{
			
				Cookie mo = new Cookie(request.getParameter("Itemid"),"1");
				response.addCookie(mo);
				
				pw.print("Product added to cart succesfully");
			}
			catch(Exception ex) {}
				
				
				
			

			pw.print("<a href='Viewcart'>View Cart</a>");
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
			while(rs.next())
			{
				pw.print("<tr><td>"+rs.getInt(1)+"</td>"
				+"<td>"+rs.getString(2)+"</td>"
				+"<td>"+rs.getInt(3)+"</td>"
				+"<td><a href='Displaycart?Itemid=" + rs.getInt(1)+"'>Add To cart</a></td>"
				+"</tr><br><br>");
				
			}
			pw.println("</table></body></html>");
			
		}
		catch(Exception ex)
		{
			pw.print(ex);
		}
		
		
	}
}


