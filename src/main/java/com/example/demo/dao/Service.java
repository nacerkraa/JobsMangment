package com.example.demo.dao;



public class Service {
	private int id;
	private String title;
	private String description;
	private String location;
	private String emailUser;
	
	
	public Service() {
		super();
	}


	


	public Service(String title, String description, String location, String emailUser) {
		super();
		this.title = title;
		this.description = description;
		this.location = location;
		this.emailUser = emailUser;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}





	public String getEmailUser() {
		return emailUser;
	}





	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}


	
	
	
	
	
}