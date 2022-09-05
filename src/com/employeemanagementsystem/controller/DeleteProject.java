package com.employeemanagementsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeemanagementsystem.dao.EmployeeDao;
import com.employeemanagementsystem.dao.ProjectDAO;
import com.employeemanagementsystem.model.Employee;


@WebServlet("/DeleteProject")
public class DeleteProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		EmployeeDao empDao = new EmployeeDao(); 
		ProjectDAO projectDao = new ProjectDAO();
		Employee emp = new Employee();
		String projectName = request.getParameter("name");
		System.out.println(projectName);
		if(!projectName.isEmpty()){	
		System.out.println("INSIDE");
		emp.setName(projectName);
		int check = projectDao.deleteProject(emp);
		if(check>0) {
			request.setAttribute("message", "Deleted Successfully!!");

		} else {
			request.setAttribute("message", "Unsuccessfull");
		}
	} else {
		request.setAttribute("message", "Please Enter Field");
	}
	RequestDispatcher rd = request.getRequestDispatcher("/deleteProject.jsp");
	rd.forward(request, response);

}
}
