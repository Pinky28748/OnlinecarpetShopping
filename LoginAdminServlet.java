

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginAdminServlet
 */
@WebServlet("/LoginAdminServlet")
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdminServlet() {
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
		String n = request.getParameter("adname");
		String p = request.getParameter("adpwd");
		PreparedStatement ps = con.prepareStatement("select adname from admin where adname=? and password=?");
		ps.setString(1, n);
		ps.setString(2, p);
		 ResultSet rs =ps.executeQuery();
		 if(rs.next())
		 {
			 RequestDispatcher rd = request.getRequestDispatcher("adminhome1.html");
			 rd.forward(request, response);
		 }
		 else
		 {
			 
			 out.println("<font color=red size=18>Login Failed!!<br>");
			 out.println("<a href=LoginAdmin.jsp>Try Again!!");
		 }
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
