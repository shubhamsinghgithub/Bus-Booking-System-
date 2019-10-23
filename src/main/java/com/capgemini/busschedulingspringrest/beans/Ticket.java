package com.capgemini.busschedulingspringrest.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
@Entity
@Table(name = "ticket_details")
@JsonRootName("ticket_details")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Ticket {
	@Id
	@Column(name = "booking_id")
	private Integer bookingId;
	@Column(name = "bus_id")
	private Integer busId;
	@Column(name = "customer_id")
	private Integer customerId;
	@Column(name = "journey_date")
	private Date journeyDate;
	@Column(name = "number_of_seats")
	private Integer numOfSeats;
	@Column(name = "booking_date_time")
	private Date bookingDateTime;

	
	public Integer getBookingId() {
		return bookingId;
	}


	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}


	public Integer getBusId() {
		return busId;
	}


	public void setBusId(Integer busId) {
		this.busId = busId;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public Date getJourneyDate() {
		return journeyDate;
	}


	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}


	public Integer getNumOfSeats() {
		return numOfSeats;
	}


	public void setNumOfSeats(Integer numOfSeats) {
		this.numOfSeats = numOfSeats;
	}


	public Date getBookingDateTime() {
		return bookingDateTime;
	}


	public void setBookingDateTime(Date bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}


	@Override
	public String toString() {
		return "Ticket [bookingId=" + bookingId + ", busId=" + busId + ", customerId=" + customerId + ", journeyDate="
				+ journeyDate + ", numOfSeats=" + numOfSeats + ", bookingDateTime=" + bookingDateTime + "]";
	}
	
}
