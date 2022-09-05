package com.employeemanagementsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeemanagementsystem.dao.EmployeeDao;
import com.employeemanagementsystem.dao.LoginAuthentification;
import com.employeemanagementsystem.model.Employee;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDao employeedao = new EmployeeDao();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Employee employee = new Employee();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		RequestDispatcher rd = null;
		LoginAuthentification la = new LoginAuthentification();
		boolean isRegister = la.isRegistered(name, email, password);
		if (isRegister) {
			request.setAttribute("message", "PLEASE ENTER ALL THE FIELDS");
			rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		} else if (role == "employee") {
			employee.setName(name);
			employee.setEmail(email);
			employee.setPassword(password);
			employee.setRole(role);
			request.setAttribute("message", "Login Successful");
			rd = request.getRequestDispatcher("addEmployeeInProject.jsp");
			rd.forward(request, response);
		} else {
			employee.setName(name);
			employee.setEmail(email);
			employee.setPassword(password);
			employee.setRole(role);
			try {
				int value = employeedao.registerEmployee(employee);
				System.out.println(value);
				if (value > 0) {
					request.setAttribute("message", "REGISTERED SUCCESSFULLY NOW LOGIN");
					rd = request.getRequestDispatcher("/login.jsp");
				} else {
					request.setAttribute("message", "ENTER CORRECT USERNAME AND PASSWORD");
					rd = request.getRequestDispatcher("/index.jsp");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			rd.forward(request, response);
		}
	}

}
