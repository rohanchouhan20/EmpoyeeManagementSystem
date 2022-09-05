package com.employeemanagementsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employeemanagementsystem.dbconnector.DBConnector;
import com.employeemanagementsystem.model.Employee;
import com.employeemanagementsystem.model.Project;
import com.employeemanagementsystem.model.ProjectModel;

public class ProjectDAO {
	private Connection con = null;

	public ProjectDAO() {
		con = DBConnector.getConnection();
	}
	public List<Employee> displayProjectEmployee() throws ClassNotFoundException {
		List<Employee> listOfUsers = new ArrayList<Employee>();
		String input = Project.getInput();
		String project = Project.getProject();
		System.out.println("displayProjectEmployee():- " + input);
		System.out.println("displayProjectEmployee():- " + project);
		try {
			Connection con = DBConnector.getConnection();
			String query = "SELECT role.Name, empproject.Email, empproject.EmpProject FROM role INNER JOIN empproject ON role.Id = empproject.Id WHERE empproject.EmpProject =? OR role.Name =?";
			System.out.println("displayProjectEmployee()" + query);
			PreparedStatement preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1, project);
			preparedStatement.setString(2, input);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setName(rs.getString(1));
				emp.setEmail(rs.getString(2));
				emp.setProject(rs.getString(3));
				listOfUsers.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfUsers;
	}
	public int deleteProject(Employee emp) {
		String projectName = emp.getName();
		System.out.println(projectName);
		int projectId = getProjectId(projectName);
		System.out.println(projectId);
		try {
			Connection con = DBConnector.getConnection();
			String query = "DELETE from projects where project_Id = ?";
			
			PreparedStatement prepareStatement = con.prepareStatement(query);
			prepareStatement.setInt(1, projectId);
			System.out.println("Query = " + query);
			int rs = prepareStatement.executeUpdate();
			System.out.println("RS = " + rs);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	// --------------END---------------------------------------------------------------------------------------

	private int getProjectId(String projectName){
		try {
			Connection con = DBConnector.getConnection();
			String query = "Select project_Id from projects where project_name= ?";
			
			PreparedStatement prepareStatement = con.prepareStatement(query);
			prepareStatement.setString(1, projectName);
			System.out.println("Query = " + query);
			ResultSet rs = prepareStatement.executeQuery();
			System.out.println("RS = " + rs);
			if (rs.next()) {
				
				int projectId =Integer.parseInt(rs.getString(1));
				return projectId;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int addNewProject(ProjectModel pm) {
		String query = "INSERT into projects (project_name,client,technology) VALUES(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, pm.getProjectName());
			ps.setString(2, pm.getProjectClient());
			ps.setString(3, pm.getProjectTechnology());
			int rs = ps.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<String> getAllProjectName() {
		List<String> listOfProjects = new ArrayList<String>();
		String query = "SELECT * from projects";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				listOfProjects.add(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfProjects;
	}
	
	public int addEmployeeInProject(Employee emp, List<String> selectedEmp) throws ClassNotFoundException

	{
//		List<Employee> listOfProjects = new ArrayList<Employee>();
		System.out.println("----INSIDE POST----");
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "root");
			String getProjectQuery = "select project_id from projects where project_name = ?";

			for (int i = 0; i < selectedEmp.size(); i++) {
				String query = "INSERT into empproject (Id,project_Id,EmpProject,Email) values((Select Id from role where Email = ?),(Select project_Id from projects where project_name = ?),?,?)";
				PreparedStatement preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, selectedEmp.get(i));
				preparedStatement.setString(2, emp.getProject());
				preparedStatement.setString(3, emp.getProject());
				preparedStatement.setString(4, selectedEmp.get(i));
				System.out.println(selectedEmp.get(i));
				System.out.println(emp.getProject());
				result = preparedStatement.executeUpdate();
				System.out.println("1R" + result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}

//	public List<Employee> getAllProjectData() throws ClassNotFoundException {
//		List<Employee> listOfUsers = new ArrayList<Employee>();
//		try {
//			Connection con = DBConnector.getConnection();
//			String query = "SELECT role.Name,role.Email FROM role INNER JOIN empproject ON role.Id = empproject.Id where empproject.EmpProject = ? OR role.Name = ?";
//			PreparedStatement preparedStatement = con.prepareStatement(query);
//			ResultSet rs = preparedStatement.executeQuery(query);
//			preparedStatement.setString(1, Project.getProject());
//			preparedStatement.setString(2, Project.getInput());
//			while (rs.next()) {
//				Employee emp = new Employee();
//				emp.setId(rs.getString(1));
//				emp.setName(rs.getString(2));
//				emp.setEmail(rs.getString(3));
//				emp.setPassword(rs.getString(4));
//				emp.setRole(rs.getString(5));
//				listOfUsers.add(emp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return listOfUsers;
//	}