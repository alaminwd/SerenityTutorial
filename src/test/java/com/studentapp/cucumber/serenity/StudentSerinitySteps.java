package com.studentapp.cucumber.serenity;

import java.util.HashMap;
import java.util.List;

import com.studentapp.model.StudentClass;
import com.studetnapp.utils.ReusableSpecification;
import com.studetnapp.utils.*;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StudentSerinitySteps {

	
	@Step("crating student with firstName:{0},lstName:{1},emil:{2},programme:{3}")
	public ValidatableResponse createSteps(String firstName,String lastName,String email,String programme,List<String>courses) {
		
		
		

		StudentClass student = new StudentClass();
		
		student.SetFirstName(firstName);
		student.SetLastName(lastName);
		student.setemail(email);
		student.setprogramme(programme);
		student.setCourses(courses);
		
		
				
				return SerenityRest.given()
				.spec(ReusableSpecification.GetGenericRequest())
				.when()
				.body(student)
				.post()
				.then();
	}
	
	
	@Step("Getting the studetn inforamtion with first name {0}")
	public HashMap<String,Object> getStudentifoByfirstname(String firstName){
		String p1 = "findAll{it.firstName=='";
		String p2 = "'}.get(0)";
		
		return SerenityRest.given()
				.when()
					.get("/list")
				.then()
				.statusCode(200)
				.extract()
				.path(p1+firstName+p2);

	}
	
	@Step("Updating student information with with studentid={0},firstName={1},lastname={2},email={3},programme={4}")
	
public ValidatableResponse UpdateStudent(int Studentid,String firstName,String lastName,String email,String programme,List<String>courses) {
		
		StudentClass student = new StudentClass();
		
		student.SetFirstName(firstName);
		student.SetLastName(lastName);
		student.setemail(email);
		student.setprogramme(programme);
		student.setCourses(courses);
		
		
				
				return 
						SerenityRest.given()
						.contentType(ContentType.JSON)
						
						.log().all()
						.when()
						.body(student)
						.put("/"+Studentid)
						.then();
	}
	
	@Step("Deleting student information with ID: {0}")
	public void delteStudent(int Studentid) {
		
SerenityRest.given()	
		.when()
		.delete("/"+Studentid);

	}
	
	@Step("Deleting student information with ID: {0}")
	public ValidatableResponse getStudentbyId(int Studentid) {
		
return SerenityRest.given()	
		.when()
		.get("/"+Studentid)
		.then();

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
