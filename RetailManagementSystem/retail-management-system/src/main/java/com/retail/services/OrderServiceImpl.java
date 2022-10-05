package com.retail.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.models.CustomerDetails;
import com.retail.models.CustomerOrder;
import com.retail.models.OrderReport;
import com.retail.repositories.CustomerDetailsRepository;
import com.retail.repositories.CustomerOrderRepository;
import com.retail.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orepo;
	@Autowired
	private CustomerDetailsRepository crepo;
	@Autowired
	private CustomerOrderRepository co_repo;
	
	@Override
	public void addCustomer(CustomerDetails cd) {
		crepo.save(cd);
	}

	@Override
	public void setCustomerOrder(CustomerOrder co) {
		co_repo.save(co);
	}

	@Override
	public void addOrderReport(OrderReport or) {
		orepo.save(or);
	}

	@Override
	public List<OrderReport> getOrderReport() {
		return orepo.findAll();
	}

	@Override
	public void deleteReport(int order_no) {
		orepo.deleteById(order_no);
	}

	@Override
	public OrderReport getOrder(int order_no) {
		return orepo.findById(order_no).orElse(null);
	}

	@Override
	public List<CustomerOrder> getCustomerOrderList(int customer_no) {
		return co_repo.findByCustomerId(customer_no);
	}

	@Override
	public OrderReport getOrderByCustomerId(int cid) {
		return orepo.findByCustomerId(cid);
	}
	
}
