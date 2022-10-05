package com.retail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.retail.models.OrderReport;

public interface OrderRepository extends JpaRepository<OrderReport, Integer> {

	@Query("from OrderReport where customer_customer_no=:cno")
	OrderReport findByCustomerId(@Param("cno") int cid);

}
