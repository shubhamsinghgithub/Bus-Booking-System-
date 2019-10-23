package com.capgemini.busschedulingspringrest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.busschedulingspringrest.beans.Feedback;
import com.capgemini.busschedulingspringrest.beans.Ticket;
import com.capgemini.busschedulingspringrest.beans.User;
import com.capgemini.busschedulingspringrest.dao.AdminDAOImpl;
import com.capgemini.busschedulingspringrest.dao.CustomerDAOImpl;
import com.capgemini.busschedulingspringrest.dao.OwnerDAOImpl;
import com.capgemini.busschedulingspringrest.service.AdminService;
import com.capgemini.busschedulingspringrest.service.AdminServiceImpl;
import com.capgemini.busschedulingspringrest.service.CustomerService;
import com.capgemini.busschedulingspringrest.service.CustomerServicesImpl;
import com.capgemini.busschedulingspringrest.util.FeedbackResponse;
import com.capgemini.busschedulingspringrest.util.TicketResponse;
import com.capgemini.busschedulingspringrest.util.UserResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CustomerController {
	CustomerService customerService=new CustomerServicesImpl();
	AdminService adminService=new AdminServiceImpl();	
	
	@PutMapping("enjoyer/update")
	public UserResponse updateCustomer(@RequestBody User user) {
		UserResponse response = new UserResponse();
		if(customerService.updateCustomer( user)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Profile Updated Successfully");
			response.setUser(user);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to update the profile");
		}
		return response;
	}//end of updateCustomer()
	
	
	
	@PostMapping("enjoyer/bookTicket")
	public TicketResponse bookTicket(@RequestBody Ticket ticket) {
		ticket= customerService.bookTicket(ticket);

		TicketResponse responce = new TicketResponse();
		if(ticket!=null) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Ticked Booked Successfully");
			responce.setTicket(ticket);
		}else {
			responce.setStatusCode(401);
			responce.setMessage("Failed");
			responce.setDescription("Unable to book the ticket");
		}
		return responce;
	}// end of bookTicket()
	
	@DeleteMapping("enjoyer/deleteTicket/{bookingId}")
	public TicketResponse cancelTicket(@PathVariable("bookingId") int bookingId) {
		
		TicketResponse response = new TicketResponse();
		if(customerService.cancelTicket(bookingId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Ticket canceled Successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Cancel the ticket");
		}
		return response;
	}//end of cancelTicket()
	
	@GetMapping("enjoyer/getTicket/{bookingId}")
	public TicketResponse getTicketInfo(@PathVariable("bookingId") int bookingId) {
		
		Ticket ticket = customerService.getTicketInfo(bookingId);
		
		TicketResponse response = new TicketResponse();
		if(ticket!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Ticket Fetched Successfully");
			response.setTicket(ticket);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to fetched the ticket");
		}
		return response;
	}//end of getTicketInfo()
	
	@PostMapping("enjoyer/giveFeedback")
	public FeedbackResponse giveFeedback(@RequestBody Feedback feedback) {
		
		FeedbackResponse response = new FeedbackResponse();
		if(customerService.writeFeedback(feedback)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Thank You!!!...");
			response.setFeedback(feedback);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Sorry we can't take your feedback now please give later");
		}
		return response;
	}// end of giveFeedback()
	
}
