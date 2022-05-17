package com.cg.flightapp.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Schedule_Flight")
public class Schedule {
	/*
	 * 9:00AM
	 * flight
	 */
	
	@Id
	private int scheduleId;
	private LocalDate scheduleDate;
	private LocalTime scheduleTime;
	
	@OneToMany(mappedBy = "schedule",cascade = CascadeType.ALL)
	private Set<Flight> flights=new HashSet<Flight>();

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public LocalDate getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(LocalDate scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public LocalTime getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(LocalTime scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}
	public void addFlight(Flight flight)
	{
		//flight.setSchedule(this);
		this.getFlights().add(flight);
	}
	
	
	

}
