package com.capgemini.busschedulingspringrest.dao;

import java.util.List;

import com.capgemini.busschedulingspringrest.beans.Availability;
import com.capgemini.busschedulingspringrest.beans.Bus;
import com.capgemini.busschedulingspringrest.beans.Ticket;




public interface OwnerDAO {
	//bus operations
	public Bus addBus(Bus bus) ;
	public Boolean updateBus(Bus bus) ;
	public Boolean deleteBus(Integer busId) ;
	public List<Ticket>getAllTicket();
	public Boolean setBusAvailability(Availability availability) ;
}
