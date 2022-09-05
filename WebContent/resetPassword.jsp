<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Reset Page</title>
</head>
<body bgcolor = "cyan">
<div align = "center">
<form action = "myPasswordUpdate" method = "post">
<table style = "width:10%" border = "1">	
	<tr>
	<td>Current-Password</td>
	<td><input type = "password" name = "password" 
	placeholder = "Enter Current-Password"/></td>
	</tr>
	<tr>
	<td>New-Password</td>
	<td><input type = "password" name = "newpassword" 
	placeholder = "Enter New-Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"/></td>
	</tr>
</table>
	<div align = "center">
	<button value = "Save Changes" style = "background:red ; padding:1px;
 border-radius:20px; color:white; font-size: 20px;">Save Changes</button> 
</div>
<div><h4><a href = "myProfile.jsp">Go-Back</a></h4></div>
</form>
<%if(request.getAttribute("message")!=null){%>
<h2><%=request.getAttribute("message")%><h2>	
<%}%>
</div>
</body>
</html>