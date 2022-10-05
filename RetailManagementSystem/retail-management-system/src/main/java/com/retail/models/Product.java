package com.retail.models;

import javax.persistence.*;

@Entity
public class Product {
	@Id
	@GeneratedValue(generator = "seq_prod")
	@SequenceGenerator(name = "seq_prod", initialValue = 101, allocationSize = 1)
	private int product_id;
	private String product_name;
	@ManyToOne
	private ProductCompany product_company;
	private String product_type;
	private int price;

	public Product() {
	}

	public Product(String product_name, ProductCompany product_company, String product_type,
			int price) {
		super();
		this.product_name = product_name;
		this.product_company = product_company;
		this.product_type = product_type;
		this.price = price;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public ProductCompany getProduct_company() {
		return product_company;
	}

	public void setProduct_company(ProductCompany product_company) {
		this.product_company = product_company;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
