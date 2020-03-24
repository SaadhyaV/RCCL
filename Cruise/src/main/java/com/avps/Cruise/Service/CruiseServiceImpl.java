package com.avps.Cruise.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.avps.Cruise.Dao.CruiseRepository;
import com.avps.Cruise.Entity.Cruise;

@Service
public class CruiseServiceImpl {

	private CruiseRepository cruiseRepository;
	
	@Autowired
	public CruiseServiceImpl(CruiseRepository theCruiseRepository) {
		cruiseRepository = theCruiseRepository;
	}

	public List<Cruise> findAll() {
		return cruiseRepository.findAll();
	}

	public Cruise findByState(@PathVariable("state") String state) {
		return cruiseRepository.findByState(state);
	}


	public Cruise findAllByStateAndDestination(String state, String destination) {
		return cruiseRepository.findAllByStateAndDestination(state, destination);
	}

	public Cruise findByStartDate(Date cruiseDate) {
		return cruiseRepository.findByCruiseDate(cruiseDate);
	}

	public List<Cruise> findAllBySDC(String state, String destination, Date cruiseDate) {
		return cruiseRepository.findByStateAndDestinationAndCruiseDate(state, destination, cruiseDate);
	}

	public Cruise findById(@PathVariable("id") Integer theId) {
		return cruiseRepository.findBy_id(theId);
	}
	
	public Cruise save(Cruise theCruise) {
		return cruiseRepository.save(theCruise);
	}

	public void deleteById(@PathVariable Integer theId) {
		cruiseRepository.delete(cruiseRepository.findBy_id(theId));
	}
	
}