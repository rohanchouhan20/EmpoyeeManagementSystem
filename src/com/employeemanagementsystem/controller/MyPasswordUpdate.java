package com.employeemanagementsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanagementsystem.dao.EmployeeDao;
import com.employeemanagementsystem.model.Employee;

@WebServlet("/myPasswordUpdate")
public class MyPasswordUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPassword = request.getParameter("password");
		String newpassword = request.getParameter("newpassword");
		HttpSession session = request.getSession();
		String userpassword = (String) session.getAttribute("password");
		String userId = (String) session.getAttribute("userId");
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = new Employee();
		employee.setPassword(newpassword);
		employee.setId(userId);
		RequestDispatcher rd = null;
		if (!currentPassword.isEmpty() && !newpassword.isEmpty()) {
			try {
				System.out.println("Inside try");
				int value = employeeDao.passwordUpdate(employee);
				System.out.println(value);
				if (value > 0) {
//				response.sendRedirect("MyProfile.jsp");
					request.setAttribute("message", "Password Changed Successfully");
					rd = request.getRequestDispatcher("/myProfile.jsp");
				} else {
//			response.sendRedirect("resetPassword.jsp?output=true");
					request.setAttribute("message", "Password Not Changed");
					rd = request.getRequestDispatcher("/resetPassword.jsp");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("message", "Please Enter Fields");
			rd = request.getRequestDispatcher("/resetPassword.jsp");
		}
		rd.forward(request, response);
	}
}
