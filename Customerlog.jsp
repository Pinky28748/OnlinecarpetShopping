<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
 body{
 background-image:url("CustomerLog (1).jpg");
  background-repeat: no-repeat;
  background-size: 100% 300%;
}

h1 {
  color: black;
  text-align: center;
  font-size: 60px;
}

td{
  color: black;
  font-family: verdana;
  font-size: 30px;
}
input[type=submit] {
  background-color: white ;
  border-width: thin;
  color: black;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
</head>
<body>
<h1 align="center">Customer Login</h1>
<form action=CustomerLogin method=post>
<table align="center">
<tr><td>Enter username:</td><td><input type=text name=usernm></td></tr>
<tr><td>Enter password:</td><td><input type=password name=cpass></td></tr>
<tr><td><input type=submit value=login></td></tr>
<tr><td><a href="customerRegister.jsp">Register</a>
</table>
</form>

</body>
</html>