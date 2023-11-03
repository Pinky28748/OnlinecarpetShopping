<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*" %>
<% 
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "onlineshopping";
String userid = "root";
String password = "";
int cartTotal=0;

String product_id = request.getParameter("pid");

int quantity=1;
try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping","root","");
	
	
	PreparedStatement ps=con.prepareStatement("insert into cart (total,pid,cartquantity)values(?,?,?)");
		ps.setInt(1,cartTotal);
		ps.setString(2,"product_id");
		ps.setString(3,"product_quantity");
		ps.executeUpdate();
		out.println("Data Registered");
}
	
	
	
	

catch(Exception ex)
{
	out.println(ex);
}

%>
