package com.restassured.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.restassured.endpoints.UserEndPoint;
import com.restassured.payload.User;

import io.restassured.response.Response;

public class UserTest {

	Faker faker;
	User userpayload;

	@BeforeClass
	public void setupDeta() {

		faker = new Faker();
		userpayload = new User();

		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());

	}
	
	@Test(priority=1)
	public void testPostUser() {
		
		Response response = UserEndPoint.createUser(userpayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	@Test(priority=2)
	public void testGetUserName() {
		
		Response response =UserEndPoint.readUser(this.userpayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=3)
	public void testUpdateByUserName() {
		
		//update data using payload
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoint.updateUser(this.userpayload.getUsername(), userpayload);
		response.then().log().all();
		response.then().log().body().statusCode(200); // It is one type of assertion which is come from the restassured
		
		Assert.assertEquals(response.getStatusCode(), 200); // testNG assertion
		
		// Checking data after update
		
		Response responseAfterupdate =UserEndPoint.readUser(this.userpayload.getUsername());
		Assert.assertEquals(responseAfterupdate.getStatusCode(), 200);
		
	}
	
	
	@Test(priority=4)
	public void testDeleteUser() {
		
		Response response = UserEndPoint.deleteUser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
	
	
	

}
