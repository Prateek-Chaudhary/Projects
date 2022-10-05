package com.retail.models;

import javax.persistence.*;

@Entity
public class ProductCompany {
	
	@Id
	@GeneratedValue(generator = "seq_cmp")
	@SequenceGenerator(name = "seq_cmp", initialValue = 1001, allocationSize = 1)
	private int company_id;
	private String company_name;
	private String company_desc;
	
	public ProductCompany() {}

	public ProductCompany(String company_name, String company_desc) {
		super();
		this.company_name = company_name;
		this.company_desc = company_desc;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public int getCompany_id() {
		return company_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_desc() {
		return company_desc;
	}

	public void setCompany_desc(String company_desc) {
		this.company_desc = company_desc;
	}
	
}
