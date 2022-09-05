<%@page import="com.employeemanagementsystem.dbconnector.DBConnector"%>
<%@page import="java.sql.*"%>
<%@page import="com.employeemanagementsystem.dao.EmployeeDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.employeemanagementsystem.model.Employee"%>
<%@page import="com.employeemanagementsystem.dao.ProjectDAO"%>

<%-- <%@page import ="com.controller.DBConnector" %> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<title>This is Your Employee ADD SECTION</title>
</head>
<body bgcolor = "cyan">
<div align = "center">
<h2>Enter Below Details to Add Employee</h2>
<form class = "box" action = "AddEmployeeInProject" method = "post">
<table  style = "widht:100%" border ="1">
   
<%ProjectDAO pd = new ProjectDAO();
List<String> list = pd.getAllProjectName();
%>
	<tr>
	<td colspan = "2">
	<p><strong>ADD EMPLOYEE IN PROJECT:<strong>
	<SELECT name = "project">
	<%for(String v:list){ %>
		<option><%=v%></option>
		<%} %>
	</SELECT>
	</p>
	</td>
	</tr>
	<tr>
	<th colspan = "3"><strong>LIST OF ALL AVALABLE EMPLOYEE'S</strong></th></tr>
			<tr>
			<td><strong>Name</strong></td>
			<td><strong>Email</strong></td>
			<td><strong>Select</strong></td>
			</tr>
	<%
		EmployeeDao emp = new EmployeeDao();
		List<Employee> listOfUser = emp.getAllUserData();
		System.out.println(listOfUser);
		Iterator<Employee> iterator = listOfUser.iterator();
		while(iterator.hasNext()){
			Employee empDao = iterator.next();
		%>
	<tr><td><strong><%=empDao.getName()%></strong></td>
	<td><strong><%=empDao.getEmail()%></strong></td>
	<td><strong><input type= "checkbox" name = "selectedEmp" value = "<%=empDao.getEmail()%>"></strong></td>
	</tr>
	<%} %>	
</table>
</div>
<div align = "center">
	
</div>
<div align = "center">
	<button value = "ADD" style = "background:red ; padding:10px;
 border-radius:20px; color:white; font-size: 20px;">ADD</button> 
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