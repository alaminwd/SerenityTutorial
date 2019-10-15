package StudentApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;

@RunWith(SerenityRunner.class)
public class FirstserenityTest {

	@BeforeClass
	
	public static void limit() {
		RestAssured.baseURI="http://localhost:8080/student";
	}
	
	
	@Test
	
	public void GetAllstudent() {
		SerenityRest.given()
		
		.when()
			.get("/list")
			
		.then()
		.statusCode(200)
		.log().all();
		
	}
	

	@Test
	
	public void TcsFailing() {
		SerenityRest.given()
		
		.when()
			.get("/list")
			
		.then()
		.statusCode(300)
		.log().all();
		
	}
	
	@Pending
	@Test
	
	public void TcsPENDING() {
		
	}
	
	@Ignore
	@Test
	
	public void Tcsignore() {
		
	}
	
	@Test
	
	public void TcwithError() {
		System.out.println("this is a error"+(5/0));
	}
	
	@Test
	
	public void FileNotfound() throws FileNotFoundException {
	File file= new File("E:HTIS");
	FileReader fr =new FileReader(file);
	}
	
	@Manual
	@Test
	
	public void Tcsmanual() {
		
	}
	
}
