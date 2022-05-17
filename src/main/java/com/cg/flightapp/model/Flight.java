package com.cg.flightapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/*
 *  Flight==Flight_Details
 * Many Flight refer to Single object of schedule
 */

@Entity
@Table(name = "Flight_Details")
@NamedQuery(name = "findFlightDetails" , query = "select f from Flight f where f.flightNumber=:param1")
//@NamedQuery(name = "queryForUpdate", query = "update Flight f  set f.flightNumber=:par1 where f.flightNumber=:par2")
//@NamedNativeQuery(name="nativeQry1" , query = "select * from Flight_details")


/*
 * select * from flight;
 * Selct FlightNumber and other details from flight based on id
 * update flight set flightNumner=:par1 where flightId=:par2
 * kol-chennai 6:20
 * kol-delhi6:20
 * kol-pune6:20
 */

public class Flight {
	@Id
	private int flightNumber;
	private String flightName;
	@ManyToOne
	//scheduled_scheduled_id
	@JoinColumn(name="scheduleId")
	private Schedule schedule;
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	}

		
		
		
		
	
	
	
	


