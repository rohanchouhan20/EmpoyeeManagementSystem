<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<!-- <link rel="stylesheet" href ="style1.css">-->
</head>
<body bgcolor="cyan">
	<div align="center">
		<form class="box" action="Authentification" method="post">
			<h1>Welcome to Login Page</h1>
			<table style="width: 10%" border="1">
				<tr>
					<td>Email</td>
					<td><input type="email" name="email"
						placeholder="Enter your email"
						pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"
						placeholder="Enter your password"
						title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" /></td>
				</tr>
			</table>
			<br>
			<!-- <input type = "submit" value = "Login"/>  -->
			<button value="Login"
				style="background: red; padding: 1px; border-radius: 20px; color: white; font-size: 25px;">Login</button>
		</form>
		<h4>
			Not Registered then <a href="index.jsp">Go-To-Register</a>
		</h4>
		<%
			if (request.getAttribute("message") != null) {
		%>
		<h2><%=request.getAttribute("message")%><h2>
				<%
					}
				%>
			
	</div>
</body>
</html>