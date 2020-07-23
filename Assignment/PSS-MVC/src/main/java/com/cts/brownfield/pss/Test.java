package com.cts.brownfield.pss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.brownfield.pss.dao.AirlineDao;
import com.cts.brownfield.pss.dao.FlightInfo;
import com.cts.brownfield.pss.entity.AirlineInfo;

@SpringBootApplication
public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(Test.class, args);
		AirlineDao dao = ac.getBean(AirlineDao.class);

		AirlineInfo ai = dao.findByNameOfAirline("Air India");
		System.out.println(ai.getNameOfAirline());
		
		for(FlightInfo fi:ai.getInfo()) {
			System.out.println(fi.getFlightInfoid());
			System.out.println(fi.getFlightNumber());
			System.out.println(fi.getFlightType());
			System.out.println(fi.getNumberofSeats());
		}

	}

}
