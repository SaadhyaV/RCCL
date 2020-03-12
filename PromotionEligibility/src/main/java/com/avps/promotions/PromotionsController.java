package com.avps.promotions;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rccl.promotions.Promotions;

@RestController
public class PromotionsController {
	
	Promotions promotions = new Promotions();
	
	@RequestMapping(value="/sendData", method=RequestMethod.POST, headers="Accept=application/json")
	public Promotions setData(@RequestBody Promotions p) {
		promotions= p;
		
		promotions.setPromotionName(p.getPromotionName());
		promotions.setPromotionState(p.getPromotionState());
		promotions.setDiscountAmount(p.getDiscountAmount());
		promotions.setMilitaryManStatus(p.getMilitaryManStatus());
		
		Date startdate = promotions.getStartDate();
		Date enddate = promotions.getEndDate();
		startdate = new java.sql.Date(promotions.getStartDate().getTime());
		System.out.println("sql date convertor===" + startdate);

		enddate = new java.sql.Date(promotions.getEndDate().getTime());
		System.out.println("sql date convertor===" + enddate);
		promotions.setStartDate(startdate);
		promotions.setEndDate(enddate);

		try {
			System.out.println("Registration begin");
			PromotionsService.createPromotions(promotions);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return promotions;
	}
//	@ResponseBody
//	@RequestMapping(value = "/getData", method = RequestMethod.GET, headers = "Accept=application/json")
//	public Promotions driverName() {
//		return promotions;
//	}
	
	@ResponseBody
	@RequestMapping(value = "/getData", method = RequestMethod.GET)
	    public ResponseEntity<List<Promotions>> listAllUsers() {
		 try {
			List<Promotions> rowspromotion = PromotionsService.list(promotions);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		    return new ResponseEntity<List<Promotions>>(HttpStatus.OK);
	    }
	  
	
}
