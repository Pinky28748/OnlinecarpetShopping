

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerRegister
 */
@WebServlet("/CustomerRegister")
public class CustomerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegister() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		try
		{
			PrintWriter out = response.getWriter();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping","root","");
		String cnm = request.getParameter("cname");
		String unm = request.getParameter("usrnm");
		String em = request.getParameter("cemail");
		String p = request.getParameter("cpass");
		String  c = request.getParameter("cphno");
		
		PreparedStatement ps = con.prepareStatement("insert into customer(custname,username,email,password,contactno)values(?,?,?,?,?)");
		ps.setString(1, cnm);
		ps.setString(2, unm);
		ps.setString(3, em);
		ps.setString(4,p);
		ps.setString(5, c);
		
		int i =ps.executeUpdate();
		
		
		
		out.println("Data is succesfully inserted!");
		RequestDispatcher rd = request.getRequestDispatcher("home.html");
		 rd.forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
