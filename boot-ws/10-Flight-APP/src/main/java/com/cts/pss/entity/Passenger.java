package com.cts.pss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="passenger")
@SecondaryTable(name = "communications")
public class Passenger {

	@Id
	@GeneratedValue
	private int passengerId;
	private String firstName;
	private String lastNamew;
	private String gender;
	@Column(table = "communications")
	private long mobileNumber;
	@Column(table = "communications")
	private String emailAddress;
	@Column(table = "communications")
	private String address;

	@ManyToOne
	@JoinColumn(name = "bookingId")
	private BookingRecord bookingRecord;

	public int getPassengerId() {
		return passengerId;
	}
	
	

	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNamew() {
		return lastNamew;
	}

	public void setLastNamew(String lastNamew) {
		this.lastNamew = lastNamew;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public BookingRecord getBookingRecord() {
		return bookingRecord;
	}

	public void setBookingRecord(BookingRecord bookingRecord) {
		this.bookingRecord = bookingRecord;
	}

}
