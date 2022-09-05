<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User Profile</title>
</head>
<body bgcolor = "cyan">
<div align = "center">
<form action = "myProfileEdit" method = "post">
<table style = "width:10%" border = "1">	
	<tr>
	<td>Name</td>
	<td><input type = "name" name = "name" 
	value = "<%String username = (String)session.getAttribute("name");
	   	out.println(username);%>"/></td>
	</tr>
	<tr>
	<td>Email</td>
	<td><input type = "email" name = "email" 
	value = "<%String useremail = (String)session.getAttribute("email");
	   				out.println(useremail);%>"/></td>
	</tr>
</table>
	<div align = "center">
	<button value = "Save Changes" style = "background:red ; padding:1px;
 border-radius:20px; color:white; font-size: 20px;">Save Changes</button> 
</div>
<div><h4><a href = "myProfile.jsp">Go-Back</a></h4></div>
<%-- <input type = text name = "userId" value = "<% String userId = (String)session.getAttribute("userId");
out.println(userId);
%>"> --%>
</form>
<%if(request.getAttribute("message")!=null){%>
<h2><%=request.getAttribute("message")%><h2>	
<%}%>
</div>
</body>
</html>