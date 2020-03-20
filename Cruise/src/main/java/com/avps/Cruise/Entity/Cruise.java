package com.avps.Cruise.Entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cruises")
public class Cruise {
	@Id
	public Integer _id;
	
	private String shipName;
	private Date startDate;
	private Date endDate;
	private String destination;
	private String state;
	private String departurePort;
	
	public Cruise() {
		
	}


	public Cruise(Integer _id, String shipName, Date startDate, Date endDate, String destination, String state,
			String departurePort) {
		super();
		this._id = _id;
		this.shipName = shipName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.destination = destination;
		this.state = state;
		this.departurePort = departurePort;
	}


	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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


	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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

	@Override
	public String toString() {
		return "Cruise [_id=" + _id + ", shipName=" + shipName + ", startDate=" + startDate + ",endDate=" + endDate
				+ ", destination=" + destination + ", state= " + state + ",departurePort=" + departurePort + "]";
	}

	
}
