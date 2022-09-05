package com.employeemanagementsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeemanagementsystem.dao.EmployeeDao;
import com.employeemanagementsystem.model.Employee;
import com.employeemanagementsystem.model.Project;

@WebServlet("/deleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao empDao = new EmployeeDao();
//		Employee emp = new Employee();
		String input = request.getParameter("name");
		if (!input.isEmpty()) {
			Project.setInput(input);
			int check = empDao.deleteEmployee();
			System.out.println(check);
			if (check > 0) {
				request.setAttribute("message", "Deleted Successfully!!");

			} else {
				request.setAttribute("message", "Please Enter Valid PROJECT/EMAIL Name");
			}
		} else {
			request.setAttribute("message", "Please Enter Field");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/deleteEmployee.jsp");
		rd.forward(request, response);

	}
}
