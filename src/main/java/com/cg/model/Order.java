package com.cg.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * Many order can have many products
 * Many products can have many orders
 */

@Entity
@Table(name="MyOrders")

public class Order {
	@Id
	private int id;
	 
	/*
	@Temporal annotation solves the one of the major issue of converting the date and time values from java object to compatible database type and retrieving back to the application. 
	
	*/
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;
	@ManyToMany(cascade = CascadeType.ALL)
	//@Column(name="abc"
	@JoinTable(name="Product_Order", joinColumns = { @JoinColumn(name="order_id")},
	inverseJoinColumns= {@JoinColumn(name="product_id")})
	private Set<Product> products=new HashSet();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public void addProduct(Product product)
	{
		this.getProducts().add(product);
	}
	
}
