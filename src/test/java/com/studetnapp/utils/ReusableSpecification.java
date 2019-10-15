package com.studetnapp.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

public class ReusableSpecification {

	public static RequestSpecBuilder reqspc;
	public static RequestSpecification requestSpecification;
	
	public static ResponseSpecBuilder respons;
	public static ResponseSpecification responseSpacification;
	public static RequestSpecification GetGenericRequest() {
		
		reqspc = new RequestSpecBuilder();
		reqspc.setContentType(ContentType.JSON);
		requestSpecification=reqspc.build();
		return requestSpecification;
		
		
		
	}
	
	public static ResponseSpecification GetGenericresponse() {
		
		respons = new ResponseSpecBuilder();
		respons.expectHeader("Content-Type","application/json;charset-UTF-8"); 
		respons.expectHeader("Transfer-Encoding","chunked");
		respons.expectResponseTime(lessThan(5L),TimeUnit.SECONDS);
		responseSpacification=respons.build();
		return null;
		
		
	}
	
	
}
