package com.cg.flightapp.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



import com.cg.flightapp.dao.FlightServiceImpl;
import com.cg.flightapp.model.Flight;
import com.cg.flightapp.model.Schedule;
import com.cg.flightapp.utility.FlightUtility;



public class AppForFlight {
	
	public static void main(String[] args) {
		
		EntityManager em=FlightUtility.getEntityManagerFactory().createEntityManager();
	Schedule schedule=new Schedule();
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter schedule id");
	int id=Integer.parseInt(scanner.nextLine());
	System.out.println("Enter schedule date in yyyy-MM-dd format");
	String scheduleDate=scanner.nextLine();
	
	
	/*LocalDate.parse(String string)--LocalDate
	LocalDate.parse(String date, DateTimeFormat)
	*/
	
	LocalDate schDate=LocalDate.parse(scheduleDate);
	System.out.println("Enter schedule time hh:mm:ss format");
	String scheduleTime=scanner.nextLine();
	
	LocalTime schTime=LocalTime.parse(scheduleTime);
	
	schedule.setScheduleId(id);
	schedule.setScheduleDate(schDate);
	schedule.setScheduleTime(schTime);
	
	
	Flight flight1=new Flight();
	flight1.setFlightNumber(567423);
	flight1.setFlightName("Air India");
	
	Flight flight2=new Flight();
	flight2.setFlightNumber(6785);
	flight2.setFlightName("Air India Express");
	
	
	schedule.addFlight(flight1);
	schedule.addFlight(flight2);
	em.getTransaction().begin();
	em.persist(schedule);
	
	FlightServiceImpl impl=new FlightServiceImpl();
	List<Flight> listOfFlights = impl.getAllFlightWithSchedule();
	for(Flight f:listOfFlights)
	{
		System.out.println(f.getFlightName() + " "+f.getFlightNumber()+ " "+f.getSchedule().getScheduleDate()+ " "+f.getSchedule().getScheduleTime());
		
	}
	
	System.out.println("search by Id");
	int flightId=Integer.parseInt(scanner.nextLine());
	Flight f2=impl.searchFlightById(flightId);
	System.out.println(f2.getFlightName() + " "+f2.getFlightNumber());
	
	
	Flight f4= impl.getFlight();
	System.out.println(f4.getFlightName() + " "+f4.getFlightNumber());
	
	em.getTransaction().commit();
	impl.removeFlight(5678);
	}
}
	
	
	
	
	
	
	
	
	


