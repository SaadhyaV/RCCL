package com.avps.Cruise.Entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cruises")
public class Cruise {
	@Id
	public Integer _id;
	
	private String shipName;
	private Date cruiseDate;
	private String destination;
	private String state;
	private String departurePort;
	private String cruiseName;
	
	public Cruise() {
		
	}

	public Cruise(Integer _id, String shipName, Date cruiseDate, String destination, String state,
			String departurePort, String cruiseName) {
		super();
		this._id = _id;
		this.shipName = shipName;
		this.cruiseDate = cruiseDate;
		this.destination = destination;
		this.state = state;
		this.departurePort = departurePort;
		this.cruiseName = cruiseName;
	}



	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public Date getCruiseDate() {
		return cruiseDate;
	}

	public void setCruiseDate(Date cruiseDate) {
		this.cruiseDate = cruiseDate;
	}

	public String getDeparturePort() {
		return departurePort;
	}

	public void setDeparturePort(String departurePort) {
		this.departurePort = departurePort;
	}


	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String theDestination) {
		destination = theDestination;
	}

	public String getState() {
		return state;
	}

	public void setState(String sstate) {
		state = sstate;
	}

	public String getCruiseName() {
		return cruiseName;
	}

	public void setCruiseName(String cruiseName) {
		this.cruiseName = cruiseName;
	}

	@Override
	public String toString() {
		return "Cruise [_id=" + _id + ", shipName=" + shipName + ", cruiseDate=" + cruiseDate + ", destination="
				+ destination + ", state= " + state + ",departurePort=" + departurePort + ", cruiseName=" + cruiseName
				+ "]";
	}

	
}
