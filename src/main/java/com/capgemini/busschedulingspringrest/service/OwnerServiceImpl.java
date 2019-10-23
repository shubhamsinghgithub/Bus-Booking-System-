package com.capgemini.busschedulingspringrest.service;

import java.util.List;

import com.capgemini.busschedulingspringrest.beans.Availability;
import com.capgemini.busschedulingspringrest.beans.Bus;
import com.capgemini.busschedulingspringrest.beans.Ticket;
import com.capgemini.busschedulingspringrest.dao.OwnerDAO;
import com.capgemini.busschedulingspringrest.dao.OwnerDAOImpl;



public class OwnerServiceImpl implements OwnerService{
	OwnerDAO ownerDAO=new OwnerDAOImpl();
	
	@Override
	public Bus addBus(Bus bus)  {
		return ownerDAO.addBus(bus);
	}
	@Override
	public Boolean updateBus(Bus bus)  {
		return ownerDAO.updateBus(bus);
	}
	@Override
	public Boolean deleteBus(Integer busId)  {
		return ownerDAO.deleteBus(busId);
	}
	@Override
	public List<Ticket> getAllTicket() {
		return ownerDAO.getAllTicket();
	}
	@Override
	public Boolean setBusAvailability(Availability availability)  {
		return ownerDAO.setBusAvailability(availability);
	}
}
