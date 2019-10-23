package com.capgemini.busschedulingspringrest.service;

import java.util.Date;
import java.util.List;


import com.capgemini.busschedulingspringrest.beans.Availability;
import com.capgemini.busschedulingspringrest.beans.Feedback;
import com.capgemini.busschedulingspringrest.beans.Ticket;
import com.capgemini.busschedulingspringrest.beans.User;
import com.capgemini.busschedulingspringrest.dao.BusBookingDAO;
import com.capgemini.busschedulingspringrest.dao.BusBookingDAOImpl;
import com.capgemini.busschedulingspringrest.dao.CustomerDAO;
import com.capgemini.busschedulingspringrest.dao.CustomerDAOImpl;


public class CustomerServicesImpl implements CustomerService{
	CustomerDAO customerDAO=new CustomerDAOImpl();
	BusBookingDAO busBookingDAO=new BusBookingDAOImpl();

	@Override
	public Boolean updateCustomer(User user)  {
		return customerDAO.updateCustomer(user);
	}
	
	@Override
	public Ticket bookTicket(Ticket ticket)  {
		return customerDAO.bookTicket(ticket);
	}
	@Override
	public Boolean cancelTicket(Integer bookingId) {
		return customerDAO.cancelTicket(bookingId);
	}
	@Override
	public Ticket getTicketInfo(Integer bookingId) {
		return customerDAO.getTicketInfo(bookingId);
	}
	
	@Override
	public List<Availability> checkAvailability(String source, String destination,Date date) {
		return busBookingDAO.checkAvailability(source, destination, date);
	}
	@Override
	public Boolean writeFeedback(Feedback feed) {
		return customerDAO.writeFeedback(feed);
	}


}
