package com.avps.Cruise.RestController;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.avps.Cruise.Entity.Cruise;
import com.avps.Cruise.Service.CruiseServiceImpl;

@RestController
@RequestMapping("/api")
public class CruiseRestController {

	private CruiseServiceImpl cruiseService;

	@Autowired
	public CruiseRestController(CruiseServiceImpl theCruiseService) {
		cruiseService = theCruiseService;
	}

	
	// expose "/cruises" and return list of cruises
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/cruises", headers = "Accept=application/json")
	public List<Cruise> findAll(){
		return cruiseService.findAll();
	}


	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/cruisesState/{state}")
	// @RequestMapping(value = "/cruises/{state}", method = RequestMethod.GET)
	public Cruise findByState(@PathVariable String state) {
		System.out.println(state);
		return cruiseService.findByState(state);
	}


	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/cruises/{state}/{destination}")
	public Cruise getAllCruise(@PathVariable String state, @PathVariable String destination) {
		return cruiseService.findAllByStateAndDestination(state, destination);
	}

	
	
	
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/cruisesDate/{cruiseDate}", method = RequestMethod.GET)
	public Cruise findByCruiseDate(@PathVariable Date cruiseDate) {

		System.out.println("start Date: " + cruiseDate);
		Cruise sd = cruiseService.findByStartDate(cruiseDate);
		System.out.println(sd);
		return sd;
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	// @GetMapping("cruisesAll/{state}/{destination}/{cruiseDate}")
	@RequestMapping(value = "cruisesAll/{state}/{destination}/{cruiseDate}", method = RequestMethod.GET)
	public List<Cruise> getCruiseByAll(@PathVariable String state, @PathVariable String destination,
			@PathVariable Date cruiseDate) {
		System.out.println("cruise date: " + cruiseDate);
		return cruiseService.findAllBySDC(state, destination, cruiseDate);
	}
	// add mapping for GET /cruises/{cruiseId}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/cruisesId/{cruiseId}")
	public Cruise getCruise(@PathVariable Integer cruiseId) {
		return cruiseService.findById(cruiseId);
	}

	// add mapping for POST /cruises - add new cruises
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/setcruises", headers = "Accept=application/json")
	public Cruise addCruise(@Valid @RequestBody Cruise theCruise) {
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		theCruise.set_id(0);
		cruiseService.save(theCruise);
		System.out.println(theCruise);
		return theCruise;
	}


	// add mapping for PUT /employees - update existing employee
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/updatecruises")
	public Cruise updateCruise(@RequestBody Cruise theCruise) {
		theCruise = cruiseService.save(theCruise);
		return theCruise;
	}


	// add mapping for DELETE /employees/{employeeId} - delete employee
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/deleteCruises/{cruiseId}")
	public String deleteEmployee(@PathVariable Integer cruiseId) {
		Cruise theCruise = cruiseService.findById(cruiseId);
		// throw exception if null

		if (theCruise == null) {
			throw new RuntimeException("Cruise Id is not found : " + cruiseId);
		}
		cruiseService.deleteById(cruiseId);
		return "Deleted Cruise Id : " + cruiseId;
	}

}
