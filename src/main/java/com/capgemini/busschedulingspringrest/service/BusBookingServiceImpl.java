package com.capgemini.busschedulingspringrest.service;

import java.util.Date;
import java.util.List;


import com.capgemini.busschedulingspringrest.beans.Availability;
import com.capgemini.busschedulingspringrest.beans.Bus;
import com.capgemini.busschedulingspringrest.beans.Feedback;
import com.capgemini.busschedulingspringrest.dao.BusBookingDAO;
import com.capgemini.busschedulingspringrest.dao.BusBookingDAOImpl;


public class BusBookingServiceImpl implements BusBookingService {
	BusBookingDAO busBookingDAO=new BusBookingDAOImpl();

	

	@Override
	public List<Availability> checkAvailability(String source, String destination, Date date) {
		return busBookingDAO.checkAvailability(source, destination, date);
	}

	@Override
	public List<Feedback> viewFeedback() {
		return busBookingDAO.viewFeedback();
	}

	@Override
	public List<Bus> showAllBuses() {
		return busBookingDAO.showAllBuses();
	}
}