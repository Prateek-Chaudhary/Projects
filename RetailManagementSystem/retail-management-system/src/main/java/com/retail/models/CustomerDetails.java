package com.retail.models;

import javax.persistence.*;

@Entity
public class CustomerDetails {
	
	@Id
	@GeneratedValue(generator = "cust_seq")
	@SequenceGenerator(name = "cust_seq", initialValue = 111111, allocationSize = 1)
	private int customer_no;
	private String customer_name;
	private String customer_phone;
	private String customer_email;
	
	public CustomerDetails() {}

	public CustomerDetails(int customer_no, String customer_name, String customer_phone, String customer_email) {
		super();
		this.customer_no = customer_no;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
		this.customer_email = customer_email;
	}

	public int getCustomer_no() {
		return customer_no;
	}

	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	
}
