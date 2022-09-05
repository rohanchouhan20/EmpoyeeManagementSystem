<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddMoreProject</title>
</head>
<body bgcolor = "cyan">

<div align = "center">
<form action = "AddNewProject" method = "post">
<h1>Add Project</h1>
<table style = "width:10%" border ="1">
	<tr>
	<th>Name</th>
	<td><input type = "text" name = "name" placeholder = "Enter Project Name"/></td>
	</tr>
	<tr>
	<th>Client</th>	
	<td><input type = "text" name = "client" placeholder = "Enter Client"/></td>
	</tr>
	<tr>
	<th>Technology</th>	
	<td><input type = "text" name = "technology" placeholder = "Enter Technology"/></td>
	</tr>
	</table>
	<div align = "center">
	<button value = "ADD" style = "background:red ; padding:10px;
 border-radius:20px; color:white; font-size: 15px;">ADD</button> 
 </div>
	</form>
	</div>	
	<div align = "center">
<h4><a href = "adminHomePage.jsp">HOME-PAGE</a></h4>
<%if(request.getAttribute("message")!=null){%>
<h2><%=request.getAttribute("message")%><h2>	
<%}%>
</div>
</body>
</html>