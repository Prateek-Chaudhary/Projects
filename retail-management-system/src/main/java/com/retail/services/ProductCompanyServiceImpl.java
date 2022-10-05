package com.retail.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.models.ProductCompany;
import com.retail.repositories.ProductCompanyRepository;

@Service
public class ProductCompanyServiceImpl implements ProductCompanyService {
	
	@Autowired
	private ProductCompanyRepository repo;

	@Override
	public void addCompany(ProductCompany pc) {
		repo.save(pc);
	}
	
	@Override
	public List<ProductCompany> getCompany() {
		return repo.findAll();
	}

	@Override
	public List<ProductCompany> getProductCompany() {
		return repo.findAll();
	}

	@Override
	public ProductCompany getCompany(int company_id) {
		return repo.findById(company_id).orElse(null);
	}

	@Override
	public void deleteCompany(int company_id) {
		repo.deleteById(company_id);
	}
}