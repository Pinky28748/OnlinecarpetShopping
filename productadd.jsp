<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*" %>
<%
int id=Integer.parseInt(request.getParameter("pid"));
String name=request.getParameter("pname");
String d = request.getParameter("pdesc");
int pr = Integer.parseInt(request.getParameter("pprice"));
int q = Integer.parseInt(request.getParameter("pquan"));
int ci = Integer.parseInt(request.getParameter("cid"));

try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping","root","");
	PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?,?,?,?)");
	ps.setInt(1,id);
	ps.setString(2, name);
	ps.setString(3,d);
	ps.setInt(4,pr);
	ps.setInt(5,q);
	ps.setInt(6,ci);
	int i =ps.executeUpdate();
	
	
	
	out.println("Data is succesfully inserted!");
	RequestDispatcher rd = request.getRequestDispatcher("displayproduct.jsp");
	 rd.forward(request, response);
	
}
catch(Exception e)
{
out.println(e);
}
%>