<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This is Your PROFILE SECTION</title>
</head>
<body bgcolor = "cyan">
<div align = "center">
<form class = "box" action = "MyProfileUpdate" method = "post">
<table  style = "widht:100%" border ="1">
   
	<tr>
	<th>Name</th>
	<td><h4>
	<%String username = (String)session.getAttribute("name");
	out.println(username);%>
	   	</h4></td>
	<td rowspan = "2"><h4><a href = "editUserProfile.jsp">Edit Profile</a></h4></td>
	</tr>
	<tr>
	<th>Email</th>	
	<td><h4>
	<%String useremail = (String)session.getAttribute("email");
	   	out.println(useremail);%>
	</h4></td>
	</tr>
</table>
</form>
</div>

<div align = "center">
<h4><a href = "resetPassword.jsp">Reset-Password</a></h4>
<h4><a href = "adminHomePage.jsp">HOME-PAGE</a></h4>
<%if(request.getAttribute("message")!=null){%>
<h2><%=request.getAttribute("message")%><h2>	
<%}%>
</div>
</body>
</html>