	package com.employeemanagementsystem.model;

public class ProjectModel {
	private int projectId;
	private String projectName;
	private String projectClient;
	private String projectTechnology;
	
	public ProjectModel(String projectName, String projectClient, String projectTechnology) {
		super();
		this.projectName = projectName;
		this.projectClient = projectClient;
		this.projectTechnology = projectTechnology;
	}
	public ProjectModel(int projectId, String projectName, String projectClient, String projectTechnology) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectClient = projectClient;
		this.projectTechnology = projectTechnology;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectClient() {
		return projectClient;
	}
	public void setProjectClient(String projectClient) {
		this.projectClient = projectClient;
	}
	public String getProjectTechnology() {
		return projectTechnology;
	}
	public void setProjectTechnology(String projectTechnology) {
		this.projectTechnology = projectTechnology;
	}
}
