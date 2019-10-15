package com.studentapp.junit.studentinfo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.cucumber.serenity.StudentSerinitySteps;
import com.studentapp.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
@Concurrent(threads="4x")
@UseTestDataFrom("C:\\Users\\Ahmed Anik\\eclipse-workspace\\StudentApp\\resouce\\newtestdata\\StudentInfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentDatadrivent extends TestBase {
	
	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProgramme() {
		return programme;
	}
	public void setProgramme(String programme) {
		this.programme = programme;
	}
	public String getCourses() {
		return course;
	}
	public void setCourses(String courses) {
		this.course = courses;
	}
	public StudentSerinitySteps getSteps() {
		return steps;
	}
	public void setSteps(StudentSerinitySteps steps) {
		this.steps = steps;
	}
	private String lastName;
	private String email;
	private String programme;
	private String course;
	
	@Steps
	StudentSerinitySteps steps;
	@Title("DataDriven Test for adding multiple students to the student app")
	@Test
	public void createMultipleStudent() {
		
		ArrayList<String>courses = new ArrayList<>();
		courses.add(course);
		steps.createSteps(firstName, lastName, email, programme, courses)
		.statusCode(201);
		
	}
}
