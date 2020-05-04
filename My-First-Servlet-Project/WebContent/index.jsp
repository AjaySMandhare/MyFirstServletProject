<html>
<head>

<title>Welcome to Login</title>
 <!--  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
<link rel="stylesheet" href="F:\Bootstrap\bootstrap-4.4.1-dist\css\bootstrap.min.css">
 -->
</head>

<body>	

	<%
	
	if(request.getAttribute("msg")!=null)
out.println(request.getAttribute("msg"));
%>
<form action="LoginServlet" method="post">
<table style="background-color:skyblue; margin-left: 20px; margin-left: 20px">

<tr><td><h3 style="color: red;">Login Page !!!</h3></td></tr>
<tr><td> User Name : </td><td><input type="text" name="uname"></td></tr>
<tr><td> User Password: </td><td> <input type="password" name="password" ></td></tr>
<tr><td> <input type="submit" value="Login" ></td></tr>
<!-- <tr><td><a href="home.jsp">Submit</a></td></tr> -->
<tr><td><a href="register.jsp">Register</a></td></tr>
<tr><td><a href="forgotpassword.jsp">Forgot Password</a></td></tr>
</table>
</form>
</body>
</html>