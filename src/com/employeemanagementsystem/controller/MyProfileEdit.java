package com.employeemanagementsystem.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeemanagementsystem.dao.EmployeeDao;
import com.employeemanagementsystem.model.Employee;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/myProfileEdit")
public class MyProfileEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao employeedao = new EmployeeDao();
		Employee employee = new Employee();
		HttpSession session = request.getSession(true);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String userId = (String) session.getAttribute("userId");
		employee.setName(name);
		employee.setEmail(email);
		employee.setId(userId);

		RequestDispatcher rd = null;
		if (!name.isEmpty() && !email.isEmpty()) {
			try {
				int value = employeedao.profileUpdate(employee);
				System.out.println(value);
				if (value > 0) {
					session.setAttribute("name", name);
					session.setAttribute("email", email);
					request.setAttribute("message", "Update Successfully");
					rd = request.getRequestDispatcher("/myProfile.jsp");
				} else {
					request.setAttribute("message", "Not Update Successfully");
					rd = request.getRequestDispatcher("/editUserProfile.jsp");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("message", "Please Enter Fields");
			rd = request.getRequestDispatcher("/editUserProfile.jsp");
		}
		rd.forward(request, response);
	}
}
