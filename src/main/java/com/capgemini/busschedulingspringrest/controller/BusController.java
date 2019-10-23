	package com.capgemini.busschedulingspringrest.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.busschedulingspringrest.beans.Availability;
import com.capgemini.busschedulingspringrest.beans.Bus;
import com.capgemini.busschedulingspringrest.beans.Feedback;
import com.capgemini.busschedulingspringrest.service.BusBookingService;
import com.capgemini.busschedulingspringrest.service.BusBookingServiceImpl;
import com.capgemini.busschedulingspringrest.service.CustomerService;
import com.capgemini.busschedulingspringrest.service.CustomerServicesImpl;
import com.capgemini.busschedulingspringrest.service.OwnerService;
import com.capgemini.busschedulingspringrest.service.OwnerServiceImpl;
import com.capgemini.busschedulingspringrest.util.AvailabilityResponse;
import com.capgemini.busschedulingspringrest.util.BusResponse;
import com.capgemini.busschedulingspringrest.util.FeedbackResponse;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BusController {
	private BusBookingService bookingService=new BusBookingServiceImpl();
	private OwnerService ownerService=new OwnerServiceImpl();
	private CustomerService customerService=new CustomerServicesImpl();
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor=new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	@GetMapping("owner/getAllBus")
	public BusResponse getAllBus() {
		List<Bus> busList = bookingService.showAllBuses();
		BusResponse response = new BusResponse();
		if(busList!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Bus Fetched  Successfully");
			response.setBusList(busList);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to fetch Bus");
		}
		return response;
	}// end of getAllBus()
	
	
	@GetMapping("enjoyer/checkAvailability/{startingPoint}/{endingPoint}/{availableDate}")
	public AvailabilityResponse checkAvailability(@PathVariable("startingPoint") String startingPoint, @PathVariable("endingPoint") String endingPoint, @PathVariable("availableDate") Date availableDate) {
		
		List<Availability> availList = customerService.checkAvailability(startingPoint, endingPoint, availableDate);
		
		AvailabilityResponse response = new AvailabilityResponse();
		if(availList!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Bus Availabilty Fetched  Successfully");
			response.setAvailList(availList);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to fetch Bus");
		}
		return response;
	}//end of checkAvailability()
	
	
}
