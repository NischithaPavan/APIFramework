package com.employeeApi.testcases;



import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeApi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TestCase_001 extends TestBase {
	
	@BeforeClass
	
	public void getAllEmplyoess() {
		logger.info("***********Started Tc_001_GetAllEmployess*********");
		RestAssured.baseURI="https://reqres.in";
		httprequest = RestAssured.given();
		response=httprequest.request(Method.GET,"api/users/2");
	}
	
	@Test
	public void verifyresponsebody() {
		logger.info("***********Checking response body**********");

		String responsebody=response.getBody().asString();
		logger.info("Response body==>" +responsebody);
		Assert.assertTrue(responsebody!=null);
	}
	
	@Test
	public void verifyStatusCode() {
		logger.info("***********Checking Status code**********");

		int statuscode=response.statusCode();
		logger.info("Status code==>"+statuscode);
		Assert.assertEquals(statuscode,200);
		
	}
	@Test
	public void verifyResponseTime() {
		logger.info("***********Checking response time**********");

		long responseTime=response.getTime();
		logger.info("responseTime==>"+responseTime);
		if(responseTime>2000)
        logger.warn("Response time is greater than 2000");
		Assert.assertTrue(responseTime<2000);
		
	}
	@Test
	public void verifyStatusline() {
		logger.info("***********Checking Status line**********");
		String statusline=response.getStatusLine();
		logger.info("StatusLine==>"+statusline);
       Assert.assertEquals(statusline, "HTTP/1.1 200 OK");

	}
	
	
	
	
	

}
