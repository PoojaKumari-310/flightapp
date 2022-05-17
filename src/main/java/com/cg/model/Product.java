package com.cg.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MyProducts")
public class Product {
	@Id
	private int id;
	private String name;
	private double price;
	/*
	 * lazy
	 * egar
	 * Order Product
	 * 1.customer want to get all data from order table and only required data from product table
	 * based on demand means based on the call of getter method
	 * 
	 * fetch=FetchType.LAZY
	 * fecth=FetchType.EGAR
	 */
	@ManyToMany(fetch=FetchType.EAGER,mappedBy = "products")
     private Set<Order> orders=new HashSet<Order>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}
