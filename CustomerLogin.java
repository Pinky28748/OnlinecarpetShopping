

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerLogin
 */
@WebServlet("/CustomerLogin")
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLogin() {
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
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping","root","");
		String n = request.getParameter("usernm");
		String p = request.getParameter("cpass");
		PreparedStatement ps = con.prepareStatement("select username from customer where username=? and password=?");
		ps.setString(1, n);
		ps.setString(2, p);
		 ResultSet rs =ps.executeQuery();
		 if(rs.next())
		 {
			 RequestDispatcher rd = request.getRequestDispatcher("home.html");
			 rd.forward(request, response);
		 }
		 else
		 {
			 RequestDispatcher rd = request.getRequestDispatcher("customerRegister.jsp");
			 rd.forward(request, response);
		 }
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
