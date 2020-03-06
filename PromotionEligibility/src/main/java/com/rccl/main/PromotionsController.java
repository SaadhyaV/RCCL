package com.rccl.main;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rccl.promotions.Promotions;

@Controller
public class PromotionsController {
	
	Promotions promotions = new Promotions();
	
	@RequestMapping(value="/sendData", method=RequestMethod.POST, headers="Accept=application/json")
	public Promotions setData(@RequestBody Promotions p) {
		promotions= p;
		
		promotions.setName(p.getName());
		promotions.setState(p.getState());
		promotions.setDiscountAmount(p.getDiscountAmount());
//		promotions.setStartDate(p.getStartDate());
//		promotions.setEndDate(p.getEndDate());
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
			System.out.println("done!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return promotions;
	}
	@ResponseBody
	@RequestMapping(value = "/getData", method = RequestMethod.GET, headers = "Accept=application/json")
	public Promotions driverName() {
		return promotions;
	}
	
}
