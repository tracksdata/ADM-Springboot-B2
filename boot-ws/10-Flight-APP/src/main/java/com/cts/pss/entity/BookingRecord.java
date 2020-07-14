package com.cts.pss.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class BookingRecord {
	
	@Id
	@GeneratedValue
	private int bookingId;
	private String origin;
	private String destination;
	private LocalDate flightDate;
	private LocalTime flightTime;
	private String status;


	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="booking_details",joinColumns = {@JoinColumn(name="bookingId")},inverseJoinColumns = {@JoinColumn(name="passengerId")})
	private List<Passenger> passengers=new ArrayList<>();


	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	public String getOrigin() {
		return origin;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public LocalDate getFlightDate() {
		return flightDate;
	}


	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}


	public LocalTime getFlightTime() {
		return flightTime;
	}


	public void setFlightTime(LocalTime flightTime) {
		this.flightTime = flightTime;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<Passenger> getPassengers() {
		return passengers;
	}


	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	
	

}
