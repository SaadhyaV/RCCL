package com.avps.Promotion.Service;

import java.util.List;

import com.avps.Promotion.Entity.Promotion;

public interface PromotionService {

	public List<Promotion> findAll();
	
	public Promotion findById(int theId);
	
	public Promotion save(Promotion thePromotion);
	
	public void deleteById(int theId);

	
	
}
