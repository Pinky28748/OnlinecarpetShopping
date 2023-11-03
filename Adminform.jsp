<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
  background-image: url('images.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
.box{width:900px;
        float:right;
        border:1px solid none;
       }

  .box ul li{
             width:120px;
              float:left;
               margin:10px auto;
              text-align:center;     
            }

    .box ul li a{text-decoration: none;
                  color:darkgrey;
                 }

    .box ul li:hover{background-color:green;}
    .box ul li a:hover{color:white;}
     .wd{ width:30px;
          height:539;
          background-color:black;
          opacity:0.9;
         padding:55px;
        }
</style>
</head>
<body>
<div class="box">
<h1>Welcome Admin Home Page</h1>
<ul type="none">
<li><a href="addcategory.html">CataLogue</a></li>
<li ><a href="">Product</a></li>
<li><a href="">Order</a></li>
<li><a href="">Payment</a></li>



</ul>
</div>

</body>
</html>