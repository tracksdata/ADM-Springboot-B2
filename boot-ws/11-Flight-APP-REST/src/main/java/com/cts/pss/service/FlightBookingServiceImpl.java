package com.cts.pss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pss.dao.FlightDao;
import com.cts.pss.entity.Flight;

@Service
public class FlightBookingServiceImpl {
	
	@Autowired
	private FlightDao flightDao;
	
	public boolean bookFlight(Flight flight,int numberOfPassengers) {
		
		if(numberOfPassengers<=9) {
			
			
			
			
		}else {
			System.out.println("Maximum number of passengers exceeded. Maximum is 9");
		}
		
		return false;
	}
	
	
	public void updateInventory(Flight flight,int new_inventory) {
		
		//flightDao.findById(flight.getId()).orElse(null);
		int count=flight.getInventory().getCount();
		flight.getInventory().setCount(count-new_inventory);
		flightDao.save(flight);
	}
	

}
