package com.retail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.retail.models.CustomerDetails;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Integer> {

}
