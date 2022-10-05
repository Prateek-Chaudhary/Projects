package com.retail.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.retail.models.Product;

@Service
public interface ProductService {

	void insertProduct(Product pr);

	List<Product> getProduct();

	Product getProduct(int product_id);

	void deleteCompany(int product_id);

	void addProduct(Product p);
	
}
