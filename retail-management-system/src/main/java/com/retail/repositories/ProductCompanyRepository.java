package com.retail.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.retail.models.ProductCompany;

public interface ProductCompanyRepository extends JpaRepository<ProductCompany, Integer> {
	
}
