package com.avps.Cruise.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Cruise findByState(String state) {
		return cruiseRepository.findByState(state);
	}


	public Cruise findAllByStateAndDestination(String state, String destination) {
		return cruiseRepository.findAllByStateAndDestination(state, destination);
	}

	public Cruise findByStartDate(String startDate) {
		return cruiseRepository.findByStartDate(startDate);
	}

	// public Cruise findById(@PathVariable("id") Integer theId) {
	// return cruiseRepository.findBy_id(theId);
	// }
	
	public Cruise save(Cruise theCruise) {
		return cruiseRepository.save(theCruise);
	}

	// public void deleteById(@PathVariable Integer theId) {
	// cruiseRepository.delete(cruiseRepository.findBy_id(theId));
	// }
	
}