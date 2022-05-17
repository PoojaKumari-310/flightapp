package com.cg.flightapp.service;

import java.util.List;

import com.cg.flightapp.model.Flight;
import com.cg.flightapp.model.Schedule;



public interface FlightService {
	public Flight searchFlightById(int id);
	public List<Flight> getAllFlightWithSchedule();
	//public Schedule removeFlight(int id);
	public void removeFlight(int id);
	public int updateFlight(int id);
	public void addFlight(Flight flight);

}
