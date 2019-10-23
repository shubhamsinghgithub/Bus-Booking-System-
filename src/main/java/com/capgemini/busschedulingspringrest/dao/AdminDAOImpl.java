package com.capgemini.busschedulingspringrest.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import com.capgemini.busschedulingspringrest.beans.User;


public class AdminDAOImpl implements AdminDAO {
	static int id;
	private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
	@Override
	public User adminLogin(User user)  {
		User admin = null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			Query query=entityManager.createQuery("FROM User WHERE id=:id and password=:password", User.class);
			this.id=user.getUserId();
			query.setParameter("id", user.getUserId());
			query.setParameter("password",user.getUserPassword());
			admin=(User) query.getSingleResult();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return admin;		
	}
	@Override
	public Boolean registerOwner(User owner)   {	
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(owner);
			entityTransaction.commit();
			entityManager.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Boolean deleteCustomer(Integer customerId)  {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			User customer=entityManager.find(User.class, customerId);		
			if(customer.getType().equalsIgnoreCase("enjoyer")) {
				entityTransaction.begin();
				entityManager.remove(customer);
				entityTransaction.commit();
				entityManager.close();
				return true;
			}		
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	@Override
	public Boolean deleteOwner(Integer ownerId)  {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			User owner=entityManager.find(User.class, ownerId);
			if(owner.getType().equalsIgnoreCase("owner")) {
				entityTransaction.begin();
				entityManager.remove(owner);
				entityTransaction.commit();
				entityManager.close();
				return true;
			}
		} catch (Exception e) {
			return true;
		}
		return false;
	}
	@Override
	public List<User> getAllOwner() {
		List<User> owners=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			Query query=entityManager.createQuery("FROM User WHERE type='owner'", User.class);
			owners=(List<User>) query.getResultList();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return owners;
	}
	@Override
	public List<User> getAllCustomer() {
		List<User> customers=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			Query query=entityManager.createQuery("FROM User WHERE type='enjoyer'", User.class);
			customers=(List<User>) query.getResultList();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return customers;
	}	
}


