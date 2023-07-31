package com.restassured.endpoints;


/*Swagger URL  --> Create user(post) : https://petstore.swagger.io/v2

Create user(post) : https://petstore.swagger.io/v2/user
Get user(post) : https://petstore.swagger.io/v2/user/{username}
Update user(post) : https://petstore.swagger.io/v2/user/{username}
Delete user(post) : https://petstore.swagger.io/v2/user/{username}
		*/
	

public class Routes {
	
	//base URL
	
	public static String base_url= "https://petstore.swagger.io/v2";
	
	//User module API
	
	public static String post_url= base_url +"/user";
	public static String get_url = base_url +"/user/{username}";
	public static String update_url = base_url +"/user/{username}";
	public static String delete_url = base_url +"/user/{username}";
	
	// store module
	
	     // Here you will create Store module URL's
	
	
	//pet module
	
	   //Here you will create pet module URL's
	
	

}
