package com.capgemini.busschedulingspringrest.dao;

import com.capgemini.busschedulingspringrest.beans.Feedback;
import com.capgemini.busschedulingspringrest.beans.Ticket;
import com.capgemini.busschedulingspringrest.beans.User;

public interface CustomerDAO {

	//user operations	
	public Boolean updateCustomer(User customer) ;
	public Ticket bookTicket(Ticket ticket) ;
	public Boolean cancelTicket(Integer bookingId);
	public Ticket getTicketInfo(Integer bookingId);
	public Boolean writeFeedback(Feedback feed);
}
