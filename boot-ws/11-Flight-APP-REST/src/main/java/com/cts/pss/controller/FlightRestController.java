package com.cts.pss.controller;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pss.entity.Flight;
import com.cts.pss.service.FlightBookingServiceImpl;
import com.cts.pss.service.FlightSearchServiceImpl;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin
public class FlightRestController {

	@Autowired
	private FlightBookingServiceImpl fs;
	@Autowired
	private FlightSearchServiceImpl fss;

	@GetMapping
	public Stream<Flight> findFlights() {
		Stream<Flight> flights = fss.searchFlights(LocalDate.of(2020, 8, 21), "DELHI", "CHENNAI", 5);
		return flights;
	}

	@PostMapping
	public Flight f2(@RequestBody Flight flight) {

		fss.save(flight);

		return flight;
	}

	@PutMapping
	public Flight f3(@RequestBody Flight flight) {
		
		fss.save(flight);
		
		return flight;
	}

	@PatchMapping
	public String f4() {
		return "PATCH MAPPING";
	}

	@DeleteMapping
	public String f5() {
		return "DELETE MAPPING";
	}

}
