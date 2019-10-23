package com.capgemini.busschedulingspringrest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.busschedulingspringrest.beans.User;
import com.capgemini.busschedulingspringrest.service.AdminService;
import com.capgemini.busschedulingspringrest.service.AdminServiceImpl;
import com.capgemini.busschedulingspringrest.service.BusBookingService;
import com.capgemini.busschedulingspringrest.service.BusBookingServiceImpl;
import com.capgemini.busschedulingspringrest.util.UserResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AdminController {
	BusBookingService bookingService=new BusBookingServiceImpl();
	AdminService adminService=new AdminServiceImpl();
	
	@PostMapping("user/add")
	public UserResponse addOwner(@RequestBody User user) {
		UserResponse response = new UserResponse();
		if(adminService.registerOwner(user)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("User registerd Successfully");
			response.setUser(user);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Register");
		}
		return response;
	}//end of addUsers()
	
	@DeleteMapping("user/deleteOwner/{userId}")
	public UserResponse deleteOwner(@PathVariable("userId") int userId) {
		
		UserResponse response = new UserResponse();
		if(adminService.deleteOwner(userId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Owner Deleted Successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Delete");
		}
		return response;
	}//end of deleteOwner()
	@DeleteMapping("user/deleteUser/{userId}")
	public UserResponse deleteCustomer(@PathVariable("userId") int userId) {
		
		UserResponse response = new UserResponse();
		if(adminService.deleteCustomer(userId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Customer Deleted Successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Delete");
		}
		return response;
	}//end of deleteCustomer()
	
	
	//************************************************************//
	@GetMapping("user/getAllOwner")
	public UserResponse getAllOwner() {
	List<User> owners=adminService.getAllOwner();
		UserResponse response = new UserResponse();
		if(owners!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Customer Deleted Successfully");
			response.setUserList(owners);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Delete");
		}
		return response;
	}//end of getAllOwner()
	@GetMapping("user/getAllCustomer")
	public UserResponse getAllCustomer() {
	List<User> customers=adminService.getAllCustomer();
		UserResponse response = new UserResponse();
		if(customers!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Customer Deleted Successfully");
			response.setUserList(customers);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Delete");
		}
		return response;
	}//end of getAllCustomer()	
}
