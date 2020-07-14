package com.cts.pss.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.pss.entity.Flight;
import com.cts.pss.service.FlightSearchServiceImpl;

@Controller
public class FlightController {
	
	@Autowired
	private FlightSearchServiceImpl fs;
	
	
	@RequestMapping("/book")
	public void bookFlight(@RequestParam("flightNumber") String flightNumber,
		@RequestParam("flightDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate flightDate,
		@RequestParam("flightTime")LocalTime flightTime,
		@RequestParam("origin")String origin,
		@RequestParam("destination")String destination
			) {
		
		
		
		System.out.println("Date: "+flightDate);
		
	}
	
	@RequestMapping("/findAll")
	public String listAll(Model data) {
		
		Stream<Flight> flights=fs.searchFlights(LocalDate.of(2020, 8, 21), "DELHI", "CHENNAI", 5);
		data.addAttribute("flights",(Iterable<Flight>) flights::iterator);
		
		return "flights";
	}

}
