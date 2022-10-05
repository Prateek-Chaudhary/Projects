package com.retail.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.models.Product;
import com.retail.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public void insertProduct(Product pr) {
		repo.save(pr);
	}

	@Override
	public List<Product> getProduct() {
		return repo.findAll();
	}

	@Override
	public Product getProduct(int product_id) {
		return repo.findById(product_id).orElse(null);
	}

	@Override
	public void deleteCompany(int product_id) {
		repo.deleteById(product_id);
	}

	@Override
	public void addProduct(Product p) {
		repo.save(p);
	}
}
