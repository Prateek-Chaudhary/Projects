package com.retail.models;

import javax.persistence.*;

@Entity
public class CustomerOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int co_id;
	@ManyToOne
	private CustomerDetails customer;
	@ManyToOne
	private Product product;
	private String quantity;
	private String price;
	private String amount;
	
	public CustomerOrder() {}

	public CustomerOrder(int co_id, CustomerDetails customer, Product product, String quantity, String price,
			String amount) {
		super();
		this.co_id = co_id;
		this.customer = customer;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
	}

	public int getCo_id() {
		return co_id;
	}

	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}

	public CustomerDetails getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
