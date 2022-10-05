package com.retail.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.retail.models.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {
	
	@Query("from CustomerOrder where customer_customer_no=:cno")
	List<CustomerOrder> findByCustomerId(@Param("cno") int customer_no);
}
