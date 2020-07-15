package com.cts.pss.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pss.dao.FlightDao;
import com.cts.pss.entity.Flight;

@Service
public class FlightSearchServiceImpl {

	@Autowired
	private FlightDao flightDao;

	public Flight searchFlight(String flightNumber, LocalDate flightDate, LocalTime flightTime,int numberOfPassengers) {

		Flight flight = flightDao.findByFlightNumberAndFlightDateAndFlightTime(flightNumber, flightDate, flightTime);

		if (flight != null && flight.getInventory().getCount()>=numberOfPassengers) {
			return flight;
		}

		return null;
	}

	public Stream<Flight> searchFlights(LocalDate flightDate, String origin, String destination,
			int numberOfPassengers) {

		List<Flight> flights = flightDao.findByFlightDateAndOriginAndDestination(flightDate, origin, destination);

		Stream<Flight> searchReasults = flights.stream()
				.filter(flight -> flight.getInventory().getCount() >= numberOfPassengers);

		return searchReasults;
	}

	public Flight save(Flight flight) {
		flightDao.save(flight);
		return flight;
	}

	public List<Flight> saveFlights(List<Flight> flights) {
		flightDao.saveAll(flights);
		return flights;
	}

}
