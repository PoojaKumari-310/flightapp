package com.cg.flightapp.utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FlightUtility {


	public static EntityManagerFactory getEntityManagerFactory()
	{
		return Persistence.createEntityManagerFactory("PU");
	}

}
