<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
  background-image:url("Wallpaper.jpg");
  background-repeat: no-repeat;
 	 background-size: 100% 350%;
}
input[type=submit] {
  background-color: Grey ;
  border-width: thin;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
h1 {
  color: white;
  text-align: center;
font-size: 70px;
  
}
td{
  color: black;
  text-align: left;
  font-size: 30px;
}
</style>
</head>
<body>
<h1 align=center> Login</h1>
<form action=LoginAdminServlet method=post >
<table align=center>
<tr><td>Enter Name:</td><td><input type=text name=adname required></td>
<tr><td>Enter Password:</td><td><input type=password name=adpwd required></td>
<tr><td><input type=submit value=Login></td></tr>
</table>
</form> 
</body>
</html>