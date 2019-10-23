package com.capgemini.busschedulingspringrest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.busschedulingspringrest.beans.User;
import com.capgemini.busschedulingspringrest.service.AdminService;
import com.capgemini.busschedulingspringrest.service.AdminServiceImpl;
import com.capgemini.busschedulingspringrest.util.UserResponse;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {
	AdminService adminService=new AdminServiceImpl();
	@PostMapping("/login")
	public UserResponse adminLogin(@RequestBody User user) {
		
		 user =  adminService.adminLogin(user);

		UserResponse response = new UserResponse();
		if(user!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Login  Successfully");
			response.setUser(user);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Invalid Credentials");
		}
		return response;
	}//end of login()
}
