package com.retail.models;

import javax.persistence.*;

@Entity
public class OrderReport {
	@Id
	@GeneratedValue(generator = "seq_order")
	@SequenceGenerator(name = "seq_order", initialValue = 1, allocationSize = 1)
	private int order_no;
	private String date;
	@ManyToOne
	private CustomerDetails customer;
	
	public OrderReport() {}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public CustomerDetails getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}
	
}
