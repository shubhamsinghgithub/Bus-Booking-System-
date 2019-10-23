package com.capgemini.busschedulingspringrest.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.busschedulingspringrest.beans.Availability;
import com.capgemini.busschedulingspringrest.beans.Bus;
import com.capgemini.busschedulingspringrest.beans.Feedback;



public interface BusBookingDAO {

	public List<Availability>checkAvailability(String source, String destination, Date date);
	public List<Feedback> viewFeedback();
	public List<Bus> showAllBuses();



}