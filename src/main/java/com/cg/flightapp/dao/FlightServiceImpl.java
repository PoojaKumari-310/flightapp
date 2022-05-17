package com.cg.flightapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.flightapp.model.Flight;
import com.cg.flightapp.model.Schedule;
import com.cg.flightapp.service.FlightService;
import com.cg.flightapp.utility.FlightUtility;


public class FlightServiceImpl implements FlightService {
	
	public Flight searchFlightById(int id) {
		
		EntityManager em=FlightUtility.getEntityManagerFactory().createEntityManager();
		if(em!=null)
		{
			/*
			 * native query-sql--incase of native query it is going to map with table name and column name of database
		 * 
		 * jpql query--it is going to map with class name and attribute name of the classess which are annotated with @Entity annotation
			 */
			//Query--TypedQuery and NamedQury
			//select flight.flightNumber from flight_details flight left join Schedule_details s ON flight.scheduleId=s.scheduleId where flight.flightnumber=1
			//em.cr

			//JPQL is going with the entities and attributes
			//select f.flightNumber, f.flightType, s.scheduleDate, s.schedulerTime from Flight f inner join Schedule s ON f.schedule=s.scheduleId where condition
			//order by a 
			String qStr = "SELECT flight FROM Flight flight left join Schedule s ON s.scheduleId=flight.schedule WHERE flight.flightNumber=:p1";
			TypedQuery<Flight> query = em.createQuery(qStr,Flight.class);
			query.setParameter("p1", id);
			
			List<Flight> flightList = query.getResultList();
			return flightList.get(0);
		}
		em.close();
		return null;
		
	}
	
	public List<Flight> getAllFlightWithSchedule() {
		EntityManager em=FlightUtility.getEntityManagerFactory().createEntityManager();
		if(em!=null)
		{
			List<Flight> list=new ArrayList<Flight>();
			Query query=em.createQuery("select s from Schedule s");
			
			List<Schedule> listOfSchedule=(List<Schedule>)query.getResultList();
			for(Schedule s: listOfSchedule)
			{
				Set<Flight> flight=s.getFlights();
				for(Flight f: flight)
				{
					list.add(f);
				}
			}
			return list;
		}
		em.close();
		return null;
	}
	
	public void removeFlight(int id) {
		EntityManager em=FlightUtility.getEntityManagerFactory().createEntityManager();
		
		/*String qStr = "SELECT s FROM Flight flight inner join Schedule s ON s.scheduleId=flight.schedule WHERE s.scheduleId=:p1";
	     TypedQuery<Schedule> query = em.createQuery(qStr, Schedule.class);
	     query.setParameter("p1", id);
	     
	     List<Schedule> scheduleList = query.getResultList();
	     em.remove(scheduleList.get(0));
	     return scheduleList.get(0);*/
		
		em.getTransaction().begin();
		
		//delete from Schedule_details where s.sid=:si
		String qStr="delete from Schedule s where s.scheduleId=:sId";
		Query query = em.createQuery(qStr);
		query.setParameter("sId", id);
		int rowsDeleted = query.executeUpdate();
		System.out.println("entities deleted: " + rowsDeleted);
		em.getTransaction().commit();
		em.close();
	}
	
	public int updateFlight(int id) {
		//String qStr="update Schedule set s.s where s.scheduleId=:sId";
		return 0;
	}
	
	public Flight getFlight()
	{
		EntityManager em=FlightUtility.getEntityManagerFactory().createEntityManager();
		Query namedQuery = em.createNamedQuery("findFlightDetails");
		namedQuery.setParameter("param1",1234);
		
		return (Flight) namedQuery.getSingleResult();
	}

	public void addFlight(Flight flight) {
		// TODO Auto-generated method stub
		
	}

	
}
		
	     
	     
	     
	
	
		
	
	


