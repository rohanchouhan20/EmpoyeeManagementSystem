package com.employeemanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.employeemanagementsystem.dbconnector.DBConnector;
import com.employeemanagementsystem.model.Employee;

public class LoginAuthentification {

	public boolean isLogin(Employee emp) {
		if (emp.getEmail().isEmpty() && emp.getPassword().isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean isRegistered(String name, String email, String password) {
		if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public Employee isCorrect(Employee emp) {
		System.out.println("INSIDE IsCorrect");
		Statement st;
		ResultSet rs;
		String email = emp.getEmail(); 
		String password = emp.getPassword(); 
		System.out.println("isCorrect = "+email);
		System.out.println("isCorrect = "+password);
		try {
			st = DBConnector.getStatement();
			String query = "Select * from role where Email = '" + email + "' && Password = '" + password + "'";
			System.out.println("query = " + query);
			System.out.println("Above RS");
			rs = st.executeQuery(query);
			System.out.println("Below RS");
			if(rs.next()) {
			Employee savedEmp = new Employee();
			savedEmp.setEmail(email);
			savedEmp.setPassword(password);
			savedEmp.setName(rs.getString(2));
			savedEmp.setId(rs.getString("Id"));
			return savedEmp;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
}}
