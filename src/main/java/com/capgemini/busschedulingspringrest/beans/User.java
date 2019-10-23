package com.capgemini.busschedulingspringrest.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name = "individual_details")
@JsonRootName("individual_details")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class User {
	@Id
	@Column(name = "id")
	private Integer userId;
	@Column(name = "name")
	private String userName;
	@Column(name = "email")
	private String userEmail;
	@Column(name = "password")
	private String userPassword;
	@Column(name = "contact")
	private Long userMobile;
	@Column
	private String type;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Long getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(Long userMobile) {
		this.userMobile = userMobile;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Admin [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userMobile=" + userMobile + ", type=" + type + "]";
	}
	
	
}
