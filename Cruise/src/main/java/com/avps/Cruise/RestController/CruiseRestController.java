package com.avps.Cruise.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	// @GetMapping("/cruises/{state}")
	@RequestMapping(value = "/cruises/{state}", method = RequestMethod.GET)
	public Cruise findByState(@PathVariable String state) {
		return cruiseService.findByState(state);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/cruises/{state}/{destination}")
	public Cruise getAllCruise(@PathVariable String state, @PathVariable String destination) {
		return cruiseService.findAllByStateAndDestination(state, destination);
	}
	// @RequestMapping(method = RequestMethod.GET)
	// public List<Brand> getBrand(@RequestParam(value="name") String name) {

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/cruises/{startDate}", method = RequestMethod.GET)
	// @GetMapping("/cruises/{startDate}")
	public Cruise findByStartDate(@PathVariable String startDate) {

		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
		df.setTimeZone(tz);
		String nowAsISO = df.format(startDate);

		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(nowAsISO);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(nowAsISO + "\t" + date1);
		return cruiseService.findByStartDate(nowAsISO);
	}

	// add mapping for GET /cruises/{cruiseId}
	// @CrossOrigin(origins = "*", allowedHeaders = "*")
	// @GetMapping("/cruises/{cruiseId}")
	// public Cruise getCruise(@PathVariable Integer cruiseId) {
	// return cruiseService.findById(cruiseId);
	// }

	// add mapping for POST /cruises - add new cruises
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/setcruises", headers = "Accept=application/json")
	public Cruise addCruise(@Valid @RequestBody Cruise theCruise) {
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		theCruise.set_id(0);
		cruiseService.save(theCruise);
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
	// @CrossOrigin(origins = "*", allowedHeaders = "*")
	// @DeleteMapping("/deleteCruises/{cruiseId}")
	// public String deleteEmployee(@PathVariable Integer cruiseId) {
	// Cruise theCruise = cruiseService.findById(cruiseId);
	// // throw exception if null
	//
	// if (theCruise == null) {
	// throw new RuntimeException("Cruise Id is not found : " + cruiseId);
	// }
	// cruiseService.deleteById(cruiseId);
	// return "Deleted Cruise Id : " + cruiseId;
	// }

}
