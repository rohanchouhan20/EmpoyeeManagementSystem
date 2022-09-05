 package com.employeemanagementsystem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanagementsystem.dao.EmployeeDao;
import com.employeemanagementsystem.model.Employee;
import com.employeemanagementsystem.model.Project;

@WebServlet("/SearchEmployee")
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao empDao = new EmployeeDao();
		String input = request.getParameter("searchBar");
		String projectName = request.getParameter("project");
		Project.setInput(input);
		Project.setProject(projectName);
		System.out.println(input);
		System.out.println(projectName);
		
		if(input!=null) {
			response.sendRedirect("displayEmployee.jsp?one=true");
		}else {
			response.sendRedirect("displayEmployee.jsp");		
	}
	}
}
