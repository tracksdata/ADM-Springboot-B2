package com.cts.brownfield.pss.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.brownfield.pss.entity.AirlineInfo;
import com.cts.brownfield.pss.entity.Flight;

public interface AirlineDao extends JpaRepository<AirlineInfo, Long> {
	
	
	AirlineInfo findByNameOfAirline(String nameOfAirline);

}
