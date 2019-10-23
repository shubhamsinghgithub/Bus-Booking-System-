package com.capgemini.busschedulingspringrest.service;

import java.util.Date;
import java.util.List;

import com.capgemini.busschedulingspringrest.beans.Availability;
import com.capgemini.busschedulingspringrest.beans.Feedback;
import com.capgemini.busschedulingspringrest.beans.Ticket;
import com.capgemini.busschedulingspringrest.beans.User;



public interface CustomerService {

	public Boolean updateCustomer(User user) ;
	public Ticket bookTicket(Ticket ticket) ;
	public Boolean cancelTicket(Integer bookingId);
	public Ticket getTicketInfo(Integer bookingId);
	public List<Availability>checkAvailability(String source, String destination, Date date);
	public Boolean writeFeedback(Feedback feed);
}
