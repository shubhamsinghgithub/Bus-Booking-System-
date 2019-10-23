package com.capgemini.busschedulingspringrest.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.busschedulingspringrest.beans.Availability;
import com.capgemini.busschedulingspringrest.beans.Bus;
import com.capgemini.busschedulingspringrest.beans.Feedback;
import com.capgemini.busschedulingspringrest.beans.Ticket;
import com.capgemini.busschedulingspringrest.service.BusBookingService;
import com.capgemini.busschedulingspringrest.service.BusBookingServiceImpl;
import com.capgemini.busschedulingspringrest.service.OwnerService;
import com.capgemini.busschedulingspringrest.service.OwnerServiceImpl;
import com.capgemini.busschedulingspringrest.util.AvailabilityResponse;
import com.capgemini.busschedulingspringrest.util.BusResponse;
import com.capgemini.busschedulingspringrest.util.FeedbackResponse;
import com.capgemini.busschedulingspringrest.util.TicketResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class OwnerController {
	OwnerService ownerService=new OwnerServiceImpl();
	BusBookingService busBookingService=new BusBookingServiceImpl();
	
	@PostMapping("owner/addBus")
	public BusResponse addBus(@RequestBody Bus bus) {
		
		 bus= ownerService.addBus(bus);
		
		 BusResponse response = new BusResponse();
		if(bus!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Bus added Successfully");
			response.setBus(bus);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Add");
		}
		return response;
	}//end of addBus()
	
	@PutMapping("owner/updateBus")
	public BusResponse updateBus(@RequestBody Bus bus) {
		
		 BusResponse response = new BusResponse();
		if(ownerService.updateBus(bus)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Bus updated Successfully");
			response.setBus(bus);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to update");
		}
		return response;
	}//end of updateBus()
	
	@DeleteMapping("owner/deleteBus/{busId}")
	public BusResponse deleteBus(@PathVariable("busId") int busId) {
		
		BusResponse response = new BusResponse();
		if(ownerService.deleteBus(busId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Bus Deleted Successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Delete");
		}
		return response;
	}//end of deleteBus()
	
	
	//***************************************************
	@GetMapping(path="owner/getAllTicket", 
			produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public TicketResponse getAllTicket() {
		
		List<Ticket> ticketList = ownerService.getAllTicket();
		
		TicketResponse response = new TicketResponse();
		if(ticketList!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Ticket Fetched Successfully");
			response.setTicketList(ticketList);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to fetch the tickets");
		}
		return response;
	}//end of getAllTicket()
	
	@PostMapping("owner/setAvaliability")
	public AvailabilityResponse setAvailability(@RequestBody Availability availabilty) {
		
		AvailabilityResponse response = new AvailabilityResponse();
		
		if(ownerService.setBusAvailability(availabilty)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Bus Deleted Successfully");
			response.setAvailability(availabilty);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Delete");
		}
		return response;
	}//end of setAvailability()
	@GetMapping("owner/getFeedback")
	public FeedbackResponse getAllFeedback() {
		
		List<Feedback> feedList = busBookingService.viewFeedback();
		
		FeedbackResponse response = new FeedbackResponse();
		if(feedList!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Feedback Fetched  Successfully");
			response.setFeedList(feedList);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to fetch feedbacks");
		}
		return response;
	}// end of getAllFeedback()
}
