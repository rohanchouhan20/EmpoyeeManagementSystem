package com.employeemanagementsystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeemanagementsystem.dao.EmployeeDao;


@WebServlet("/MyProfileUpdate")
public class MyProfileUpdate extends HttpServlet {
	EmployeeDao employeedao = new EmployeeDao();
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    		PrintWriter out = response.getWriter();
//    	String print = (String) request.getAttribute("name");
//    	out.println("Name - "+print);
    	Statement st;
    	ResultSet rs;
    	String name = request.getParameter("name");
    	String email = request.getParameter("email");
    	String id = request.getParameter("id");
    	{
    		String query = "UPDATE role SET Name = ?, Email = ? where id=?;";
    		try {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","root");
    		
    			PreparedStatement preparedStatement = con.prepareStatement(query);
    			 	
    			preparedStatement.setString(1,name);
    			preparedStatement.setString(2,email);
    			preparedStatement.setString(3,id);
    			
    			preparedStatement.executeUpdate();
    	    	}catch(SQLException e) 
    				{
    	    		e.printStackTrace();
    				}
    			catch(ClassNotFoundException e) 
    			{
    				e.printStackTrace();
    			}
    		 }
	}

}
