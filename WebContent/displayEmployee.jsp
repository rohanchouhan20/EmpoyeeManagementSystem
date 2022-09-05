<%@page import="com.employeemanagementsystem.dbconnector.DBConnector"%>
<%@page import="java.sql.*"%>
<%@page import="com.employeemanagementsystem.dao.EmployeeDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.employeemanagementsystem.model.Employee"%>
<%@page import="com.employeemanagementsystem.dao.ProjectDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Employee Page</title>
</head>
<body bgcolor = "cyan">
<div align = center>
<form action="SearchEmployee" method = "post">
<h1>Employee Display Page</h1>
<%ProjectDAO pd = new ProjectDAO();
List<String> list = pd.getAllProjectName();
%>
<table border = "1">
<tr>
<td><input type = text name = "searchBar" placeholder = "Search here"></input></td>
 <td>
	<SELECT name = "project">
	<option>none</option>
	<%for(String v:list){ %>
		<option><%=v%></option>
		<%} %>
	</SELECT>
	</td>
	</tr>
<tr><td></td>
	<td align = center><button value = "Search">Search</td></tr>
</table>
	<div>
<table border ="1">
<tr>
	<%	
	String value =request.getParameter("one");
	if(value!=null){
	if(value.equals("true")){%>
		<td><strong>Name</strong></td>
		<td><strong>Email</strong></td>
		<td><strong>ProjectName</strong></td>
		</tr>
<%	ProjectDAO projectDao = new ProjectDAO();
	List<Employee> listOfUser = projectDao.displayProjectEmployee();
	Iterator<Employee> iterator = listOfUser.iterator();
	while(iterator.hasNext()){
		Employee empDao = iterator.next();
	%>
	<tr><td><strong><%=empDao.getName()%></strong></td>
	<td><strong><%=empDao.getEmail()%></strong></td>
	<td><strong><%=empDao.getProject()%></strong></td>
	</tr>
	<%}}}%>
	</table>
	</div>
</form>	
	<h3><a href= "adminHomePage.jsp">HOME-PAGE</a></h3>
</div>
</body>
</html>