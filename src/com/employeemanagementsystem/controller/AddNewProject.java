package com.employeemanagementsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeemanagementsystem.dao.ProjectDAO;
import com.employeemanagementsystem.model.ProjectModel;

@WebServlet("/AddNewProject")
public class AddNewProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String projectName = request.getParameter("name");
		String clientName = request.getParameter("client");
		String technology = request.getParameter("technology");
		System.out.println("PN" + projectName);
		if (!projectName.equals("") && !clientName.equals("") && !technology.equals("")) {
			ProjectModel pm = new ProjectModel(projectName, clientName, technology);
			ProjectDAO pd = new ProjectDAO();
			int value = pd.addNewProject(pm);
			System.out.println(value);
			if (value > 0) {
				System.out.println("Inside");
				request.setAttribute("message", "SuccessfullyAdded");

			} else {
				request.setAttribute("message", "Unsuccessfull");

			}
		} else {
			request.setAttribute("message", "Please Fill ALL FIELDS");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/addMoreProject.jsp");
		rd.forward(request, response);
	}

}
