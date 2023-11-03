<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*" %>
<%
int ca = Integer.parseInt(request.getParameter("cid"));
String c = request.getParameter("catname");
try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping","root","");
	
	PreparedStatement ps = con.prepareStatement("insert into category(catid,catname) values(?,?)");
	
	ps.setInt(1,ca);
	ps.setString(2,c);
 ps.executeUpdate();
 out.println("Successfully Registered");
	RequestDispatcher rd = request.getRequestDispatcher("demo.jsp");
	 rd.forward(request, response);
	
}
catch(Exception e)
{
out.println(e);
}
%>