package com.capgemini.busschedulingspringrest.service;

import java.util.List;

import com.capgemini.busschedulingspringrest.beans.User;

public interface AdminService {

	public List<User> getAllOwner();
	public List<User> getAllCustomer();
	public User adminLogin(User user)  ;
	public Boolean registerOwner( User user)  ;
	public Boolean deleteCustomer(Integer userId) ;
	public Boolean deleteOwner(Integer userId) ;
}
