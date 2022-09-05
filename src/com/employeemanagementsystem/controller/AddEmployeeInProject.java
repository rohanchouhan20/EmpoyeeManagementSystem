	package com.employeemanagementsystem.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeemanagementsystem.dao.EmployeeDao;
import com.employeemanagementsystem.dao.ProjectDAO;
import com.employeemanagementsystem.model.Employee;


@WebServlet("/AddEmployeeInProject")
public class AddEmployeeInProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	ProjectDAO projectDao = new ProjectDAO();

	Employee emp = new Employee(); 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String project = request.getParameter("project");
		String selectedEmail[] = request.getParameterValues("selectedEmp");
		if (selectedEmail!=null){
		List<String> selectedEmp =Arrays.asList(selectedEmail);
		emp.setProject(project);
		
		System.out.println(selectedEmp);
		try {
			int value = projectDao.addEmployeeInProject(emp,selectedEmp);
			
			if(value>0) {
				request.setAttribute("message", "SuccessfullyAdded");
				
			} else {
				request.setAttribute("message", "Already Added In Other Project");
				
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}else {
		request.setAttribute("message", "Please Select Any Employee");
	}
	RequestDispatcher rd = request.getRequestDispatcher("/addEmployeeInProject.jsp");
	rd.forward(request, response);

}}
