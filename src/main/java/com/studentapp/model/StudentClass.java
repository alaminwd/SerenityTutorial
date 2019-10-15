package com.studentapp.model;

import java.util.List;

public class StudentClass {

	private int id ;
	
	private String firstName;
	private String lastName;
	private String email;
	private String programme;
	private List <String> courses;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id =id;
	}
	
	public String getFirstName() {
		
		return firstName;
	}
	
	public void SetFirstName(String FirstName) {
		
		 this.firstName =FirstName;
	}
	
	public String getLastName() {
		
		return firstName;
	}
	
	public void SetLastName(String LastName) {
		
		 this.lastName =LastName;
	}	
	
	public String getemail() {
		return email;
	}
	
	public void setemail(String email) {
		
		this.email=email;
	}
	public String getprogramme() {
		
		return programme;
	}
	
	public void setprogramme(String programme) {
		
		this.programme=programme;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
}

