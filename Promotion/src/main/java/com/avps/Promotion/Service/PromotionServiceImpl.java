package com.avps.Promotion.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avps.Promotion.Dao.PromotionRepository;
import com.avps.Promotion.Entity.Promotion;

@Service
public class PromotionServiceImpl implements PromotionService {

	private PromotionRepository promotionRepository;
	
	@Autowired
	public PromotionServiceImpl(PromotionRepository thePromotionRepository) {
		promotionRepository = thePromotionRepository;
	}
	
	@Override
	public List<Promotion> findAll() {
		return promotionRepository.findAll();
	}

	@Override
	public Promotion findById(int theId) {
		Optional<Promotion> result = promotionRepository.findById(theId);
		
		Promotion thePromotion = null;
		
		if (result.isPresent()) {
			thePromotion = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return thePromotion;
	}

	@Override
	public Promotion save(Promotion thePromotion) {
		return promotionRepository.save(thePromotion);
	}

	@Override
	public void deleteById(int theId) {
		promotionRepository.deleteById(theId);
	}

}