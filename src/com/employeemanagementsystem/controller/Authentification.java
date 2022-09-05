package com.employeemanagementsystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanagementsystem.dao.EmployeeDao;
import com.employeemanagementsystem.dao.LoginAuthentification;
import com.employeemanagementsystem.dbconnector.DBConnector;
import com.employeemanagementsystem.model.Employee;
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	Statement st;
	ResultSet rs;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("logout.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String output = "false";
		Employee emp = new Employee();
		EmployeeDao empDao = new EmployeeDao();
		LoginAuthentification la = new LoginAuthentification();
		emp.setEmail(email);
		emp.setPassword(password);
		RequestDispatcher rd = null;
		boolean login = la.isLogin(emp);
		System.out.println(login);
		HttpSession session = request.getSession(true);
		if (login) {
			request.setAttribute("message", "PLEASE ENTER ALL THE FIELDS");
			rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		} else {
			Employee empObj = la.isCorrect(emp);
			if(empObj!=null) {
				session.setAttribute("email", email);
				session.setAttribute("password", password);
				session.setAttribute("name", empObj.getName());
				session.setAttribute("userId", empObj.getId());
				request.setAttribute("message", "Login Successful");
				rd = request.getRequestDispatcher("/adminHomePage.jsp");
			}else{
				request.setAttribute("message", "Invalid Username/Password");
				rd = request.getRequestDispatcher("/login.jsp");
			}
		}
		rd.forward(request, response);
	}
}
