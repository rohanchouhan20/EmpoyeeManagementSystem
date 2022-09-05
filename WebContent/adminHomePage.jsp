<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home Page</title>
</head>
<body bgcolor = cyan>
<div align = "center">
<%

String currentUser = String.valueOf(session.getAttribute("email"));
System.out.println(currentUser);
if(currentUser == null) {
System.out.println("Inside Current");
	%>
	<h2>Please login first to access this page<h2>
	<%return;
}
if(request.getAttribute("message")!=null){%>
<h2><%=request.getAttribute("message")%><h2>	
<%}%>
<h2><%	
	   	
       if(session.getAttribute("name")!=null)
       {
  		String username = (String)session.getAttribute("name");
	   out.println("This is "+username+"'s Home Page");	
       
%></h2>
<%-- <h2>${name}'s</h2> --%>
	<h3><a href = "myProfile.jsp">My Profile</a></h3>
</div>
<div align = "center">
	<h3><a href = "addEmployeeInProject.jsp">Add Employee in Project</a></h3>
</div>
<div align = "center">
	<h3><a href = "displayEmployee.jsp">View Employee</a></h3>
</div>
<div align = "center">
	<h3><a href = "deleteEmployee.jsp">Delete Employee</a></h3>
</div>
<div align = "center">
	<h3><a href = "addMoreProject.jsp">Add More Project</a></h3>
</div>
<div align = "center">
	<h3><a href = "deleteProject.jsp">Delete Project</a></h3>
</div>
<div align = "center">
	<h3><a href = "logout.jsp">Logout</a></h3>
</div>
   <%}
       else{
    	   response.sendRedirect("login.jsp");
       }%>
</body>
</html>