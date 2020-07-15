package com.cts.pss.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.pss.entity.Flight;
import com.cts.pss.service.FlightBookingServiceImpl;
import com.cts.pss.service.FlightSearchServiceImpl;

@Controller
public class FlightController {
	
	@Autowired
	private FlightSearchServiceImpl fs;
	@Autowired
	private FlightBookingServiceImpl fb;
	
	
	
	
	@RequestMapping("/book1")
	public void book1(@ModelAttribute Flight flight) {
		System.out.println(flight);
		System.out.println("<<<<< >>>>");
		System.out.println(flight.getFlightNumber());
	}
	@RequestMapping("/book")
	public void bookFlight(@RequestParam("flightNumber") String flightNumber,
		@RequestParam("flightDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate flightDate,
		@RequestParam("flightTime")@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)LocalTime flightTime,
		@RequestParam("numberOfPassengers") int numberOfPassengers) {
		
		Flight flight=fs.searchFlight(flightNumber, flightDate, flightTime,numberOfPassengers);
		if(flight!=null) {
			fb.bookFlight(flight, numberOfPassengers);
		}
		
		
	}
	
	@RequestMapping("/findAll")
	public String listAll(Model data) {
		
		Stream<Flight> flights=fs.searchFlights(LocalDate.of(2020, 8, 21), "DELHI", "CHENNAI", 5);
		data.addAttribute("flights",(Iterable<Flight>) flights::iterator);
		data.addAttribute("numberOfPassengers",5);
		
		return "flights";
	}

}
