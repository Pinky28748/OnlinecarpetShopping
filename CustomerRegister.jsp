<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
 body{
  background-image:url("customerregister1.jpg");
  background-repeat: no-repeat;
  background-size: 100% 220%;
  }
        h1 {
            color: black;
            text-align: center;
	    font-size: 50px;
        }

input[type=submit] {
  background-color: black;
  border-width: thin;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
td{
  color: black;
  text-align: left;
  font-size: 30px;
}
</style>
</head>
<body>
<h1 align="cente">Customer Registration</h1>
<form action="CustomerRegister" method=post onSubmit="return dil(this)" >
<table align="center">
<tr><td>Enter Name:<input type=text name=cname></td></tr>
<tr><td>Enter Username:<input type=text name=usrnm></td></tr>
<tr><td>Enter Email Id:<input type=text name=cemail></td></tr>
<tr><td>Enter password:<input type=password name=cpass></td></tr>
<tr><td>Enter Contact No:<input type=text name=cphno ></td></tr>
<tr><td><input type=submit value=submit></input></td></tr>
</table>
</form>
</body>
</html>