package com.capgemini.busschedulingspringrest.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import com.capgemini.busschedulingspringrest.beans.Availability;
import com.capgemini.busschedulingspringrest.beans.Bus;
import com.capgemini.busschedulingspringrest.beans.Feedback;


public class BusBookingDAOImpl implements BusBookingDAO{

	private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
	
	static Date jdate;

	@Override
	public List<Availability> checkAvailability(String source, String destination, Date date) {
		List<Availability> availList=new ArrayList<Availability>();
		List<Availability> resultList=null;
		List<Bus> busList=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Bus> query=entityManager.createQuery("FROM Bus WHERE startingPoint=:sp and endingPoint=:ep", Bus.class);
			query.setParameter("sp", source);
			query.setParameter("ep", destination);
			TypedQuery<Availability> availQuery=entityManager.createQuery("FROM Availability WHERE busId=:bid and availableDate=:aDate", Availability.class);
			busList=query.getResultList();
			if (busList.size()>0) {
				for (Bus bus : busList) {
					availQuery.setParameter("bid", bus.getBusId());
					availQuery.setParameter("aDate", date);
					
					this.jdate=date;
					//getting result from taable
					resultList=availQuery.getResultList();

					//storing in array list
					availList.addAll(resultList);					
				}
			}
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return availList;
	}
	@Override
	public List<Feedback> viewFeedback() {
		List<Feedback> feedbacks=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Feedback> query=entityManager.createQuery("FROM Feedback", Feedback.class);
			feedbacks=query.getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return feedbacks;
	}
	@Override
	public List<Bus> showAllBuses() {	
		List<Bus> buses=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Bus> query=entityManager.createQuery("FROM Bus", Bus.class);
			buses=query.getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buses;
	}



}

