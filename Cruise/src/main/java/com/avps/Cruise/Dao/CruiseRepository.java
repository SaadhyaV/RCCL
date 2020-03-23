package com.avps.Cruise.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.avps.Cruise.Entity.Cruise;

@Repository
public interface CruiseRepository extends MongoRepository<Cruise, String> {

	// @Query("{state:'Florida'}")
	public Cruise findByState(String state);

	// public Cruise findBy_id(Integer id);

	public Cruise findAllByStateAndDestination(String state, String destination);

	public Cruise findByCruiseDate(Date cruiseDate);

	public List<Cruise> findByStateAndDestinationAndCruiseDate(String state, String destination, Date cruiseDate);
}
