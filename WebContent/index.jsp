<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<style>

 #edit tr td{
 font-size: 20px;
 }
</style>
</head>
<body bgcolor = "cyan">

<div align = "center">
<form action = "EmployeeServlet" method = "post">
<h1>Welcome to Registration Form</h1>
<table  id = "edit" style = "width:10%" border ="1">
	<tr>
	<th>Name</th>
	<td><input type = "text" name = "name" placeholder = "Enter your name"/></td>
	</tr>
	<tr>
	<th>Email</th>	
	<td><input type = "email" name = "email" placeholder = "Enter your email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"/></td>
	</tr>
	<tr>
	<th>Password</th>
	<td><input type="password" name="password" placeholder = "Enter your password" 
	pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
	title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters">
  </td>
  <!-- <input type="submit"> -->
	<!-- <input type = "password" name = "password" placeholder = "Enter your password"/> -->
	</tr>
	<tr>
	<td colspan = "2">
	<p>SELECT ROLE:
	<SELECT name = "role">
		<option value = "admin">ADMIN</option>
		<option value = "employee">EMPLOYEE</option>
	</SELECT>
	</p>
	</td>
	</tr>
	
	
	
</table>
<br>
	<button align = "center" type = "submit" value = "Register" style = "background:red; padding:1px;
 border-radius:20px; color:white; font-size: 25px;">Register</button>	
</form>
	<h3>Already Registered then  <a href = "login.jsp">Go-To-Login</a></h3>
<%if(request.getAttribute("message")!=null){%>
<h2><%=request.getAttribute("message")%><h2>	
<%}%>
</div>	
</body>
</html>