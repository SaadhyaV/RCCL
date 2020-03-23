package com.avps.Promotion.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avps.Promotion.Entity.Promotion;
import com.avps.Promotion.Service.PromotionService;

@RestController
@RequestMapping("/api")
public class PromotionRestController {

	private PromotionService promotionService;

	@Autowired
	public PromotionRestController(PromotionService thePromotionService) {
		promotionService = thePromotionService;
	}

	
	// expose "/employees" and return list of employees
//	@CrossOrigin(origins = "http://localhost:9090")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value="/promotions", headers="Accept=application/json")
	public List<Promotion> findAll() {
		return promotionService.findAll();
	}

	// add mapping for GET /employees/{employeeId}

	@CrossOrigin(origins = "*", allowedHeaders="*")
	@GetMapping("/promotions/{promotionId}")
	public Promotion getEmployee(@PathVariable int promotionId) {

		Promotion thePromotion = promotionService.findById(promotionId);

		if (thePromotion == null) {
			throw new RuntimeException("Employee id not found - " + promotionId);
		}

		return thePromotion;
	}

	// add mapping for POST /employees - add new employee

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/setpromotions", headers = "Accept=application/json")
	public Promotion addEmployee(@RequestBody Promotion thePromotion) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		thePromotion.setId(0);

		promotionService.save(thePromotion);

		return thePromotion;
	}

	// add mapping for PUT /employees - update existing employee

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/updatepromotions")
	public Promotion updateEmployee(@RequestBody Promotion thePromotion) {
		  	thePromotion = promotionService.save(thePromotion);
		
		return thePromotion;
	}

	// add mapping for DELETE /employees/{employeeId} - delete employee

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/deletepromotions/{promotionId}")
	public String deleteEmployee(@PathVariable int promotionId) {

		Promotion tempEmployee = promotionService.findById(promotionId);

		// throw exception if null

		if (tempEmployee == null) {
			throw new RuntimeException("promotion id not found - " + promotionId);
		}

		promotionService.deleteById(promotionId);

		return "Deleted employee id - " + promotionId;
	}

}
