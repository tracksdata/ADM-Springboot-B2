package com.cts.pss;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.pss.entity.Fare;
import com.cts.pss.entity.Flight;
import com.cts.pss.entity.Inventory;
import com.cts.pss.service.FlightSearchServiceImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(Application.class, args);

		FlightSearchServiceImpl fs = ac.getBean(FlightSearchServiceImpl.class);

		Flight f1 = new Flight("AI-100", LocalDate.of(2020, 8, 21), LocalTime.of(21, 45), "DELHI", "CHENNAI",
				new Fare(4500), new Inventory(150));
		Flight f2 = new Flight("AI-150", LocalDate.of(2020, 8, 21), LocalTime.of(11, 15), "DELHI", "MUMBAI",
				new Fare(3500), new Inventory(150));
		Flight f3 = new Flight("AI-200", LocalDate.of(2020, 8, 21), LocalTime.of(18, 45), "DELHI", "HYDERABAD",
				new Fare(1200), new Inventory(150));
		Flight f4 = new Flight("6E-799", LocalDate.of(2020, 8, 21), LocalTime.of(21, 45), "DELHI", "CHENNAI",
				new Fare(8754), new Inventory(150));
		Flight f5 = new Flight("6E-340", LocalDate.of(2020, 9, 21), LocalTime.of(21, 45), "DELHI", "CHENNAI",
				new Fare(9854), new Inventory(150));
		Flight f6 = new Flight("AI-800", LocalDate.of(2020, 8, 21), LocalTime.of(11, 30), "DELHI", "GOA",
				new Fare(1212), new Inventory(150));

		//fs.saveFlights(Arrays.asList(f1,f2,f3,f4,f5,f6));

		Stream<Flight> flights = fs.searchFlights(LocalDate.of(2020, 8, 21), "DELHI", "CHENNAI", 4);

		flights.forEach(flight -> {
			System.out.println(flight.getId());
			System.out.println(flight.getFlightNumber());
			System.out.println(flight.getOrigin());
			System.out.println(flight.getDestination());
			System.out.println(flight.getFlightDate());
			System.out.println(flight.getFlightTime());
			System.out.println("Price: " + flight.getFare().getAmount());
			System.out.println("Available: " + flight.getInventory().getCount());
			System.out.println("------------------------------------------------------");

		});

	}

}
