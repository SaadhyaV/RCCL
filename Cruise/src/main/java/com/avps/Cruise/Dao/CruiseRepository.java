package com.avps.Cruise.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.avps.Cruise.Entity.Cruise;

@Repository
public interface CruiseRepository extends MongoRepository<Cruise, String> {

	public Cruise findByState(String state);

	// public Cruise findBy_id(Integer id);

	public Cruise findAllByStateAndDestination(String state, String destination);

	public Cruise findByStartDate(String startDate);
}
