package com.cg.controller;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.model.Order;
import com.cg.model.Product;

public class AppForProduct {
	public static void main(String[] args) {
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("PU");
		EntityManager em=factory.createEntityManager();
		em.getTransaction().begin();
		Product p1=new Product();
		p1.setId(1);
		p1.setName("shinchan");
		p1.setPrice(85);
		
		Product p2=new Product();
		p2.setId(4);
		p2.setName("doremon");
		p2.setPrice(65);
		
		Product p3=new Product();
		p3.setId(7);
		p3.setName("pokemon");
		p3.setPrice(70);
		
		Order order1=new Order();
		order1.setId(45);
		order1.addProduct(p1);
		order1.addProduct(p3);
		order1.setPurchaseDate(new Date());
		
		Order order2=new Order();
		order2.setId(56);
		order2.setPurchaseDate(new Date());
		order2.addProduct(p1);
		order2.addProduct(p2);
		order2.addProduct(p3);
		
		em.persist(order1);
		em.persist(order2);
		em.getTransaction().commit();
		em.close();
		factory.close();
		

	}

}

		
		
		
		
