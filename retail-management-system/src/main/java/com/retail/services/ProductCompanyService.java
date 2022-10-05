package com.retail.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.retail.models.ProductCompany;

@Service
public interface ProductCompanyService {
	
	List<ProductCompany> getCompany();

	void addCompany(ProductCompany pc);

	List<ProductCompany> getProductCompany();

	ProductCompany getCompany(int company_id);

	void deleteCompany(int company_id);

}
