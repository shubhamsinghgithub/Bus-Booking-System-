package com.capgemini.busschedulingspringrest.service;



import java.util.List;

import com.capgemini.busschedulingspringrest.beans.User;
import com.capgemini.busschedulingspringrest.dao.AdminDAO;
import com.capgemini.busschedulingspringrest.dao.AdminDAOImpl;
public class AdminServiceImpl implements AdminService{
	AdminDAO adminDAO=new AdminDAOImpl();

	@Override
	public User adminLogin(User user)  {
		return adminDAO.adminLogin(user);
	}
	@Override
	public Boolean registerOwner(User user)  {
		return adminDAO.registerOwner(user);
	}
	@Override
	public Boolean deleteCustomer(Integer userId)  {
		return adminDAO.deleteCustomer(userId);
	}
	@Override
	public Boolean deleteOwner(Integer ownerId)  {
		return adminDAO.deleteOwner(ownerId);
	}
	@Override
	public List<User> getAllOwner() {
		return adminDAO.getAllOwner();
	}
	@Override
	public List<User> getAllCustomer() {
		return adminDAO.getAllCustomer();
	}
}
