package com.capgemini.busschedulingspringrest.dao;

import java.util.List;

import com.capgemini.busschedulingspringrest.beans.User;

public interface AdminDAO {
	
	public List<User> getAllOwner();
	public List<User> getAllCustomer();
	public User adminLogin(User user) ;
	public Boolean registerOwner( User owner)  ;
	public Boolean deleteCustomer(Integer customerId)  ;
	public Boolean deleteOwner(Integer ownerId) ;
	
}
