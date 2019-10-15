package StudentApp;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.internal.MethodSorter;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.studentapp.cucumber.serenity.StudentSerinitySteps;
import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;
import com.studetnapp.utils.TestUtils;

import net.serenitybdd.junit.runners.SerenityRunner;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentCurd extends TestBase {

	static String firstName = "tSMOKEUSER"+TestUtils.getRandomValue();
	static String lastName = "SMtOKEUSER"+TestUtils.getRandomValue();
	static String programme = "CotmputerScience";
	static String email =TestUtils.getRandomValue()+"xyz@gmaitl.com"; 
	static int Studentid;
	
	@Steps
	StudentSerinitySteps steps;
	
	
	@Title("this test will create a new studen")
	@Test
	public void test001() {
		
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		
		steps.createSteps(firstName, lastName, email, programme, courses)
		.statusCode(201);
		
		
	}
	
	@Title("Verify if the Student was added to the application")
	@Test
	public void test002() {
		
		
		HashMap<String,Object>value =steps.getStudentifoByfirstname(firstName);
		
		System.out.println("the value is :"+value);
		
		assertThat(value,hasValue(firstName));
		Studentid =(int) value.get("id");
	}
	
	@Title("update the user information")
	@Test
	public void test003(){
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		
		firstName=firstName+"Updated";
				
			steps.UpdateStudent(Studentid, firstName, lastName, email, programme, courses);
				
				String p1 = "findAll{it.firstName=='";
				String p2 = "'}.get(0)";
				
	HashMap<String,Object>value =steps.getStudentifoByfirstname(firstName);
				
				
								
				assertThat(value,hasValue(firstName));

	}
	@Title("Delete Student ID")
	@Test
	public void test004() {
		
		steps.delteStudent(Studentid);		
		steps.getStudentbyId(Studentid).statusCode(404);

	
	}
	
	
}
