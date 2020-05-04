<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><h1></h1>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Employee Register</title>
</head>
<body>
<form action="RegisterUser" method="post">
<table style="background-color:skyblue; margin-left: 20px; margin-left: 20px">

<tr><td>User Name:</td><td><input type="text" name="uname"></td></tr>
<tr><td>User Password:</td><td><input type="password" name="password"></td></tr>
<tr><td>User Email:</td><td><input type="text" name="email"></td></tr>
<tr><td>User Phone Number:</td><td><input type="text" name="phono"></td></tr>
<tr><td><input type="submit" value="Register"></td></tr>
</table>
</form>
</body>
</html>