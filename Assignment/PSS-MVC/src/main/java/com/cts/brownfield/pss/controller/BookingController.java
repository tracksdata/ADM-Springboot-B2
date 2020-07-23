package com.cts.brownfield.pss.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cts.brownfield.pss.dao.BookingRecordDao;
import com.cts.brownfield.pss.dao.CheckInDao;
import com.cts.brownfield.pss.dao.PassengerDao;
import com.cts.brownfield.pss.dao.UserDao;
import com.cts.brownfield.pss.entity.BookingRecord;
import com.cts.brownfield.pss.entity.CheckIn;
import com.cts.brownfield.pss.entity.CoPassenger;
import com.cts.brownfield.pss.entity.Flight;
import com.cts.brownfield.pss.entity.Passenger;
import com.cts.brownfield.pss.entity.User;
import com.cts.brownfield.pss.service.BookingServiceImpl;
import com.cts.brownfield.pss.service.SearchFlightService;
import com.cts.brownfield.pss.service.SearchQuery;

@Controller
@SessionAttributes("user")
public class BookingController {

	@Autowired
	private SearchFlightService ss;
	@Autowired
	private UserDao userDao;

	@Autowired
	private PassengerDao passengerDao;

	@Autowired
	private BookingServiceImpl bs;
	@Autowired
	private BookingRecordDao br;
	
	@Autowired
	private CheckInDao checkinDao;

	@ModelAttribute("user")
	User getMoney() {
		return new User(); // or however you create a default
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/checkin")
	public String checkIn() {
		return "CheckIn";
	}

	@RequestMapping("/checkInprocess")
	public String checkInProcess(@RequestParam("booking_id") long booking_id) {
		
		
		BookingRecord bookingRecord =br.findByBookingId(booking_id);
		Passenger pass=passengerDao.findByBookingRecord(bookingRecord);
		
		
		
		if(pass!=null) {
			System.out.println("name: "+pass.getFirstName());
			System.out.println("Flight Number: "+pass.getBookingRecord().getFlightNumber());
			System.out.println("Assigned Seat No: A3 ");
		
			CheckIn c=new CheckIn();
			c.setBookingId(booking_id);
			c.setCheckinTime(LocalDateTime.now());
			c.setFlightNumber(pass.getBookingRecord().getFlightNumber());
			c.setPassenger(pass);
			c.setSeatNumber("F4");
			
			checkinDao.save(c);
			
		}

		
		
		
		return "index";
	}

	@RequestMapping("/listAll")
	public String listAllFlights(Model data) {

		String viewName;

		SearchQuery searchQuery = new SearchQuery("DELHI", "CHENNAI", LocalDate.of(2020, 8, 21), 3);

		Stream<Flight> flights = ss.search(searchQuery);
		// data.addAttribute("flights",flights);
		data.addAttribute("flights", (Iterable<Flight>) flights::iterator);
		if (flights.count() == 0) {
			data.addAttribute("errorMsg", "No Flights found with given criteria");
			viewName = "FlightSearch";
		} else {
			viewName = "flights";
		}

		// ss.findByFlightNumberAndFlightDate("", flightDate)
		// ss.findByFlightNumberAndFlightDateAndFlightTime(searchQuery)
		return viewName;
	}

	@RequestMapping("/bookFlight")
	public String bookFlight(Model data, @ModelAttribute("passenger") Passenger passenger, @RequestParam("id") long id,
			@RequestParam("numberofPassengers") int numberofPassengers) {
		System.out.println("<<<<< >>>>>  ==> " + passenger);

		System.out.println("===> " + id);

		Passenger bookedPassenger = bs.book(passenger, id, numberofPassengers);
		// Passenger p=new Passenger();

		// passengerDao.save(passenger);

		List<CoPassenger> coPassengers = passenger.getCoPassengers();

		if (coPassengers != null)
			for (CoPassenger cp : coPassengers) {
				// cp.setPassenger(passenger);
				System.out.println(cp);
			}

		data.addAttribute("passenger", bookedPassenger);
		data.addAttribute("flight", ss.findById(id));

		return "BookingConfirmation";
	}

	@RequestMapping("/book")
	public String book(Model data, @RequestParam("id") long id,
			@RequestParam("numberofPassengers") int numberofPassengers) {

		Flight flight = ss.findById(id);
		if (flight != null) {
			data.addAttribute("numberofPassengers", numberofPassengers);
			data.addAttribute("flight", flight);
			data.addAttribute("passenger", new Passenger());
			System.out.println("<<<<<<<<<<<<<<<< >>>>>>>>>>>>>>>>>>");
			System.out.println("Fare: " + flight.getFares().getFare());
			System.out.println("ID: " + id);
			System.out.println("Passengers: " + numberofPassengers);
		}

		return "BookFlight";
	}

	@RequestMapping("/search")
	public String loadSearchForm(Model data) {

		SearchQuery searchQuery = new SearchQuery("DELHI", "CHENNAI", LocalDate.of(2020, 8, 21), 3);
		data.addAttribute("searchQuery", searchQuery);
		data.addAttribute("errorMsg", "");

		return "SearchFlight";
	}

	@RequestMapping("/regForm")
	public String loaduserRegForm(@ModelAttribute User user) {

		return "UserRegister";
	}

	@RequestMapping("/registerUser")
	public String registerNewUser(@ModelAttribute User user, Model data) {
		String viewName = "index";
		System.out.println("======>");
		System.out.println(user.getUserName());
		System.out.println(user.getPassenger().getFirstName());

		System.out.println("<======");
		user.setLoginTime(LocalDateTime.now());
		User userObj = userDao.findById(user.getUserName()).orElse(null);
		if (userObj == null)
			userDao.save(user);
		else {
			viewName = "UserRegister";
			data.addAttribute("errorMsg", "User Id " + user.getUserName() + " Already taken");
			data.addAttribute("user", user);
			return viewName;
		}

		return viewName;
	}

	@RequestMapping("/loginForm")
	public String loginForm() {
		return "Login";
	}

	@RequestMapping("/validateUser")
	public String validateUser(@ModelAttribute User user, Model model) {

		User userObj = userDao.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		model.addAttribute("user", userObj);

		System.out.println(userObj);

		if (userObj == null) {
			model.addAttribute("errorMsg", "Invalid User Name/Password");
			return "Login";
		}
		model.addAttribute("searchQuery", new SearchQuery());
		return "UserHome";
	}

	@RequestMapping("/searchResults")
	public String listSearchedFlights(Model data, @RequestParam("origin") String origin,
			@RequestParam("destination") String destination,
			@RequestParam("flightDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate flighttDate,
			@RequestParam("numberofPassengers") int numberofPassengers) {
		String viewName = "ss";
		System.out.println("=========>>>> <<==========");
		System.out.println(origin);
		System.out.println(destination);
		System.out.println(flighttDate);
		System.out.println("=========>>>> <<==========");
		SearchQuery searchQuery = new SearchQuery(origin, destination, flighttDate, numberofPassengers);

		List<Flight> flights = ss.search(searchQuery).collect(Collectors.toList());

		// data.addAttribute("flights",flights);
		if (flights.size() == 0) {
			data.addAttribute("errorMsg", "No Flights found with given criteria");
			data.addAttribute("searchQuery", searchQuery);
			viewName = "SearchFlight";
			return viewName;
		} else {
			viewName = "flights";
			data.addAttribute("flights", flights);
			data.addAttribute("numberofPassengers", numberofPassengers);

		}

		// ss.findByFlightNumberAndFlightDate("", flightDate)
		// ss.findByFlightNumberAndFlightDateAndFlightTime(searchQuery)

		return viewName;
	}

	@RequestMapping("/logout")
	public String logoutUser() {
		return "index";
	}

}
