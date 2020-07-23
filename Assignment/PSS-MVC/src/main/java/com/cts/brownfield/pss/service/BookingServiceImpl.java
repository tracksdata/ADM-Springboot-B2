package com.cts.brownfield.pss.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.brownfield.pss.dao.BookingRecordDao;
import com.cts.brownfield.pss.dao.FlightRepository;
import com.cts.brownfield.pss.dao.PassengerDao;
import com.cts.brownfield.pss.entity.BookingRecord;
import com.cts.brownfield.pss.entity.Flight;
import com.cts.brownfield.pss.entity.Inventory;
import com.cts.brownfield.pss.entity.Passenger;

@Service
public class BookingServiceImpl {

	@Autowired
	private SearchFlightService searchFlightService;
	@Autowired
	private BookingRecordDao bookingRecordDao;
	@Autowired
	private PassengerDao passengerDao;
	
	@Autowired
	private FlightRepository flightRepository;
	
	
	
	
	
	public Passenger book(Passenger passenger,long id,int numberOfPassengers) {
		
		Flight flight=searchFlightService.findById(id);
		
		
		if(flight!=null) {
			BookingRecord bookingRecord = new BookingRecord(flight.getFlightNumber(), flight.getOrigin(),
					flight.getDestination(), flight.getFlightDate(), flight.getFlightTime(), LocalDateTime.now(),
					flight.getFares().getFare(), "Confirmed");
			bookingRecord.getPassengers().add(passenger);
			bookingRecord.setFare(flight.getFares().getFare()*numberOfPassengers);
			passenger.setBookingRecord(bookingRecord);
			passengerDao.save(passenger);
			//bookingRecordDao.save(bookingRecord);
			
			Inventory inv = flight.getInventory();
			inv.setCount(inv.getCount() - numberOfPassengers);
			flightRepository.save(flight);
		}
		
		
		
		
		return passenger;
	}

	public boolean book(SearchQuery searchQuery) {

		if (searchQuery.getNumberofPassengers() <= 4) {
			Flight flight = searchFlightService.findByFlightNumberAndFlightDateAndFlightTime(searchQuery);
			if (flight != null) {

				// logic for payment confirmation status. if status is true, then proceed for
				// booking
				BookingRecord bookingRecord = new BookingRecord(flight.getFlightNumber(), flight.getOrigin(),
						flight.getDestination(), flight.getFlightDate(), flight.getFlightTime(), LocalDateTime.now(),
						flight.getFares().getFare(), "Confirmed");
				searchFlightService.updateInventory(searchQuery.getFlightNumber(), searchQuery.getFlightDate(),
						searchQuery.getFlightTime(), searchQuery.getNumberofPassengers());
				Passenger p1 = new Passenger("Praveen", "Reddy", "Male", 1212121212L, "praveen@abc.com", bookingRecord);
				Passenger p2 = new Passenger("James", "Goedic", "Male", 3243654321L, "james@abc.com", bookingRecord);
				bookingRecord.getPassengers().add(p1);
				bookingRecord.getPassengers().add(p2);

				bookingRecordDao.save(bookingRecord);

				// passengerDao.saveAll(Arrays.asList(p1,p2));

				return true;

			} else {
				System.out.println("Flight Doeant have enought seats to book. Choose another flight");
				return false;
			}

		} else {
			System.out.println("Maximum number of passengers exceeded for booking. Maximum is 4");
			return false;
		}

	}

	
	
	
	public void updateInventory(String flightNumber, LocalDate flightDate, LocalTime flightTime, int new_inventory) {

		Flight flight = flightRepository.findByFlightNumberAndFlightDate(flightNumber, flightDate);
		if (flight != null) {
			Inventory inv = flight.getInventory();
			inv.setCount(inv.getCount() - new_inventory);
			flightRepository.save(flight);
		} else { // flight info is not available yet in search schema
			throw new RuntimeException("====> Failed");
		}
	}
	public boolean book(Flight flight) {

		BookingRecord bookingRecord = new BookingRecord(flight.getFlightNumber(), flight.getOrigin(),
				flight.getDestination(), flight.getFlightDate(), flight.getFlightTime(), LocalDateTime.now(),
				flight.getFares().getFare(), "Confirmed");

		Passenger p1 = new Passenger("Praveen", "Reddy", "Male", 1212121212, "praveen@abc.com", bookingRecord);

		return true;

	}

}
