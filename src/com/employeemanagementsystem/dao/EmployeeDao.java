package com.employeemanagementsystem.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeemanagementsystem.dbconnector.DBConnector;
import com.employeemanagementsystem.model.Employee;
import com.employeemanagementsystem.model.Project;

public class EmployeeDao {


	public int deleteEmployee() {
		String userInput = Project.getInput();
		System.out.println(userInput);
		try {
			Connection con = DBConnector.getConnection();
			String query = "DELETE FROM role where Email =?";
			PreparedStatement prepareStatement = con.prepareStatement(query);
			prepareStatement.setString(1, userInput);
			System.out.println("Query" + query);
			int rs = prepareStatement.executeUpdate();
			System.out.println("RS" + rs);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Employee getUserData(String username) {
		Employee emp = new Employee();
		try {
			Statement st = DBConnector.getStatement();
			String query = "SELECT * FROM role WHERE email = '" + username + "'";
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				emp.setId(rs.getString(1));
				emp.setName(rs.getString(2));
				emp.setName(rs.getString(3));
				emp.setName(rs.getString(4));
				emp.setName(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public List<Employee> getAllUserData() throws ClassNotFoundException {
		List<Employee> listOfUsers = new ArrayList<Employee>();
		try {
			Connection con = DBConnector.getConnection();
			String query = "SELECT * from role where Role = 'employee';";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery(query);
//			preparedStatement.setString(1, Project.getProject());
//			preparedStatement.setString(2, Project.getInput());
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getString(1));
				emp.setName(rs.getString(2));
				emp.setEmail(rs.getString(3));
				emp.setPassword(rs.getString(4));
				emp.setRole(rs.getString(5));
				listOfUsers.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfUsers;
	}


	public int registerEmployee(Employee employee) throws ClassNotFoundException

	{
		String query = "INSERT into role (Name, Email, Password, Role) values(?,?,?,?)";
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "root");

			PreparedStatement preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getEmail());
			preparedStatement.setString(3, employee.getPassword());
			preparedStatement.setString(4, employee.getRole());

			result = preparedStatement.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int profileUpdate(Employee employee) throws ClassNotFoundException

	{
		String query = "UPDATE role SET Name = ?, Email = ? where Id = ?";
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "root");

			PreparedStatement preparedStatement = con.prepareStatement(query);
			System.out.println("Name - " + employee.getName());
			System.out.println("Email - " + employee.getEmail());
			System.out.println("ID - " + employee.getId());

			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getEmail());
			preparedStatement.setString(3, employee.getId());
			result = preparedStatement.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int passwordUpdate(Employee employee) throws ClassNotFoundException

	{
		String query = "UPDATE role SET password = ? where Id = ?";
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "root");

			PreparedStatement preparedStatement = con.prepareStatement(query);
			System.out.println("empID" + employee.getId());
			System.out.println("emppass" + employee.getPassword());
			preparedStatement.setString(1, employee.getPassword());
			preparedStatement.setString(2, employee.getId());
			result = preparedStatement.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


}
