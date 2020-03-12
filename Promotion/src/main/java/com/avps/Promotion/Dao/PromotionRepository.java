package com.avps.Promotion.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avps.Promotion.Entity.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

	// that's it ... no need to write any code LOL!
	
}
