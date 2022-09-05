<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Project</title>
</head>
<body bgcolor = cyan>
<div align = center>
<form action = "DeleteProject" method = "post">
<h1>Delete Project</h1>
<table style = "width:10%" border ="1">
	<tr>
	<td><input type = "text" name = "name" placeholder = "Enter Project Name"/></td>	
	<td><button value = "Delete" style = "background:red ; padding:10px;
 border-radius:20px; color:white; font-size: 15px;">Delete</button></td>
	</tr>
	</table>
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