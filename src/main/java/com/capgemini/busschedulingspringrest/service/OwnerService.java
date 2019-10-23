package com.capgemini.busschedulingspringrest.service;

import java.util.List;

import com.capgemini.busschedulingspringrest.beans.Availability;
import com.capgemini.busschedulingspringrest.beans.Bus;
import com.capgemini.busschedulingspringrest.beans.Ticket;



public interface OwnerService {
	public Bus addBus(Bus bus);
	public Boolean updateBus(Bus bus) ;
	public Boolean deleteBus(Integer busId) ;
	public List<Ticket>getAllTicket();
	public Boolean setBusAvailability(Availability availability) ;
}
