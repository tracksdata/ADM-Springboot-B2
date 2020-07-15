package com.cts.pss.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Flight {

	@Id
	@GeneratedValue
	private int id;
	private String flightNumber;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate flightDate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime flightTime;
	private String origin;
	private String destination;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fareId")
	private Fare fare;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "inventoryId")
	private Inventory inventory;

	public Fare getFare() {
		return fare;
	}

	public void setFare(Fare fare) {
		this.fare = fare;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public Flight(String flightNumber, LocalDate flightDate, LocalTime flightTime, String origin, String destination,
			Fare fare, Inventory inventory) {

		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.origin = origin;
		this.destination = destination;
		this.fare = fare;
		this.inventory = inventory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
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

}
